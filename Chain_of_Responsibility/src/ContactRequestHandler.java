public class ContactRequestHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void handleRequest(Message message) {
        // Handle the message if it is a contact request
        // Randomly assign the contact request to a department
        if (message.getType() == Message.MessageType.CONTACT_REQUEST) {
            System.out.println("Handling contact request: " + message.getMessageContent());

            // Randomly assign the contact request to a department
            String[] departments = {"Sales", "Support", "Marketing"};
            String department = departments[(int) (Math.random() * departments.length)];
            System.out.println("Forwarding contact request to " + department + " department");

        } else if (nextHandler != null) {
            nextHandler.handleRequest(message);
        }
    }
}
