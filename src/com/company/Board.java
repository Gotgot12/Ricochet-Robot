import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Board extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        final int boardSizeHorizontal = 16;
        final int boardSizeVertical = 16;

        GridPane grille = new GridPane();
        ArrayList<Case> listCase = new ArrayList<Case>();

        for (int i = 0; i < boardSizeHorizontal; i++) {
            for (int j = 0; j < boardSizeVertical; j++) {
                listCase.add(new Case(i, j, false, false, false, false));
                createBordure(grille, i, j);
            }
        }

        // Bordure sur l'ensemble des côtés du jeu
        for (int i = 0; i < 16; i++) {
            listCase.get(i).setBordure(false, false, false, true);
            modifBordure(grille, i, false, false, false, true);

            listCase.get(255 - i).setBordure(false, true, false, false);
            modifBordure(grille, 255 - i, false, true, false, false);
        }

        for (int i = 0; i < 256; i += 16) {
            listCase.get(i).setBordure(true, false, false, false);
            modifBordure(grille, i, true, false, false, false);

            listCase.get(255 - i).setBordure(false, false, true, false);
            modifBordure(grille, 255 - i, false, false, true, false);
        }

        listCase.get(0).setBordure(true, false, false, true);
        modifBordure(grille, 0, true, false, false, true);

        listCase.get(15).setBordure(false, false, true, true);
        modifBordure(grille, 15, false, false, true, true);

        listCase.get(240).setBordure(true, true, false, false);
        modifBordure(grille, 240, true, true, false, false);

        listCase.get(255).setBordure(false, true, true, false);
        modifBordure(grille, 255, false, true, true, false);

        // --------------- Configuration manuelle des murs

        // Planche ricochet robot 1 spe et Planche ricochet robot 3 spe
        setManualBordure(grille, listCase, 3, false, false, true, true);

        setManualBordure(grille, listCase, 4, true, false, false, true);

        setManualBordure(grille, listCase, 9, false, false, true, true);

        setManualBordure(grille, listCase, 10, true, false, false, true);

        setManualBordure(grille, listCase, 34, false, true, false, false);

        setManualBordure(grille, listCase, 35, false, false, true, false);

        setManualBordure(grille, listCase, 36, true, true, false, false);

        setManualBordure(grille, listCase, 46, false, true, false, false);

        setManualBordure(grille, listCase, 49, false, false, true, false);

        setManualBordure(grille, listCase, 50, true, false, false, true);

        setManualBordure(grille, listCase, 52, false, false, false, true);

        setManualBordure(grille, listCase, 62, false, false, true, true);

        setManualBordure(grille, listCase, 63, true, false, true, false);

        setManualBordure(grille, listCase, 67, false, true, false, false);

        setManualBordure(grille, listCase, 69, false, true, true, false);

        setManualBordure(grille, listCase, 70, true, false, false, false);

        setManualBordure(grille, listCase, 72, false, false, true, false);

        setManualBordure(grille, listCase, 73, true, true, false, false);

        setManualBordure(grille, listCase, 80, true, true, false, false);

        setManualBordure(grille, listCase, 83, false, false, true, true);

        setManualBordure(grille, listCase, 84, true, false, false, false);

        setManualBordure(grille, listCase, 85, false, false, false, true);

        setManualBordure(grille, listCase, 89, false, false, false, true);

        setManualBordure(grille, listCase, 93, false, true, false, false);

        setManualBordure(grille, listCase, 95, false, true, true, false);

        setManualBordure(grille, listCase, 96, true, false, false, true);

        setManualBordure(grille, listCase, 103, false, true, false, false);

        setManualBordure(grille, listCase, 104, false, true, false, false);

        setManualBordure(grille, listCase, 108, false, true, true, false);

        setManualBordure(grille, listCase, 109, true, false, false, true);

        setManualBordure(grille, listCase, 111, false, false, true, true);

        setManualBordure(grille, listCase, 118, false, false, true, false);

        setManualBordure(grille, listCase, 119, true, false, false, true);

        setManualBordure(grille, listCase, 120, false, false, true, true);

        setManualBordure(grille, listCase, 121, true, false, false, false);

        setManualBordure(grille, listCase, 124, false, false, false, true);

        // Planche ricochet robot 2 spe et Planche ricochet robot 4 spe

        setManualBordure(grille, listCase, 134, false, false, true, false);

        setManualBordure(grille, listCase, 135, true, true, false, false);

        setManualBordure(grille, listCase, 136, false, true, true, false);

        setManualBordure(grille, listCase, 137, true, false, false, false);

        setManualBordure(grille, listCase, 141, false, true, false, false);

        setManualBordure(grille, listCase, 145, false, true, true, false);

        setManualBordure(grille, listCase, 146, true, false, false, false);

        setManualBordure(grille, listCase, 151, false, false, false, true);

        setManualBordure(grille, listCase, 152, false, false, false, true);

        setManualBordure(grille, listCase, 156, false, false, true, false);

        setManualBordure(grille, listCase, 157, true, false, false, true);

        setManualBordure(grille, listCase, 161, false, false, false, true);

        setManualBordure(grille, listCase, 163, false, true, false, false);

        setManualBordure(grille, listCase, 165, false, false, true, false);

        setManualBordure(grille, listCase, 166, true, true, false, false);

        setManualBordure(grille, listCase, 169, false, true, true, false);

        setManualBordure(grille, listCase, 170, true, false, false, false);

        setManualBordure(grille, listCase, 175, false, true, true, false);

        setManualBordure(grille, listCase, 176, true, true, false, false);

        setManualBordure(grille, listCase, 179, false, false, true, true);

        setManualBordure(grille, listCase, 180, true, false, false, false);

        setManualBordure(grille, listCase, 182, false, false, false, true);

        setManualBordure(grille, listCase, 185, false, false, false, true);

        setManualBordure(grille, listCase, 191, false, false, true, true);

        setManualBordure(grille, listCase, 192, true, false, false, true);

        setManualBordure(grille, listCase, 199, false, true, false, false);

        setManualBordure(grille, listCase, 202, false, false, true, false);

        setManualBordure(grille, listCase, 203, true, true, false, false);

        setManualBordure(grille, listCase, 213, false, true, false, false);

        setManualBordure(grille, listCase, 215, false, false, true, true);

        setManualBordure(grille, listCase, 216, true, false, false, false);

        setManualBordure(grille, listCase, 219, false, false, true, true);

        setManualBordure(grille, listCase, 220, true, false, false, false);

        setManualBordure(grille, listCase, 228, false, false, true, false);

        setManualBordure(grille, listCase, 229, true, false, false, true);

        setManualBordure(grille, listCase, 242, false, true, true, false);

        setManualBordure(grille, listCase, 243, true, true, false, false);

        setManualBordure(grille, listCase, 252, false, true, true, false);

        setManualBordure(grille, listCase, 253, true, true, false, false);

        // Set Robot
        createRobot(grille, 3, 5, Color.GREEN);

        // Set Objectifs
        setObjectif(grille, 3, 2, Color.YELLOW);
        setObjectif(grille, 4, 9, Color.YELLOW);
        setObjectif(grille, 9, 1, Color.YELLOW);
        setObjectif(grille, 10, 9, Color.YELLOW);

        setObjectif(grille, 5, 3, Color.BLUE);
        setObjectif(grille, 6, 12, Color.BLUE);
        setObjectif(grille, 14, 5, Color.BLUE);
        setObjectif(grille, 9, 13, Color.BLUE);

        setObjectif(grille, 2, 4, Color.RED);
        setObjectif(grille, 3, 14, Color.RED);
        setObjectif(grille, 11, 3, Color.RED);
        setObjectif(grille, 12, 11, Color.RED);

        setObjectif(grille, 4, 5, Color.GREEN);
        setObjectif(grille, 6, 13, Color.GREEN);
        setObjectif(grille, 10, 6, Color.GREEN);
        setObjectif(grille, 13, 11, Color.GREEN);

        System.out.println(listCase.get(254).getPosition()[1]);
        Scene scene = new Scene(grille);
        primaryStage.setTitle("Ricochet Robot");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void createBordure(GridPane grille, int x, int y) {
        StackPane stackPane = new StackPane();
        Rectangle rectangle = new Rectangle();

        rectangle.setWidth(35);
        rectangle.setHeight(35);

        BorderStroke borderStroke = new BorderStroke(Color.LIGHTGREY, BorderStrokeStyle.SOLID, null,
                new BorderWidths(1));
        Border border = new Border(borderStroke);

        stackPane.setBorder(border);

        rectangle.setFill(Color.TRANSPARENT);
        stackPane.getChildren().add(rectangle);

        grille.add(stackPane, x, y);
    }

    public static void modifBordure(GridPane grille, int index, Boolean Nord, Boolean Est, Boolean Sud,
            Boolean Ouest) {
        if (Nord == true && Est == false && Sud == false && Ouest == false) {
            BorderStroke borderStroke = new BorderStroke(Color.BLACK, Color.LIGHTGREY, Color.LIGHTGREY,
                    Color.LIGHTGREY,
                    BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID,
                    null,
                    new BorderWidths(1), new Insets(0));
            Border border = new Border(borderStroke);
            StackPane stackPane = getCenteredNodeGridPane(grille, index);
            stackPane.setBorder(border);
        } else if (Nord == true && Est == true && Sud == false && Ouest == false) {
            BorderStroke borderStroke = new BorderStroke(Color.BLACK, Color.BLACK, Color.LIGHTGREY, Color.LIGHTGREY,
                    BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID,
                    null,
                    new BorderWidths(1), new Insets(0));
            Border border = new Border(borderStroke);
            StackPane stackPane = getCenteredNodeGridPane(grille, index);
            stackPane.setBorder(border);
        } else if (Nord == true && Ouest == true && Sud == false && Est == false) {
            BorderStroke borderStroke = new BorderStroke(Color.BLACK, Color.LIGHTGREY, Color.LIGHTGREY, Color.BLACK,
                    BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID,
                    null,
                    new BorderWidths(1), new Insets(0));
            Border border = new Border(borderStroke);
            StackPane stackPane = getCenteredNodeGridPane(grille, index);
            stackPane.setBorder(border);
        } else if (Nord == true && Ouest == false && Sud == true && Est == false) {
            BorderStroke borderStroke = new BorderStroke(Color.BLACK, Color.LIGHTGREY, Color.BLACK, Color.LIGHTGREY,
                    BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID,
                    null,
                    new BorderWidths(1), new Insets(0));
            Border border = new Border(borderStroke);
            StackPane stackPane = getCenteredNodeGridPane(grille, index);
            stackPane.setBorder(border);
        } else if (Est == true && Nord == false && Sud == false && Ouest == false) {
            BorderStroke borderStroke = new BorderStroke(Color.LIGHTGREY, Color.BLACK, Color.LIGHTGREY,
                    Color.LIGHTGREY,
                    BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID,
                    null,
                    new BorderWidths(1), new Insets(0));
            Border border = new Border(borderStroke);
            StackPane stackPane = getCenteredNodeGridPane(grille, index);
            stackPane.setBorder(border);
        } else if (Sud == true && Est == false && Nord == false && Ouest == false) {
            BorderStroke borderStroke = new BorderStroke(Color.LIGHTGREY, Color.LIGHTGREY, Color.BLACK,
                    Color.LIGHTGREY,
                    BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID,
                    null,
                    new BorderWidths(1), new Insets(0));
            Border border = new Border(borderStroke);
            StackPane stackPane = getCenteredNodeGridPane(grille, index);
            stackPane.setBorder(border);

        } else if (Sud == true && Ouest == true && Nord == false && Est == false) {
            BorderStroke borderStroke = new BorderStroke(Color.LIGHTGREY, Color.LIGHTGREY, Color.BLACK, Color.BLACK,
                    BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID,
                    null,
                    new BorderWidths(1), new Insets(0));
            Border border = new Border(borderStroke);
            StackPane stackPane = getCenteredNodeGridPane(grille, index);
            stackPane.setBorder(border);

        } else if (Sud == true && Est == true && Nord == false && Ouest == false) {
            BorderStroke borderStroke = new BorderStroke(Color.LIGHTGREY, Color.BLACK, Color.BLACK, Color.LIGHTGREY,
                    BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID,
                    null,
                    new BorderWidths(1), new Insets(0));
            Border border = new Border(borderStroke);
            StackPane stackPane = getCenteredNodeGridPane(grille, index);
            stackPane.setBorder(border);

        } else if (Ouest == true && Est == false && Sud == false && Nord == false) {
            BorderStroke borderStroke = new BorderStroke(Color.LIGHTGREY, Color.LIGHTGREY, Color.LIGHTGREY,
                    Color.BLACK,
                    BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID,
                    null,
                    new BorderWidths(1), new Insets(0));
            Border border = new Border(borderStroke);
            StackPane stackPane = getCenteredNodeGridPane(grille, index);
            stackPane.setBorder(border);
        } else if (Nord == true && Est == true && Sud == true && Ouest == true) {
            BorderStroke borderStroke = new BorderStroke(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
                    BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID,
                    null,
                    new BorderWidths(1), new Insets(0));
            Border border = new Border(borderStroke);
            StackPane stackPane = getCenteredNodeGridPane(grille, index);
            stackPane.setBorder(border);
        }

    }

    private static StackPane getCenteredNodeGridPane(GridPane gridPane, int index) {
        return (StackPane) gridPane.getChildren().get(index);
    }

    private static void setManualBordure(GridPane grille, ArrayList<Case> listCase, int index, Boolean Nord,
            Boolean Est, Boolean Sud,
            Boolean Ouest) {
        listCase.get(index).setBordure(Nord, Est, Sud, Ouest);
        modifBordure(grille, index, Nord, Est, Sud, Ouest);
    }

    private static void createRobot(GridPane grille, int x, int y, Color color) {
        StackPane stackPane = getCenteredNodeGridPane(grille, positionToIndex(x, y));
        Circle cercle = new Circle(10, color);
        stackPane.getChildren().add(cercle);

        new Robot(x, y, color);
    }

    public static int positionToIndex(int x, int y) {
        return (16 * x + y);
    }

    private void setObjectif(GridPane grille, int x, int y, Color color) {
        StackPane stackPane = getCenteredNodeGridPane(grille, positionToIndex(x, y));
        Rectangle rectangle = new Rectangle(30, 30, color);

        stackPane.getChildren().add(rectangle);
    }

}
