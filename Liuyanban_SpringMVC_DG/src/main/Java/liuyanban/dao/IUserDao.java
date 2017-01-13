package liuyanban.dao;

import liuyanban.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2016/8/22.
 */
public interface IUserDao {

    boolean isExistUesr(String loginId);//通过loginId判断用户是否已存在

    boolean addUser(User user);

    boolean updataUser(User user);

    boolean deleteUser(User user);

    List<User> getUserAll();//获取所有的User对象集合

    User getUserByUserId(int userId);//返回User对象By id

    User getUserByloginId(String loginId);//返回User对象By loginId
}
