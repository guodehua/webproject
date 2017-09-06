package org.lanqiao.dao;

import java.util.List;

import org.lanqiao.entity.Users;


public interface UserDao {
	public void regi(Users user);
	public Users getUserByName(String uname);
	public void insertUstateid(String userid,String ustateid);
	public void insertUsersAgain(Users user);
	//返回所有用户信息
	public List<Users> userList();
	//删除单个用户
	public boolean removeUserByUserid(String userid);
	public Users getUserByEmail(String uemail);
}
