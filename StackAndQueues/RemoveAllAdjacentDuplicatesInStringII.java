package StackAndQueues;

import java.util.ArrayDeque;
import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInStringII {
    // another solution using ArrayDeque, but same approach
    static String sol2(String s, int k) {
        ArrayDeque<Adjacent> st = new ArrayDeque<>(s.length());

        for (char c : s.toCharArray()) {
            if (!st.isEmpty() && c == st.peekLast().ch) {
                st.peekLast().freq++;
            } else {
                st.addLast(new Adjacent(c, 1));
            }
            if (st.peekLast().freq == k) {
                st.removeLast();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Adjacent a : st) {
            sb.append(String.valueOf(a.ch).repeat(a.freq));
        }
        return sb.toString();
    }

    static class Adjacent {
        char ch;
        int freq;

        public Adjacent(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    // below solution is optimal :)
    static String sol(String s, int k) {
        Stack<Object[]> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(new Object[] { ch, 1 });
            } else {
                char top = (char) stack.peek()[0];
                int count = (int) stack.peek()[1];
                if (top == ch) {
                    count++;
                    stack.pop();
                    if (count != k) {
                        stack.push(new Object[] { ch, count });
                    }
                } else {
                    stack.push(new Object[] { ch, 1 });
                }
            }
        }

        String ans = "";

        while (!stack.isEmpty()) {
            char top = (char) stack.peek()[0];
            int count = (int) stack.peek()[1];

            for (int i = 0; i < count; i++) {
                ans = top + ans;
            }

            stack.pop();

        }

        return ans;
    }
}
