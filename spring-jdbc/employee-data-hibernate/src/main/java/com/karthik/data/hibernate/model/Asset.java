package com.karthik.data.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({@NamedQuery(name="Asset.findAll", query="from Asset")})
@Table(name="ASSETS")
public class Asset {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ASSET_ID")
	private Long id;
	@Column(name="ASSET_TYPE")
	private String assetType;
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Employee employee;

	public Asset() {
		this.assetType = "Laptop";
	}
	
	public Asset(String assetType) {
		this.assetType = assetType;
	}
	
	public long getAssetId() {
		return id;
	}

	public void setAssetId(Long assetId) {
		this.id = assetId;
	}

	public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Asset [assetId=" + id + ", assetType=" + assetType + ", employee=" + employee + "]";
	}
}
