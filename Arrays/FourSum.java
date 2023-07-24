package Arrays;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {
    static List<List<Integer>> optimal(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int i, j;
        for (i = 0; i < (nums.length - 3); i++) {
            for (j = i + 1; j < (nums.length - 2); j++) {
                int k = j + 1, l = nums.length - 1;
                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum < target) {
                        k++;
                    } else if (sum > target) {
                        l--;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);
                        ans.add(list);
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }
                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }
                    }
                }
                while (j < (nums.length - 2) && nums[j] == nums[j + 1]) {
                    j++;
                }
            }
            while (i < (nums.length - 3) && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        return ans;
    }
}
