import java.util.Scanner;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class InputParser {
    public static int nombreJoueur() {
        Scanner scanner = new Scanner(System.in);
        int nbrJoueur = 0;
        while (nbrJoueur != 1 && nbrJoueur != 2) {
            System.out.println("A combien de joueurs voulez-vous jouer ? (1 ou 2)");
            nbrJoueur = scanner.nextInt();
        }

        return nbrJoueur;
    }

    // static EventHandler<MouseEvent> clickRobot = new EventHandler<MouseEvent>() {
    // @Override
    // public void handle(MouseEvent e) {
    // String sousChaineGrande = "";

    // if (e.getSource().toString().length() > 15) {
    // sousChaineGrande = e.getSource().toString().substring(13, 16);
    // }
    // String sousChaineMoyenne = e.getSource().toString().substring(13, 15);
    // String sousChainePetite = e.getSource().toString().substring(13, 14);

    // boolean integerOrNotGrand = sousChaineGrande.matches("-?\\d+");
    // boolean integerOrNotMoyen = sousChaineMoyenne.matches("-?\\d+");
    // boolean integerOrNotPetit = sousChainePetite.matches("-?\\d+");

    // int index = -1;
    // if (integerOrNotGrand == true) {
    // index = Integer.parseInt(sousChaineGrande);
    // } else if (integerOrNotMoyen == true) {
    // index = Integer.parseInt(sousChaineMoyenne);
    // } else if (integerOrNotPetit == true) {
    // index = Integer.parseInt(sousChainePetite);
    // }

    // System.out.println(this.getClass());

    // allDeplacement(grille, listCase, listCase2, listRobot,
    // indexToPosition(index).get(0),
    // indexToPosition(index).get(1));

    // }

    // };

    // static EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>()
    // {
    // public void handle(MouseEvent e) {
    // Board.deplacerRobot(grille, listCaseInitial, listCase, listRobot, x, y,
    // clickRobot);
    // }
    // };
}