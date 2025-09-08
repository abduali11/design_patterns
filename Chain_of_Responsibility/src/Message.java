public class Message {
    enum MessageType {
        COMPENSATION,
        CONTACT_REQUEST,
        SUGGESTION,
        GENERAL
    }
    private final MessageType type;
    private final String messageContent;
    private final String senderEmail;

    public Message(MessageType type, String messageContent, String senderEmail) {
        this.type = type;
        this.messageContent = messageContent;
        this.senderEmail = senderEmail;
    }

    public MessageType getType() {
        return type;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public String getSenderEmail() {
        return senderEmail;
    }


}