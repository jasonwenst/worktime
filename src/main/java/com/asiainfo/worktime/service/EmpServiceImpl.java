package com.asiainfo.worktime.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.asiainfo.worktime.converter.EmpConverter;
import com.asiainfo.worktime.entity.EmployeeEntity;
import com.asiainfo.worktime.model.EmpModel;
import com.asiainfo.worktime.repository.EmployeeRepository;

@Service("empService")
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmployeeRepository repository;
	
	public List<EmpModel> getAllEmps() {
		List<EmpModel> models = new ArrayList<EmpModel>();
		Sort sort = new Sort(Sort.Direction.ASC, "empName");
		List<EmployeeEntity> emps =(ArrayList<EmployeeEntity>) repository.findAll(sort);
		for(EmployeeEntity entity : emps) {
			models.add(EmpConverter.getModel(entity));
		}
		return models;
	}

}
