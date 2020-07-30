package com.cg.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="department_tbl1")
public class Department {
	
	@Id
	@GeneratedValue(generator="seq",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq",sequenceName="department_seq1",allocationSize=1)
	@Column(name="deptid")
	private int departmentId;
	
	@Column(name="dname")
	private String departmentName;
	
	@OneToMany(mappedBy="department",cascade = CascadeType.REMOVE)
	private List<Employee> Employee = new ArrayList<Employee>();

	public Department(int departmentId, String departmentName, List<Employee> employee) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		Employee = employee;
	}

	public Department() {
		super();
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<Employee> getEmployee() {
		return Employee;
	}

	public void setEmployee(List<Employee> employee) {
		Employee = employee;
	}
	
	
	
}
