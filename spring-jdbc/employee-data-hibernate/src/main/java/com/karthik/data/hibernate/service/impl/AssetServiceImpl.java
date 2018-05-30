package com.karthik.data.hibernate.service.impl;

import java.util.List;
import java.util.Objects;

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
	public Asset get(Long id) {
		return this.assetDao.read(id);
	}

	@Override
	public Asset add(Asset entity) {
		return this.assetDao.create(entity);
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
		Asset asset = this.assetDao.read(id);
		if (!Objects.isNull(asset)) {
			this.assetDao.delete(asset);
		}
	}

	@Override
	public List<Asset> getAll() {
		return this.assetDao.findAll();
	}

}
