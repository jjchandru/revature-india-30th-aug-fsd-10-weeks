
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.revature.bankapp.dao.CustomerDao;
import com.revature.bankapp.dao.impl.CustomerDaoImpl;
import com.revature.bankapp.model.Customer;

class CustomerDaoImplTest {

	@Test
	void testCreate_Success() {
		Customer customer = new Customer("Maria", "John", "maria@gmail.co", "pass");
		CustomerDao dao = new CustomerDaoImpl();
		try {
			dao.create(customer);
		} catch (SQLException e) {
			e.printStackTrace();
			fail("Creating employee failed.");
		}
		
	}

}
