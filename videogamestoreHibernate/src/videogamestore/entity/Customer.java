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
@Table(name="customer"
    ,catalog="games"
)
public class Customer  implements java.io.Serializable {


     private Integer customerId;
     private String phoneNum;
     private String name;
     private String address;
     private Set<History> histories = new HashSet<History>(0);

    public Customer() {
    }

	
    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }
    public Customer(String phoneNum, String name, String address, Set<History> histories) {
       this.phoneNum = phoneNum;
       this.name = name;
       this.address = address;
       this.histories = histories;
    }
     @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="CustomerID", unique=true, nullable=false)
    public Integer getCustomerId() {
        return this.customerId;
    }
    
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
        
    }

    @Column(name="PhoneNum", length=45)
    public String getPhoneNum() {
        return this.phoneNum;
    }
    
    public void setPhoneNum(String phoneNum) {
        
        this.phoneNum = phoneNum;
        
    }

    @Column(name="Name", nullable=false, length=45)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        
        this.name = name;
    }

    @Column(name="Address", nullable=false, length=45)
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        
        this.address = address;
    }
@OneToMany(fetch=FetchType.LAZY, mappedBy="customer")
    public Set<History> getHistories() {
        return this.histories;
    }
    
    public void setHistories(Set<History> histories) {
        this.histories = histories;
    }

    


}


