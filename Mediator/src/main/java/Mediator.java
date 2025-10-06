import java.util.HashMap;
import java.util.Map;

public interface Mediator {
    void registerClient(ChatClient client);
    void sendMessage(String message, String sender, String recipient);
}