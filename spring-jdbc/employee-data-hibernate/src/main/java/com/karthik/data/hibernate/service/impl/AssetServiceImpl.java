package com.karthik.data.hibernate.service.impl;

import java.util.List;

import com.karthik.data.hibernate.dao.AssetDao;
import com.karthik.data.hibernate.model.Asset;
import com.karthik.data.hibernate.service.AssetService;

public class AssetServiceImpl implements AssetService {

	private AssetDao assetDao;
	
	public AssetDao getAssetDao() {
		return assetDao;
	}

	public void setAssetDao(AssetDao assetDao) {
		this.assetDao = assetDao;
	}

	@Override
	public List<Asset> getAll() {
		return this.assetDao.getAll();
	}

	@Override
	public Asset get(Integer id) {
		return this.assetDao.get(id);
	}

	@Override
	public Integer add(Asset entity) {
		return (Integer) this.assetDao.add(entity);
	}

	@Override
	public void delete(Asset entity) {
		this.assetDao.delete(entity);
	}

	@Override
	public void update(Asset entity) {
		this.assetDao.update(entity);
	}

	@Override
	public void deleteById(Long id) {
		this.assetDao.deleteById(id);
	}

}
