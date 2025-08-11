public class checkPalindrome {
    static boolean isPalindrome(String s){
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length -1;

        while (left < right){
            if (chars[left] != chars[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main (String[] args){
        String s = "hi";
        boolean result = isPalindrome(s);
        System.out.println("Is the string \"" + s + "\" a palindrome? " + result);
    }
}
