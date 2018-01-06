package br.com.client.daos;

import org.junit.Test;

import br.com.cliente.daos.UserDAO;
import br.com.cliente.models.User;
import junit.framework.Assert;
import junit.framework.TestCase;

public class UserTest extends TestCase {

	
	@Test
	public void testMethod() {
		
		User user = new User();
		user.setLogin("admin");
		user.setFullName("Ramon Lacava Gutierrez Gonçales");
		user.setPassword("admin");
		
		UserDAO userDAO = new UserDAO();
		Assert.assertEquals(userDAO.save(user), true);
		
		Assert.assertEquals(userDAO.userExist(user), true);

		
	}
	
	
	
}

