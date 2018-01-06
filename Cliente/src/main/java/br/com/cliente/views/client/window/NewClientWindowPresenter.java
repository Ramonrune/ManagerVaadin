package br.com.cliente.views.client.window;

import br.com.cliente.conf.MyUI;
import br.com.cliente.daos.ClientDAO;
import br.com.cliente.models.Client;
import br.com.cliente.views.client.ClientDataProvider;
import br.com.cliente.views.client.window.NewClientWindowCrud.NewClientWindowCrudListener;

public class NewClientWindowPresenter implements NewClientWindowCrudListener {

	private NewClientWindow view = new NewClientWindow();
	private ClientDataProvider clientDataProvider;
	
	public NewClientWindowPresenter(ClientDataProvider clientDataProvider) {
		view.addListener(this);
		this.clientDataProvider = clientDataProvider;
	}	
	
	public void show() {
    	MyUI.get().addWindow(view);
	}
	
	public void setModel(Client client) {
		view.setModel(client);
	}

	@Override
	public boolean save(Client client) {
		if(client == null) {
			throw new IllegalStateException("Cliente não foi informado");
		}
		ClientDAO dao = new ClientDAO();
		clientDataProvider.refreshAll();
		return dao.save(client);
		
	}

	@Override
	public boolean update(Client client) {
		
		if(client == null) {
			throw new IllegalStateException("Cliente não foi informado");
		}
		ClientDAO dao = new ClientDAO();
		clientDataProvider.refreshAll();
		
		return dao.update(client);
	}
	
	
}
