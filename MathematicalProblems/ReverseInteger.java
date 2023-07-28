package MathematicalProblems;

public class ReverseInteger {
    static int reverse(int x) {
        int dup = x;
        int reverse = 0;
        if (x < 0) {
            x = -1 * x;
        }
        while (x > 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        if (dup < 0) {
            reverse = -1 * reverse;
        }
        return reverse;
    }
}
