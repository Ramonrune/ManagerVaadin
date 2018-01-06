package br.com.cliente.views.client.window;

import com.vaadin.ui.Window;

public class NewClientWindow extends Window {

	
	public NewClientWindow() {
		addStyleName("new-client-window");
		setClosable(true);
		setWidth("20%");
		setHeight("100%");
		setResizable(false);
		setModal(false);
		setDraggable(true);
		
		
	}
}
