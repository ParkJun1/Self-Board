package org.mstory.bbs.common;

import java.util.HashMap;
import java.util.Map;

public class Criteria {

	private int page; // 현재 페이지
	private int total; // 101개의 데이터
	private int displaySize = 10; // 한화면에 보여지는 클릭할 페이지
	private int perPageSize = 10; // 한페이지당 나오는 게시물 수

	private int startPage;
	private int endPage;

	private int rnFirst;
	private int rnLast;

	private boolean hasBefore = false;
	private boolean hasNext = false;

	private String type;
	private String keyword;

	private Map<String, String> criMap;

	public Criteria() {
		this(1);
	}

	public Criteria(int page) {
		this.page = page;
	}

	public void setTotal(int total) {
		this.total = total;
		calcStartEndPage();
	}

	public int getRnLast() {
		this.rnLast = page * perPageSize;
		return rnLast;
	}

	public int getRnFirst() {
		this.rnFirst = getRnLast() - perPageSize;
		return rnFirst;
	}

	public void calcStartEndPage() {

		int tempEnd = ((int) Math.ceil(page / (double) displaySize)) * displaySize;

		this.startPage = (tempEnd - displaySize) + 1;

		if (this.total >= tempEnd * perPageSize) {
			this.endPage = tempEnd;
		} else {
			this.endPage = (int) Math.ceil(total / (double) perPageSize);
		}

		if (this.startPage != 1) {
			this.hasBefore = true;
		}
		if (this.total > tempEnd * perPageSize) {
			this.hasNext = true;
		}

	}

	public String selected(String type) {

		if (this.type == null || this.type == "") {
			return "";
		}
		if (this.type.equals(type)) {
			System.out.println(type + "selected");
			return "selected";
		}
		return "";
	}

	public void parseType(String type, String keyword) {
		criMap = new HashMap<String, String>();
		String[] typeArr = type.split("-");
		
		for (String str : typeArr) {
			System.out.println(str + ":" + keyword);
			criMap.put(str, keyword);
		}
	}
	
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	
	public int getTotal() {
		return total;
	}

	public int getDisplaySize() {
		return displaySize;
	}

	public int getPerPageSize() {
		return perPageSize;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public boolean isHasBefore() {
		return hasBefore;
	}

	public boolean isHasNext() {
		return hasNext;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public Map<String, String> getCriMap() {
		return criMap;
	}

	public void setCriMap(Map<String, String> criMap) {
		this.criMap = criMap;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", total=" + total
				+ ", displaySize=" + displaySize + ", perPageSize="
				+ perPageSize + ", startPage=" + startPage + ", endPage="
				+ endPage + ", rnFirst=" + rnFirst + ", rnLast=" + rnLast
				+ ", hasBefore=" + hasBefore + ", hasNext=" + hasNext
				+ ", type=" + type + ", keyword=" + keyword 
				+ ", criMap=" + criMap + "]";
	}

}
