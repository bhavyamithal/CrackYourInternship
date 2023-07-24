package Arrays;

import java.util.ArrayList;
import java.util.Collections;

public class ChocolateDistributionProblem {
    // FIND MINIMUM DIFFERENCE
    public static void main(String[] args) {

    }

    /*
     * a - array of N integers where each value represents the number of chocolates
     * in a packet
     * n - length of a
     * m - number of students
     */

    static int optimal(ArrayList<Integer> a, int n, int m) {
        Collections.sort(a);
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < (n - m + 1); i++) {
            int diff = a.get(i + m - 1) - a.get(i);
            minDiff = Math.min(diff, minDiff);
        }

        return minDiff;
    }

    static void bruteforce(ArrayList<Integer> a, int n, int m) {

    }
}
