package Arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    static List<Integer> spiral(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int n = matrix.length;
        int m = matrix[0].length;

        int top = 0, right = m - 1, bottom = n - 1, left = 0;

        while (top <= bottom && left <= right) {

            // for moving left to right
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }

            top++;

            // for moving top to bottom
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }

            right--;

            // for moving right to left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }

                bottom--;
            }

            // for moving bottom to top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }

                left++;
            }
        }

        return ans;
    }
}
