import java.util.ArrayList;
import java.util.List;

public class Node {
    private String nodeId;
     private Node parentNode;
     private List<String> childrenNodeIds;

    public Node(String nodeId) {
        this.nodeId = nodeId;
        this.childrenNodeIds = new ArrayList<>();
    }

    public String getNodeId() {
        return nodeId;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
     }

    public void addChildNode(Node childNode) {
        childNode.setParentNode(this);
        this.childrenNodeIds.add(childNode.getNodeId());
    }

    public List<String> getChildrenNodeIds() {
        return new ArrayList<>(childrenNodeIds);
    }
}