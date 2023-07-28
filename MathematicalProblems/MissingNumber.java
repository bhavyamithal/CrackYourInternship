package MathematicalProblems;

public class MissingNumber {
    // other trick method
    static int method2(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        int n = nums.length;
        int total = n * (n + 1) / 2;
        return total - sum;
    }

    // solve by cyclic sort
    static int missingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i];
            if (nums[i] != nums.length && nums[i] != nums[correct]) {
                swap(nums, correct, i);
            } else {
                i++;
            }
        }
        i = 0;
        while (i < nums.length) {
            if (nums[i] != i) {
                return i;
            }
            i++;
        }
        return nums.length;
    }

    static void swap(int[] arr, int i, int j) {
        // swap
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
