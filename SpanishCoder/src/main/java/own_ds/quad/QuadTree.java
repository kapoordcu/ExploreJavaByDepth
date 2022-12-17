package own_ds.quad;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class QuadTree {
    private Rectangle boundary;
    private int capacity;
    private List<Point> points;
    private boolean divided;

    private QuadTree topRight;
    private QuadTree topLeft;
    private QuadTree bottomRight;
    private QuadTree bottomLeft;

    public QuadTree(Rectangle boundary, int capacity) {
        this.boundary = boundary;
        this.capacity = capacity;
        this.points = new ArrayList<>();
        this.divided = false;
        this.topRight = null;
        this.topLeft = null;
        this.bottomRight = null;
        this.bottomLeft = null;
    }

    public void insert(Point point) {
        if(!this.boundary.contains(point)) {
            return;
        }
        if(this.points.size() < capacity) {
            this.points.add(point);
            return;
        } else if(!this.divided){
            this.subdivide();
        }
        this.topRight.insert(point);
        this.topLeft.insert(point);
        this.bottomLeft.insert(point);
        this.bottomRight.insert(point);
    }

    private void subdivide() {
        int x = boundary.getX();
        int y = boundary.getY();
        int w = boundary.getW();
        int h = boundary.getH();
        Rectangle topR = new Rectangle(x + w/2, y + h/2, w/2, h/2);
        Rectangle topL = new Rectangle(x - w/2, y + h/2, w/2, h/2);
        Rectangle bottomR = new Rectangle(x + w/2, y - h/2, w/2, h/2);
        Rectangle bottomL = new Rectangle(x - w/2, y - h/2, w/2, h/2);

        this.topRight = new QuadTree(topR, capacity);
        this.topLeft = new QuadTree(topL, capacity);
        this.bottomRight = new QuadTree(bottomR, capacity);
        this.bottomLeft = new QuadTree(bottomL, capacity);
        this.divided = true;
    }
}
