package liuyanban.controller;

import liuyanban.entity.User;
import liuyanban.service.UserServiceImpl;
import net.sf.json.JSONObject;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/User/*")
public class UserController {
    //登录Action
    @ResponseBody
    @RequestMapping(value = "/Login", produces = {"application/json;charset=UTF-8"})
    public String Login(String loginId, String loginPwd, HttpSession session) {
        JSONObject json = new JSONObject();
        try {
            User user = new UserServiceImpl().getUserByloginId(loginId.trim());
            if (user.getPwd().equals(loginPwd)) {
                session.setAttribute("User", user);
                json.put("TFMark", true);
                json.put("Msg", "欢迎您，" + user.getName() + " !");
    q            return json.toString();
            } else {
                json.put("TFMark", false);
                json.put("Msg", "账号或密码错误，请重新输入 !");
                return json.toString();
            }
        } catch (Exception ee) {
            json.put("TFMark", false);
            json.put("Msg", "输入有误，请重试 !");
            return json.toString();
        }
    }

    //注销Action
    @RequestMapping(value = "LogOut")
    public String LogOut(HttpSession session) {
        session.removeAttribute("User");
        return "/Views/User/Login";
    }

    //获得User列表
    @ResponseBody
    @RequestMapping(value = "getUserList", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public String getUserList() {
        List<User> userList = new UserServiceImpl().getUserALL();
        JSONArray jsonArray = JSONArray.fromObject(userList);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("TFMark",true);
        jsonObject.put("userList",jsonArray);
        return jsonObject.toString();
    }
    //获得User对象
    @ResponseBody
    @RequestMapping(value = "getUserByUserId", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public String getUserByUserId(String userId) {
        User user=new UserServiceImpl().getUserByUserId(Integer.parseInt(userId));
        JSONObject jsonUser=JSONObject.fromObject(user);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("TFMark",true);
        jsonObject.put("User",jsonUser);
        return jsonObject.toString();
    }
    //添加用户--注册
    @ResponseBody
    @RequestMapping(value = "addUser", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public String addUser(String loginId,String Pwd,String userName,String Image) {
        User user=new User();
        user.setLoginId(loginId);
        user.setPwd(Pwd);
        user.setName(userName);
        user.setJurisdiction("user");
        user.setImage(Image);

        UserServiceImpl userService=new UserServiceImpl();
        boolean isExist=userService.isExist(user.getLoginId());
        boolean isAdd=userService.addUser(user);
        if(isExist)
        {
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("TFMark",false);
            jsonObject.put("isExist",true);
            return jsonObject.toString();
        }
        if (isAdd)
        {
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("TFMark",true);
            return jsonObject.toString();
        }
        else
        {
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("TFMark",false);
            return jsonObject.toString();
        }
    }

}
