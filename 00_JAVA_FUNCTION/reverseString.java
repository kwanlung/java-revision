public class reverseString {
    public static void main(String[] args){
        String s = "abcdef12345";
        String reversed = reverse(s);
        System.out.println("Reversed string using method 1: " + reversed);

        // Method 2: Direct use char array without StringBuilder
        char[] charArray = s.toCharArray();
        for (int i = s.length()-1; i>=0; i--){
            System.out.print(charArray[i]);
        }
    }

    /**
     * This method reverses a given string.
     * @param s The string to be reversed.
     * @return The reversed string.
     * method 1: Using StringBuilder to reverse the string
     */
    private static String reverse(String s) {
//        StringBuilder reversed = new StringBuilder(s);
//        reversed.reverse();
//        System.out.println(reversed);
//        return reversed.toString();
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length -1;
        while (left < right){
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }
}
