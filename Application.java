import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // Create a few nodes.
        Node node1 = new Node("Node1", Arrays.asList("Node2", "Node3"));
        Node node2 = new Node("Node2", Arrays.asList("Node4", "Node5"));
        Node node3 = new Node("Node3", Arrays.asList("Node6", "Node7"));

        // Print out their IDs and children's IDs to check if they're correct.
        System.out.println(node1.getNodeId() + " children: " + node1.getChildrenIds());
        System.out.println(node2.getNodeId() + " children: " + node2.getChildrenIds());
        System.out.println(node3.getNodeId() + " children: " + node3.getChildrenIds());

        // Create a message.
        Message message = new Message(node1.getNodeId(), node1.getChildrenIds());

        // Print out the message sender ID and children IDs.
        System.out.println("Message from: " + message.getSenderId());
        System.out.println("Children IDs in the message: " + message.getChildrenIds());

        // Create a topic.
        Topic topic = new Topic(Constants.TOPIC_NAME);

        // Add nodes as subscribers.
        topic.addSubscriber(node1);
        topic.addSubscriber(node2);
        topic.addSubscriber(node3);

        // Print out the topic name.
        System.out.println("Topic name: " + topic.getName());
        
        // This won't do anything since we haven't implemented the publish method yet.
        topic.publish(message);
    }
}
