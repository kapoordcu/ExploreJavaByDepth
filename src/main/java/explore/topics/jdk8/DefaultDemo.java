package explore.topics.jdk8;

public class DefaultDemo {
    public static void main(String[] args) {
       A clazz = new C();
       clazz.show();
       I.showStatic();
    }
}

interface I {
    static void showStatic() {
        System.out.println("Static inside interface");
    }
    default void show() {
        System.out.println("I");
    }
}

interface J {
    default void show() {
        System.out.println("J");
    }
}

class A {
    public void show() {
        System.out.println("A");
    }
}

class C extends A implements I, J {

}

interface I1 {
//    default boolean equals(Object o) {
//        return true;
//    }
}