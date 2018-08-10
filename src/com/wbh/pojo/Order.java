package com.wbh.pojo;

import java.util.Date;
import java.util.List;

public class Order {
	//�������
	private int orderId;
	//����״̬
	private int orderFlag;
	//�û�Id
	private int userId;
	//�û���ַId
	private int addressId;
	//��������ʱ��
	private Date orderTime;
	//�ܽ��
	private double totalPrice;
	private String userName;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * ���ι���
	 */
	public Order(int orderFlag, int userId, int addressId,
			Date orderTime) {
		super();
		this.orderFlag = orderFlag;
		this.userId = userId;
		this.addressId = addressId;
		this.orderTime = orderTime;
	}
	/**
	 * �ղι���
	 */
	public Order(){}
	//������get��set����
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getOrderFlag() {
		return orderFlag;
	}
	public void setOrderFlag(int orderFlag) {
		this.orderFlag = orderFlag;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	
}