package org.lanqiao.service;

import org.lanqiao.entity.PasswordAnswer;
import org.lanqiao.dao.*;

public class PasswordAnswerServiceImp implements PasswordAnswerService {

	org.lanqiao.dao.PasswordAnswerDao pa = new org.lanqiao.dao.PasswordAnswerDaoImp();
	@Override
	public void insertPasswordAnswer(PasswordAnswer passwordAnswer) {
		pa.insertPasswordAnswer(passwordAnswer);
	}

	@Override
	public PasswordAnswer getPasswordAnswerByUserid(String userid) {
		//org.lanqiao.dao.PasswordAnswerDao pa = new org.lanqiao.dao.PasswordAnswerDaoImp();
		return pa.getPasswordAnswerByUserid(userid);
	}

	@Override
	public void upDate(PasswordAnswer passwordAnswer) {
		pa.upDate(passwordAnswer);
	}

}
