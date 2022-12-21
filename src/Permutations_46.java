import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Учитывая массив nums различных целых чисел,
вернуть все возможные перестановки .
Вы можете вернуть ответ в любом порядке .
 */
public class Permutations_46 {
    public static void main(String[] params) {
        int[] nums = new int[]{1,2,3};
        // Вывод: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1 ,2],[3,2,1]]
        List<List<Integer>> list = permute(nums);
        System.out.println(Arrays.asList(list));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtr(list, new ArrayList<>(), nums);

        return list;
    }
    public static List<Integer> backtr(List<List<Integer>> list, List<Integer> l, int[] nums){
        if (l.size()==nums.length) {
            list.add(new ArrayList<>(l));
        }else{
            for (int i=0; i<nums.length; i++) {
                if (!l.contains(nums[i])) {
                    l.add(nums[i]);
                    backtr(list, l, nums);
                    l.remove(l.size() - 1);
                }
            }
        }

        return l;
    }
}
