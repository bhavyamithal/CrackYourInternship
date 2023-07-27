package Strings;

import java.util.Stack;

public class SimplifyPath {
    static String solution(String path) {
        Stack<String> stack = new Stack<>();
        String[] directory = path.split("/");

        for (String s : directory) {
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!s.equals("") && !s.equals(".")) {
                stack.push(s);
            }
        }
        return "/" + String.join("/", stack);
    }
}
