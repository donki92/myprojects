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
@Table(name="videogame"
    ,catalog="games"
)
public class Videogame  implements java.io.Serializable {


     private Integer videogameId;
     private String gameTitle;
     private String platform;
     private double price;
     private String publisher;
     private Integer distributorId;
     private String esrbrating;
     private Integer quantity;
     private Set<History> histories = new HashSet<History>(0);

    public Videogame() {
    }

	
    public Videogame(String gameTitle, String platform, double price, String publisher) {
        this.gameTitle = gameTitle;
        this.platform = platform;
        this.price = price;
        this.publisher = publisher;
    }
    public Videogame(String gameTitle, String platform, double price, String publisher, Integer distributorId, String esrbrating, Integer quantity, Set<History> histories) {
       this.gameTitle = gameTitle;
       this.platform = platform;
       this.price = price;
       this.publisher = publisher;
       this.distributorId = distributorId;
       this.esrbrating = esrbrating;
       this.quantity = quantity;
       this.histories = histories;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="VideogameId", unique=true, nullable=false)
    public Integer getVideogameId() {
        return this.videogameId;
    }
    
    public void setVideogameId(Integer videogameId) {
        this.videogameId = videogameId;
    }

    
    @Column(name="GameTitle", nullable=false, length=50)
    public String getGameTitle() {
        return this.gameTitle;
    }
    
    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    
    @Column(name="Platform", nullable=false, length=20)
    public String getPlatform() {
        return this.platform;
    }
    
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    
    @Column(name="Price", nullable=false, precision=22, scale=0)
    public double getPrice() {
        return this.price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }

    
    @Column(name="Publisher", nullable=false, length=50)
    public String getPublisher() {
        return this.publisher;
    }
    
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    
    @Column(name="DistributorID")
    public Integer getDistributorId() {
        return this.distributorId;
    }
    
    public void setDistributorId(Integer distributorId) {
        this.distributorId = distributorId;
    }

    
    @Column(name="ESRBRating", length=5)
    public String getEsrbrating() {
        return this.esrbrating;
    }
    
    public void setEsrbrating(String esrbrating) {
        this.esrbrating = esrbrating;
    }

    
    @Column(name="Quantity")
    public Integer getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="videogame")
    public Set<History> getHistories() {
        return this.histories;
    }
    
    public void setHistories(Set<History> histories) {
        this.histories = histories;
    }




}


