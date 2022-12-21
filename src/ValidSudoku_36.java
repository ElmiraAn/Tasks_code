import java.util.*;
/*
Определите,  9 x 9действительна ли доска судоку.
Только заполненные ячейки должны быть проверены  в соответствии со следующими правилами :

Каждая строка должна содержать цифры  1-9без повторения.
Каждый столбец должен содержать цифры  1-9 без повторения.
Каждый из девяти  3 x 3подблоков сетки должен содержать цифры  1-9 без повторения.
Примечание:

Доска судоку (частично заполненная) может быть действительной, но не обязательно решаемой.
Только заполненные ячейки должны быть проверены в соответствии с указанными правилами. */

public class ValidSudoku_36 {
    public static void main(String[] params) {
        char[][] board = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};


        boolean sudoku = isValidSudoku(board);
        System.out.println(sudoku);
    }


    public static boolean isValidSudoku(char[][] board) {
        boolean res = true;

        for (int i = 0; i < board.length; i++) {
            Set<Character> rows = new HashSet<>();
            Set<Character> columns = new HashSet<>();
            Set<Character> nine = new HashSet<>();

            int start1, start2;
            if (i < 3) start1 = -1;
            else if (i < 6) start1 = 2;
            else start1 = 5;

            if (i % 3 == 0) start2 = 0;
            else if (i % 3 == 1) start2 = 3;
            else start2 = 6;
            int a = start1, b = start2;

            for (int j = 0; j < board.length; j++) {

                if (board[i][j] != '.') {
                    if (rows.contains(board[i][j])) return false;
                    else rows.add(board[i][j]);
                }
                if (board[j][i] != '.') {
                    if (columns.contains(board[j][i])) return false;
                    else columns.add(board[j][i]);
                }

                if (j % 3 == 0) {
                    b = start2;
                    a++;
                }

                if (board[a][b] != '.') {
                    if (nine.contains(board[a][b])) return false;
                    else nine.add(board[a][b]);
                }
                b++;
            }
            //System.out.println(Arrays.asList(rows).toString());
            //System.out.println(Arrays.asList(columns).toString());
            rows.clear();
            columns.clear();
            nine.clear();
        }
        return res;
    }
}

