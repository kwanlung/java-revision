public class reverseString {
    public static void main(String[] args){
        String s = "Hello World";
        String reversed = reverse(s);

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
        StringBuilder reversed = new StringBuilder(s);
        reversed.reverse();
        System.out.println(reversed);
        return reversed.toString();
    }
}
