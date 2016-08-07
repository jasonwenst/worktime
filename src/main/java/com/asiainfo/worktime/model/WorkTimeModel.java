package com.asiainfo.worktime.model;

import java.sql.Timestamp;

public class WorkTimeModel {

	private int workId;
	private int applyDevHour;
	private int applyQaHour;
	private int applyWholeHour;
	private Timestamp createTime;
	private int realDevHour;
	private int realQaHour;
	private int realWholeHour;
	private String requestCode;
	private String requestName;
	private WorkStateModel tbWorkState;
	private EmpModel dev;
	private EmpModel qa;
	private ProcModel tbProc;

	public WorkTimeModel() {
		super();
		this.tbWorkState = new WorkStateModel();
		this.dev = new EmpModel();
		this.qa = new EmpModel();
		this.tbProc = new ProcModel();
	}

	//
	// private ProcEntity tbProc;
	//
	// private EmployeeEntity dev;
	//
	// private EmployeeEntity qa;

	public int getWorkId() {
		return workId;
	}

	public void setWorkId(int workId) {
		this.workId = workId;
	}

	public int getApplyDevHour() {
		return applyDevHour;
	}

	public void setApplyDevHour(int applyDevHour) {
		this.applyDevHour = applyDevHour;
	}

	public int getApplyQaHour() {
		return applyQaHour;
	}

	public void setApplyQaHour(int applyQaHour) {
		this.applyQaHour = applyQaHour;
	}

	public int getApplyWholeHour() {
		return applyWholeHour;
	}

	public void setApplyWholeHour(int applyWholeHour) {
		this.applyWholeHour = applyWholeHour;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public int getRealDevHour() {
		return realDevHour;
	}

	public void setRealDevHour(int realDevHour) {
		this.realDevHour = realDevHour;
	}

	public int getRealQaHour() {
		return realQaHour;
	}

	public void setRealQaHour(int realQaHour) {
		this.realQaHour = realQaHour;
	}

	public int getRealWholeHour() {
		return realWholeHour;
	}

	public void setRealWholeHour(int realWholeHour) {
		this.realWholeHour = realWholeHour;
	}

	public String getRequestCode() {
		return requestCode;
	}

	public void setRequestCode(String requestCode) {
		this.requestCode = requestCode;
	}

	public String getRequestName() {
		return requestName;
	}

	public void setRequestName(String requestName) {
		this.requestName = requestName;
	}

	public WorkStateModel getTbWorkState() {
		return tbWorkState;
	}

	public void setTbWorkState(WorkStateModel tbWorkState) {
		this.tbWorkState = tbWorkState;
	}

	public EmpModel getDev() {
		return dev;
	}

	public void setDev(EmpModel dev) {
		this.dev = dev;
	}

	public EmpModel getQa() {
		return qa;
	}

	public void setQa(EmpModel qa) {
		this.qa = qa;
	}

	public ProcModel getTbProc() {
		return tbProc;
	}

	public void setTbProc(ProcModel tbProc) {
		this.tbProc = tbProc;
	}

}
