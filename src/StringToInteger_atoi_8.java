public class StringToInteger_atoi_8 {
    public static void main(String[] params) {
        String s = "+-351";
        int y = myAtoi(s);
        System.out.println(y);
    }

    public static int myAtoi(String s) {
        s = s.trim();
        int res = 0;
        char z;
        if (s.isEmpty()) return 0;
        if (s.charAt(0) == '-' && s.length() > 1) {
            z = '-';
            s = s.substring(1);
        } else if (s.charAt(0) == '+' && s.length() > 1) {
            z = '+';
            s = s.substring(1);
        } else z = '+';
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        boolean b = false;
        for (char c : ch) {
            if (!(c <= '9' && c >= '0')) {
                break;
            }
            sb.append(c);
            b = true;
        }
        if (!b) return 0;

        try {
            res = Integer.parseInt(String.valueOf(sb));
            if (z == '-') res = -res;
            return res;
        } catch (NumberFormatException e) {
            if (z == '-') return Integer.MIN_VALUE;
            else return Integer.MAX_VALUE;
        }

    }

}


