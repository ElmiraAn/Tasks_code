public class IntegerToRoman_12 {
    public static void main(String[] params) {
        int num = 1994;
        String s = intToRoman(num);
        System.out.println(s);
    }

    public static String intToRoman(int num) {

        int a1,a2,a3,a4;
        a1=num/1000;
        a2 = (num-a1*1000)/100;
        a3 = (num -a1*1000-a2*100)/10;
        a4 = num%10;
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<a1;i++){
            sb.append("M");
        }
        if (a2>=5 && a2<9) {sb.append("D"); a2=a2-5;}
        for (int i=0;i<a2;i++){
            if (a2==9) {sb.append("CM"); break;}
            else if (a2==4) {sb.append("CD"); break;}
            else sb.append("C");

        }
        if (a3>=5 && a3<9) {sb.append("L"); a3=a3-5;}
        for (int i=0;i<a3;i++){
            if (a3==9) {sb.append("XC"); break;}
            else if (a3==4) {sb.append("XL"); break;}
            else sb.append("X");

        }
        if (a4>=5 && a4<9) {sb.append("V"); a4=a4-5;}
        for (int i=0;i<a4;i++){
            if (a4==9) {sb.append("IX"); break;}
            else if (a4==4) {sb.append("IV"); break;}
            else sb.append("I");
        }
        return sb.toString();
    }
}

