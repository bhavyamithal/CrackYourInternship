package MathematicalProblems;

public class PalindromeNumber {
    // without converting to string
    static boolean solution(int x) {
        if (x < 0) {
            return false;
        }
        int dup = x;
        int rev = 0;
        while (x != 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return rev == dup;
    }

    static boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
