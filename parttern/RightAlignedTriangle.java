public class RightAlignedTriangle {
    public static void main(String[] args) {
        int row = 5;
        for (int i = 0; i <= row; i++) {
            System.out.println("* ".repeat(i));
            System.out.print(" ".repeat(row - i));
        }
    }
}
