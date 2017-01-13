package liuyanban.dao;

import liuyanban.Utils.DBUtils_DG;
import liuyanban.entity.Message;
import liuyanban.entity.MessagePlus;

import java.util.List;

/**
 * Created by Administrator on 2016/8/23.
 */
public class MessageDaoImpl implements IMessageDao{
    //增删改
    public boolean addMessage(Message message) {
        String sql="insert into tb_message (Messages,Time,userId,Root,rootUserId) values (?,?,?,?,?)";
        Object[] objects={message.getMessages(), message.getTime(), message.getUserId(), message.getRoot(), message.getRootUserId()};
        return DBUtils_DG.executeUpdate(sql,objects);
    }

    public boolean updataMessageByMessageId(Message message) {
        String sql="update tb_message set Messages=?,Time=?,userId=?,Root=?,rootUserId=? where messageId=?";
        Object[] objects={message.getMessages(), message.getTime(), message.getUserId(), message.getRoot(), message.getUserId(), message.getMessageId()};
        return DBUtils_DG.executeUpdate(sql,objects);
    }

    public boolean deleteMessageByMessageId(Message message) {
        String sql="delete from tb_message where messageId=?";
        return DBUtils_DG.executeUpdate(sql, message.getMessageId());
    }
    //查询
    /**
     * 获取数量
     * @param rootUserId
     * @return
     */
    public int getMessageCountByRootUserId(int rootUserId) {
        String sql="select COUNT(*) from tb_message where Root='0' and rootUserId=?";
        return Integer.valueOf(DBUtils_DG.executeQuerySingleData(sql,rootUserId).toString()).intValue();
    }

    public List<MessagePlus> getMessagePlusListPagingByRootUserId(int pageIndex, int pageSize, int rootUserId) {
        String sql="select tb_message.*,tb_user.`Name`,tb_user.Image from tb_message,tb_user where tb_message.Root in (select t.messageId from (select * from tb_message where Root='0' and rootUserId=? ORDER BY Time desc LIMIT ?,?) as t)  and tb_message.userId=tb_user.userId ORDER BY tb_message.Time";
        Object[] objects={rootUserId,pageIndex,pageSize};//参数
        return DBUtils_DG.executeQueryList(MessagePlus.class,sql,objects);
    }
    public List<MessagePlus> getRootMessagePlusListPagingByRootUserId(int pageIndex, int pageSize, int rootUserId)
    {
        String sql="select tb_message.*,tb_user.`Name`,tb_user.Image from tb_message,tb_user where tb_message.Root='0' and tb_message.rootUserId=? and tb_message.userId=tb_user.userId ORDER BY Time desc LIMIT ?,? ";
        Object[] objects={rootUserId,pageIndex,pageSize};//参数
        return DBUtils_DG.executeQueryList(MessagePlus.class,sql,objects);
    }
}
