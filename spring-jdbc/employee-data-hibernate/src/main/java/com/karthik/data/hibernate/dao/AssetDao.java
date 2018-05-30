package com.karthik.data.hibernate.dao;

import java.util.List;

import com.karthik.data.hibernate.model.Asset;

public interface AssetDao extends GenericDao<Asset, Long> {

	List<Asset> findAll();
}
