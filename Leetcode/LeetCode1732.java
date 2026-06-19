
import java.util.PriorityQueue;

public class LeetCode1732 {
    public static void main(String[] args) {
        int gain[] = { -5, 1, 5, 0, -7 };
        System.out.println("res: " + largestAltitude(gain));
    }

    public static int largestAltitude(int[] gain) {
        int sum = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        queue.add(sum);
        for (int num : gain) {
            sum += num;
            queue.add(sum);
        }
        return queue.poll();
    }
}
