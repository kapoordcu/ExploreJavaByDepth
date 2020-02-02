package explore.topics._arrays;

public class TrappedWater {

    public static void main(String[] args) {
        int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        TrappedWater water = new TrappedWater();
        System.out.println(water.maxWaterNaive(arr, arr.length));
        System.out.println(water.maxWaterAuxilarryArray(arr, arr.length));
        System.out.println(water.maxWaterON(arr, arr.length));
    }

    public int maxWaterNaive(int arr[], int n) {
        int res = 0;
        int left = 0;
        int right = 0;
        for (int i = 1; i < n-1; i++) {
            for (int j=0; j<i; j++) {
                left = Math.max(left, arr[j]);
            }
            for (int j=i+1; j<n; j++) {
                right = Math.max(right, arr[j]);
            }
            if(left>arr[i] && right> arr[i]){
                res = res + (Math.min(left, right) - arr[i]);
            }
            left = 0;
            right = 0;
        }
        return res;
    }

    public int maxWaterON(int arr[], int n) {
        int result = 0;
        int left_max = 0, right_max = 0;
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            if (arr[lo] < arr[hi]) {
                if (arr[lo] > left_max) {
                    left_max = arr[lo];
                }
                else {
                    result += left_max - arr[lo];
                }
                lo++;
            }
            else {
                if (arr[hi] > right_max) {
                    right_max = arr[hi];
                }
                else {
                    result += right_max - arr[hi];
                }
                hi--;
            }
        }

        return result;
    }

    public int maxWaterAuxilarryArray(int arr[], int n) {
        int res = 0;
        int[] left = new int[n];
        int[] right = new int[n];

        // Fill left array
        left[0] = arr[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
        }

        // Fill right array
        right[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], arr[i]);
        }

        for (int i = 0; i < n; i++) {
            res += Math.min(left[i], right[i]) - arr[i];
        }
        return res;
    }


}
