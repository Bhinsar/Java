public class LeetCode3660 {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 1 };
        System.out.println("result: ");
        int ans[] = maxValue(nums);
        for (int num : ans) {
            System.out.print(num + " ");

        }
    }

    public static int[] maxValue(int[] nums) {

        int n = nums.length;

        int[] preMax = new int[n];
        int[] ans = new int[n];

        preMax[0] = nums[0];

        for (int i = 1; i < n; i++) {
            preMax[i] = Math.max(preMax[i - 1], nums[i]);
        }

        int sufMin = Integer.MAX_VALUE;

        for (int i = n - 1; i >= 0; i--) {

            if (preMax[i] > sufMin) {
                ans[i] = (i == n - 1) ? preMax[i] : ans[i + 1];
            } else {
                ans[i] = preMax[i];
            }

            sufMin = Math.min(sufMin, nums[i]);
        }

        return ans;

    }
}
