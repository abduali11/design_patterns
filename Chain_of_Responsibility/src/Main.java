public class Main {
    public static void main(String[] args) {

        // Tehdään handlerit ja ketjutetaan ne
        Handler compensationHandler = new CompensationHandler();
        Handler contactRequestHandler = new ContactRequestHandler();
        Handler suggestionHandler = new SuggestionHandler();
        Handler generalFeedbackHandler = new GeneralFeedbackHandler();

        compensationHandler.setNextHandler(contactRequestHandler);
        contactRequestHandler.setNextHandler(suggestionHandler);
        suggestionHandler.setNextHandler(generalFeedbackHandler);


        // Create some messages to test the handlers:
        Message[] messages = {
                new Message(Message.MessageType.COMPENSATION, "Requesting compensation for damaged product.", "customer1@example.com"),
                new Message(Message.MessageType.CONTACT_REQUEST, "Need to contact support.", "customer2@example.com"),
                new Message(Message.MessageType.SUGGESTION, "Suggesting a new feature.", "customer3@example.com"),
                new Message(Message.MessageType.GENERAL, "General feedback about the service.", "customer4@example.com")
        };

        // Process messages
        for (Message message : messages) {
            compensationHandler.handleRequest(message);
        }
    }
}