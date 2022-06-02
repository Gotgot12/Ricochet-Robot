import java.util.ArrayList;

import javafx.scene.paint.Color;

public class Objectif extends Board {

    private int x;
    private int y;
    private Color color;

    public Objectif(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public ArrayList<Integer> getPosition() {
        ArrayList<Integer> position = new ArrayList<Integer>(2);
        position.add(x);
        position.add(y);

        return position;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

}
