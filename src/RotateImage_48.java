import java.util.Arrays;
/*
Вам дано n x n2D matrixизображение, поверните изображение на 90 градусов (по часовой стрелке).

Вы должны повернуть изображение на месте , что означает, что вы должны изменить
 входную 2D-матрицу напрямую. НЕ выделяйте другую 2D-матрицу и не выполняйте поворот.
 */

public class RotateImage_48 {
    public static void main(String[] params) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        // Вывод: [[7,4,1],[8,5,2],[9 ,6,3]]
        rotate(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] m2 = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(matrix[i], 0, m2[i], 0, n);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int k = n - i - 1;
                matrix[j][k] = m2[i][j];
            }
        }
    }
}

