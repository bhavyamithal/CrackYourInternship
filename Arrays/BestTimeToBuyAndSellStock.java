package Arrays;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] arr = { 7, 1, 5, 3, 6, 4 };
        System.out.println(bruteforce(arr));
        System.out.println(optimal(arr));
    }

    static int optimal(int[] prices) {
        int maxProfit = 0;

        int minSoFar = prices[0];

        for (int i = 0; i < prices.length; i++) {
            minSoFar = Math.min(minSoFar, prices[i]);
            int profit = prices[i] - minSoFar;
            maxProfit = Math.max(profit, maxProfit);
        }

        return maxProfit;
    }

    static int bruteforce(int[] prices) {
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }
}
