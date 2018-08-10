package com.wbh.pojo;

public class Taste {
	//口味Id
	private int tasteId;
	//口味名称
	private String tasteName;

	
	
	
	//空参构造
	public Taste() {
		super();
	}
	//带参构造
	public Taste(String tasteName) {
		super();
		this.tasteName = tasteName;
	}
	//下面是get和set方法
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
