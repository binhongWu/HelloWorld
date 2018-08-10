package com.wbh.dao;

import java.util.List;

import com.wbh.dao.util.DaoHandler;
import com.wbh.pojo.Taste;

public class TasteDao {
	/**
	 * �������еĿ�ζ����
	 * 
	 */
	public List<Taste> findAllTaste(){
		return DaoHandler.executeQueryMultiple("select * from taste_", null, Taste.class);
	}
	
	/**
	 * ������Ʒ����Id��ȡ��ζId
	 * @param kindId
	 * @return
	 */
	public List<Taste> findTasteByKindId(int kindId){
		return DaoHandler.executeQueryMultiple("select * from taste_ where tasteId in(select tasteId from dessertTaste_ where dessertId in(select dessertId from dessert_ where kindId=?))", new Object[]{kindId}, Taste.class);
	}
}