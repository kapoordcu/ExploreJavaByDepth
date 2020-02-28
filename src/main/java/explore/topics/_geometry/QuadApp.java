package explore.topics._geometry;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuadApp {
    public static Random rand = new Random();
    public static void main(String[] args) {
        int width = 200;
        int height = 200;
        Rect boundary = new Rect(new Point(200, 200), width, height);
        QuadTree qTree = new QuadTree(boundary, 4);
        for (int i = 0; i < 1000; i++) {
            Point point = new Point(rand.nextInt(width), rand.nextInt(height));
            qTree.insert(point);
        }
        System.out.println(qTree);
    }
}

class QuadTree {
    public Rect boundary;
    public int capacity;
    public List<Point> points;
    public boolean divided;
    public QuadTree northEast;
    public QuadTree northWest;
    public QuadTree southWest;
    public QuadTree southEast;

    public QuadTree(Rect boundary, int capacity) {
        this.boundary = boundary;
        this.capacity = capacity;
        this.points = new ArrayList<>();
        this.divided = false;
        this.northEast = null;
        this.northWest = null;
        this.southWest = null;
        this.southEast = null;
    }

    public boolean insert(Point point) {
        if(this.points.size()<capacity) {
            this.points.add(point);
            return true;
        } else {
            if(!this.divided) {
                this.subdivideFurther();
            }
            if(this.northEast.insert(point)) {
                return true;
            } else if(this.northWest.insert(point)) {
                return true;
            } else if(this.southWest.insert(point)) {
                return true;
            } else if(this.southEast.insert(point)) {
                return true;
            }
        }
        return false;
    }

    private void subdivideFurther() {
        double x = this.boundary.center.x;
        double y = this.boundary.center.y;
        double w = this.boundary.width;
        double h = this.boundary.height;

        Rect ne = new Rect(new Point(x + w/4, y + h/4), w/2, h/2);
        Rect nw = new Rect(new Point(x - w/4, y + h/4), w/2, h/2);
        Rect sw = new Rect(new Point(x - w/4, y - h/4), w/2, h/2);
        Rect se = new Rect(new Point(x + w/4, y - h/4), w/2, h/2);
        this.northEast = new QuadTree(ne, this.capacity);
        this.northWest = new QuadTree(nw, this.capacity);
        this.southWest = new QuadTree(sw, this.capacity);
        this.southEast = new QuadTree(se, this.capacity);

        this.divided = true;
    }
}

class Rect {
    public Point center;
    public  double width;
    public  double height;

    public Rect(Point center, double width, double height) {
        this.center = center;
        this.width = width;
        this.height = height;
    }
}

class Point {
    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

