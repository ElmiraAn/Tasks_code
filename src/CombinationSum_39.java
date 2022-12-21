import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Учитывая массив различных целых чисел nums и целевое целое число target,
вернуть список всех уникальных комбинаций , в nums которых сумма выбранных
 чисел равна target. Вы можете возвращать комбинации в любом порядке .

Один и тот же номер можно выбирать nums неограниченное количество раз .
Две комбинации уникальны, если частота хотя бы одного из выбранных чисел различна.

Тестовые случаи генерируются таким образом, чтобы количество уникальных комбинаций,
которые суммируются, было target меньше, чем 150комбинаций для данного входа.
 */
public class CombinationSum_39 {
    public static void main(String[] params) {
        //int [] nums = new int[]{2,3,6,7};
        // int target =7; //[[2,2,3],[7]]
        int [] nums = new int[]{2,3,5};
        int target =8; //[[2,2,2,2],[2,3,3],[3,5]]
        List<List<Integer>> list = combinationSum(nums, target);

        System.out.println(list.toString());
    }


    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) {list.add(new ArrayList<>(tempList));
            //System.out.println(list.toString()+" list");
        }
        else{
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                //System.out.println(tempList.toString()+" "+i);
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
                //System.out.println(tempList.toString()+" после remove "+i);
            }
        }
    }
}

