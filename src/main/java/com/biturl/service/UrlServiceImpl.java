package com.biturl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biturl.adaptor.UrlAdaptor;
import com.biturl.model.UrlModel;
import com.biturl.persistence.entity.UrlEntity;
import com.biturl.persistence.service.PersistenceService;
import com.biturl.urlcode.UrlCode;

@Service
public class UrlServiceImpl implements UrlService{

	@Autowired private PersistenceService persistenceService;
	
	@Override
	public String addUrl(final UrlModel model) throws Exception{
		final UrlEntity entity = UrlAdaptor.toEntity(model);
		Long id = persistenceService.save(entity).getId();
		return UrlCode.idToCode(id);
	}
	
}
