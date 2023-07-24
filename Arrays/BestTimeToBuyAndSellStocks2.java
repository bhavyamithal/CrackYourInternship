package Arrays;

public class BestTimeToBuyAndSellStocks2 {

    //other solutions use DP, i'll come back to this later

    static int optimal(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                profit = profit + (prices[i+1] - prices[i]);
            }
        }
        return profit;
    }
}
