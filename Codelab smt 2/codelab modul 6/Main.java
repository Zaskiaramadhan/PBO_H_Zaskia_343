import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.Random;

public class Main extends Application {
    private int targetNumber;
    private int attemptCount;
    private Random random;
    private TextField inputField;
    private Button guessButton;
    private Button playAgainButton;
    private Label feedbackLabel;
    private Label attemptLabel;
    private Label titleLabel;

    @Override
    public void start(Stage primaryStage) {
        random = new Random();
        initializeGame();
        createComponents();

        VBox mainLayout = createMainLayout();

        Scene scene = new Scene(mainLayout, 350, 200);
        primaryStage.setTitle("Tebak Angka");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void initializeGame() {
        targetNumber = random.nextInt(100) + 1;
        attemptCount = 0;
    }

    private void createComponents() {
        titleLabel = new Label("🎯 Tebak Angka 1-100");
        titleLabel.setStyle("-fx-font-size: 10px; -fx-font-weight: bold; -fx-text-fill: #ffff;");

        Label instructionLabel = new Label("Masukkan tebakanmu!");
        instructionLabel.setStyle("-fx-font-size: 12px;");

        inputField = new TextField();
        inputField.setPromptText("Masukkan angka di sini");
        inputField.setPrefWidth(150);

        guessButton = new Button("🟢 Coba Tebak!");
        guessButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold;");

        playAgainButton = new Button("🔄 Main Lagi");
        playAgainButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white; -fx-font-weight: bold;");
        playAgainButton.setVisible(false);

        feedbackLabel = new Label("");
        feedbackLabel.setStyle("-fx-font-size: 12px;");

        attemptLabel = new Label("Jumlah percobaan: 0");
        attemptLabel.setStyle("-fx-font-size: 11px; -fx-text-fill: #666;");

        setupEventHandlers();
    }

    private void setupEventHandlers() {
        guessButton.setOnAction(e -> handleGuess());
        inputField.setOnAction(e -> handleGuess());
        playAgainButton.setOnAction(e -> resetGame());
    }

    private void handleGuess() {
        try {
            String input = inputField.getText().trim();
            if (input.isEmpty()) {
                showFeedback("Masukkan angka terlebih dahulu!", Color.ORANGE);
                return;
            }

            int guess = Integer.parseInt(input);

            if (guess < 1 || guess > 100) {
                showFeedback("Angka harus antara 1-100!", Color.ORANGE);
                return;
            }

            attemptCount++;
            updateAttemptLabel();

            if (guess == targetNumber) {
                showFeedback("✅ Tebakan benar!", Color.GREEN);
                endGame();
            } else if (guess < targetNumber) {
                showFeedback("⚠️ Terlalu kecil!", Color.ORANGE);
            } else {
                showFeedback("⚠️ Terlalu besar!", Color.ORANGE);
            }

            inputField.clear();

        } catch (NumberFormatException ex) {
            showFeedback("Masukkan angka yang valid!", Color.RED);
        }
    }

    private void showFeedback(String message, Color color) {
        feedbackLabel.setText(message);
        feedbackLabel.setTextFill(color);
    }

    private void updateAttemptLabel() {
        attemptLabel.setText("Jumlah percobaan: " + attemptCount);
    }

    private void endGame() {
        inputField.setDisable(true);
        guessButton.setVisible(false);
        playAgainButton.setVisible(true);
    }

    private void resetGame() {
        initializeGame();

        inputField.setDisable(false);
        inputField.clear();
        guessButton.setVisible(true);
        playAgainButton.setVisible(false);
        feedbackLabel.setText("");
        updateAttemptLabel();
    }

    private VBox createMainLayout() {
        HBox inputSection = new HBox(10);
        inputSection.setAlignment(Pos.CENTER);
        inputSection.getChildren().addAll(inputField, guessButton, playAgainButton);

        VBox mainLayout = new VBox(15);
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.setPadding(new Insets(20));
        mainLayout.getChildren().addAll(
                titleLabel,
                new Label("Masukkan tebakanmu!"),
                inputSection,
                feedbackLabel,
                attemptLabel
        );

        mainLayout.setStyle("-fx-background-color: #f5f5f5;");
        return mainLayout;
    }

    public static void main(String[] args) {
        launch(args);
    }
}