import rice.pastry.*;
import rice.pastry.socket.*;
import rice.pastry.standard.RandomNodeIdFactory;
import rice.environment.Environment;
import java.util.List;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        try {
            Environment env = new Environment();
            PastryNodeFactory factory = new SocketPastryNodeFactory(new RandomNodeIdFactory(env), 9001, env);

            int N = args.length > 0 ? Integer.parseInt(args[0]) : 10;
            List<MyApplication> nodes = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                PastryNode pastryNode = factory.newNode();
                MyApplication node = new MyApplication(pastryNode);
                pastryNode.registerApplication(node);

                // subscribe to topic "SimpleAggr"
                // node.subscribe("SimpleAggr");
                
                nodes.add(node);
            }

            // Bootstrapping and forming a tree structure.
            // For simplicity, let's assume nodes are added sequentially and each node's parent is the previous node.
            for (int i = 1; i < N; i++) {
                nodes.get(i).setParentNode(nodes.get(i - 1));
                nodes.get(i - 1).addChildNode(nodes.get(i));
                // bootstrap the node, e.g., nodes.get(i).getPastryNode().boot(some_address);
            }

            // periodically send updates
            new Timer().scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    // root publishes a message asking for updates
                    // nodes.get(0).publish("SimpleAggr", "update");
                }
            }, 0, 5000); // starts immediately and runs every 5 seconds

            // print the tree structure
            TreePrinter treePrinter = new TreePrinter();
            treePrinter.printTree(nodes.get(0), "");
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
