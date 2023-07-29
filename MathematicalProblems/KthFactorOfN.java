package MathematicalProblems;

public class KthFactorOfN {
    // optimal
    static int sol2(int n, int k) {
        int factor;
        for (factor = 1; factor * factor < n; factor++) {
            if (n % factor == 0 && --k == 0) {
                return factor;
            }
        }
        for (factor = (int) Math.sqrt(n); factor >= 1; --factor) {
            if (n % (n / factor) == 0 && --k == 0) {
                return n / factor;
            }
        }
        return -1;

    }

    // bruteforce
    static int solution1(int n, int k) {
        int factor = 1;
        while (factor <= n) {
            if (n % factor == 0) {
                k--;
            }
            if (k == 0)
                return factor;
            factor++;
        }
        return -1;
    }
}
