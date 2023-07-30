package SortingAndSearching;

import java.util.Arrays;

public class Checkifreversingsubarraymakethearraysorted {
    // TC : (N * log N)
    // SC : (1)
    // sort the array
    // find the first index and last index in the given array which does not match
    // with the sorted array
    // If no such indices are found (given array was already sorted), return True
    // Else check if the elements between the found indices are in decreasing order,
    // if Yes then return True else return False
    static boolean optimal(int[] nums) {
        int[] arr = nums;
        Arrays.sort(arr);
        int i = 0;
        int count = 0;
        int start = -1, end = -1;
        while (i < nums.length) {
            if (count == 0 && nums[i] != arr[i]) {
                start = i;
            }
            if (count != 0 && nums[i] != arr[i]) {
                end = i;
            }
            i++;
        }
        if (start == -1)
            return true;
        for (int j = start; j < end; j++) {
            if (nums[j + 1] > nums[j])
                return false;
        }
        return true;
    }

    // brute force would be to take every possible subarray, and then reverse it,
    // and the check if it is sorted or not
}
