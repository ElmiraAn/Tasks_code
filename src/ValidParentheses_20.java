import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ValidParentheses_20 {
    public static void main(String[] params) {
        String s = "()}";
        boolean res = isValid(s);
        System.out.println(res);
    }


    public static boolean isValid(String s) {
        boolean res = false;
        char cha1 = '(', cha2 = ')', chb1 = '{', chb2 = '}', chc1 = '[', chc2 = ']';

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            boolean condition = s.charAt(i) == cha2 || s.charAt(i) == chb2 || s.charAt(i) == chc2;

            if ((st.isEmpty()) && condition) return false;

            if (s.charAt(i) == cha1 || s.charAt(i) == chb1 || s.charAt(i) == chc1) st.add(s.charAt(i));
            else if (condition) {
                if (((st.peek() == cha1) && (s.charAt(i) == cha2))
                        || ((st.peek() == chb1) && (s.charAt(i) == chb2))
                        || ((st.peek() == chc1) && (s.charAt(i) == chc2))){
                    st.pop();
                    res = true;
                }  else return false;
            }
        }
        if (!st.isEmpty()) res = false;
        return res;
    }
}

