package com.asiainfo.worktime.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TB_WORK_STATE database table.
 * 
 */
@Entity
@Table(name="TB_WORK_STATE")
//@NamedQuery(name="TbWorkState.findAll", query="SELECT t FROM TbWorkState t")
public class WorkStateEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="WORK_STATE_CODE")
	private String workStateCode;

	@Column(name="WORK_STATE_NAME")
	private String workStateName;

	//bi-directional many-to-one association to TbWorkTime
	@OneToMany(mappedBy="tbWorkState")
	private List<WorkTimeEntity> tbWorkTimes;

	public WorkStateEntity() {
	}

	public String getWorkStateCode() {
		return this.workStateCode;
	}

	public void setWorkStateCode(String workStateCode) {
		this.workStateCode = workStateCode;
	}

	public String getWorkStateName() {
		return this.workStateName;
	}

	public void setWorkStateName(String workStateName) {
		this.workStateName = workStateName;
	}

	public List<WorkTimeEntity> getTbWorkTimes() {
		return this.tbWorkTimes;
	}

	public void setTbWorkTimes(List<WorkTimeEntity> tbWorkTimes) {
		this.tbWorkTimes = tbWorkTimes;
	}

	public WorkTimeEntity addTbWorkTime(WorkTimeEntity tbWorkTime) {
		getTbWorkTimes().add(tbWorkTime);
		tbWorkTime.setTbWorkState(this);

		return tbWorkTime;
	}

	public WorkTimeEntity removeTbWorkTime(WorkTimeEntity tbWorkTime) {
		getTbWorkTimes().remove(tbWorkTime);
		tbWorkTime.setTbWorkState(null);

		return tbWorkTime;
	}

}