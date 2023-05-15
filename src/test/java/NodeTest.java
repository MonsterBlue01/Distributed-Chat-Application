import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {
    @Test
    public void testNodeId() {
        Node node = new Node("123");
        assertEquals("123", node.getNodeId());
    }

    @Test
    public void testChildrenNodeIds() {
        Node node = new Node("123");
        node.addChildNodeId("456");
        node.addChildNodeId("789");
        assertEquals(2, node.getChildrenNodeIds().size());
        assertTrue(node.getChildrenNodeIds().contains("456"));
        assertTrue(node.getChildrenNodeIds().contains("789"));
    }
}