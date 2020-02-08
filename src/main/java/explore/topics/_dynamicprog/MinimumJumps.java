package explore.topics._dynamicprog;

public class MinimumJumps {
    public static void main(String[] args) {
        int[] A = {2, 3, 1, 1, 2, 4, 2, 0, 1, 1};
        MinimumJumps jumps = new MinimumJumps();
        System.out.println(jumps.findMinJumps(A));
        System.out.println(jumps.findMinJumpsOn(A));
    }

    private int findMinJumpsOn(int[] A) {
        // initialization
        int maxReach = A[0];
        int step = A[0];
        int jump = 1;
        for (int i = 1; i < A.length; i++) {
            if(i==A.length-1) {
                return jump;
            }
            maxReach = Math.max(maxReach, i + A[i]);
            step--;
            if (step == 0)  {
                jump++;
                if(i>=maxReach) {
                    return -1;
                }
                step = maxReach - i;
            }
        }
        return 0;
    }
    /**
     * Time Complexity: O(n^2) in worst case.
     */
    private int findMinJumps(int[] A) {
        int[] jumps = new int[A.length];
        int[] index = new int[A.length];
        if(A==null || A.length==0 || A[0]==0) {
            return Integer.MAX_VALUE;
        }
        jumps[0] = 0;
        index[0] = 0;
        for (int i = 1; i < A.length; i++) {
            jumps[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if(i <= j + A[j]) {
                    if(jumps[j] + 1 < jumps[i]) {
                        jumps[i] = jumps[j] + 1;
                        index[i] = j;
                    } else {
                        index[i] = i;
                    }
                    break;
                }
            }
        }
        int stop = index.length - 1;
        while(stop!=0) {
            System.out.print(stop + " ");
            stop = index[stop];
        }
        return jumps[A.length-1];

    }
}
