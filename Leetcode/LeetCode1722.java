import java.util.HashMap;
import java.util.Map;

public class LeetCode1722 {
    public static void main(String[] args) {
        int source[] = {1,2,3,4};
        int traget[] = {2,1,4,5};
        int allowedSwaps[][] ={{0,1},{2,3}};
        System.out.println("result: "+minimumHammingDistance(source, traget, allowedSwaps));
    }
    public static int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        DSU uf = new DSU(n);

        // 1. Union the allowed swaps
        for (int[] swap : allowedSwaps) {
            uf.union(swap[0], swap[1]);
        }

        // 2. Group source values by their root parent
        Map<Integer, Map<Integer, Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            groups.computeIfAbsent(root, k -> new HashMap<>())
                    .put(source[i], groups.get(root).getOrDefault(source[i], 0) + 1);
        }

        // 3. Count mismatches against target
        int hammingDistance = 0;
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            Map<Integer, Integer> componentMap = groups.get(root);
            int targetVal = target[i];

            if (componentMap.getOrDefault(targetVal, 0) > 0) {
                componentMap.put(targetVal, componentMap.get(targetVal) - 1);
            } else {
                hammingDistance++;
            }
        }

        return hammingDistance;
    }
}

// Standard DSU class (Use the one from our previous chat)
class DSU {
    int[] parent;
    public DSU(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }
    public int find(int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }
    public void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) parent[rootI] = rootJ;
    }
}
