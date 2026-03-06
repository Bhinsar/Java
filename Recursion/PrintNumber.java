public class PrintNumber {
    public static void PrintLoop(int n) {
        System.err.print(n + " ");
        if (n > 0)
            PrintLoop(n - 1);
    }

    public static void main(String[] args) {
        PrintLoop(5);
    }
}
