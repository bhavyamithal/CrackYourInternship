package StackAndQueues;

import java.util.Stack;

public class EvaluationOfPostFixExpression {
    static int sol(String S) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            } else {
                int n1 = stack.pop();
                int n2 = stack.pop();
                if (ch == '+') {
                    stack.push(n1 + n2);
                } else if (ch == '-') {
                    stack.push(n2 - n1);
                } else if (ch == '*') {
                    stack.push(n1 * n2);
                } else if (ch == '/') {
                    stack.push(n2 / n1);
                }
            }
        }
        return stack.pop();
    }
}
