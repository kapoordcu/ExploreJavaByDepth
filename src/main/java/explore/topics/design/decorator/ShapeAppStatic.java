package explore.topics.design.decorator;

import java.util.function.Supplier;

public class ShapeAppStatic {
    public static void main(String[] args) {
        ColoredShapeStatic<SquareStatic> blueSquare = new ColoredShapeStatic<SquareStatic>(
                () -> new SquareStatic(20),
                "blue"
        );
        System.out.println(blueSquare.infoStatic());
        TransparentShapeStatic<ColoredShapeStatic> transparentColoredShapeCircle =
                new TransparentShapeStatic<>(() ->
                        new ColoredShapeStatic(() ->
                                new CircleStatic(7), "yellow"),
                34
        );
        System.out.println(transparentColoredShapeCircle.infoStatic());
    }
}

interface ShapeStatic {
    String infoStatic();
}

// Static decorators
class CircleStatic implements ShapeStatic {
    private float radius;

    public CircleStatic() {}

    public CircleStatic(float radius) {
        this.radius = radius;
    }

    void resizeStatic(float factor) {
        radius *= factor;
    }

    @Override
    public String infoStatic() {
        return "A CircleStatic of radius " + radius;
    }
}


class SquareStatic implements ShapeStatic {
    private float side;

    public SquareStatic() {}

    public SquareStatic(float side) {
        this.side = side;
    }

    void resizeStatic(float factor) {
        side *= factor;
    }

    @Override
    public String infoStatic() {
        return "A SquareStatic of side " + side;
    }
}

class ColoredShapeStatic<T extends ShapeStatic> implements ShapeStatic {
    private ShapeStatic shape;
    private String color;

    public ColoredShapeStatic(Supplier<? extends T> supplier, String color) {
        this.shape = supplier.get();
        this.color = color;
    }

    @Override
    public String infoStatic() {
        return shape.infoStatic() + " has the color " + color;
    }
}

class TransparentShapeStatic<T extends ShapeStatic> implements ShapeStatic {
    private ShapeStatic shape;
    private int transparency;

    public TransparentShapeStatic(Supplier<? extends T> supplier, int transparency) {
        this.shape = supplier.get();
        this.transparency = transparency;
    }

    @Override
    public String infoStatic() {
        return shape.infoStatic() + " has the " + transparency + "% transparency";
    }
}