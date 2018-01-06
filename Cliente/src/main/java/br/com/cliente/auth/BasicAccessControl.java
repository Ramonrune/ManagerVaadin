package br.com.cliente.auth;

import br.com.cliente.daos.UserDAO;
import br.com.cliente.models.User;

public class BasicAccessControl implements AccessControl {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean signIn(String username, String password) {
		if (username == null || username.isEmpty())
			return false;
		if (password == null || password.isEmpty())
			return false;

		System.out.println(username + " " + password);
		UserDAO userDAO = new UserDAO();
		User user = new User();
		user.setLogin(username);
		user.setPassword(password);
		System.out.println(user.getPassword());
		if(userDAO.userExist(user)) {
			CurrentUser.set(username);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean isUserSignedIn() {
		return !CurrentUser.get().isEmpty();
	}

	@Override
	public String getFullName() {
		return CurrentUser.get();
	}

}
