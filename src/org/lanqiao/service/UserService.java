package org.lanqiao.service;

import java.util.List;

import org.lanqiao.entity.Users;

public interface UserService {
	public void regi(Users user);
	public Users getUserByName(String uname);
	public void insertUstateid(String userid,String ustateid);
	//更新数据  表名不恰当
	public void insertUsersAgain(Users user);
	public List<Users> userList();
	//删除单个用户
	public boolean removeUserByUserid(String userid);
	public Users getUserByEmail(String uemail);
}
