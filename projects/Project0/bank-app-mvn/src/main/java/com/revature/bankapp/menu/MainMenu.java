package com.revature.bankapp.menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.bankapp.dao.CustomerDao;
import com.revature.bankapp.dao.impl.CustomerDaoImpl;
import com.revature.bankapp.form.LoginForm;
import com.revature.bankapp.model.Customer;

public class MainMenu extends Menu {

	public MainMenu(String name) {
		super(name);
		addMenuItem("Register new Customer");
		addMenuItem("Login as Customer");
		addMenuItem("Login as Employee");
		addMenuItem("Exit");
	}

	@Override
	void handleAction() {
		Scanner scanner = new Scanner(System.in);
		switch (selection) {
		case 1:
			System.out.println("\n===");
			System.out.println("Register new customer");
			System.out.println("====\n");
			
			System.out.print("First Name: ");
			String firstName = scanner.nextLine();
			
			System.out.print("Last Name: ");
			String lastName = scanner.nextLine();

			System.out.print("Email: ");
			String email = scanner.nextLine();

			System.out.print("Password: ");
			String password = scanner.nextLine();
			
			//DataManager.addCustomer(new Customer(firstName, lastName, email, password));
			CustomerDao dao = new CustomerDaoImpl();
			try {
				dao.create(new Customer(firstName, lastName, email, password));
			} catch (SQLException e) {
				System.out.println("Unable to create customer.");
			}
			System.out.println("Customer added successfully.");
			displayMenuAndCaptureSelection();
			break;
		case 2:
			LoginForm loginForm = new LoginForm("Login Form");
			loginForm.captureDataAndPerformAction();
			break;
		}
	}
}
