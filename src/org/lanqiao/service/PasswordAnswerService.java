package org.lanqiao.service;

import org.lanqiao.entity.PasswordAnswer;

public interface PasswordAnswerService {
	public void insertPasswordAnswer(PasswordAnswer passwordAnswer);
	public PasswordAnswer getPasswordAnswerByUserid(String userid);
	public void upDate(PasswordAnswer passwordAnswer);
}
