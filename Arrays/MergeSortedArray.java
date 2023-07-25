package Arrays;

import java.util.Arrays;

public class MergeSortedArray {

    static void optimal3(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i];
                k--;
                i--;
            } else {
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }
    }

    static void optimal2(int[] nums1, int m, int[] nums2, int n) {
        int right = 0;
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[right];
            right++;
        }
        Arrays.sort(nums1);
    }

    static void optimal1(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1;
        int right = 0;
        while (left >= 0 && right < n) {
            if (nums1[left] > nums2[right]) {
                // swap
                int temp = nums1[left];
                nums1[left] = nums2[right];
                nums2[right] = temp;
                left--;
                right++;
            } else {
                break;
            }
        }
        Arrays.sort(nums1, 0, m);
        Arrays.sort(nums2);
        left = m;
        right = 0;
        while (left < m + n) {
            nums1[left] = nums2[right];
            left++;
            right++;
        }
    }

    static void bruteforce(int[] nums1, int[] nums2, int m, int n) {
        // Declare a 3rd array and 2 pointers:
        long[] arr3 = new long[n + m];
        int left = 0;
        int right = 0;
        int index = 0;

        // Insert the elements from the 2 arrays
        // into the 3rd array using left and right
        // pointers:

        while (left < n && right < m) {
            if (nums1[left] <= nums2[right]) {
                arr3[index] = nums1[left];
                left++;
                index++;
            } else {
                arr3[index] = nums2[right];
                right++;
                index++;
            }
        }

        // If right pointer reaches the end:
        while (left < n) {
            arr3[index++] = nums1[left++];
        }

        // If left pointer reaches the end:
        while (right < m) {
            arr3[index++] = nums2[right++];
        }

        // Fill back the elements from arr3[]
        // to nums1[] and nums2[]:
        for (int i = 0; i < n + m; i++) {
            if (i < n) {
                nums1[i] = (int) arr3[i];
            } else {
                nums2[i - n] = (int)arr3[i];
            }
        }

    }
}
