package MathematicalProblems;

public class MinimumMovesToEqualArrayElements {

    // optimal
    static int optimal(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int min = getMin(nums);
        return sum - (nums[min] * n);        
    }

    static int getMin(int[] nums) {
        int min = nums[0];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                index = i;
            }
        }
        return index;
    }



    // brute force, TLE 
    static int bruteforce(int[] nums) {
        int count = 0;
        while (!allEqual(nums)) {
            int max = getMax(nums);
            increase(nums, max);
            count++;
        }
        return count;
    }

    static void increase(int[] nums, int avoidIndex) {
        for (int i = 0; i < nums.length; i++) {
            if (i != avoidIndex) {
                nums[i] += 1;
            }
        }
    }

    static boolean allEqual(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                return false;
            }
        }
        return true;
    }

    static int getMax(int[] nums) {
        int index = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }

}
