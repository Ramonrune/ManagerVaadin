package br.com.cliente.views.client.window;

import br.com.cliente.daos.ClientDAO;
import br.com.cliente.models.Client;

public class NewClientWindowListener{

	private Client client;
	
	public NewClientWindowListener(Client client) {
		this.client = client;
	}
	

	public boolean save() {
		ClientDAO dao = new ClientDAO();
		return dao.save(client);
	}

}
