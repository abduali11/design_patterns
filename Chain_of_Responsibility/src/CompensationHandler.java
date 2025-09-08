public class CompensationHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void handleRequest(Message message) {
        if (message.getType() == Message.MessageType.COMPENSATION) {
            System.out.println("Handling compensation claim: " + message.getMessageContent());
            // Randomly approve or reject the claim
            if (Math.random() < 0.5) {
                System.out.println("Compensation claim approved.");
                System.out.println("Compensating " + " with " + Math.random() * 1000 + " dollars.");
            } else {
                System.out.println("Compensation claim rejected.");
            }

        } else if (nextHandler != null) {
            nextHandler.handleRequest(message);
        }
    }
}
