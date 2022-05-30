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
        Image cellImage = new Image("cell.png", CELL_SIZE, CELL_SIZE, false, true);
        for (int row = 0; row < 16; row++) {
            for (int column = 0; column < 16; column++) {
                ImageView cellImageView = new ImageView(cellImage);
                gridBoard.add(cellImageView, row, column);
            }
        }

        //Créer les murs
    }
}