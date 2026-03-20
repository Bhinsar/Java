
import java.util.Iterator;
import java.util.TreeSet;

public class LeetCode3567 {
    public static void main(String[] args) {
        int[][] grid = { { 1, 8 }, { 3, -2 } };
        int[][] result = minAbsDiff(grid, 2);

        System.out.println("result: ");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.println(result[i][j]);
            }
        }
    }

    public static int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] result = new int[m - k + 1][n - k + 1];

        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                TreeSet<Integer> orderSet = new TreeSet<>();
                for (int r = i; r < i + k; r++) {
                    for (int c = j; c < j + k; c++) {
                        orderSet.add(grid[r][c]);
                    }
                }

                if (orderSet.size() == 1) {
                    result[i][j] = 0;
                    continue;
                }

                int min = Integer.MAX_VALUE;
                if (orderSet.size() >= 2) {
                    Iterator<Integer> it = orderSet.iterator();

                    int prev = it.next();

                    while (it.hasNext()) {
                        int curr = it.next();
                        min = Math.min(min, curr - prev);
                        prev = curr;
                    }
                }
                result[i][j] = min;
            }
        }

        return result;
    }
}
