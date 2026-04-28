import java.util.Arrays;

public class LeetCode2033 {
    public static void main(String[] args) {
        int[][] grid = { { 2, 4 }, { 6, 8 } };
        int x = 2;
        System.out.println("result: " + minOperations(grid, x));
    }

    public static int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int[] flattened = new int[m * n];

        int index = 0;
        for (int[] row : grid) {
            for (int val : row) {
                flattened[index++] = val;
            }
        }

        Arrays.sort(flattened);

        int mid = flattened[(flattened.length - 1) / 2];

        int numberOfOperations = 0;

        int rem = flattened[0] % x;
        
        for (int num : flattened) {
            if (num % x != rem) {
                return -1;
            }
            numberOfOperations += Math.abs(num - mid) / x;

        }
        return numberOfOperations;
    }
}
