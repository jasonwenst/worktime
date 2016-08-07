package com.asiainfo.worktime.converter;

import org.springframework.beans.BeanUtils;

import com.asiainfo.worktime.entity.ProcEntity;
import com.asiainfo.worktime.model.ProcModel;

public class ProcConverter {

	
	public static ProcEntity getEntity(ProcModel model) {
		ProcEntity entity = new ProcEntity();
		
		BeanUtils.copyProperties(model, entity);
		
		return entity;
	}
	
	
	public static ProcModel getModel(ProcEntity entity) {
		ProcModel model = new ProcModel();
		
		BeanUtils.copyProperties(entity, model);
		BeanUtils.copyProperties(entity.getTbRpocType(), model.getTbRpocType());
		
		return model;
	}
}
