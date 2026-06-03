public class LeetCode3635 {
    public static void main(String[] args) {
        System.out.println(
                "res: " + earliestFinishTime(new int[] { 5 }, new int[] { 3 }, new int[] { 1
                }, new int[] { 10 }));
        System.out.println(
                "res: " + earliestFinishTime(new int[] { 2, 8 }, new int[] { 4, 1 }, new int[] { 6 }, new int[] { 3 }));
    }

    public static int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        // Case 1: Land ride first, then Water ride
        int landFirst = calculateOrderTime(landStartTime, landDuration, waterStartTime, waterDuration);

        // Case 2: Water ride first, then Land ride
        int waterFirst = calculateOrderTime(waterStartTime, waterDuration, landStartTime, landDuration);

        // The result is the absolute minimum of both sequence strategies
        return Math.min(landFirst, waterFirst);
    }

    private static int calculateOrderTime(int[] firstStart, int[] firstDuration, int[] secondStart, int[] secondDuration) {
        // Step 1: Find the absolute earliest time we can finish ANY ride of the first
        // category
        int minFirstEnd = Integer.MAX_VALUE;
        for (int i = 0; i < firstStart.length; i++) {
            minFirstEnd = Math.min(minFirstEnd, firstStart[i] + firstDuration[i]);
        }

        // Step 2: Find the earliest finish time for the second ride category based on
        // that head start
        int minTotalEnd = Integer.MAX_VALUE;
        for (int j = 0; j < secondStart.length; j++) {
            int actualStart = Math.max(secondStart[j], minFirstEnd);
            int currentTotalEnd = actualStart + secondDuration[j];
            minTotalEnd = Math.min(minTotalEnd, currentTotalEnd);
        }

        return minTotalEnd;
    }

}