package com.asiainfo.worktime.criteria;

import com.asiainfo.worktime.model.WorkTimeModel;

public class SearchCriteria {

	
	private WorkTimeModel criteria;
	private int currentPage;
	private int pageSize;
	
	public WorkTimeModel getCriteria() {
		return criteria;
	}

	public void setCriteria(WorkTimeModel criteria) {
		this.criteria = criteria;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	
	
	
	
}
