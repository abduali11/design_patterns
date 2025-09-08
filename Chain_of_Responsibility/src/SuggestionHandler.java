public class SuggestionHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void handleRequest(Message message) {
        // Geneerinen handler
        if (message.getType() == Message.MessageType.SUGGESTION) {
            System.out.println("Handling suggestion: " + message.getMessageContent());


        } else if (nextHandler != null) {
            nextHandler.handleRequest(message);
        }
    }
}