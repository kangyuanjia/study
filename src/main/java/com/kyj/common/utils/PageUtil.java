package com.kyj.common.utils;

public class PageUtil {

	private int page;
	private int totalRecord;
	private int pageCount;//总页数
	private int rows;  //每页显示条数
		
	public PageUtil(int page, int rows) {
		super();
		this.page = page;
		this.rows = rows;
	}

	public int getPageCount() {
		pageCount=totalRecord%rows==0?totalRecord/rows:totalRecord/rows+1;
		return pageCount ;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}


	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	
	public int getStartRecord(){
		if((page-1)*rows>totalRecord){
			return rows;
		}else{
			return (page-1)*rows;
		}
	}
}
