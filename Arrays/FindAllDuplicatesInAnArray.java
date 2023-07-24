package Arrays;

import java.util.Arrays;
import java.util.ArrayList;

public class FindAllDuplicatesInAnArray {

    // BruteForce : sort the array, then find duplicates
    // Better : maintain a frequency array, return elements whose frequency is more
    // than 1
    // another approach is to use a HashMap

    static ArrayList<Integer> better(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] freq = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (freq[nums[i] - 1] == 0) {
                freq[nums[i] - 1] = 1;
            } else {
                ans.add(nums[i]);
            }
        }
        return ans;
    }

    static ArrayList<Integer> bruteforce(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                ans.add(nums[i]);
            }
        }
        return ans;
    }
}
