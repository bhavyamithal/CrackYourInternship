package Matrix;

import java.util.Stack;

public class MaximumRectangles {
    public int maxArea(int[][] M, int n, int m) {
        int[] arr = new int[m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (M[i][j] == 1) {
                    arr[j] = arr[j] + 1;
                } else {
                    arr[j] = 0;
                }
            }
            max = Math.max(max, largestRectangleInHistogram(arr));
        }
        return max;
    }

    static int largestRectangleInHistogram(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                max = getMax(heights, stack, max, i);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            max = getMax(heights, stack, max, heights.length);
        }
        return max;
    }

    static int getMax(int[] heights, Stack<Integer> stack, int max, int i) {
        int area;
        int popped = stack.pop();
        if (stack.isEmpty()) {
            area = heights[popped] * i;
        } else {
            area = heights[popped] * (i - 1 - stack.peek());
        }
        return Math.max(area, max);
    }
}
