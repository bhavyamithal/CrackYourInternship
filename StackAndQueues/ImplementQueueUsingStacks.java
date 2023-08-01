package StackAndQueues;

import java.util.Stack;

public class ImplementQueueUsingStacks {
    class MyQueue {
        private Stack<Integer> first;
        private Stack<Integer> second;

        public MyQueue() {
            first = new Stack<>();
            second = new Stack<>();
        }

        public void push(int x) {
            first.push(x);
        }

        public int pop() {
            while (!first.isEmpty()) {
                second.push(first.pop());
            }
            int n = second.pop();
            while (!second.isEmpty()) {
                first.push(second.pop());
            }
            return n;
        }

        public int peek() {
            while (!first.isEmpty()) {
                second.push(first.pop());
            }
            int n = second.peek();
            while (!second.isEmpty()) {
                first.push(second.pop());
            }
            return n;
        }

        public boolean empty() {
            return first.isEmpty();
        }
    }
}
