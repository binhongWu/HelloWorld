package com.wbh.pojo;

public class Address {
	//��ַ Id
	private int addressId;
	//��ַ 
	private String addressDetail;
	//�û�id
	private int userId;
	
	//�ղι���
	public Address(){}
	//���ι���
	public Address(String addressDetail, int userId) {
		super();
		this.addressDetail = addressDetail;
		this.userId = userId;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getAddressDetail() {
		return addressDetail;
	}
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}