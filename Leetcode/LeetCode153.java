public class LeetCode153 {
    public static void main(String[] args) {
        int nums[] = { 3, 4, 5, 1, 2 };
        System.out.println("res: " + findMin(nums));
    }

    public static int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return nums[r];
    }
}
