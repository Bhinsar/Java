public class LeetCode1979 {
    public static void main(String[] args) {
        System.out.println("res:" + findGCD(new int[] { 2, 5, 6, 9, 10 }));
    }

    public static int findGCD(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        for (int num : nums) {
            if (num < min)
                min = num;
            if (num > max)
                max = num;
        }

        return gcd(min, max);
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
