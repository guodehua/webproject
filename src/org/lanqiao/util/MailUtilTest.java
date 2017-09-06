package org.lanqiao.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class MailUtilTest {

	@Test
	public void testSendMailStringStringString() {
		 new  MailUtil().sendMail("18435138179@163.com", "邮件主题", "邮件内容");
	}

}
