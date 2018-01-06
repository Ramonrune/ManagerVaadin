package br.com.cliente.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import br.com.cliente.util.Criptography;

@Entity
public class User {

	@Id
	private String login;
	@NotNull
	private String password;
	@NotNull
	private String fullName;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		Criptography cripto = new Criptography();
		this.password = cripto.sha256(password);
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	
	
}
