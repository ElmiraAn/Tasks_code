import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class LongestPalindromicSubstring_5 {
    public static void main(String[] params) {
        String s = "baabd";
        String l = longestPalindrome(s);
        System.out.println(l);
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            System.out.println("i=" + i + " len1=" + len1 + " len2=" + len2);
            int len = Math.max(len1, len2);
            if (len > (end - start)) {
                start = i - (len - 1) / 2;
                end = i + (len) / 2;
                System.out.println("start=" + start + " end=" + end);
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int l = left;
        int r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            System.out.println("l=" + l + " r=" + r);
            l--;
            r++;
        }
        return r - l - 1;
    }

}

