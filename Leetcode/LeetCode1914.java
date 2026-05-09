
import java.util.ArrayList;
import java.util.List;

public class LeetCode1914 {
    public static void main(String[] args) {
        int[][] grid = { { 40, 10 }, { 30, 20 } };

        rotateGrid(grid, 1);

        System.out.println("Resulting Grid:");
        for (int[] row : grid) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int numLayers = Math.min(m, n) / 2;

        for (int layer = 0; layer < numLayers; layer++) {
            int top = layer, left = layer;
            int bottom = m - layer - 1, right = n - layer - 1;
            List<Integer> elements = new ArrayList<>();

            for (int j = left; j <= right; j++) {
                elements.add(grid[top][j]);
            }
            for (int j = top + 1; j <= bottom; j++) {
                elements.add(grid[j][right]);
            }
            for (int j = right - 1; j >= left; j--) {
                elements.add(grid[bottom][j]);
            }
            for (int j = bottom - 1; j >= top + 1; j--) {
                elements.add(grid[j][left]);
            }

            int listSize = elements.size();
            int startIdx = k % listSize;

            for (int j = left; j <= right; j++)
                grid[top][j] = elements.get(startIdx ++ % listSize);
            for (int i = top + 1; i <= bottom; i++)
                grid[i][right] = elements.get(startIdx++ % listSize);
            for (int j = right - 1; j >= left; j--)
                grid[bottom][j] = elements.get(startIdx++ % listSize);
            for (int i = bottom - 1; i > top; i--)
                grid[i][left] = elements.get(startIdx++ % listSize);
        }
        return grid;
    }
}