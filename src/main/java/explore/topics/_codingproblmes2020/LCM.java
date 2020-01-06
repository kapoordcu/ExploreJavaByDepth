package explore.topics._codingproblmes2020;

public class LCM {
    public static void main(String[] args) {
        LCM lcm = new LCM();
        System.out.println(lcm.lcm(5, 6));
    }

    private int lcm(int a, int b) {
        GCD gcd = new GCD();
        return (a*b)/gcd.gcd(a, b);
    }
}
