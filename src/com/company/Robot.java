import javafx.scene.paint.Color;

public class Robot extends Board {

    private int x;
    private int y;

    private Color color;

    public Robot(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public int[] getPosition() {
        int[] position = { x, y };
        return position;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

}
