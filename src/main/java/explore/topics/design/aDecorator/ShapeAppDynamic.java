package explore.topics.design.aDecorator;

// Decorator is used to decorate individual objects at run-time. Adapter is used to add features to the class and therefore to ALL of its objects.
public class ShapeAppDynamic {
    public static void main(String[] args) {
        Circle circle = new Circle(10);
        System.out.println(circle.info());

        ColoredShape redSquare = new ColoredShape(
                new Square(10), "red"
        );
        System.out.println(redSquare.info());

        TransparentShape transparentGreenCircle3_30 = new TransparentShape(new ColoredShape(new Circle(3), "green"), 30);
        System.out.println(transparentGreenCircle3_30.info());
    }
}


interface Shape {
    String info();
}

class Circle implements Shape {
    private float radius;

    public Circle() {}

    public Circle(float radius) {
        this.radius = radius;
    }

    void resize(float factor) {
        radius *= factor;
    }

    @Override
    public String info() {
        return "A circle of radius " + radius;
    }
}


class Square implements Shape {
    private float side;

    public Square() {}

    public Square(float side) {
        this.side = side;
    }

    void resize(float factor) {
        side *= factor;
    }

    @Override
    public String info() {
        return "A Square of side " + side;
    }
}

// Build a decorator
class ColoredShape implements Shape {
    private Shape shape;
    private String color;

    public ColoredShape(Shape shape, String color) {
        this.shape = shape;
        this.color = color;
    }

    @Override
    public String info() {
        return shape.info() + " has the color " + color;
    }
}

class TransparentShape implements Shape {
    private Shape shape;
    private int transparency;

    public TransparentShape(Shape shape, int transparency) {
        this.shape = shape;
        this.transparency = transparency;
    }

    @Override
    public String info() {
        return shape.info() + " has the " + transparency + "% transparency";
    }
}