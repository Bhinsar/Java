
import java.util.HashMap;

public class LeetCode3761 {
    public static void main(String args[]) {
        int[] nums = { 12, 34, 46, 21, 12 };
        System.out.println("result: " + minMirrorPairDistance(nums));
    }

    public static int minMirrorPairDistance(int[] nums) {

        HashMap<Integer, Integer> numMap = new HashMap<>();
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(nums[i])) {
                int dist = Math.abs(numMap.get(nums[i]) - i);
                minDist = Math.min(dist, minDist);
            } 
            numMap.put(reverseInteger(nums[i]), i);
            
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }

    public static int reverseInteger(int num) {
        int reversed = 0;
        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        return reversed;
    }

}