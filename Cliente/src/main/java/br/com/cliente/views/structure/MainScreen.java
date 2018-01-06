package br.com.cliente.views.structure;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import br.com.cliente.conf.MyUI;
import br.com.cliente.views.client.SampleCrudView;

public class MainScreen extends HorizontalLayout {

	private static final long serialVersionUID = 1L;
	private Menu menu;

	public MainScreen(MyUI ui) {

		setSpacing(false);
		setStyleName("main-screen");

		CssLayout viewContainer = new CssLayout();
		viewContainer.addStyleName("valo-content");
		viewContainer.setSizeFull();

		final Navigator navigator = new Navigator(ui, viewContainer);
		navigator.setErrorView(ErrorView.class);
		menu = new Menu(navigator);
		menu.addView(new SampleCrudView(), SampleCrudView.VIEW_NAME, SampleCrudView.VIEW_NAME, VaadinIcons.EDIT);

		navigator.addViewChangeListener(viewChangeListener);

		addComponent(menu);
		addComponent(viewContainer);
		setExpandRatio(viewContainer, 1);
		setSizeFull();
	}

	ViewChangeListener viewChangeListener = new ViewChangeListener() {

		
		private static final long serialVersionUID = 1L;

		@Override
		public boolean beforeViewChange(ViewChangeEvent event) {
			return true;
		}

		@Override
		public void afterViewChange(ViewChangeEvent event) {
			menu.setActiveView(event.getViewName());
		}

	};
}
