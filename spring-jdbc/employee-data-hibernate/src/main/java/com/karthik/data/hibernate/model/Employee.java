package com.karthik.data.hibernate.model;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "EMPLOYEE", uniqueConstraints={@UniqueConstraint(name = "uk_cubicle", columnNames = { "CUBICLE_ID" })})
public class Employee {

	@Id
	@Column(name="EMP_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer employeeId;
	
	@Column(name="EMP_NAME")
	private String employeeName;
	
	@Enumerated(EnumType.STRING)
	@Column(name="EMP_EMPLOYER")
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name = "DEPARTMENT_ID")
	private Department department;
	
	private Double salary;
	
	@Column(name="CUBICLE_ID")
	private Long cubicle;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="EMPLOYEE_ASSETS",
			   joinColumns=@JoinColumn(name="EMP_ID"),
			   inverseJoinColumns=@JoinColumn(name="ASSET_ID"))
	private Collection<Asset> assets = new HashSet<Asset>();

	public Employee() {}

	public Employee(Integer employeeId, String employeeName, Employer employer) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employer = employer;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Long getCubicle() {
		return cubicle;
	}

	public void setCubicle(Long cubicle) {
		this.cubicle = cubicle;
	}

	
	public Collection<Asset> getAssets() {
		return assets;
	}

	public void setAssets(Collection<Asset> assets) {
		this.assets = assets;
	}

	public void assignAssetToEmployee(Asset asset) {
		this.assets.add(asset);
		asset.setEmployee(this);
	}
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employer=" + employer
				+ ", department=" + department + ", salary=" + salary + ", cubicle=" + cubicle + "]";
	}

}
