/**
 * Example: "Write a function to check if a string is an anagram of another."
 */
public class stringAnagram {
    static boolean isAnagram(String a, String b){
        // Remove spaces and convert to lowercase
        a = a.replaceAll("\\s", "").toLowerCase();
        b = b.replaceAll("\\s", "").toLowerCase();

        if (a.length() != b.length()){
            return false;
        }

        // Create an array to count character occurrences
        int[] count = new int[256]; // ASCII characters
        // Count occurrences of each character in a and b
        for (char c: a.toCharArray()){
            count[c]++;
        }
        for (char c : b.toCharArray()){
            count[c]--;
            if (count[c] < 0) {
                return false; // More occurrences of c in b than in a
            }
        }
        return true; // All counts are zero, so they are anagrams

    }
}
