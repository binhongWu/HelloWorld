package com.wbh.model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.wbh.mvc.model.ModelSupport;
import com.wbh.mvc.model.TextModel;
import com.wbh.pojo.CartRecord;
import com.wbh.pojo.User;

public class AddCartRecordAjax extends TextModel{
	private String dessertId;
	
	public String getDessertId() {
		return dessertId;
	}

	public void setDessertId(String dessertId) {
		this.dessertId = dessertId;
	}

	/**
	 * �����ӹ��ﳵ�ķ��������߼��ж�
	 */
	@Override
	public String execute() {
		//���ñ�ʾ���жϸ�����Ƿ��Ѵ����ڹ��ﳵ��
		int isExist=0;
		//���ڽ�����Ʒ������
		int dessertNum=0;
		//���ڽ��ո���Ʒ���б��е�����
		int index=-1;
		//���ڽ��մ���������ƷId
		int dessertId=Integer.parseInt(this.dessertId);
		// TODO Auto-generated method stub
		HttpServletRequest request=ModelSupport.getRequest();
		HttpSession session=ModelSupport.getSession();
		//��ȡ�����û����ﳵ�е���������
		List<CartRecord> userCartRecordList=(List<CartRecord>)session.getAttribute("userCartRecordList");
		//�жϴ�������dessertId��ֵ��ȡ��ͬ�Ĳ���
		if(dessertId>0){
			//Idֵ����0
			//�����û����ﳵ��û�����ݣ���ֱ������
			if(userCartRecordList.size()==0){
				userCartRecordList.add(new CartRecord(dessertId, 1, ((User)session.getAttribute("loginUser")).getUserId()));
				return "�ɹ����빺�ﳵ��";
			}else{
				//�Թ��ﳵ���б������ж���Ʒ�Ƿ����
				for(int i=0;i<userCartRecordList.size();i++){
					if(dessertId==userCartRecordList.get(i).getDessertId()){
						dessertNum=userCartRecordList.get(i).getDessertNumber();
						index=i;
						isExist=1;
						break;
					}
				}
				//��Ʒ�����ڣ���������Ʒ
				if(isExist==0){
					userCartRecordList.add(new CartRecord(dessertId, 1, ((User)session.getAttribute("loginUser")).getUserId()));
					
					return "�ɹ����빺�ﳵ��";
				}
				else{
					//��Ʒ���ڣ����ж���Ʒ�����Ƿ񳬹����ֵ
					if(dessertNum<99){
						//������Ʒ����
						userCartRecordList.get(index).setDessertNumber(dessertNum+1);
						return "�ɹ����빺�ﳵ��";
					}
					else{
						return "��Ʒ�����������ޣ�";
					}
				}
			}
		}else{
			int id=0;
			int num=0;
			//��������ֵС��0�����ԭsession�е����ݽ��и���
			userCartRecordList=new ArrayList<CartRecord>();
			String[] idArray=request.getParameter("dessertIdList").toString().split("A");
			String[] numArray=request.getParameter("numList").toString().split("A");
			for(int i=0;i<idArray.length;i++){
				id=Integer.parseInt(idArray[i]);
				num=Integer.parseInt(numArray[i]);
				userCartRecordList.add(new CartRecord(id, num, ((User)session.getAttribute("loginUser")).getUserId()));
			}
			System.out.println("mmpaansndkjnaskdbsfbkjsadf");
			session.setAttribute("userCartRecordList", userCartRecordList);
			List<CartRecord> list=userCartRecordList;
			return "";
		}
		
	}
	
	
}