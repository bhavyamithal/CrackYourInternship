package Strings;

import java.util.Stack;

public class BasicCaluculatorTwo {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int curr = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                curr = (curr * 10) + (ch - '0');
            }
            if (!Character.isDigit(ch) && ch != ' ' || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(curr);
                } else if (sign == '-') {
                    stack.push(-curr);
                } else if (sign == '*') {
                    stack.push(stack.pop() * curr);
                } else if (sign == '/') {
                    stack.push(stack.pop() / curr);
                }
                sign = ch;
                curr = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans = ans + stack.pop();
        }
        return ans;
    }
}
