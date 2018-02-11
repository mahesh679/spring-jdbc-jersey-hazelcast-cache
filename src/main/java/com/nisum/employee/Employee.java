package com.nisum.employee;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee implements Serializable{
	private int eid;
	private String ename;
	private float esal;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public float getEsal() {
		return esal;
	}
	public void setEsal(float esal) {
		this.esal = esal;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
		System.out.println("==================Default Constructor=======================");
	}
	public Employee(int eid, String ename, float esal) {
		this.eid = eid;
		this.ename = ename;
		this.esal = esal;
	}
	public Employee(int eid) {
		this.eid = eid;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", esal=" + esal + "]";
	}
}
