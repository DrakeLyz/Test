package liuyanban.service;

import liuyanban.entity.Message;
import liuyanban.entity.MessagePlus;

import java.util.List;

/**
 * Created by Administrator on 2016/8/23.
 */
public interface IMessageService {
    boolean addMessage(Message message);                               //增加一条message
    boolean updataMessageByMessageId(Message message);                 //修改一条message by messageId
    boolean deleteMessageByMessageId(Message message);                   //删除某一条消息，若该消息的root==0，则删除root=该消息id的全部消息
    int getMessageCountByRootUserId(int rootUserId);                   //通过rootUserId获取到总数量
    List<MessagePlus> getMessagePlusListPagingByRootUserId(int pageIndex, int pageSize, int rootUserId);     //通过rootUserId分页获取到在此rootUserId下的全部回复信息
    List<MessagePlus> getRootMessagePlusListPagingByRootUserId(int pageIndex, int pageSize, int rootUserId);    //通过rootUserId获取根下的留言 根留言 没有回复
}
