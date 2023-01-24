package org.tomtom;

import org.junit.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReachHospitalsDistrict {


    public int dijkstra(int[][] graph, int sourceVertex){
        int max = Integer.MIN_VALUE;
        int vertexCount = graph.length;
        boolean[] visitedVertex = new boolean[vertexCount];
        int[] distance = new int[vertexCount];
        for (int i = 0; i < vertexCount; i++){
            visitedVertex[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }
        distance[sourceVertex] = 0; // distance of source vertex to itself is zero
        for (int i = 0; i < vertexCount; i++){
            int u = findMinDistance(distance, visitedVertex);
            visitedVertex[u] = true;
            for (int v =0 ; v < vertexCount; v++){
                if(!visitedVertex[v] && graph[u][v] != 0 && (distance[u] + graph[u][v] < distance[v])){
                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }
        for (int i = 0; i < distance.length; i++){
            max = Math.max(max, distance[i]);
        }
        return max;
    }

    private int[][] createGraph(int N, int[] A, int[] B) {
        int[][] graph = new int[A.length+1][B.length+1];
        for (int i = 0; i < A.length; i++) {
            graph[A[i]][B[i]] = 1;
        }
        return graph;
    }
    private int findMinDistance(int[] distance, boolean[] visitedVertex) {
        int minDistance = Integer.MAX_VALUE;
        int minDistanceVertex = -1;
        for (int i =0; i < distance.length; i++){
            if(!visitedVertex[i] && distance[i] < minDistance){
                minDistance = distance[i];
                minDistanceVertex = i;
            }
        }
        return minDistanceVertex;
    }

    public int solution(int N, int[] A, int[] B, int[] H) {
        Set<Integer> nodes = new HashSet<>();

        for (int i = 0; i < H.length; i++) {
            nodes.add(H[i]);
        }

        if(nodes.size() == N) {
            return 0;
        }
        nodes.clear();
        int graph[][] = createGraph(N, A, B);
        int max = 0;
        ReachHospitalsDistrict t = new ReachHospitalsDistrict();

        for (Integer node:         A) {
            nodes.add(node);
        }
        for (Integer node:         B) {
            nodes.add(node);
        }
        for (Integer node:         H) {
            nodes.remove(node);
        }

        for (Integer node:         nodes) {
            int maxDist = dijkstra(graph, node);
            max = Math.max(maxDist, max);
        }
        return max;
    }

    @Test
    public void test01() {
        int[] A = {0, 1, 1, 3, 0};
        int[] B = {1, 2, 3, 4, 5};
        int[] H = {2, 4};

        int yes = solution(A.length, A, B, H);

    }


}
