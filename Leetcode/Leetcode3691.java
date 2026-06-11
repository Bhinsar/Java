
import java.util.PriorityQueue;

public class Leetcode3691 {
    public static void main(String[] args) {
        System.out.println("res1 : " + maxTotalValue(new int[] { 1, 3, 2 }, 2)); // output: 4
        System.out.println("res2 : " + maxTotalValue(new int[] { 4, 2, 5, 1 }, 3));// output: 12
        System.out.println("res3 : "
                + maxTotalValue(new int[] { 11, 8 }, 2));// output: 3
        System.out.println("res4 : "
                + maxTotalValue(new int[] { 9, 9, 37 }, 3));// output: 59
        System.out.println("res5 : "
                + maxTotalValue(new int[] { 28, 21, 50, 32 }, 4));// output: 116
    }

    public static long maxTotalValue(int[] nums, int k) {

        int n = nums.length;

        PriorityQueue<Long> maxHeap = new PriorityQueue<>((a, b) -> Long.compare(b, a));

        int currentMax = nums[0];
        int currentMin = nums[0];

        for (int i = 1; i < n; i++) {
            currentMax = Math.max(currentMax, nums[i]);
            currentMin = Math.min(currentMin, nums[i]);

            long subarrayValue = (long) currentMax - currentMin;
            maxHeap.add(subarrayValue);
        }
        currentMax = nums[n - 1];
        currentMin = nums[n - 1];
        for (int i = n - 2; i > 0; i--) {
            currentMax = Math.max(currentMax, nums[i]);
            currentMin = Math.min(currentMin, nums[i]);

            long subarrayValue = (long) currentMax - currentMin;
            maxHeap.add(subarrayValue);
        }

        long totalMaxSum = 0;
        for (int i = 0; i < k; i++) {
            if (!maxHeap.isEmpty()) {
                totalMaxSum += maxHeap.poll();
            }
        }

        return totalMaxSum;
    }
}
