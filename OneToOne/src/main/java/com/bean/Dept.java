package com.bean;

import java.util.Collection;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;

public class Dept {

	private int did;
	private String dname;
	private Collection<Emp> emp;
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "did")
	public Collection<Emp> getEmp() {
		return emp;
	}
	public void setEmp(Collection<Emp> emp) {
		this.emp = emp;
	}
	
	
}
