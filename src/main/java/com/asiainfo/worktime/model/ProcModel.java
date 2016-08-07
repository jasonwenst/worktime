package com.asiainfo.worktime.model;

public class ProcModel {

	private int procId;

	private String procName;

	private ProcTypeModel tbRpocType;
	
	

	public ProcModel() {
		super();
		this.tbRpocType = new ProcTypeModel();
	}

	public int getProcId() {
		return procId;
	}

	public void setProcId(int procId) {
		this.procId = procId;
	}

	public String getProcName() {
		return procName;
	}

	public void setProcName(String procName) {
		this.procName = procName;
	}

	public ProcTypeModel getTbRpocType() {
		return tbRpocType;
	}

	public void setTbRpocType(ProcTypeModel tbRpocType) {
		this.tbRpocType = tbRpocType;
	}
	
	
}
