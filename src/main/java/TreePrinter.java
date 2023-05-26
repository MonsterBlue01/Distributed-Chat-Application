import java.util.List;

public class TreePrinter {

    public void printTree(MyApplication node, String prefix) {
        if (node == null) {
            return;
        }

        System.out.println(prefix + node.getNodeId());
        List<MyApplication> childrenNodes = node.getChildrenNodes();

        for (MyApplication childNode : childrenNodes) {
            printTree(childNode, prefix + "--");
        }
    }
}
