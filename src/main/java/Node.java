import java.util.ArrayList;
import java.util.List;

public class Node {
    private String nodeId;
    private List<String> childrenNodeIds;

    public Node(String nodeId) {
        this.nodeId = nodeId;
        this.childrenNodeIds = new ArrayList<>();
    }

    public String getNodeId() {
        return nodeId;
    }

    public void addChildNodeId(String childNodeId) {
        this.childrenNodeIds.add(childNodeId);
    }

    public List<String> getChildrenNodeIds() {
        return new ArrayList<>(childrenNodeIds);
    }
}