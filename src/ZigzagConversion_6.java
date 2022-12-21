import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion_6 {
    public static void main(String[] params) {
        String s = "PAYPALISHIRING";
        String res = convert(s, 4);
        System.out.println(res);
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();

        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());
        boolean down = true;
        int c = 0;
        char[] ch = s.toCharArray();
        for (char value : ch) {
            rows.get(c).append(value);
            if (c == 0 || c == numRows - 1) down = !down;
            if (!down) c++;
            else c--;
        }
        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }
        return ret.toString();
    }
}

