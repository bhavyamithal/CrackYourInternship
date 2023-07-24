package Arrays;

import java.util.Arrays;

public class SetMatrixZeros {
    public static void main(String[] args) {
        int[][] arr = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
        optimal(arr);
        System.out.println(Arrays.deepToString(arr));
    }

    static void optimal(int[][] matrix) {
        // Time complexity = O(M*N)
        // Space complexity = O(1)
        int col0 = 1;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j == 0) {
                        col0 = 0;
                    } else {
                        matrix[0][j] = 0;
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(col0);
        // Traversing from last of the list
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (j == 0) {
                    if (col0 == 0) {
                        matrix[i][j] = 0;
                    }
                } else {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }

    static void brutefroce(int[][] matrix) {
        // Time complexity = O(M*N)
        // Space complexity = O(M+N)
        int m = matrix.length;
        int n = matrix[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
