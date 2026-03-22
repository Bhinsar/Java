public class LeetCode3643 {
    public static void main(String args[]) {
        int grid[][] = { { 3,4,2,3}, { 2,3,4,2 } };
        int result[][] = reverseSubmatrix(grid, 0, 2, 2);
        System.out.println("[");
        for (int r = 0; r < result.length; r++) {
            System.out.print("[");
            for (int c = 0; c < result[0].length; c++) {
                System.out.print(result[r][c] + ", ");
            }
            System.out.println("]");

        }
        System.out.println("]");
    }

    public static int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {

            for (int c = y; c < y + k ; c++) {
                int i = x, j = x + k - 1;
                while (i != j & i<j) {
                    int temp = grid[i][c];
                    grid[i][c] = grid[j][c];
                    grid[j][c]= temp;
                    i++;
                    j--;
                }
            }
        

        return grid;
    }
}
