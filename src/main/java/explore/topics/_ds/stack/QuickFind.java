package explore.topics._ds.stack;

public class QuickFind {
    private Integer nodes;
    private int[] backedArray;
    public static void main(String[] args) {
        QuickFind find = new QuickFind(10);
        find.union(4, 3);
        find.union(3, 8);
        find.union(6, 5);
        find.union(9,4);
        find.union(2,1);
        System.out.println(find.isConnected(8, 9));
        System.out.println(find.isConnected(5, 0));
        find.union(5,  0);
        find.union(7,  2);
        find.union(6,  1);
        System.out.println(find.isConnected(5, 0));
    }

    public QuickFind(int nodes) {
        this.nodes = nodes;
        this.backedArray = new int[nodes];
        for (int i = 0; i < backedArray.length; i++) {
            backedArray[i]=i;
        }
    }

    public void union(int p, int q) {
        int source = backedArray[p];
        int destination = backedArray[q];
        for (int i = 0; i < backedArray.length; i++) {
            if(backedArray[i]==source) {
                backedArray[i] = destination;
            }
        }

    }

    public boolean isConnected(int p, int q) {
        return backedArray[p]==backedArray[q];
    }

    public int findComponentIdentifier(int p) {
        return 0;
    }
    public int findTotalConnectedComponent(int p) {
        return 0;
    }
}
