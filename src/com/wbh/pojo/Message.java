package com.wbh.pojo;

import java.util.Date;

public class Message {
	//����id
	private int messageId;
	//�û�id
	private int userId;
	//��������
	private String messageContent;
	//����ʱ��
	private Date messageTime;
	//����״̬
	private int messageFlag;
	private int rid;
	
	private String userName;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	//�ղι���
	public Message(){}
	//���ι���
	public Message(int userId, String messageContent, Date messageTime,
			int messageFlag) {
		super();
		this.userId = userId;
		this.messageContent = messageContent;
		this.messageTime = messageTime;
		this.messageFlag = messageFlag;
	}
	//����ȫ��get��set����
	
	
	public int getMessageId() {
		return messageId;
	}
	
	public int getMessageFlag() {
		return messageFlag;
	}
	public void setMessageFlag(int messageFlag) {
		this.messageFlag = messageFlag;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public Date getMessageTime() {
		return messageTime;
	}
	public void setMessageTime(Date messageTime) {
		this.messageTime = messageTime;
	}
	
	
	
}