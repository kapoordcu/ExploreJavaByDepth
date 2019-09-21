package explore.topics.design.factory;

//  In Factory pattern, we create object without exposing the creation logic to client and the client use the same
//  common interface to create new type of object.

//The idea is to use a static member-function (static factory method) which creates & returns instances, hiding the details of class modules from user.

// valueOf() method in wrapper classes like Boolean, Integer etc.
//  Factory Design Pattern Advantages
//        Factory design pattern provides approach to code for interface rather than implementation.
//        Factory pattern removes the instantiation of actual implementation classes from client code. Factory pattern makes our code more robust, less coupled and easy to extend. For example, we can easily change PC class implementation because client program is unaware of this.
//        Factory pattern provides abstraction between implementation and client classes through inheritance.

// https://www.geeksforgeeks.org/design-patterns-set-2-factory-method/

public class FactoryApp {


    public static void main(String[] args) {
        Point pointDirect = Point.Factory.oneType(3, 7);
        Point pointFactory = Point.Factory.twoType(3, 7);
        Boolean.valueOf("0");
        System.out.println(pointDirect);
        System.out.println(pointFactory);
    }

}

class Point {

    private double x;
    private double y;

    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    static class Factory {
        public static Point oneType(double one, double two) {
            return new Point(one, two);
        }

        public static Point twoType(double one, double two) {
            return new Point(one*Math.cos(two), one*Math.sin(two));
        }
    }
}

