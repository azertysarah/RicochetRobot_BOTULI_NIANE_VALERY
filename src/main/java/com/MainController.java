package com;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class MainController {
    public final int CELL_SIZE = 40;

    @FXML
    GridPane gridBoard;

    @FXML
    Button playBtn;

    public void playGame() throws Exception{

        //Afficher les cases du plateau dans chaque cellule de la grille
        Image cellImage = new Image("Cell.png", CELL_SIZE, CELL_SIZE, false, true);             //Case du plateau
        Image emptyCellImage = new Image("EmptyCell.png", CELL_SIZE, CELL_SIZE, false, true);   //Case du milieu

        for (int row = 0; row < 16; row++) {
            for (int column = 0; column < 16; column++) {
                ImageView cellImageView = new ImageView(cellImage);
                gridBoard.add(cellImageView, row, column);
                //Cases du milieu du plateau
                if (row == 7 || row == 8){
                    if (column == 7 || column == 8){
                        ImageView emptyCellImageView = new ImageView(emptyCellImage);
                        gridBoard.add(emptyCellImageView, row, column);
                    }
                }
            }
        }

        //Créer les murs
    }
}