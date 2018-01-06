package br.com.cliente.auth;

import java.io.Serializable;

public interface AccessControl extends Serializable {

    public boolean signIn(String username, String password);

    public boolean isUserSignedIn();

    public String getFullName();
}
