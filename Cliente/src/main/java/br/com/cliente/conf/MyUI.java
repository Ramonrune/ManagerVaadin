package br.com.cliente.conf;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Viewport;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;
import br.com.cliente.auth.AccessControl;
import br.com.cliente.auth.BasicAccessControl;
import br.com.cliente.auth.LoginScreen;
import br.com.cliente.views.structure.MainScreen;

@Viewport("user-scalable=no,initial-scale=1.0")
@Theme("mytheme")
public class MyUI extends UI {

	private static final long serialVersionUID = 1L;

	private AccessControl accessControl = new BasicAccessControl();

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		Responsive.makeResponsive(this);
		setLocale(vaadinRequest.getLocale());
		getPage().setTitle("Cliente");
		if (!accessControl.isUserSignedIn()) {
			setContent(new LoginScreen(accessControl, () -> {

				showMainView();

			}));
		} else {
			showMainView();
		}

	}

	protected void showMainView() {
		addStyleName(ValoTheme.UI_WITH_MENU);
		setContent(new MainScreen(MyUI.this));
		getNavigator().navigateTo("Clientes");
	}

	public static MyUI get() {
		return (MyUI) UI.getCurrent();
	}

	public AccessControl getAccessControl() {
		return accessControl;
	}

}
