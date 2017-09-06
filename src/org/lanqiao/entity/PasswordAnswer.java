package org.lanqiao.entity;

public class PasswordAnswer {
	private String answerid;
	private String aquestion;
	private String answer;
	private String amail;
	private String userid;
	
	
	public PasswordAnswer() {
		super();
	}
	public PasswordAnswer(String answerid, String aquestion, String answer, String amail, String userid) {
		super();
		this.answerid = answerid;
		this.aquestion = aquestion;
		this.answer = answer;
		this.amail = amail;
		this.userid = userid;
	}
	public String getAnswerid() {
		return answerid;
	}
	public void setAnswerid(String answerid) {
		this.answerid = answerid;
	}
	public String getAquestion() {
		return aquestion;
	}
	public void setAquestion(String aquestion) {
		this.aquestion = aquestion;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getAmail() {
		return amail;
	}
	public void setAmail(String amail) {
		this.amail = amail;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "PasswordAnswer [answerid=" + answerid + ", aquestion=" + aquestion + ", answer=" + answer + ", amail="
				+ amail + ", userid=" + userid + "]";
	}
	
}
