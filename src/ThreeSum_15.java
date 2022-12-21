import java.util.*;

/*
Дан целочисленный массив nums, вернуть все триплеты [nums[i], nums[j], nums[k]],
такие что i != j, i != k, и j != k, и nums[i] + nums[j] + nums[k] == 0.
Обратите внимание, что в наборе решений не должно быть повторяющихся триплетов.
 */
public class ThreeSum_15 {

    public static void main(String[] params) {
        int[] nums = new int[]{3, 0, -2, -1, 1, 2};
        List<List<Integer>> s = threeSum(nums);
        System.out.println(s.toString());
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        if (nums.length == 0) return new ArrayList<>(set);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) set.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                else if (sum > 0) k--;
                else j++;
            }
        }
        return new ArrayList<>(set);
    }
}

