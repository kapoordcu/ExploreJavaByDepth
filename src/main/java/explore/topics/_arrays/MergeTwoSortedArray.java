package explore.topics._arrays;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] a1 = {2, 4, 5, 9, 10};
        int[] a2 = {0, 1, 8};

        int[] join = extraSpaceJoin(a1, a2);
        inPlaceJoin(a1, a2);  // {0,1,2,4,5}   {8,9,10}
        inPlaceJoin(a2, a1); // {0,1,2}   {4,5,8,9,10}
    }

    // In Place join
    private static void inPlaceJoin(int[] a1, int[] a2) {
        for (int i = 0; i < a1.length; i++) {
            if(a1[i] > a2[0]) {
                int higher = a1[i];
                a1[i] = a2[0];
                a2[0] = higher;
            }
            sortSecondArray(a2);
        }
    }

    private static void sortSecondArray(int[] a2) {
        int element = a2[0];
        int k=1;
        while (k<a2.length && a2[k]<element) {
            a2[k-1] = a2[k];
            k++;
        }
        a2[k-1] = element;
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
