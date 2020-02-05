package explore.topics._stacks_queues;

import java.util.Stack;

public class NextLargerElement {
    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 4};
        int[] arr2 = { 4, 3, 2, 1};
        int[] arr3 = { 1, 2, 5, 4};


        findNextLarger(arr1);
        findNextLarger(arr2);
        findNextLarger(arr3);
        System.out.println();
    }

    //Time Complexity: O(n).
    private static void findNextLarger(int[] arr) {
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length-1; i >= 0 ; i--) {
            if(s.isEmpty()) {
                s.push(arr[i]);
                arr[i] = -1;
            } else {
                Integer pop = s.pop();
                if(pop>arr[i]) {
                    s.push(arr[i]);
                    arr[i] = pop;
                } else {
                    s.push(pop);
                    arr[i] =   -1;
                }
            }
        }
    }
}
