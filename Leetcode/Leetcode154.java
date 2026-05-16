public class Leetcode154 {
    public static void main(String[] args) {
        int nums[] = { 3, 5, 1 };
        System.out.println("res: " + findMin(nums));
    }

    public static int findMin(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        for (int i = 0; i < n; i++) {
            int k = (i + 1) % n;
            if (nums[i] < nums[k]) {
                min = Math.min(min, nums[i]);
            }
        }
        return min;
    }
}
