package br.com.cliente.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import br.com.cliente.conf.HibernateUtil;
import br.com.cliente.models.User;


public class UserDAO extends GeneralDAO<User> {
	
	@Override
	public boolean save(User user) {
		return super.save(user);
	}
	
	@Override
	public boolean update(User user) {
		return super.update(user);

	}
	
	@Override
	public User find(Class<?> classType, String elem) {
		return super.find(classType, elem);
	}
	
	@Override
	public boolean delete(User user) {
		return super.delete(user);
	}
	
	@Override
	public List<User> getAll(Class<?> classe, String from) {
		return super.getAll(classe, from);
	}
	
	public boolean userExist(User user) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
		
			System.out.println(user.getLogin() + " " + user.getPassword());
			String sql = "SELECT count(*)  FROM User where login = :login and password = :password";
			Query query = session.createQuery(sql);
			query.setParameter("login", user.getLogin());
			query.setParameter("password", user.getPassword());
			
			int rows = ((Long)query.uniqueResult()).intValue();
			
			System.out.println("retorno foi " + rows);
			if(rows <= 0){
				return false;
			}
			else{
				return true;
			}
			
			
			
		} catch (HibernateException ex) {
			ex.printStackTrace();
			return false;
		} finally {
			session.close();
		}
			
	}
}
