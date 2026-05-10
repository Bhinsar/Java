public class LeetCode2770 {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 6, 4, 1, 2 };
        // int[] nums = { 1, 0, 2 };
        System.out.println("res: " + maximumJumps(nums, 2));
    }

    public static int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }

        dp[0] = 0;

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (dp[i] != -1 && Math.abs(nums[j] - nums[i]) <= target) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }

        return dp[n - 1];
    }
}
