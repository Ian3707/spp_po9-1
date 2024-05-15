package com.example.main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SierpinskiCarpet extends Application {

    private final int width = 800;
    private final int height = 800;
    private final int depth = 5;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Sierpinski Carpet");
        Canvas canvas = new Canvas(width, height);
        drawSierpinskiCarpet(canvas.getGraphicsContext2D(), 0, 0, width, height, depth);
        StackPane root = new StackPane();
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root, width, height));
        primaryStage.show();
    }

    private void drawSierpinskiCarpet(GraphicsContext gc, double x, double y, double width, double height, int depth) {
        if (depth == 0) {
            gc.setFill(Color.BLACK);
            gc.fillRect(x, y, width, height);
        } else {
            double newWidth = width / 3;
            double newHeight = height / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i != 1 || j != 1) {
                        drawSierpinskiCarpet(gc, x + i * newWidth, y + j * newHeight, newWidth, newHeight, depth - 1);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

