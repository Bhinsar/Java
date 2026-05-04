import java.util.Arrays;

public class MaxLoot {
    public static void main(String[] args) {
        int arr[] = { 10, 20, 5, 2 };
        int dp[] = new int[arr.length];
        Arrays.fill(dp, -1);
        System.out.print("result: " + findMaxSum(arr, 0, dp));
    }

    public static int findMaxSum(int arr[], int idx, int[] dp) {
        if (idx >= arr.length)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];
        int steal = arr[idx] + findMaxSum(arr, idx + 2, dp);
        int skip = findMaxSum(arr, idx + 1, dp);
        
        System.out.println("idx: " + idx + " skip: " + skip + " steal: " + steal);
        if(skip == 0){
            return dp[idx] = steal;
        }
        return dp[idx] = Math.min(steal, skip);
    }
}
