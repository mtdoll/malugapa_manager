package com.malugapa;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label lblSaludo = new Label("¡Bienvenido a MALUGAPA Manager!");

        StackPane root = new StackPane();
        root.getChildren().add(lblSaludo);

        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("MALUGAPA Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}