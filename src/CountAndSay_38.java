import java.util.Arrays;
import java.util.HashMap;

public class CountAndSay_38 {

    public static void main(String[] params) {
        int n =7;
        String res = countAndSay(n);
        System.out.println(res);
    }
    public static String getCurrentSequence(String previous)
    {
        StringBuilder current=new StringBuilder();
        int counter = 1;

        for (int idx = 1; idx < previous.length(); idx++)
        {
            if (previous.charAt(idx-1) == previous.charAt(idx))
            {
                counter += 1;
            }
            else
            {
                current = current.append(Integer.toString(counter));
                current.append(previous.charAt(idx - 1));
                counter = 1;
            }
        }
        current = current.append(Integer.toString(counter));
        current.append(previous.charAt(previous.length()-1));

        return current.toString();
    }

    public static String countAndSay(int n) {

        if (n == 1)
            return "1";

        String previous = countAndSay(n - 1);
        System.out.println(previous);
        return getCurrentSequence(previous);

    }

}

