package com.biturl.adaptor;

import com.biturl.model.UrlModel;
import com.biturl.persistence.entity.UrlEntity;

public class UrlAdaptor {

	public static UrlEntity toEntity(UrlModel model) {
		final UrlEntity entity = new UrlEntity();
		entity.setUrl(model.getUrl());
		
		return entity;
	}
	
	public static UrlModel toModel(UrlEntity entity) {
		final UrlModel model = new UrlModel();
		model.setId(entity.getId().intValue());
		model.setUrl(entity.getUrl());
		
		return model;
	}
}
