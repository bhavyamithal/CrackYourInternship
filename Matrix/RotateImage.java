package Matrix;

public class RotateImage {

    // optimal : in-place rotate
    // transpose the matrix first, then reverse each row
    static void optimal(int[][] matrix) {
        // transpose the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // reverse the rows
        for (int i = 0; i < matrix.length; i++) {
            int m = 0, n = matrix.length - 1;
            while (m < n) {
                // swap
                int temp = matrix[i][m];
                matrix[i][m] = matrix[i][n];
                matrix[i][n] = temp;
                m++;
                n--;
            }
        }
    }


    // brute force : we are creating an extra array
    static void bruteforce(int[][] matrix) {
        int n = matrix.length;
        int[][] ans = new int[n][n];
        // int i = 0, j = 0;
        for (int k = 0; k < n; k++) {
            for (int l = 0; l < n; l++) {
                ans[l][n-k-1] = matrix[k][l];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = ans[i][j];
            }
        }
    }
}
