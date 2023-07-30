package SortingAndSearching;

public class ProductArrayPuzzle {
    // An approach using prefix and suffix multiplication: Create two extra space,
    // i.e. two extra arrays to store the product of all the array elements from
    // start, up to that index and another array to store the product of all the
    // array elements from the end of the array to that index.
    // To get the product excluding that index, multiply the prefix product up to
    // index i-1 with the suffix product up to index i+1.
    // TC : N
    // SC : N
    static long[] optimal(int[] nums, int n) {
        // Without using '/' operator
        long[] prefix = new long[n];
        long[] suffix = new long[n];
        long[] prod = new long[n];

        prefix[0] = 1;
        suffix[n - 1] = 1;

        // calc prefix product
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        // calc suffix product
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }
        // update prod array
        for (int i = 0; i < n; i++) {
            prod[i] = prefix[i] * suffix[i];
        }
        return prod;
    }

    // brute force, as in the problem, we can't use / operator
    // TC : N
    // SC : N (for return array)
    static long[] bruteforce(int[] nums, int n) {
        // find product of all elements
        // if 0 appears more than once, all elements would be 0
        // if 0 appears exactly once, all elements except that one would be 0

        long allProduct = 1;
        int zeroCount = 0;
        int zeroIndex = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                allProduct = allProduct * nums[i];
            } else {
                zeroCount++;
                zeroIndex = i;
            }
        }

        if (zeroCount > 1) {
            return new long[n];
        }

        long[] prod = new long[n];

        if (zeroCount == 1) {
            prod[zeroIndex] = allProduct;
            return prod;
        }

        for (int i = 0; i < n; i++) {
            prod[i] = allProduct / nums[i];
        }

        return prod;
    }
}
