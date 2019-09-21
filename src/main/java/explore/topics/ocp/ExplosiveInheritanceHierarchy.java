package explore.topics.ocp;

public class ExplosiveInheritanceHierarchy {
    public static void main(String[] args) {
        Abs1 abs1 = new Class1();
        Abs2 abs2 = new Class2();
        Abs3 abs3 = new Class3();
        ((Class1) abs1).m1();
        ((Class2) abs2).m2();
        ((Class3) abs3).m3();
    }
}


abstract class Abs1 {
    protected Class1 class1;
}

abstract class Abs2 {
    protected Class2 class2;
}

abstract class  Abs3 {
    protected Class3 class3;
}


class Class1 extends Abs1 {
    public void m1() {
        System.out.println("m1 method in Class1.");
    }
}

class Class2 extends Abs2 {
    public void m2() {
        System.out.println("m2 method in Class2");
    }
}

class Class3 extends Abs3 {
    public void m3() {
        System.out.println("m3 method in Class3");
    }
}