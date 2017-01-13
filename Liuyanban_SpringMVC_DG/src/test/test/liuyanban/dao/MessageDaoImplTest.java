package liuyanban.dao;

import junit.framework.TestCase;
import liuyanban.entity.MessagePlus;
import net.sf.json.JSONArray;

import java.util.List;

/**
 * Created by Administrator on 2016/8/24.
 */
public class MessageDaoImplTest extends TestCase {
    public void testgetRootMessagePulsListPagingByRootUserId()
    {
        List<MessagePlus> messagePlusList=new MessageDaoImpl().getRootMessagePlusListPagingByRootUserId(0,10,1003);
        JSONArray jsonArray=JSONArray.fromObject(messagePlusList);
        System.out.println(jsonArray.toString());
    }
    public void testgetMessagePulsListPagingByRootUserId()
    {
        List<MessagePlus> messagePlusList=new MessageDaoImpl().getMessagePlusListPagingByRootUserId(0,10,1003);
        JSONArray jsonArray=JSONArray.fromObject(messagePlusList);
        System.out.println(jsonArray.toString());
    }
}