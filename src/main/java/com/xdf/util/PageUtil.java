package com.xdf.util;

public class PageUtil {

	private Long page;
	
	private Long rows;
	
	private Long lastpage;
	
	private Long index;
	
	private Long total;

	public PageUtil(Long page, Long rows, Long lastpage) {
		super();
		this.page = page;
		this.rows = rows;
		this.lastpage = lastpage;
	}
	
	public PageUtil(Long page, Long rows, Long lastpage, Long total) {
		super();
		this.page = page;
		this.rows = rows;
		this.lastpage = lastpage;
		this.total = total;
	}

	public Long getPage() {
		if (this.page < 1) {
			this.page = 1L;
		} else if (this.lastpage != null && this.page > this.lastpage) {
			this.page = this.lastpage;
		}
		return page;
	}

	public void setPage(Long page) {
		if (page < 1) {
			this.page = 1L;
		} else if (this.lastpage != null && page > this.lastpage) {
			this.page = this.lastpage;
		} else {
			this.page = page;
		}
	}

	public Long getRows() {
		return rows;
	}

	public void setRows(Long rows) {
		this.rows = rows;
	}

	public Long getLastpage() {
		this.lastpage = 0L;
		if (this.total%this.rows == 0) 
			this.lastpage = this.total/this.rows; 
		else 
			this.lastpage = this.total/this.rows + 1;
		return this.lastpage;
	}

	public void setLastpage(Long lastpage) {
		this.lastpage = lastpage;
	}

	public Long getIndex() {
		this.index = (this.getPage() - 1)*this.rows;
		return index;
	}

	public void setIndex(Long index) {
		this.index = index;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}
	
	
}
