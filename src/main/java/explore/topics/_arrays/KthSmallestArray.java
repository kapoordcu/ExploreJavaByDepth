package explore.topics._arrays;

public class KthSmallestArray {
    public static void main(String[] args) {
        KthSmallestArray kthSmallest = new KthSmallestArray();
        //int[] arr = {3, 6, 0, 5, 2, 7, 9};
        int[] arrDuplicate = {3, 6, 0, 9, 2, 7, 0, 9, 9};

        int kth = 3;
        int kthElement = kthSmallest.findKthElement(arrDuplicate, 0, arrDuplicate.length-1, kth);
        System.out.println(kth + " smallest is " + kthElement);


        kth = 5;
        kthElement = kthSmallest.findKthElement(arrDuplicate, 0, arrDuplicate.length-1, kth);
        System.out.println(kth + " smallest is " + kthElement);
    }

    //[0, 0, 2, 3, 6, 7, 9, 9, 9]
    private int findKthElement(int[] arr, int low, int high, int kth) {
        if(low<high) {
            int j = partition(arr, low, high);
            if(j+1==kth) {
                return arr[j];
            } else if(j+1> kth) {
                high = j-1;
            } else {
                low = j + 1;
            }
            //System.out.println("j:" + j);
            return findKthElement(arr, low, high, kth);
        }
        return -1;
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        for (int i = low; i < high; i++) {
            if(arr[i] < pivot) {
                swap(arr, i, low++);
            }
        }
        swap(arr, low, high);
        return low;
    }

    private static void swap(int[] a, int i, int j) {
        if(i==j) {
            return;
        }
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
