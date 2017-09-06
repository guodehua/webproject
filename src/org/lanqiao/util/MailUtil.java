package org.lanqiao.util;

import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

public class MailUtil {
	static final String SMTPHOST = "smtp.qq.com";
	static final String AUTH_PASSWORD="ndeepejyrwmtbgfg";//授权码
	static final String FROM="178337729@qq.com";//发送邮件的账号（公司固定账号）
	
	public static void sendMail(String go,String subject,String content){  // go--> 收件人账号   , subject--> 邮件主题， content --> 邮件内容 
		Properties props = new Properties();
		props.setProperty("mail.smtp.host", SMTPHOST);//设置邮件服务器
		props.setProperty("mail.transport.protocol", "smtp");//设置发送邮件的协议
		props.setProperty("mail.smtp.auth", "true");//设置验证
		//QQ邮箱创建验证器
		Authenticator auth = new Authenticator(){
			public PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(FROM,AUTH_PASSWORD);
			}
		};
		//QQ邮箱开启ssl认证
		MailSSLSocketFactory sf = null;
		try {
			sf = new MailSSLSocketFactory();
			
		} catch (GeneralSecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		sf.setTrustAllHosts(true);
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.socketFactory", sf);
		//建立邮件服务器会话；---Session
		Session session = Session.getDefaultInstance(props);
		//2、创建一封邮件；---MimeMessage
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(FROM,"郭","utf-8"));//发件人
			message.setSubject("这是一封测试邮件");//设置发送主体
			message.setSentDate(new Date());//设置发送日期；
			message.setContent(content,"text/html;charset=utf-8");//内容
			//设置收件人
			message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(go, "guodehua", "utf-8"));//发件
			//message.setRecipient(MimeMessage.RecipientType.CC, new InternetAddress("517690655@qq.com", "yct", "utf-8"));//抄送
			//message.setRecipient(MimeMessage.RecipientType.BCC, new InternetAddress("952208659@qq.com", "yct", "utf-8"));//密送
			//3、发送邮件 -- Transport
			Transport transport = session.getTransport();
			transport.connect(FROM,AUTH_PASSWORD);//通过授权码以发送账号身份链接
			transport.sendMessage(message, message.getAllRecipients());//发送邮件
			transport.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	public static void sendMail(String subject,String content,String...MailAddress){
		
	}

}
