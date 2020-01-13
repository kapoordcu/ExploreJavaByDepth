package explore.topics._ds.stack;

public class QuickFind {
    private Integer nodes;
    private int[] backedArray;
    public static void main(String[] args) {

    }

    public QuickFind(int nodes) {
        this.nodes = nodes;
        this.backedArray = new int[nodes];
        for (int i = 0; i < backedArray.length; i++) {
            backedArray[i]=i;
        }
    }

    public void union(int p, int q) {

    }

    public boolean isConnected(int p, int q) {
        return false;
    }

    public int findComponentIdentifier(int p) {
        return 0;
    }
    public int findTotalConnectedComponent(int p) {
        return 0;
    }
}
