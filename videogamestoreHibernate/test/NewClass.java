
import java.sql.Date;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import videogamestore.entity.*;
import videogamestore.model.*;
public class NewClass {
    public static void main(String[] args) {
            Configuration configuration = new Configuration().configure().addAnnotatedClass(Videogame.class).addAnnotatedClass(History.class).addAnnotatedClass(Customer.class);
        ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
        registry.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = registry.build();

        // builds a session factory from the service registry
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
         
        // obtains the session
        Session session = sessionFactory.openSession();
        sessionFactory.getCurrentSession().beginTransaction();
        Customer customer = new Customer();
        CustomerModel customerModel = new CustomerModel();
        AccountModel accountModel = new AccountModel();
        HistoryModel historyModel = new HistoryModel();
        
        Query q = sessionFactory.getCurrentSession().createQuery("select customer.customerId from Customer customer");
        System.out.println(q.list());
        System.out.println(customerModel.CustomerId());
        int id =2;
        if(customerModel.CustomerId().contains(id))
            System.out.println("true");
        else
        { System.out.println("false");}
       String username = "doan.selmani@gmail.com";
        System.out.println(accountModel.user(username).get(0));
        EmployeeModel employeeModel = new EmployeeModel();
        int empId = 6;
        System.out.println(employeeModel.employeeId()+" employee ids");
        if(employeeModel.employeeId().contains(empId))
            System.out.println("true");
        else
            System.out.println("false");
        
        Employee employee = new Employee();
        Account account = new Account(employee, "doan.selmani@gmail.com", "1234");
        System.out.println(employee.toString());
        System.out.println(account.getEmployee().getName());
        //customerModel.create(customer);
        System.out.println(customerModel.CustomerName());
        System.out.println(customerModel.SellId("John"));
        System.out.println(accountModel.username());
        System.out.println(customerModel.find(13));
        //customerModel.delete(customerModel.find(13));
        //customerModel.delete(customer);
        System.out.println(customerModel.findAll());
        System.out.println(historyModel.Date());
        System.out.println(historyModel.LikeDate(Date.valueOf("2018-08-31")));
        
        System.out.println(employeeModel.employeeName());
        System.out.println(employeeModel.accountToName("Doan Selmani"));
        
    }
}
