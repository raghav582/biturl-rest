package com.biturl.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.biturl.service.RedirectService;

@Controller
@RequestMapping("")
public class RedirectController {

	@Autowired private RedirectService redirectService;
	private static final Logger LOGGER = LogManager.getLogger(RedirectController.class);
	private static final String HOME_URL = "http://biturl.github.io/";
	
	@RequestMapping(value = "/{code}",
			method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView addUrl(@PathVariable("code") final String code, HttpServletResponse response) {
		try{
			return new ModelAndView("redirect:" + redirectService.getUrl(code)); 
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return new ModelAndView("redirect:" + HOME_URL);
		}
	}
}
