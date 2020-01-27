package explore.topics._arrays;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] a1 = {2, 4, 5, 9, 10};
        int[] a2 = {0, 1, 8};

        int[] join = extraSpaceJoin(a1, a2);
        inPlaceJoin(a1, a2);
    }

    // In Place join
    private static void inPlaceJoin(int[] a1, int[] a2) {
        int i = a1.length-1;
        int j = a2.length-1;
        while (j>=0 && a1[i]>a2[j]) {
            replaceMax(a1, a2, i, j);
            j--;
        }
    }

    private static void replaceMax(int[] a1, int[] a2, int i, int j) {
        int replace = a1[i];
        int l = i-1;
        while (l>=0 && a1[l]>a2[j]) {
            a1[l+1] = a1[l];
            l--;
        }
        a1[l+1] = a2[j];
        a2[j] = replace;
    }

    /**
     * Time Complexity : O(n1 + n2)
     * Auxiliary Space : O(n1 + n2)
     * This task is simple and O(m+n) if we are allowed to use extra space.
     * But it becomes really complicated when extra space is not allowed
     * and doesn’t look possible in less than O(m*n) worst case time.
     */
    private static int[] extraSpaceJoin(int[] a1, int[] a2) {
        int l1 = a1.length;
        int l2 = a2.length;
        int[] joined = new int[l1+l2];
        int i=0;
        int j=0;
        int k = 0;
        while (i<l1 && j<l2) {
            if(a1[i] < a2[j]) {
                joined[k++] = a1[i++];
            } else {
                joined[k++] = a2[j++];
            }
        }
        for (int l = i; l < l1; l++) {
            joined[k++] = a1[l];
        }
        for (int l = j; l < l2; l++) {
            joined[k++] = a2[l];
        }
        return joined;
    }
}
