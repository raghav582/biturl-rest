package com.biturl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biturl.persistence.entity.UrlEntity;
import com.biturl.persistence.service.PersistenceService;
import com.biturl.urlcode.UrlCode;

@Service
public class RedirectServiceImpl implements RedirectService{

	@Autowired PersistenceService persistenceService;
	
	@Override
	public String getUrl(final String code) {
		final Long id = UrlCode.codeToId(code);
		final String url = persistenceService.findById(UrlEntity.class, id).getUrl();
		
		return url;
	}
}
