package com.karthik.data.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@NamedQueries({@NamedQuery(name="Department.findAll", query="from Department"),
			   @NamedQuery(name="Department.findByName", query="select d from Department d where d.departmentName = :d_name")})
@Table(name = "DEPARTMENT", uniqueConstraints=@UniqueConstraint(name="uk_department_name", columnNames= {"DEPARTMENT_NAME"}))
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DEPARTMENT_ID")
	private Integer id;
	@Column(name = "DEPARTMENT_NAME")
	private String departmentName;
	@Column(name = "DEPARTMENT_DESC")
	private String description;

	public Department() {}
	
	public Department(String departmentName, String description) {
		this.departmentName = departmentName;
		this.description = description;
	}
	
	public Integer getDepartmentId() {
		return id;
	}

	public void setDepartmentId(Integer departmentId) {
		this.id = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
