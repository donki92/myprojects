
package videogamestore.model;

import java.util.*;
import java.io.*;
import org.hibernate.*;
import videogamestore.util.*;
public abstract class AbstractModel<T>
{
    private Class<T> entityClass;
    //final = constant; only one sessionFactory object needed
    protected final SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();

    public AbstractModel(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public AbstractModel() {
    }
    //Select all from table
    public List<T> findAll()
    {
        if(!sessionFactory.getCurrentSession().getTransaction().isActive())
            sessionFactory.getCurrentSession().getTransaction().begin();
        return sessionFactory.getCurrentSession()
                .createQuery("from "+ entityClass.getName()).list();
    }
    
    
    //Update row
    public void update(T instance)
    {
        try{
         if(!sessionFactory.getCurrentSession().getTransaction().isActive())
             sessionFactory.getCurrentSession().getTransaction().begin();
        sessionFactory.getCurrentSession().merge(instance);
        sessionFactory.getCurrentSession().getTransaction().commit();
        }
        catch(RuntimeException re)
        {sessionFactory.getCurrentSession().getTransaction().rollback();
           throw re;
        }
    }
    //Delete row
    public void delete(T instance)
    {
        try{
         if(!sessionFactory.getCurrentSession().getTransaction().isActive())
             sessionFactory.getCurrentSession().getTransaction().begin();
        sessionFactory.getCurrentSession().delete(instance);
        sessionFactory.getCurrentSession().getTransaction().commit();
        }
        catch(RuntimeException re)
        {sessionFactory.getCurrentSession().getTransaction().rollback();
           throw re;
        }
    }
   //Create a row
   public void create(T instance)
    {
        try{
         if(!sessionFactory.getCurrentSession().getTransaction().isActive())
             sessionFactory.getCurrentSession().getTransaction().begin();
        sessionFactory.getCurrentSession().persist(instance);
        sessionFactory.getCurrentSession().getTransaction().commit();
        }
        catch(RuntimeException re)
        {sessionFactory.getCurrentSession().getTransaction().rollback();
        }
    }
   //Find a row by primary key
   public T find(Object primarykey)
   {try
   {
    if(!sessionFactory.getCurrentSession().getTransaction().isActive()) 
     sessionFactory.getCurrentSession().getTransaction().begin();
    return(T) sessionFactory.getCurrentSession().get(entityClass, (Serializable) primarykey);
   }
       catch(RuntimeException re){
       return null;
       }
       
       
   }
}


