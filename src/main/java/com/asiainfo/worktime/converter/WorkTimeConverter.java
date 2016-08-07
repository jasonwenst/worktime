package com.asiainfo.worktime.converter;

import org.springframework.beans.BeanUtils;

import com.asiainfo.worktime.entity.WorkTimeEntity;
import com.asiainfo.worktime.model.WorkTimeModel;

public class WorkTimeConverter {

	
	public static WorkTimeModel getModel(WorkTimeEntity entity) {
		
		WorkTimeModel model = new WorkTimeModel();
		BeanUtils.copyProperties(entity, model);
		BeanUtils.copyProperties(entity.getTbWorkState(), model.getTbWorkState());
		BeanUtils.copyProperties(entity.getQa(), model.getQa());
		BeanUtils.copyProperties(entity.getDev(), model.getDev());
		BeanUtils.copyProperties(entity.getTbProc().getTbRpocType(), model.getTbProc().getTbRpocType());
		BeanUtils.copyProperties(entity.getTbProc(), model.getTbProc());
		return model;
	}
	
	public static WorkTimeEntity getEntity(WorkTimeModel model) {
		WorkTimeEntity entity  = new WorkTimeEntity();
		
		BeanUtils.copyProperties(model, entity);
		BeanUtils.copyProperties(model.getTbProc(), entity.getTbProc());
		BeanUtils.copyProperties(model.getTbWorkState(), entity.getTbWorkState());
		BeanUtils.copyProperties(model.getQa(), entity.getQa());
		BeanUtils.copyProperties(model.getDev(), entity.getDev());
		BeanUtils.copyProperties(model.getTbProc().getTbRpocType(), entity.getTbProc().getTbRpocType());
		
		return entity;
	}
}
