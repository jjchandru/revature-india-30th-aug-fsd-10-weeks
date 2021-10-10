package com.revature.bankapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/logout")
public class LogoutController {
	private static final Logger LOGGER = LoggerFactory.getLogger(LogoutController.class);

	@GET
	public Response login(@Context HttpServletRequest request) {
		LOGGER.info("Start");
		request.getSession().invalidate();
		return Response.ok().build();
	}
}
