package com.biturl.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.biturl.model.UrlModel;
import com.biturl.service.RedirectService;

@Controller
@RequestMapping("v2")
public class RedirectController {

	@Autowired private RedirectService redirectService;
	
	@RequestMapping(value = "/{code}",
			method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView addUrl(@PathVariable("code") final String code, HttpServletResponse response) {
		try{
			return new ModelAndView("redirect:" + redirectService.getUrl(code)); 
		} catch (Exception e) {
			System.err.println(e);
			return new ModelAndView("redurect:");
		}
	}
}
