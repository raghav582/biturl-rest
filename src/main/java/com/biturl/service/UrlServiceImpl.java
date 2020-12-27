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
	public String addUrl(final UrlModel model) {
		final UrlEntity entity = UrlAdaptor.toEntity(model);
		Long id = persistenceService.save(entity).getId();
		return idToCode(id);
	}
	
	public String idToCode(final Long id) {
		String code = "";
		Integer entityId = id.intValue();
		for(int i=0; i<6; i++) {
			code = UrlCode.URL_CODE.get(entityId%62) + code;
			entityId = entityId/62;
		}
		
		return code;
	}
}
