public class LeetCode3532 {
    public static void main(String[] args) {
        boolean[] res1 = pathExistenceQueries(2, new int[] { 1, 3 }, 1, new int[][] {
                { 0, 0 }, { 0, 1 } });
        System.out.println("******************");
        for (boolean res : res1) {
            System.out.println(res + " ");
        }
        System.out.println("******************");
        
        boolean[] res2 = pathExistenceQueries(4, new int[] { 2, 5, 6, 8 }, 2,
                new int[][] { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 2, 3 } });
        for (boolean res : res2) {
            System.out.println(res + " ");
        }
        System.out.println("******************");
        
        boolean[] res3 = pathExistenceQueries(2, new int[] { 2975, 50642 }, 6,
                new int[][] { { 1, 0 } });
        for (boolean res : res3) {
            System.out.println(res + " ");
        }
    }

    public static boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        // Step 1: Build a prefix sum array to count "bad" adjacent differences
        int[] prefixBad = new int[n];
        for (int i = 1; i < n; i++) {
            prefixBad[i] = prefixBad[i - 1]; 
            
            if (Math.abs(nums[i - 1] - nums[i]) > maxDiff) {
                prefixBad[i]++;
            }
        }

        boolean[] res = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            
            int left = Math.min(u, v);
            int right = Math.max(u, v);

            int badEdgesCount = prefixBad[right] - prefixBad[left];
            
            res[i] = (badEdgesCount == 0);
        }

        return res;
    }
}