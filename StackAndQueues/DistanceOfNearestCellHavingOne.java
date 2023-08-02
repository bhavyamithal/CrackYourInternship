package StackAndQueues;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCellHavingOne {
    // queue data structure is used
    // solution explaination ->
    // https://www.youtube.com/watch?v=7AhF1h1fGnk
    static int[][] solution(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    ans[i][j] = 0;
                    q.add(new int[] { i, j });
                } else {
                    ans[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] index = q.remove();
            int i = index[0];
            int j = index[1];

            int val = ans[i][j] + 1;

            // top
            if ((i - 1 >= 0) && val < ans[i - 1][j]) {
                ans[i - 1][j] = val;
                q.add(new int[] { i - 1, j });
            }

            // right
            if ((j + 1 < m) && val < ans[i][j + 1]) {
                ans[i][j + 1] = val;
                q.add(new int[] { i, j + 1 });
            }

            // bottom
            if ((i + 1 < n) && val < ans[i + 1][j]) {
                ans[i + 1][j] = val;
                q.add(new int[] { i + 1, j });
            }

            // left
            if ((j - 1 >= 0) && val < ans[i][j - 1]) {
                ans[i][j - 1] = val;
                q.add(new int[] { i, j - 1 });
            }

        }

        return ans;

    }
}
