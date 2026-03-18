public class LeetCode3070 {
    public static void main(String[] args) {
        int[][] grid = { { 9, 9, 3 }, { 1, 1, 7 }, { 8, 4, 6 }, { 10, 3, 2 }, { 2, 3, 3 } };
        System.out.println("result: " + countSubmatrices(grid, 49));
    }

    // public static int countSubmatrices(int[][] grid, int k) {
    // int count = 0;

    // if (grid[0][0] > k)
    // return count;

    // int m = grid.length;
    // int n = grid[0].length;

    // int sum = 0;

    // for (int r = 0; r < m; r++) {
    // sum += grid[r][0];
    // if (sum > k) {
    // break;
    // } else {
    // count++;
    // }
    // }

    // sum = grid[0][0];

    // for (int c = 1; c < n; c++) {
    // sum += grid[0][c];
    // if (sum > k) {
    // break;
    // } else {
    // count++;
    // }
    // }

    // sum = grid[0][0];

    // for (int r = 1; r < m; r++) {
    // for (int c = 1; c < n; c++) {
    // sum += grid[r][c];
    // for (int i = r - 1; i >= 0; i--) {
    // sum += grid[i][c];
    // sum += grid[r][i];
    // }
    // if (sum > k) {
    // break;
    // } else {
    // count++;
    // }
    // }
    // if (sum > k)
    // break;
    // }

    // sum = grid[0][0];
    // for (int r = 1; r < m; r++) {
    // for (int c = 2; c < n; c++) {
    // sum += grid[r][c];
    // for (int i = r - 1; i >= 0; i--) {
    // sum += grid[i][c];
    // }
    // for (int i = c - 1; i >= 0; i--) {
    // sum += grid[r][i];
    // }
    // if (sum > k) {
    // break;
    // } else {
    // count++;
    // }
    // }
    // }
    // for (int c = 2; c < n; c++) {
    // for (int r = 1; r < m; r++) {
    // sum += grid[r][c];
    // for (int i = r - 1; i >= 0; i--) {
    // sum += grid[i][c];
    // }
    // for (int i = c - 1; i >= 0; i--) {
    // sum += grid[r][i];
    // }
    // if (sum > k) {
    // break;
    // } else {
    // count++;
    // }
    // }
    // }

    // return count;
    // }
    public static int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        
        // We can create a prefix sum matrix of the same size
        long[][] prefixSum = new long[m][n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                long currentSum = grid[r][c];

                
                // Add the sum from the top
                if (r > 0) currentSum += prefixSum[r - 1][c];
                // Add the sum from the left
                if (c > 0) currentSum += prefixSum[r][c - 1];
                // Subtract the overlap (diagonal top-left)
                if (r > 0 && c > 0) currentSum -= prefixSum[r - 1][c - 1];

                // Update the prefix sum matrix
                prefixSum[r][c] = currentSum;

                // Check condition
                if (currentSum <= k) {
                    count++;
                } else {
                    // Optimization: If a submatrix starting at (0,0) ends at (r,c) 
                    // and exceeds k, any further submatrix ending in this row (c+1, c+2...) 
                    // will also exceed k because all elements are non-negative.
                    break; 
                }

            }
        }

        return count;
    }
}
