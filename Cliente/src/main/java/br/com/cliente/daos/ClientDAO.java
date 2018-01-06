package br.com.cliente.daos;

import java.util.List;

import br.com.cliente.models.Client;

public class ClientDAO extends GeneralDAO<Client> {
	
	@Override
	public boolean save(Client user) {
		return super.save(user);
	}
	
	@Override
	public boolean update(Client user) {
		return super.update(user);

	}
	
	@Override
	public Client find(Class<?> classType, String elem) {
		return super.find(classType, elem);
	}
	
	@Override
	public boolean delete(Client user) {
		return super.delete(user);
	}
	
	@Override
	public List<Client> getAll(Class<?> classe, String from) {
		return super.getAll(classe, from);
	}
}
