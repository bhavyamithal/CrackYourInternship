package StackAndQueues;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumTimeRequiredToRotAllOranges {
    // https://www.youtube.com/watch?v=H-p_MaL0g-A
    static int minTimeReq(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                }
            }
        }
        int count = 0;
        q.add(new int[] { -1, -1 });
        while (!q.isEmpty()) {
            int i = q.element()[0];
            int j = q.element()[1];
            if (i == -1 && q.size() == 1) {
                q.remove();
                break;
            } else if (i == -1 && q.size() > 1) {
                count++;
                q.remove();
                q.add(new int[] { -1, -1 });
            } else {
                if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                    q.add(new int[] { i - 1, j });
                }
                if (j + 1 < m && grid[i][j + 1] == 1) {
                    grid[i][j + 1] = 2;
                    q.add(new int[] { i, j + 1 });
                }
                if (i + 1 < n && grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 2;
                    q.add(new int[] { i + 1, j });
                }
                if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                    grid[i][j - 1] = 2;
                    q.add(new int[] { i, j - 1 });
                }
                q.remove();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return count;
    }
}
