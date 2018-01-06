package br.com.cliente.views.structure;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;


public class ErrorView extends VerticalLayout implements View {

    
	private static final long serialVersionUID = 1L;
	private Label explanation;

    public ErrorView() {
        Label header = new Label("Página não encontrada");
        header.addStyleName(ValoTheme.LABEL_H1);
        addComponent(header);
        addComponent(explanation = new Label());
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        explanation.setValue(String.format(
                "Você tentou navegar pela página ('%s') que não existe.",
                event.getViewName()));
    }
}
