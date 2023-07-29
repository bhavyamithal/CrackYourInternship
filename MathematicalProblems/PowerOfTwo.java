package MathematicalProblems;

public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println((Math.log(536870912) / Math.log(2)));
    }
    static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
