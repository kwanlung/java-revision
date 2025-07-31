import java.util.HashMap;
import java.util.Map;

/**
 * * This is a placeholder for the twoSum function.
 * int [] nums = {2, 7, 11, 15};
 * int target = 9;
 * * The function should return the indices of the two numbers such that they add up to the target.
 */
public class twoSum {
    public static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 1; i<nums.length; i++){
            int result = target - nums[i];
            if (map.containsKey(result)){
                return new int[]{
                        map.get(result), i
                };
            }
            // Store the index of the current number
            map.put(nums[i], i);
        }
        return new int[]{-1, -1}; // Return -1, -1 if no solution is found
    }
}
