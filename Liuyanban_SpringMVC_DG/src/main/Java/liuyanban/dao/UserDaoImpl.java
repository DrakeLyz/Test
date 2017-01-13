package liuyanban.dao;

import liuyanban.Utils.DBUtils_DG;
import liuyanban.entity.User;
import sun.org.mozilla.javascript.internal.EcmaError;

import java.util.List;

/**
 * Created by Administrator on 2016/8/22.
 */
public class UserDaoImpl implements IUserDao {
    //增删改
    public boolean addUser(User user) {
        if (this.isExistUesr(user.getLoginId())) return false;//当登录名已存在时不能进行注册
        String sql="insert into tb_user (loginId,Pwd,Name,jurisdiction,Image) values (?,?,?,?,?)";
        Object[]objects={user.getLoginId(),user.getPwd(),user.getName(),user.getJurisdiction(),user.getImage()};
        return DBUtils_DG.executeUpdate(sql,objects);
    }

    public boolean updataUser(User user) {
        String sql="update tb_user set loginId=?,Pwd=?,Name=?,jurisdiction=?,Image=? where userId=?";
        Object[]objects={user.getLoginId(),user.getPwd(),user.getName(),user.getJurisdiction(),user.getImage(),user.getUserId()};
        return DBUtils_DG.executeUpdate(sql,objects);
    }
    public boolean deleteUser(User user) {
        String sql="delete from tb_user where userId=?";
        return DBUtils_DG.executeUpdate(sql,user.getUserId());
    }
    //查询
    //获得所有User
    public List<User> getUserAll() {
        String sql="select userId,loginId,`Name`,Jurisdiction,Image  from tb_user";
        return DBUtils_DG.executeQueryList(User.class,sql);
    }
    //通过Id 获得User对象
    public User getUserByUserId(int userId) {
        String sql="select userId,loginId,`Name`,Jurisdiction,Image from tb_user where userId=? limit 1";
        return DBUtils_DG.executeQuerySingleLine(User.class,sql,userId);
    }

    public boolean isExistUesr(String loginId) {
        String sql="select loginId from tb_user where loginId=? limit 1";
        try{
            return DBUtils_DG.executeQuerySingleData(sql,loginId).toString().length()>0?true:false;
        }
        catch (Exception ee)
        {
            return false;
        }
    }

    //通过loginId 获得User对象
    public User getUserByloginId(String loginId)
    {
        String sql="select * from tb_user where loginId=? limit 1";
        return DBUtils_DG.executeQuerySingleLine(User.class,sql,loginId);
    }
}
