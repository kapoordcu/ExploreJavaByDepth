package explore.topics._codingproblmes2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountZeroSumSlices {
    public static void main(String[] args) {
        int[] A = { 2, -2, 3, 0, 4, -7};
        int[] B = { 6, 3, -1, -3, 4, -2, 2};

        /*
            2 -> 0
            0 -> 1, 5
            3 -> 2, 3
            7 -> 4
         */

        CountZeroSumSlices distance = new CountZeroSumSlices();
        System.out.println(distance.solutionON(A));

    }

    private int solutionON(int[] A) {
        int sum = 0;
        Map<Integer, List<Integer>> mapping = new HashMap<>();
        List<SubArrayWithZeroSum> zeroSumList = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            sum += A[i];

            if(sum==0) {
                zeroSumList.add(new SubArrayWithZeroSum(0, i));
            }
            List<Integer> indexList = new ArrayList<>();

            if(mapping.containsKey(sum)) {
                indexList = mapping.get(sum);
                int finalI = i;
                indexList.stream().forEach(v -> zeroSumList.add(new SubArrayWithZeroSum(v+1, finalI)));
            }
            indexList.add(i);
            mapping.put(sum, indexList);
        }
        return zeroSumList.size();
    }


    private int solution(int[] A) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                if(((A[i] == 0) && (A[i]==A[j]))) {
                    count++;
                } else if(findSum(A, i, j)==0){
                    count++;
                }
            }
        }
        return count;
    }

    private int findSum(int[] A, int i, int j) {
        int sum = 0;
        for (int k = i; k <=j ; k++) {
            sum += A[k];
        }
        return sum;
    }
}

class SubArrayWithZeroSum  {
    int startIndx, endIndx;

    public SubArrayWithZeroSum(int startIndx, int endIndx) {
        this.startIndx = startIndx;
        this.endIndx = endIndx;
    }
}