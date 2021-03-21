package com.biturl.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.condition.ConsumesRequestCondition;

import com.biturl.model.UrlModel;
import com.biturl.service.UrlService;

@Controller
@RequestMapping("v1/url")
public class UrlController {

	@Autowired private UrlService urlService;
	private static final Logger LOGGER = LogManager.getLogger(UrlController.class);
	
	@RequestMapping(value = "/add-url",
			method = RequestMethod.POST)
	@ResponseBody
	public String addUrl(@RequestBody final UrlModel model) {
		try{
			return urlService.addUrl(model);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return "";
		}
	}
}
