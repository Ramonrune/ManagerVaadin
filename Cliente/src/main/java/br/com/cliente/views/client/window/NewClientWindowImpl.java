package br.com.cliente.views.client.window;

import com.vaadin.data.Binder;
import com.vaadin.data.ValidationException;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;

import br.com.cliente.models.Client;
import br.com.cliente.views.CustomWindow;

public class NewClientWindowImpl extends CustomWindow<Client> {

	private TextField nameTxtField;
	private TextField emailTxtField;
	private TextField telephoneTxtField;
	private Button cancelButton;
	private Button addButton;

	public NewClientWindowImpl() {
		super(Client::new);
		
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
				binder.writeBean(get());

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

		binder.setBean(get());

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

	
}
