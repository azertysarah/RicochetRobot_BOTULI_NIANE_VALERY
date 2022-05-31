package com.isep;

import java.util.ArrayList;
import java.util.List;

public class HorizontalWall {
    private int column;
    private int row;
    private boolean up;

    //Constructeur
    public HorizontalWall(int column, int row, boolean up) {
        this.column = column;
        this.row = row;
        this.up = up;
    }

    //Méthode pour lister tous les murs horizontaux du plateau de jeu
    public static List<HorizontalWall> createHorizontalWalls(){
        List<HorizontalWall> listOfHorizontalWalls = new ArrayList<>();
        //Bordure du plateau
        for (int row =0; row < 16; row++){
            listOfHorizontalWalls.add(new HorizontalWall(0, row, true));
            listOfHorizontalWalls.add(new HorizontalWall(15, row, false));
        }

        //Bordure des cases vides
        listOfHorizontalWalls.add(new HorizontalWall(6, 7, false));
        listOfHorizontalWalls.add(new HorizontalWall(6, 8, false));
        listOfHorizontalWalls.add(new HorizontalWall(9, 7, true));
        listOfHorizontalWalls.add(new HorizontalWall(9, 8, true));

        //Autres murs

        return listOfHorizontalWalls;
    }

    //Getters
    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean isUp() {
        return up;
    }
}
