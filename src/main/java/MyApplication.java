import rice.pastry.*;
import rice.pastry.messaging.Message;
import rice.p2p.commonapi.*;

public class MyApplication extends Application {
    private String nodeId;
    private MyApplication parentNode;
    private List<MyApplication> childrenNodes;
    private PastryNode pastryNode;
    private MessageLogger messageLogger;

    public MyApplication(PastryNode pastryNode) {
        super(pastryNode, "myApp");
        this.pastryNode = pastryNode;
        this.nodeId = pastryNode.getNodeId().toStringFull();
        this.childrenNodes = new ArrayList<>();
        this.messageLogger = new MessageLogger();
    }

    // Implement the required methods from the Application class
    @Override
    public boolean forward(RouteMessage message) {
        return true;  // Continue to forward messages by default
    }

    @Override
    public void deliver(Id id, Message message) {
        // Log the delivery of the message
        messageLogger.logDelivery(this.nodeId, message.toString());

        // Your message processing logic here
    }

    @Override
    public void update(NodeHandle handle, boolean joined) {
        // Assume the network is static (no nodes will join or drop out halfway)
    }

    public String getNodeId() {
        return nodeId;
    }

    public MyApplication getParentNode() {
        return parentNode;
    }

    public void setParentNode(MyApplication parentNode) {
        this.parentNode = parentNode;
    }

    public void addChildNode(MyApplication childNode) {
        childNode.setParentNode(this);
        this.childrenNodes.add(childNode);
    }

    public List<MyApplication> getChildrenNodes() {
        return new ArrayList<>(childrenNodes);
    }

    public PastryNode getPastryNode() {
        return pastryNode;
    }
}
