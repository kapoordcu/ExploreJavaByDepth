package explore.topics._geometry;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuadTree {

    public static Random rand = new Random();


    public Rectangle boundry;
    public int capacity;
    public boolean divided;
    public List<Point> points;
    public QuadTree northwest;
    public QuadTree northeast;
    public QuadTree southeast;
    public QuadTree southwest;

    public QuadTree(Rectangle boundry, int capacity) {
        this.boundry = boundry;
        this.capacity = capacity;
        this.points = new ArrayList<>();
        divided = false;
    }


    public static void main(String[] args) {
        int width = 200;
        int height = 200;
        Rectangle boundry = new Rectangle(200, 200, width, height);
        QuadTree qtree = new QuadTree(boundry, 4);

        for (int i = 0; i < 100; i++) {
            Point p = new Point(rand.nextInt(width), rand.nextInt(height));
            qtree.insert(p);

        }
        qtree.points.listIterator().forEachRemaining(System.out::println);
    }

    private boolean insert(Point point) {
        if(!this.boundry.contains(point)) {
            return false;
        }
        if(this.points.size()<capacity) {
            this.points.add(point);
            return true;
        } else {
            if(!divided) {
                subdivide();
            }

            if(this.northeast.insert(point)) {
                return true;
            } else if(this.northwest.insert(point)) {
                return true;
            } else if(this.southeast.insert(point)) {
                return true;
            } else if(this.southwest.insert(point)) {
                return true;
            }
        }
        return false;
    }

    private void subdivide() {
        int x = boundry.x;
        int y = boundry.y;
        int w = boundry.w;
        int h = boundry.h;
        Rectangle ne = new Rectangle(x+w/2, y+h/2, w/2, h/2);
        Rectangle nw = new Rectangle(x-w/2, y+h/2, w/2, h/2);
        Rectangle se = new Rectangle(x+w/2, y-h/2, w/2, h/2);
        Rectangle sw = new Rectangle(x-w/2, y-h/2, w/2, h/2);

        this.northeast = new QuadTree(ne, capacity);
        this.northwest = new QuadTree(nw, capacity);
        this.southeast = new QuadTree(se, capacity);
        this.southwest = new QuadTree(sw, capacity);

        divided = true;
    }
}

class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Rectangle {
    public int x;
    public int y;
    public int w;
    public int h;

    public Rectangle(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public boolean contains(Point point) {
        return point.x >= this.x-this.w/2 &&
                point.x <= this.x+this.w/2 &&
                point.y >= this.y-this.h/2 &&
                point.y >= this.y+this.h/2 ;
    }
}


//class Point {
//    constructor(x, y) {
//        this.x = x;
//        this.y = y;
//    }
//}
//
//class Rectangle {
//    constructor(x, y, w, h) {
//        this.x = x;
//        this.y = y;
//        this.w = w;
//        this.h = h;
//    }
//    contains(point) {
//        return (point.x >= this.x-this.w/2 &&
//                point.x <= this.x+this.w/2 &&
//                point.y >= this.y-this.h/2 &&
//                point.y <= this.y+this.h/2) ;
//    }
//}
//
//class QuadTree {
//    constructor(boundry, n) {
//        this.boundry = boundry;
//        this.capacity = n;
//        this.points = [];
//        this.divided = false;
//    }
//
//    subdivide() {
//        let x = this.boundry.x;
//        let y = this.boundry.y;
//        let w = this.boundry.w;
//        let h = this.boundry.h;
//        let ne = new Rectangle(x+w/2, y+h/2, w/2, h/2);
//        let nw = new Rectangle(x-w/2, y+h/2, w/2, h/2);
//        let sw = new Rectangle(x-w/2, y-h/2, w/2, h/2);
//        let se = new Rectangle(x+w/2, y-h/2, w/2, h/2);
//
//
//        this.northeast = new QuadTree(ne, this.capacity);
//        this.northwest = new QuadTree(nw, this.capacity);
//        this.southeast = new QuadTree(se, this.capacity);
//        this.southwest = new QuadTree(sw, this.capacity);
//
//        this.divided = true;
//    }
//
//    insert(point) {
//        if(!this.boundry.contains(point)) {
//            return false;
//        }
//        if(this.points.length < this.capacity) {
//            this.points.push(point);
//        } else {
//            if(!this.divided) {
//                this.subdivide();
//
//            }
//
//            if(this.northeast.insert(point)) {
//                return true;
//            } else if(this.northwest.insert(point)) {
//                return true;
//            } else if(this.southeast.insert(point)) {
//                return true;
//            } else if(this.southwest.insert(point)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    show() {
//        stroke(255);
//        rectMode(CENTER);
//        rect(this.boundry.x, this.boundry.y, this.boundry.w*2, this.boundry.h*2);
//        if(this.divided) {
//            this.northeast.show();
//            this.northwest.show();
//            this.southeast.show();
//            this.southwest.show();
//        }
//    }
//}
//
//    function setup() {
//        createCanvas(400, 400);
//        let boundry = new Rectangle(200, 200, 200, 200);
//        let qtree = new QuadTree(boundry, 4);
//        console.log(qtree);
//        for (let i = 0; i < 50; i++) {
//            let p = new Point(random(width), random(height));
//            qtree.insert(p);
//
//        }
//        background(0);
//        qtree.show();
//    }