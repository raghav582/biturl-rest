package com.biturl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.biturl.model.ContactModel;
import com.biturl.model.ModelResponse;
import com.biturl.service.ContactService;

@Controller
@RequestMapping("v1/contact")
public class ContactController {

	@Autowired private ContactService contactService;
	
	@RequestMapping(value = "/add-contact",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ModelResponse addContact(@RequestBody final ContactModel model) {
		contactService.addContact(model);
		return ModelResponse.ok();
	}
}
