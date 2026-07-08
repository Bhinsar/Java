public class LeetCode3756 {
    public static void main(String[] args) {
        int res1[] = sumAndMultiply("10203004", new int[][] { { 0, 7 }, { 1, 3 }, { 4, 6 } });
        System.out.println("res1: ");
        for (int n : res1) {
            System.out.println(n);
        }
        int res2[] = sumAndMultiply("1000", new int[][] { { 0, 3 }, { 1, 1 } });
        System.out.println("res2: ");
        for (int n : res2) {
            System.out.println(n);
        }
    }

    public static int[] sumAndMultiply(String s, int[][] queries) {

        int ans[] = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int x = 0;
            int sum = 0;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                if (s.charAt(j) != '0') {
                    x = (int) s.charAt(j) + x * 10;
                    sum = (int) s.charAt(j) + sum;
                }
            }
            ans[i] = x * sum;
        }
        return ans;
    }
}
