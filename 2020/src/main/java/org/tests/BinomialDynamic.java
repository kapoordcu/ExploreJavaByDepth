package org.tests;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BinomialDynamic {
    public int solution(int N, int K) {
        long limit = 1000_000_000;
        if(K==0 || N==K) {
            return 1;
        } else if(N > 0 && K > 0 && N > K) {
            return binomialAlgorithm(N, K, limit).intValue();
        }
        return -1;
    }

    private Long binomialAlgorithm(int N, int K, Long limit) {
        Long[][] binDyna = new Long[N+1][K+1];
        for (int i = 0; i <= N ; i++) {
            for (int j = 0; j <= Math.min(K, i); j++) {
                if(j==0 || i==j) {
                    binDyna[i][j] = 1l;
                } else {
                    binDyna[i][j] = binDyna[i-1][j-1] + binDyna[i-1][j];
                }
            }
        }
        return binDyna[N][K].compareTo(limit) > 0 ? -1 : binDyna[N][K];
    }

    @Test
    public void oneSImple() {
        BinomialDynamic one = new BinomialDynamic();
        long solution = one.solution(5, 3);
        assertTrue(solution == 10);
    }

    @Test
    public void oneSImple2() {
        BinomialDynamic one = new BinomialDynamic();
        long solution = one.solution(1, 3);
        assertTrue(solution == -1);
    }

    @Test
    public void oneSImple3() {
        BinomialDynamic one = new BinomialDynamic();
        long solution = one.solution(40, 20);
        assertTrue(solution == -1);
    }

}

