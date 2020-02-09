package explore.topics._dynamicprog;

public class LISubsequence {
    public static void main(String[] args) {
        int[] A = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        int[] A2 = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        LISubsequence liSubsequence = new LISubsequence();
        System.out.println(liSubsequence.findMaxSubsequenceOn2(A, A.length));
        System.out.println(liSubsequence.findMaxSubsequenceOn2(A, A.length));
        System.out.println(liSubsequence.findMaxSubsequenceOLongN(A, A.length));
        System.out.println(liSubsequence.findMaxSubsequenceOLongN(A2, A2.length));
    }

    private int findMaxSubsequenceOLongN(int[] A, int size) {
        int[] tailTable = new int[size];
        tailTable[0] = A[0];
        int len = 1;
        for (int i = 1; i < size; i++) {
            if(A[i]<tailTable[0]) {
                tailTable[0] = A[i];
            } else if(A[i] > tailTable[len-1]) {
                tailTable[len++] = A[i];
            } else {
                int index = ceilElementInArray(tailTable, 0, len-1, A[i]);
                tailTable[index] = A[i];
            }
        }
        return len;
    }

    /**
     *
     Ceiling in a sorted array
     Given a sorted array and a value x, the ceiling of x is the smallest element in array greater
     than or equal to x, and the floor is the greatest element smaller than or equal to x.
     it requires log n time to find the ceiling
     */
    private int ceilElementInArray(int A[],int start,int end,int key){
        while (end-start>1) {
            int mid = start + (end-start)/2;
            if(A[mid] >= key) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return end;
    }

    private int findMaxSubsequenceOn2(int[] A, int length) {
        int[] maxLen = new int[A.length];
        for (int i = 0; i < maxLen.length; i++) {
            maxLen[i] = 1;
        }
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if(A[i]>A[j]) {
                    maxLen[i] = Math.max(maxLen[j] + 1, maxLen[i]);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < maxLen.length; i++) {
            max = Math.max(max, maxLen[i]);
        }
        return max;
    }
}
