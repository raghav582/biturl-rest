package com.biturl.persistence.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class JpaPersistenceServiceImpl implements PersistenceService{

	@PersistenceContext
	private EntityManager entityManager;
	
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
}
