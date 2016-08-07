package com.asiainfo.worktime.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainfo.worktime.converter.ProcTypeConverter;
import com.asiainfo.worktime.entity.RpocTypeEntity;
import com.asiainfo.worktime.model.ProcTypeModel;
import com.asiainfo.worktime.repository.ProcTypeRepository;

@Service("procTypeService")
public class ProcTypeServiceImpl implements ProcTypeService {

	
	@Autowired
	private ProcTypeRepository repository;
	
	public List<ProcTypeModel> getAllProcTypes() {
		List<ProcTypeModel> models = new ArrayList<ProcTypeModel>();
		
		List<RpocTypeEntity> entites = (List<RpocTypeEntity>)repository.findAll();
		
		for(RpocTypeEntity entity : entites) {
			models.add(ProcTypeConverter.getModel(entity));
		}
		
		return models;
	}

}
