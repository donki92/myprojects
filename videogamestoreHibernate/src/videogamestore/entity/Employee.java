package videogamestore.entity;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="employee"
    ,catalog="games"
)
public class Employee  implements java.io.Serializable {


     private Integer employeeId;
     private String name;
     private String address;
     private String positionName;
     private Set histories = new HashSet(0);
     private Set<Account> accounts = new HashSet<Account>(0);

    public Employee() {
    }

	
    public Employee(String name, String address) {
        this.name = name;
        this.address = address;
    }
    public Employee(String name, String address, String positionName, Set<Account> accounts) {
       this.name = name;
       this.address = address;
       this.positionName = positionName;
       this.accounts = accounts;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="EmployeeID", unique=true, nullable=false)
    public Integer getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    
    @Column(name="Name", nullable=false, length=50)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="Address", nullable=false, length=50)
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    
    @Column(name="PositionName", length=45)
    public String getPositionName() {
        return this.positionName;
    }
    
    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
@OneToMany(fetch=FetchType.LAZY, mappedBy="employee")    
public Set getHistories() {
        return this.histories;
    }
    
    public void setHistories(Set histories) {
        this.histories = histories;
    }
@OneToMany(fetch=FetchType.LAZY, mappedBy="employee")
    public Set<Account> getAccounts() {
        return this.accounts;
    }
    
    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Employee{" + "accounts=" + accounts + '}';
    }




}


