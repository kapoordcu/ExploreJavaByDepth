package explore.topics._ds.connectivity;

public class QuickFind {
    private Integer nodes;
    private int[] arr;
//    public static void main(String[] args) {
//        QuickFind find = new QuickFind(10);
//        find.union(4, 3);
//        find.union(3, 8);
//        find.union(6, 5);
//        find.union(9,4);
//        find.union(2,1);
//        System.out.println(find.isConnected(8, 9));
//        System.out.println(find.isConnected(5, 0));
//        find.union(5,  0);
//        find.union(7,  2);
//        find.union(6,  1);
//        System.out.println(find.isConnected(5, 0));
//    }

    public QuickFind(int nodes) {
        this.nodes = nodes;
        this.arr = new int[nodes];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=i;
        }
    }

    public void union(int p, int q) {
        int source = arr[p];
        int destination = arr[q];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==source) {
                arr[i] = destination;
            }
        }

    }

    public boolean isConnected(int p, int q) {
        return arr[p]== arr[q];
    }
}
