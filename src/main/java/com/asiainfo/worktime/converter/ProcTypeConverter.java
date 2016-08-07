package com.asiainfo.worktime.converter;

import org.springframework.beans.BeanUtils;

import com.asiainfo.worktime.entity.RpocTypeEntity;
import com.asiainfo.worktime.model.ProcTypeModel;

public class ProcTypeConverter {
	
	public static ProcTypeModel getModel(RpocTypeEntity entity) {
		ProcTypeModel model = new ProcTypeModel();
		
		BeanUtils.copyProperties(entity, model);
		
		return model;
		
	}
	
	
	public static RpocTypeEntity getEntity(ProcTypeModel model) {
		RpocTypeEntity entity  = new RpocTypeEntity();
		
		BeanUtils.copyProperties(model, entity);
		
		return entity;
		
	}

}
