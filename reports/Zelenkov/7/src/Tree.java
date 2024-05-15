package ru.akimov.spring.lab7spp;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Tree extends Application {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int ANGLE = 45; // Угол наклона веток
    private static final double WIND_FORCE = 0.4; // Сила ветра
    private GraphicsContext gc;
    private double windOffset = 0;

    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        gc = canvas.getGraphicsContext2D();
        primaryStage.setTitle("Pythagoras Tree");
        primaryStage.setScene(new Scene(new Group(canvas)));
        primaryStage.show();
        drawTree(WIDTH / 2, HEIGHT, HEIGHT / 4, -90, 8); // Начальные параметры дерева
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                windOffset = Math.sin(now * 1e-9) * WIND_FORCE * HEIGHT /
                        10;
                gc.clearRect(0, 0, WIDTH, HEIGHT);
                drawTree(WIDTH / 2, HEIGHT, HEIGHT / 4, -90, 8);
            }
        }.start();
    }

    private void drawTree(double x, double y, double len, double angle, int
            depth) {
        if (depth == 0) return;
        double x2 = x + Math.cos(Math.toRadians(angle)) * len;
        double y2 = y + Math.sin(Math.toRadians(angle)) * len;
        gc.setStroke(Color.BROWN);
        gc.strokeLine(x, y, x2, y2 + windOffset); // Учитываем смещение от ветра
        drawTree(x2, y2, len * Math.sqrt(0.5), angle + ANGLE, depth - 1);
        drawTree(x2, y2, len * Math.sqrt(0.5), angle - ANGLE, depth - 1);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
