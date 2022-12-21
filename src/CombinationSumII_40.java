import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Имея набор чисел-кандидатов ( candidates) и целевое число ( target),
найдите все уникальные комбинации, в candidates которых сумма чисел-кандидатов равна target.

Каждое число candidates может быть использовано в комбинации только один раз .

Примечание.  В наборе решений не должно быть повторяющихся комбинаций.
 */

public class CombinationSumII_40 {
    public static void main(String[] params) {
        int[] nums = new int[]{2, 5, 2, 1, 2};
        int target = 5; //[[2,2,3],[7]]
        //int [] nums = new int[]{10,1,2,7,6,1,5};
        //int target =8; //[[2,2,2,2],[2,3,3],[3,5]]
        List<List<Integer>> list = combinationSum2(nums, target);

        System.out.println(list.toString());
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        recursia(list, new ArrayList<>(), candidates, target, 0);

        return list;
    }

    public static void recursia(List<List<Integer>> list, List<Integer> templelist, int[] nums, int target, int start) {
        if (target < 0) return;
        else if (target == 0) {
            list.add(new ArrayList<>(templelist));
            // System.out.println(list.toString()+" list");
        } else {

            for (int i = start; i < nums.length; i++) {
                //if (i>start) continue;
                if (i > start && nums[i] == nums[i - 1]) {
                    // System.out.println(" "+i+" continue "+start);
                    continue;
                } // skip duplicates

                templelist.add(nums[i]);
                //System.out.println(templelist.toString()+" "+i+" "+start);
                recursia(list, templelist, nums, target - nums[i], i + 1);
                templelist.remove(templelist.size() - 1);
                //System.out.println(templelist.toString()+" после remove "+i);
            }
        }
    }
}

