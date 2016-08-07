package com.asiainfo.worktime.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.asiainfo.worktime.entity.EmployeeEntity;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Integer>, PagingAndSortingRepository<EmployeeEntity, Integer> {

	List<EmployeeEntity> getEmployeeEntityByEmpType(String empType);
}
