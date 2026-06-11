import java.util.ArrayList;
import java.util.List;

public class LeetCode3558 {
    public static void main(String[] args) {
        System.out.println("res1: " + assignEdgeWeights(new int[][] { { 1, 2 } }));
        System.out.println("res2: " + assignEdgeWeights(new int[][] { { 1, 2 }, { 1, 3 }, { 3, 4 }, { 3, 5 } }));

    }

    static long mod = (long) (1e9) + 7;

    public static int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        ArrayList<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int depth = findDepth(graph, 1, 0);

        if (depth == 0)
            return 0;

        long result = 1;
        for (int i = 0; i < depth - 1; i++) {
            result = (result * 2) % mod;
        }

        return (int) result;
    }

    private static int findDepth(ArrayList<List<Integer>> graph, int i, int j) {
        int depth = 0;
        for (int nrb : graph.get(i)) {
            if (nrb != j) {
                depth = Math.max(depth, findDepth(graph, nrb, i) + 1);
            }
        }
        return depth;
    }
}
