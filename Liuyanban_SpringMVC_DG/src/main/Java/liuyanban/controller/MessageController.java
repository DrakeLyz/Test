package liuyanban.controller;

import liuyanban.entity.Message;
import liuyanban.entity.MessagePlus;
import liuyanban.service.MessageServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/8/25.
 */
@Controller
@RequestMapping(value = "/Message/*")
public class MessageController {
    //获得信息数目
    @ResponseBody
    @RequestMapping(value = "getMessageCountByUserRootId", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public String getMessageCountByUserRootId(int rootUserId)
    {
        int messageCount=new MessageServiceImpl().getMessageCountByRootUserId(rootUserId);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("TFMark",true);
        jsonObject.put("messageCount",messageCount);
        return jsonObject.toString();
    }
    //获得信息列表
    @ResponseBody
    @RequestMapping(value = "getMessageByUserRootIdPaging", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public String getMessageByUserRootIdPaging( int pageIndex, int pageSize, int rootUserId)
    {
        int pageIndex2=0;
        pageIndex2=(pageIndex-1)*pageSize;
        MessageServiceImpl messageService=new MessageServiceImpl();
        List<MessagePlus> messagePluses_root=messageService.getRootMessagePlusListPagingByRootUserId(pageIndex2,pageSize,rootUserId);
        List<MessagePlus> messagePluses=messageService.getMessagePlusListPagingByRootUserId(pageIndex2,pageSize,rootUserId);
        int messageCount=messageService.getMessageCountByRootUserId(rootUserId);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("TFMark",true);
        jsonObject.put("messageCount",messageCount);
        jsonObject.put("messagePluses_root", JSONArray.fromObject(messagePluses_root));
        jsonObject.put("messagePluses",JSONArray.fromObject(messagePluses));
        return jsonObject.toString();
    }
    //插入信息--即在留言板留言的实现 同时用作留言板回复的实现
    @ResponseBody
    @RequestMapping(value = "addMessage", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public String addMessage(String Messages,int userId,int Root ,int rootUserId)
    {
        liuyanban.entity.Message messages=new Message();
        messages.setMessages(Messages);
        messages.setTime(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));//获取当前时间
        messages.setUserId(userId);
        messages.setRoot(Root);
        messages.setRootUserId(rootUserId);
        boolean isAdd=new MessageServiceImpl().addMessage(messages);
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
    //删除一条Message
    @ResponseBody
    @RequestMapping(value = "deleteMessage", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public String deleteMessage(int messageId)
    {
        Message message=new Message();
        message.setMessageId(messageId);
        boolean isDelete=new MessageServiceImpl().deleteMessageByMessageId(message);
        if (isDelete)
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
