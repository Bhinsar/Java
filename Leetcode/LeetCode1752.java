
public class LeetCode1752 {
    public static void main(String[] args) {
        int nums[] = { 6, 10, 6 };
        System.out.println("res: " + check(nums));
    }

    public static boolean check(int[] nums) {
        int countDrops = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] > nums[(i + 1) % length]) {
                countDrops++;
            }

            if (countDrops > 1) {
                return false;
            }
        }

        return true;
    }
}
