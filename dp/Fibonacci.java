public class Fibonacci {
    public static void main(String args[]) {
        int n = 10;
        int dp[] = new int[n];
        System.out.println("Fibonacci series of 10 elements are:");
        for (int i = 0; i < n; i++) {
            System.out.print(serise(i, dp) + " ");
        }
    }

    public static int serise(int n, int[] dp) {
        if (n <= 1)
            return n;
        
        if (dp[n] != 0)
            return dp[n];
        
        dp[n] = serise(n - 1, dp) + serise(n - 2, dp);
        
        return dp[n];
    }
}