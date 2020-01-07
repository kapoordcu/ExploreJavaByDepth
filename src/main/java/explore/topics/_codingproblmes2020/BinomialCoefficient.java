package explore.topics._codingproblmes2020;

public class BinomialCoefficient {

    public static void main(String[] args) {
        BinomialCoefficient bnml = new BinomialCoefficient();
        System.out.println(bnml.solution(5, 3));
    }

    public int solution(int N, int K) {
        int bnmlCoeff = 1;

        K = K > N-K ? N-K: K;
        for (int i = 0; i < K; ++i) {
            bnmlCoeff *= (N - i);
            bnmlCoeff /= (i + 1);
        }

        return bnmlCoeff;

    }
}
