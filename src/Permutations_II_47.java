import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations_II_47 {
    public static void main(String[] params) {
        int[] nums = new int[]{1,1,2};
        // Вывод: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1 ,2],[3,2,1]]
        List<List<Integer>> list = permuteUnique(nums);
        System.out.println(Arrays.asList(list));
    }


    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtr(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    public static List<Integer> backtr(List<List<Integer>> list, List<Integer> l, int[] nums, boolean[] used) {

        if (l.size()==nums.length){

            list.add(new ArrayList<>(l));
        }else{
            for (int i=0; i<nums.length;i++){
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
                used[i] = true;
                l.add(nums[i]);

                backtr(list, l,  nums, used);
                used[i] = false;
                l.remove(l.size() - 1);
            }
        }
        return l;
    }
}
