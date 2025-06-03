import  javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import  javafx.stage.Stage;

public class Main  extends Application{
    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Mau kirim ke siapa ya?");
        TextField textField = new TextField();
        Button button = new Button("kirim pesan");
        button.setOnAction(e -> {
            String nama = textField.getText();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("haloo?");;
            alert.setHeaderText(null);;
            alert.setContentText("haloo " + nama + ", Semoga kabar mu baikkk ya, sehat selalu jangan lupa sholat");
            alert.showAndWait();
        } );

        VBox root = new VBox(12, label, textField, button);
        Scene scene = new Scene( root, 500,250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("percobaan praktik modul 6");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}