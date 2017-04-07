package Modelo;

import Mapeo.Grupo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Emilio
 */
public class ComentarioDAO{

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
        	this.sessionFactory = sessionFactory;
    	}
  	
	@Override
  	public void guardar(Comentario c) {
    
	        Session session = sessionFactory.openSession();
        	Transaction tx = null;
	        try {
			tx = session.beginTransaction();
         
           		session.persist(c);
           		tx.commit();
        	}catch (Exception e) {
           		if (tx!=null){ 
               			tx.rollback();
           		}
           		e.printStackTrace(); 
        	}finally {
           		session.close();
        	}
	}
	
	@Override
	public void eliminar(Comentario grupo) {
    
        	Session session = sessionFactory.openSession();
        	Transaction tx = null;
        	try {
        	   	tx = session.beginTransaction();
	           	session.delete(c);
           		tx.commit();
        	}catch (Exception e) {
	        	if (tx!=null){ 
        	       		tx.rollback();
           		}
           		e.printStackTrace(); 
        	}finally {
           		session.close();
        	}
	}
  
}
