package SortingAndSearching;

public class CeilingInASortedArray {
    static int ceiling(int[] nums, int x) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= x)
                return nums[i];
        }
        return -1;
    }
}
