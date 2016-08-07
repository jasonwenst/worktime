package com.asiainfo.worktime.converter;

import org.springframework.beans.BeanUtils;

import com.asiainfo.worktime.entity.EmployeeEntity;
import com.asiainfo.worktime.model.EmpModel;

public class EmpConverter {

	
	public static EmpModel getModel(EmployeeEntity entity) {
		EmpModel model = new EmpModel();
		
	    BeanUtils.copyProperties(entity, model);
	    
	    return model;
	}
	
	public static EmployeeEntity getEntity(EmpModel model) {
		EmployeeEntity entity = new EmployeeEntity();
		
		BeanUtils.copyProperties(model, entity);
		
		return entity;
	}
}
