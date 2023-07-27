package Strings;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        System.out.println(method1(3));
    }


    static List<String> method1(int n) {
        return helper("", 0, 0, n, 2 * n);
    }

    static ArrayList<String> helper(String p, int open, int close, int n, int steps) {
        if (steps == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> left = new ArrayList<>();
        ArrayList<String> right = new ArrayList<>();

        if (open < n) {
            left = helper(p + '(', open + 1, close, n, steps - 1);
        }
        if (close < n && close < open) {
            right = helper(p + ')', open, close + 1, n, steps - 1);
        }

        left.addAll(right);

        return left;
    }
}
