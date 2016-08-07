package com.asiainfo.worktime.converter;

import org.springframework.beans.BeanUtils;

import com.asiainfo.worktime.entity.WorkStateEntity;
import com.asiainfo.worktime.model.WorkStateModel;

public class WorkStateConverter {
	
	public static WorkStateModel getModel(WorkStateEntity entity) {
		WorkStateModel model = new WorkStateModel();
		
		BeanUtils.copyProperties(entity, model);
		
		return model;
		
	}
	
	
	public static WorkStateEntity getEntity(WorkStateModel model) {
		WorkStateEntity entity = new WorkStateEntity();
		
		BeanUtils.copyProperties(model, entity);
		
		return entity;
	}

}
