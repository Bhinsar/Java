import java.util.Arrays;

public class LeetCode1340 {
    public static void main(String[] args) {
        int arr[] = { 6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12 };
        System.out.println("res: " + maxJumps(arr, 2)); // Expected Output: 4
    }

    public static int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int maxJumps = 0;
        int dp[] = new int[n];
        Arrays.fill(dp, -1); 

        for (int i = 0; i < n; i++) {
            maxJumps = Math.max(maxJumps, dfs(arr, i, d, dp));
        }
        return maxJumps;
    }

    private static int dfs(int[] arr, int i, int d, int[] dp) {
        if (dp[i] != -1) {
            return dp[i];
        }

        int maxFromHere = 1; 

        for (int k = 1; k <= d; k++) {
            int next = i + k;
            if (next >= arr.length || arr[next] >= arr[i]) {
                break; 
            }
            maxFromHere = Math.max(maxFromHere, 1 + dfs(arr, next, d, dp));
        }

        for (int k = 1; k <= d; k++) {
            int next = i - k;
            if (next < 0 || arr[next] >= arr[i]) {
                break; 
            }
            maxFromHere = Math.max(maxFromHere, 1 + dfs(arr, next, d, dp));
        }

        return dp[i] = maxFromHere;
    }
}