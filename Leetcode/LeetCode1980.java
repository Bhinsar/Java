
import java.util.HashSet;
import java.util.Set;

public class LeetCode1980 {
    public static void main(String[] args) {
        String[] str = { "111", "011", "001" };
        System.out.println("result: " + findDifferentBinaryString(str));
    }

    public static String findDifferentBinaryString(String[] nums) {
        int n = nums.length;

        // 1. Convert input strings to a Set of Integers for fast lookup
        Set<Integer> existingNums = new HashSet<>();
        for (String s : nums) {
            existingNums.add(Integer.parseInt(s, 2)); // Parse binary string to int
        }

        for (int i = 0; i <= n + 1; i++) {
            if (!existingNums.contains(i)) {
                String binary = Integer.toBinaryString(i);
                System.out.println(binary);
                StringBuilder sb = new StringBuilder();
                while (sb.length() < n - binary.length()) {
                    sb.append('0');
                }
                sb.append(binary);
                return sb.toString();

            }
        }
        return "";

    }

}
