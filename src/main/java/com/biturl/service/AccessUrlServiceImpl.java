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
		String entityId = "";
		for(int i=0; i<6; i++) {
			entityId = entityId + UrlCode.URL_CODE.indexOf(String.valueOf(urlCode.charAt(i)));
		}
		
		return persistenceService.findById(UrlEntity.class, Long.parseLong(entityId)).getUrl();
	}
}
