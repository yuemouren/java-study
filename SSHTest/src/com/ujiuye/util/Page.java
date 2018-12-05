package com.ujiuye.util;

public class Page {
	private Integer currentPage;// 当前页
	private Integer perPageRows;// 每页的记录数
	private Integer totalRows;// 总记录数：
	private Integer totalPages;// 总页数：

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPerPageRows() {
		return perPageRows;
	}

	public void setPerPageRows(Integer perPageRows) {
		this.perPageRows = perPageRows;
	}

	public Integer getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(Integer totalRows) {
		this.totalRows = totalRows;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
}
