package com.asiainfo.worktime.model;

public class EmpModel {

	private int empId;
	private String empEmail;
	private String empName;
	private String empPhone;
	private String empType;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpPhone() {
		return empPhone;
	}

	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}

	public String getEmpType() {
		return empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

	@Override
	public String toString() {
		return "EmpModel [empId=" + empId + ", empEmail=" + empEmail + ", empName=" + empName + ", empPhone=" + empPhone
				+ ", empType=" + empType + "]";
	}
	
	
	
	
}
