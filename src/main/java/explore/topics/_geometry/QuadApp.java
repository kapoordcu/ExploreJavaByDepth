package explore.topics._geometry;

import java.util.*;

public class QuadApp {
    public static Random rand = new Random();
    public static int TOTAL_POINTS = 1000000;
    public static int RANGE_RECT_WIDTH = 200;
    public static int RANGE_RECT_HEIGHT = 200;

    public static void main(String[] args) {
        Rect boundary = new Rect(new Point(200, 200), RANGE_RECT_WIDTH, RANGE_RECT_HEIGHT);
        QuadTree qTree = new QuadTree(boundary, 4);
        for (int i = 0; i < TOTAL_POINTS; i++) {
            Point point = new Point(rand.nextInt(RANGE_RECT_WIDTH), rand.nextInt(RANGE_RECT_HEIGHT));
            qTree.insert(point);
        }

        //Point center = new Point(rand.nextInt(250), rand.nextInt(250));
        int rangerectX = rand.nextInt(RANGE_RECT_WIDTH);
        int rangerectY = rand.nextInt(RANGE_RECT_HEIGHT);
        Point center = new Point(rangerectX, rangerectY);
        Rect range = new Rect(center, 100, 100);
        List<Point> intersactionAreaPoints = new ArrayList<>();
        List<Point> points = qTree.query(range, intersactionAreaPoints);
        System.out.println("The rectangle range is (" + rangerectX + " , " + rangerectY + ") from a sample space ("
                + RANGE_RECT_WIDTH + " , " + RANGE_RECT_HEIGHT + ")");
        System.out.println(points.size() + " points (out of " + TOTAL_POINTS + ") found in the intersection area" );
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
    }

    public boolean insert(Point point) {
        if(!this.boundary.contains(point)) {
            return false;
        }
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

    public List<Point> query(Rect range, List<Point> pointsIntersect) {
        if(!this.boundary.intersects(range)) {
            return pointsIntersect;
        } else {
            for (Point p:  this.points) {
                if(range.contains(p)) {
                    pointsIntersect.add(p);
                }
            }
            if(this.divided) {
                this.northEast.query(range, pointsIntersect);
                this.northWest.query(range, pointsIntersect);
                this.southWest.query(range, pointsIntersect);
                this.southEast.query(range, pointsIntersect);
            }
        }
        return pointsIntersect;
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

    public boolean intersects(Rect range) {
        return !(range.center.x - range.width/2 > this.center.x + this.width/2 ||
                range.center.x + range.width/2 < this.center.x - this.width/2 ||
                range.center.y - range.height/2 > this.center.y + this.height/2 ||
                range.center.y + range.height/2 < this.center.y - this.height/2);
    }

    public boolean contains(Point point) {
        return (point.x >= this.center.x-this.width/2 &&
                point.x <= this.center.x+this.width/2 &&
                point.y >= this.center.y-this.height/2 &&
                point.y <= this.center.y+this.height/2) ;
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

