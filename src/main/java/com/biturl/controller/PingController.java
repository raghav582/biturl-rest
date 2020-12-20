package com.biturl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/ping")
public class PingController {

	@RequestMapping(value = "",
			method = RequestMethod.GET)
	public String ping() {
		return "Successful";
	}
}
