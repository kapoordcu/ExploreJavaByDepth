package explore.topics._stacks_queues;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumSubArraySize {
    private static Queue subQueue = new LinkedList();

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int[] A2 = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
        int[] B = findMaxSubArray(A, 3);
        System.out.println(Arrays.toString(B));
        B = findMaxSubArray(A2, 4);
        System.out.println(Arrays.toString(B));
    }

    private static int[] findMaxSubArray(int[] A, int size) {
        int[] B = new int[A.length-size+1];
        for (int i = 0; i < A.length - size+1; i++) {
            subQueue.add(A[i]);
            subQueue.add(A[i+1]);
            subQueue.add(A[i+2]);
            int max = findMaxElement(A[i], A[i+1], A[i+2]);
            B[i] =  max;
            subQueue.poll();
        }
        return B;
    }

    private static int findMaxElement(int a, int b, int c) {
        return Math.max(Math.max(a,b) ,c);
    }
}
