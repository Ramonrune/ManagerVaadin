package br.com.cliente.views.client.window;

public interface NewClientWindow {
	interface NewClientWindowViewListener {
        void buttonClick(char operation);
    }
	
    public void addListener(NewClientWindowViewListener listener);
    
}
