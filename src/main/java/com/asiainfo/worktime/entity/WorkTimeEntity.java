package com.asiainfo.worktime.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the TB_WORK_TIME database table.
 * 
 */
@Entity
@Table(name="TB_WORK_TIME")
//@NamedQuery(name="TbWorkTime.findAll", query="SELECT t FROM TbWorkTime t")
public class WorkTimeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="WORK_ID")
	private int workId;

	@Column(name="APPLY_DEV_HOUR")
	private int applyDevHour;

	@Column(name="APPLY_QA_HOUR")
	private int applyQaHour;

	@Column(name="APPLY_WHOLE_HOUR")
	private int applyWholeHour;

	@Column(name="CREATE_TIME")
	private Timestamp createTime;

	@Column(name="REAL_DEV_HOUR")
	private int realDevHour;

	@Column(name="REAL_QA_HOUR")
	private int realQaHour;

	@Column(name="REAL_WHOLE_HOUR")
	private int realWholeHour;

	@Column(name="REQUEST_CODE")
	private String requestCode;

	@Column(name="REQUEST_NAME")
	private String requestName;

	//bi-directional many-to-one association to TbWorkState
	@ManyToOne
	@JoinColumn(name="WORK_STATE_CODE")
	private WorkStateEntity tbWorkState;

	//bi-directional many-to-one association to TbProc
	@ManyToOne
	@JoinColumn(name="PROC_ID")
	private ProcEntity tbProc;

	//bi-directional many-to-one association to TbEmployee
	@ManyToOne
	@JoinColumn(name="DEV")
	private EmployeeEntity dev;

	//bi-directional many-to-one association to TbEmployee
	@ManyToOne
	
	@JoinColumn(name="QA")
	private EmployeeEntity qa;

	public WorkTimeEntity() {
		this.tbProc = new ProcEntity();
		this.tbWorkState = new WorkStateEntity();
		this.qa = new EmployeeEntity();
		this.dev = new EmployeeEntity();
	}

	public int getWorkId() {
		return this.workId;
	}

	public void setWorkId(int workId) {
		this.workId = workId;
	}

	public int getApplyDevHour() {
		return this.applyDevHour;
	}

	public void setApplyDevHour(int applyDevHour) {
		this.applyDevHour = applyDevHour;
	}

	public int getApplyQaHour() {
		return this.applyQaHour;
	}

	public void setApplyQaHour(int applyQaHour) {
		this.applyQaHour = applyQaHour;
	}

	public int getApplyWholeHour() {
		return this.applyWholeHour;
	}

	public void setApplyWholeHour(int applyWholeHour) {
		this.applyWholeHour = applyWholeHour;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public int getRealDevHour() {
		return this.realDevHour;
	}

	public void setRealDevHour(int realDevHour) {
		this.realDevHour = realDevHour;
	}

	public int getRealQaHour() {
		return this.realQaHour;
	}

	public void setRealQaHour(int realQaHour) {
		this.realQaHour = realQaHour;
	}

	public int getRealWholeHour() {
		return this.realWholeHour;
	}

	public void setRealWholeHour(int realWholeHour) {
		this.realWholeHour = realWholeHour;
	}

	public String getRequestCode() {
		return this.requestCode;
	}

	public void setRequestCode(String requestCode) {
		this.requestCode = requestCode;
	}

	public String getRequestName() {
		return this.requestName;
	}

	public void setRequestName(String requestName) {
		this.requestName = requestName;
	}

	public WorkStateEntity getTbWorkState() {
		return this.tbWorkState;
	}

	public void setTbWorkState(WorkStateEntity tbWorkState) {
		this.tbWorkState = tbWorkState;
	}

	public ProcEntity getTbProc() {
		return this.tbProc;
	}

	public void setTbProc(ProcEntity tbProc) {
		this.tbProc = tbProc;
	}

	public EmployeeEntity getDev() {
		return dev;
	}

	public void setDev(EmployeeEntity dev) {
		this.dev = dev;
	}

	public EmployeeEntity getQa() {
		return qa;
	}

	public void setQa(EmployeeEntity qa) {
		this.qa = qa;
	}

	@Override
	public String toString() {
		return "WorkTimeEntity [workId=" + workId + ", applyDevHour=" + applyDevHour + ", applyQaHour=" + applyQaHour
				+ ", applyWholeHour=" + applyWholeHour + ", createTime=" + createTime + ", realDevHour=" + realDevHour
				+ ", realQaHour=" + realQaHour + ", realWholeHour=" + realWholeHour + ", requestCode=" + requestCode
				+ ", requestName=" + requestName + "]";
	}

	

}