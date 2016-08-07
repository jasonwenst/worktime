package com.asiainfo.worktime.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.asiainfo.worktime.entity.WorkTimeEntity;

public interface WorkTimeRepository extends CrudRepository<WorkTimeEntity, Integer>, PagingAndSortingRepository<WorkTimeEntity, Integer>, JpaSpecificationExecutor<WorkTimeEntity> {

	
}
