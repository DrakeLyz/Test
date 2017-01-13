package liuyanban.service;

import liuyanban.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2016/8/22.
 */
public interface IUserService {
    boolean addUser(User user);

    boolean updataUser(User user);

    boolean deleteUser(User user);

    boolean isExist(String loginId);

    List<User> getUserALL();//获得所有User对象

    User getUserByUserId(int userId);//获得User对象

    User getUserByloginId(String loginId);//获得User对象 by loginId
}
