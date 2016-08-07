package com.asiainfo.worktime.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asiainfo.worktime.criteria.SearchCriteria;
import com.asiainfo.worktime.model.EmpModel;
import com.asiainfo.worktime.model.PaginationConf;
import com.asiainfo.worktime.model.ProcModel;
import com.asiainfo.worktime.model.ProcTypeModel;
import com.asiainfo.worktime.model.WorkStateModel;
import com.asiainfo.worktime.model.WorkTimeModel;
import com.asiainfo.worktime.repository.ProcTypeRepository;
import com.asiainfo.worktime.repository.WorkTimeRepository;
import com.asiainfo.worktime.service.EmpService;
import com.asiainfo.worktime.service.ProcService;
import com.asiainfo.worktime.service.ProcTypeService;
import com.asiainfo.worktime.service.WorkStateService;
import com.asiainfo.worktime.service.WorkTimeService;

@Controller
public class WorkTimeController {
	
	private static final Logger log = LoggerFactory.getLogger(WorkTimeController.class);
	
	@Autowired
	private WorkTimeService workTiemService;
	@Autowired
	private EmpService empService;
	@Autowired
	private WorkStateService stateService;
	@Autowired
	private ProcService procService;
	@Autowired
	private ProcTypeService procTypeService;
	
	@RequestMapping(value="/workTimes", method = RequestMethod.POST)
	@ResponseBody
	public Object getPagingWorkTime(@RequestBody PaginationConf conf) {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log.info("pageConf = {}", conf.toString());
		Sort sort = new Sort(Direction.DESC, "createTime");
		Pageable page = new PageRequest(conf.getPageIndex(), conf.getPageSize(), sort);
		Page<WorkTimeModel> entities = workTiemService.getPagingWorkTimes(page);
//		ResponseEntity<Page<WorkTimeEntity>> pages =  new ResponseEntity<Page<WorkTimeEntity>>( entities,HttpStatus.OK);
		log.info("return entities = {}", entities.toString());
		return entities;
		
	}
	
	
	@RequestMapping(value = "/workTimes/pages", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Page<WorkTimeModel>> getPagingWrokTime(@RequestBody SearchCriteria criteria) {
		
		Sort sort = new Sort(Direction.DESC, "createTime");
		Pageable page = new PageRequest(criteria.getCurrentPage(), criteria.getPageSize(), sort);
		
		Page<WorkTimeModel> entities = workTiemService.getPagingWorkTimes(criteria.getCriteria(), page);
		
		return new ResponseEntity<Page<WorkTimeModel>>(entities, HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage() {
		return "view/app";
	}
	
	@RequestMapping(value = "/workTime/update", method = RequestMethod.POST) 
	@ResponseBody
	public Object update(@RequestBody WorkTimeModel model) {
		workTiemService.save(model);
		return Boolean.TRUE;
	}
	
	
	@RequestMapping(value = "/emps", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<EmpModel>> getEmpSelets() {
		return new ResponseEntity<List<EmpModel>>( empService.getAllEmps(), HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/states", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<WorkStateModel>> getStates() {
		return new ResponseEntity<List<WorkStateModel>>(stateService.getAllStates(), HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value = "/procs", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<ProcModel>> getPorcs() {
		return new ResponseEntity<List<ProcModel>>(procService.getAllProc(), HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/procTypes", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<ProcTypeModel>> getProcTypes() {
		return new ResponseEntity<List<ProcTypeModel>>(procTypeService.getAllProcTypes(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/procs/proctype/{procType}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<ProcModel>> getPorcs(@PathVariable String procType) {
		return new ResponseEntity<List<ProcModel>>(procService.getAllProcByProcType(procType), HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/worktime/delete", method = RequestMethod.POST)
	public ResponseEntity<Boolean> deleteWork(@RequestBody WorkTimeModel model) {
		workTiemService.delete(model.getWorkId());
		
		return  new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
