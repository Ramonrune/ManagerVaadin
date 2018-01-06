package br.com.cliente.views.client;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.stream.Collectors;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Grid;
import com.vaadin.ui.renderers.HtmlRenderer;
import com.vaadin.ui.renderers.NumberRenderer;

import br.com.cliente.models.Client;

/**
 * Grid of products, handling the visual presentation and filtering of a set of
 * items. This version uses an in-memory data source that is suitable for small
 * data sets.
 */
public class ClientGrid extends Grid<Client> {

    public ClientGrid() {
        setSizeFull();

        addColumn(Client::getId, new NumberRenderer()).setCaption("Id");
        addColumn(Client::getName).setCaption("Product Name");

    }

 
}
