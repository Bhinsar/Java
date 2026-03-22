public class HollowPyramid {
    public static void main(String[] args) {
        int row = 5;

        for (int i = 1; i < row; i++) {

            System.out.print("  ".repeat(row - i));

            if (i == 1 || i == row-1) {
                System.out.println("* ".repeat(2 * i - 1));
            } else {
                System.out.print("* ");
                System.out.print("  ".repeat(2 * i - 3));
                System.out.println("* ");
            }
        }
    }
}
