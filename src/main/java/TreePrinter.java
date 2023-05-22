import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class TreePrinter {
    private Map<String, Node> nodeMap;

    public TreePrinter(Map<String, Node> nodeMap) {
        this.nodeMap = nodeMap;
    }
    
    public void printTree(Node node, String prefix) {
        if (node == null) {
            return;
        }
    
        System.out.println(prefix + node.getNodeId());
        List<String> childrenNodeIds = node.getChildrenNodeIds();
    
        for (String childNodeId : childrenNodeIds) {
            Node childNode = nodeMap.get(childNodeId);
            printTree(childNode, prefix + "--");
        }
    }
}