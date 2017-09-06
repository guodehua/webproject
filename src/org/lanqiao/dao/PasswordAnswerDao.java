package org.lanqiao.dao;

import org.lanqiao.entity.PasswordAnswer;

public interface PasswordAnswerDao {
	public void insertPasswordAnswer(PasswordAnswer passwordAnswer);
	public PasswordAnswer getPasswordAnswerByUserid(String userid);
	public void upDate(PasswordAnswer passwordAnswer);
}
