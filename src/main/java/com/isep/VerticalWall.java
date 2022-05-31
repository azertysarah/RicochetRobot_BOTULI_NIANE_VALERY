package com.isep;

import java.util.ArrayList;
import java.util.List;

public class VerticalWall {
    private int column;
    private int row;
    private boolean left;

    //Constructeur
    public VerticalWall(int column, int row, boolean left) {
        this.column = column;
        this.row = row;
        this.left = left;
    }

    //Méthode pour lister tous les murs horizontaux du plateau de jeu
    public static List<VerticalWall> createVerticalWalls() {
        List<VerticalWall> listOfVerticalWall = new ArrayList<>();
        //Bordure du plateau
        for (int column = 0; column < 16; column++) {
            listOfVerticalWall.add(new VerticalWall(column, 0, true));
            listOfVerticalWall.add(new VerticalWall(column, 15, false));
        }

        //Bordure des cases vides
        listOfVerticalWall.add(new VerticalWall(7, 6, false));
        listOfVerticalWall.add(new VerticalWall(8, 6, false));
        listOfVerticalWall.add(new VerticalWall(7, 9, true));
        listOfVerticalWall.add(new VerticalWall(8, 9, true));

        //Autres murs

        return listOfVerticalWall;
    }

    //Getters
    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public boolean isLeft() {
        return left;
    }
}
