package Arrays;

public class MaxValueOfEquation {

    // will come to the optimal solution later

    // TLE
    static int bruteforce(int[][] points, int k) {
        int maxValue = Integer.MIN_VALUE;
        int i = 0;
        while (i < points.length - 1) {
            int j = i + 1;
            while (j < points.length) {
                int sum1 = points[i][0] - points[j][0];
                if (Math.abs(sum1) <= k) {
                    sum1 = Math.abs(sum1) + points[i][1] + points[j][1];
                    maxValue = Math.max(maxValue, sum1);
                }
                j++;
            }
            i++;
        }
        return maxValue;
    }
}
