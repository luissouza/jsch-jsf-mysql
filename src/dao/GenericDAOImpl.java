package dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;

public abstract class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {
	
	private Class<T> clazz;
	private Transaction tx;

	@SuppressWarnings("unchecked")
	public GenericDAOImpl() {  	
        this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ID insert(T object) {	
		Serializable id = null;
		try {
			this.tx = getSession().beginTransaction();
			id = getSession().save(object);
			this.tx.commit();
		} catch (Throwable e) {
			e.printStackTrace();
			this.tx.rollback();
			System.err.println(e.getMessage());
			throw new HibernateException(e.getMessage());
		}		
		return (ID) id;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T select(ID id) {
		return (T) getSession().get(this.clazz, id);
	}
	
	
	/*public List<T> selectByName(T object) {
		Aluno aluno = null;
		if(object instanceof Aluno){
			aluno = (Aluno) object;
		Criteria c = getSession().createCriteria(clazz);
		c.add(Restrictions.like("nomeAluno", aluno.getNomeAluno()));
		}
		
		
		return selectByName(object);
		
	}
*/
	


	@Override
	public void update(T object) {
		try {
			this.tx = getSession().beginTransaction();
			getSession().update(object);
			this.tx.commit();
		} catch (Throwable e) {
			this.tx.rollback();
			System.err.println(e.getMessage());
			throw new HibernateException(e.getMessage());
		}
	}


	@Override
	public void delete(T object) {
		try {
			this.tx = getSession().beginTransaction();
			getSession().delete(object);
			this.tx.commit();
		} catch (Throwable e) {
			this.tx.rollback();
			System.err.println(e.getMessage());
			throw new HibernateException(e.getMessage());
		}		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> list() {
		try {
			this.tx = getSession().beginTransaction();
			Criteria criteria = getSession().createCriteria(clazz);
			return (List<T>) criteria.list();
		} catch (Throwable e) {
			System.err.println(e.getMessage());
			throw new HibernateException(e.getMessage());
		} 
	}
	
	public Session getSession() {	
		try {
			if (HibernateUtil.session == null) {
				HibernateUtil.session = HibernateUtil.getConfiguration().buildSessionFactory().openSession();
			} else {		
				HibernateUtil.session = HibernateUtil.getSessionFactory().getCurrentSession();
			}	
		} catch (Throwable e) {
			e.printStackTrace();
			System.err.println("Initial Session creation failed. " + e.getMessage());
			
		}
		return HibernateUtil.session;
	}

}
