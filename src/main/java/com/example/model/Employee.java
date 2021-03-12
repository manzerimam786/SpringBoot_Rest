package com.example.model;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Employee Model", value = "Employee Details")
public class Employee implements Serializable{

	@ApiModelProperty(notes = "ID of an Employee", dataType = "Integer", name = "id", value="test id", allowableValues = "Only Digit", required = true)
	int id;
	private static final long serialVersionUID = 1000000000L;
	@ApiModelProperty(notes = "Name of Student", dataType = "String", name = "name", value="test name")
	String name;
	@ApiModelProperty(notes = "Name of Student Department",name="deptname", value="test deptname")
	String deptname;
	@ApiModelProperty(notes = "Joining Date of Employee", dataType = "String", name = "joiningDate", value="test joining date")
	String joiningDate;
	
	public Employee() {
		super();
	}
	public Employee(String name, String deptname) {
		super();
		this.name = name;
		this.deptname = deptname;
	}
	
	public String getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deptname == null) ? 0 : deptname.hashCode());
		result = prime * result + id;
		result = prime * result + ((joiningDate == null) ? 0 : joiningDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (deptname == null) {
			if (other.deptname != null)
				return false;
		} else if (!deptname.equals(other.deptname))
			return false;
		if (id != other.id)
			return false;
		if (joiningDate == null) {
			if (other.joiningDate != null)
				return false;
		} else if (!joiningDate.equals(other.joiningDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", deptname=" + deptname + ", joiningDate=" + joiningDate
				+ "]";
	}
	
}
