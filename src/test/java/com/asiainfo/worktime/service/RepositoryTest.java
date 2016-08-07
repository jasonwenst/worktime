package com.asiainfo.worktime.service;

import java.sql.Timestamp;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.asiainfo.worktime.configure.BaseJUnit4Test;
import com.asiainfo.worktime.entity.EmployeeEntity;
import com.asiainfo.worktime.entity.ProcEntity;
import com.asiainfo.worktime.entity.WorkStateEntity;
import com.asiainfo.worktime.entity.WorkTimeEntity;
import com.asiainfo.worktime.repository.ProcRepository;
import com.asiainfo.worktime.repository.WorkTimeRepository;

public class RepositoryTest extends BaseJUnit4Test {
	
//	private final Logger log = Logger.getLogger(RepositoryTest.class);

	@Autowired
	private WorkTimeRepository workRepository;
	
	@Autowired
	private ProcRepository procRepository;
	
	@Test
	@Transactional
	public void testQry1() {
		List<ProcEntity> list = procRepository.getAllByProcType("G");
		System.out.println(list.size());
	}

	@Test
	@Transactional
	public void testPaging() {
		Pageable page = new PageRequest(0, 5);

		Page<WorkTimeEntity> pages = workRepository.findAll(page);
		
		for(WorkTimeEntity entity : pages) {
			System.out.println(entity.getRequestName());
		}

	}

	@Test
	public void batchAdd() {
		for(int i = 0; i < 10; i++) {
			testAdd();
		}
	}
	
	@Test
	public void testAdd() {

		EmployeeEntity e1 = new EmployeeEntity();
		e1.setEmpId(1);

		EmployeeEntity e2 = new EmployeeEntity();
		e2.setEmpId(2);

		ProcEntity p = new ProcEntity();
		p.setProcId(1);

		WorkStateEntity w = new WorkStateEntity();
		w.setWorkStateCode("A");

		WorkTimeEntity entity = new WorkTimeEntity();
		entity.setApplyDevHour(1);
		entity.setApplyQaHour(2);
		entity.setApplyWholeHour(3);
		entity.setCreateTime(new Timestamp(System.currentTimeMillis()));
		entity.setRealDevHour(1);
		entity.setRealQaHour(2);
		entity.setRealWholeHour(3);
		entity.setRequestCode("BILLINGDSAF2324");
		entity.setRequestName("���췢Ʊ�ش�");
		entity.setDev(e1);
		entity.setQa(e2);
		entity.setTbProc(p);
		entity.setTbWorkState(w);

		workRepository.save(entity);
	}

	@Test
	@Transactional
	public void testQry() {
		WorkTimeEntity entity = workRepository.findOne(1);

		System.out.println(entity.toString());

		System.out.println(entity.getDev().getEmpName());
		System.out.println(entity.getQa().getEmpName());
		System.out.println(entity.getTbProc().getProcName());
		System.out.println(entity.getTbWorkState().getWorkStateName());
	}

}
