public class Union{
    public static void main(String[] args) {
        DSU uf = new DSU(5);
        uf.union(0, 4);
        uf.union(4, 2);
        // uf.union(4, 2);
        System.out.println(uf.find(0));
        
    }
}
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