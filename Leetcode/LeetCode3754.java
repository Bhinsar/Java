public class LeetCode3754 {
    public static void main(String[] args) {
        System.out.println("res1: " + sumAndMultiply(10203004));
        System.out.println("res2: " + sumAndMultiply(1000));
    }

    public static long sumAndMultiply(int n) {
        long x = 0;
        long sum = 0;
        int power = 0;

        while (n != 0) {
            int res = n % 10;
            if (res != 0) {
                x = (long) (res * Math.pow(10, power) + x);
                power++;
                sum = (long) (res + sum);
            }
            n /= 10;
        }

        return x * sum;
    }
}
