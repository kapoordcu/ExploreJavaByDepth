package explore.topics._codingproblmes2020;

public class BinomialCoefficient {

    public static void main(String[] args) {
        BinomialCoefficient bnml = new BinomialCoefficient();
        System.out.println(bnml.solution(5, 3));
    }

    public int solution(int N, int K) {
        // (n, K) = (n-1, K) + (n, K-1)
        // (5, 3) = (5, 2) + (4,
        int bnmlCoeff = 1;

        K = K > N-K ? N-K: K;
        for (int i = 1, m=N; i <= K; i++, m--) {
            bnmlCoeff *= m/i;
        }


        return bnmlCoeff;

    }
}
