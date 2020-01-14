package explore.topics._ds.connectivity;

public class QuickUnion {
    private Integer nodes;
    private int[] arr;
//
//    public static void main(String[] args) {
//        QuickUnion findUnion = new QuickUnion(10);
//        findUnion.union(4, 3);
//        findUnion.union(3, 8);
//        findUnion.union(6, 5);
//        findUnion.union(9,4);
//        findUnion.union(2,1);
//        System.out.println(findUnion.isConnected(8, 9));
//        System.out.println(findUnion.isConnected(5, 4));
//        findUnion.union(5,  0);
//        findUnion.union(7,  2);
//        findUnion.union(6,  1);
//        findUnion.union(7,  3);
//        System.out.println(findUnion.isConnected(5, 0));
//    }

    public QuickUnion(Integer nodes) {
        this.nodes = nodes;
        this.arr = new int[nodes];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=i;
        }
    }

    private void union(int p, int q) {
        int rP = root(p);
        int rQ = root(q);
        arr[rP] = rQ;
    }

    private boolean isConnected(int p, int q) {
        return root(p)==root(q);
    }

    private int root(int i) {
        while(i!= arr[i]) {
            i = arr[i];
        }
        return i;
    }
}
