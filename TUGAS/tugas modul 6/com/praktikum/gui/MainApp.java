package com.praktikum.gui;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Lost & Found Kampus");
        primaryStage.setResizable(false);

        LoginPane loginPane = new LoginPane(primaryStage);
        primaryStage.setScene(loginPane.createLoginScene());

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}