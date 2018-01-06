package br.com.cliente.views.client;

import java.util.Locale;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Stream;

import com.vaadin.data.provider.AbstractDataProvider;
import com.vaadin.data.provider.Query;

import br.com.cliente.daos.ClientDAO;
import br.com.cliente.models.Client;

public class ClientDataProvider extends AbstractDataProvider<Client, String> {


	@Override
	public Integer getId(Client client) {
		Objects.requireNonNull(client, "Não é possível fornecer um id de um objeto nulo");

		return client.getId();
	}

	@Override
	public boolean isInMemory() {
		return true;
	}

	@Override
	public int size(Query<Client, String> t) {
		return (int) fetch(t).count();
	}

	@Override
	public Stream<Client> fetch(Query<Client, String> query) {
		ClientDAO dao = new ClientDAO();

		return dao.getAll(Client.class, "Client").stream();

	}

}
