public class SearchInRotatedSortedArray_33 {
    /*
    Имеется целочисленный массив, nums отсортированный в порядке возрастания (с различными значениями).
    Перед тем, как быть переданным вашей функции, nums он может быть повернут по
    неизвестному опорному индексу k( 1 <= k < nums.length), так что результирующий массив
    будет [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]( 0-индексирован ).
     Например, [0,1,2,4,5,6,7]может быть повернут по опорному индексу 3и станет [4,5,6,7,0,1,2].

     Учитывая массив nums после возможного поворота и целое число target, вернуть индекс target,
     если он находится в nums или -1 если он не находится в nums .

     Вы должны написать алгоритм со O(log n)сложностью выполнения.
     */
    public static void main(String[] params) {
        //int[] nums = new int[]{1, 3}; //результат 1
        //int target = 3;
        int[] nums = new int[]{4,5,6,7,0,1,2}; // результат 4
        int target = 0;

        //int[] nums = new int[]{4,5,6,7,0,1,2}; // результат -1
        //int target = 3;

        int s = search(nums, target);
        System.out.println(s);
    }

    public static int search(int[] nums, int target) {
        int i = 0;
        if (nums.length == 1) {
            if (nums[0] == target) return 0;
            else return -1;
        }
        while (i < nums.length - 1 && nums[i] < nums[i + 1]) {
            i++;
        }
        int index2 = i + 1;
        if (index2 == nums.length) index2 = 0;
        int[] nums2 = new int[nums.length];
        for (int j = 0; j < nums.length; j++) {
            nums2[j] = nums[index2];
            index2++;
            if (index2 == nums.length) index2 = 0;
        }
        int first = 0;
        int last = nums.length - 1;
        while (first <= last) {
            int mid = (first + last) / 2;
            if (nums2[mid] == target) {
                if (mid + i + 1 < nums.length) return mid + i + 1;
                else return mid + i + 1 - nums.length;
            } else if (nums2[mid] < target) first = mid + 1;
            else if (nums2[mid] > target) last = mid - 1;
        }
        return -1;
    }
}

