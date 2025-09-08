public class GeneralFeedbackHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void handleRequest(Message message) {
        // Geneerinen handler
        if (message.getType() == Message.MessageType.GENERAL) {
            System.out.println("Handling general feedback: " + message.getMessageContent());


        } else if (nextHandler != null) {
            nextHandler.handleRequest(message);
        }
    }
}
