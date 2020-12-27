package com.biturl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biturl.service.AccessUrlService;

@Controller
@RequestMapping("")
public class AccessUrlController {

	@Autowired private AccessUrlService accessUrlService;
	
	@RequestMapping(value = "/{urlCode}",
			method = RequestMethod.GET)
	@ResponseBody
	public String getUrl(@PathVariable("urlCode") final String urlCode) {
		return accessUrlService.getUrl(urlCode);
	}
}
