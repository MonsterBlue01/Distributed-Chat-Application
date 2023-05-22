import org.junit.jupiter.api.Test;
import java.util.logging.*;

import static org.junit.jupiter.api.Assertions.*;

public class MessageLoggerTest {
    @Test
    public void testLogPublish() {
        Logger logger = Logger.getLogger(MessageLogger.class.getName());
        TestHandler testHandler = new TestHandler();
        logger.addHandler(testHandler);

        MessageLogger messageLogger = new MessageLogger();
        messageLogger.logPublish("123", "SimpleAggr", "Update");

        LogRecord record = testHandler.getLogRecord();
        assertEquals("Node 123 published message 'Update' to topic 'SimpleAggr'", record.getMessage());
    }

    // Similar tests for logDelivery and logUpdate...

    private static class TestHandler extends Handler {
        private LogRecord logRecord;

        @Override
        public void publish(LogRecord record) {
            logRecord = record;
        }

        @Override
        public void flush() {}

        @Override
        public void close() throws SecurityException {}

        public LogRecord getLogRecord() {
            return logRecord;
        }
    }
}
