/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogamestore.model;
import java.sql.Date;
import java.util.List;
import org.hibernate.Query;
import videogamestore.entity.*;

public class HistoryModel extends AbstractModel<History>{
    public HistoryModel()
    {
        super(History.class);
    }
    //queries to search history tab by various fields
public List<History> LikeGameTitle(String keyword)
    {
        {try
   {
    if(!sessionFactory.getCurrentSession().getTransaction().isActive()) 
     sessionFactory.getCurrentSession().getTransaction().begin();
     Query q = this.sessionFactory.getCurrentSession().createQuery
        ("from History  history where history.videogame.gameTitle like :gameTitle");
          q.setParameter("gameTitle", "%"+keyword+"%");

     return q.list();
   }
       catch(RuntimeException re){
       return null;
       }
    }
    }
public List<History> LikeDate(Date keyword)
    {
        {try
   {
    if(!sessionFactory.getCurrentSession().getTransaction().isActive()) 
     sessionFactory.getCurrentSession().getTransaction().begin();
     Query q = this.sessionFactory.getCurrentSession().createQuery
      ("from History history where history.shipmentDate = :shipmentDate ");
          q.setParameter("shipmentDate", keyword);

     return q.list();
   }
       catch(RuntimeException re){
       return null;
       }
    }
    }
public List<History> LikePlatform(String keyword)
    {
        {try
   {
    if(!sessionFactory.getCurrentSession().getTransaction().isActive()) 
     sessionFactory.getCurrentSession().getTransaction().begin();
     Query q = this.sessionFactory.getCurrentSession().createQuery
        ("from History  history where history.videogame.platform like :platform");
          q.setParameter("platform", "%"+keyword+"%");

     return q.list();
   }
       catch(RuntimeException re){
       return null;
       }
    }
    }
public List<History> LikePublisher(String keyword)
    {
        {try
   {
    if(!sessionFactory.getCurrentSession().getTransaction().isActive()) 
     sessionFactory.getCurrentSession().getTransaction().begin();
     Query q = this.sessionFactory.getCurrentSession().createQuery
        ("from History history where history.publisher like :publisher");
          q.setParameter("publisher", keyword+"%");

     return q.list();
   }
       catch(RuntimeException re){
       return null;
       }
    }
    }
//display todays total after each purchase, resets automatically to 0 after a new day
public List<Double> TotalToday()
    {
        {
            try
   {
    if(!sessionFactory.getCurrentSession().getTransaction().isActive()) 
     sessionFactory.getCurrentSession().getTransaction().begin();
     Query q = this.sessionFactory.getCurrentSession().createQuery
        ("select COALESCE (sum(history.videogame.price*history.quantity), 0) from History history where shipmentDate = CURRENT_DATE()");
     return q.list();
   
   }
       catch(RuntimeException re){
       return null;
       }
        }
}

public List<String> Date()
    {
        {try
   {
    if(!sessionFactory.getCurrentSession().getTransaction().isActive()) 
     sessionFactory.getCurrentSession().getTransaction().begin();
     Query q = this.sessionFactory.getCurrentSession().createQuery
        ("select history.shipmentDate from History history");
     return q.list();
   }
       catch(RuntimeException re){
       return null;
       }
    }
    }
}