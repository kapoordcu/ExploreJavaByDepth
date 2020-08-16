package explore.topics.testlive.toptal;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MaxPointsInsideCircle {
    public int solution(String S, int[] X, int[] Y) {

        List<IncludePoint> tags = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            char tag = S.charAt(i);
            IncludePoint po = new IncludePoint(tag, X[i], Y[i]);
            if(!tags.contains(po)) {
                tags.add(po);
            }
        }

        Collections.sort(tags);
        Set<Character> tagUnique = new HashSet<>();
        for (IncludePoint point:         tags) {
            if(!tagUnique.contains(point.tag)) {
                tagUnique.add(point.tag);
            } else {
                return tagUnique.size();
            }
        }
        return 0;
    }

    @Test
    public void getCompressedForm() {
        MaxPointsInsideCircle q1= new MaxPointsInsideCircle();
        int[] X = {2,-1,-4,-3,3};
        int[] Y = {2, -2, 4, 1, 3};
        int abdca = q1.solution("ABDCA", X, Y);
        assertEquals(abdca, 3);

    }
}

class IncludePoint implements Comparable<IncludePoint>{
    char tag;
    int x;
    int y;
    public double distance = 0;

    public IncludePoint(char tag, int x, int y) {
        this.tag = tag;
        this.x=x;
        this.y=y;
        this.distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    @Override
    public int compareTo(IncludePoint other) {
        return distance < other.distance ? -1 : 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IncludePoint that = (IncludePoint) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}