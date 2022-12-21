public class FindTheIndexoftheFirstOccurrenceInAString_28 {
    /*
    Учитывая две строки needle и haystack,
    вернуть индекс первого вхождения needleв haystack,
    или -1 если needle не является частью haystack.
     */
    public static void main(String[] params) {
        String haystack = "sadbutsad";
        String needle = "sad";
        int res = strStr(haystack, needle);
        System.out.println(res);
    }

    public static int strStr(String haystack, String needle) {

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (i + needle.length() <= haystack.length()) {
                    if (haystack.substring(i, i + needle.length()).equals(needle)) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }
}

