package liuyanban.entity;

/**
 * Created by Administrator on 2016/8/23.
 * 该类是辅助查询所用的虚类，并没有该实体
 */
public class MessagePlus {

    private int messageId;
    private String Messages;
    private String Time;
    private int userId;
    private int Root;   //节点 0=根 Id=子节点
    private int rootUserId;//根消息用户id
    private String Name;
    private String Image;

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

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
