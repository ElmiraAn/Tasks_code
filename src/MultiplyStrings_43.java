import java.util.ArrayList;
import java.util.List;

public class MultiplyStrings_43 {
    public static void main(String[] params) {

        //String num2 = "123";
        //String num1 = "456";
        String num2 = "0";
        String num1 = "9133";
        String res = multiply(num1, num2);
        System.out.println(res);
    }

    public static String multiply(String num1, String num2) {

        String res = "";
        if (num1=="0" || num2=="0" || num2=="" || num1=="" || num2==null || num1==null) return "0";
        else {
            //String[] r = new String[]
            // List<Integer> r = new ArrayList<>();
            int[] r =new int[40000];
            int a=0;
            int count =-1;
            int count1=-1;
            int c=0;
            for (int i=num1.length()-1; i>=0;i--){
                //count++;
                System.out.println();
                count =-1;
                count1++;
                for (int j=num2.length()-1; j>=0;j--){
                    count++;

                    int temp = Integer.parseInt(num1.substring(i,i+1))*Integer.parseInt(num2.substring(j,j+1))+a;
                    //System.out.println(temp);
                    int b = temp%10;

                    a = temp/10;
                    System.out.println(a+ " a "+ b +" b" );


                    System.out.println(r[count+count1]+"  r[count+count1]"+ (count+count1)+" " +count +" "+ count1);
                    int sum =(r[count+count1]+b);
                    r[count+count1] = (sum)%10;

                    c = sum/10;
                    System.out.println(r[count+count1]+"  r[ccount+count1]"+ (count+count1)+" b "+b+" c "+c);
                    if (c!=0) {r[count+count1+1] = r[count+count1+1]+c; c=0; }
                    if (j==0 && a!=0) {r[count+count1+1] = r[count+count1+1]+a; a=0;count++; }

                    System.out.println(r[count+count1]+"  r[ccount+count1]"+ (count+count1)+" b "+b+" c "+c);
                }
            }
            // if (a!=0) {r[count+count1+1] = r[count+count1+1]+a; a=0; count1++;}
            StringBuilder sb = new StringBuilder();
            for (int i=count+count1; i>=0; i--){
                sb.append(r[i]);
            }
            return sb.toString();}
    }
}

