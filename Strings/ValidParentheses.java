package Strings;

import java.util.Stack;

public class ValidParentheses {
    static boolean method1(String s) {
        Stack<Character> stack = new Stack<>();
        char[] ch = s.toCharArray();

        for (int i = 0; i < ch.length; i++) {

            if (ch[i] == '(' || ch[i] == '{' || ch[i] == '[') {
                stack.push(ch[i]);

            } else {

                if (stack.isEmpty()) {
                    return false;
                }
                if (ch[i] == ')') {
                    if (stack.pop() != '(') {
                        return false;
                    }
                }
                if (ch[i] == ']') {
                    if (stack.pop() != '[') {
                        return false;
                    }
                }
                if (ch[i] == '}') {
                    if (stack.pop() != '{') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
