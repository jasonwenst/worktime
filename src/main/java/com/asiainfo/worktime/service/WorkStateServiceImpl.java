package com.asiainfo.worktime.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainfo.worktime.converter.WorkStateConverter;
import com.asiainfo.worktime.entity.WorkStateEntity;
import com.asiainfo.worktime.model.WorkStateModel;
import com.asiainfo.worktime.repository.WorkStateRepository;

@Service("stateService")
public class WorkStateServiceImpl implements WorkStateService {
	
	@Autowired
	private WorkStateRepository respository;

	public List<WorkStateModel> getAllStates() {
		
		List<WorkStateEntity> allStates = (List<WorkStateEntity>)respository.findAll();
		
		List<WorkStateModel> models = new ArrayList<WorkStateModel>();
		
		for(WorkStateEntity entity : allStates) {
			models.add(WorkStateConverter.getModel(entity));
		}
		
		return models;
	}

}
