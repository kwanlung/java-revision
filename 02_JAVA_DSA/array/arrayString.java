package array;

public class arrayString {
    public static void main(String[] args) {
        // Example usage of the arrayString class
        String[] array = {"Hello", "World", "Java", "Programming"};
        printArray(array);
        System.out.println("Length of array: " + getArrayLength(array));
    }

    public static void printArray(String[] arr) {
        for (String str : arr) {
            System.out.print(str + " ");
        }
        System.out.println();
    }

    public static int getArrayLength(String[] arr) {
        return arr.length;
    }
}
