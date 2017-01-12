package jt.Bean;

/**
 * Created by 彦喆 on 2016/8/22.
 */
public class UserBean {
    private int userid;
    private String username;
    private String userpw;
    private String email;
    public  UserBean(){
    }

    public UserBean(String username, String userpw, String email) {
        this.username = username;
        this.userpw = userpw;
        this.email = email;
    }

    public UserBean(int userid, String username, String userpw, String email) {
        this.userid = userid;
        this.username = username;
        this.userpw = userpw;
        this.email = email;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpw() {
        return userpw;
    }

    public void setUserpw(String userpw) {
        this.userpw = userpw;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", userpw='" + userpw + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
