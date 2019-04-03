package explore.topics.ocp;

public class InheritanceBreaksEncapsulation {
    public static void main(String[] args) {
        MySuperClass superClass = new MyVerboseSuperClass();
        superClass.printMe();

    }
}


class MySuperClass {
    public void printMe() {
        printMeNTimes(1);
    }

    public void printMeNTimes(int N) {
        for (int i = 0; i < N; i++) {
            System.out.println("Print Me.");
        }
    }
}

class MyVerboseSuperClass extends MySuperClass {
    @Override
    public void printMeNTimes(int N) {
        for (int i = 0; i < N; i++) {
            printMe();
        }
    }

}