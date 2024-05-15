package ru.akimov.spring.lab7spp;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MovingCircle extends Application {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private static final int CIRCLE_RADIUS = 35;
    private static final int SPEED = 2;
    private double circleX = WIDTH / 2;
    private double circleY = HEIGHT / 2;
    private double deltaX = SPEED;
    private double deltaY = SPEED;
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        Circle circle = new Circle(circleX, circleY, CIRCLE_RADIUS);
        circle.setFill(Color.GREEN);
        root.getChildren().add(circle);
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                moveCircle();
                checkBoundaryCollision(circle);
            }
        };
        timer.start();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Lab6_Circle");
        primaryStage.show();
    }
    private void moveCircle() {
        circleX += deltaX;
        circleY += deltaY;
    }
    private void checkBoundaryCollision(Circle circle) {
        if (circleX - CIRCLE_RADIUS <= 0 || circleX + CIRCLE_RADIUS >=
                WIDTH) {
            deltaX *= -1;
        }
        if (circleY - CIRCLE_RADIUS <= 0 || circleY + CIRCLE_RADIUS >=
                HEIGHT) {
            deltaY *= -1;
        }
        circle.setCenterX(circleX);
        circle.setCenterY(circleY);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
