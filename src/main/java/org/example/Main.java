package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.view.AnimationController;


public class Main extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {

        AnimationController animationController = new AnimationController();
        animationController.setStyle("-fx-background-color: white");

        Scene scene = new Scene(animationController, AnimationController.WINDOW_WIDTH, AnimationController.WINDOW_HEIGHT);

        stage.setTitle("Visual Sorting Algorithms");
        stage.setScene(scene);
        stage.show();
    }
}
