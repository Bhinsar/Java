public class LeetCode1582 {
    public static void main(String[] args) {

        int mat[][] = { { 0, 0, 0, 1 }, { 1, 0, 0, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0, 0 } };
        int result = numSpecial(mat);
        System.out.println("result: " + result);
    }

    public static int numSpecial(int[][] mat) {
        int count = 0;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (isSpecial(mat, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static boolean isSpecial(int[][] mat, int row, int col) {
        if (mat[row][col] == 0)
            return false;

        System.out.println("the orignal number is " + mat[row][col] + " at row " + row + " and col " + col);

        for (int i = 0; i < col; i++) {
            if (mat[row][i] == 1) {
                System.out.println("mat1 is " + mat[row][i] + " at row " + row + " and col " + i);
                return false;
            }
        }
        for (int i = 0; i < row; i++) {
            if (mat[i][col] == 1) {
                System.out.println("mat2 is " + mat[i][col] + " at row " + i + " and col " + col);
                return false;
            }
        }
        for (int i = col+1; i < mat[0].length; i++) {
            if (mat[row][i] == 1) {
                System.out.println("mat3 is " + mat[row][i] + " at row " + row + " and col " + i);
                return false;
            }
        }
        for (int i = row+1; i < mat.length; i++) {
            if (mat[i][col] == 1) {
                System.out.println("mat4 is " + mat[i][col] + " at row " + i + " and col " + col);
                return false;
            }
        }

        return true;
    }
}
