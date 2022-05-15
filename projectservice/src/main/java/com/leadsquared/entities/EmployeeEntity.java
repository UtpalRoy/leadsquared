package com.leadsquared.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class EmployeeEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="emp_name")
	private String empName;
	
	@Column(name="emp_code")
	private String empCode;
	
	@Column(name="age")
	private Integer age;
	
	@OneToMany
	@JoinColumn(name="depart_code")
	private List<DepartmentEntity> departmentEntities;
	
	@OneToMany
	@JoinColumn(name="proj_code")
	private List<ProjectEntity> projectEntities;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<DepartmentEntity> getDepartmentEntities() {
		return departmentEntities;
	}

	public void setDepartmentEntities(List<DepartmentEntity> departmentEntities) {
		this.departmentEntities = departmentEntities;
	}

}
