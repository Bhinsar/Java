import java.util.TreeSet;

class LeetCode1878 {
    public static void main(String[] args) {
        int[][] arr = { { 3, 4, 5, }, { 3, 3, 4 }, { 20, 30, 200} };
        int []result = getBiggestThree(arr); 
        System.out.println("result: ");
        for (int res : result) {
            System.out.println(res);
        }
    }

    public static int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // Use TreeSet to keep unique sums and maintain order
        TreeSet<Integer> sums = new TreeSet<>();

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                // Case: Radius 0 (just the single cell)
                sums.add(grid[r][c]);

                // Case: Radius q > 0
                for (int q = 1; r - q >= 0 && r + q < m && c - q >= 0 && c + q < n; q++) {
                    int currentSum = 0;

                    // Traverse the four edges of the rhombus
                    // We move q steps for each of the 4 sides
                    for (int i = 0; i < q; i++) {
                        currentSum += grid[r - q + i][c + i]; // Top to Right
                        currentSum += grid[r + i][c + q - i]; // Right to Bottom
                        currentSum += grid[r + q - i][c - i]; // Bottom to Left
                        currentSum += grid[r - i][c - q + i]; // Left to Top
                    }
                    sums.add(currentSum);
                }

                // Optimization: Keep only the top 3 elements in the set to save space
                while (sums.size() > 3) {
                    sums.pollFirst(); // Removes the smallest element
                }
            }
        }

        // Convert the TreeSet to an array in descending order
        int[] result = new int[sums.size()];
        int idx = sums.size() - 1;
        for (int val : sums) {
            result[idx--] = val;
        }
        return result;

    }
}