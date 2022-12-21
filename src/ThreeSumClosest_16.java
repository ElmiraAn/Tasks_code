import java.util.Arrays;
/*
Учитывая целочисленный массив numsдлины nи целое число target,
найдите три целых числа в numsтаком, что сумма является самой близкой к target.
Возвращает сумму трех целых чисел .
Вы можете предположить, что каждый вход будет иметь ровно одно решение.
 */

public class ThreeSumClosest_16 {
    public static void main(String[] params) {
        //int[] nums = new int[]{-1,2,1,-4};
        int[] nums = new int[]{4, 0, 5, -5, 3, 3, 0, -4, -5};
        //int[] nums = new int[]{0,0,0};
        int target = -2;
        int s = threeSumClosest(nums, target);
        System.out.println(s);
    }

    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length == 0) return 0;
        if (nums.length == 3) return nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        int close_sum = nums[0] + nums[1] + nums[2];
        int r = 10000;
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int rsz = sum - target;
                if (rsz == 0) return sum;
                else if (rsz > 0) {
                    if (Math.abs(target - sum) < r) {
                        r = Math.abs(target - sum);
                        close_sum = sum;
                    }
                    k--;
                } else if (rsz < 0) {
                    if (Math.abs(target - sum) < r) {
                        r = Math.abs(target - sum);
                        close_sum = sum;
                    }
                    j++;
                }
            }
        }
        return close_sum;
    }
}

