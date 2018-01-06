package br.com.cliente.views.client.window;

import br.com.cliente.models.Client;

interface NewClientWindowCrud {

	interface NewClientWindowCrudListener{
		boolean save(Client client);
		boolean update(Client client);
	}
	
	public void addListener(NewClientWindowCrudListener listener);

}
