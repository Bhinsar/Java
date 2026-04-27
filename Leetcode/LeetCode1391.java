import java.util.HashMap;
import java.util.Map;

public class LeetCode1391 {
    public static void main(String[] args) {
        int grid[][] = { { 2, 4, 3 }, { 6, 5, 2 } };
        System.out.println("result: " + hasValidPath(grid));
    }

    private static final Map<Integer, int[][]> directions = new HashMap<>();

    static {
        directions.put(1, new int[][] { { 0, -1 }, { 0, 1 } }); // Left, Right
        directions.put(2, new int[][] { { 1, 0 }, { -1, 0 } }); // Down, Up
        directions.put(3, new int[][] { { 0, -1 }, { 1, 0 } }); // Left, Down
        directions.put(4, new int[][] { { 0, 1 }, { 1, 0 } }); // Right, Down
        directions.put(5, new int[][] { { 0, -1 }, { -1, 0 } }); // Left, Up
        directions.put(6, new int[][] { { 0, 1 }, { -1, 0 } }); // Right, Up
    }

    public static boolean hasValidPath(int[][] grid) {
        boolean visited[][] = new boolean[grid.length][grid[0].length];

        return helper(0, 0, grid, visited);
    }

    public static boolean helper(int r, int c, int[][] grid, boolean visited[][]) {
        if (r == grid.length - 1 && c == grid[0].length - 1) return true;

        visited[r][c] = true;

        for (int[] dir : directions.get(grid[r][c])) {
            int newR = r + dir[0];
            int newC = c + dir[1]; 

            if (newR >= 0 && newR < grid.length && newC >= 0 && newC < grid[0].length && !visited[newR][newC]) {
                
                for (int[] backDir : directions.get(grid[newR][newC])) {
                    if (newR + backDir[0] == r && newC + backDir[1] == c) {
                        if (helper(newR, newC, grid, visited)) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;

    }
}
