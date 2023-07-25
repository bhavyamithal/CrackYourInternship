package Arrays;

import java.util.ArrayList;
import java.util.List;

public class ReversePairs {

    // Intuition
    // To get an intuition of merge sort u think basically we have to check how many
    // elements are greater as per some condtion like inversions SO in these kind of
    // problems merge sort can be used beacuase we comapre left subarray which is
    // sorted to right subarray through that we can minimize time complexity beacuse
    // we don't need to chekc all combinations .. That is key thing about merge sort
    // just like it makes sorting in nlogn

    // Approach
    // Just Modified Merge sort only a change in merge function count as per
    // condition rest is same

    // Complexity
    // Time complexity:O(nlogn)
    // Space complexity:O(n)

    public int reversePairs(int[] nums) {
        return mergesort(nums, 0, nums.length - 1);
    }

    public int mergesort(int[] nums, int low, int high) {
        int count = 0;
        if (low >= high)
            return count;
        int mid = (low + high) / 2;
        count += mergesort(nums, low, mid);
        count += mergesort(nums, mid + 1, high);
        count += countpairs(nums, low, mid, high);
        merge(nums, low, mid, high);
        return count;
    }

    public void merge(int[] nums, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (nums[right] < nums[left]) {
                temp.add(nums[right]);
                right++;
            } else {
                temp.add(nums[left]);
                left++;
            }
        }
        while (left <= mid) {
            temp.add(nums[left]);
            left++;
        }
        while (right <= high) {
            temp.add(nums[right]);
            right++;
        }
        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }
    }

    public int countpairs(int[] nums, int low, int mid, int high) {
        int cnt = 0, right = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (right <= high && (double) nums[i] > 2 * (double) nums[right]) {
                right++;
            }
            cnt += right - (mid + 1);
        }
        return cnt;
    }

    // below solution is brute force

    static int bruteforce(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((long) nums[i] > (long) nums[j] * 2) {
                    count++;
                }
            }
        }
        return count;
    }
}
