package Arrays;

public class ContainerWithMostWater {

    static int optimal(int[] height) {
        int max_area = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            max_area = Math.max(area, max_area);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max_area;
    }

    static int bruteforce(int[] height) {
        int max_area = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                max_area = Math.max(area, max_area);
            }
        }
        return max_area;
    }
}
