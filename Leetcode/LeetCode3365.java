public class LeetCode3365 {

    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        // int[] nums = { 1,1,1};
        // int q[][] = { { 0,2,1,4} };
        int[] nums = { 2, 3, 1, 5, 4 };
        int q[][] = { { 1, 4, 2, 3 }, { 0, 2, 1, 2 } };
        System.out.println("Result: " + xorAfterQueries(nums, q));
    }

    public static int xorAfterQueries(int[] nums, int[][] queries) {
        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];
            int step = query[2];
            int multiplier = query[3];

            for (int i = start; i <= end && i < nums.length; i += step) {
                nums[i] = (int) (((long) nums[i] * multiplier) % MOD);
            }
        }

        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }

        return result;

    }
}