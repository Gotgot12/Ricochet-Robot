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

    public Boolean[] getBordure() {
        Boolean[] bordure = { Nord, Est, Sud, Ouest };
        return bordure;
    }

    public void setBordure(Boolean Nord, Boolean Est, Boolean Sud, Boolean Ouest) {
        this.Nord = Nord;
        this.Est = Est;
        this.Sud = Sud;
        this.Ouest = Ouest;
    }

    public int[] getPosition() {
        int[] position = { x, y };
        return position;
    }

}
