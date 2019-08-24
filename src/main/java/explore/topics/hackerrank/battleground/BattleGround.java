package explore.topics.hackerrank.battleground;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BattleGround {

    public static void main(String[] args) {
        String S = "1A 1B,2C 2C";
        String T = "1B";

        BattleGround ground = new BattleGround();
        System.out.println(ground.solution(10, S, T));
    }
    private List<Point> positionHitPoints(int n, String hitPoints) {
        List<Point> hitsList = new ArrayList<Point>(n*n);

        String[] coords = hitPoints.split(" ");
        for (String coord : coords) {
            hitsList.add(new Point(coord));
        }
        return hitsList;

    }

    public List<Ship> positionShips(int n, String ships) {
        List<Ship> shipList = new ArrayList<Ship>(n*n);
        String[] shipsCoords = ships.split(",");
        for (String shipCoord : shipsCoords) {
            String[] coords = shipCoord.split(" ");
            shipList.add(new Ship(new Point(coords[0]), new Point(coords[1])));
        }
        return shipList;
    }

    public String solution(int N, String S, String T) {

        List<Ship> ships = positionShips(N, S);
        List<Point> hits = positionHitPoints(N, T);

        int hit = 0;
        int sunk = 0;

        Iterator<Ship> shipIterator = ships.iterator();
        while (shipIterator.hasNext()) {
            Ship current = shipIterator.next();
            int touching = (int)current.countHits(hits);
            if (touching > 0) {
                if (touching == current.getSize()) {
                    sunk++;
                } else {
                    hit++;
                }
            }
        }

        return "" + sunk + "," + hit;
    }

}

class Point {
    int row;
    int column;

    public Point(String cellIdentifier) {
        column = (cellIdentifier.toUpperCase().charAt(1)) - ('A');
        row = (cellIdentifier.charAt(0)) - ('1');
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean insideShip(Point other) {
        return row >= other.row && column >= other.column;
    }

    @Override
    public String toString() {
        return "Point{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }
}
class Ship  {
    private Point topLeft;
    private Point bottomRight;

    public Ship(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public Point getBottomRight() {
        return bottomRight;
    }

    public int getSize() {
        return (Math.abs(topLeft.getRow() - bottomRight.getRow()) + 1)
                * (Math.abs(topLeft.getColumn() - bottomRight.getColumn()) + 1);
    }

    @Override
    public String toString() {
        return "(" + topLeft + ", " + bottomRight + ")";
    }

    public long countHits(List<Point> shots) {
        return shots.stream()
                .filter(point-> point.insideShip(topLeft) && bottomRight.insideShip(point))
                .count();

    }
}