import java.util.Map;
import java.util.HashMap;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TreePrinterTest {
    @Test
    public void testPrintTree() {
        Node node1 = new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");
        node1.addChildNode(node2);
        node1.addChildNode(node3);

        Map<String, Node> nodeMap = new HashMap<>();
        nodeMap.put("1", node1);
        nodeMap.put("2", node2);
        nodeMap.put("3", node3);

        TreePrinter treePrinter = new TreePrinter(nodeMap);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        treePrinter.printTree(node1, "");

        String expectedOutput = "1\n" +
                                "--2\n" +
                                "--3\n";

        assertEquals(expectedOutput, outContent.toString());
    }
}
