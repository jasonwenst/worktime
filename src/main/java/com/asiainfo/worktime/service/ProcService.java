package com.asiainfo.worktime.service;

import java.util.List;

import com.asiainfo.worktime.model.ProcModel;

public interface ProcService {

	
	List<ProcModel> getAllProc();
	
	List<ProcModel> getAllProcByProcType(String procType);
}
