package com.praktikum.gui;

import com.praktikum.data.DataStore;
import com.praktikum.users.User;
import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginPane {
    private Stage primaryStage;
    private DataStore dataStore;

    public LoginPane(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.dataStore = DataStore.getInstance();
    }

    public Scene createLoginScene() {
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));
        root.setStyle("-fx-background-color: #f0f0f0;");

        Label titleLabel = new Label("Login Sistem Lost & Found");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");

        ComboBox<String> userTypeCombo = new ComboBox<>();
        userTypeCombo.getItems().addAll("Admin", "Mahasiswa");
        userTypeCombo.setValue("Mahasiswa");
        userTypeCombo.setPrefWidth(200);

        GridPane loginForm = new GridPane();
        loginForm.setAlignment(Pos.CENTER);
        loginForm.setHgap(10);
        loginForm.setVgap(15);
        loginForm.setPadding(new Insets(20));
        loginForm.setStyle("-fx-background-color: white; -fx-background-radius: 10; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 10, 0, 0, 0);");

        Label field1Label = new Label("Username:");
        TextField field1 = new TextField();
        field1.setPrefWidth(200);


        Label field2Label = new Label("Password:");
        PasswordField field2 = new PasswordField();
        Label field3Label = new Label("Password:");
        field2.setPrefWidth(200);

        userTypeCombo.setOnAction(e -> {
            if (userTypeCombo.getValue().equals("Admin")) {
                field1Label.setText("Username:");
                field2Label.setText("Password:");
                field3Label.setText("NIM ");
                field2.setVisible(true);
            } else {
                field1Label.setText("Nama:");
                field2Label.setText("NIM:");
                field2.setVisible(true);
            }
        });

        Button loginButton = new Button("Login");
        loginButton.setPrefWidth(100);
        loginButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-weight: bold;");


        Label messageLabel = new Label();
        messageLabel.setStyle("-fx-text-fill: red;");

        loginForm.add(new Label("Tipe User:"), 0, 0);
        loginForm.add(userTypeCombo, 1, 0);
        loginForm.add(field1Label, 0, 1);
        loginForm.add(field1, 1, 1);
        loginForm.add(field2Label, 0, 2);
        loginForm.add(field2, 1, 2);
        loginForm.add(loginButton, 1, 3);
        loginForm.add(messageLabel, 1, 4);

        loginButton.setOnAction(e -> {
            String userType = userTypeCombo.getValue();
            String input1 = field1.getText().trim();
            String input2 = field2.getText().trim();


            if (input1.isEmpty() || input2.isEmpty()) {
                messageLabel.setText("Semua field harus diisi!");
                return;
            }

            User user = null;
            if (userType.equals("Admin")) {
                user = dataStore.authenticateAdmin(input1, input2);
            } else {
                user = dataStore.authenticateMahasiswa(input1, input2);
            }

            if (user != null) {
                messageLabel.setText("");
                if (user instanceof Admin) {
                    AdminDashboard adminDashboard = new AdminDashboard(primaryStage, (Admin) user);
                    primaryStage.setScene(adminDashboard.createAdminScene());
                } else if (user instanceof Mahasiswa) {
                    MahasiswaDashboard mahasiswaDashboard = new MahasiswaDashboard(primaryStage, (Mahasiswa) user);
                    primaryStage.setScene(mahasiswaDashboard.createMahasiswaScene());
                }
            } else {
                messageLabel.setText("Login gagal, periksa kredensial!");
            }

        });

        root.getChildren().addAll(titleLabel, loginForm);
        return new Scene(root, 400, 500);
    }
}