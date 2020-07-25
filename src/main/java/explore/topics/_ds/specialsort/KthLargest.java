//package explore.topics._ds.specialsort;
//
//import explore.topics._ds.basicsort.SortUtils;
//
//public class KthLargest {
//    public static void main(String[] args) {
//        KthLargest sort = new KthLargest();
//        Comparable[] arr = {7, 3, 2, 5, 1, 4, 6};
//        int kthL = sort.kthLargest(arr, 0, arr.length - 1, 20);
//        System.out.println(kthL);
//    }
//
//    private int kthLargest(Comparable[] arr, int low, int high, int kth) {
//        int j = QuickSort.partition(arr, low, high);
//        if(kth>arr.length) {
//            return -1;
//        }
//        if(j == kth ) {
//            return j;
//        } else if(SortUtils.less(j, kth)) {
//            return kthLargest(arr, j+1, high, kth);
//        } else {
//            return kthLargest(arr, low, j, kth);
//        }
//    }
//
//
//}
