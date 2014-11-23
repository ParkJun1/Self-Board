package org.mstory.bbs.vo;

import java.sql.Date;

public class ReplyVO {
	
	private Integer rno;
	private Integer bno; 
	private String replyer;
	private String reply;
	private Date regdate;
	private Date moddate;
	private Integer lately;
	
	public Integer getLately() {
		return lately;
	}
	public void setLately(Integer lately) {
		this.lately = lately;
	}
	public Integer getRno() {
		return rno;
	}
	public void setRno(Integer rno) {
		this.rno = rno;
	}
	public Integer getBno() {
		return bno;
	}
	public void setBno(Integer bno) {
		this.bno = bno;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getModdate() {
		return moddate;
	}
	public void setModdate(Date moddate) {
		this.moddate = moddate;
	}
	@Override
	public String toString() {
		return "ReplyVO [rno=" + rno + ", bno=" + bno + ", replyer=" + replyer
				+ ", reply=" + reply + ", regdate=" + regdate + ", moddate="
				+ moddate + "]";
	}
	  
	  
}
