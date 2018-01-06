package br.com.cliente.views;

import java.util.function.Supplier;

import com.vaadin.data.Binder;
import com.vaadin.ui.Component;
import com.vaadin.ui.Window;

public abstract class CustomWindow<E> extends Window{
	
	private static final long serialVersionUID = 1L;
	private Supplier<E> supplier;

	public CustomWindow(Supplier<E> supplier) {
		this.supplier = supplier;
		addStyleName("new-client-window");
		setClosable(true);
		setWidth("20%");
		setHeight("100%");
		setResizable(false);
		setModal(false);
		setDraggable(true);
		
		buildFields();
		buildValidators();
		setContent(buildLayout());
		
	}
	
	protected abstract void buildFields();
	protected abstract void buildValidators();
	protected abstract Component buildLayout();
	protected Binder<E> binder = new Binder<>();	
	protected E get() {
		return supplier.get();
	}

	
}
