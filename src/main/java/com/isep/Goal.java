package com.isep;

import java.util.ArrayList;
import java.util.List;

public class Goal {
    private int column;
    private int row;
    private String color;

    //Constructeur
    public Goal(int column, int row, String color) {
        this.column = column;
        this.row = row;
        this.color = color;
    }

    //Méthode pour lister les objectifs du jeu
    public static List<Goal> createGoals() {
        //On rentre tous les objectifs dans une liste
        List<Goal> listOfGoals = new ArrayList<>();
        listOfGoals.add(new Goal(1, 10, "RED"));
        listOfGoals.add(new Goal(2, 5, "GREEN"));
        listOfGoals.add(new Goal(2, 6, "YELLOW"));
        listOfGoals.add(new Goal(2, 12, "BLUE"));
        listOfGoals.add(new Goal(3, 12, "GREEN"));
        listOfGoals.add(new Goal(5, 1, "RED"));
        listOfGoals.add(new Goal(6, 13, "YELLOW"));
        listOfGoals.add(new Goal(7, 4, "BLUE"));
        listOfGoals.add(new Goal(9, 10, "YELLOW"));
        listOfGoals.add(new Goal(10, 5, "YELLOW"));
        listOfGoals.add(new Goal(11, 1, "GREEN"));
        listOfGoals.add(new Goal(11, 12, "RED"));
        listOfGoals.add(new Goal(11, 13, "GREEN"));
        listOfGoals.add(new Goal(12, 6, "BLUE"));
        listOfGoals.add(new Goal(13, 9, "BLUE"));
        listOfGoals.add(new Goal(14, 3, "RED"));

        //On crée une nouvelle liste qui va accueillir aléatoirement les objectifs de la liste précédente
        //List<Goal> randomListOfGoals = new ArrayList<>();
        //for (int i=0; i<listOfGoals.size(); i++){
        //    Random random = new Random();
        //    int randomNumber = random.nextInt(listOfGoals.size());
        //    randomListOfGoals.add(listOfGoals.get(randomNumber));
        //    listOfGoals.remove(listOfGoals.get(randomNumber));
        //}

        //On retourne la liste aléatoire d'objectifs
        return listOfGoals;
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
