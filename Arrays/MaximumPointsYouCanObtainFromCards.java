package Arrays;

public class MaximumPointsYouCanObtainFromCards {

    // 1, 2, 3, 4, 5, 6, 1
    // k = 3
    // Sliding window approach

    static int bruteforce(int[] cardPoints, int k) {
        int l = 0, r = (cardPoints.length - k);
        int total = 0;
        for (int i = r; i < cardPoints.length; i++) {
            total += cardPoints[i];
        }
        int result = total;
        while (r < cardPoints.length) {
            total = total + cardPoints[l] - cardPoints[r];
            result = Math.max(result, total);
            l++;
            r++;
        }
        return result;
    }
}
