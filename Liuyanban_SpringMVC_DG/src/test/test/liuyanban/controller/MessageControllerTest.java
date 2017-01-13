package liuyanban.controller;

import junit.framework.TestCase;
import liuyanban.entity.MessagePlus;
import liuyanban.service.MessageServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;

/**
 * Created by Administrator on 2016/8/26.
 */
public class MessageControllerTest extends TestCase {
    public void testGetMessageByUserRootIdPaging() throws Exception {
        List<MessagePlus> list =new MessageServiceImpl().getRootMessagePlusListPagingByRootUserId(0,10,1001);
        JSONArray jsonArray=JSONArray.fromObject(list);
        System.out.println(jsonArray.toString());
    }

}