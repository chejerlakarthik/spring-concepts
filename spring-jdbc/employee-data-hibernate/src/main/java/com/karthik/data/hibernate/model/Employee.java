package com.karthik.data.hibernate.model;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@NamedQueries({ @NamedQuery(name = "Employee.findAll", query = "from Employee"),
				@NamedQuery(name = "Employee.findById", query = "from Employee e where e.id = :e_id"),
				@NamedQuery(name = "Employee.findByName", query = "from Employee e where e.employeeName = :e_name"),
				@NamedQuery(name = "Employee.findBySalaryGreaterThanInDepartment", query = "from Employee e, Department d where e.salary > :e_salary and d.departmentName = :d_name")})
@Table(name = "EMPLOYEE", uniqueConstraints={@UniqueConstraint(name = "uk_cubicle", columnNames = { "CUBICLE_ID" })})
public class Employee {

	@Id
	@Column(name="EMP_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="EMP_NAME")
	private String employeeName;
	
	@Enumerated(EnumType.STRING)
	@Column(name="EMP_EMPLOYER")
	private Employer employer;
	
	@ManyToOne
	@JoinColumn(name = "DEPARTMENT_ID")
	private Department department;
	
	private Double salary;
	
	@Column(name="CUBICLE_ID")
	private Long cubicle;
	
	@OneToMany(mappedBy="employee", cascade=CascadeType.ALL)
	private Collection<Asset> assets = new HashSet<Asset>();
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_MODIFIED")
	private Date lastModified;

	public Employee() {}

	public Employee(Integer employeeId, String employeeName, Employer employer) {
		this.id = employeeId;
		this.employeeName = employeeName;
		this.employer = employer;
	}

	public Integer getEmployeeId() {
		return id;
	}

	public void setEmployeeId(Integer employeeId) {
		this.id = employeeId;
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
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + id + ", employeeName=" + employeeName + ", employer=" + employer
				+ ", department=" + department + ", salary=" + salary + ", cubicle=" + cubicle + "]";
	}

}
