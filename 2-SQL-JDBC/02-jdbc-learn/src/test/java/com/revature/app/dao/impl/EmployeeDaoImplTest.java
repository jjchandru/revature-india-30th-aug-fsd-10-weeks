package com.revature.app.dao.impl;

//import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.revature.app.dao.EmployeeDao;
import com.revature.app.model.Department;
import com.revature.app.model.Employee;

class EmployeeDaoImplTest {

	@Test
	void testList_Success() {
		EmployeeDao dao = new EmployeeDaoImpl();
		try {
			assertTrue(dao.list().size() > 0, "");
		} catch (SQLException e) {
			e.printStackTrace();
			fail("Getting employee list failed.");
		}
	}
	
	@Test
	void testGet_Success() {
		EmployeeDao dao = new EmployeeDaoImpl();
		try {
			Employee employee = dao.get(1);
			assertEquals(1, employee.getId(), "Incorrect user returned.");
		} catch (SQLException e) {
			e.printStackTrace();
			fail("Getting employee list failed.");
		}
	}
	
	@Test
	void testCreate_Success() {
		Employee employee = new Employee();
		employee.setName("Maria");
		employee.setSalary(1500);
		employee.setGender('F');
		Department department = new Department();
		department.setId(1);
		employee.setDepartment(department);
		EmployeeDao dao = new EmployeeDaoImpl();
		try {
			dao.create(employee);
		} catch (SQLException e) {
			e.printStackTrace();
			fail("Creating employee failed.");
		}
		
	}

	@Test
	void testUpdate_Success() {
		EmployeeDao dao = new EmployeeDaoImpl();
		try {
			Employee employee = dao.get(1);
			double currentSalary = employee.getSalary();
			currentSalary++;
			employee.setSalary(currentSalary);
			dao.update(employee);
			employee = dao.get(1);
			assertEquals(currentSalary, employee.getSalary());
		} catch (SQLException e) {
			e.printStackTrace();
			fail("Update employee failed.");
		}
	}
	
	@Test
	void testDelete_Success() {
		EmployeeDao dao = new EmployeeDaoImpl();
		try {
			Employee employee = new Employee();
			employee.setName("Maria");
			employee.setSalary(1500);
			employee.setGender('F');
			Department department = new Department();
			department.setId(1);
			employee.setDepartment(department);
			int id = dao.create(employee);
			System.out.println(id);
			dao.delete(id);
			assertNull(dao.get(id));
		} catch (SQLException e) {
			e.printStackTrace();
			fail("Delete employee failed.");
		}
	}

}
