package com.revature.bankapp.dao;

import java.util.List;

import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Account;

public interface AccountDao {
	
	List<Account> getCustomerAccounts(long customerId) throws AppException;

}
