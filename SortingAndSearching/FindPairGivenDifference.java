package SortingAndSearching;

import java.util.Arrays;

public class FindPairGivenDifference {
    static boolean findPair(int[] arr, int size, int n) {
        Arrays.sort(arr);
        int low = 0, high = 1;
        while (low <= high && high < size) {
            int diff = arr[high] - arr[low];
            if (diff > n) {
                low++;
            } else if (diff < n) {
                high++;
            } else {
                if (low != high)
                    return true;
                else
                    high++;
            }
        }
        return false;
    }
}
