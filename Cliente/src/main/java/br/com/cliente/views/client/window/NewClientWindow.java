package br.com.cliente.views.client.window;


import com.vaadin.data.ValidationException;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import br.com.cliente.models.Client;
import br.com.cliente.views.CustomWindow;

class NewClientWindow extends CustomWindow<Client> implements NewClientWindowCrud{

	private static final long serialVersionUID = 1L;
	private NewClientWindowCrud.NewClientWindowCrudListener listener;
	private Client client = get();
	private TextField nameTxtField;
	private TextField emailTxtField;
	private TextField telephoneTxtField;
	private Button cancelButton;
	private Button addButton;

	NewClientWindow() {
		super(Client::new);
		addCloseListener((event) -> {
			nameTxtField.setValue("");
			emailTxtField.setValue("");
			telephoneTxtField.setValue("");
			windowMode = WINDOW_MODE.NEW_CLIENT;
			nameTxtField.setComponentError(null);
			emailTxtField.setComponentError(null);
			telephoneTxtField.setComponentError(null);

			
			addButton.setCaption("Cadastrar");
		});
	}

	@Override
	protected void buildFields() {
		// build fields
		nameTxtField = new TextField("Nome");
		nameTxtField.setWidth("100%");
		emailTxtField = new TextField("E-mail");
		emailTxtField.setWidth("100%");
		telephoneTxtField = new TextField("Telefone");
		telephoneTxtField.setWidth("100%");

		// build buttons
		cancelButton = new Button("Cancelar");
		cancelButton.addStyleName(ValoTheme.BUTTON_DANGER);

		cancelButton.addClickListener((event) -> {
			close();
		});

		addButton = new Button("Cadastrar");
		addButton.addStyleName(ValoTheme.BUTTON_PRIMARY);

		addButton.addClickListener((event) -> {
			try {
				binder.writeBean(client);
				
				if(windowMode.equals(WINDOW_MODE.NEW_CLIENT)) {
					if(listener.save(client)) {
						Notification.show("Sucesso ao cadastrar dados do cliente!");
						
						close();
					}
					else {
						Notification.show("Erro ao cadastrar dados do cliente!");

					}
				}
				else {
					if(listener.update(client)) {
						Notification.show("Sucesso ao atualizar dados do cliente!");
						
						close();
					}
					else {
						Notification.show("Erro ao atualizar dados do cliente!");

					}
					
				}
				
				
			} catch (ValidationException e) {

			}
		});
		
	}

	@Override
	protected void buildValidators() {
		binder.forField(nameTxtField)
				.withValidator(new StringLengthValidator("Nome deve ter entre 1 e 50 caracteres", 1, 50))
				.bind(Client::getName, Client::setName);

		binder.forField(emailTxtField)
				.withValidator(new StringLengthValidator("E-mail deve ter entre 1 e 100 caracteres", 1, 100))
				.bind(Client::getEmail, Client::setEmail);

		binder.forField(telephoneTxtField)
				.withValidator(new StringLengthValidator("Telefone deve ter entre 1 e 12 caracteres", 1, 12))
				.bind(Client::getTelephone, Client::setTelephone);

		binder.setBean(client);

	}

	@Override
	protected Component buildLayout() {
		VerticalLayout layout = new VerticalLayout();
		layout.setSizeFull();

		VerticalLayout fields = new VerticalLayout();
		fields.setMargin(false);
		fields.setSpacing(true);
		fields.setWidth("100%");

		fields.addComponent(nameTxtField);
		fields.addComponent(emailTxtField);
		fields.addComponent(telephoneTxtField);
		layout.addComponent(fields);

		HorizontalLayout buttons = new HorizontalLayout();
		buttons.addComponents(cancelButton, addButton);

		layout.addComponent(buttons);

		layout.setComponentAlignment(buttons, Alignment.BOTTOM_RIGHT);

		return layout;
	}

	@Override
	public void addListener(NewClientWindowCrudListener listener) {
		this.listener = listener;
		
	}

	public void setModel(Client client) {
		this.client = client;
		binder.setBean(client);

		nameTxtField.setValue(client.getName());
		emailTxtField.setValue(client.getEmail());
		telephoneTxtField.setValue(client.getTelephone());
		
		windowMode = WINDOW_MODE.UPDATE_CLIENT;
		addButton.setCaption("Atualizar");
	}

	private WINDOW_MODE windowMode = WINDOW_MODE.NEW_CLIENT;
	
	
	
	
	
}
