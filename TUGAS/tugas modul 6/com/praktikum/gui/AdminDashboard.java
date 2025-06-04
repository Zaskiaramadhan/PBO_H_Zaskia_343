package com.praktikum.gui;

import com.praktikum.data.DataStore;
import com.praktikum.data.Item;
import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import com.praktikum.users.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdminDashboard {
    private Stage primaryStage;
    private Admin admin;
    private DataStore dataStore;
    private TableView<Item> itemTable;
    private ObservableList<Item> itemData;
    private TableView<Mahasiswa> mahasiswaTable;
    private ObservableList<Mahasiswa> mahasiswaData;

    public AdminDashboard(Stage primaryStage, Admin admin) {
        this.primaryStage = primaryStage;
        this.admin = admin;
        this.dataStore = DataStore.getInstance();
        this.itemData = FXCollections.observableArrayList();
        this.mahasiswaData = FXCollections.observableArrayList();
    }

    public Scene createAdminScene() {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #ecf0f1;");

        VBox header = new VBox(10);
        header.setPadding(new Insets(20));
        header.setStyle("-fx-background-color: #34495e;");
        header.setAlignment(Pos.CENTER);

        Label titleLabel = new Label("Lost & Found Kampus");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: white;");

        Label welcomeLabel = new Label("Halo, Admin " + admin.getNama());
        welcomeLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #bdc3c7;");

        header.getChildren().addAll(titleLabel, welcomeLabel);

        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Tab laporanTab = new Tab("Laporan Barang");
        VBox laporanContent = createLaporanContent();
        laporanTab.setContent(laporanContent);

        Tab mahasiswaTab = new Tab("Data Mahasiswa");
        VBox mahasiswaContent = createMahasiswaContent();
        mahasiswaTab.setContent(mahasiswaContent);

        tabPane.getTabs().addAll(laporanTab, mahasiswaTab);
        HBox bottomBox = new HBox();
        bottomBox.setAlignment(Pos.CENTER);
        bottomBox.setPadding(new Insets(20));

        Button logoutButton = new Button("Logout");
        logoutButton.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white; -fx-font-weight: bold;");
        logoutButton.setPrefWidth(100);

        logoutButton.setOnAction(e -> {
            LoginPane loginPane = new LoginPane(primaryStage);
            primaryStage.setScene(loginPane.createLoginScene());
        });

        bottomBox.getChildren().add(logoutButton);

        root.setTop(header);
        root.setCenter(tabPane);
        root.setBottom(bottomBox);

        return new Scene(root, 900, 700);
    }

    private VBox createLaporanContent() {
        VBox content = new VBox(20);
        content.setPadding(new Insets(20));

        Label sectionLabel = new Label("Laporan Barang");
        sectionLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");
        createItemTable();
        refreshItemTable();
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);

        Button claimedButton = new Button("Tandai Claimed");
        claimedButton.setStyle("-fx-background-color: #27ae60; -fx-text-fill: white; -fx-font-weight: bold;");
        claimedButton.setPrefWidth(150);

        Button refreshButton = new Button("Refresh");
        refreshButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-weight: bold;");
        refreshButton.setPrefWidth(100);

        buttonBox.getChildren().addAll(claimedButton, refreshButton);
        claimedButton.setOnAction(e -> markSelectedItemAsClaimed());
        refreshButton.setOnAction(e -> refreshItemTable());

        content.getChildren().addAll(sectionLabel, itemTable, buttonBox);
        return content;
    }

    private VBox createMahasiswaContent() {
        VBox content = new VBox(20);
        content.setPadding(new Insets(20));

        Label sectionLabel = new Label("Data Mahasiswa");
        sectionLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");

        createMahasiswaTable();
        refreshMahasiswaTable();

        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);

        Button refreshMahasiswaButton = new Button("Refresh");
        refreshMahasiswaButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-weight: bold;");
        refreshMahasiswaButton.setPrefWidth(100);

        buttonBox.getChildren().add(refreshMahasiswaButton);
        refreshMahasiswaButton.setOnAction(e -> refreshMahasiswaTable());

        content.getChildren().addAll(sectionLabel, mahasiswaTable, buttonBox);
        return content;
    }

    private void createItemTable() {
        itemTable = new TableView<>();
        itemTable.setPrefHeight(300);

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

    private void createMahasiswaTable() {
        mahasiswaTable = new TableView<>();
        mahasiswaTable.setPrefHeight(300);

        TableColumn<Mahasiswa, String> namaCol = new TableColumn<>("Nama");
        namaCol.setCellValueFactory(new PropertyValueFactory<>("nama"));
        namaCol.setPrefWidth(200);

        TableColumn<Mahasiswa, String> nimCol = new TableColumn<>("NIM");
        nimCol.setCellValueFactory(new PropertyValueFactory<>("nim"));
        nimCol.setPrefWidth(150);

        mahasiswaTable.getColumns().addAll(namaCol, nimCol);
        mahasiswaTable.setItems(mahasiswaData);
    }

    private void refreshItemTable() {
        itemData.clear();
        itemData.addAll(dataStore.getReportedItems());
    }

    private void refreshMahasiswaTable() {
        mahasiswaData.clear();
        for (User user : dataStore.getUserList()) {
            if (user instanceof Mahasiswa) {
                mahasiswaData.add((Mahasiswa) user);
            }
        }
    }

    private void markSelectedItemAsClaimed() {
        Item selectedItem = itemTable.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            if (selectedItem.getStatus().equals("Reported")) {
                int index = dataStore.getReportedItems().indexOf(selectedItem);
                dataStore.markItemAsClaimed(index);
                refreshItemTable();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Berhasil");
                alert.setHeaderText(null);
                alert.setContentText("Item '" + selectedItem.getItemName() + "' telah ditandai sebagai 'Claimed'.");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Peringatan");
                alert.setHeaderText(null);
                alert.setContentText("Item sudah memiliki status 'Claimed'.");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Peringatan");
            alert.setHeaderText(null);
            alert.setContentText("Pilih item yang akan ditandai sebagai 'Claimed'.");
            alert.showAndWait();
        }
    }
}