import java.util.*;

public class History {
    private List<Message> messages;

    public History() {
        messages = new ArrayList<>();
    }

    // Add a new message to the history
    public void addMessage(Message message) {
        messages.add(message);
    }

    // Get the full chat history
    public List<Message> getMessages() {
        return messages;
    }

    // Get the last n messages from the chat history
    public List<Message> getLastMessages(int n) {
        int startIndex = Math.max(0, messages.size() - n);
        return messages.subList(startIndex, messages.size());
    }
}
