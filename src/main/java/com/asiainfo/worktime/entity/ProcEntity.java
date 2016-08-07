package com.asiainfo.worktime.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TB_PROC database table.
 * 
 */
@Entity
@Table(name="TB_PROC")
//@NamedQuery(name="TbProc.findAll", query="SELECT t FROM TbProc t")
public class ProcEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PROC_ID")
	private int procId;

	@Column(name="PROC_NAME")
	private String procName;

	//bi-directional many-to-one association to TbRpocType
	@ManyToOne
	@JoinColumn(name="PROC_TYPE")
	private RpocTypeEntity tbRpocType;

	//bi-directional many-to-one association to TbWorkTime
	@OneToMany(mappedBy="tbProc")
	private List<WorkTimeEntity> tbWorkTimes;

	public ProcEntity() {
		this.tbRpocType = new RpocTypeEntity();
	}

	public int getProcId() {
		return this.procId;
	}

	public void setProcId(int procId) {
		this.procId = procId;
	}

	public String getProcName() {
		return this.procName;
	}

	public void setProcName(String procName) {
		this.procName = procName;
	}

	public RpocTypeEntity getTbRpocType() {
		return this.tbRpocType;
	}

	public void setTbRpocType(RpocTypeEntity tbRpocType) {
		this.tbRpocType = tbRpocType;
	}

	public List<WorkTimeEntity> getTbWorkTimes() {
		return this.tbWorkTimes;
	}

	public void setTbWorkTimes(List<WorkTimeEntity> tbWorkTimes) {
		this.tbWorkTimes = tbWorkTimes;
	}

	public WorkTimeEntity addTbWorkTime(WorkTimeEntity tbWorkTime) {
		getTbWorkTimes().add(tbWorkTime);
		tbWorkTime.setTbProc(this);

		return tbWorkTime;
	}

	public WorkTimeEntity removeTbWorkTime(WorkTimeEntity tbWorkTime) {
		getTbWorkTimes().remove(tbWorkTime);
		tbWorkTime.setTbProc(null);

		return tbWorkTime;
	}

}