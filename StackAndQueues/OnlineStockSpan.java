package StackAndQueues;

import java.util.ArrayList;
import java.util.Stack;

public class OnlineStockSpan {
    // https://www.youtube.com/watch?v=jtOWh4pfmYM
    class StockSpannerOptimal {

        private Stack<int[]> stack;

        public StockSpannerOptimal() {
            stack = new Stack<>();
        }

        public int next(int price) {
            int span = 1;

            while (!stack.isEmpty() && stack.peek()[0] <= price) {
                span += stack.pop()[1];
            }

            stack.push(new int[] { price, span });

            return span;
        }
    }

    class StockSpannerArrayList {

        private ArrayList<Integer> list;

        public StockSpannerArrayList() {
            list = new ArrayList<>();
        }

        public int next(int price) {
            int span = 0;

            list.add(price);
            int last = list.size() - 1;

            for (int i = last; i >= 0; i--) {
                if (list.get(i) <= price) {
                    span++;
                } else {
                    break;
                }
            }

            return span;
        }
    }

    // Time Limit Exceeded
    class StockSpannerTwoStacks {

        private Stack<Integer> first;
        private Stack<Integer> second;

        public StockSpannerTwoStacks() {
            first = new Stack<>();
            second = new Stack<>();
        }

        public int next(int price) {
            int span = 0;
            first.push(price);

            while (!first.isEmpty() && first.peek() <= price) {
                second.push(first.pop());
                span++;
            }

            while (!second.isEmpty()) {
                first.push(second.pop());
            }

            return span;
        }
    }
}
