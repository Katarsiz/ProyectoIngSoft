package Modelo;

public class PuestoDAO{
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
        	this.sessionFactory = sessionFactory;
    	}
  	
  	public void guardar(Puesto c) {
    
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
	
	public void eliminar(Puesto c) {
    
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
