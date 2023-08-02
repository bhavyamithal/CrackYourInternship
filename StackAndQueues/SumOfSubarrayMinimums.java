package StackAndQueues;

// import java.util.ArrayList;
import java.util.Stack;

public class SumOfSubarrayMinimums {
    // optimal solution
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;

        // NSL - Next Smallest Left (index)
        // NSR - Next Smallest Right (index)
        int[] NSL = getNSL(arr, n);
        int[] NSR = getNSR(arr, n);

        long sum = 0;
        int N = (int) (Math.pow(10, 9)) + 7;

        for (int i = 0; i < n; i++) {
            long ls = i - NSL[i]; // # of elements on left, which are smaller than current
            long rs = NSR[i] - i; // # of elements on right, which are smaller than current

            long totalWays = ls * rs; // total # of subarrays, whose minimum element is current

            long totalSum = arr[i] * totalWays;

            sum = (sum + totalSum) % N;
        }

        return (int) sum;

    }

    public int[] getNSL(int[] arr, int n) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            if (st.isEmpty()) {
                result[i] = -1;
            } else {
                while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                    st.pop();
                }

                if (st.isEmpty()) {
                    result[i] = -1;
                } else {
                    result[i] = st.peek();
                }
            }

            st.push(i);
        }

        return result;
    }

    public int[] getNSR(int[] arr, int n) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            if (st.isEmpty()) {
                result[i] = n;
            } else {
                while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                    st.pop();
                }

                if (st.isEmpty()) {
                    result[i] = n;
                } else {
                    result[i] = st.peek();
                }
            }

            st.push(i);

        }

        return result;

    }

    // TLE
    static int bruteforce(int[] arr) {
        int N = (int) (Math.pow(10, 9)) + 7;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int min = findMin(i, j, arr);
                sum = (sum % N + min % N) % N;
            }
        }
        return sum;
    }

    static int findMin(int i, int j, int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            min = Math.min(min, arr[k]);
        }
        return min;
    }

}
