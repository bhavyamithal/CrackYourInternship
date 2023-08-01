package StackAndQueues;

import java.util.Deque;
import java.util.LinkedList;

public class ImplementStackAndQueueUsingDeque {
    class MyStack {
        private Deque<Integer> first;

        public MyStack() {
            first = new LinkedList<>();
        }

        public void push(int x) {
            first.addFirst(x);
        }

        public int pop() {
            return first.removeFirst();
        }

        public int peek() {
            return first.peek();
        }

        public boolean isEmpty() {
            return first.isEmpty();
        }
    }

    class MyQueue {
        private Deque<Integer> first;

        public MyQueue() {
            first = new LinkedList<>();
        }

        public void push(int x) {
            first.addLast(x);
        }

        public int pop() {
            return first.removeFirst();
        }

        public int peek() {
            return first.peekFirst();
        }

        public boolean isEmpty() {
            return first.isEmpty();
        }
    }
}
