import java.util.Arrays;

public class LeetCode1665 {
    public static void main(String[] args) {
        int task[][] = { { 1, 3 }, { 2, 4 }, { 10, 11 }, { 10, 12 }, { 8, 9 } };
        System.out.println("res: " + minimumEffort(task));
    }

    public static int minimumEffort(int[][] tasks) {

        Arrays.sort(tasks, (a, b) -> {
            int diffA = Math.abs(a[0] - a[1]);
            int diffB = Math.abs(b[0] - b[1]);
            return Integer.compare(diffB, diffA);
        });

        for (int[] t : tasks) {
            System.out.print("[ ");
            for (int num : t) {
                System.out.print(num + " ");
            }
            System.out.println("]");
        }

        int maxEnergy = 0;
        for (int[] task : tasks) {
            maxEnergy += task[1];
        }

        int min = 0;

        int result = Integer.MAX_VALUE;

        while (maxEnergy >= min) {
            int mid = min + (maxEnergy - min) / 2;
            System.out.println(mid);
            if (isPossible(tasks, mid)) {
                result = mid; 
                maxEnergy = mid - 1; 
            } else {
                min = mid + 1;
            }
        }

        return result;

    }

    private static boolean isPossible(int[][] tasks, int mid) {
        for (int[] task : tasks) {
            if (task[1] > mid)
                return false;
            mid -= task[0];
        }
        return true;
    }

}
