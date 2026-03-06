public class Butterfly {
    public static void main(String[] args) {
        int row = 5;
        for (int i = 1; i <= row; i++) {
            System.out.print("* ".repeat(i));
            System.out.print("  ".repeat(2));
        }
    }
}
