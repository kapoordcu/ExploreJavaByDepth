package explore.topics._dynamicprog;

public class LISubsequence {
    public static void main(String[] args) {
        int[] A = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        LISubsequence liSubsequence = new LISubsequence();
        System.out.println(liSubsequence.findMaxSubsequence(A, A.length));
    }

    private int findMaxSubsequence(int[] A, int length) {
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
