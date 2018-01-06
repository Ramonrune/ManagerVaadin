package br.com.cliente.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.cliente.conf.HibernateUtil;

public class GeneralDAO<E> implements DataAcessObject<E> {

	@Override
	public boolean save(E elem) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.save(elem);
			transaction.commit();
			return true;
		} catch (HibernateException ex) {
			if (transaction != null)
				transaction.rollback();

			ex.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean update(E elem) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.update(elem);
			transaction.commit();
			return true;
		} catch (HibernateException ex) {
			if (transaction != null)
				transaction.rollback();

			ex.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public E find(Class<?> classType, String elem) {

		System.out.println(classType.getName());
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			@SuppressWarnings("unchecked")
			E obj = (E) session.get(classType, elem);
			transaction.commit();

			return obj;
		} catch (HibernateException ex) {
			if (transaction != null)
				transaction.rollback();

			ex.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean delete(E elem) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.delete(elem);
			transaction.commit();
			return true;
		} catch (HibernateException ex) {
			if (transaction != null)
				transaction.rollback();

			ex.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public List<E> getAll(Class<?> classe, String from) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {

			@SuppressWarnings("unchecked")
			List<E> list = (List<E>) session.createSQLQuery("SELECT * FROM " + from).addEntity(classe).list();

			return list;
		} catch (HibernateException ex) {
			return null;
		} finally {
			session.close();
		}
	}

}
