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
		//创建接收的集合和用到的dao
		List<User> userlist=new ArrayList();
		UserDao userdao=new UserDao();
		MessageDao messagedao=new MessageDao();
		
//		System.out.println(messagelist.size());
		//接收传过来的值
		String revise=request.getParameter("revise");
		String messageId=request.getParameter("messageid");
		int topicconut=messagedao.findMessageCount();
		//获取每页的记录条数
		int size=CommonUtil.getSize();
//		if()
		
//		//计算总页数CommonUtil
		int totalpage;
		if(topicconut%size==0){
			totalpage=topicconut/size;
		}
		else{
			totalpage=topicconut/size+1;
		}
//		//当前页
		int nowpage=1;
		if(request.getParameter("page")!=null){
			nowpage=Integer.parseInt(request.getParameter("page"));
		}
//		//分页呈现的页数
		int size1=5;
//		//设置分页的范围
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
		//分页找到留言集合
		List<Message> messagelist=messagedao.findMessageByPage(nowpage);
		//遍历集合
		for(Message m:messagelist){
			//找到每个用户对象
			User user=userdao.findUserByUserId(m.getUserId());
			//将名字写到留言对象中
			m.setUserName("wbh");
		}
		//把值传到页面
		request.setAttribute("min",min);
		request.setAttribute("size",size);
		request.setAttribute("max",max);
		request.setAttribute("nowpage",nowpage);
		request.setAttribute("totalpage",totalpage);
		request.setAttribute("messagelist", messagelist);
		return "success";
	}
	
}
