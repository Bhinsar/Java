import java.util.Arrays;

public class LeetCode2126 {
    public static void main(String[] args) {
        int ast[] = { 4,9,23,4 };
        System.out.println("res: " + asteroidsDestroyed(5, ast));
    }

    public static boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long sum = mass;
        for (int ast : asteroids) {
            if (sum < ast) {
                return false;
            }
            sum += ast;
        }

        return true;
    }
}
