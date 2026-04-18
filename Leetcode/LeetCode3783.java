public class LeetCode3783 {
    public static void main(String[] args) {
        System.out.printf("result: %d", mirrorDistance(10));
    }

    public static int mirrorDistance(int n) {

        int rev = 0;
        int num = n;
        while (num != 0) {
            int digit = num % 10;
            rev = rev * 10 + digit;
            num /= 10;
        }
        return Math.abs(rev - n);
    }
}
