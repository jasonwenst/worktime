package com.asiainfo.worktime.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.asiainfo.worktime.model.WorkTimeModel;

public interface  WorkTimeService {
	
	
	Page<WorkTimeModel> getPagingWorkTimes(Pageable page);
	
	public void save(WorkTimeModel model);
	
	public void delete(int workId);
	
	Page<WorkTimeModel> getPagingWorkTimes(WorkTimeModel condition, Pageable page);
	

}
