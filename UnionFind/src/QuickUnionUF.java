public class QuickUnionUF {
    private int[] id;

    public QuickUnionUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    private int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }

        return i;
    }

    public boolean isConnected(int p, int q) {
        return (root(q) == root(q));
    }

    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);

        id[pRoot] = qRoot;
    }
}
