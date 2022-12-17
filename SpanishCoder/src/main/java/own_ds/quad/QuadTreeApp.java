package own_ds.quad;

import java.util.ArrayList;
import java.util.Random;

public class QuadTreeApp {
    private static Random r = new Random();
    private static int MAX_DIM = 200;
    private static int TH = 4;

    public static void main(String[] args) {

        Rectangle boundary = new Rectangle(MAX_DIM, MAX_DIM, MAX_DIM, MAX_DIM);
        QuadTree qTree = new QuadTree(boundary, TH);
        for (int i = 0; i < 50; i++) {
            Point p = new Point(r.nextInt(MAX_DIM), r.nextInt(MAX_DIM));
            qTree.insert(p);
        }
        System.out.println();
    }
}
