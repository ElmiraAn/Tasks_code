import java.util.Arrays;
/*
Дан массив целых чисел, nums отсортированных в неубывающем порядке,
найти начальную и конечную позицию заданного target значения.
Если target не найдено в массиве, вернуть [-1, -1].
Вы должны написать алгоритм со  O(log n)сложностью выполнения.
 */

public class FindFirstAndLastPositionOfElementInSortedArray_34 {

    public static void main(String[] params) {
        int[] nums = new int[]{2, 2}; //результат 0,1
        int target = 2;
        //int[] nums = new int[]{5,7,7,8,8,10}; // результат 3,4
        //int target = 8;

        int[] res = searchRange(nums, target);
        System.out.println(Arrays.toString(res));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums.length == 1) {
            if (nums[0] == target) {
                res[0] = 0;
                res[1] = 0;
            }
            return res;
        }
        int a1 = -1, a2 = -1, first = 0;
        int last = nums.length - 1;
        while (first <= last) {
            int mid = (first + last) / 2;
            if (nums[mid] == target) {
                a1 = mid;
                a2 = mid;
                break;
            } else if (nums[mid] < target) first = mid + 1;
            else if (nums[mid] > target) last = mid - 1;
        }
        while (a1 != -1 && ((a1 < nums.length - 1 && nums[a1] == nums[a1 + 1])
                || (a2 > 0 && nums[a2] == nums[a2 - 1]))) {
            if (a1 < nums.length - 1 && nums[a1] == nums[a1 + 1]) a1++;
            if (a2 > 0 && nums[a2] == nums[a2 - 1]) a2--;
        }
        res[0] = a2;
        res[1] = a1;
        return res;
    }
}

