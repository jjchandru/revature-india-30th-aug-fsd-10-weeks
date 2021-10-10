package com.revature.bankapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankapp.dao.AccountDao;
import com.revature.bankapp.dao.impl.AccountDaoImpl;
import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Customer;

@Path("/accounts")
public class AccountController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);
	private AccountDao dao = new AccountDaoImpl();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAccounts(@Context HttpServletRequest request) {
		LOGGER.info("Start");
		Customer customer = (Customer) request.getSession().getAttribute("customer");
		LOGGER.debug("{}", customer);
		try {
			List<Account> accountList = dao.getCustomerAccounts(customer.getId());
			LOGGER.info("End");
			return Response.ok().entity(accountList).build();
		} catch (AppException e) {
			return Response.status(500).build();
		}
	}
}
