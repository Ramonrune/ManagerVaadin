package br.com.cliente.views.client;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.stream.Collectors;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Grid;
import com.vaadin.ui.renderers.HtmlRenderer;
import com.vaadin.ui.renderers.NumberRenderer;

import br.com.cliente.models.Client;

public class ClientGrid extends Grid<Client> {
	
    public ClientGrid() {
        setSizeFull();

        addColumn(Client::getId, new NumberRenderer()).setCaption("Id");
        addColumn(Client::getName).setCaption("Nome");
        addColumn(Client::getEmail).setCaption("E-mail");
        addColumn(Client::getTelephone).setCaption("Telefone");

       
    }
    
    public Client getSelectedRow() {
        return asSingleSelect().getValue();
    }

    public void refresh(Client client) {
        getDataCommunicator().refresh(client);
    }

    		

 
}
