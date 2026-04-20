public class LeetCode2078 {
    public static void main(String[] args) {
        // int nums[] = { 1, 1, 1, 6, 1, 1, 1 };
        int nums[] = { 1, 1, 1, 6, 1, 1, 1 };
        System.out.println("result: " + maxDistance(nums));

    }

    public static int maxDistance(int[] colors) {
        int maxDist = 0;
        int n = colors.length;
        int i = 0, j = n - 1;
        while (i < n) {
            if (colors[i] != colors[j]) {
                int dist = Math.abs(j - i);
                maxDist = Math.max(dist, maxDist);
                i++;
                j = n - 1;
            } else if (j < i) {
                i++;
                j = n - 1;

            } else {
                j--;

            }
        }
        return maxDist;
    }
}
