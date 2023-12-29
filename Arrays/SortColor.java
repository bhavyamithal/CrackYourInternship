package Arrays;

public class SortColor {
    public static void main(String[] args) {

    }

    // Brute force approach would be to just sort the array, but it is not allowed
    // Better approach would be Keeping count of values
    // Optimal approach would be taking 3 pointers and sorting with their help
    // (since we know that there are only 3 elements in the array)

    static void optimal(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;

                mid++;
                low++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;

                high--;
            }
        }
    }

    static void better(int[] nums) {
        int count_0 = 0;
        int count_1 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count_0++;
            } else if (nums[i] == 1) {
                count_1++;
            }
        }


        for (int i = (count_0 + count_1); i < nums.length; i++) {
            nums[i] = 2;
        }
        for (int i = count_0; i < (count_0 + count_1); i++) {
            nums[i] = 1;
        }
        for (int i = 0; i < count_0; i++) {
            nums[i] = 0;
        }
    }
}
