package explore.topics._arrays;

public class MaximumDifference {
    public static void main(String[] args) {
        int[] arr = {2, 3, 10, 1, 4, 8, 12};
        int[] arr2 = {7, 9, 5, 6, 3, 2};

        MaximumDifference difference = new MaximumDifference();
        System.out.println(difference.getMaxNaive(arr));
        System.out.println(difference.getMaxNaive(arr2));
        System.out.println(difference.getMaxON(arr));
        System.out.println(difference.getMaxON(arr2));
    }

    //Time Complexity : O(n^2)
    //Auxiliary Space : O(1)
    private int getMaxNaive(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j]-arr[i] > max) {
                    max = arr[j]-arr[i];
                }
            }
        }
        return max;
    }

    //Time Complexity : O(n)
    //Auxiliary Space : 2*O(1)
    private int getMaxON(int[] arr) {
        int max = 0;
        int element = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]-element > max) {
                max = arr[i]-element;
            }
            if(arr[i]<element) {
                element = arr[i];
            }
        }
        return max;
    }
}
