import java.util.Arrays;

public class LeetCode2144 {
    public static void main(String[] args) {
        int nums[] = { 1, 2, 3 };
        System.out.println("res: " + minimumCost(nums));
    }

    public static int minimumCost(int[] cost) {
        Arrays.sort(cost);

        int ans = 0;

        for (int i = cost.length - 1, count = 1; i >= 0; i--, count++) {
            if (count % 3 != 0) {
                ans += cost[i];
            }
        }

        return ans;
    }
}
