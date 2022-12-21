public class ReverseInteger_7 {
    public static void main(String[] params) {
        int x = 351;
        int y  = reverse(x);
        System.out.println(y);
    }
    public static int reverse(int x) {
        /*System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;*/

        int res=0;
        char z;
        if (x<0) {z='-'; x = -x;} else z='+';
        String str = Integer.toString(x);
        char[] ch = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        if (z=='-') sb.append(z);
        for (int i=ch.length-1; i >=0; i--){
            sb.append(ch[i]);
        }
        try{res = Integer.parseInt(String.valueOf(sb));
            return res;}
        catch (NumberFormatException e){
            return 0;
        }
    }

}
