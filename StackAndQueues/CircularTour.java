package StackAndQueues;

public class CircularTour {
    static int optimal(int[] petrol, int[] distance) {
        int start = 0;
        int extraFuel = 0;
        int requiredFuel = 0;
        for (int i = 0; i < petrol.length; i++) {
            extraFuel += petrol[i] - distance[i];
            if (extraFuel < 0) {
                start = i + 1;
                requiredFuel += extraFuel;
                extraFuel = 0;
            }
        }
        if (requiredFuel + extraFuel >= 0)
            return start;
        return -1;
    }
}
