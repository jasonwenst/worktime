package com.asiainfo.worktime.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TB_EMPLOYEE database table.
 * 
 */
@Entity
@Table(name="TB_EMPLOYEE")
//@NamedQuery(name="TbEmployee.findAll", query="SELECT t FROM TbEmployee t")
public class EmployeeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="EMP_ID")
	private int empId;

	@Column(name="EMP_EMAIL")
	private String empEmail;

	@Column(name="EMP_NAME")
	private String empName;

	@Column(name="EMP_PHONE")
	private String empPhone;

	@Column(name="EMP_TYPE")
	private String empType;

	//bi-directional many-to-one association to TbWorkTime
	@OneToMany(mappedBy="dev")
	private List<WorkTimeEntity> dev;

	//bi-directional many-to-one association to TbWorkTime
	@OneToMany(mappedBy="qa")
	private List<WorkTimeEntity> qa;

	public EmployeeEntity() {
	}

	public int getEmpId() {
		return this.empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpEmail() {
		return this.empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpName() {
		return this.empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpPhone() {
		return this.empPhone;
	}

	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}

	public String getEmpType() {
		return this.empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}



	public WorkTimeEntity addTbWorkTimes1(WorkTimeEntity tbWorkTimes1) {
		getDev().add(tbWorkTimes1);
		tbWorkTimes1.setDev(this);

		return tbWorkTimes1;
	}

	public WorkTimeEntity removeTbWorkTimes1(WorkTimeEntity tbWorkTimes1) {
		getDev().remove(tbWorkTimes1);
		tbWorkTimes1.setDev(null);

		return tbWorkTimes1;
	}

	public List<WorkTimeEntity> getDev() {
		return dev;
	}

	public void setDev(List<WorkTimeEntity> dev) {
		this.dev = dev;
	}

	public List<WorkTimeEntity> getQa() {
		return qa;
	}

	public void setQa(List<WorkTimeEntity> qa) {
		this.qa = qa;
	}

	public List<WorkTimeEntity> getTbWorkTimes2() {
		return this.qa;
	}

	public void setTbWorkTimes2(List<WorkTimeEntity> tbWorkTimes2) {
		this.qa = tbWorkTimes2;
	}


}