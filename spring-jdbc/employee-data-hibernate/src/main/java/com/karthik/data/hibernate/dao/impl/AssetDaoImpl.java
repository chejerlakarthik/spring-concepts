package com.karthik.data.hibernate.dao.impl;

import org.springframework.transaction.annotation.Transactional;

import com.karthik.data.hibernate.dao.AssetDao;
import com.karthik.data.hibernate.model.Asset;

@Transactional
public class AssetDaoImpl extends GenericDaoImpl<Asset,Long> implements AssetDao {

	public AssetDaoImpl() {
		super(Asset.class);
	}

}
