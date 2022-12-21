import java.util.*;
/*
Учитывая массив целых numsчисел n, верните массив всех
уникальных четверок [nums[a], nums[b], nums[c], nums[d]] , таких что:
    0 <= a, b, c, d < n
    a, b, , cи различны .d
    nums[a] + nums[b] + nums[c] + nums[d] == target

Вы можете вернуть ответ в любом порядке . */

public class FourSum_18 {
    public static void main(String[] params) {
        //int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int[] nums = new int[]{1000000000, 1000000000, 1000000000, 1000000000};

        int target = -294967296;
        //int target = 0;
        List<List<Integer>> s = fourSum(nums, target);
        System.out.println(s.toString());
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length - 3; i++) {

            int j = i + 2;
            int jj = j;
            int kk = nums.length - 1;
            while (jj < kk) {
                int q = jj - 1;
                j = jj;
                int k = nums.length - 1;
                while (j < k) {

                    if ((long)(nums[q] + nums[i]) + (long)(nums[j] + nums[k]) == target) {
                        set.add(Arrays.asList(nums[q], nums[i], nums[j], nums[k]));
                        j++;
                        k--;
                    } else if ((long)(nums[q] + nums[i]) + (long)(nums[j] + nums[k]) < target) {
                        j++;
                    } else k--;
                }
                jj++;
            }
        }
        return new ArrayList<>(set);
    }
}

