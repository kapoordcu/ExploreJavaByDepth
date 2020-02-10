package explore.topics._arrays;
// Subarray With Max Sum
public class Kadane {
    public static void main(String[] args) {
        int[] array = { 1, -3, 2, 1, -1};
        findKadaneSum(array);
    }

    private static int findKadaneSum(int[] A) {
        int localMax = A[0], globalMax = A[0];
        for (int i = 1; i < A.length; i++) {
            localMax = Math.max(localMax+A[i], A[i]);
            if(localMax>globalMax) {
                globalMax = localMax;
            }
        }
        return globalMax;
    }
}
