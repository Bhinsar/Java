
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LeetCode874 {
    public static void main(String[] args) {
        int m[] = { 4, -1, 4, -2, 4 };
        int o[][] = { { 2, 4 } };

        System.out.println("result: " + robotSim(m, o));
    }

    public static int robotSim(int[] commands, int[][] obstacles) {

        Set<String> obStSet = new HashSet<>();

        for (int[] obs : obstacles) {
            String key = obs[0] + "_" + obs[1];
            obStSet.add(key);
        }

        int x = 0, y = 0, maxD = 0;

        int dir[] = { 0, 1 };

        for (int i = 0; i < commands.length; i++) {
            switch (commands[i]) {
                case -2 -> { // Turn left
                    int temp = dir[0];
                    dir[0] = -dir[1];
                    dir[1] = temp;
                }
                case -1 -> { // Turn right
                    int temp = dir[0];
                    dir[0] = dir[1];
                    dir[1] = -temp;
                }
                default -> {
                    for (int step = 0; step < commands[i]; step++) {
                        int newX = x + dir[0];
                        int newY = y + dir[1];

                        String nextKey = newX + "_" + newY;

                        if (obStSet.contains(nextKey))
                            break;

                        x = newX;
                        y = newY;
                    }
                }
            }
            maxD = Math.max(maxD, x * x + y * y);
        }

        return maxD;
    }
}
