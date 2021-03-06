package com.wbh.dao;

import java.math.BigDecimal;
import java.util.List;

import com.wbh.dao.util.DaoHandler;
import com.wbh.pojo.User;

public class UserDao {
	/**
	 * 通过用户名获取用户
	 * @param userName
	 * @return
	 */
	public User findUserByUserName(String userName){
		List<User> listUser = DaoHandler.executeQueryMultiple("select * from user_ where userName=?", new Object[]{userName}, User.class);
		if(listUser.size()!=0){
			return listUser.get(0);
		}
		else{
			return null;
		}
	}
	
	/**
	 * 通过用户编号查找用户
	 * @param userId
	 * @return
	 */
	public User findUserByUserId(int userId){
		List<User> listUser = DaoHandler.executeQueryMultiple("select * from user_ where userId=?", new Object[]{userId}, User.class);
		if(listUser.size()!=0){
			return listUser.get(0);
		}
		else{
			return null;
		}
	}
	
	/**
	 * 添加用户
	 * @param user
	 */
	public void addUser(User user){
		DaoHandler.executeUpdate("insert into user_ values(seq_userId.nextval,?,?,?,0,0,?)", new Object[]{user.getUserName(),user.getUserPwd(),user.getUserSex(),user.getRegTime()});
	}

	/**
	 * 
	 * 查找所有用户
	 */
	public List<User> findAllUser(){
		return DaoHandler.executeQueryMultiple("select *from user_", new Object[]{}, User.class);
	}
	/**
	 * 分页查找所有用户
	 */
	public List<User> findAllUserBypage(int page){
		return DaoHandler.executeQueryByPage("select *from(select rownum as rid,user_.*from user_) where rid between ? and ?", new Object[]{}, page, User.class);
	}
	/**
	 * 查询公共有多少个用户
//	 */
	public int findAllUserCount(){
		BigDecimal decimal=(BigDecimal)DaoHandler.executeQuerySeriz("select count(*) from user_",new Object[]{});
		if(decimal==null){
			return 0;
		}
		return decimal.intValue();
	}
	
	/**
	 * 修改密码
	 * @param password
	 * @param userName
	 */
	public void modifyPwd(String password,String userName){
		DaoHandler.executeUpdate("update user_ set userPwd = ? where userName = ?", new Object[]{password,userName});
	}
	
	public void addPoint(int userPoint,int userId){
		DaoHandler.executeUpdate("update user_ set userPoint = userPoint+? where userId = ?", new Object[]{userPoint,userId});
	}
}
