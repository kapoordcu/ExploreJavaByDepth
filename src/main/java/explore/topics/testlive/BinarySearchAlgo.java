package explore.topics.testlive;

public class BinarySearchAlgo {
    public static void main(String[] args) {
        int[] numbers = { 1, 3, 5, 8, 13, 17, 19};
        int searchNumber = 2;
        System.out.println(findIndex(numbers, searchNumber));
    }

    private static int findIndex(int[] numbers, int searchNumber) {
        int low = 0;
        int mid = -1;
        int high = numbers.length-1;
        while (low<=high) {
            mid = (low + high)/2;
            if(numbers[mid] == searchNumber) {
                return mid;
            } else if(numbers[mid] < searchNumber) {
                low = mid + 1;
            } else {
                high = mid -1;
            }
        }
        return mid;
    }
}
