package StackAndQueues;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
    class MyStack {
        private Queue<Integer> first;
        private Queue<Integer> second;

        public MyStack() {
            first = new LinkedList<>();
            second = new LinkedList<>();
        }

        public void push(int x) {
            second.add(x);
            while (!first.isEmpty()) {
                second.add(first.remove());
            }
            while (!second.isEmpty()) {
                first.add(second.remove());
            }
        }

        public int pop() {
            return first.remove();
        }

        public int top() {
            return first.peek();
        }

        public boolean empty() {
            return first.isEmpty();
        }
    }
}
