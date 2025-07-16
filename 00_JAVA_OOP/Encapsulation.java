/**
 * Explanation:
 * The balance field is private, so it cannot be changed directly from outside the class.
 * Methods like deposit and withdraw validate input and update the balance safely.
 * Getters provide controlled access to account information.
 */
public class Encapsulation {
    public static class BankAccount{
        private final String accountNumber;
        private final String accountHolder;
        private double balance;

        public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
            this.accountNumber = accountNumber;
            this.accountHolder = accountHolder;
            this.balance = initialBalance;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public String getAccountHolder() {
            return accountHolder;
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
            } else {
                System.out.println("Deposit amount must be positive.");
            }
        }

        public boolean withdraw(double amount){
            if (amount > 0 && amount <= balance){
                balance -= amount;
                return true;
            } else {
                System.out.println("Withdrawal amount must be positive and less than or equal to the current balance.");
                return false;
            }
        }
    }
}
// Summary:
// Encapsulation hides the internal state (balance) and only allows changes through controlled methods, ensuring data integrity and security.
// This is a common practice in real-world applications like banking systems.

// 🔍 Interviewer might follow up with:
// "What if we make the field public?"
// 👉 Answer: It breaks encapsulation, as external code can directly change the state (e.g., set a negative balance).