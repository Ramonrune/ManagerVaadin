package br.com.cliente.views.client;


import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import br.com.cliente.models.Client;
import br.com.cliente.views.client.window.NewClientWindowPresenter;


public class SampleCrudView extends CssLayout implements View {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ClientDataProvider dataProvider = new ClientDataProvider();
	private NewClientWindowPresenter newClientWindowPresenter = new NewClientWindowPresenter(dataProvider);
    public static final String VIEW_NAME = "Clientes";
    private ClientGrid grid;
    private TextField filter;
    private Button newProduct;


    public SampleCrudView() {
        setSizeFull();
        addStyleName("crud-view");
        HorizontalLayout topLayout = createTopBar();

        grid = new ClientGrid();
        grid.setDataProvider(dataProvider);
        grid.addItemClickListener((event) ->{
        	Client model = event.getItem();
        	newClientWindowPresenter.setModel(model);
        	newClientWindowPresenter.show();
        });

        VerticalLayout barAndGridLayout = new VerticalLayout();
        barAndGridLayout.addComponent(topLayout);
        barAndGridLayout.addComponent(grid);
        barAndGridLayout.setSizeFull();
        barAndGridLayout.setExpandRatio(grid, 1);
        barAndGridLayout.setStyleName("crud-main-layout");

        addComponent(barAndGridLayout);

    }

    public HorizontalLayout createTopBar() {
        filter = new TextField();
        filter.setStyleName("filter-textfield");
        filter.setPlaceholder("Filtre pelo nomes dos clientes");
        // Apply the filter to grid's data provider. TextField value is never null

        newProduct = new Button("Novo Cliente");
        newProduct.addStyleName(ValoTheme.BUTTON_PRIMARY);
        newProduct.setIcon(VaadinIcons.PLUS_CIRCLE);
        newProduct.addClickListener((event) ->{
        	newClientWindowPresenter.show();
        });
        HorizontalLayout topLayout = new HorizontalLayout();
        topLayout.setWidth("100%");
        topLayout.addComponent(filter);
        topLayout.addComponent(newProduct);
        topLayout.setComponentAlignment(filter, Alignment.MIDDLE_LEFT);
        topLayout.setExpandRatio(filter, 1);
        topLayout.setStyleName("top-bar");
        return topLayout;
    }

    @Override
    public void enter(ViewChangeEvent event) {
    }

    public void showError(String msg) {
        Notification.show(msg, Type.ERROR_MESSAGE);
    }

    public void showSaveNotification(String msg) {
        Notification.show(msg, Type.TRAY_NOTIFICATION);
    }

    public void setNewProductEnabled(boolean enabled) {
        newProduct.setEnabled(enabled);
    }

    public void clearSelection() {
        grid.getSelectionModel().deselectAll();
    }

   

}
