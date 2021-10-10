package com.revature.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankapp.dao.AccountDao;
import com.revature.bankapp.dao.Util;
import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Customer;

public class AccountDaoImpl implements AccountDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountDaoImpl.class);

	@Override
	public List<Account> getCustomerAccounts(long customerId) throws AppException {
		LOGGER.info("Start");
		LOGGER.debug("CustomerId: {}", customerId);
		List<Account> accountList = new ArrayList<>();
		try (Connection connection = Util.getConnection()) {
			String sql = "select * from account where customer_id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, customerId);
			ResultSet rs = statement.executeQuery();
			LOGGER.debug("Query executed successfully.");
			while (rs.next()) {
				Account account = new Account();
				account.setId(rs.getInt("id"));
				account.setAccountNumber(rs.getString("account_number"));
				account.setBalance(rs.getDouble("balance"));
				accountList.add(account);
			}
			
			LOGGER.info("End");
		} catch (SQLException e) {
			LOGGER.error("Error inserting customer", e);
			throw new AppException(e);
		}
		return accountList;
	}

}
