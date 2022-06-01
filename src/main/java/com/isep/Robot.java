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

    public static List<Robot> createRobots() {
        List<Robot> listOfRobots = new ArrayList<>();
        //On génère deux nombres aléatoirement pour les positions aléatoires initiales des robots
        Random random = new Random();
        listOfRobots.add(new Robot(random.nextInt(15) + 1, random.nextInt(15) + 1, "RED"));
        listOfRobots.add(new Robot(random.nextInt(15) + 1, random.nextInt(15) + 1, "GREEN"));
        listOfRobots.add(new Robot(random.nextInt(15) + 1, random.nextInt(15) + 1, "BLUE"));
        listOfRobots.add(new Robot(random.nextInt(15) + 1, random.nextInt(15) + 1, "YELLOW"));

        return listOfRobots;
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
