package MathematicalProblems;

public class HapyNumber {
    static boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = sum(slow);
            fast = sum(fast);
            fast = sum(fast);
            if (fast == 1) return true;
        } while (slow != fast);
        return false;
    }

    static int sum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += (int) Math.pow(digit, 2);
            n /= 10;
        }
        return sum;
    }
}
