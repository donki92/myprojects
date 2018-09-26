package videogamestore.model;
import java.util.List;
import org.hibernate.Query;
import videogamestore.entity.*;

public class AccountModel extends AbstractModel<Account>
{
    public AccountModel()
    {
        super(Account.class);
    }
    //Queries for logging in to the application
    public Account login(String username, String password)
    {try 
    {if(!sessionFactory.getCurrentSession().getTransaction().isActive()) 
     sessionFactory.getCurrentSession().getTransaction().begin();
     Query q = this.sessionFactory.getCurrentSession().createQuery
             ("select account from Account account where account.username=:username and account.password=:password");
       q.setString("username", username);
       q.setString("password", password);
       return (Account)q.uniqueResult();
        } catch (Exception e) {
            return null;
        }
    }
    public List<String> user(String username)
    {try 
    {if(!sessionFactory.getCurrentSession().getTransaction().isActive()) 
     sessionFactory.getCurrentSession().getTransaction().begin();
     Query q = this.sessionFactory.getCurrentSession().createQuery
             ("select account.employee.name from Account account where account.username =:username");
       q.setString("username", username);
       return q.list();
        } catch (Exception e) {
            return null;
        }
    }
    //Find all user Ids, displayed in main window after succesful login
    public List<Integer> userId(String username)
    {try 
    {if(!sessionFactory.getCurrentSession().getTransaction().isActive()) 
     sessionFactory.getCurrentSession().getTransaction().begin();
     Query q = this.sessionFactory.getCurrentSession().createQuery
             ("select account.employee.employeeId from Account account where account.username =:username");
       q.setString("username", username);
       return q.list();
        } catch (Exception e) {
            return null;
        }
    }
    //List of usernames to fill the combo boxes
    public List<String> username()
    {try 
    {if(!sessionFactory.getCurrentSession().getTransaction().isActive()) 
     sessionFactory.getCurrentSession().getTransaction().begin();
     Query q = this.sessionFactory.getCurrentSession().createQuery
             ("select account.username from Account account");
       return q.list();
        } catch (Exception e) {
            return null;
        }
    }
    //This query lets us display customer position automatically
    //in the main window after succesful login
     public List<String> position(String username)
    {try 
    {if(!sessionFactory.getCurrentSession().getTransaction().isActive()) 
     sessionFactory.getCurrentSession().getTransaction().begin();
     Query q = this.sessionFactory.getCurrentSession().createQuery
             ("select account.employee.positionName from Account account where account.username =:username");
       q.setString("username", username);
       return q.list();
        } catch (Exception e) {
            return null;
        }
    }
}