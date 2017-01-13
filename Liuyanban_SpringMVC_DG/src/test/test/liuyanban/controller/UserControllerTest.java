package liuyanban.controller;

import junit.framework.TestCase;
import liuyanban.entity.User;
import liuyanban.service.UserServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;

/**
 * Created by Administrator on 2016/8/23.
 */
public class UserControllerTest extends TestCase {
    public void testgetUserListALL(){
        List<User> userList=new UserServiceImpl().getUserALL();
        JSONArray jsonArray=JSONArray.fromObject(userList);
        System.out.println(jsonArray.toString());
        System.out.println(userList);
    }
    public void testgetMessageByUserRootIdPaging()
    {

    }

}