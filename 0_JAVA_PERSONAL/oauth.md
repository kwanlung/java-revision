# OAuth and JWT Token Flow in AmOnline Lite Project

The AmOnline Lite project implements a comprehensive OAuth 2.0 authentication system using JWT (JSON Web Tokens). Here's a detailed end-to-end explanation of how it works:

## 1. JWT Implementation Components

### Key Management
- JwtTokenKeystoreUtil loads RSA key pairs from a Java KeyStore file for token signing
- Uses configurable keystore paths, aliases, and passwords (with defaults if not specified)
- Provides methods to access RSA public and private keys

### Token Generation
- JwtTokenUtil class handles token creation and verification
- Supports different token types:
    - Client access/refresh tokens
    - Backoffice access/refresh tokens
    - API tokens
    - Pre-auth tokens
    - Init tokens

## 2. Token Types and Lifecycles

- *Client Tokens*: User authentication tokens with configurable expiration
- *Backoffice Tokens*: Admin authentication tokens with configurable expiration
- *API Tokens*: Short-lived (30 minutes) tokens for API access
- *Pre-Auth Tokens*: 30-minute tokens for pre-authentication steps
- *Init Tokens*: 2-hour tokens for initialization processes

## 3. Authentication Flow

1. *Token Request*:
    - Client sends credentials to appropriate endpoint in OauthTokenController
    - Different endpoints handle various token types (client, backoffice, API, pre-auth)

2. *Token Generation*:
    - Controller delegates to appropriate process class (e.g., ProcessGenerateClientToken)
    - Process class uses JwtTokenUtil to create signed JWT tokens
    - Tokens include claims like username, session ID, and token ID

3. *Token Storage*:
    - Tokens are stored in MongoDB via OauthTokenRepository
    - OAuthTokenService provides methods to find, save, and delete tokens

4. *Token Verification*:
    - JwtTokenUtil verifies token signatures and extracts claims
    - TokenInformation inner class provides access to token claims

5. *Token Refresh*:
    - Refresh tokens allow getting new access tokens without re-authentication
    - isClientRefreshToken and isBackofficeRefreshToken methods validate refresh tokens

## 4. Grant Types

The HelperGrantType class defines custom grant types:
- AMBANK_GRANT_TYPE: Standard authentication
- AMBANK_REFRESH_GRANT_TYPE: Refresh token flow
- AMBANK_API: API authentication

## 5. Security Considerations

- RSA-256 algorithm for token signing (asymmetric cryptography)
- Token expiration managed per token type
- Claims validation for username, session ID, and token ID

The system follows OAuth 2.0 principles with JWT as the token format, providing a secure and flexible authentication framework for various client types accessing the AmBank Online Lite services.


---

# JWT Token Generation in AmOnline Lite Project

The JWT token generation in the AmOnline Lite project follows a thorough implementation of cryptographic security practices. Here's a technical explanation of the end-to-end process:

## 1. Key Management

The token generation starts with proper key management:

java
JwtTokenKeystoreUtil keystoreUtil = new JwtTokenKeystoreUtil(keystorePath, alias, password);


- The system loads an RSA key pair from a Java KeyStore file (JKS)
- Uses a configurable path, alias and password (with defaults as fallback)
- Extracts both private and public RSA keys for cryptographic operations

## 2. Algorithm Preparation

java
Algorithm algorithm = Algorithm.RSA256(
keystoreUtil.generateRsa().toRSAPublicKey(),
keystoreUtil.generateRsa().toRSAPrivateKey()
);


- The system uses the RSA-256 algorithm (asymmetric cryptography)
- The private key is used for signing tokens
- The public key is used for token verification

## 3. JWT Token Creation Process

java
String token = JWT.create()
.withIssuer(TOKEN_VALUE_ISSUER)
.withSubject(subject)
.withIssuedAt(now)
.withExpiresAt(validity)
// Add claims
.withClaim("username", username)
.withClaim("sessionId", sessionId)
.withClaim("tokenId", tokenId)
.sign(algorithm);


- Creates a JWT builder with common fields (issuer, subject, dates)
- Adds specific claims based on token type
- Signs the token using the RSA private key

## 4. Token Structure

Each generated JWT token consists of:

- *Header*: Contains algorithm type (RS256) and token type (JWT)
- *Payload*: Contains claims like:
    - iss: Issuer ("AmBank - AmOnline-Lite")
    - sub: Subject (token type identifier)
    - iat: Issued timestamp
    - exp: Expiration timestamp
    - Custom claims: username, sessionId, tokenId
- *Signature*: Created by signing header+payload with the RSA private key

## 5. Token Storage

java
OauthTokenDO tokenDO = new OauthTokenDO();
tokenDO.setAccessTokenId(token.getAccessToken());
tokenDO.setRefreshTokenId(token.getRefreshToken());
// Set other fields
oAuthTokenService.save(tokenDO);


- The generated tokens are persisted in MongoDB
- This allows for token revocation and auditing

## 6. Token Verification

java
DecodedJWT decodedJWT = JWT.require(algorithm)
.build()
.verify(token);


- Token signature is verified using the public key
- Claims are extracted and validated
- Expiration is checked automatically

## 7. Refresh Token Flow

When a client needs to refresh their token:

1. Client submits a refresh token to /oauth2/client/refresh-token endpoint
2. The system verifies it's a valid refresh token using isClientRefreshToken()
3. The token's claims are validated using getTokenInformation()
4. A new access token (and optionally a new refresh token) is generated
5. The new tokens are stored and the response is sent to the client

This implementation ensures proper security measures through asymmetric cryptography, token expiration, and secure storage practices for authentication in the AmBank Online Lite application.

---

# JWT Refresh Token Implementation in AmOnline Lite Project

To implement token refresh functionality, you need to allow clients to exchange a valid refresh token for a new access token. Here's how it works in the AmOnline Lite project:

### Key Components
1. *Refresh Token Endpoint*: The OauthTokenController provides endpoints for refreshing tokens.
2. *Token Validation*: The refresh token is validated to ensure it is still valid and belongs to the user.
3. *Token Generation*: A new access token (and optionally a new refresh token) is generated.
4. *Token Storage*: The new tokens are stored in the database.

### Implementation Steps
1. *Controller Method*:
    - The customerRefreshToken method in OauthTokenController handles the refresh token request.
    - It accepts a request body containing the refresh token, validates it, and generates new tokens.

2. *Token Validation*:
    - The generateClientTokenRefresh method in ProcessGenerateClientToken validates the refresh token using JwtTokenUtil.

3. *Token Generation*:
    - A new access token is generated using the generateClientToken method in JwtTokenUtil.

4. *Response*:
    - The new tokens are returned in the response body.

### Example Code
Here’s the relevant part of the customerRefreshToken method in OauthTokenController:

```java
@PostMapping("/oauth2/client/refresh-token")
public ResponseEntity<OauthTokenClientRefreshTokenRespVM> customerRefreshToken(
@RequestBody OauthTokenClientRefreshTokenReqVM reqVm) {

    try {
        log.info("[START] customerRefreshToken : refreshToken :: {}", reqVm.getRefreshToken());

        JwtTokenUtil.Token token = processGenerateClientToken.generateClientTokenRefresh(reqVm.getRefreshToken());

        return ResponseEntity
                .ok()
                .body(
                        OauthTokenClientRefreshTokenRespVM
                                .builder()
                                .access_token(token.getAccessToken())
                                .refresh_token(token.getRefreshToken())
                                .expires_in(token.getRefreshTokenExpired())
                                .token_type("Bearer")
                                .build()
                );

    } catch (Exception ex) {
        log.info("[ERROR] customerRefreshToken , ", ex);
        return ResponseEntity
                .badRequest()
                .build();

    } finally {
        log.info("[END] customerRefreshToken ");
    }
}
```

### Summary
- The refresh token is validated and used to generate a new access token.
- The new tokens are returned to the client in the response.
- This ensures secure and seamless token renewal without requiring the user to re-authenticate.
