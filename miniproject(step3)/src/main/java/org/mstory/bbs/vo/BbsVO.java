package org.mstory.bbs.vo;

import java.sql.Date;
import java.util.Arrays;

public class BbsVO {
	
	private Integer bno;
	private String title;
	private String writer;
	private String publisher;
	private String pubyear; //Date로 바꿔야된다.
	private String keyword;
	private Date regdate;
	private Integer state;
	
	private Integer lately; 
	private Integer viewcnt; //조회수
	private Integer cnt; //101, 201, ......
	private Integer replycnt; //댓글수
	
	private String isFile = "F";
	private String filename;
	private String[] fileList;
	
	public Integer getLately() {
		return lately;
	}
	public void setLately(Integer lately) {
		this.lately = lately;
	}
	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}
	
	public Integer getReplycnt() {
		return replycnt;
	}
	public void setReplycnt(Integer replycnt) {
		this.replycnt = replycnt;
	}
	public Integer getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(Integer viewcnt) {
		this.viewcnt = viewcnt;
	}
	
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public Integer getBno() {
		return bno;
	}
	public void setBno(Integer bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPubyear() {
		return pubyear;
	}
	public void setPubyear(String pubyear) {
		this.pubyear = pubyear;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getIsFile() {
		return isFile;
	}
	public void setIsFile(String isFile) {
		this.isFile = isFile;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String[] getFileList() {
		return fileList;
	}
	public void setFileList(String[] fileList) {
		this.fileList = fileList;
	}
	@Override
	public String toString() {
		return "BbsVO [bno=" + bno + ", title=" + title + ", writer=" + writer
				+ ", publisher=" + publisher + ", pubyear=" + pubyear
				+ ", keyword=" + keyword + ", regdate=" + regdate + ", state="
				+ state + ", lately=" + lately + ", viewcnt=" + viewcnt
				+ ", cnt=" + cnt + ", replycnt=" + replycnt + ", isFile="
				+ isFile + ", filename=" + filename + ", fileList="
				+ Arrays.toString(fileList) + "]";
	}

	

}
