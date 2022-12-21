import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/*
Учитывая массив строк strs, сгруппируйте анаграммы вместе.
Вы можете вернуть ответ в любом порядке .

Анаграмма — это слово или фраза, образованная путем перестановки букв
другого слова или фразы, обычно с использованием всех исходных букв ровно один раз.
 */
public class GroupAnagrams_49 {
    public static void main(String[] params) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        // Вывод: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1 ,2],[3,2,1]]
        List<List<String>> list = groupAnagrams(strs) ;
        System.out.println(Arrays.asList(list));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs.length==0 || strs==null) return result;
        if (strs.length==1) {
            result.add(Arrays.asList(strs));
            return result;
        }
        HashMap<String , List<String>> groups = new HashMap<>();

        for (int i=0; i<strs.length; i++){
            int[] count = new int[26];
            for (int j=0; j<strs[i].length(); j++){
                count[strs[i].charAt(j)-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int k =0; k<26; k++){
                sb.append((char) (k+'a')).append(count[k]);
            }
            groups.putIfAbsent(sb.toString(), new ArrayList<>());
            groups.get(sb.toString()).add(strs[i]);
        }
        return new ArrayList<>(groups.values());
    }
}

