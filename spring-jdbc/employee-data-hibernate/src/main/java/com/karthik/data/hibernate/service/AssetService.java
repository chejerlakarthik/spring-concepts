package com.karthik.data.hibernate.service;

import org.springframework.transaction.annotation.Transactional;

import com.karthik.data.hibernate.model.Asset;

@Transactional
public interface AssetService extends ApplicationService<Asset> {

}
