package explore.topics._arrays;

public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        SubarrayWithGivenSum sum = new SubarrayWithGivenSum();
        int[] arr = {10,3,5,8,6,12,20,15,31};
        System.out.println(sum.findSumInOn(arr, 31));
        System.out.println(sum.findSumInOn(arr, 32));
        System.out.println(sum.findSumInOn(arr, 33));
        System.out.println(sum.findSumInOn(arr, 34));
    }

    private String findSumInOn(int[] arr, int sum) {
        int start = 0;
        int end = arr.length-1;
        int tempSum = 0;
        int i = 0;
        while (start<=end && i < end) {
            if(tempSum==sum) {
                return start + ":" + (i-1);
            } else if(tempSum<sum) {
                tempSum += arr[i++];
            } else if(tempSum>sum) {
                tempSum -= arr[start++];
            }
        }
        return "NO Subarray Exists for sum:  " + sum;
    }
}
