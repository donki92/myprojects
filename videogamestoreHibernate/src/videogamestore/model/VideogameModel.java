
package videogamestore.model;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import videogamestore.entity.*;
public class VideogameModel extends AbstractModel<Videogame> {
   public VideogameModel()
           {
               super(Videogame.class);
           }
   Criteria criteria;
   //queries for searching videogame tab by various fields
  public List<Videogame> LikeGameTitle(String keyword)
   {try
   {
    if(!sessionFactory.getCurrentSession().getTransaction().isActive()) 
     sessionFactory.getCurrentSession().getTransaction().begin();
    this.sessionFactory.getCurrentSession().createCriteria(Videogame.class)
            .add(Restrictions.isNull("videogameId")).add(Restrictions.isNull("publisher"))
            .add(Restrictions.isNull("platform"));
     Query q = this.sessionFactory.getCurrentSession().createQuery
        ("from Videogame videogameTitle where videogameTitle.gameTitle like :gameTitle" );
     q.setParameter("gameTitle", "%"+keyword+"%");
     return q.list();
   }
       catch(RuntimeException re){
       return null;
       }
   }  
    public List<Videogame> LikePlatform(String keyword)
   {try
   {
    if(!sessionFactory.getCurrentSession().getTransaction().isActive()) 
     sessionFactory.getCurrentSession().getTransaction().begin();
    this.sessionFactory.getCurrentSession().createCriteria(Videogame.class)
            .add(Restrictions.isNull("videogameId")).add(Restrictions.isNull("gameTitle"))
            .add(Restrictions.isNull("publisher"));
     Query q = this.sessionFactory.getCurrentSession().createQuery
        ("from Videogame videogamePlatform where videogamePlatform.platform like :platform");
     q.setParameter("platform", "%"+keyword+"%");
     return q.list();
   }
       catch(RuntimeException re){
       return null;
       }
   }    
    public List<Videogame> LikePublisher(String keyword)
   {try
   {
    if(!sessionFactory.getCurrentSession().getTransaction().isActive()) 
     sessionFactory.getCurrentSession().getTransaction().begin();
    this.sessionFactory.getCurrentSession().createCriteria(Videogame.class)
            .add(Restrictions.isNull("videogameId")).add(Restrictions.isNull("gameTitle"))
            .add(Restrictions.isNull("platform"));
     Query q = this.sessionFactory.getCurrentSession().createQuery
        ("from Videogame videogamePublisher where"
        + " videogamePublisher.publisher  like :publisher");
          q.setParameter("publisher", "%"+keyword+"%");

     return q.list();
   }
       catch(RuntimeException re){
       return null;
       }
   }  
   public List<Videogame> LikeVideogameID(int keyword)
   {try
   {
    if(!sessionFactory.getCurrentSession().getTransaction().isActive()) 
     sessionFactory.getCurrentSession().getTransaction().begin();
     Query q = this.sessionFactory.getCurrentSession().createQuery
        ("from Videogame videogameID where videogameID.videogameId = :videogameId");
          q.setParameter("videogameId", keyword);

     return q.list();
   }
       catch(RuntimeException re){
       return null;
       }
   }   
   
   public List<Videogame> LikeDistID(int keyword)
   {try
   {
    if(!sessionFactory.getCurrentSession().getTransaction().isActive()) 
     sessionFactory.getCurrentSession().getTransaction().begin();
     Query q = this.sessionFactory.getCurrentSession().createQuery
        ("from Videogame videogameDist where videogameDist.distributorId = "+keyword);
     return q.list();
   }
       catch(RuntimeException re){
       return null;
       }
   }   
   public List<Videogame> LikeQuantity(int keyword)
   {try
   {
    if(!sessionFactory.getCurrentSession().getTransaction().isActive()) 
     sessionFactory.getCurrentSession().getTransaction().begin();
     Query q = this.sessionFactory.getCurrentSession().createQuery
        ("from Videogame videogameQuantity where videogameQuantity.quantity = "+keyword);
     return q.list();
   }
       catch(RuntimeException re){
       return null;
       }
   }   
     public List<Videogame> LikePrice(double keyword)
   {try
   {
    if(!sessionFactory.getCurrentSession().getTransaction().isActive()) 
     sessionFactory.getCurrentSession().getTransaction().begin();
     Query q = this.sessionFactory.getCurrentSession().createQuery
        ("from Videogame videogamePrice where videogamePrice.price = "+keyword);
     return q.list();
   }
       catch(RuntimeException re){
       return null;
       }
   }  
     public List<Videogame> LikeESRB(String keyword)
   {try
   {
    if(!sessionFactory.getCurrentSession().getTransaction().isActive()) 
     sessionFactory.getCurrentSession().getTransaction().begin();
     Query q = this.sessionFactory.getCurrentSession().createQuery
        ("from Videogame videogameESRB where videogameESRB.esrbrating = '"+keyword+"'");
     return q.list();
   }
       catch(RuntimeException re){
       return null;
       }
   }  
     }
     

    

