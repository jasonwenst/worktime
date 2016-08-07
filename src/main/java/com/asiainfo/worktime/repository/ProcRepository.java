package com.asiainfo.worktime.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.asiainfo.worktime.entity.ProcEntity;

public interface ProcRepository extends CrudRepository<ProcEntity, Integer> {
	
	@Query("select proc from ProcEntity proc where proc.tbRpocType.procType = ?1")
	List<ProcEntity> getAllByProcType(String procType);

}
