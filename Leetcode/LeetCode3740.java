import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode3740 {
    public static void main(String args[]) {
        int nums[] = { 1, 2, 1, 1, 3 };
        System.out.println("result: " + minimumDistance(nums));
    }

    public static int minimumDistance(int[] nums) {
        int result = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(i);
            // the vales are stored in my like x-> [there idx]

            List<Integer> indices = map.get(nums[i]);
            int size = indices.size();

            if (size >= 3) {
                int iIdx = indices.get(size - 3);
                int jIdx = indices.get(size - 2);
                int kIdx = indices.get(size - 1);

                int distance = (jIdx - iIdx) + (kIdx - jIdx) + (kIdx - iIdx);
                result = Math.min(result, distance);
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}