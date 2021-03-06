package com.wbh.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.wbh.dao.util.DaoHandler;
import com.wbh.pojo.Message;

public class MessageDao {
	/**
	 * 查找所有的留言列表
	 */
	public List<Message> findALLMessage(){
		return DaoHandler.executeQueryMultiple("select  rownum as rid, n.* from (select  message_.*from  message_  order by   messageFlag , messageTime  )  n order by rid desc", new Object[]{}, Message.class);
	}
	/**
	 * 查询所有已阅的留言
	 * @return
	 */
	public List<Message> findAllCheckedMessage(){
		return DaoHandler.executeQueryMultiple("select * from message_ where messageFlag=0 order by messageTime desc", null, Message.class);
	}
	
	/**
	 * 
	 * 查询留言总数
	 */
	public int findMessageCount(){
		BigDecimal decimal=(BigDecimal)DaoHandler.executeQuerySeriz("select count(*) from message_",new Object[]{});
		if(decimal==null){
			return 0;
		}
		return decimal.intValue();
		
	}
	/**
	 * 根据留言id查找留言对象
	 */
	public List<Message> findMessageByMessageid(int messageid){
		return DaoHandler.executeQueryMultiple("select *from message_ where messageId=?", new Object[]{messageid}, Message.class);
	}
	/**
	 * 根据留言id修改留言状态
	 * 
	 */
	public void reviseMessage(int messageid){
		DaoHandler.executeUpdate("update message_ set messageFlag=0 where messageId=?", new Object[]{messageid	});
		
	}
	/**
	 * 
	 * 分页查询所有的留言列表
	 */
	public List<Message> findMessageByPage(int page){
		return DaoHandler.executeQueryByPage("select  messageId,userId,messageContent,messageTime,messageFlag  from(select rownum as rowd, n.*from(select  rownum as rid, n.* from (select  message_.*from  message_  order by messageFlag,messageTime) n order by rid desc) n) where rowd between ? and  ?", new Object[]{}, page, Message.class);
	}
	/**
	 * 
	 * 分页查询所有的已阅留言列表（0表示已读1表示未读）
	 */
	public List<Message> findMessageByPageMessageFlag(int page){
		return DaoHandler.executeQueryByPage("select  messageId,userId,messageContent,messageTime,messageFlag  from(select rownum as rowd, n.*from(select  rownum as rid, n.* from (select  message_.*from  message_  where messageFlag=0 order by messageTime) n order by rid desc) n) where rowd between ? and  ?", new Object[]{}, page, Message.class);
	}
	/**
	 * 新增未读留言
	 * @param message
	 */
	public void addMessage(Message message){
		DaoHandler.executeUpdate("insert into message_ values(seq_messageId.nextval,?,?,?,1)", new Object[]{message.getUserId(),message.getMessageContent(),new Date()});
	}
	
}
