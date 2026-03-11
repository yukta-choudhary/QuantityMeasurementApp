package com.repository;

import com.entity.QuantityMeasurementEntity;
import java.util.HashMap;
import java.util.Map;
import com.entity.QuantityMeasurementEntity;

public class QuantityMeasurementCacheRepository implements IQuantityMeasurementRepository {

	private final Map<String, QuantityMeasurementEntity> cache = new HashMap<>();

	@Override
	public void save(String key, QuantityMeasurementEntity entity) {
		cache.put(key, entity);
	}

	@Override
	public QuantityMeasurementEntity find(String key) {
		return cache.get(key);
	}
}