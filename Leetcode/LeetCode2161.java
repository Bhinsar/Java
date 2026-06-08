public class LeetCode2161 {
    public static void main(String[] args) {
        int num1[] = { 9, 12, 5, 10, 14, 3, 10 };
        int res1[] = pivotArray(num1, 10);
        System.out.println("res1");
        for (int num : res1) {
            System.out.println(num);
        }
        System.out.println("********");

        int num2[] = { -3, 4, 3, 2 };
        int res2[] = pivotArray(num2, 2);
        System.out.println("res2");
        for (int num : res2) {
            System.out.println(num);
        }
        System.out.println("********");

    }

    public static int[] pivotArray(int[] nums, int pivot) {
        int len = nums.length;
        int ans[] = new int[len];
        int idx = 0, smallerIdx = 0, freq = 0;
        ans[idx] = pivot;
        for (int i = 0; i < len; i++) {
            if (nums[i] < pivot) {
                ans[smallerIdx++] = nums[i];
                ans[++idx] = pivot;
            } else if (nums[i] == pivot) {
                ans[idx] = pivot;
                freq++;
            }
        }
        if (freq > 1) {
            for (int i = 0; i < freq; i++) {
                ans[idx++] = pivot;
            }
        } else {
            idx++;
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] > pivot) {
                ans[idx++] = nums[i];
            }
        }

        return ans;
    }
}