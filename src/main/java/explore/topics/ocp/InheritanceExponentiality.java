package explore.topics.ocp;

public class InheritanceExponentiality {
    public static void main(String[] args) {
        double d1 = 0d;
        float f1 = (float) d1;
        System.out.println(f1);
        float f2 = 1f;
        double d2 = (double) f2;
        System.out.println(d2);
    }
}


interface I1 {
    void m1();
}

class C1 implements I1 {
    @Override
    public void m1() {
        System.out.println("m1 method in C1 class.");
    }
}

interface I2 {
    void m2();
}

class C2 implements I2 {
    @Override
    public void m2() {
        System.out.println("m2 method in C2 class.");
    }
}

interface I3 extends I1, I2 {
    void m3();
}
// Compilation Error
//class C3 implements I3 {
//    @Override
//    public void m3() {
//        System.out.println("m3 method in C3 class.");
//    }
//
//}