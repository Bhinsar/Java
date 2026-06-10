public class LeetCode3689 {
    public static void main(String[] args) {
        // System.out.println("res1 : " + maxTotalValue(new int[] { 1, 3, 2 }, 2));
        // System.out.println("res2 : " + maxTotalValue(new int[] { 4, 2, 5, 1 }, 3));
        System.out.println("res3 : "
                + maxTotalValue(new int[] { 701025805, 484014287, 486484825, 479659005, 127752519, 497392660, 905035207,
                        885813233, 36336196, 83624455, 562558760, 504283643, 414557507, 340461196, 75269772, 787067318,
                        310705037, 994901461, 509673195, 908722607, 69228965, 239220571, 719440526, 986897320 }, 78));
    }

    public static long maxTotalValue(int[] nums, int k) {

        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }

        return k * ((long) max - min);
    }
}
