package com.revature.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.revature.springlearn.controller.DepartmentController;
import com.revature.springlearn.service.DepartmentService;

@SpringBootApplication
//@ImportResource("classpath:app-config.xml")
public class Application {
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		/*ApplicationContext context = SpringApplication.run(Application.class, args);
		DepartmentController controller = context.getBean("departmentController", DepartmentController.class);
		DepartmentService service = context.getBean("departmentService", DepartmentService.class);
		LOGGER.debug("Department Controller: {}", controller);
		LOGGER.debug("Department Service: {}", controller.getDepartmentService());
		DepartmentController controller1 = context.getBean("departmentController", DepartmentController.class);*/
		//LOGGER.debug("Department Controller: {}", controller);
	}

}
