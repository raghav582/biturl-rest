package com.biturl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biturl.adaptor.ContactAdaptor;
import com.biturl.model.ContactModel;
import com.biturl.persistence.service.PersistenceService;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired private PersistenceService persistenceService;
	
	@Override
	public void addContact(final ContactModel model) {
		persistenceService.save(ContactAdaptor.toEntity(model));
	}
}
