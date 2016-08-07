package com.asiainfo.worktime.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.asiainfo.worktime.converter.WorkTimeConverter;
import com.asiainfo.worktime.entity.WorkTimeEntity;
import com.asiainfo.worktime.model.WorkTimeModel;
import com.asiainfo.worktime.repository.WorkTimeRepository;

@Service("workTimeService")
public class WorkTimeServiceImp implements WorkTimeService {

	
	@Autowired
	private WorkTimeRepository repository;
	
	@Transactional
	public Page<WorkTimeModel> getPagingWorkTimes(Pageable page) {
		Page<WorkTimeEntity> pages = repository.findAll(page);
		List<WorkTimeModel> models = new ArrayList<WorkTimeModel>();
		for(WorkTimeEntity entity : pages) {
			models.add(WorkTimeConverter.getModel(entity));
		}
		Page<WorkTimeModel> modelPages = new PageImpl(models, page, pages.getTotalElements());
		return modelPages;
	}
	
	public void save(WorkTimeModel model) {
		
		repository.save(WorkTimeConverter.getEntity(model));
		
	}
	
	public void delete(int workId) {
		repository.delete(workId);
	}

	public Page<WorkTimeModel> getPagingWorkTimes(final WorkTimeModel condition, Pageable page) {
		
		List<WorkTimeModel> models = new ArrayList<WorkTimeModel>();
		
		Page<WorkTimeEntity> pages = repository.findAll(new Specification<WorkTimeEntity>() {

			public Predicate toPredicate(Root<WorkTimeEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Path<String> procType = root.join("tbProc").join("tbRpocType").get("procType"); 
				Path<Integer> procId = root.join("tbProc").get("procId");
				Path<Integer> devId = root.join("dev").get("empId");
				Path<Integer> qaId = root.join("qa").get("empId");
				List<Predicate> pres = new ArrayList<Predicate>();
				if(condition.getTbProc().getProcId() != -1) {
					pres.add(cb.equal(procId, condition.getTbProc().getProcId()));
				}
				if(!"-1".equals(condition.getTbProc().getTbRpocType().getProcType())) {
					pres.add(cb.equal(procType, condition.getTbProc().getTbRpocType().getProcType()));
				}
				if( condition.getDev().getEmpId() != -1) {
					pres.add(cb.equal(devId, condition.getDev().getEmpId()));
				}
				if(condition.getQa().getEmpId() != -1) {
					pres.add(cb.equal(qaId, condition.getQa().getEmpId()));
				}
				Predicate[] pre = new Predicate[pres.size()];
				query.where(pres.toArray(pre));
// 				query.where(
//						cb.equal(procId, condition.getTbProc().getProcId()),
//						cb.equal(procType, condition.getTbProc().getTbRpocType().getProcType()),
//						cb.equal(devId, condition.getDev().getEmpId()),
//						cb.equal(qaId, condition.getQa().getEmpId()));
				
				return null;
			}
			
		},page);
		
		for(WorkTimeEntity entity : pages) {
			models.add(WorkTimeConverter.getModel(entity));
		}
		Page<WorkTimeModel> modelPages = new PageImpl(models, page, pages.getTotalElements());
		return modelPages;
	}

}
