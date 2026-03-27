public class LeetCode2946 {
    public static void main(String[] args) {
        int[][] mat = { { 1, 2, 1, 2 }, { 5, 5, 5, 8 }, { 6, 3, 6, 3 } };
        System.out.println("result: " + areSimilar(mat, 2));
    }

    public static boolean areSimilar(int[][] mat, int k) {

        int m = mat.length, n = mat[0].length;

        if (k == n)
            return true;

        int shift = k > n ? k % n : k;


        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n ; c++) {
                if (mat[r][c] != mat[r][(c + shift)%n])
                    return false;
            }
        }

        return true;
    }
}
