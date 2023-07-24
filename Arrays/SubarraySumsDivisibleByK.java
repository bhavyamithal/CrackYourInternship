package Arrays;

public class SubarraySumsDivisibleByK {

    // the optimal solution implements hashmap, i'll come back to this later
    
    // static int optimal(int[] nums, int k) {

    // }

    static int bruteforce(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum % k == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
