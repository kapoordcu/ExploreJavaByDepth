package explore.topics.design.aSqRect;

public class SquareRectangleProblem {
    public static void main(String[] args) {
        Rectangle rectangle = new Square(10, 10);
        rectangle.setWidth(20);

        System.out.println(rectangle.getWidth());
        System.out.println(rectangle.getBreadth());

    }
}

class Rectangle {
    private Integer width;
    private Integer breadth;

    public Rectangle(Integer width, Integer breadth) {
        this.width = width;
        this.breadth = breadth;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public void setBreadth(Integer breadth) {
        this.breadth = breadth;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getBreadth() {
        return breadth;
    }
}

class Square extends Rectangle {
    private Integer width;
    private Integer breadth;

    public Square(Integer width, Integer breadth) {
        super(width, breadth);
        this.width = width;
        this.breadth = width;
    }

    @Override
    public Integer getWidth() {
        return width;
    }

    @Override
    public Integer getBreadth() {
        return breadth;
    }

    @Override
    public void setWidth(Integer width) {
        this.width = width;
        this.breadth = width;
    }

    @Override
    public void setBreadth(Integer breadth) {
        this.breadth = breadth;
        this.width = breadth;
    }
}