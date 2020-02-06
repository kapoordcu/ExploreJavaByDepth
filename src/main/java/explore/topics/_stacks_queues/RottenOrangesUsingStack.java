package explore.topics._stacks_queues;

import java.util.Arrays;
import java.util.Stack;

public class RottenOrangesUsingStack {

    private static Stack<Element> elementStack = new Stack<>();
    private static int rounds = 0;

    static class Element {
        public int row;
        public int column;
        public int value;

        public Element(int value, int row, int column) {
            this.value = value;
            this.row = row;
            this.column = column;
        }
    }

    public static void main(String[] args) {
        int[][] A = {
                {2, 1, 0, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 0, 0, 0, 2}
        };

        int rounds = findCount(A);
        boolean possible = true;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if(A[i][j]==1) {
                    possible = false;
                }
            }
        }

        System.out.println(rounds + " rounds run");
        if(!possible) {
            System.out.println("But, All oranges cannot be rotten.");
        }
    }

    private static int findCount(int[][] A) {
        while (true) {
            int[][] dataCopy = Arrays.stream(A)
                    .map((int[] row) -> row.clone())
                    .toArray((int length) -> new int[length][]);
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[i].length; j++) {
                    if(A[i][j]==1) {
                        elementStack.push(new Element(A[i][j], i, j));
                    }
                }
            }
            if(elementStack.isEmpty()) {
                return rounds;
            }
            while (!elementStack.isEmpty()) {
                Element pop = elementStack.pop();
                rotten(A, pop);
            }
            if(Arrays.deepEquals(A, dataCopy)) {
                return rounds;
            }
            rounds++;
        }
    }

    private static void rotten(int[][] A, Element pop) {
        int r = pop.row;
        int c = pop.column;
        // UP
        if(r-1 >=0 && r-1 < A.length && A[r-1][c] == 2) {
            A[r][c] = 2;
            pop.value = 2;
        }
        //Down
        if(r+1 < A.length && A[r+1][c] == 2) {
            A[r][c] = 2;
            pop.value = 2;
        }
        //Left
        if(c-1 >=0 && c-1 < A[r].length && A[r][c-1] == 2) {
            A[r][c] = 2;
            pop.value = 2;
        }
        if(c+1 < A[r].length && A[r][c+1] == 2) {
            A[r][c] = 2;
            pop.value = 2;
        }


    }
}
