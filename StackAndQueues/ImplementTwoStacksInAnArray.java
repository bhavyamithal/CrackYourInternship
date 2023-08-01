package StackAndQueues;

public class ImplementTwoStacksInAnArray {
    class TwoStacks {
        int[] arr;
        int size;
        int top1, top2;

        public TwoStacks() {
            size = 100;
            arr = new int[100];
            top1 = -1;
            top2 = size;
        }

        public void push1(int x) {
            top1++;
            arr[top1] = x;
        }

        public void push2(int x) {
            top2--;
            arr[top2] = x;
        }

        public int pop1() {
            if (top1 == -1)
                return -1;
            int popped = arr[top1];
            top1--;
            return popped;
        }

        public int pop2() {
            if (top2 == size)
                return -1;
            int popped = arr[top2];
            top2++;
            return popped;
        }
    }
}
