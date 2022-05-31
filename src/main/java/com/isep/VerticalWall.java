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
        listOfVerticalWall.add(new VerticalWall(0, 3, true));
        listOfVerticalWall.add(new VerticalWall(0, 9, true));
        listOfVerticalWall.add(new VerticalWall(1, 10, true));
        listOfVerticalWall.add(new VerticalWall(2, 6, true));
        listOfVerticalWall.add(new VerticalWall(2, 13, true));
        listOfVerticalWall.add(new VerticalWall(3, 12, true));
        listOfVerticalWall.add(new VerticalWall(5, 1, true));
        listOfVerticalWall.add(new VerticalWall(5, 8, true));
        listOfVerticalWall.add(new VerticalWall(6, 14, true));
        listOfVerticalWall.add(new VerticalWall(7, 5, true));
        listOfVerticalWall.add(new VerticalWall(9, 11, true));
        listOfVerticalWall.add(new VerticalWall(10, 5, true));
        listOfVerticalWall.add(new VerticalWall(11, 1, true));
        listOfVerticalWall.add(new VerticalWall(11, 13, true));
        listOfVerticalWall.add(new VerticalWall(12, 7, true));
        listOfVerticalWall.add(new VerticalWall(13, 9, true));
        listOfVerticalWall.add(new VerticalWall(14, 4, true));
        listOfVerticalWall.add(new VerticalWall(15, 6, true));
        listOfVerticalWall.add(new VerticalWall(15, 11, true));

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
