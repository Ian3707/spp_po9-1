package com.example.main;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        double[] points = { 100, 50, 200, 200, 0, 200 };
        Polygon triangle = new Polygon(points);
        triangle.setFill(Color.BLUE);

        root.getChildren().add(triangle);

        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(3), triangle);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(Animation.INDEFINITE);
        rotateTransition.setAutoReverse(false);

        rotateTransition.play();

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setScene(scene);

        primaryStage.setTitle("Rotating Triangle");
        
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
