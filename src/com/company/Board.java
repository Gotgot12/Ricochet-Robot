import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Board extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        // Lancer la musique au départ du jeu
        SimpleAudioPlayer.main();

        // Définir la taille du plateau
        final int boardSizeHorizontal = 16;
        final int boardSizeVertical = 16;

        // Création des listes pour gérer le jeu
        ArrayList<StackPane> listStackPane = new ArrayList<StackPane>();
        ArrayList<Robot> listRobot = new ArrayList<Robot>();
        ArrayList<Objectif> listObjectif = new ArrayList<Objectif>();

        // Création de la grille pour le plateau
        GridPane grille = new GridPane();

        // Création de la liste qui contiendra l'ensemble des objets Cases
        ArrayList<Case> listCase = new ArrayList<Case>();

        // Mise en place du compteur
        ArrayList<Integer> compteurCoup = new ArrayList<Integer>();
        compteurCoup.add(0);

        // Création de l'ensemble des cases du jeu. Chaque case est ajouté à la liste
        // listCase pour y accéder
        for (int i = 0; i < boardSizeHorizontal; i++) {
            for (int j = 0; j < boardSizeVertical; j++) {
                listCase.add(new Case(i, j, false, false, false, false));
                createBordure(grille, listStackPane, i, j);
            }
        }

        // Mise en place de la bordure sur l'ensemble des côtés du jeu
        for (int i = 0; i < 16; i++) {
            // Bordure sur le côté gauche du plateau
            listCase.get(i).setBordure(false, false, false, true);
            modifBordure(grille, i, false, false, false, true);

            // Bordure sur le côté droit du plateau
            listCase.get(255 - i).setBordure(false, true, false, false);
            modifBordure(grille, 255 - i, false, true, false, false);
        }

        for (int i = 0; i < 256; i += 16) {
            // Bordure sur le côté nord du plateau
            listCase.get(i).setBordure(true, false, false, false);
            modifBordure(grille, i, true, false, false, false);

            // Bordure sur le côté sud du plateau
            listCase.get(255 - i).setBordure(false, false, true, false);
            modifBordure(grille, 255 - i, false, false, true, false);
        }

        // Configuration des murs sur les 4 coins
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

        // Création de la liste de case composé des bordures + objectifs + robots
        // Copie par valeur de listeCase
        ArrayList<Case> listCase2 = new ArrayList<Case>();
        for (int i = 0; i < boardSizeHorizontal; i++) {
            for (int j = 0; j < boardSizeVertical; j++) {
                listCase2.add(
                        new Case(i, j, listCase.get(positionToIndex(i, j)).getBordure().get(0),
                                listCase.get(positionToIndex(i, j)).getBordure().get(1),
                                listCase.get(positionToIndex(i, j)).getBordure().get(2),
                                listCase.get(positionToIndex(i, j)).getBordure().get(3)));
            }
        }

        // Mise en place des objectifs sur le plateau
        listObjectif.add(new Objectif(3, 2, Color.YELLOW));
        listObjectif.add(new Objectif(4, 9, Color.YELLOW));
        listObjectif.add(new Objectif(9, 1, Color.YELLOW));
        listObjectif.add(new Objectif(10, 9, Color.YELLOW));

        listObjectif.add(new Objectif(5, 3, Color.BLUE));
        listObjectif.add(new Objectif(6, 12, Color.BLUE));
        listObjectif.add(new Objectif(14, 5, Color.BLUE));
        listObjectif.add(new Objectif(9, 13, Color.BLUE));

        listObjectif.add(new Objectif(2, 4, Color.RED));
        listObjectif.add(new Objectif(3, 14, Color.RED));
        listObjectif.add(new Objectif(11, 3, Color.RED));
        listObjectif.add(new Objectif(12, 11, Color.RED));

        listObjectif.add(new Objectif(4, 5, Color.GREEN));
        listObjectif.add(new Objectif(6, 13, Color.GREEN));
        listObjectif.add(new Objectif(10, 6, Color.GREEN));
        listObjectif.add(new Objectif(13, 11, Color.GREEN));

        // Générer un nombre aléatoire pour choisir l'objectif parmi la liste créée
        Random random = new Random();
        int nb = random.nextInt(listObjectif.size());

        // On choisit l'objectif
        Objectif objectifDuJeu = listObjectif.get(nb);
        setObjectif(grille, objectifDuJeu.getPosition().get(0), objectifDuJeu.getPosition().get(1),
                objectifDuJeu.getColor());
        // On retire l'objectif de la liste pour ne pas retomber dessus
        listObjectif.remove(nb);

        StackPane stackPaneGlobal = new StackPane();
        // Mise en place du compteur sur l'interface graphique
        Text textCompteur = new Text();
        textCompteur.setText(String.valueOf(compteurCoup.get(0)));
        textCompteur.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 35));

        // Création de l'évènement s'exécutant au clic du robot pour la prédiction des
        // déplacements
        EventHandler<MouseEvent> clickRobot = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {

                // Récupération de l'ID du stackPane sélectionné
                String sousChaineGrande = "";

                if (e.getSource().toString().length() > 15) {
                    sousChaineGrande = e.getSource().toString().substring(13, 16);
                }
                String sousChaineMoyenne = e.getSource().toString().substring(13, 15);
                String sousChainePetite = e.getSource().toString().substring(13, 14);

                boolean integerOrNotGrand = sousChaineGrande.matches("-?\\d+");
                boolean integerOrNotMoyen = sousChaineMoyenne.matches("-?\\d+");
                boolean integerOrNotPetit = sousChainePetite.matches("-?\\d+");

                int index = -1;
                if (integerOrNotGrand == true) {
                    index = Integer.parseInt(sousChaineGrande);
                } else if (integerOrNotMoyen == true) {
                    index = Integer.parseInt(sousChaineMoyenne);
                } else if (integerOrNotPetit == true) {
                    index = Integer.parseInt(sousChainePetite);
                }

                // On prédit les déplacements possibles
                allDeplacement(grille, textCompteur, listCase, listCase2, listRobot, listObjectif,
                        indexToPosition(index).get(0),
                        indexToPosition(index).get(1), objectifDuJeu, compteurCoup);
            }
        };

        // Début de code pour randomiser la position des robots au départ

        // for (int i = 0; i < 4; i++) {
        // Random randomRobot = new Random();
        // int xRd = randomRobot.nextInt(16);
        // int yRd = randomRobot.nextInt(16);
        // Color color;
        // if (i == 0) {
        // color = Color.YELLOW;
        // } else if (i == 1) {
        // color = Color.BLUE;
        // } else if (i == 2) {
        // color = Color.RED;
        // } else {
        // color = Color.GREEN;
        // }

        // listRobot.add(new Robot(xRd, yRd, color));
        // createRobot(grille, listCase2, xRd, yRd, Color.YELLOW, clickRobot);

        // }

        // Mise en place de la liste des robots et des robots
        listRobot.add(new Robot(14, 13, Color.YELLOW));
        createRobot(grille, listCase2, 14, 13, Color.YELLOW, clickRobot);

        listRobot.add(new Robot(5, 5, Color.BLUE));
        createRobot(grille, listCase2, 5, 5, Color.BLUE, clickRobot);

        listRobot.add(new Robot(12, 13, Color.RED));
        createRobot(grille, listCase2, 12, 13, Color.RED, clickRobot);

        listRobot.add(new Robot(0, 0, Color.GREEN));
        createRobot(grille, listCase2, 0, 0, Color.GREEN, clickRobot);

        stackPaneGlobal.getChildren().addAll(textCompteur, grille);

        // Créer la scène et faire apparaître la grille
        Scene scene = new Scene(stackPaneGlobal);
        primaryStage.setTitle("Ricochet Robot");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    // Permet de visualiser tous les déplacements possibles avec en entrée la
    // position de la case
    public static void allDeplacement(GridPane grille, Text textCompteur, ArrayList<Case> listCaseInitial,
            ArrayList<Case> listCase,
            ArrayList<Robot> listRobot, ArrayList<Objectif> listObjectif, int x, int y, Objectif objectifDuJeu,
            ArrayList<Integer> compteurCoup) {

        // On récupère la position des cases où le déplacement est possible
        ArrayList<Integer> deplacementPossibleNord = deplacementRobotNord(grille, listCase, x, y);
        ArrayList<Integer> deplacementPossibleEst = deplacementRobotEst(grille, listCase, x, y);
        ArrayList<Integer> deplacementPossibleSud = deplacementRobotSud(grille, listCase, x, y);
        ArrayList<Integer> deplacementPossibleOuest = deplacementRobotOuest(grille, listCase, x, y);

        // On récupère le stackPane de la case où le déplacement est possible
        StackPane caseNordPossible = getCenteredNodeGridPane(grille,
                positionToIndex(deplacementPossibleNord.get(0), deplacementPossibleNord.get(1)));

        StackPane caseEstPossible = getCenteredNodeGridPane(grille,
                positionToIndex(deplacementPossibleEst.get(0), deplacementPossibleEst.get(1)));

        StackPane caseSudPossible = getCenteredNodeGridPane(grille,
                positionToIndex(deplacementPossibleSud.get(0), deplacementPossibleSud.get(1)));

        StackPane caseOuestPossible = getCenteredNodeGridPane(grille,
                positionToIndex(deplacementPossibleOuest.get(0), deplacementPossibleOuest.get(1)));

        // Evènmenent qui se lance lorsque l'on déplace le robot
        EventHandler<MouseEvent> clickCaseToMoveRobot = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {

                // On récupère l'index du stackPane sélectionné
                String sousChaineGrande = "";
                if (e.getSource().toString().length() > 15) {
                    sousChaineGrande = e.getSource().toString().substring(13, 16);
                }
                String sousChaineMoyenne = e.getSource().toString().substring(13, 15);
                String sousChainePetite = e.getSource().toString().substring(13, 14);

                boolean integerOrNotGrand = sousChaineGrande.matches("-?\\d+");
                boolean integerOrNotMoyen = sousChaineMoyenne.matches("-?\\d+");
                boolean integerOrNotPetit = sousChainePetite.matches("-?\\d+");

                int index = -1;
                if (integerOrNotGrand == true) {
                    index = Integer.parseInt(sousChaineGrande);
                } else if (integerOrNotMoyen == true) {
                    index = Integer.parseInt(sousChaineMoyenne);
                } else if (integerOrNotPetit == true) {
                    index = Integer.parseInt(sousChainePetite);
                }

                // Pour chacune des cases, on désactive l'évènement des cases de déplacement
                // possible car le choix de la case a été réalisé (et on la retire
                // graphiquement)
                caseNordPossible.setOnMouseClicked(null);
                caseNordPossible.getChildren()
                        .remove(caseNordPossible.getChildren().get(caseNordPossible.getChildren().size()
                                - 1));

                caseEstPossible.setOnMouseClicked(null);
                caseEstPossible.getChildren()
                        .remove(caseEstPossible.getChildren().get(caseEstPossible.getChildren().size()
                                - 1));

                caseSudPossible.setOnMouseClicked(null);
                caseSudPossible.getChildren()
                        .remove(caseSudPossible.getChildren().get(caseSudPossible.getChildren().size()
                                - 1));

                caseOuestPossible.setOnMouseClicked(null);
                caseOuestPossible.getChildren()
                        .remove(caseOuestPossible.getChildren().get(caseOuestPossible.getChildren().size()
                                - 1));

                // On exécute la fonction permettant le déplacement du robot
                deplacerRobot(grille, textCompteur, listCaseInitial, listCase, listRobot, listObjectif, x, y,
                        indexToPosition(index).get(0),
                        indexToPosition(index).get(1), objectifDuJeu, compteurCoup);
            }
        };

        // On met en place l'évènement sur les cases où le déplacement est possible
        caseNordPossible.setOnMouseClicked(clickCaseToMoveRobot);
        caseEstPossible.setOnMouseClicked(clickCaseToMoveRobot);
        caseSudPossible.setOnMouseClicked(clickCaseToMoveRobot);
        caseOuestPossible.setOnMouseClicked(clickCaseToMoveRobot);

    }

    // Permet de déplacer le robot graphiquement et logiquement
    public static void deplacerRobot(GridPane grille, Text textCompteur, ArrayList<Case> listCaseInitial,
            ArrayList<Case> listCase,
            ArrayList<Robot> listRobot, ArrayList<Objectif> listObjectif, int oldX,
            int oldY, int newX, int newY, Objectif objectifDuJeu, ArrayList<Integer> compteurCoup) {

        // Augmente le compteur de 1 et l'affiche graphiquement
        compteurCoup.get(0);
        compteurCoup.add(compteurCoup.get(0) + 1);
        compteurCoup.remove(0);
        textCompteur.setText(String.valueOf(compteurCoup.get(0)));

        Color colorRobot = Color.WHITE;

        // On récupère le robot sélectionné par le déplacement et on le déplace à sa
        // nouvelle case
        for (int i = 0; i < listRobot.size(); i++) {
            if ((listRobot.get(i).getPosition().get(0) == oldX) && (listRobot.get(i).getPosition().get(1) == oldY)) {
                listRobot.get(i).setX(newX);
                listRobot.get(i).setY(newY);
                colorRobot = listRobot.get(i).getColor();
                break;
            }
        }

        // On vérifie si la case sélectionnée et celle de l'objectif final (avec la
        // bonne couleur)
        if (objectifDuJeu.getPosition().get(0) == newX && objectifDuJeu.getPosition().get(1) == newY
                && colorRobot == objectifDuJeu.getColor()) {
            System.out.println("LETS GOOOOOOO");

            // On affiche le nombre de coups final
            System.out.println(compteurCoup.get(0));

            // On remet à 0 le compteur
            textCompteur.setText(String.valueOf(compteurCoup.get(0)));
            compteurCoup.add(0);
            compteurCoup.remove(0);
            textCompteur.setText(String.valueOf(compteurCoup.get(0)));

            // On choisit aléatoirement un nouvel objectif dans la liste
            Random random = new Random();
            int nb = random.nextInt(listObjectif.size());

            Objectif nouveauObjectifDuJeu = listObjectif.get(nb);
            objectifDuJeu.setX(nouveauObjectifDuJeu.getPosition().get(0));
            objectifDuJeu.setY(nouveauObjectifDuJeu.getPosition().get(1));
            objectifDuJeu.setColor(nouveauObjectifDuJeu.getColor());
            StackPane stackPane = getCenteredNodeGridPane(grille, positionToIndex(newX, newY));
            stackPane.getChildren().remove(stackPane.getChildren().size() - 1);

            setObjectif(grille, objectifDuJeu.getPosition().get(0), objectifDuJeu.getPosition().get(1),
                    objectifDuJeu.getColor());
            listObjectif.remove(nb);

        }

        // On remet en place l'évenèment pour visualiser les déplacements possibles au
        // clic sur le robot
        EventHandler<MouseEvent> clickRobot = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                allDeplacement(grille, textCompteur, listCaseInitial, listCase, listRobot, listObjectif,
                        newX, newY, objectifDuJeu, compteurCoup);
            }
        };

        // On retire graphiquement le robot de son ancienne case
        removeRobot(grille, listCase, oldX, oldY, clickRobot);

        // On retire logiquement les bordure de l'ancienne case (car le robot s'est
        // déplacé)
        removeBordure(listCaseInitial, listCase, oldX, oldY);

        // On créé graphiquement le nouveau robot sur sa nouvelle case
        createRobot(grille, listCase, newX, newY, colorRobot, clickRobot);
    }

    // Permet de visualiser les déplacements possibles vers le nord avec la position
    // de la case en entrée
    public static ArrayList<Integer> deplacementRobotNord(GridPane grille, ArrayList<Case> listCase, int x, int y) {
        // Trouve la case concernée par la position
        Case caseInit = listCase.get(positionToIndex(x, y));

        int compteur = 0;

        // Tant qu'il n'y a pas de bordure au nord de la case, on continue la boucle (et
        // on prend la case du dessus à chaque fois)
        while (caseInit.getBordure().get(0) == false) {
            // On sélectionne la case du dessus de la case précédente
            caseInit = listCase.get(positionToIndex(x, y - 1));
            x = caseInit.getPosition().get(0);
            y = caseInit.getPosition().get(1);

            compteur += 1;

        }

        // On affiche un rectangle rouge si le déplacement est possible à cette case
        StackPane stackPane = getCenteredNodeGridPane(grille, positionToIndex(x, y));
        Rectangle rectangle = new Rectangle(35, 35, Color.WHITE);
        if (compteur > 0) {
            rectangle.setFill(Color.RED);
        }
        rectangle.opacityProperty().set(0.2);
        stackPane.getChildren().add(rectangle);

        // Retire le rectangle de déplacement possible lorsque l'on reclique sur le
        // robot
        if (stackPane.getChildren().size() == 4) {
            stackPane.getChildren().remove(stackPane.getChildren().size() - 1);
        }

        // On retourne la position de la case possible
        return caseInit.getPosition();

    }

    // Même fonctionnement que deplacementRobotNord
    public static ArrayList<Integer> deplacementRobotEst(GridPane grille, ArrayList<Case> listCase, int x, int y) {
        Case caseInit = listCase.get(positionToIndex(x, y));

        int compteur = 0;

        while (caseInit.getBordure().get(1) == false) {
            caseInit = listCase.get(positionToIndex(x + 1, y));

            x = caseInit.getPosition().get(0);
            y = caseInit.getPosition().get(1);

            compteur += 1;
        }

        StackPane stackPane = getCenteredNodeGridPane(grille, positionToIndex(x, y));
        Rectangle rectangle = new Rectangle(35, 35, Color.WHITE);
        if (compteur > 0) {
            rectangle.setFill(Color.RED);
        }
        rectangle.opacityProperty().set(0.2);
        stackPane.getChildren().add(rectangle);

        if (stackPane.getChildren().size() == 4) {
            stackPane.getChildren().remove(stackPane.getChildren().size() - 1);
        }

        return caseInit.getPosition();

    }

    // Même fonctionnement que deplacementRobotNord
    public static ArrayList<Integer> deplacementRobotSud(GridPane grille, ArrayList<Case> listCase, int x, int y) {
        Case caseInit = listCase.get(positionToIndex(x, y));
        int compteur = 0;

        while (caseInit.getBordure().get(2) == false) {
            caseInit = listCase.get(positionToIndex(x, y + 1));
            x = caseInit.getPosition().get(0);
            y = caseInit.getPosition().get(1);

            compteur += 1;
        }

        StackPane stackPane = getCenteredNodeGridPane(grille, positionToIndex(x, y));
        Rectangle rectangle = new Rectangle(35, 35, Color.WHITE);
        if (compteur > 0) {
            rectangle.setFill(Color.RED);
        }
        rectangle.opacityProperty().set(0.2);
        stackPane.getChildren().add(rectangle);
        if (stackPane.getChildren().size() == 4) {
            stackPane.getChildren().remove(stackPane.getChildren().size() - 1);
        }

        return caseInit.getPosition();

    }

    // Même fonctionnement que deplacementRobotNord
    public static ArrayList<Integer> deplacementRobotOuest(GridPane grille, ArrayList<Case> listCase, int x, int y) {
        Case caseInit = listCase.get(positionToIndex(x, y));
        int compteur = 0;

        while (caseInit.getBordure().get(3) == false) {
            caseInit = listCase.get(positionToIndex(x - 1, y));
            x = caseInit.getPosition().get(0);
            y = caseInit.getPosition().get(1);

            compteur += 1;
        }

        StackPane stackPane = getCenteredNodeGridPane(grille, positionToIndex(x, y));
        Rectangle rectangle = new Rectangle(35, 35, Color.WHITE);
        if (compteur > 0) {
            rectangle.setFill(Color.RED);
        }
        rectangle.opacityProperty().set(0.2);
        stackPane.getChildren().add(rectangle);

        if (stackPane.getChildren().size() == 4) {
            stackPane.getChildren().remove(stackPane.getChildren().size() - 1);
        }

        return caseInit.getPosition();

    }

    // Créer la bordure initiale autour d'une case (en lightgrey)
    public static void createBordure(GridPane grille, ArrayList<StackPane> listStackPane, int x, int y) {
        // Mise en place de l'élément composé de la case -> on affiliera la bordure à ce
        // noeud
        StackPane stackPane = new StackPane();
        stackPane.setId(String.valueOf(positionToIndex(x, y)));
        listStackPane.add(stackPane);

        // Mise en place du rectangle permettant de faire choisir la taille de la case
        Rectangle rectangle = new Rectangle();

        rectangle.setWidth(35);
        rectangle.setHeight(35);

        // Utilisation de l'objet BorderStroke pour créer la bordure
        BorderStroke borderStroke = new BorderStroke(Color.LIGHTGREY, BorderStrokeStyle.SOLID, null,
                new BorderWidths(1));

        Border border = new Border(borderStroke);

        stackPane.setBorder(border);

        rectangle.setFill(Color.TRANSPARENT);

        // Ajout du rectangle au noeud
        stackPane.getChildren().add(rectangle);

        // Ajout du noeud à la grille
        grille.add(stackPane, x, y);
    }

    // Fonction pour mettre en place l'affichage des bordures sur le plateau
    public static void modifBordure(GridPane grille, int index, Boolean Nord, Boolean Est, Boolean Sud,
            Boolean Ouest) {
        // Si il y a une bordure au nord et pas en est, sud et ouest ont rentre dans la
        // condition
        if (Nord == true && Est == false && Sud == false && Ouest == false) {
            // Utilisation de l'objet BorderStroke pour mettre en place la bordure visuel
            // Paramètre de BorderStroke(couleurNord, couleurEst, couleurSud, couleurOuest,
            // typeBordureNord, typeBordureEst, typeBordureSud, typeBordureOuest, null(jsp
            // ce que c'est), tailleBordure, décallageIntérieurBordure)
            BorderStroke borderStroke = new BorderStroke(Color.BLACK, Color.LIGHTGREY, Color.LIGHTGREY,
                    Color.LIGHTGREY,
                    BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID,
                    null,
                    new BorderWidths(1), new Insets(0));
            Border border = new Border(borderStroke);

            // On récupère le noeud associé à la case à laquelle il faut mettre la bordure
            StackPane stackPane = getCenteredNodeGridPane(grille, index);
            stackPane.setBorder(border);

        }
        // Fonctionnement similaire pour les condtions suivantes
        else if (Nord == true && Est == true && Sud == false && Ouest == false) {
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

    // Fonction pour créer la bordure dans la logique et en visuel
    private static void setManualBordure(GridPane grille, ArrayList<Case> listCase, int index, Boolean Nord,
            Boolean Est, Boolean Sud,
            Boolean Ouest) {
        // Modifier les bordures de la case sélectionnées
        listCase.get(index).setBordure(Nord, Est, Sud, Ouest);
        modifBordure(grille, index, Nord, Est, Sud, Ouest);
    }

    // Fonction pour créer le robot au niveau visuel
    // et les bordures initiales (en logique) autour du robot initial
    private static void createRobot(GridPane grille, ArrayList<Case> listCase, int x, int y, Color color,
            EventHandler<MouseEvent> clickRobot) {

        // On crée graphiquement un nouveau robot
        StackPane stackPane = getCenteredNodeGridPane(grille, positionToIndex(x, y));
        Circle cercle = new Circle(10, color);
        stackPane.getChildren().add(cercle);

        // On ajoute à ce robot (et donc au stackPane lié l'évènment du clic)
        stackPane.setOnMouseClicked(clickRobot);

        // Mise en place des bordures sur les cases adjacentes aux robots initiales
        // La "caseNord" = la case au dessus du robot.
        // Ainsi la bordure à mettre en place est au sud de la caseNord
        // La condition permet de vérifier que l'on sort pas du plateau
        // Démarche similaire pour les autres
        if (y - 1 >= 0) {
            Case caseNord = listCase.get(positionToIndex(x, y - 1));
            caseNord.setBordure(caseNord.getBordure().get(0), caseNord.getBordure().get(1),
                    true, caseNord.getBordure().get(3));
        }

        if (x + 1 <= 15) {
            Case caseEst = listCase.get(positionToIndex(x + 1, y));
            caseEst.setBordure(caseEst.getBordure().get(0), caseEst.getBordure().get(1),
                    caseEst.getBordure().get(2), true);
        }

        if (y + 1 <= 15) {
            Case caseSud = listCase.get(positionToIndex(x, y + 1));
            caseSud.setBordure(true, caseSud.getBordure().get(1),
                    caseSud.getBordure().get(2), caseSud.getBordure().get(3));
        }

        if (x - 1 >= 0) {
            Case caseOuest = listCase.get(positionToIndex(x - 1, y));
            caseOuest.setBordure(caseOuest.getBordure().get(0),
                    true, caseOuest.getBordure().get(2), caseOuest.getBordure().get(3));
        }

    }

    // Supprimer les bordures autour des robots lorsque celui a changé de position
    private static void removeBordure(ArrayList<Case> listCaseInitial, ArrayList<Case> listCase, int x, int y) {

        if (y - 1 >= 0) {
            Case caseNordInitial = listCaseInitial.get(positionToIndex(x, y - 1));
            Case caseNord = listCase.get(positionToIndex(x, y - 1));
            if (caseNordInitial.getBordure().get(2) == false) {
                caseNord.setBordure(caseNord.getBordure().get(0), caseNord.getBordure().get(1),
                        false, caseNord.getBordure().get(3));
            }
        }

        if (x + 1 <= 15) {
            Case caseEstInitial = listCaseInitial.get(positionToIndex(x + 1, y));
            Case caseEst = listCase.get(positionToIndex(x + 1, y));
            if (caseEstInitial.getBordure().get(3) == false) {
                caseEst.setBordure(caseEst.getBordure().get(0), caseEst.getBordure().get(1),
                        caseEst.getBordure().get(2), false);
            }
        }

        if (y + 1 <= 15) {
            Case caseSudInitial = listCaseInitial.get(positionToIndex(x, y + 1));
            Case caseSud = listCase.get(positionToIndex(x, y + 1));
            if (caseSudInitial.getBordure().get(0) == false) {
                caseSud.setBordure(false, caseSud.getBordure().get(1),
                        caseSud.getBordure().get(2), caseSud.getBordure().get(3));
            }
        }

        if (x - 1 >= 0) {
            Case caseOuestInitial = listCaseInitial.get(positionToIndex(x - 1, y));
            Case caseOuest = listCase.get(positionToIndex(x - 1, y));
            if (caseOuestInitial.getBordure().get(1) == false) {
                caseOuest.setBordure(caseOuest.getBordure().get(0), false,
                        caseOuest.getBordure().get(2), caseOuest.getBordure().get(3));
            }
        }

    }

    // Supprimer le visuel du robot à la case le mettre lorsque que celui-ci a
    // changé de place
    public static void removeRobot(GridPane grille, ArrayList<Case> listCase, int x,
            int y, EventHandler<MouseEvent> clickRobot) {
        StackPane stackPane = getCenteredNodeGridPane(grille, positionToIndex(x, y));
        stackPane.getChildren()
                .remove(stackPane.getChildren().get(stackPane.getChildren().size()
                        - 1));

        stackPane.setOnMouseClicked(null);
    }

    // Fonction pour mettre en place le visuel d'un objectif
    private static void setObjectif(GridPane grille, int x, int y, Color color) {
        StackPane stackPane = getCenteredNodeGridPane(grille, positionToIndex(x, y));
        Rectangle rectangle = new Rectangle(30, 30, color);

        stackPane.getChildren().add(rectangle);
    }

    // Fonction pour récupérer le noeud associé à une position d'une case
    private static StackPane getCenteredNodeGridPane(GridPane gridPane, int index) {
        return (StackPane) gridPane.getChildren().get(index);
    }

    // Convertir une postion (x,y) en index pour connaître la case du tableau
    // cf tableau excel pour comprendre
    public static int positionToIndex(int x, int y) {
        return (16 * x + y);
    }

    // Convertir un index (de à à 256 en position [x,y])
    public static ArrayList<Integer> indexToPosition(int index) {
        ArrayList<Integer> position = new ArrayList<Integer>();
        position.add(Math.round(index / 16));
        position.add(index % 16);
        return position;
    }

}
