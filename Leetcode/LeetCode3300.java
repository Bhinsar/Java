
public class LeetCode3300 {
    public static void main(String[] args) {
        int nums[] = { 10, 12, 13, 14 };
        System.out.println("res: " + minElement(nums));
    }

    public static int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;

        for (int num : nums) {

            int sum = 0;

            while (num > 0) {

                int rem = num % 10;
                sum = sum + rem;
                num = num / 10;
            }

            min = Math.min(sum, min);
        }

        return min;
    }
}
