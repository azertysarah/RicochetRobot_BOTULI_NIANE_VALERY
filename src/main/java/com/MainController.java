package com;

import com.isep.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.List;
import java.util.Random;

public class MainController {
    public final int CELL_SIZE = 40;

    public Goal currentGoal = new Goal(0, 0, "");

    private Robot RedRobot = new Robot(0, 0, "RED");
    private Robot GreenRobot = new Robot(0, 0, "GREEN");
    private Robot BlueRobot = new Robot(0, 0, "BLUE");
    private Robot YellowRobot = new Robot(0, 0, "YELLOW");

    private int aiMoves;
    //En début de partie les joueurs n'ont pas de points
    private int playerPoints = 0;
    private int aiPoints = 0;

    @FXML
    GridPane gridBoard;

    @FXML
    Button playBtn;

    @FXML
    Label currentGoalLabel, playerPointsLabel, aiPointsLabel;

    public void playGame() throws Exception {

        //CASES: Afficher les cases du plateau dans chaque cellule de la grille
        Image cellImage = new Image("Cell.png", CELL_SIZE, CELL_SIZE, false, true);             //Case du plateau
        Image emptyCellImage = new Image("EmptyCell.png", CELL_SIZE, CELL_SIZE, false, true);   //Case du milieu

        for (int row = 0; row < 16; row++) {
            for (int column = 0; column < 16; column++) {
                ImageView cellImageView = new ImageView(cellImage);
                gridBoard.add(cellImageView, row, column);
                //Cases du milieu du plateau
                if (row == 7 || row == 8) {
                    if (column == 7 || column == 8) {
                        ImageView emptyCellImageView = new ImageView(emptyCellImage);
                        gridBoard.add(emptyCellImageView, row, column);
                    }
                }
            }
        }

        //CRÉER ET AFFICHER LES MURS (en fonction des planches versos 1, 2, 3 et 4 du document)
        //Murs horizontaux
        Image horizontalWallUpImage = new Image("HorizontalWallUp.png", CELL_SIZE, CELL_SIZE, false, true);
        Image horizontalWallDownImage = new Image("HorizontalWallDown.png", CELL_SIZE, CELL_SIZE, false, true);

        List<HorizontalWall> listOfHorizontalWalls = HorizontalWall.createHorizontalWalls();

        for (HorizontalWall horizontalWall : listOfHorizontalWalls) {
            ImageView horizontalWallUpImageView = new ImageView(horizontalWallUpImage);
            ImageView horizontalWallDownImageView = new ImageView(horizontalWallDownImage);
            if (horizontalWall.isUp() == true) {
                gridBoard.add(horizontalWallUpImageView, horizontalWall.getRow(), horizontalWall.getColumn());
            } else {
                gridBoard.add(horizontalWallDownImageView, horizontalWall.getRow(), horizontalWall.getColumn());
            }
        }
        //Murs verticaux
        Image verticalWallLeftImage = new Image("VerticalWallLeft.png", CELL_SIZE, CELL_SIZE, false, true);
        Image verticalWallRightImage = new Image("VerticalWallRight.png", CELL_SIZE, CELL_SIZE, false, true);

        List<VerticalWall> listOfVerticalWalls = VerticalWall.createVerticalWalls();

        for (VerticalWall verticalWall : listOfVerticalWalls) {
            ImageView verticalWallLeftImageView = new ImageView(verticalWallLeftImage);
            ImageView verticalWallRightImageView = new ImageView(verticalWallRightImage);
            if (verticalWall.isLeft() == true) {
                gridBoard.add(verticalWallLeftImageView, verticalWall.getRow(), verticalWall.getColumn());
            } else {
                gridBoard.add(verticalWallRightImageView, verticalWall.getRow(), verticalWall.getColumn());
            }
        }

        //CRÉER ET PLACER LES OBJECTIFS: ils apparaissent un à un de manière aléatoire
        //Création Image
        Image redGoalImage = new Image("RedGoal.png", CELL_SIZE, CELL_SIZE, false, true);
        Image greenGoalImage = new Image("GreenGoal.png", CELL_SIZE, CELL_SIZE, false, true);
        Image blueGoalImage = new Image("BlueGoal.png", CELL_SIZE, CELL_SIZE, false, true);
        Image yellowGoalImage = new Image("YellowGoal.png", CELL_SIZE, CELL_SIZE, false, true);

        //Création ImageView
        ImageView redGoalImageView = new ImageView(redGoalImage);
        ImageView greenGoalImageView = new ImageView(greenGoalImage);
        ImageView blueGoalImageView = new ImageView(blueGoalImage);
        ImageView yellowGoalImageView = new ImageView(yellowGoalImage);

        //Création liste d'objectif
        List<Goal> listOfGoals = Goal.createGoals();

        //Afficher au hasard un des objectifs de la liste
        Random random = new Random();
        int randomGoal = random.nextInt(listOfGoals.size());
        currentGoal = listOfGoals.get(randomGoal);
        switch (listOfGoals.get(randomGoal).getColor()) {
            case "RED":
                gridBoard.add(redGoalImageView, listOfGoals.get(randomGoal).getRow(), listOfGoals.get(randomGoal).getColumn());
                listOfGoals.remove(listOfGoals.get(randomGoal));
                currentGoalLabel.setText("RED");
                break;
            case "GREEN":
                gridBoard.add(greenGoalImageView, listOfGoals.get(randomGoal).getRow(), listOfGoals.get(randomGoal).getColumn());
                listOfGoals.remove(listOfGoals.get(randomGoal));
                currentGoalLabel.setText("GREEN");
                break;
            case "BLUE":
                gridBoard.add(blueGoalImageView, listOfGoals.get(randomGoal).getRow(), listOfGoals.get(randomGoal).getColumn());
                listOfGoals.remove(listOfGoals.get(randomGoal));
                currentGoalLabel.setText("BLUE");
                break;
            case "YELLOW":
                gridBoard.add(yellowGoalImageView, listOfGoals.get(randomGoal).getRow(), listOfGoals.get(randomGoal).getColumn());
                listOfGoals.remove(listOfGoals.get(randomGoal));
                currentGoalLabel.setText("YELLOW");
                break;
        }

        //CRÉER ET PLACER LES ROBOTS: leur position initiale est aléatoire
        //Création Image
        Image redRobotImage = new Image("RedRobot.png", CELL_SIZE, CELL_SIZE, false, true);
        Image greenRobotImage = new Image("GreenRobot.png", CELL_SIZE, CELL_SIZE, false, true);
        Image blueRobotImage = new Image("BlueRobot.png", CELL_SIZE, CELL_SIZE, false, true);
        Image yellowRobotImage = new Image("YellowRobot.png", CELL_SIZE, CELL_SIZE, false, true);

        //Création liste de robots
        List<Robot> listOfRobots = Robot.createRobots();

        //Afficher tous les robots de la liste
        for (Robot robot : listOfRobots) {
            //Création ImageView
            ImageView redRobotImageView = new ImageView(redRobotImage);
            ImageView greenRobotImageView = new ImageView(greenRobotImage);
            ImageView blueRobotImageView = new ImageView(blueRobotImage);
            ImageView yellowRobotImageView = new ImageView(yellowRobotImage);

            switch (robot.getColor()) {
                case "RED":
                    gridBoard.add(redRobotImageView, robot.getRow(), robot.getColumn());
                    break;
                case "GREEN":
                    gridBoard.add(greenRobotImageView, robot.getRow(), robot.getColumn());
                    break;
                case "BLUE":
                    gridBoard.add(blueRobotImageView, robot.getRow(), robot.getColumn());
                    break;
                case "YELLOW":
                    gridBoard.add(yellowRobotImageView, robot.getRow(), robot.getColumn());
                    break;
            }
        }
        //Mise à jour des positions initiales de chaque robot
        RedRobot = listOfRobots.get(0);
        GreenRobot = listOfRobots.get(1);
        BlueRobot = listOfRobots.get(2);
        YellowRobot = listOfRobots.get(3);

        //AFFICHER LES POINTS
        playerPointsLabel.setText(String.valueOf(playerPoints));
        aiPointsLabel.setText(String.valueOf(aiPoints));
    }


    @FXML
    Button confirmBtn;

    @FXML
    Label errorLabel, timerLabel, aiMovesLabel;

    @FXML
    TextField movesNumberPlayerField;

    public void confirmBtnAction() throws Exception {
        //Si l'utilisateur a bien saisie un nombre entier
        try {
            //move(); //Fonction move!
            int movesNumberPlayer = Integer.parseInt(movesNumberPlayerField.getText());
            errorLabel.setText(""); //Effacer les précédents messages d'erreurs qui auraient pu s'afficher

            //Chronomètre 30 secondes
            startTimer(30);

            //Afficher le nombre de mouvements qu'à trouver l'IA
            int aiMoves = 0;

            Image redRobotImage = new Image("RedRobot.png", CELL_SIZE, CELL_SIZE, false, true);
            Image greenRobotImage = new Image("GreenRobot.png", CELL_SIZE, CELL_SIZE, false, true);
            Image blueRobotImage = new Image("BlueRobot.png", CELL_SIZE, CELL_SIZE, false, true);
            Image yellowRobotImage = new Image("YellowRobot.png", CELL_SIZE, CELL_SIZE, false, true);

            ImageView redRobotImageView = new ImageView(redRobotImage);
            ImageView greenRobotImageView = new ImageView(greenRobotImage);
            ImageView blueRobotImageView = new ImageView(blueRobotImage);
            ImageView yellowRobotImageView = new ImageView(yellowRobotImage);

            switch (currentGoalLabel.getText()) {
                case "RED":
                    for (int i = 0; i < 16; i++) {
                        int newRedColumn = AI.aiMovingUp(RedRobot, RedRobot.getColumn(), RedRobot.getRow());
                        gridBoard.add(redRobotImageView, RedRobot.getRow(), newRedColumn);
                    }
                    break;
                case "GREEN":
                    int newGreenColumn = AI.aiMovingUp(GreenRobot, GreenRobot.getColumn(), GreenRobot.getRow());
                    gridBoard.add(greenRobotImageView, GreenRobot.getRow(), newGreenColumn);
                    break;
                case "BLUE":
                    int newBlueColumn = AI.aiMovingUp(BlueRobot, BlueRobot.getColumn(), BlueRobot.getRow());
                    gridBoard.add(blueRobotImageView, BlueRobot.getRow(), newBlueColumn);
                    break;
                case "YELLOW":
                    int newYellowColumn = AI.aiMovingUp(YellowRobot, YellowRobot.getColumn(), YellowRobot.getRow());
                    gridBoard.add(yellowRobotImageView, YellowRobot.getRow(), newYellowColumn);
                    break;
            }
            //Comparer les nombres de mouvements du joueur et de l'IA, celui qui détient le score le plus bas commence
            //Si l'IA commence

            //Messages d'erreur en cas de mauvaise saisie du nombre de mouvements de la part de l'utilisateur
        } catch (NumberFormatException e) {
            errorLabel.setText("Please enter an integer");
        }catch (Exception e){
            errorLabel.setText("Error");
        }
    }

    public void startTimer(int time) {
        timerLabel.setText(time + "seconds left...");
        //à développer!!
    }


    //Scottie
    //@FXML
    //Scene scene;

    //public void move(){
    //    if(currentGoalLabel.getText() == "RED"){
    //        //le image du robot
    //        Image redRobotImage = new Image("RedRobot.png", CELL_SIZE, CELL_SIZE, false, true);
    //        ImageView redRobotImageView = new ImageView(redRobotImage);
    //        HashSet<KeyCode> keyboardTouch  = new HashSet<KeyCode>();
    //        AnimationTimer animation = new AnimationTimer() {
    //            public void handle(long l) {
    //                for(KeyCode myRobot : keyboardTouch) {
    //
    //                    switch(myRobot){
    //
    //                        //top
    //                        case T:
    //                            redRobotImageView.setTranslateY(redRobotImageView.getTranslateY()-2);
    //                            break;
                            //bottom
    //                        case B:

    //                            redRobotImageView.setTranslateY(redRobotImageView.getTranslateY()+2);
    //                            break;
                            //right
    //                        case P:
    //                            redRobotImageView.setTranslateX(redRobotImageView.getTranslateX()+2);
    //                            break;
                            //left
    //                        case N:
    //                            redRobotImageView.setTranslateX(redRobotImageView.getTranslateX()-2);
    //                            break;
    //                    }
    //                }

    //            };
    //        };
    //        this.scene.setOnKeyPressed(e ->{
    //            boolean wasEmpty = keyboardTouch.isEmpty();
    //            if(keyboardTouch.add(e.getCode()) && wasEmpty)
    //                animation.start();
    //        });
    //        this.scene.setOnKeyReleased(e ->{
    //            if(keyboardTouch.remove(e.getCode()) && keyboardTouch.isEmpty())
    //                animation.stop();
    //        });
    //    }
    //}

}