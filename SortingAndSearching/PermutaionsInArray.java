package SortingAndSearching;

import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/permutations-in-array1747/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

public class PermutaionsInArray {
    static boolean optimal(long[] a, long[] b, int n, int k) {
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0, j = n - 1;
        while (i < n) {
            if (a[i] + b[j] < k)
                return false;
            i++;
            j--;
        }
        return true;
    }
}
