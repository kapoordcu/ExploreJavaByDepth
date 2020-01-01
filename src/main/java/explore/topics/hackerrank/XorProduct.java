package explore.topics.hackerrank;

public class XorProduct {
    public static void main(String[] args) {
        XorProduct product = new XorProduct();
        System.out.println(product.solution(5, 8));
    }


    public int solution(int M, int N) {
        return calculate(M-1)^calculate(N);
    }

    private int calculate(int n) {
        if (n % 4 == 0)
            return n;
        if (n % 4 == 1)
            return 1;
        if (n % 4 == 2)
            return n + 1;
        return 0;
    }
}
