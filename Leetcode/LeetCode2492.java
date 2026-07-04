import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LeetCode2492 {
    public static void main(String[] args) {
        System.out.println("res1: " + minScore(4, new int[][] { { 1, 2, 9 }, { 2, 3, 6 }, { 2, 4, 5 }, { 1, 4, 7 } }));
        System.out.println("res2: " + minScore(4, new int[][] { { 1, 2, 2 }, { 1, 3, 4 }, { 3, 4, 7 } }));
    }

    public static int minScore(int n, int[][] roads) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] road : roads) {
            graph.computeIfAbsent(road[0], k -> new ArrayList<>()).add(new int[]{road[1], road[2]});
            graph.computeIfAbsent(road[1], k -> new ArrayList<>()).add(new int[]{road[0], road[2]});
        }

        int minScore = Integer.MAX_VALUE;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int currentCity = queue.poll();
            
            if (!graph.containsKey(currentCity)) continue;

            for (int[] edge : graph.get(currentCity)) {
                int nextCity = edge[0];
                int distance = edge[1];

                minScore = Math.min(minScore, distance);

                if (!visited[nextCity]) {
                    visited[nextCity] = true;
                    queue.offer(nextCity);
                }
            }
        }

        return minScore;
    }
}
