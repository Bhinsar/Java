class LeetCode3212 {
    public static void main(String[] args) {
        char grid[][] = { { 'X', 'X' }, { 'X', 'Y' } };
        System.out.println("result: " + numberOfSubmatrices(grid));
    }

    public static int numberOfSubmatrices(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] cumCountX = new int[m][n];
        int[][] cumCountY = new int[m][n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 'X') {
                    int currentSumX = 1;
                    int currentSumY = 0;
                    if (r > 0) {
                        currentSumX += cumCountX[r - 1][c];
                        currentSumY += cumCountY[r - 1][c];
                    }
                    if (c > 0) {
                        currentSumX += cumCountX[r][c - 1];
                        currentSumY += cumCountY[r][c - 1];
                    }
                    if (r > 0 && c > 0) {
                        currentSumX -= cumCountX[r - 1][c - 1];
                        currentSumY -= cumCountY[r - 1][c - 1];
                    }

                    cumCountX[r][c] = currentSumX;
                    cumCountY[r][c] = currentSumY;

                } else if (grid[r][c] == 'Y') {
                    int currentSumY = 1;
                    int currentSumX = 0;
                    if (r > 0) {
                        currentSumX += cumCountX[r - 1][c];
                        currentSumY += cumCountY[r - 1][c];
                    }
                    if (c > 0) {

                        currentSumX += cumCountX[r][c - 1];
                        currentSumY += cumCountY[r][c - 1];
                    }
                    if (r > 0 && c > 0) {
                        currentSumX -= cumCountX[r - 1][c - 1];
                        currentSumY -= cumCountY[r - 1][c - 1];
                    }

                    cumCountX[r][c] = currentSumX;
                    cumCountY[r][c] = currentSumY;

                } else {
                    int currentSumY = 0;
                    int currentSumX = 0;
                    if (r > 0) {
                        currentSumX += cumCountX[r - 1][c];
                        currentSumY += cumCountY[r - 1][c];
                    }
                    if (c > 0) {

                        currentSumX += cumCountX[r][c - 1];
                        currentSumY += cumCountY[r][c - 1];
                    }
                    if (r > 0 && c > 0) {
                        currentSumX -= cumCountX[r - 1][c - 1];
                        currentSumY -= cumCountY[r - 1][c - 1];
                    }

                    cumCountX[r][c] = currentSumX;
                    cumCountY[r][c] = currentSumY;
                    System.out.println(".: " + cumCountY[r][c] + " r: " + r + " c: " + c);
                }

                if (cumCountX[r][c] == cumCountY[r][c] && cumCountX[r][c] > 0) {
                    count++;
                }
            }
        }

        return count;
    }
}