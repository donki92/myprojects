package videogamestore.entity;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="history"
    ,catalog="games"
)
public class History  implements java.io.Serializable {


     private Integer shipmentNum;
     private Customer customer;
     private Videogame videogame;
     private Employee employee;
     private Integer quantity;
     private Date shipmentDate;

    public History() {
    }

	
    public History(Customer customer, Videogame videogame) {
        this.customer = customer;
        this.videogame = videogame;
    }
    public History(Customer customer, Videogame videogame, Integer quantity, Date shipmentDate) {
       this.customer = customer;
       this.videogame = videogame;
       this.quantity = quantity;
       this.shipmentDate = shipmentDate;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="ShipmentNum", unique=true, nullable=false)
    public Integer getShipmentNum() {
        return this.shipmentNum;
    }
    
    public void setShipmentNum(Integer shipmentNum) {
        this.shipmentNum = shipmentNum;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CustomerID", nullable=false)
    public Customer getCustomer() {
        return this.customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="VideogameId", nullable=false)
    public Videogame getVideogame() {
        return this.videogame;
    }
    
    public void setVideogame(Videogame videogame) {
        this.videogame = videogame;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="VideogameId", nullable=false)
    public Employee getEmployee() {
        return this.employee;
    }
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    @Column(name="Quantity")
    public Integer getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="shipmentDate", length=10)
    public Date getShipmentDate() {
        return this.shipmentDate;
    }
    
    public void setShipmentDate(Date shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    @Override
    public String toString() {
        return "History{" + "shipmentNum=" + shipmentNum + ", customer=" + customer + ", videogame=" + videogame + ", employee=" + employee + ", quantity=" + quantity + ", shipmentDate=" + shipmentDate + '}';
    }




}


