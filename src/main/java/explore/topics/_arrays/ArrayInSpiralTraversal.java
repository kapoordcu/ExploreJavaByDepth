package explore.topics._arrays;

public class ArrayInSpiralTraversal {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        // 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
        // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
        printSpiralForm(arr);
    }

    private static void printSpiralForm(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

            }
        }
    }

    // [00][01][02][03]
    // [13][23][33]
    // [32][31][30]
    // [20][10]
    // [11][12]
    // [22][21]


}
