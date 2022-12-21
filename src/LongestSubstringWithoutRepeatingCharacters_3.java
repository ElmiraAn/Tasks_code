import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters_3 {
    public static void main(String[] params) {
        String s = "abcabcbb";
        int l = lengthOfLongestSubstring(s);
        System.out.println(l);
    }

    public static int lengthOfLongestSubstring(String s) {
        int l = 0, max = 0;
        char[] ch = s.toCharArray();
        Queue set1 = new ArrayDeque<>();
        boolean f = false;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            if (!set1.contains(ch[i])) {
                set1.add(ch[i]);
                if (!f) {
                    start = i;
                    f = true;
                }
                l++;
            } else {
                int count = 0;
                for (int j = start; j < i; j++) {
                    Character a = (Character) set1.remove();
                    if (ch[i] == a) {
                        count = j;
                        break;
                    }
                }
                i = count;
                if (l > max) max = l;
                l = 0;
                set1.clear();
                f = false;
            }
        }
        //System.out.println(set1);
        if (l > max) max = l;
        return max;
    }
}

