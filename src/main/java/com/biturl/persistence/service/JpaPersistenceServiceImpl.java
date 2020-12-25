package com.biturl.persistence.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class JpaPersistenceServiceImpl implements PersistenceService{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public <T> T findById(Class<T> clazz, Object id){
		return entityManager.find(clazz, id);
	}
	
	@Override
	@Transactional
	public <T> List<T> findAll(Class<T> clazz){
		Query query = entityManager.createNativeQuery("SELECT * FROM clazz");
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public <T> void save(final T... entities) {
		try {
			for(T entity:entities) {
				entityManager.persist(entity);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	@Transactional
	public <T> void save(final Collection<T> entities) {
		try {
			for(T entity:entities) {
				entityManager.persist(entity);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	@Transactional
	public <T> void update(final T... entities) {
		try {
			for(T entity:entities) {
				entityManager.refresh(entity);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	@Transactional
	public <T> void update(final Collection<T> entities) {
		try {
			for(T entity:entities) {
				entityManager.refresh(entity);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	@Transactional
	public <T> void delete(final T... entities) {
		try {
			for(T entity:entities) {
				entityManager.remove(entity);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	@Transactional
	public <T> void delete(final Collection<T> entities) {
		try {
			for(T entity:entities) {
				entityManager.remove(entity);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public <T> List<T> executeQuery(String query) {
		Query q = entityManager.createNativeQuery(query);
		return q.getResultList();
	}
	
	public void flushAndClear() {
		entityManager.flush();
		entityManager.clear();
	}
}
