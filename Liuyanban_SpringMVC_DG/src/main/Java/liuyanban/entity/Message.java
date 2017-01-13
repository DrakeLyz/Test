package liuyanban.entity;

/**
 * Created by Administrator on 2016/8/22.
 */
public class Message implements java.io.Serializable {
    private int messageId;
    private String Messages;
    private String Time;
    private int userId;
    private int Root;   //节点 0=根 Id=子节点
    private int rootUserId;//根消息用户id

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getMessages() {
        return Messages;
    }

    public void setMessages(String messages) {
        Messages = messages;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoot() {
        return Root;
    }

    public void setRoot(int root) {
        Root = root;
    }

    public void setRootUserId(int rootUserId) {this.rootUserId = rootUserId;}

    public int getRootUserId() { return rootUserId;}
}
