package explore.topics._ds.connectivity;

public class WeightedQuickUnion {
    private int nodes;
    private int[] arr;
    private int[] size;


    public WeightedQuickUnion(int nodes) {
        this.nodes = nodes;
        this.arr = new int[nodes];
        this.size = new int[nodes];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    public static void main(String[] args) {
        WeightedQuickUnion wgUnion = new WeightedQuickUnion(10);
        wgUnion.union(4, 3);
        wgUnion.union(3, 8);
        wgUnion.union(6, 5);
        wgUnion.union(9,4);
        wgUnion.union(2,1);
        System.out.println(wgUnion.isConnected(8, 9));
        System.out.println(wgUnion.isConnected(5, 4));
        wgUnion.union(5,  0);
        wgUnion.union(7,  2);
        wgUnion.union(6,  1);
        wgUnion.union(7,  3);
        System.out.println(wgUnion.isConnected(5, 0));
    }

    public int root(int p) {
        int i = p;
        while (i!=arr[i]) {
            // arr[i] = arr[arr[i]]; Path Compression
            i = arr[i];
        }
        return i;
    }

    public boolean isConnected(int p, int q) {
        return root(p)==root(q);
    }

    public void union(int p, int q) {
        int p1 = root(p);
        int q1 = root(q);

        if(p1==q1) {
            return;
        }

        if(size[p1] < size[q1]) {
            arr[p1] = arr[q1];
            size[q1] += 1;
            size[p1] = 0;
        } else {
            arr[q1] = arr[p1];
            size[p1] += 1;
            size[q1] = 0;
        }
        System.out.println();
    }
}
