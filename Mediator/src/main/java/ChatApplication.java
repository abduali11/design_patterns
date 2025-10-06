import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChatApplication extends Application {
    private Mediator mediator = new ChatMediator();

    @Override
    public void start(Stage primaryStage) {
        createClientWindow("User1");
        createClientWindow("User2");
        createClientWindow("User3");
    }

    private void createClientWindow(String username) {
        Stage stage = new Stage();
        stage.setTitle(username);

        TextArea messageArea = new TextArea();
        messageArea.setEditable(false);

        TextField messageField = new TextField();
        TextField recipientField = new TextField();
        recipientField.setPromptText("Recipient");

        Button sendButton = new Button("Send");
        ChatClient client = new ChatClient(username, mediator, messageArea);

        sendButton.setOnAction(e -> {
            String message = messageField.getText();
            String recipient = recipientField.getText();
            if (!message.isEmpty() && !recipient.isEmpty()) {
                client.sendMessage(message, recipient);
                messageArea.appendText("Me: " + message + "\n");
                messageField.clear();
            }
        });

        VBox layout = new VBox(10, messageArea, recipientField, messageField, sendButton);
        Scene scene = new Scene(layout, 300, 400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}