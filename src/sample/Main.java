package sample;

import javafx.scene.paint.Color;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.shape.*;

import static javafx.scene.paint.Color.rgb;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Lab1");
        Group home = new Group();
        Scene scene = new Scene (home, 406, 247);

        Rectangle houseWall = new Rectangle(62, 128, 311, 103);
        home.getChildren().add(houseWall);
        houseWall.setFill(Color.rgb(128, 0, 0));

        Polygon roof = new Polygon(197, 64, 62, 125, 62, 130, 220, 130, 220, 128, 375, 128, 375, 125);
        home.getChildren().add(roof);
        roof.setFill(Color.rgb(128, 128, 128));

        Rectangle window1 = new Rectangle(119, 154, 35, 38);
        home.getChildren().add(window1);
        window1.setFill(Color.rgb(254, 255, 0));

        Rectangle window2 = new Rectangle(208, 155, 35, 38);
        home.getChildren().add(window2);
        window2.setFill(Color.rgb(254, 255, 0));

        Rectangle star1 = new Rectangle(13, 53, 15, 15);
        home.getChildren().add(star1);
        star1.setFill(Color.rgb(254, 255, 0));

        Rectangle star2 = new Rectangle(79, 18, 15, 15);
        home.getChildren().add(star2);
        star2.setFill(Color.rgb(254, 255, 0));

        Rectangle star3 = new Rectangle(241, 47, 15, 15);
        home.getChildren().add(star3);
        star3.setFill(Color.rgb(254, 255, 0));

        Rectangle star4 = new Rectangle(301, 22, 15, 15);
        home.getChildren().add(star4);
        star4.setFill(Color.rgb(254, 255, 0));

        scene.setFill(Color.rgb(8, 0, 128));

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}