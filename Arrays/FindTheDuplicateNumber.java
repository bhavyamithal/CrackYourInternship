package Arrays;

public class FindTheDuplicateNumber {
    public static void main(String[] args) {

    }
    // Use Sorting and the check if any number is repeated but Can not modify the
    // array
    // Use a frequency array, but can not use extra space
    // compare all elements (nested for loop) but TLE
    // Optimal - Linked List cycle method (fast and slow pointers), just like
    // finding the start of a cycle in a LL question

    static int optimal(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (fast != slow);

        fast = nums[0];
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    static int bruteforce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }
}
