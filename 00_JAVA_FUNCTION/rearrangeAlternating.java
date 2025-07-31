import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of positive and negative numbers, rearrange them in alternating fashion (positive, negative, positive…) maintaining their original relative order.
 * <p>
 * Approach:
 * Use two auxiliary lists (one for positive, one for negative), then merge alternatively.
 */
public class rearrangeAlternating {
    public static void rearrange(int[] arr){
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for (int num : arr){
            if (num >= 0){
                pos.add(num);
            } else{
                neg.add(num);
            }
        }

        // If the number of positive and negative numbers are not equal, we cannot rearrange them in alternating fashion
        int i = 0, p = 0, n = 0;
        while (p<pos.size() && n<neg.size()){
            arr[i++] = pos.get(p++);
            arr[i++] = neg.get(n++);
        }
        // If there are remaining positive numbers
        while (p < pos.size()) {
            arr[i++] = pos.get(p++);
        }
        // If there are remaining negative numbers
        while (n < neg.size()) {
            arr[i++] = neg.get(n++);
        }

    }
}
