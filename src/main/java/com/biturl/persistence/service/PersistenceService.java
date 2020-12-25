package com.biturl.persistence.service;

import java.util.Collection;
import java.util.List;

public interface PersistenceService {

	<T> T findById(Class<T> clazz, Object id);
	<T> List<T> findAll(Class<T> clazz);
	
	<T> T save(T o);
	<T> void save(T... o);
	<T> void save(Collection<T> c);
	
	<T> void update(T... o);
	<T> void update(Collection<T> c);
	
	<T> void delete(T... o);
	<T> void delete(Collection<T> c);
	
	<T> List<T> executeQuery(String query);
	
	void flushAndClear();
}
