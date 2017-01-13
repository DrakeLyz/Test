package liuyanban.service;

import liuyanban.dao.UserDaoImpl;
import liuyanban.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2016/8/22.
 */
public class UserServiceImpl implements IUserService {
    //增删改业务
    public boolean addUser(User user) {
        return new UserDaoImpl().addUser(user);
    }

    public boolean updataUser(User user) {
        return new UserDaoImpl().updataUser(user);
    }

    public boolean deleteUser(User user) {
        return new UserDaoImpl().deleteUser(user);
    }

    public boolean isExist(String loginId){return new UserDaoImpl().isExistUesr(loginId);}
    //查询
    public User getUserByUserId(int userId) {
        return new UserDaoImpl().getUserByUserId(userId);
    }

    public List<User> getUserALL() {
        return new UserDaoImpl().getUserAll();
    }

    public  User getUserByloginId(String loginId){return new UserDaoImpl().getUserByloginId(loginId);}
}
