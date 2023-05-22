import java.util.logging.Logger;

public class MessageLogger {
    private static final Logger LOGGER = Logger.getLogger(MessageLogger.class.getName());

    public void logPublish(String nodeId, String topic, String message) {
        LOGGER.info(String.format("Node %s published message '%s' to topic '%s'", nodeId, message, topic));
    }

    public void logDelivery(String nodeId, String message) {
        LOGGER.info(String.format("Node %s received message '%s'", nodeId, message));
    }

    public void logUpdate(String nodeId, String message) {
        LOGGER.info(String.format("Node %s updated message '%s'", nodeId, message));
    }
}
