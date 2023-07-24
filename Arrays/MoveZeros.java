package Arrays;

import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        int[] arr = { 0, 1, 0, 3, 12 };
        bruteforce(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void optimal(int[] nums) {
        // TC : O(N)
        // SC : O(1)
        int j = -1;
        for (int n = 0; n < nums.length; n++) {
            if (nums[n] == 0) {
                j = n;
                break;
            }
        }
        if (j == -1) {
            return;
        }
        for (int i = j + 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                // swap
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }

    static void bruteforce(int[] nums) {
        // TC : O(N)
        // SC : O(N)
        int[] arr = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                arr[index] = nums[i];
                index++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }
    }
}
