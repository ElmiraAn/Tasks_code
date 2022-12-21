import java.util.Arrays;

public class NextPermutation_31 {
    /*
    Перестановка массива целых чисел — это расположение его элементов в последовательности или линейном порядке .
    Например, для arr = [1,2,3], следующие все перестановки arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
    Следующая перестановка массива целых чисел — это следующая лексикографически большая перестановка его целого числа.
    Более формально, если все перестановки массива отсортированы в одном контейнере в соответствии с
    их лексикографическим порядком, то следующей перестановкой этого массива будет перестановка,
    следующая за ней в отсортированном контейнере. Если такое расположение невозможно, массив необходимо
    переупорядочить в самом низком возможном порядке (т. е. отсортировать по возрастанию).

    Например, следующая arr = [1,2,3]перестановка [1,3,2].
    arr = [2,3,1]Точно так же следующая перестановка [3,1,2].
    В то время как следующая перестановка arr = [3,2,1]происходит [1,2,3]потому [3,2,1],
    что не имеет лексикографической большей перестановки.
    Учитывая массив целых чисел nums, найдите следующую перестановку nums .
    Замена должна быть на месте и использовать только постоянную дополнительную память.
    */


    public static void main(String[] params) {
        //int[] nums = new int[]{0, 1, 2, 5, 3, 3, 0}; /*Ответ: 0130235*/
        //int[] nums = new int[]{5,3,3};               /*Ответ: 3 3 5*/
        int[] nums = new int[]{3, 2, 1};               /*Ответ: 1 2 3*/
        nextPermutation(nums);
    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) {
            i--;
        }
        if (i == 0) {
            Arrays.sort(nums);
        } else {
            //System.out.println(i);//3

            int min = 100;
            int min_index = i - 1;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] <= min && nums[j] > nums[i - 1]) {
                    min = nums[j];
                    min_index = j;
                }
            }
            System.out.println(min_index + " " + min);
            nums[min_index] = nums[i - 1];
            nums[i - 1] = min;
            int index_i = i;
            int[] nums2 = new int[nums.length - i];

            for (int k = 0; k < nums2.length; k++) {
                nums2[k] = nums[index_i];
                index_i++;
            }

            index_i = i;
            Arrays.sort(nums2);
            //System.out.println(Arrays.toString(nums2));
            for (int k = 0; k < nums2.length; k++) {
                nums[index_i] = nums2[k];
                index_i++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
