package explore.topics._arrays;

import java.util.Arrays;

public class MergeOrder {


    public int solution(int[] A) {
        int time = 0;
        // write your code in Java SE 8
        Arrays.sort(A);
        int[] lengthArray = new int[A.length/2 + 1];
        boolean[] isMerged = new boolean[A.length];
        int i  = 0;
        int j  = 0;
        for (i = 0, j = 0; i+1 < A.length ; i+=2, j++) {
            time = A[i] + A[i+1];
            isMerged[i] = true;
            isMerged[i+1] = true;
        }
        if(i<A.length) {
            lengthArray[j] = A[i];
        }
        return time;
    }

    public static void main(String[] args) {

//        ExecutorService cpuBound = Executors.newFixedThreadPool(4);
//        ExecutorService ioBound = Executors.newCachedThreadPool();
//
//        for (int i = 0; i < 100; i++) {
//            CompletableFuture.supplyAsync(()-> getOrders(), ioBound)
//                    .thenApply(order -> enrich(order), cpuBound)
//                    .thenApply(order -> performPayment(order))
//                    .thenApply(order -> dispatch(order))
//                    .thenAccept(order -> sendEmail(order));
    }

                
//        int[] A = {1000, 250, 100};
//        MergeOrder order = new MergeOrder();
//        int solution = order.solution(A);
//
//        System.out.println(solution);


}
