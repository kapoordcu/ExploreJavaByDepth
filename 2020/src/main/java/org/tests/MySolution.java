package org.tests;

import org.junit.Test;

import java.util.*;

public class MySolution {
    public int solution(int [][] A) {
        Set<Node> nodes = new HashSet<>();

        int result = 0;
        int row = A.length;
        int column = A[0].length;

        if(row ==1 && column ==1) {
            return 1;
        }
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                if(A[i][j] != Integer.MIN_VALUE) {
                    if(checkNeighbourSame(A, i, j, nodes)) {
                        makeNodesVisited(nodes, A);
                        result++;
                    }
                }
            }
        }

        return result;
    }

    private void makeNodesVisited(Set<Node> nodes, int[][] A) {
        for (Node n : nodes) {
            A[n.x][n.y] = Integer.MIN_VALUE;
        }
        nodes.clear();
    }

    public boolean checkNeighbourSame(int [][]A ,int i, int j, Set<Node> nodes) {
        int row = A.length;
        int column = A[0].length;
        if(i < 0 || i >= row || j <0||j>=column) {
            return false;
        }
        if((i < row-1 ) && A[i+1][j] == A[i][j]) {
            nodes.add(new Node(i, j));
            return checkNeighbourSame(A, i+1, j, nodes);
        }

        if((j < column-1 ) && A[i][j+1] == A[i][j]) {
            nodes.add(new Node(i, j));
            return checkNeighbourSame(A, i, j + 1, nodes);
        }
        nodes.add(new Node(i, j));
        return true;
    }


    @Test
    public void one() {
        int[][] A = {
                {5, 4, 4},
                {4, 3, 4},
                {3, 2, 4},
                {2, 2, 2},
                {3, 3, 4},
                {1, 4, 4},
                {4, 1, 1}
        };
        MySolution countriesCount = new MySolution();
        System.out.println(countriesCount.solution(A));
    }

    class Node {
        private int x;
        private int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x &&
                    y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}

