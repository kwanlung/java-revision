import java.util.*;

public class targetSum {
    public static List<int[]> findPairsWithTargetSum(int[] sums, int target){
        List<int[]> pairs = new ArrayList<>();
        for (int i = 0; i<sums.length; i++){
            for(int j = i + 1; j<sums.length; j++){
                if (sums[i] + sums[j] == target){
                    pairs.add(new int[]{sums[i], sums[j]});
                }
            }
        }
        return pairs;
    }

    public static List<int[]> findPairsWithTargetSumOptimized(int[] sums, int target) {
        List<int[]> pairs = new ArrayList<>();
        int left = 0;
        int right = sums.length - 1;

        while (left < right) {
            int currentSum = sums[left] + sums[right];
            if (currentSum == target) {
                pairs.add(new int[]{sums[left], sums[right]});
                left++;
                right--;
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }
        return pairs;
    }

    public static List<int[]> findPairsWithTargetSumUsingHashMap(int[] sums, int target){
        List<int[]> pairs = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int sum : sums) {
            int complement = target - sum;
            if (map.containsKey(complement)) {
                pairs.add(new int[]{complement, sum});
            }
            map.put(sum, 1); // Store the sum in the map
        }
        return pairs;
    }

    public static List<int[]> findPairsWithTargetSumUsingHashSet(int[] sums, int target){
        List<int[]> pairs = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for(int sum : sums){
            int complement = target - sum;
            if (set.contains(complement)){
                pairs.add(new int[]{complement, sum});
            }
            set.add(sum);
        }
        return pairs;
    }

    public static void main(String[] args) {
        int[] sums = {1, 2, 3, 4, 5};
        int target = 6;
        List<int[]> pairs = findPairsWithTargetSumUsingHashSet(sums, target);
        System.out.println("Pairs with target sum " + target + ":");
        for (int[] pair : pairs) {
            System.out.println(pair[0] + ", " + pair[1]);
        }
    }
}
