package com.wbh.pojo;

public class Taste {
	//��ζId
	private int tasteId;
	//��ζ����
	private String tasteName;

	
	
	
	//�ղι���
	public Taste() {
		super();
	}
	//���ι���
	public Taste(String tasteName) {
		super();
		this.tasteName = tasteName;
	}
	//������get��set����
	public int getTasteId() {
		return tasteId;
	}

	public void setTasteId(int tasteId) {
		this.tasteId = tasteId;
	}

	public String getTasteName() {
		return tasteName;
	}

	public void setTasteName(String tasteName) {
		this.tasteName = tasteName;
	}
	
}