package com.asiainfo.worktime.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TB_RPOC_TYPE database table.
 * 
 */
@Entity
@Table(name="TB_RPOC_TYPE")
//@NamedQuery(name="TbRpocType.findAll", query="SELECT t FROM TbRpocType t")
public class RpocTypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PROC_TYPE")
	private String procType;

	@Column(name="PROC_NAME")
	private String procName;

	//bi-directional many-to-one association to TbProc
	@OneToMany(mappedBy="tbRpocType")
	private List<ProcEntity> tbProcs;

	public RpocTypeEntity() {
	}

	public String getProcType() {
		return this.procType;
	}

	public void setProcType(String procType) {
		this.procType = procType;
	}

	public String getProcName() {
		return this.procName;
	}

	public void setProcName(String procName) {
		this.procName = procName;
	}

	public List<ProcEntity> getTbProcs() {
		return this.tbProcs;
	}

	public void setTbProcs(List<ProcEntity> tbProcs) {
		this.tbProcs = tbProcs;
	}

	public ProcEntity addTbProc(ProcEntity tbProc) {
		getTbProcs().add(tbProc);
		tbProc.setTbRpocType(this);

		return tbProc;
	}

	public ProcEntity removeTbProc(ProcEntity tbProc) {
		getTbProcs().remove(tbProc);
		tbProc.setTbRpocType(null);

		return tbProc;
	}

}