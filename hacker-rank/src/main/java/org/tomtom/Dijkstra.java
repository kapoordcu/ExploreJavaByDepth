package org.tomtom;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Dijkstra {

    private int[] dijkstra(int[][] graph, int src) {
        int v = graph[0].length;
        int[] parent = new int[v];
        int[] values = new int[v];
        boolean[] processed = new boolean[v];

        Arrays.fill(values, Integer.MAX_VALUE);

        values[src] = 0;
        parent[0] = -1;

        for (int i = 0; i < v; i++) {
            int minIndex = selectMinValueVertex(values, processed);
            processed[minIndex] = true;

            for (int j = 0; j < v; j++) {
                if(graph[minIndex][j] > 0 &&
                        processed[j]==false &&
                        values[minIndex] != Integer.MAX_VALUE &&
                        graph[minIndex][j] + values[minIndex] < values[j]
                ) {
                    values[j] = graph[minIndex][j] + values[minIndex];
                    parent[j] = minIndex;
                }
            }

        }
        return values;
    }

    private int selectMinValueVertex(int[] values, boolean[] processed) {
        int minValue = Integer.MAX_VALUE;
        int vertex = 0;
        for (int i = 0; i < values.length; i++) {
            if(values[i] < minValue && !processed[i]) {
                vertex = i;
                minValue = values[i];
            }
        }
        return vertex;
    }

    @Test
    public void test01() {
        int[][] graph = {
                {0, 1, 4, 0, 0, 0},
                {1, 0, 4, 2, 7, 0},
                {4, 4, 0, 3, 5, 0},
                {0, 2, 3, 0, 4, 6},
                {0, 7, 5, 4, 0, 7},
                {0, 0, 0, 6, 7, 0}
        };
        int[] result = {0, 1, 4, 3, 7, 9};
        int[] yes = dijkstra(graph, 0);
        for (int i = 0; i < result.length; i++) {
            assertEquals(result[i], yes[i]);
        }
    }

    @Test
    public void test02() {
        int[][] graph = {
                {0, 1, 4, 0, 0, 0},
                {1, 0, 4, 2, 7, 0},
                {4, 4, 0, 3, 5, 0},
                {0, 2, 3, 0, 4, 6},
                {0, 7, 5, 4, 0, 7},
                {0, 0, 0, 6, 7, 0}
        };
        int[] result = {0, 1, 4, 3, 7, 9};
        int[] yes = dijkstra(graph, 0);
        for (int i = 0; i < result.length; i++) {
            assertEquals(result[i], yes[i]);
        }
    }
}
