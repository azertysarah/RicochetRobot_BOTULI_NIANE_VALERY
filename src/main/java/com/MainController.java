package com;

import com.isep.HorizontalWall;
import com.isep.VerticalWall;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.List;

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

        //Créer les murs (en fonction des planches versos 1, 2, 3 et 4 du document)
        //Murs horizontaux
        Image horizontalWallUpImage = new Image("HorizontalWallUp.png", CELL_SIZE, CELL_SIZE, false, true);
        Image horizontalWallDownImage = new Image("HorizontalWallDown.png", CELL_SIZE, CELL_SIZE, false, true);

        List<HorizontalWall> listOfHorizontalWalls = HorizontalWall.createHorizontalWalls();

        for (HorizontalWall horizontalWall : listOfHorizontalWalls){
            ImageView horizontalWallUpImageView = new ImageView(horizontalWallUpImage);
            ImageView horizontalWallDownImageView = new ImageView(horizontalWallDownImage);
            if(horizontalWall.isUp() == true){
                gridBoard.add(horizontalWallUpImageView,horizontalWall.getRow(),horizontalWall.getColumn());
            }else{
                gridBoard.add(horizontalWallDownImageView,horizontalWall.getRow(),horizontalWall.getColumn());
            }
        }
        //Murs verticaux
        Image verticalWallLeftImage = new Image("VerticalWallLeft.png", CELL_SIZE, CELL_SIZE, false, true);
        Image verticalWallRightImage = new Image("VerticalWallRight.png", CELL_SIZE, CELL_SIZE, false, true);

        List<VerticalWall> listOfVerticalWalls = VerticalWall.createVerticalWalls();

        for (VerticalWall verticalWall : listOfVerticalWalls){
            ImageView verticalWallLeftImageView = new ImageView(verticalWallLeftImage);
            ImageView verticalWallRightImageView = new ImageView(verticalWallRightImage);
            if(verticalWall.isLeft() == true){
                gridBoard.add(verticalWallLeftImageView,verticalWall.getRow(),verticalWall.getColumn());
            }else{
                gridBoard.add(verticalWallRightImageView,verticalWall.getRow(),verticalWall.getColumn());
            }
        }
        //Créer et placer les objectifs
        //Créer et placer les robots de manière aléatoire sur le plateau
    }
}