package Arrays;

public class JumpGame {

    // optimal solution : Valley peak approach

    static boolean optimal(int[] nums) {
        int reachable = 0;

        for (int i = 0; i < nums.length; i++) {
            if (reachable < i) {
                return false;
            }
            reachable = Math.max(reachable, i + nums[i]);
        }

        return true;
    }

    // below solution can be optimized with DP, we will come back to this later

    // bruteforce : the below solution uses recursion (TLE)
    static boolean canJump(int[] nums) {
        int index = 0;
        if (helper(nums, index)) {
            return true;
        }
        return false;
    }

    static boolean helper(int[] nums, int index) {
        if (index == nums.length - 1) {
            return true;
        }

        if (nums[index] == 0) {
            return false;
        }

        for (int i = index + 1; i < index + nums[index]; i++) {
            if (helper(nums, i)) {
                return true;
            }
        }

        return false;
    }
}
