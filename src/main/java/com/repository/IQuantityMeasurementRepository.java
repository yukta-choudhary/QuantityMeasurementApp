package com.repository;

import com.entity.QuantityMeasurementEntity;

public interface IQuantityMeasurementRepository {

	void save(String key, QuantityMeasurementEntity entity);

	QuantityMeasurementEntity find(String key);
}