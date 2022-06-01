package com.isep;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Robot {
    private int column;
    private int row;
    private String color;

    //Constructeur
    public Robot(int column, int row, String color) {
        this.column = column;
        this.row = row;
        this.color = color;
    }

    //POSITION INITIALE
    public static List<Robot> createRobots() {
        //Création d'une liste vide pour les robots
        List<Robot> listOfRobots = new ArrayList<>();

        //On génère des nombres aléatoirement pour les positions aléatoires initiales des robots
        Random random = new Random();

        int randomColumn1; int randomColumn2; int randomColumn3; int randomColumn4;
        int randomRow1; int randomRow2; int randomRow3; int randomRow4;

        do {
            randomColumn1 = random.nextInt(16);
            randomColumn2 = random.nextInt(16);
            randomColumn3 = random.nextInt(16);
            randomColumn4 = random.nextInt(16);

            randomRow1 = random.nextInt(16);
            randomRow2 = random.nextInt(16);
            randomRow3 = random.nextInt(16);
            randomRow4 = random.nextInt(16);
            //On exclut les positions du milieu (7,7), (7,8), (8,8) et (8,7) qui correspondent aux cases supposées vides
        } while (randomColumn1 == 7 || randomColumn1 == 8 || randomColumn2 == 7 || randomColumn2 == 8 ||
                randomColumn3 == 7 || randomColumn3 == 8 || randomColumn4 == 7 || randomColumn4 == 8 ||
                randomRow1 == 7 || randomRow1 == 8 || randomRow2 == 7 || randomRow2 == 8 ||
                randomRow3 == 7 || randomRow3 == 8 || randomRow4 == 7 || randomRow4 == 8);

        //Si les conditions sont respectées, on ajoute les robots à la liste vide
        listOfRobots.add(new Robot(randomColumn1, randomRow1, "RED"));
        listOfRobots.add(new Robot(randomColumn2, randomRow2, "GREEN"));
        listOfRobots.add(new Robot(randomColumn3, randomRow3, "BLUE"));
        listOfRobots.add(new Robot(randomColumn4, randomRow4, "YELLOW"));

        return listOfRobots;
    }

    //DÉPLACEMENT
    public void moveRobot(){

    }

    //Getters
    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public String getColor() {
        return color;
    }
}
