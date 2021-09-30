package com.revature.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankapp.dao.CustomerDao;
import com.revature.bankapp.dao.Util;
import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Customer;

public class CustomerDaoImpl implements CustomerDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerDaoImpl.class);

	@Override
	public int create(Customer customer) throws AppException {
		LOGGER.info("Start");
		LOGGER.debug("{}", customer);
		try (Connection connection = Util.getConnection()) {
			String sql = "insert into customer (first_name, last_name, email, password) values (?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, customer.getFirstName());
			statement.setString(2, customer.getLastName());
			statement.setString(3, customer.getEmail());
			statement.setString(4, customer.getPassword());
			LOGGER.debug("Parameter binding done.");
			statement.executeUpdate();
			LOGGER.debug("Query executed successfully.");
			
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				return rs.getInt(1);
			}
			LOGGER.info("End");
			return 0;
		} catch (SQLException e) {
			LOGGER.error("Error inserting customer", e);
			throw new AppException(e);
		}
	}

}
