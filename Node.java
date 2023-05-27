import java.util.List;

public class Node {
    private String nodeId;
    private List<String> childrenIds;

    public Node(String nodeId, List<String> childrenIds) {
        this.nodeId = nodeId;
        this.childrenIds = childrenIds;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public List<String> getChildrenIds() {
        return childrenIds;
    }

    public void setChildrenIds(List<String> childrenIds) {
        this.childrenIds = childrenIds;
    }
}