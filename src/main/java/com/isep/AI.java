package com.isep;

import java.util.List;

public class AI {
    private int maxMovesNumber = 5;

    public static int aiMovingUp(Robot robot, int initialColumn, int initialRow) {
        List<HorizontalWall> listOfHorizontalWalls = HorizontalWall.createHorizontalWalls();
        int newColumn = initialColumn;
        for (HorizontalWall horizontalWall : listOfHorizontalWalls) {
            if (initialColumn == horizontalWall.getColumn() && initialRow == horizontalWall.getRow()) {
                newColumn = initialColumn;
            }else{
                newColumn = initialColumn - 1;
        }
    } return newColumn;
    }
}


    //    while((initialColumn != goalColumn && initialRow != goalRow) || limite > 5){

        //Recherche d'un objectif sur les cases voisines
        //Recherche d'un objectif sur la colonne où se situe le robot
        //Recherche d'un objectif sur la ligne où se situe le robot


    //Méthode pour avoir le contenu d'une case du plateau
    //private static Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
    //    for (Node node : gridPane.getChildren()) {
    //        if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
    //            return node;
    //        }
    //    }
    //    return null;
    //}

