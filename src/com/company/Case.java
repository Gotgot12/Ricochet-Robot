import java.util.ArrayList;

public class Case extends Board {
    // Position
    private int x;
    private int y;

    // Bordure
    private Boolean Nord;
    private Boolean Est;
    private Boolean Sud;
    private Boolean Ouest;

    public Case(int x, int y, Boolean Nord, Boolean Est, Boolean Sud, Boolean Ouest) {
        this.x = x;
        this.y = y;
        this.Nord = Nord;
        this.Est = Est;
        this.Sud = Sud;
        this.Ouest = Ouest;
    }

    public ArrayList<Boolean> getBordure() {
        ArrayList<Boolean> bordure = new ArrayList<Boolean>(4);
        bordure.add(Nord);
        bordure.add(Est);
        bordure.add(Sud);
        bordure.add(Ouest);
        return bordure;
    }

    public void setBordure(Boolean Nord, Boolean Est, Boolean Sud, Boolean Ouest) {
        this.Nord = Nord;
        this.Est = Est;
        this.Sud = Sud;
        this.Ouest = Ouest;
    }

    public ArrayList<Integer> getPosition() {
        ArrayList<Integer> position = new ArrayList<Integer>(2);
        position.add(x);
        position.add(y);

        return position;
    }

}
