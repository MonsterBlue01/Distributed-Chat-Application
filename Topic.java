import java.util.List;

public class Topic {
    private String name;
    private List<Node> subscribers;

    public Topic(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addSubscriber(Node node) {
        subscribers.add(node);
    }

    public void removeSubscriber(Node node) {
        subscribers.remove(node);
    }

    public void publish(Message message) {
        // Code to publish the message to all subscribers
    }
}
