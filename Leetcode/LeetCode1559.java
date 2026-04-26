public class LeetCode1559 {
    public static void main(String[] args) {
        char grid[][] = { { 'a', 'a', 'a', 'a' }, { 'a', 'b', 'b', 'a' }, { 'a', 'b', 'b', 'a' },
                { 'a', 'a', 'a', 'a' } };

        System.out.println("result: " + containsCycle(grid));
    }

    public static boolean containsCycle(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean visited[][] = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
               if (!visited[i][j]) {
                    if (helper(i, j, -1, -1, grid, visited)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean helper(int r, int c, int prevR, int prevC, char[][] grid, boolean visited[][]) {

        visited[r][c] = true;

        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length) {
                if (grid[nr][nc] == grid[r][c]) {
                    if (visited[nr][nc]) {
                        if (nr != prevR || nc != prevC) {
                            return true;
                        }
                    } else {
                        if (helper(nr, nc, r, c, grid, visited)) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

}