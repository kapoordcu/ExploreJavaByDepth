package own_ds.quad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rectangle {
    private int x;
    private int y;
    private int w;
    private int h;

    public boolean contains(Point point) {
        return point.getX() > this.x - w &&
                point.getX() < this.x + w &&
                point.getY() > this.y - h &&
                point.getX() < this.y + h;
    }
}
