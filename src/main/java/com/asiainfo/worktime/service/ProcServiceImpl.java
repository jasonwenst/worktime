package com.asiainfo.worktime.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asiainfo.worktime.converter.ProcConverter;
import com.asiainfo.worktime.entity.ProcEntity;
import com.asiainfo.worktime.model.ProcModel;
import com.asiainfo.worktime.repository.ProcRepository;


@Service("procService")
public class ProcServiceImpl implements ProcService {
	
	@Autowired
	private ProcRepository repository;

	@Transactional
	public List<ProcModel> getAllProc() {
		List<ProcEntity> procs = (List<ProcEntity>)repository.findAll();
		List<ProcModel> models = new ArrayList<ProcModel>();
		for(ProcEntity entity : procs) {
			models.add(ProcConverter.getModel(entity));
			
		}
		return models;
	}

	
	public List<ProcModel> getAllProcByProcType(String procType) {
		List<ProcEntity> procs = (List<ProcEntity>)repository.getAllByProcType(procType);
		List<ProcModel> models = new ArrayList<ProcModel>();
		for(ProcEntity entity : procs) {
			models.add(ProcConverter.getModel(entity));
			
		}
		return models;
	}

}
