package org.lanqiao.service;

import java.util.List;

import org.lanqiao.entity.Users;

public class UserServiceImp implements UserService {
	org.lanqiao.dao.UserDao user = new org.lanqiao.dao.UserDaoImp();
	@Override
	public void regi(Users user1) {
		
		user.regi(user1);
	}

	@Override
	public Users getUserByName(String uname) {
		return user.getUserByName(uname);
	}

	@Override
	public void insertUstateid(String userid, String ustateid) {
		user.insertUstateid(userid, ustateid);
	}

	@Override
	public void insertUsersAgain(Users user1) {
		user.insertUsersAgain(user1);
		
	}

	@Override
	public List<Users> userList() {
		return user.userList();
	}

	@Override
	public boolean removeUserByUserid(String userid) {
		return user.removeUserByUserid(userid);
	}

	@Override
	public Users getUserByEmail(String uemail) {
		
		return user.getUserByEmail(uemail);
	}

}
