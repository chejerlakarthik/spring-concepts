package com.karthik.data.hibernate.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.karthik.data.hibernate.dao.AssetDao;
import com.karthik.data.hibernate.model.Asset;

@Transactional
public class AssetDaoImpl extends GenericDaoImpl<Asset,Long> implements AssetDao {

	public AssetDaoImpl(Class<Asset> persistentClass) {
		super(persistentClass);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Asset> findAll() {
		Query query = getSession().getNamedQuery("Asset.findAll");
		List<Asset> assets = query.getResultList();
		return assets;
	}

}
