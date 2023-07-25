package Arrays;

public class MajorityElement {

    // moore's voting algo
    static int optimal(int[] nums) {
        int count = 0;
        int element = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == element) {
                count++;
            } else {
                if (count == 0) {
                    element = nums[i];
                    count++;
                } else {
                    count--;
                }
            }
        }
        return element;
    }

    static int bruteforce(int[] nums) {
        int maxCount = 0;
        int element = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }

            if (count > maxCount) {
                element = nums[i];
                maxCount = count;
            }
        }
        return element;
    }
}
