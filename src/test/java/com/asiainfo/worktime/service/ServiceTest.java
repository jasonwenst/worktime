package com.asiainfo.worktime.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.asiainfo.worktime.configure.BaseJUnit4Test;
import com.asiainfo.worktime.model.EmpModel;
import com.asiainfo.worktime.model.ProcModel;
import com.asiainfo.worktime.model.ProcTypeModel;
import com.asiainfo.worktime.model.WorkTimeModel;
import com.asiainfo.worktime.repository.ProcRepository;

public class ServiceTest  extends BaseJUnit4Test{

	
	@Autowired
	WorkTimeService workTimeService;
	
	@Autowired
	EmpService empService;
	
	@Autowired
	ProcRepository repository;
	
	
	@Test
	public void testPagingSec() {
		
		Pageable page = new PageRequest(0, 5);
		
		WorkTimeModel model = new WorkTimeModel();
		ProcTypeModel type = new ProcTypeModel();
		type.setProcType("-1");
		ProcModel proc = new ProcModel();
		proc.setProcId(-1);
		proc.setTbRpocType(type);
		model.setTbProc(proc);
		EmpModel dev = new EmpModel();
		EmpModel qa = new EmpModel();
		dev.setEmpId(-1);
		qa.setEmpId(6);
		model.setDev(dev);
		model.setQa(qa);
		
		Page<WorkTimeModel>  models = workTimeService.getPagingWorkTimes(model, page);
		
		System.out.println(models.getTotalPages());
	}
	
	
	@Test
	public void getEmps() {
		List<EmpModel> models = empService.getAllEmps();
		
		for(EmpModel model : models) {
			System.out.println(model.toString());
		}
	}
	
	
	@Test
	@Transactional
	public void testpaging() {
		
		Pageable page = new PageRequest(1, 5);
		
		Page<WorkTimeModel> pages = workTimeService.getPagingWorkTimes(page);
		
		System.out.println("stateName = "  + pages.getContent().get(0).getTbWorkState().getWorkStateName());
	}

	

	
}
