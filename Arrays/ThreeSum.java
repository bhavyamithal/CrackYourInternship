package Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class ThreeSum {

    // So, we essentially need to find three numbers x, y, and z such that they add
    // up to the given value. If we fix one of the numbers say x, we are left with
    // the two-sum problem at hand!
    // For the two-sum problem, if we fix one of the numbers, say x, we have to scan
    // the entire array to find the next number y, which is value - x where value is
    // the input parameter. Can we change our array somehow so that this search
    // becomes faster?

    static List<List<Integer>> better(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int target = -nums[i];
                int sum = nums[j] + nums[k];
                if (sum < target) {
                    j++;
                } else if (sum > target) {
                    k--;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ans.add(list);
                    j++;
                    k--;
                    // skip duplicates for j
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    // skip duplicates for k
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
            // skip duplicates for i
            while (i < nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return ans;
    }

    static ArrayList<ArrayList<Integer>> bruteforce(int[] nums) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        int i, j, k;
        for (i = 0; i < nums.length - 2; i++) {
            for (j = i + 1; j < nums.length - 1; j++) {
                for (k = j + 1; k < nums.length; k++) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                    }
                    if (temp.size() != 0)
                        ans.add(temp);
                }
            }
        }

        return ans;
    }
}
