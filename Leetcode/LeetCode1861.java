public class LeetCode1861 {
    public static void main(String[] args) {
        char[][] boxGrid = {
                { '#', '#', '*', '.', '*', '.' },
                { '#', '#', '#', '*', '.', '.' },
                { '#', '#', '#', '.', '#', '.' }
        };
        char[][] result = rotateTheBox(boxGrid);
        System.out.println("result: ");
        for (char[] i : result) {
            for (char j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }

    public static char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;

        char result[][] = new char[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = boxGrid[m - 1 - j][i];
            }
        }
        for (int j = 0; j < m; j++) {
            int emptySlot = n - 1;
            for (int i = n - 1; i >= 0; i--) {
                if (result[i][j] == '#') {
                    result[i][j] = '.';
                    result[emptySlot][j] = '#';
                    emptySlot--;
                } else if (result[i][j] == '*') {
                    emptySlot = i - 1;
                }
            }
        }

        return result;
    }

}
