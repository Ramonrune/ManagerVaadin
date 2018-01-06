package br.com.cliente.daos;

import java.util.List;

public interface DataAcessObject<E> {
	public boolean save(E elem);

	public boolean update(E elem);

	public E find(Class<?> classType, String elem);

	public boolean delete(E elem);
	
	public List<E> getAll(Class<?> classe, String from);
	

}
