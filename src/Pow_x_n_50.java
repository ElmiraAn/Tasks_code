import java.util.Arrays;
/*
Реализуйте pow(x, n) , который вычисляет xв степени n(т.е. ).xn
 */
public class Pow_x_n_50 {
    public static void main(String[] params) {
        double x=0.00001;
        int n=2147483647;
        double res = myPow(x, n);
        System.out.println(res);
    }


    public static double myPow(double x, int n) {
        if(n < 0){
            n = -n;
            x = 1 / x;
        }
        double pow = 1;

        while(n != 0){
            if(n%2!=0){
                pow *= x;
            }
            x *= x;
            n=n/2;
        }
        return pow;
    }
}

