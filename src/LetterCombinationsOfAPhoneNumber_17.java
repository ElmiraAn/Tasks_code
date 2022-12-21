import java.util.*;
/*
Учитывая строку, содержащую цифры 2-9включительно,
вернуть все возможные комбинации букв, которые может представлять число.
Верните ответ в любом порядке .

Отображение цифр в буквы (точно так же, как на телефонных кнопках) приведено ниже.
 Обратите внимание, что 1 не соответствует ни одной букве.*/

public class LetterCombinationsOfAPhoneNumber_17 {

    public static void main(String[] params) {

        String digits = "23";
        List<String> l = letterCombinations(digits);
        System.out.println(l.toString());
    }

    public static List<String> letterCombinations(String digits) {
        List<String> l = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        if (digits.length() == 0) return l;
        Deque<String> deque = new ArrayDeque<>();
        deque.add("");
        for (int i = 0; i < digits.length(); i++) {
            String a_map = map.get(digits.substring(i, i + 1));
            int size = deque.size();
            for (int j = 0; j < size; j++) {
                String p = deque.pollFirst();
                for (int k = 0; k < a_map.length(); k++) {

                    deque.add(p.concat(a_map.substring(k, k + 1)));
                    System.out.println(deque);
                }
            }

        }
        while (!deque.isEmpty()) l.add(deque.poll());
        return l;
    }
}

