import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 7;
        int[] result = new int[n];
        generate(n, 0, 0, 1, result);
        System.out.println(Arrays.toString(result));
    }

    public static void generate(int n, int index, int a, int b, int[] arr) {
        if (index == n)
            return;
        arr[index] = a;
        generate(n, index + 1, b, a + b, arr);
    }
}
