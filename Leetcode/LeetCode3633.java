public class LeetCode3633 {
    public static void main(String[] args) {
        System.out.println(
                "res: " + earliestFinishTime(new int[] { 5 }, new int[] { 3 }, new int[] { 1
                }, new int[] { 10 }));
        System.out.println(
                "res: " + earliestFinishTime(new int[] { 2, 8 }, new int[] { 4, 1 }, new int[] { 6 }, new int[] { 3 }));
    }

    public static int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime,
            int[] waterDuration) {
        int minTotalTime = Integer.MAX_VALUE;
        for (int i = 0; i < landStartTime.length; i++) {
            int landFinish = landStartTime[i] + landDuration[i];

            for (int j = 0; j < waterStartTime.length; j++) {
                int waterFinish = waterStartTime[j] + waterDuration[j];

                // Option 1: Do Land Ride first, then Water Ride
                int waterStartAfterLand = Math.max(waterStartTime[j], landFinish);
                int totalTimeIfLandFirst = waterStartAfterLand + waterDuration[j];

                // Option 2: Do Water Ride first, then Land Ride
                int landStartAfterWater = Math.max(landStartTime[i], waterFinish);
                int totalTimeIfWaterFirst = landStartAfterWater + landDuration[i];

                // Track the absolute minimum finish time encountered
                int bestForThisPair = Math.min(totalTimeIfLandFirst, totalTimeIfWaterFirst);
                minTotalTime = Math.min(minTotalTime, bestForThisPair);
            }
        }

        return minTotalTime;
    }
}
