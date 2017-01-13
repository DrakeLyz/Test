package liuyanban.service;

import junit.framework.TestCase;
import liuyanban.Utils.DBUtils_DG;
import liuyanban.entity.User;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by Administrator on 2016/8/22.
 */
public class UserServiceImplTest extends TestCase {

    public void testGetUserById() throws Exception {
        User user=new UserServiceImpl().getUserByUserId(1001);
        net.sf.json.JSONObject jsonObject= net.sf.json.JSONObject.fromObject(user);
        System.out.println(jsonObject.toString());
    }
    public void testGetUserAll(){
        List<User> list =new UserServiceImpl().getUserALL();
        System.out.println(list);
    }

}