import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode2615 {
    public static void main(String[] args) {
        int nums[] = { 1, 3, 1, 1, 2 };
        long[] result = distance(nums);
        System.out.println("result: ");
        for (long num : result) {
            System.out.println(num);
        }
    }

    public static long[] distance(int[] nums) {
        int n = nums.length;
        long[] result = new long[n];
        HashMap<Integer, List<Integer>> freq = new HashMap<>();

        for (int i = 0; i < n; i++) {
            freq.computeIfAbsent(nums[i], k -> new ArrayList<>())
                    .add(i);
        }

        for (List<Integer> list : freq.values()) {
            int size = list.size();

            long prefixSum = 0;
            long totalSum = 0;

            for (int idx : list) {
                totalSum += idx;
            }

            for (int j = 0; j < size; j++) {
                int index = list.get(j);

                long left = (long) index * j - prefixSum;
                long right = (totalSum - prefixSum - index) - (long) index * (size - j - 1);

                result[index] = left + right;

                prefixSum += index;
            }
        }

        // for (int i = 0; i < n; i++) {
        //     List<Integer> list = freq.get(nums[i]);
        //     long sum = 0;
        //     for (int j = 0; j < list.size(); j++) {
        //         sum += Math.abs(i - list.get(j));
        //     }
        //     result[i] = sum;
        // }

        return result;
    }
}