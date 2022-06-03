import java.util.ArrayList;

import javafx.scene.paint.Color;

// Création de l'objet Objectif
// Paramètres : x, y (position initale), couleur 
public class Objectif {

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

    public void setColor(Color color) {
        this.color = color;
    }

}
