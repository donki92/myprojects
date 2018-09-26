
package videogamestore.model;
import java.util.List;
import org.hibernate.Query;
import videogamestore.entity.*;
public class CustomerModel extends AbstractModel<Customer> {
    public CustomerModel()
            {
                super(Customer.class);
            }
    //queries used to search customer tab by various fields
    public List<Customer> LikeCustomerId(int keyword)
    {
        {try
   {
    if(!sessionFactory.getCurrentSession().getTransaction().isActive()) 
     sessionFactory.getCurrentSession().getTransaction().begin();
     Query q = this.sessionFactory.getCurrentSession().createQuery
        ("from Customer customer where customer.customerId = "+keyword);
         //q.setParameter("customerId", keyword);
         return q.list();
   }
       catch(RuntimeException re){
       return null;
       }
    }
    }
    public List<Customer> LikeCustomerName(String keyword)
    {
        {try
   {
    if(!sessionFactory.getCurrentSession().getTransaction().isActive()) 
     sessionFactory.getCurrentSession().getTransaction().begin();
     Query q = this.sessionFactory.getCurrentSession().createQuery
        ("from Customer customer where customer.name like :name");
          q.setParameter("name", "%"+keyword+"%");
          return q.list();
   }
       catch(RuntimeException re){
       return null;
       }
    }
    }
    public List<Customer> LikePhone(String keyword)
    {
        {try
   {
    if(!sessionFactory.getCurrentSession().getTransaction().isActive()) 
     sessionFactory.getCurrentSession().getTransaction().begin();
     Query q = this.sessionFactory.getCurrentSession().createQuery
        ("from Customer customer where customer.phoneNum like :phoneNum");
          q.setParameter("phoneNum", keyword+"%");
          return q.list();
   }
       catch(RuntimeException re){
       return null;
       }
    }
    }
    public List<Customer> LikeAddresCustomer(String keyword)
    {
        {try
   {
    if(!sessionFactory.getCurrentSession().getTransaction().isActive()) 
     sessionFactory.getCurrentSession().getTransaction().begin();
     Query q = this.sessionFactory.getCurrentSession().createQuery
        ("from Customer customer where customer.address like :address");
          q.setParameter("address", "%"+keyword+"%");
          return q.list();
   }
       catch(RuntimeException re){
       return null;
       }
    }
    }
    
    public List<Integer> CustomerId()
    {
       {try
   {
    if(!sessionFactory.getCurrentSession().getTransaction().isActive()) 
     sessionFactory.getCurrentSession().getTransaction().begin();
     Query q = this.sessionFactory.getCurrentSession().createQuery
        ("select customer.customerId from Customer customer");
          return q.list();
   }
       catch(RuntimeException re){
       return null;
       }
    } 
    }
    //list of customers to fill the customer name combo boz
    public List<String> CustomerName()
    {
        {try
   {
    if(!sessionFactory.getCurrentSession().getTransaction().isActive()) 
     sessionFactory.getCurrentSession().getTransaction().begin();
     Query q = this.sessionFactory.getCurrentSession().createQuery
        ("select customer.name from Customer customer");
          return q.list();
   }
       catch(RuntimeException re){
       return null;
       }
    }
    }
    //adding the customer id into the history table where name is from the combobox
    public List<Integer> SellId(String keyword)
    {
        {try
   {
    if(!sessionFactory.getCurrentSession().getTransaction().isActive()) 
     sessionFactory.getCurrentSession().getTransaction().begin();
     Query q = this.sessionFactory.getCurrentSession().createQuery
        ("select customer.customerId from Customer customer where customer.name = :name");
          q.setParameter("name", keyword);
          return q.list();
   }
       catch(RuntimeException re){
       return null;
       }
    }
    }
}
