public class DivideTwoIntegers_29 {

    public static void main(String[] params) {
        int dividend = 7;
        int divisor = -3;
        int s = divide(dividend,divisor);
        System.out.println(s);
    }
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        long s=0;
        int z=1;
        if ((divisor<0 && dividend>0)||(divisor>0 && dividend<0)) {z=-1;divisor=-divisor;}
        long d = divisor;
        if (divisor>0 && dividend>0){
            while (d<=dividend){
                d=(long)(d+divisor);
                s=(long)(s+1);
            }}
        if (divisor<0 && dividend<0){
            while (d>=dividend){
                d=(long)(d+divisor);
                s=(long)(s+1);
            }}
        s = (long) (s*z);
        if (s>Integer.MAX_VALUE) s = Integer.MAX_VALUE;
        else if (s<Integer.MIN_VALUE) s = Integer.MIN_VALUE;
        return (int) s;
    }
}

