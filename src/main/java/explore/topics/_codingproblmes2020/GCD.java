package explore.topics._codingproblmes2020;

public class GCD {
    public static void main(String[] args) {
        GCD gcd = new GCD();
        System.out.println(gcd.gcd(7836, 100006));
    }

    public int gcd(int a, int b) {
        if(b==0) {
            return a;
        }
        return gcd(b, a%b);
    }
}
