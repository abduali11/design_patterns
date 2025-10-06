import javafx.application.Platform;
import javafx.scene.control.TextArea;

public class ChatClient {
    private String username;
    private Mediator mediator;
    private TextArea messageArea;

    public ChatClient(String username, Mediator mediator, TextArea messageArea) {
        this.username = username;
        this.mediator = mediator;
        this.messageArea = messageArea;
        mediator.registerClient(this);
    }

    public String getUsername() {
        return username;
    }

    public void sendMessage(String message, String recipient) {
        mediator.sendMessage(message, username, recipient);
    }

    public void receiveMessage(String message, String sender) {
        Platform.runLater(() -> messageArea.appendText(sender + ": " + message + "\n"));
    }
}