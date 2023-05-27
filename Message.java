import java.util.List;

public class Message {
    private String senderId;
    private List<String> childrenIds;

    public Message(String senderId, List<String> childrenIds) {
        this.senderId = senderId;
        this.childrenIds = childrenIds;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public List<String> getChildrenIds() {
        return childrenIds;
    }

    public void setChildrenIds(List<String> childrenIds) {
        this.childrenIds = childrenIds;
    }
}
