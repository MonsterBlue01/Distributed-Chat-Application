import rice.pastry.*;
import rice.pastry.messaging.Message;
import rice.p2p.commonapi.*;

public class MyApplication extends Application {
    private Node node;
    private MessageLogger messageLogger;

    public MyApplication(PastryNode pastryNode) {
        this.node = new Node(pastryNode.getNodeId().toStringFull());
        this.endpoint = pastryNode.buildEndpoint(this, "myinstance");
        this.messageLogger = new MessageLogger();
        this.endpoint.register();
    }

    public boolean forward(RouteMessage message) {
        return true;
    }

    public void deliver(Id id, Message message) {
        // Log the delivery of the message
        messageLogger.logDelivery(this.node.getNodeId(), message.toString());

        // Check if the message is asking for an update
        if (message.toString().equals("update")) {
            // Create a new message with the NodeId and the children NodeIds
            Message responseMessage = new Message(this.node.getNodeId(), "response",
                this.node.getNodeId() + ", " + String.join(", ", this.node.getChildrenNodeIds()), null);

            // Send the new message to the parent node
            if (this.node.getParentNode() != null) {
                endpoint.route(null, responseMessage, this.node.getParentNode().getNodeHandle());
            }
        }
    }

    public void update(NodeHandle handle, boolean joined) {
        // Assume the network is static (no nodes will join or drop out halfway)
    }
}

