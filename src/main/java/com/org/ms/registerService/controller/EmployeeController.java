package com.org.ms.registerService.controller;

import java.util.List;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/employees")
public class EmployeeController {
	private Logger logger = Logger.getLogger(EmployeeController.class);


	@RequestMapping(value = "uriinfo", method = RequestMethod.GET)
	public Response getEmployees(@Context UriInfo info) {
		String from = info.getQueryParameters().getFirst("from");
		String to = info.getQueryParameters().getFirst("to");
		List<String> orderBy = info.getQueryParameters().get("orderBy");
		logger.info("coming here >> ");
		return Response.status(200)
				.entity("getEmployees is called, from : " + from + ", to : " + to + ", orderBy" + orderBy.toString())
				.build();

	}
}
