package com.biturl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biturl.persistence.entity.UrlEntity;
import com.biturl.persistence.service.PersistenceService;
import com.biturl.urlcode.UrlCode;

@Service
public class AccessUrlServiceImpl implements AccessUrlService{

	@Autowired PersistenceService persistenceService;
	
	public String getUrl(String urlCode) {
		Long entityId = UrlCode.codeToId(urlCode);
		return persistenceService.findById(UrlEntity.class, entityId).getUrl();
	}
}
