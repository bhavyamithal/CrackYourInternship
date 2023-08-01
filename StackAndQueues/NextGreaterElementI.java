package StackAndQueues;

public class NextGreaterElementI {
    // optimal solution requires hashmap, will come back to this later
    // static int[] optimal(int[] nums1, int[] nums2) {
        
    // }

    // for every element in nums1, find its next greater in nums 2 and add it to the
    // ans array
    // TC : O(N square)
    // SC : O(n)
    static int[] bruteforce(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int j = 0;
            while (nums1[i] != nums2[j]) {
                j++;
            }
            boolean valueFound = false;
            for (int k = j + 1; k < nums2.length; k++) {
                if (nums2[j] < nums2[k]) {
                    ans[i] = nums2[k];
                    valueFound = true;
                    break;
                }
            }
            if (!valueFound) {
                ans[i] = -1;
            }
        }
        return ans;
    }
}
