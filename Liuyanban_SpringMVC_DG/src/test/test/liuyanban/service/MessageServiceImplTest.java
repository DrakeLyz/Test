package liuyanban.service;

import junit.framework.TestCase;

/**
 * Created by Administrator on 2016/8/26.
 */
public class MessageServiceImplTest extends TestCase {
    public void testMessageCount()
    {
        int count=  new MessageServiceImpl().getMessageCountByRootUserId(1003);
        System.out.println(count);
    }
}