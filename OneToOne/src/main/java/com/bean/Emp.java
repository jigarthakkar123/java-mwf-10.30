package com.bean;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Emp {

	private int eid;
	private String fname,lname;
	private Dept did;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "did")
	public Dept getDid() {
		return did;
	}
	public void setDid(Dept did) {
		this.did = did;
	}
	
	
}
