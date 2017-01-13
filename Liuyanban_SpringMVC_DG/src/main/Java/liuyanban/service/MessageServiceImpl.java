package liuyanban.service;

import liuyanban.dao.IMessageDao;
import liuyanban.dao.MessageDaoImpl;
import liuyanban.entity.Message;
import liuyanban.entity.MessagePlus;

import java.util.List;

/**
 * Created by Administrator on 2016/8/23.
 */
public class MessageServiceImpl implements IMessageService {
    //增删改业务
    public boolean addMessage(Message message) {
        return new MessageDaoImpl().addMessage(message);
    }

    public boolean updataMessageByMessageId(Message message) {
        return new MessageDaoImpl().updataMessageByMessageId(message);
    }

    public boolean deleteMessageByMessageId(Message message) {
        return new MessageDaoImpl().deleteMessageByMessageId(message);
    }

    //查询业务
    public int getMessageCountByRootUserId(int rootUserId) {
        return new MessageDaoImpl().getMessageCountByRootUserId(rootUserId);
    }

    public List<MessagePlus> getMessagePlusListPagingByRootUserId(int pageIndex, int pageSize, int rootUserId) {
        return new MessageDaoImpl().getMessagePlusListPagingByRootUserId(pageIndex, pageSize, rootUserId);
    }

    public List<MessagePlus> getRootMessagePlusListPagingByRootUserId(int pageIndex, int pageSize, int rootUserId) {
        return new MessageDaoImpl().getRootMessagePlusListPagingByRootUserId(pageIndex, pageSize, rootUserId);
    }
}
