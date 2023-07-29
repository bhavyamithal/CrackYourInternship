package MathematicalProblems;

public class ReverseInteger {
    static int reverse(int x) {
        int MIN = Integer.MIN_VALUE;
        int MAX = Integer.MAX_VALUE;

        int reverse = 0;

        while (x > 0) {
            int digit = x % 10;
            x /= 10;

            if (reverse > (MAX / 10) || (reverse == MAX / 10 && digit >= MAX % 10)) {
                return 0;
            }
            if (reverse < (MIN / 10) || (reverse == MIN / 10 && digit <= MIN % 10)) {
                return 0;
            }

            reverse = reverse * 10 + digit;
        }

        return reverse;
    }
}
