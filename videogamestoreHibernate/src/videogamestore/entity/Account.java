package videogamestore.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="account"
    ,catalog="games"
)
public class Account  implements java.io.Serializable {


     private Integer accountId;
     private Employee employee;
     private String username;
     private String password;

    public Account() {
    }

    public Account(Employee employee, String username, String password) {
       this.employee = employee;
       this.username = username;
       this.password = password;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="AccountId", unique=true, nullable=false)
    public Integer getAccountId() {
        return this.accountId;
    }
    
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="EmployeeId")
    public Employee getEmployee() {
        return this.employee;
    }
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    
    @Column(name="Username", length=45)
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    
    @Column(name="Password", length=45)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }




}


