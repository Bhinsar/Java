public class LeetCode2574 {
    public static void main(String[] args) {
        int nums[] = { 10, 4, 8, 3 };
        int res[] = leftRightDifference(nums);
        for (int num : res) {
            System.out.println(num);
        }
    }

    public static int[] leftRightDifference(int[] nums) {
        int leftSum = 0, rightSum = 0, n = nums.length;
        for (int num : nums)
            rightSum += num;
        for (int i = 0; i < n; i++) {
            int val = nums[i];
            rightSum -= val;
            nums[i] = Math.abs(leftSum - rightSum);
            leftSum += val;
        }
        return nums;
        // int ans[] = new int[nums.length];
        // int leftSum[] = new int[nums.length];
        // int rigthSum[] = new int[nums.length];
        // int left = 0;
        // int right = 0;
        // for (int i = 0; i < nums.length; i++) {
        // leftSum[i] = left;
        // left += nums[i];
        // }
        // for (int i = nums.length - 1; i >= 0; i--) {
        // rigthSum[i] = right;
        // right += nums[i];
        // }
        // for (int i = 0; i < nums.length; i++) {
        // ans[i] = Math.abs(leftSum[i] - rigthSum[i]);
        // }

        // return ans;
    }
}
