import java.util.Arrays;

public class LeetCode3129 {
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        System.out.println("result: " + numberOfStableArrays(534, 587, 394));
    }

    public static int numberOfStableArrays(int zero, int one, int limit) {
        // memo[zeros][ones][lastBit]
        int[][][] memo = new int[zero + 1][one + 1][2];
        for (int[][] row : memo) {
            for (int[] col : row)
                Arrays.fill(col, -1);
        }

        // // We can start with a 0 or start with a 1
        // System.out.println("solve with 0: "+ solve(zero, one, limit, 0, memo));
        // System.out.println("solve with 1: "+ solve(zero, one, limit, 1, memo));

        long total = (solve(zero, one, limit, 0, memo) + solve(zero, one, limit, 1, memo)) % MOD;
        return (int) total;
    }

    private static int solve(int z, int o, int limit, int last, int[][][] memo) {
        if (z == 0 && o == 0)
            return 1;
        if (memo[z][o][last] != -1) {
            // System.out.println("returning");
            // for (int i = 0; i < memo.length; i++) {
            //     System.out.println("Layer " + i + ":");
            //     for (int j = 0; j < memo[i].length; j++) {
            //         System.out.println(Arrays.toString(memo[i][j]));
            //     }
            //     System.out.println();
            // }

            return memo[z][o][last];
        }

        long count = 0;
        if (last == 0) { // We want to place a block of zeros
            // System.out.println("when last was 0");
            // for (int i = 0; i < memo.length; i++) {
            //     System.out.println("Layer " + i + ":");
            //     for (int j = 0; j < memo[i].length; j++) {
            //         System.out.println(Arrays.toString(memo[i][j]));
            //     }
            //     System.out.println();
            // }
            for (int i = 1; i <= Math.min(z, limit); i++) {
                count = (count + solve(z - i, o, limit, 1, memo)) % MOD;
            }
        } else { // We want to place a block of ones
            // System.out.println("when last was 1");
            // for (int i = 0; i < memo.length; i++) {
            //     System.out.println("Layer " + i + ":");
            //     for (int j = 0; j < memo[i].length; j++) {
            //         System.out.println(Arrays.toString(memo[i][j]));
            //     }
            //     System.out.println();
            // }

            for (int i = 1; i <= Math.min(o, limit); i++) {
                count = (count + solve(z, o - i, limit, 0, memo)) % MOD;
            }
        }
        // System.out.println(memo[z][o][last]);
        // System.out.println(count);
        return memo[z][o][last] = (int) count;
    }
}