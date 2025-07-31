/**
 * Given an array of size n-1 containing numbers from 1 to n, find the missing number.
 */
public class findMissingNumber {
    public static int findMissing(int[] arr, int n){
        // Calculate the expected sum of numbers from 1 to n
        int expectedSum = n * (n + 1) / 2;
        // Calculate the actual sum of the array elements
        int actualSum = 0;
        for (int num : arr) {
            actualSum += num;
        }
        // The missing number is the difference between expected and actual sum
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6}; // Example array with missing number 3
        int n = 6; // Size of the array should be n-1, so n is the maximum number
        System.out.println("Missing number: " + findMissing(arr, n)); // Output: Missing number: 3
    }
}
