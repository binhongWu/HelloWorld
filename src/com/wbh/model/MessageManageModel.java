package com.wbh.model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.wbh.dao.MessageDao;
import com.wbh.dao.UserDao;
import com.wbh.mvc.model.DispatchModel;
import com.wbh.mvc.model.ModelSupport;
import com.wbh.pojo.Message;
import com.wbh.pojo.User;
import com.wbh.util.CommonUtil;

public class MessageManageModel extends DispatchModel {
	//
	private String revise;
	private String messageid;
	private String page;
	
	
	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getMessageid() {
		return messageid;
	}

	public void setMessageid(String messageid) {
		this.messageid = messageid;
	}

	public String getRevise() {
		return revise;
	}

	public void setRevise(String revise) {
		this.revise = revise;
	}

	@Override
	public String execute() {
		// TODO Auto-generated method stub
		
		HttpServletRequest request=ModelSupport.getRequest();
		//�������յļ��Ϻ��õ���dao
		List<User> userlist=new ArrayList();
		UserDao userdao=new UserDao();
		MessageDao messagedao=new MessageDao();
		
//		System.out.println(messagelist.size());
		//���մ�������ֵ
		String revise=request.getParameter("revise");
		String messageId=request.getParameter("messageid");
		int topicconut=messagedao.findMessageCount();
		//��ȡÿҳ�ļ�¼����
		int size=CommonUtil.getSize();
//		if()
		
//		//������ҳ��CommonUtil
		int totalpage;
		if(topicconut%size==0){
			totalpage=topicconut/size;
		}
		else{
			totalpage=topicconut/size+1;
		}
//		//��ǰҳ
		int nowpage=1;
		if(request.getParameter("page")!=null){
			nowpage=Integer.parseInt(request.getParameter("page"));
		}
//		//��ҳ���ֵ�ҳ��
		int size1=5;
//		//���÷�ҳ�ķ�Χ
		int min,max;
		
		if(nowpage<3){
			min=1;
			max=size1;
		}
		else{
			min=nowpage-2;
			max=nowpage+2;
		}
		if(max>totalpage){
			max=totalpage;
		}
		//��ҳ�ҵ����Լ���
		List<Message> messagelist=messagedao.findMessageByPage(nowpage);
		//��������
		for(Message m:messagelist){
			//�ҵ�ÿ���û�����
			User user=userdao.findUserByUserId(m.getUserId());
			//������д�����Զ�����
			m.setUserName("wbh");
		}
		//��ֵ����ҳ��
		request.setAttribute("min",min);
		request.setAttribute("size",size);
		request.setAttribute("max",max);
		request.setAttribute("nowpage",nowpage);
		request.setAttribute("totalpage",totalpage);
		request.setAttribute("messagelist", messagelist);
		return "success";
	}
	
}