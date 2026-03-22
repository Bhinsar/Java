public class LeetCode1886 {
    public static void main(String[] args) {
        int mat[][] = { { 0, 1 }, { 1, 0 } };
        int tag[][] = { { 1, 0 }, { 0, 1 } };

        System.out.println("result: " + findRotation(mat, tag));

    }

    public static boolean findRotation(int[][] mat, int[][] target) {

        for (int rot = 0; rot < 3; rot++) {

            if (isEqual(mat, target)) {
                return true;
            }

            rotate(mat);
        }

        return false;

    }

     public static boolean isEqual(int[][] mat, int[][] target) {
        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[0].length; c++) {
                if (mat[r][c] != target[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void rotate(int[][] grid) {
        int n = grid.length;

        // Step 1: Transpose
        for (int r = 0; r < n; r++) {
            for (int c = r; c < n; c++) {
                int temp = grid[r][c];
                grid[r][c] = grid[c][r];
                grid[c][r] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n / 2; c++) {
                int temp = grid[r][c];
                grid[r][c] = grid[r][n - 1 - c];
                grid[r][n - 1 - c] = temp;
            }
        }

    }
}
