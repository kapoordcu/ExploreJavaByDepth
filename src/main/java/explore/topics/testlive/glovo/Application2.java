package explore.topics.testlive.glovo;

public class Application2 {

    public static void main(String[] args) {
        Application2 app = new Application2();
        int solution = app.solution(5, 3);
        System.out.println(solution);
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
