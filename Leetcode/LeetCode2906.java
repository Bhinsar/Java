public class LeetCode2906 {
    public static void main(String[] args) {
        // int grid[][] = { { 1, 2 }, { 3, 4 } };
        int grid[][] = { { 4, 3, 9 }, { 3, 9, 10 }, { 9, 7, 8 }, { 8, 4, 7 }, { 6, 1, 3 } };
        int result[][] = constructProductMatrix(grid);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.println(result[i][j]);
            }
        }
    }

    public static int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int result[][] = new int[m][n];

        Long suffix = 1L;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                result[i][j] = (int) (suffix % 12345);
                suffix = (suffix * grid[i][j]) % 12345;
            }
        }
        Long prefix = 1L;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = (int) (prefix * result[i][j]) % 12345;
                prefix = (prefix * grid[i][j]) % 12345;
            }
        }

        return result;
    }
}
