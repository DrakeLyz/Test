package jt.Bean;

/**
 * Created by 彦喆 on 2016/8/22.
 */
public class MessageBean {
    private int id;
    private String userName;
    private String date;
    private String content;

    public MessageBean() {
    }

    public MessageBean(String userName, String date, String content) {
        this.userName = userName;
        this.date = date;
        this.content = content;
    }

    public MessageBean(int id, String userName, String date, String content) {
        this.id = id;
        this.userName = userName;
        this.date = date;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MessageBean{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", date=" + date +
                ", content='" + content + '\'' +
                '}';
    }
}
