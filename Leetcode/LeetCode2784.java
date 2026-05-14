
import java.util.HashMap;

public class LeetCode2784 {
    public static void main(String args[]) {
        int nums[] = { 14, 2, 2 };
        LeetCode2784 res = new LeetCode2784();
        System.out.println("res: " + res.isGood(nums));
    }

    public boolean isGood(int[] nums) {
        int n = nums.length;

        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        if (freq.getOrDefault(n - 1, 0) == 2) {
            for (int i = 1; i <= n - 2; i++) {
                if (freq.getOrDefault(i, 0) != 1) {
                    return false;
                }
            }

            if (freq.size() != n - 1) {
                return false; 
            }

            return true;
        }
        return false;
    }
}
