package com.praktikum.gui;

import com.praktikum.data.DataStore;
import com.praktikum.data.Item;
import com.praktikum.users.Mahasiswa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MahasiswaDashboard {
    private Stage primaryStage;
    private Mahasiswa mahasiswa;
    private DataStore dataStore;
    private TableView<Item> itemTable;
    private ObservableList<Item> itemData;

    public MahasiswaDashboard(Stage primaryStage, Mahasiswa mahasiswa) {
        this.primaryStage = primaryStage;
        this.mahasiswa = mahasiswa;
        this.dataStore = DataStore.getInstance();
        this.itemData = FXCollections.observableArrayList();
    }

    public Scene createMahasiswaScene() {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #ecf0f1;");

        VBox header = new VBox(10);
        header.setPadding(new Insets(20));
        header.setStyle("-fx-background-color: #27ae60;");
        header.setAlignment(Pos.CENTER);

        Label titleLabel = new Label("Lost & Found Kampus");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: white;");

        Label welcomeLabel = new Label("Selamat datang, " + mahasiswa.getNama());
        welcomeLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #a9dfbf;");

        Label subtitleLabel = new Label("Laporkan Barang Hilang/Temuan");
        subtitleLabel.setStyle("-fx-font-size: 12px; -fx-text-fill: #d5f4e6;");
        header.getChildren().addAll(titleLabel, welcomeLabel, subtitleLabel);

        VBox mainContent = new VBox(20);
        mainContent.setPadding(new Insets(20));

        VBox formSection = new VBox(10);
        formSection.setStyle("-fx-background-color: green ; -fx-background-radius: 10; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 10, 0, 0, 0);");
        formSection.setPadding(new Insets(20));

        HBox formHeader = new HBox(10);
        formHeader.setAlignment(Pos.CENTER_LEFT);

        TextField itemNameField = new TextField();
        itemNameField.setPromptText("Barang yang hilang");
        itemNameField.setPrefWidth(150);

        TextField descField = new TextField();
        descField.setPromptText("Warna Hitam");
        descField.setPrefWidth(150);

        TextField locationField = new TextField();
        locationField.setPromptText("Lab Komputer");
        locationField.setPrefWidth(120);

        Button reportButton = new Button("Laporkan");
        reportButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-weight: bold;");
        reportButton.setPrefWidth(100);

        formHeader.getChildren().addAll(
                new Label("Nama:"), itemNameField,
                new Label("Deskripsi:"), descField,
                new Label("Lokasi:"), locationField,
                reportButton
        );

        formSection.getChildren().add(formHeader);

        Label tableLabel = new Label("Daftar Laporan Anda");
        tableLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");

        createItemTable();
        refreshItemTable();

        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);

        Button refreshButton = new Button("Refresh");
        refreshButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-weight: bold;");
        refreshButton.setPrefWidth(100);

        Button logoutButton = new Button("Logout");
        logoutButton.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white; -fx-font-weight: bold;");
        logoutButton.setPrefWidth(100);

        buttonBox.getChildren().addAll(refreshButton, logoutButton);

        reportButton.setOnAction(e -> {
            String itemName = itemNameField.getText().trim();
            String description = descField.getText().trim();
            String location = locationField.getText().trim();

            if (itemName.isEmpty() || description.isEmpty() || location.isEmpty()) {
                showAlert("Error", "Semua field harus diisi!", Alert.AlertType.ERROR);
                return;
            }

            Item newItem = new Item(itemName, description, location, "Reported");
            dataStore.addReportedItem(newItem);

            itemNameField.clear();
            descField.clear();
            locationField.clear();

            refreshItemTable();
            showAlert("Berhasil", "Laporan telah diterima. Terima kasih!", Alert.AlertType.INFORMATION);
        });

        refreshButton.setOnAction(e -> refreshItemTable());

        logoutButton.setOnAction(e -> {
            LoginPane loginPane = new LoginPane(primaryStage);
            primaryStage.setScene(loginPane.createLoginScene());
        });

        mainContent.getChildren().addAll(formSection, tableLabel, itemTable, buttonBox);
        root.setTop(header);
        root.setCenter(mainContent);
        return new Scene(root, 800, 600);
    }

    private void createItemTable() {
        itemTable = new TableView<>();
        itemTable.setPrefHeight(250);

        TableColumn<Item, String> nameCol = new TableColumn<>("Nama");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        nameCol.setPrefWidth(150);

        TableColumn<Item, String> locationCol = new TableColumn<>("Lokasi");
        locationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        locationCol.setPrefWidth(120);

        TableColumn<Item, String> statusCol = new TableColumn<>("Status");
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        statusCol.setPrefWidth(100);

        TableColumn<Item, String> descCol = new TableColumn<>("Deskripsi");
        descCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        descCol.setPrefWidth(200);

        itemTable.getColumns().addAll(nameCol, locationCol, statusCol, descCol);
        itemTable.setItems(itemData);
    }

    private void refreshItemTable() {
        itemData.clear();
        itemData.addAll(dataStore.getReportedOnlyItems());
    }

    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}