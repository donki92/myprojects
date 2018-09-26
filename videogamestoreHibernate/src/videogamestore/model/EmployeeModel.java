/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogamestore.model;
import java.util.List;
import org.hibernate.Query;
import videogamestore.entity.*;
public class EmployeeModel extends AbstractModel<Employee> {
    public EmployeeModel()
    {
      super(Employee.class);
    }
    //quuries to search employee tab by various fields
    public List<Employee> LikeEmployeeId(int keyword)
    {
        {try
   {
    if(!sessionFactory.getCurrentSession().getTransaction().isActive()) 
     sessionFactory.getCurrentSession().getTransaction().begin();
     Query q = this.sessionFactory.getCurrentSession().createQuery
        ("from Employee employee where employee.employeeId = "+keyword);
          //q.setParameter("employeeId", keyword);

     return q.list();
   }
       catch(RuntimeException re){
       return null;
       }
    }
    }
    public List<Employee> LikeEmployeeName(String keyword)
    {
        {try
   {
    if(!sessionFactory.getCurrentSession().getTransaction().isActive()) 
     sessionFactory.getCurrentSession().getTransaction().begin();
     Query q = this.sessionFactory.getCurrentSession().createQuery
        ("from Employee employee where employee.name like :name");
          q.setParameter("name", "%"+keyword+"%");

     return q.list();
   }
       catch(RuntimeException re){
       return null;
       }
    }
    }
    public List<Employee> LikePosition(String keyword)
    {
        {try
   {
    if(!sessionFactory.getCurrentSession().getTransaction().isActive()) 
     sessionFactory.getCurrentSession().getTransaction().begin();
     Query q = this.sessionFactory.getCurrentSession().createQuery
        ("from Employee employee where employee.positionName like :positionName");
          q.setParameter("positionName", "%"+keyword+"%");

     return q.list();
   }
       catch(RuntimeException re){
       return null;
       }
    }
    }
    public List<Employee> LikeAddresEmployee(String keyword)
    {
        {try
   {
    if(!sessionFactory.getCurrentSession().getTransaction().isActive()) 
     sessionFactory.getCurrentSession().getTransaction().begin();
     Query q = this.sessionFactory.getCurrentSession().createQuery
        ("from Employee employee where employee.address like :address");
          q.setParameter("address", "%"+keyword+"%");

     return q.list();
   }
       catch(RuntimeException re){
       return null;
       }
    }
    }
    //list of employee ids used to display the id of the logged in employee in the history tab
    public List<Integer> employeeId()
    {try 
    {if(!sessionFactory.getCurrentSession().getTransaction().isActive()) 
     sessionFactory.getCurrentSession().getTransaction().begin();
     Query q = this.sessionFactory.getCurrentSession().createQuery
             ("select employee.employeeId from Employee employee");
       return q.list();
        } catch (Exception e) {
            return null;
        }
    }
    //list of employee names used to display the name of the logged in employee in the history tab
    public List<String> employeeName()
    {try 
    {if(!sessionFactory.getCurrentSession().getTransaction().isActive()) 
     sessionFactory.getCurrentSession().getTransaction().begin();
     Query q = this.sessionFactory.getCurrentSession().createQuery
             ("select employee.name from Employee employee");
       return q.list();
        } catch (Exception e) {
            return null;
        }
    }
    public List<Integer> accountToName(String name)
    {try 
    {if(!sessionFactory.getCurrentSession().getTransaction().isActive()) 
     sessionFactory.getCurrentSession().getTransaction().begin();
     Query q = this.sessionFactory.getCurrentSession().createQuery
             ("select employee.employeeId from Employee employee where employee.name = :name");
     q.setParameter("name", name);
       return q.list();
        } catch (Exception e) {
            return null;
        }
    }
}
