package com.biturl.adaptor;

import com.biturl.model.ContactModel;
import com.biturl.persistence.entity.ContactEntity;

public class ContactAdaptor {

	public static ContactModel toModel(ContactEntity entity) {
		final ContactModel model = new ContactModel();
		model.setId(entity.getId().intValue());
		model.setFullName(entity.getFullName());
		model.setEmail(entity.getEmail());
		model.setPhone(entity.getPhone());
		model.setComments(entity.getComments());
		model.setStatus(entity.getStatus());
		
		return model;
	}
	
	public static ContactEntity toEntity(ContactModel model) {
		final ContactEntity entity = new ContactEntity();
		entity.setFullName(model.getFullName());
		entity.setEmail(model.getEmail());
		entity.setPhone(model.getPhone());
		entity.setComments(model.getComments());
		entity.setStatus(true);
		
		return entity;
	}
}
