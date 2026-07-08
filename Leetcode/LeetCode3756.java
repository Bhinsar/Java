public class LeetCode3756 {
    public static void main(String[] args) {
        // int res1[] = sumAndMultiply("10203004", new int[][] { { 0, 7 }, { 1, 3 }, { 4, 6 } });
        // System.out.println("res1: ");
        // for (int n : res1) {
        //     System.out.println(n);
        // }
        // int res2[] = sumAndMultiply("1000", new int[][] { { 0, 3 }, { 1, 1 } });
        // System.out.println("res2: ");
        // for (int n : res2) {
        //     System.out.println(n);
        // }
        int res3[] = sumAndMultiply("9876543210", new int[][] { { 0, 9 } }); //output [444444137]
        System.out.println("res3: ");
        for (int n : res3) {
            System.out.println(n);
        }
    }

    public static int[] sumAndMultiply(String s, int[][] queries) {
        final int MOD = 1_000_000_007;
        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long x = 0;
            long sum = 0;

            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                if (s.charAt(j) != '0') {
                    int digit = s.charAt(j) - '0';
                    x = (x * 10 + digit) % MOD;
                    sum = (sum + digit) % MOD;
                }
            }

            ans[i] = (int) ((x * sum) % MOD);
        }

        return ans;
    }
}
