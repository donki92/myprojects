package videogamestore.ui;
import java.text.MessageFormat;
import java.time.Instant;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.*;
import videogamestore.entity.*;
import videogamestore.model.*;
import videogamestore.util.*;
public class videogameGUI extends javax.swing.JFrame {

 
 
               
    public videogameGUI() 
    {   
        initComponents();
        FillData();
        FillDataSell();
        FillDataHistory();
        FillDataCustomer();
        FillDataEmployee();
    }
  
    //FILL TABLES WITH DATA
    
    private final VideogameModel videogameModel = new VideogameModel();
    private final HistoryModel historyModel = new HistoryModel();
    private final CustomerModel customerModel = new CustomerModel();
    private final EmployeeModel employeeModel = new EmployeeModel();
    private final AccountModel  accountModel = new AccountModel();
    public void FillData()
   {
       DefaultTableModel dtm = new DefaultTableModel();
       dtm.addColumn("Game ID");
       dtm.addColumn("Game Title");
       dtm.addColumn("Platform");
       dtm.addColumn("Price");
       dtm.addColumn("Publisher");
       dtm.addColumn("Distributor ID");
       dtm.addColumn("ESRB Rating");
       dtm.addColumn("Quantity");
       for(Videogame videogame: this.videogameModel.findAll())
       {
           dtm.addRow(new Object []{videogame.getVideogameId(), videogame.getGameTitle(),videogame.getPlatform(),videogame.getPrice(),
           videogame.getPublisher(),videogame.getDistributorId(),videogame.getEsrbrating(),videogame.getQuantity()});
          this.JTableVideogame.setModel(dtm);
   }
   }
    
    private void FillDataHistory()
   {
       DefaultTableModel dtm = new DefaultTableModel();
       dtm.addColumn("Shipment ID");
       dtm.addColumn("Customer Name");
       dtm.addColumn("Employee Name");
       dtm.addColumn("Game Title");
       dtm.addColumn("Platform");
       dtm.addColumn("Quantity");
       dtm.addColumn("Shipment Date");
       dtm.addColumn("Price");

       for(History history: this.historyModel.findAll())
       {
           dtm.addRow(new Object []{history.getShipmentNum(),
           history.getCustomer().getName(), history.getEmployee().getName(),
           history.getVideogame().getGameTitle(),
           history.getVideogame().getPlatform(), history.getQuantity(),
           history.getShipmentDate(), history.getVideogame().getPrice()});
          this.JTableHistory.setModel(dtm);
   }

   }
     private void FillDataCustomer()
   {
       DefaultTableModel dtm = new DefaultTableModel();
       dtm.addColumn("Customer ID");
       dtm.addColumn("Phone Number");
       dtm.addColumn("Name");
       dtm.addColumn("Address");
       

       for(Customer customer: this.customerModel.findAll())
       {
           dtm.addRow(new Object []{customer.getCustomerId(),
           customer.getPhoneNum(),customer.getName(),customer.getAddress()});
          this.JTableCustomer.setModel(dtm);
   }
   }
       private void FillDataEmployee()
   {
       DefaultTableModel dtm = new DefaultTableModel();
       dtm.addColumn("Employee ID");
       dtm.addColumn("Name");
       dtm.addColumn("Address");
       dtm.addColumn("Position Name");
       
       for(Employee employee: this.employeeModel.findAll())
       {
           dtm.addRow(new Object []{employee.getEmployeeId(),employee.getName(),
               employee.getAddress(),employee.getPositionName()});
          this.JTableEmployee.setModel(dtm);
   }
   }
       
         private void FillDataSell()
   {
        DefaultTableModel dtm = new DefaultTableModel();
       dtm.addColumn("Game ID");
       dtm.addColumn("Game Title");
       dtm.addColumn("Platform");
       dtm.addColumn("Price");
       dtm.addColumn("Publisher");
       dtm.addColumn("Distributor ID");
       dtm.addColumn("ESRB Rating");
       dtm.addColumn("Quantity");
       for(Videogame videogame: this.videogameModel.findAll())
       {
           dtm.addRow(new Object []{videogame.getVideogameId(),
           videogame.getGameTitle(),videogame.getPlatform(),videogame.getPrice(),
           videogame.getPublisher(),videogame.getDistributorId(),
           videogame.getEsrbrating(),videogame.getQuantity()});
          this.JTableSell.setModel(dtm);
   }
}
    // FILL TABLES WITH DATA END
   
    

// CLEAR FIELDS AFTER BUTTON PRESS METHODS
     public void ClearFields()
     {
         this.JtxtGameIDGame.setText("");
         this.JtxtPublisherGame.setText("");
         this.JtxtPriceGame.setText("");
         this.JtxtGameTitleGame.setText("");
         this.jComboBoxDistGame.setSelectedIndex(0);
         this.JtxtQuantityGame.setText("0");
         this.jComboBoxESRB.setSelectedIndex(0);
         this.cmbPlatformGame.setSelectedIndex(0);
     }
     public void ClearFieldsSellTab()
     {
         this.JtxtGameIDSell.setText("");
         this.JtxtPublisherSell.setText("");
         this.JtxtPriceSell.setText("");
         this.JtxtGameTitleSell.setText("");
         this.jComboBoxDistSell.setSelectedIndex(0);
         this.JtxtQuantitySell.setText("");
         this.jComboBoxESRB2.setSelectedIndex(0);
         this.cmbPlatformSell.setSelectedIndex(0);
         this.JtxtOrderSell.setText("");
     }
     public void ClearFieldsCustomerTab()
     {
         this.JtxtNameCustomer.setText("");
         this.JtxtAddressCustomer.setText("");
         this.JtxtPhoneCustomer.setText("");
         this.JtxtCustomerIDCustomer.setText("");
         
     }
      public void ClearFieldsEmployeeTab()
     {
         this.JtxtNameEmployee.setText("");
         this.JtxtAddressEmployee.setText("");
         this.JtxtEmployeeID.setText("");
         this.JtxtPositionEmployee.setText("");
         
     }
       public void ClearFieldsHistory()
     {
         this.JtxtGameTitleHistory.setText("");
         this.JtxtHistoryPrice.setText("");
         this.JtxtCustomerIDHistory.setText("");
         this.JtxtDateHistory.setText("");
         this.JtxtShipmentNum.setText("");
         this.JtxtQuantityHistory.setText("");
         this.JtxtOrderSell.setText("");
         this.cmbPlatformHistory.setSelectedIndex(0);
     }
     // CLEAR FIELDS END 
      
      //METHODS FOR USING SEARCH BUTTON TO FIND ROWS FROM DATABASE
// METHODS FOR VIDEOGAME TABLE
    private  void searchByGameTitle()
{
   try
   {   
       DefaultTableModel dtm = new DefaultTableModel();
       dtm.addColumn("Game ID");
       dtm.addColumn("Game Title");
       dtm.addColumn("Platform");
       dtm.addColumn("Price");
       dtm.addColumn("Publisher");
       dtm.addColumn("Distributor ID");
       dtm.addColumn("ESRB Rating");
       dtm.addColumn("Quantity");
       this.videogameModel.LikeGameTitle(JtxtGameTitleGame.getText())
               .stream().map((videogameTitle) ->
               {dtm.addRow(new Object []
              {videogameTitle.getVideogameId(), videogameTitle.getGameTitle(),
               videogameTitle.getPlatform(),videogameTitle.getPrice(),
               videogameTitle.getPublisher(),videogameTitle.getDistributorId(),
               videogameTitle.getEsrbrating(),videogameTitle.getQuantity()});
           return videogameTitle;
       }).forEachOrdered((_item) -> {
           this.JTableVideogame.setModel(dtm);
       });
         }
     catch(Exception e){
     } 
    
    
}

private  void searchByPlatform()
{
    try{
       DefaultTableModel dtm = new DefaultTableModel();
       dtm.addColumn("Game ID");
       dtm.addColumn("Game Title");
       dtm.addColumn("Platform");
       dtm.addColumn("Price");
       dtm.addColumn("Publisher");
       dtm.addColumn("Distributor ID");
       dtm.addColumn("ESRB Rating");
       dtm.addColumn("Quantity");
       this.videogameModel.LikePlatform(cmbPlatformGame.getSelectedItem().toString())
       .stream().map((videogamePlatform) -> {
           dtm.addRow(new Object []
           {videogamePlatform.getVideogameId(), videogamePlatform.getGameTitle(),
            videogamePlatform.getPlatform(),videogamePlatform.getPrice(),
           videogamePlatform.getPublisher(),videogamePlatform.getDistributorId(),
           videogamePlatform.getEsrbrating(),videogamePlatform.getQuantity()});
            return videogamePlatform;
        }).forEachOrdered((_item) -> {
            this.JTableVideogame.setModel(dtm);
        });
         }
     catch(Exception e){
     } 
    
}
private  void searchByPublisher() 
{ 
    try{
       DefaultTableModel dtm = new DefaultTableModel();
       dtm.addColumn("Game ID");
       dtm.addColumn("Game Title");
       dtm.addColumn("Platform");
       dtm.addColumn("Price");
       dtm.addColumn("Publisher");
       dtm.addColumn("Distributor ID");
       dtm.addColumn("ESRB Rating");
       dtm.addColumn("Quantity");
       this.videogameModel.LikePublisher(JtxtPublisherGame.getText()).
               stream().map((videogamePublisher) -> {
           dtm.addRow(new Object []
           {
            videogamePublisher.getVideogameId(), videogamePublisher.getGameTitle(),
            videogamePublisher.getPlatform(), videogamePublisher.getPrice(),
            videogamePublisher.getPublisher(),videogamePublisher.getDistributorId(),
            videogamePublisher.getEsrbrating(),videogamePublisher.getQuantity()});
            return videogamePublisher;
        }).forEachOrdered((_item) -> {
            this.JTableVideogame.setModel(dtm);
        });
         }
     catch(Exception e){
     } 
    
}
private  void searchByGameId()
{ 
    try{
        
       DefaultTableModel dtm = new DefaultTableModel();
       dtm.addColumn("Game ID");
       dtm.addColumn("Game Title");
       dtm.addColumn("Platform");
       dtm.addColumn("Price");
       dtm.addColumn("Publisher");
       dtm.addColumn("Distributor ID");
       dtm.addColumn("ESRB Rating");
       dtm.addColumn("Quantity");
       this.videogameModel.LikeVideogameID(Integer.parseInt(JtxtGameIDGame.getText())).
               stream().map((videogameID) -> 
               {dtm.addRow(new Object []
               {videogameID.getVideogameId(), videogameID.getGameTitle(),
                videogameID.getPlatform(),videogameID.getPrice(),
                videogameID.getPublisher(),videogameID.getDistributorId(),
                videogameID.getEsrbrating(),videogameID.getQuantity()});
            return videogameID;
        }).forEachOrdered((_item) -> {
            this.JTableVideogame.setModel(dtm);
        });
         }
     catch(Exception e){
     } 
    
}
private  void searchByDistId()
{  
    try{
       DefaultTableModel dtm = new DefaultTableModel();
       dtm.addColumn("Game ID");
       dtm.addColumn("Game Title");
       dtm.addColumn("Platform");
       dtm.addColumn("Price");
       dtm.addColumn("Publisher");
       dtm.addColumn("Distributor ID");
       dtm.addColumn("ESRB Rating");
       dtm.addColumn("Quantity");
       this.videogameModel.LikeDistID(Integer.parseInt
        (jComboBoxDistGame.getSelectedItem().toString())).
               stream().map((videogameDist) -> {
           dtm.addRow(new Object []
           {videogameDist.getVideogameId(), videogameDist.getGameTitle(),
            videogameDist.getPlatform(),videogameDist.getPrice(),
            videogameDist.getPublisher(),videogameDist.getDistributorId(),
            videogameDist.getEsrbrating(),videogameDist.getQuantity()});
            return videogameDist;
        }).forEachOrdered((_item) -> {
            this.JTableVideogame.setModel(dtm);
        });
         }
     catch(Exception e){
     } 
    
}
private void searchByQuantity()
{
    try{
        
       DefaultTableModel dtm = new DefaultTableModel();
       dtm.addColumn("Game ID");
       dtm.addColumn("Game Title");
       dtm.addColumn("Platform");
       dtm.addColumn("Price");
       dtm.addColumn("Publisher");
       dtm.addColumn("Distributor ID");
       dtm.addColumn("ESRB Rating");
       dtm.addColumn("Quantity");
       this.videogameModel.LikeQuantity(Integer.parseInt(JtxtQuantityGame.getText()))
               .stream().map((videogameQuantity) -> {
           dtm.addRow(new Object []
           {videogameQuantity.getVideogameId(), videogameQuantity.getGameTitle(),
            videogameQuantity.getPlatform(),videogameQuantity.getPrice(),
            videogameQuantity.getPublisher(),videogameQuantity.getDistributorId(),
            videogameQuantity.getEsrbrating(),videogameQuantity.getQuantity()});
            return videogameQuantity;
        }).forEachOrdered((_item) -> {
            this.JTableVideogame.setModel(dtm);
        });
         }
     catch(Exception e){
     }  
}
private void searchByPrice()
{
    try{
        
       DefaultTableModel dtm = new DefaultTableModel();
       dtm.addColumn("Game ID");
       dtm.addColumn("Game Title");
       dtm.addColumn("Platform");
       dtm.addColumn("Price");
       dtm.addColumn("Publisher");
       dtm.addColumn("Distributor ID");
       dtm.addColumn("ESRB Rating");
       dtm.addColumn("Quantity");
       this.videogameModel.LikePrice(Double.parseDouble(JtxtPriceGame.getText()))
               .stream().map((videogamePrice) -> {
           dtm.addRow(new Object []
           {videogamePrice.getVideogameId(), videogamePrice.getGameTitle(),
            videogamePrice.getPlatform(),videogamePrice.getPrice(),
            videogamePrice.getPublisher(),videogamePrice.getDistributorId(),
            videogamePrice.getEsrbrating(),videogamePrice.getQuantity()});
            return videogamePrice;
        }).forEachOrdered((_item) -> {
            this.JTableVideogame.setModel(dtm);
        });
         }
     catch(Exception e){
     } 
    
}
private void searchByESRB()
{
    try{
        
       DefaultTableModel dtm = new DefaultTableModel();
       dtm.addColumn("Game ID");
       dtm.addColumn("Game Title");
       dtm.addColumn("Platform");
       dtm.addColumn("Price");
       dtm.addColumn("Publisher");
       dtm.addColumn("Distributor ID");
       dtm.addColumn("ESRB Rating");
       dtm.addColumn("Quantity");
       this.videogameModel.LikeESRB(jComboBoxESRB.getSelectedItem().toString()).
               stream().map((videogameESRB) -> {
           dtm.addRow(new Object []
           {videogameESRB.getVideogameId(), videogameESRB.getGameTitle(),
            videogameESRB.getPlatform(),videogameESRB.getPrice(),
            videogameESRB.getPublisher(),videogameESRB.getDistributorId(),
            videogameESRB.getEsrbrating(),videogameESRB.getQuantity()});
            return videogameESRB;
        }).forEachOrdered((_item) -> {
            this.JTableVideogame.setModel(dtm);
        });
         }
     catch(Exception e){
     } 
    
}
// **************** METHODS FOR VIDEOGAME TABLE END ************************

// METHODS FOR ORDER/SELL TABLE
    private  void searchByGameTitleSell()
{
   try
   {   
       DefaultTableModel dtm = new DefaultTableModel();
       dtm.addColumn("Game ID");
       dtm.addColumn("Game Title");
       dtm.addColumn("Platform");
       dtm.addColumn("Price");
       dtm.addColumn("Publisher");
       dtm.addColumn("Distributor ID");
       dtm.addColumn("ESRB Rating");
       dtm.addColumn("Quantity");
       this.videogameModel.LikeGameTitle(JtxtGameTitleSell.getText()).stream().map((videogameTitle) -> {
           dtm.addRow(new Object []{videogameTitle.getVideogameId(), videogameTitle.getGameTitle(),videogameTitle.getPlatform(),videogameTitle.getPrice(),
               videogameTitle.getPublisher(),videogameTitle.getDistributorId(),videogameTitle.getEsrbrating(),videogameTitle.getQuantity()});
           return videogameTitle;
       }).forEachOrdered((_item) -> {
           this.JTableSell.setModel(dtm);
       });
         }
     catch(Exception e){
     } 
    
    
}

private  void searchByPlatformSell()
{
    try{
       DefaultTableModel dtm = new DefaultTableModel();
       dtm.addColumn("Game ID");
       dtm.addColumn("Game Title");
       dtm.addColumn("Platform");
       dtm.addColumn("Price");
       dtm.addColumn("Publisher");
       dtm.addColumn("Distributor ID");
       dtm.addColumn("ESRB Rating");
       dtm.addColumn("Quantity");
       this.videogameModel.LikePlatform(cmbPlatformSell.getSelectedItem().toString()).stream().map((videogamePlatform) -> {
           dtm.addRow(new Object []{videogamePlatform.getVideogameId(), videogamePlatform.getGameTitle(),videogamePlatform.getPlatform(),videogamePlatform.getPrice(),
               videogamePlatform.getPublisher(),videogamePlatform.getDistributorId(),videogamePlatform.getEsrbrating(),videogamePlatform.getQuantity()});
            return videogamePlatform;
        }).forEachOrdered((_item) -> {
            this.JTableSell.setModel(dtm);
        });
         }
     catch(Exception e){
     } 
    
}
private  void searchByPublisherSell() 
{ 
    try{
       DefaultTableModel dtm = new DefaultTableModel();
       dtm.addColumn("Game ID");
       dtm.addColumn("Game Title");
       dtm.addColumn("Platform");
       dtm.addColumn("Price");
       dtm.addColumn("Publisher");
       dtm.addColumn("Distributor ID");
       dtm.addColumn("ESRB Rating");
       dtm.addColumn("Quantity");
       this.videogameModel.LikePublisher(JtxtPublisherSell.getText()).stream().map((videogamePublisher) -> {
           dtm.addRow(new Object []{videogamePublisher.getVideogameId(), videogamePublisher.getGameTitle(),videogamePublisher.getPlatform(), videogamePublisher.getPrice(),
               videogamePublisher.getPublisher(),videogamePublisher.getDistributorId(),videogamePublisher.getEsrbrating(),videogamePublisher.getQuantity()});
            return videogamePublisher;
        }).forEachOrdered((_item) -> {
            this.JTableSell.setModel(dtm);
        });
         }
     catch(Exception e){
     } 
    
}

private  void searchByDistIdSell()
{  
    try{
       DefaultTableModel dtm = new DefaultTableModel();
       dtm.addColumn("Game ID");
       dtm.addColumn("Game Title");
       dtm.addColumn("Platform");
       dtm.addColumn("Price");
       dtm.addColumn("Publisher");
       dtm.addColumn("Distributor ID");
       dtm.addColumn("ESRB Rating");
       dtm.addColumn("Quantity");
       this.videogameModel.LikeDistID(Integer.parseInt(jComboBoxDistSell.getSelectedItem().toString())).stream().map((videogameDist) -> {
           dtm.addRow(new Object []{videogameDist.getVideogameId(), videogameDist.getGameTitle(),videogameDist.getPlatform(),videogameDist.getPrice(),
               videogameDist.getPublisher(),videogameDist.getDistributorId(),videogameDist.getEsrbrating(),videogameDist.getQuantity()});
            return videogameDist;
        }).forEachOrdered((_item) -> {
            this.JTableSell.setModel(dtm);
        });
         }
     catch(Exception e){
     } 
    
}
private void searchByQuantitySell()
{
    try{
        
       DefaultTableModel dtm = new DefaultTableModel();
       dtm.addColumn("Game ID");
       dtm.addColumn("Game Title");
       dtm.addColumn("Platform");
       dtm.addColumn("Price");
       dtm.addColumn("Publisher");
       dtm.addColumn("Distributor ID");
       dtm.addColumn("ESRB Rating");
       dtm.addColumn("Quantity");
       this.videogameModel.LikeQuantity(Integer.parseInt(JtxtQuantitySell.getText())).stream().map((videogameQuantity) -> {
           dtm.addRow(new Object []{videogameQuantity.getVideogameId(), videogameQuantity.getGameTitle(),videogameQuantity.getPlatform(),videogameQuantity.getPrice(),
               videogameQuantity.getPublisher(),videogameQuantity.getDistributorId(),videogameQuantity.getEsrbrating(),videogameQuantity.getQuantity()});
            return videogameQuantity;
        }).forEachOrdered((_item) -> {
            this.JTableSell.setModel(dtm);
        });
         }
     catch(Exception e){
     }  
}
private void searchByPriceSell()
{
    try{
        
       DefaultTableModel dtm = new DefaultTableModel();
       dtm.addColumn("Game ID");
       dtm.addColumn("Game Title");
       dtm.addColumn("Platform");
       dtm.addColumn("Price");
       dtm.addColumn("Publisher");
       dtm.addColumn("Distributor ID");
       dtm.addColumn("ESRB Rating");
       dtm.addColumn("Quantity");
       this.videogameModel.LikePrice(Double.parseDouble(JtxtPriceSell.getText())).stream().map((videogamePrice) -> {
           dtm.addRow(new Object []{videogamePrice.getVideogameId(), videogamePrice.getGameTitle(),videogamePrice.getPlatform(),videogamePrice.getPrice(),
               videogamePrice.getPublisher(),videogamePrice.getDistributorId(),videogamePrice.getEsrbrating(),videogamePrice.getQuantity()});
            return videogamePrice;
        }).forEachOrdered((_item) -> {
            this.JTableSell.setModel(dtm);
        });
         }
     catch(Exception e){
     } 
    
}
private void searchByESRBSell()
{
    try{
        
       DefaultTableModel dtm = new DefaultTableModel();
       dtm.addColumn("Game ID");
       dtm.addColumn("Game Title");
       dtm.addColumn("Platform");
       dtm.addColumn("Price");
       dtm.addColumn("Publisher");
       dtm.addColumn("Distributor ID");
       dtm.addColumn("ESRB Rating");
       dtm.addColumn("Quantity");
       this.videogameModel.LikeESRB(jComboBoxESRB2.getSelectedItem().toString()).stream().map((videogameESRB) -> {
           dtm.addRow(new Object []{videogameESRB.getVideogameId(), videogameESRB.getGameTitle(),videogameESRB.getPlatform(),videogameESRB.getPrice(),
               videogameESRB.getPublisher(),videogameESRB.getDistributorId(),videogameESRB.getEsrbrating(),videogameESRB.getQuantity()});
            return videogameESRB;
        }).forEachOrdered((_item) -> {
            this.JTableSell.setModel(dtm);
        });
         }
     catch(Exception e){
     } 
    
}
// **************** METHODS FOR VIDEOGAME TABLE END ************************
//METHODS FOR EMPLOYEE TABLE
private  void searchByEmployeeId()
{
   try 
   {   
       DefaultTableModel dtm = new DefaultTableModel();
       dtm.addColumn("Employee ID");
       dtm.addColumn("Name");
       dtm.addColumn("Address");
       dtm.addColumn("Position Name");
       this.employeeModel.LikeEmployeeId(Integer.parseInt(JtxtEmployeeID.getText())).stream().map((employee) -> {
           dtm.addRow(new Object []{employee.getEmployeeId(), employee.getName(),
               employee.getAddress(),employee.getPositionName(),
               });
            return employee;
        }).forEachOrdered((_item) -> {
            this.JTableEmployee.setModel(dtm);
        });
         }
     catch(Exception e){
     } 
}
private  void searchByEmployeeName()
{
   try 
   {   
       DefaultTableModel dtm = new DefaultTableModel();
       dtm.addColumn("Employee ID");
       dtm.addColumn("Name");
       dtm.addColumn("Address");
       dtm.addColumn("Position Name");
       this.employeeModel.LikeEmployeeName(JtxtNameEmployee.getText()).stream().map((employee) -> {
           dtm.addRow(new Object []{employee.getEmployeeId(), employee.getName(),
               employee.getAddress(),employee.getPositionName(),
               });
            return employee;
        }).forEachOrdered((_item) -> {
            this.JTableEmployee.setModel(dtm);
        });
         }
     catch(Exception e){
     } 
}
private  void searchByEmployeeAddress()
{
   try 
   {   
       DefaultTableModel dtm = new DefaultTableModel();
       dtm.addColumn("Employee ID");
       dtm.addColumn("Name");
       dtm.addColumn("Address");
       dtm.addColumn("Position Name");
       this.employeeModel.LikeAddresEmployee(JtxtAddressEmployee.getText()).stream().map((employee) -> {
           dtm.addRow(new Object []{employee.getEmployeeId(), employee.getName(),
               employee.getAddress(),employee.getPositionName(),
               });
            return employee;
        }).forEachOrdered((_item) -> {
            this.JTableEmployee.setModel(dtm);
        });
         }
     catch(Exception e){
     } 
}
private  void searchByEmployeePosition()
{
   try 
   {   
       DefaultTableModel dtm = new DefaultTableModel();
       dtm.addColumn("Employee ID");
       dtm.addColumn("Name");
       dtm.addColumn("Address");
       dtm.addColumn("Position Name");
       this.employeeModel.LikePosition(JtxtPositionEmployee.getText()).stream().map((employee) -> {
           dtm.addRow(new Object []{employee.getEmployeeId(), employee.getName(),
               employee.getAddress(),employee.getPositionName(),
               });
            return employee;
        }).forEachOrdered((_item) -> {
            this.JTableEmployee.setModel(dtm);
        });
         }
     catch(Exception e){
     } 
}
//*****************METHODS FOR EMPLOYEE TABLE END***************************

// **************** METHODS FOR CUSTOMER TABLE  ****************************
private void searchByCustomerId()
{   try
{
     DefaultTableModel dtm = new DefaultTableModel();
       dtm.addColumn("Customer ID");
       dtm.addColumn("Phone Number");
       dtm.addColumn("Name");
       dtm.addColumn("Address");
       this.customerModel.LikeCustomerId(Integer.parseInt(JtxtCustomerIDCustomer.getText())).stream().map((customerId) -> {
           dtm.addRow(new Object []{
               customerId.getCustomerId(), customerId.getPhoneNum(), customerId.getName(),
               customerId.getAddress(), 
               });
            return customerId;
        }).forEachOrdered((_item) -> {
            this.JTableCustomer.setModel(dtm);
        });
         }
     catch(Exception e){
     } 
}

private  void searchByCustomerName()
{
   try 
   {   
       DefaultTableModel dtm = new DefaultTableModel();
       dtm.addColumn("Employee ID");
       dtm.addColumn("Phone Number");
       dtm.addColumn("Name");
       dtm.addColumn("Address");
       this.customerModel.LikeCustomerName(JtxtNameCustomer.getText()).stream().map((customer) -> {
           dtm.addRow(new Object []{ customer.getCustomerId(), customer.getPhoneNum(), customer.getName(),
               customer.getAddress(),
               });
            return customer;
        }).forEachOrdered((_item) -> {
            this.JTableCustomer.setModel(dtm);
        });
         }
     catch(Exception e){
     } 
}
private  void searchByCustomerAddress()
{
   try 
   {   
       DefaultTableModel dtm = new DefaultTableModel();
       dtm.addColumn("Customer ID");
       dtm.addColumn("Phone Number");
       dtm.addColumn("Name");
       dtm.addColumn("Address");
       this.customerModel.LikeAddresCustomer(JtxtAddressCustomer.getText()).stream().map((customer) -> {
           dtm.addRow(new Object []{ customer.getCustomerId(), customer.getPhoneNum(), customer.getName(),
               customer.getAddress(),
               });
            return customer;
        }).forEachOrdered((_item) -> {
            this.JTableCustomer.setModel(dtm);
        });
         }
     catch(Exception e){
     } 
}
private  void searchByPhone()
{
   try 
   {   
       DefaultTableModel dtm = new DefaultTableModel();
       dtm.addColumn("Customer ID");
       dtm.addColumn("Phone Number");
       dtm.addColumn("Name");
       dtm.addColumn("Address");
       this.customerModel.LikePhone(JtxtPhoneCustomer.getText()).stream().map((customer) -> {
           dtm.addRow(new Object []{ customer.getCustomerId(), customer.getPhoneNum(), customer.getName(),
               customer.getAddress(),
               });
            return customer;
        }).forEachOrdered((_item) -> {
            this.JTableCustomer.setModel(dtm);
        });
         }
     catch(Exception e){
     } 
}
//*****************METHODS FOR CUSTOMER TABLE END***************************
private void searchHistoryDate()
{try
{      
       DefaultTableModel dtm = new DefaultTableModel();
       dtm.addColumn("Shipment ID");
       dtm.addColumn("Customer Name");
       dtm.addColumn("Employee Name");
       dtm.addColumn("Game Title");
       dtm.addColumn("Platform");
       dtm.addColumn("Quantity");
       dtm.addColumn("Shipment Date");
       dtm.addColumn("Price");
       this.historyModel.LikeDate(Date.valueOf(JtxtDateHistory.getText())).stream().map((historyDate) -> {
           dtm.addRow(new Object []{ historyDate.getShipmentNum(),historyDate.getCustomer().getName(), historyDate.getEmployee().getName(), historyDate.getVideogame().getGameTitle(),
           historyDate.getVideogame().getPlatform(), historyDate.getQuantity(), historyDate.getShipmentDate(), historyDate.getVideogame().getPrice(),
               });
            return historyDate;
        }).forEachOrdered((_item) -> {
            this.JTableHistory.setModel(dtm);
        });
         }
     catch(Exception e){
     } 
}
private void searchHistoryGame()
{  try
{      
       DefaultTableModel dtm = new DefaultTableModel();
       dtm.addColumn("Shipment ID");
       dtm.addColumn("Customer Name");
       dtm.addColumn("Employee Name");
       dtm.addColumn("Game Title");
       dtm.addColumn("Platform");
       dtm.addColumn("Quantity");
       dtm.addColumn("Shipment Date");
       dtm.addColumn("Price");
       this.historyModel.LikeGameTitle(JtxtGameTitleHistory.getText())
               .stream().map((history) -> 
               {dtm.addRow(new Object []
               {history.getShipmentNum(),history.getCustomer().getName(),
                history.getEmployee().getName(), history.getVideogame().getGameTitle(),
                history.getVideogame().getPlatform(), history.getQuantity(),
                history.getShipmentDate(), history.getVideogame().getPrice(),
               });
            return history;
        }).forEachOrdered((_item) -> {
            this.JTableHistory.setModel(dtm);
        });
         }
     catch(Exception e){
     } 
}
private void searchHistoryPlatform()
{  try
{      
       DefaultTableModel dtm = new DefaultTableModel();
       dtm.addColumn("Shipment ID");
       dtm.addColumn("Customer Name");
       dtm.addColumn("Employee Name");
       dtm.addColumn("Game Title");
       dtm.addColumn("Platform");
       dtm.addColumn("Quantity");
       dtm.addColumn("Shipment Date");
       dtm.addColumn("Price");
        this.historyModel.LikePlatform(cmbPlatformHistory.getSelectedItem()
                .toString()).stream().map((history) -> {
           dtm.addRow(new Object []
          {history.getShipmentNum(),history.getCustomer().getName(), 
           history.getEmployee().getName(), history.getVideogame().getGameTitle(),
           history.getVideogame().getPlatform(), history.getQuantity(),
           history.getShipmentDate(), history.getVideogame().getPrice(),
               });
            return history;
        }).forEachOrdered((_item) -> {
            this.JTableHistory.setModel(dtm);
        });
         }
     catch(Exception e){
     } 
}
//*****************METHODS FOR HISTORY TABLE  ******************************


//*****************METHODS FOR HISTORY TABLE END ***************************

//SEARCH BUTTON METHODS END
       @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelSellOrder = new javax.swing.JPanel();
        GameList1 = new javax.swing.JPanel();
        JtxtGameTitleGame = new javax.swing.JTextField();
        JtxtQuantityGame = new javax.swing.JTextField();
        cmbPlatformGame = new javax.swing.JComboBox<>();
        GameTitleList = new javax.swing.JLabel();
        PublisherList = new javax.swing.JLabel();
        ESRBList = new javax.swing.JLabel();
        PlatformList = new javax.swing.JLabel();
        jButtonSearchGame = new javax.swing.JButton();
        jButtonInsertGame = new javax.swing.JButton();
        jButtonUpdateGame = new javax.swing.JButton();
        jButtonDeleteGame = new javax.swing.JButton();
        JtxtPriceGame = new javax.swing.JTextField();
        QuantityList = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        DistIDList = new javax.swing.JLabel();
        JtxtGameIDGame = new javax.swing.JTextField();
        GameIDList = new javax.swing.JLabel();
        JtxtPublisherGame = new javax.swing.JTextField();
        jButtonClearGame = new javax.swing.JButton();
        jComboBoxESRB = new javax.swing.JComboBox<>();
        jComboBoxDistGame = new javax.swing.JComboBox<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        JTableVideogame = new javax.swing.JTable();
        JTableVideogamePrint = new javax.swing.JButton();
        jPanelGameList = new javax.swing.JPanel();
        GameList = new javax.swing.JPanel();
        JtxtPublisherSell = new javax.swing.JTextField();
        JtxtGameTitleSell = new javax.swing.JTextField();
        JtxtQuantitySell = new javax.swing.JTextField();
        cmbPlatformSell = new javax.swing.JComboBox<>();
        GameTitleSell = new javax.swing.JLabel();
        PublisherSell = new javax.swing.JLabel();
        ESRBSell = new javax.swing.JLabel();
        PlatformSell = new javax.swing.JLabel();
        jButtonOrderSell = new javax.swing.JButton();
        jButtonSellSell = new javax.swing.JButton();
        JtxtPriceSell = new javax.swing.JTextField();
        QuantitySell = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        DistIDSell = new javax.swing.JLabel();
        JtxtGameIDSell = new javax.swing.JTextField();
        GameIDSell = new javax.swing.JLabel();
        JtxtOrderSell = new javax.swing.JTextField();
        ToSell = new javax.swing.JLabel();
        jButtonSearchSell = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBoxESRB2 = new javax.swing.JComboBox<>();
        jComboBoxDistSell = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableSell = new javax.swing.JTable();
        jPanelHistory = new javax.swing.JPanel();
        History = new javax.swing.JPanel();
        JtxtGameTitleHistory = new javax.swing.JTextField();
        JtxtCustomerIDHistory = new javax.swing.JTextField();
        JtxtDateHistory = new javax.swing.JTextField();
        cmbPlatformHistory = new javax.swing.JComboBox<>();
        GameTitleHistory = new javax.swing.JLabel();
        DateHistory = new javax.swing.JLabel();
        CustomerIdHistory = new javax.swing.JLabel();
        PlatformHistory = new javax.swing.JLabel();
        jButtonSearchHistory = new javax.swing.JButton();
        JtxtShipmentNum = new javax.swing.JTextField();
        ShipmentIdHistory = new javax.swing.JLabel();
        JtxtQuantityHistory = new javax.swing.JTextField();
        QuantityHistory = new javax.swing.JLabel();
        JtxtHistoryPrice = new javax.swing.JTextField();
        PriceHistory = new javax.swing.JLabel();
        JtxtTotal = new javax.swing.JTextField();
        Dorra = new javax.swing.JLabel();
        TotalToday = new javax.swing.JLabel();
        jButtonClearHistory = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        JTableHistory = new javax.swing.JTable();
        PrintJTableHistory = new javax.swing.JButton();
        jPanelCustomer = new javax.swing.JPanel();
        Customer = new javax.swing.JPanel();
        JtxtNameCustomer = new javax.swing.JTextField();
        JtxtCustomerIDCustomer = new javax.swing.JTextField();
        JtxtPhoneCustomer = new javax.swing.JTextField();
        CustomerName = new javax.swing.JLabel();
        CustomerIdCustomer = new javax.swing.JLabel();
        PhoneCustomer = new javax.swing.JLabel();
        AddressCustomer = new javax.swing.JLabel();
        JtxtAddressCustomer = new javax.swing.JTextField();
        jButtonDeleteCustomer = new javax.swing.JButton();
        jButtonUpdateCustomer = new javax.swing.JButton();
        jButtonInsertCustomer = new javax.swing.JButton();
        jButtonSearchCustomer = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        JTableCustomer = new javax.swing.JTable();
        PrintJTableCustomer = new javax.swing.JButton();
        Employee = new javax.swing.JPanel();
        jPanelEmployee = new javax.swing.JPanel();
        JtxtNameEmployee = new javax.swing.JTextField();
        JtxtEmployeeID = new javax.swing.JTextField();
        JtxtAddressEmployee = new javax.swing.JTextField();
        JtxtPositionEmployee = new javax.swing.JTextField();
        NameEmployee = new javax.swing.JLabel();
        EmployeeID = new javax.swing.JLabel();
        AddressEmployee = new javax.swing.JLabel();
        PositionEmployee = new javax.swing.JLabel();
        jButtonSearchEmployee = new javax.swing.JButton();
        jButtonInsertEmployee = new javax.swing.JButton();
        jButtonUpdateEmployee = new javax.swing.JButton();
        jButtonDeleteEmployee = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        JTableEmployee = new javax.swing.JTable();
        PrintJTableEmployee = new javax.swing.JButton();
        jLabelUser = new javax.swing.JLabel();
        jLabelUserId = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelPosition = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        Print = new javax.swing.JMenu();
        PrintGameList = new javax.swing.JMenuItem();
        PrintHistory = new javax.swing.JMenuItem();
        PrintCustomer = new javax.swing.JMenuItem();
        PrintEmployee = new javax.swing.JMenuItem();
        LogOut = new javax.swing.JMenuItem();
        Exit = new javax.swing.JMenuItem();
        AccountCreate = new javax.swing.JMenu();
        AccountCreate1 = new javax.swing.JMenuItem();
        AccountDelete = new javax.swing.JMenuItem();
        AccountUpdate = new javax.swing.JMenuItem();
        About = new javax.swing.JMenu();
        About1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Videogame Store v1");
        setPreferredSize(new java.awt.Dimension(1360, 980));

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1280, 720));

        GameList1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        GameList1.setToolTipText("");
        GameList1.setName("Videogame"); // NOI18N
        GameList1.setPreferredSize(new java.awt.Dimension(403, 500));

        JtxtGameTitleGame.setDoubleBuffered(true);

        JtxtQuantityGame.setText("0");

        cmbPlatformGame.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "=none=", "Xbox 360", "PS3", "Wii U", "PC" }));
        cmbPlatformGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPlatformGameActionPerformed(evt);
            }
        });

        GameTitleList.setText("Game Title");
        GameTitleList.setToolTipText("Enter game title");

        PublisherList.setText("Publisher");
        PublisherList.setToolTipText("Enter publisher name");

        ESRBList.setText("ESRB");
        ESRBList.setToolTipText("E, T or M");

        PlatformList.setText("Platform");
        PlatformList.setToolTipText("Select platform");

        jButtonSearchGame.setText("Search");
        jButtonSearchGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchGameActionPerformed(evt);
            }
        });

        jButtonInsertGame.setText("Insert");
        jButtonInsertGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInsertGameActionPerformed(evt);
            }
        });

        jButtonUpdateGame.setText("Update");
        jButtonUpdateGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateGameActionPerformed(evt);
            }
        });

        jButtonDeleteGame.setText("Delete");
        jButtonDeleteGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteGameActionPerformed(evt);
            }
        });

        QuantityList.setText("Quantity");

        jLabel7.setText("Price");

        DistIDList.setText("DistributorID");
        DistIDList.setToolTipText("Set 2 or 3");

        GameIDList.setText("Game ID ");
        GameIDList.setToolTipText("Game ID (can be empty)");

        jButtonClearGame.setText("Clear");
        jButtonClearGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearGameActionPerformed(evt);
            }
        });

        jComboBoxESRB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ESRB", "E", "T", "M" }));

        jComboBoxDistGame.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DistID", "2", "3" }));

        javax.swing.GroupLayout GameList1Layout = new javax.swing.GroupLayout(GameList1);
        GameList1.setLayout(GameList1Layout);
        GameList1Layout.setHorizontalGroup(
            GameList1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GameList1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(GameList1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonClearGame, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(GameList1Layout.createSequentialGroup()
                        .addGroup(GameList1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GameList1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, Short.MAX_VALUE)
                                .addGroup(GameList1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(GameList1Layout.createSequentialGroup()
                                        .addGroup(GameList1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jButtonDeleteGame, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButtonSearchGame, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, GameList1Layout.createSequentialGroup()
                                        .addComponent(JtxtQuantityGame, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(GameList1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(QuantityList)
                                    .addGroup(GameList1Layout.createSequentialGroup()
                                        .addComponent(jButtonInsertGame, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(9, 9, 9)
                                        .addComponent(jButtonUpdateGame))))
                            .addGroup(GameList1Layout.createSequentialGroup()
                                .addGroup(GameList1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(GameList1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(JtxtGameTitleGame, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(JtxtPublisherGame, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, GameList1Layout.createSequentialGroup()
                                            .addGroup(GameList1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(JtxtPriceGame)
                                                .addComponent(cmbPlatformGame, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(GameList1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(GameList1Layout.createSequentialGroup()
                                                    .addComponent(PlatformList, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(36, 36, 36)
                                                    .addComponent(JtxtGameIDGame, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jLabel7))))
                                    .addGroup(GameList1Layout.createSequentialGroup()
                                        .addGroup(GameList1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jComboBoxDistGame, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jComboBoxESRB, 0, 72, Short.MAX_VALUE))
                                        .addGroup(GameList1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(GameList1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(ESRBList, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GameList1Layout.createSequentialGroup()
                                                .addGap(13, 13, 13)
                                                .addComponent(DistIDList, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(17, 17, 17)
                        .addGroup(GameList1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(GameTitleList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PublisherList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(GameIDList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(51, 51, 51))
        );
        GameList1Layout.setVerticalGroup(
            GameList1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GameList1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(GameList1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GameTitleList)
                    .addComponent(JtxtGameTitleGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(GameList1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbPlatformGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PlatformList)
                    .addComponent(JtxtGameIDGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GameIDList))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(GameList1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JtxtPriceGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(GameList1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PublisherList)
                    .addComponent(JtxtPublisherGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(GameList1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DistIDList)
                    .addComponent(jComboBoxDistGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(GameList1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ESRBList)
                    .addComponent(jComboBoxESRB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(GameList1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(QuantityList)
                    .addComponent(JtxtQuantityGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(GameList1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonUpdateGame)
                    .addComponent(jButtonInsertGame)
                    .addComponent(jButtonSearchGame))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDeleteGame)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonClearGame)
                .addContainerGap())
        );

        JTableVideogame.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        JTableVideogame.setColumnSelectionAllowed(true);
        JTableVideogame.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JTableVideogame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableVideogameMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(JTableVideogame);
        JTableVideogame.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (JTableVideogame.getColumnModel().getColumnCount() > 0) {
            JTableVideogame.getColumnModel().getColumn(0).setResizable(false);
            JTableVideogame.getColumnModel().getColumn(0).setPreferredWidth(15);
            JTableVideogame.getColumnModel().getColumn(1).setResizable(false);
            JTableVideogame.getColumnModel().getColumn(1).setPreferredWidth(70);
            JTableVideogame.getColumnModel().getColumn(2).setResizable(false);
            JTableVideogame.getColumnModel().getColumn(2).setPreferredWidth(20);
            JTableVideogame.getColumnModel().getColumn(3).setResizable(false);
            JTableVideogame.getColumnModel().getColumn(3).setPreferredWidth(70);
            JTableVideogame.getColumnModel().getColumn(4).setResizable(false);
            JTableVideogame.getColumnModel().getColumn(4).setPreferredWidth(25);
            JTableVideogame.getColumnModel().getColumn(5).setResizable(false);
            JTableVideogame.getColumnModel().getColumn(5).setPreferredWidth(25);
            JTableVideogame.getColumnModel().getColumn(6).setResizable(false);
            JTableVideogame.getColumnModel().getColumn(6).setPreferredWidth(25);
        }

        JTableVideogamePrint.setText("Print");
        JTableVideogamePrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTableVideogamePrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelSellOrderLayout = new javax.swing.GroupLayout(jPanelSellOrder);
        jPanelSellOrder.setLayout(jPanelSellOrderLayout);
        jPanelSellOrderLayout.setHorizontalGroup(
            jPanelSellOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelSellOrderLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanelSellOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSellOrderLayout.createSequentialGroup()
                        .addComponent(GameList1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE))
                    .addComponent(JTableVideogamePrint, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(99, 99, 99))
        );
        jPanelSellOrderLayout.setVerticalGroup(
            jPanelSellOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSellOrderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSellOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GameList1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTableVideogamePrint)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Game List", jPanelSellOrder);

        GameList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        GameList.setToolTipText("");
        GameList.setName("Videogame"); // NOI18N
        GameList.setPreferredSize(new java.awt.Dimension(403, 500));

        JtxtPublisherSell.setToolTipText("Publisher");

        JtxtGameTitleSell.setDoubleBuffered(true);

        JtxtQuantitySell.setEditable(false);

        cmbPlatformSell.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "=none=", "Xbox 360", "PS3", "Wii U", "PC" }));
        cmbPlatformSell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPlatformSellActionPerformed(evt);
            }
        });

        GameTitleSell.setText("Game Title");
        GameTitleSell.setToolTipText("Enter game title");

        PublisherSell.setText("Publisher");
        PublisherSell.setToolTipText("Enter publisher name");

        ESRBSell.setText("ESRB");
        ESRBSell.setToolTipText("E, T or M");

        PlatformSell.setText("Platform");
        PlatformSell.setToolTipText("Platform");

        jButtonOrderSell.setText("Order");
        jButtonOrderSell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOrderSellActionPerformed(evt);
            }
        });

        jButtonSellSell.setText("Sell");
        jButtonSellSell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSellSellActionPerformed(evt);
            }
        });

        QuantitySell.setText("Quantity");
        QuantitySell.setToolTipText("Total in store");

        jLabel2.setText("Price");
        jLabel2.setToolTipText("Price ($)");

        DistIDSell.setText("DistributorID");
        DistIDSell.setToolTipText("Set 2 or 3");

        JtxtGameIDSell.setEditable(false);

        GameIDSell.setText("Game ID ");
        GameIDSell.setToolTipText("Game ID (can be empty)");

        ToSell.setText("To Order or Sell");
        ToSell.setToolTipText("Enter number of units you want to sell/order");

        jButtonSearchSell.setText("Search");
        jButtonSearchSell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchSellActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a customer" }));

        jComboBoxESRB2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ESRB", "E", "T", "M" }));

        jComboBoxDistSell.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DistID", "2", "3" }));

        javax.swing.GroupLayout GameListLayout = new javax.swing.GroupLayout(GameList);
        GameList.setLayout(GameListLayout);
        GameListLayout.setHorizontalGroup(
            GameListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GameListLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(GameListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GameListLayout.createSequentialGroup()
                        .addGroup(GameListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(GameListLayout.createSequentialGroup()
                                .addComponent(jButtonOrderSell, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonSellSell, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, GameListLayout.createSequentialGroup()
                                .addGroup(GameListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbPlatformSell, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JtxtPriceSell))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(GameListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(GameListLayout.createSequentialGroup()
                                        .addComponent(PlatformSell, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(JtxtGameIDSell, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel2)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, GameListLayout.createSequentialGroup()
                                .addGroup(GameListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, GameListLayout.createSequentialGroup()
                                        .addComponent(JtxtQuantitySell, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(QuantitySell))
                                    .addComponent(JtxtPublisherSell, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JtxtGameTitleSell, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, GameListLayout.createSequentialGroup()
                                        .addGroup(GameListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jComboBoxESRB2, 0, 72, Short.MAX_VALUE)
                                            .addComponent(jComboBoxDistSell, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(GameListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ESRBSell, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(DistIDSell, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(GameListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(GameTitleSell, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PublisherSell, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(GameIDSell, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(52, 52, 52))
                    .addGroup(GameListLayout.createSequentialGroup()
                        .addGroup(GameListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonSearchSell, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(GameListLayout.createSequentialGroup()
                                .addComponent(JtxtOrderSell, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ToSell)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        GameListLayout.setVerticalGroup(
            GameListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GameListLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(GameListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GameTitleSell)
                    .addComponent(JtxtGameTitleSell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(GameListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbPlatformSell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PlatformSell)
                    .addComponent(JtxtGameIDSell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GameIDSell))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(GameListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JtxtPriceSell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(GameListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JtxtPublisherSell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PublisherSell))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(GameListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DistIDSell)
                    .addComponent(jComboBoxDistSell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(GameListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ESRBSell)
                    .addComponent(jComboBoxESRB2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(GameListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(QuantitySell)
                    .addComponent(JtxtQuantitySell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(GameListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JtxtOrderSell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ToSell))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(GameListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOrderSell)
                    .addComponent(jButtonSellSell))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSearchSell)
                .addContainerGap())
        );

        for(String customer : this.customerModel.CustomerName())
        {
            jComboBox1.addItem(customer);
        }

        JTableSell.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        JTableSell.setColumnSelectionAllowed(true);
        JTableSell.setPreferredSize(new java.awt.Dimension(250, 500));
        JTableSell.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableSellMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTableSell);
        JTableSell.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout jPanelGameListLayout = new javax.swing.GroupLayout(jPanelGameList);
        jPanelGameList.setLayout(jPanelGameListLayout);
        jPanelGameListLayout.setHorizontalGroup(
            jPanelGameListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGameListLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(GameList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
                .addGap(99, 99, 99))
        );
        jPanelGameListLayout.setVerticalGroup(
            jPanelGameListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGameListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelGameListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                    .addComponent(GameList, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sell/Order", jPanelGameList);

        History.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        History.setToolTipText("");
        History.setName("Videogame"); // NOI18N
        History.setPreferredSize(new java.awt.Dimension(403, 500));

        JtxtDateHistory.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtxtDateHistoryKeyTyped(evt);
            }
        });

        cmbPlatformHistory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "=none=", "Xbox 360", "PS3", "Wii U", "PC" }));
        cmbPlatformHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPlatformHistoryActionPerformed(evt);
            }
        });

        GameTitleHistory.setText("Game Title");
        GameTitleHistory.setToolTipText("Game title");

        DateHistory.setText("Date ");
        DateHistory.setToolTipText("YYYY-MM-DD");

        CustomerIdHistory.setText("Customer");
        CustomerIdHistory.setToolTipText("Customer ID (see Customer tab)");

        PlatformHistory.setText("Platform");
        PlatformHistory.setToolTipText("Platform");

        jButtonSearchHistory.setText("Search");
        jButtonSearchHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchHistoryActionPerformed(evt);
            }
        });

        ShipmentIdHistory.setText("ShipmentID");
        ShipmentIdHistory.setToolTipText("Your sale number (can be left empty)");

        JtxtQuantityHistory.setEditable(false);

        QuantityHistory.setText("Quantity");
        QuantityHistory.setToolTipText("Number of units sold");

        JtxtHistoryPrice.setEditable(false);

        PriceHistory.setText("Price");
        PriceHistory.setToolTipText("Price ($)");

        JtxtTotal.setEditable(false);
        JtxtTotal.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        Dorra.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Dorra.setText("$");

        TotalToday.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TotalToday.setText("Today's Total:");

        jButtonClearHistory.setText("Clear");
        jButtonClearHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearHistoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout HistoryLayout = new javax.swing.GroupLayout(History);
        History.setLayout(HistoryLayout);
        HistoryLayout.setHorizontalGroup(
            HistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HistoryLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(HistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HistoryLayout.createSequentialGroup()
                        .addComponent(jButtonClearHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(HistoryLayout.createSequentialGroup()
                        .addGroup(HistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(HistoryLayout.createSequentialGroup()
                                .addGroup(HistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(HistoryLayout.createSequentialGroup()
                                        .addComponent(cmbPlatformHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(PlatformHistory)
                                        .addGap(18, 18, 18)
                                        .addComponent(JtxtShipmentNum))
                                    .addGroup(HistoryLayout.createSequentialGroup()
                                        .addGroup(HistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(JtxtQuantityHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(JtxtCustomerIDHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(HistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(CustomerIdHistory)
                                            .addGroup(HistoryLayout.createSequentialGroup()
                                                .addComponent(QuantityHistory)
                                                .addGap(18, 18, 18)
                                                .addGroup(HistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jButtonSearchHistory)
                                                    .addComponent(JtxtDateHistory)))))
                                    .addGroup(HistoryLayout.createSequentialGroup()
                                        .addGroup(HistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(HistoryLayout.createSequentialGroup()
                                                .addComponent(JtxtHistoryPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(PriceHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(JtxtGameTitleHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(HistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DateHistory)
                                    .addComponent(ShipmentIdHistory)
                                    .addComponent(GameTitleHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(HistoryLayout.createSequentialGroup()
                                .addComponent(TotalToday)
                                .addGap(18, 18, 18)
                                .addComponent(JtxtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Dorra)))
                        .addGap(47, 47, 47))))
        );
        HistoryLayout.setVerticalGroup(
            HistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HistoryLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(HistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JtxtGameTitleHistory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GameTitleHistory))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(HistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbPlatformHistory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PlatformHistory)
                    .addComponent(JtxtShipmentNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ShipmentIdHistory))
                .addGap(21, 21, 21)
                .addGroup(HistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CustomerIdHistory)
                    .addComponent(JtxtCustomerIDHistory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(HistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JtxtDateHistory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DateHistory)
                    .addComponent(JtxtQuantityHistory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(QuantityHistory))
                .addGap(18, 18, 18)
                .addGroup(HistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JtxtHistoryPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PriceHistory)
                    .addComponent(jButtonSearchHistory))
                .addGap(18, 18, 18)
                .addGroup(HistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JtxtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TotalToday)
                    .addComponent(Dorra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonClearHistory)
                .addGap(338, 338, 338))
        );

        JtxtTotal.setText(Double.toString(historyModel.TotalToday().get(0)));

        JTableHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        JTableHistory.setPreferredSize(new java.awt.Dimension(525, 800));
        JTableHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableHistoryMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(JTableHistory);

        PrintJTableHistory.setText("Print");
        PrintJTableHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintJTableHistoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelHistoryLayout = new javax.swing.GroupLayout(jPanelHistory);
        jPanelHistory.setLayout(jPanelHistoryLayout);
        jPanelHistoryLayout.setHorizontalGroup(
            jPanelHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanelHistoryLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanelHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PrintJTableHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelHistoryLayout.createSequentialGroup()
                        .addComponent(History, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)))
                .addGap(99, 99, 99))
        );
        jPanelHistoryLayout.setVerticalGroup(
            jPanelHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHistoryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(History, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PrintJTableHistory)
                .addGap(165, 165, 165))
        );

        jTabbedPane1.addTab("History", jPanelHistory);

        Customer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Customer.setToolTipText("");
        Customer.setName("Videogame"); // NOI18N
        Customer.setPreferredSize(new java.awt.Dimension(403, 500));

        CustomerName.setText("Name");
        CustomerName.setToolTipText("Enter cusomer name");

        CustomerIdCustomer.setText("Customer ID");
        CustomerIdCustomer.setToolTipText("Customer ID");

        PhoneCustomer.setText("Phone");
        PhoneCustomer.setToolTipText("Enter customer phone number");

        AddressCustomer.setText("Address");
        AddressCustomer.setToolTipText("Enter customer address");

        jButtonDeleteCustomer.setText("Delete");
        jButtonDeleteCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteCustomerActionPerformed(evt);
            }
        });

        jButtonUpdateCustomer.setText("Update");
        jButtonUpdateCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateCustomerActionPerformed(evt);
            }
        });

        jButtonInsertCustomer.setText("Insert");
        jButtonInsertCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInsertCustomerActionPerformed(evt);
            }
        });

        jButtonSearchCustomer.setText("Search");
        jButtonSearchCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CustomerLayout = new javax.swing.GroupLayout(Customer);
        Customer.setLayout(CustomerLayout);
        CustomerLayout.setHorizontalGroup(
            CustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CustomerLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(CustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(CustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(CustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(JtxtAddressCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(CustomerLayout.createSequentialGroup()
                                .addGroup(CustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonDeleteCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonSearchCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonInsertCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonUpdateCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(JtxtPhoneCustomer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JtxtCustomerIDCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JtxtNameCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CustomerName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CustomerIdCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PhoneCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AddressCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        CustomerLayout.setVerticalGroup(
            CustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CustomerLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(CustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JtxtNameCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CustomerName))
                .addGap(21, 21, 21)
                .addGroup(CustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CustomerIdCustomer)
                    .addComponent(JtxtCustomerIDCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(CustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JtxtPhoneCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PhoneCustomer))
                .addGap(21, 21, 21)
                .addGroup(CustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddressCustomer)
                    .addComponent(JtxtAddressCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonUpdateCustomer)
                    .addComponent(jButtonInsertCustomer)
                    .addComponent(jButtonSearchCustomer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDeleteCustomer)
                .addGap(388, 388, 388))
        );

        JTableCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        JTableCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableCustomerMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(JTableCustomer);

        PrintJTableCustomer.setText("Print");
        PrintJTableCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintJTableCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCustomerLayout = new javax.swing.GroupLayout(jPanelCustomer);
        jPanelCustomer.setLayout(jPanelCustomerLayout);
        jPanelCustomerLayout.setHorizontalGroup(
            jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCustomerLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PrintJTableCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelCustomerLayout.createSequentialGroup()
                        .addComponent(Customer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)))
                .addGap(99, 99, 99))
        );
        jPanelCustomerLayout.setVerticalGroup(
            jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCustomerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Customer, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PrintJTableCustomer)
                .addContainerGap(165, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Customer", jPanelCustomer);

        jPanelEmployee.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelEmployee.setToolTipText("");
        jPanelEmployee.setName("Videogame"); // NOI18N
        jPanelEmployee.setPreferredSize(new java.awt.Dimension(403, 500));

        NameEmployee.setText("Name");
        NameEmployee.setToolTipText("Enter employee name");

        EmployeeID.setText("EmployeeID");
        EmployeeID.setToolTipText("Employee ID (can be empty)");

        AddressEmployee.setText("Address");
        AddressEmployee.setToolTipText("Enter employee address");

        PositionEmployee.setText("Position");
        PositionEmployee.setToolTipText("Employee position");

        jButtonSearchEmployee.setText("Search");
        jButtonSearchEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchEmployeeActionPerformed(evt);
            }
        });

        jButtonInsertEmployee.setText("Insert");
        jButtonInsertEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInsertEmployeeActionPerformed(evt);
            }
        });

        jButtonUpdateEmployee.setText("Update");
        jButtonUpdateEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateEmployeeActionPerformed(evt);
            }
        });

        jButtonDeleteEmployee.setText("Delete");
        jButtonDeleteEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteEmployeeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelEmployeeLayout = new javax.swing.GroupLayout(jPanelEmployee);
        jPanelEmployee.setLayout(jPanelEmployeeLayout);
        jPanelEmployeeLayout.setHorizontalGroup(
            jPanelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEmployeeLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelEmployeeLayout.createSequentialGroup()
                        .addGroup(jPanelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonSearchEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonDeleteEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonInsertEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonUpdateEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(JtxtPositionEmployee)
                    .addComponent(JtxtAddressEmployee)
                    .addComponent(JtxtEmployeeID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JtxtNameEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NameEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EmployeeID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PositionEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AddressEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanelEmployeeLayout.setVerticalGroup(
            jPanelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEmployeeLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JtxtNameEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NameEmployee))
                .addGap(21, 21, 21)
                .addGroup(jPanelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JtxtEmployeeID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EmployeeID))
                .addGap(21, 21, 21)
                .addGroup(jPanelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JtxtAddressEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddressEmployee))
                .addGap(21, 21, 21)
                .addGroup(jPanelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PositionEmployee)
                    .addComponent(JtxtPositionEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSearchEmployee)
                    .addComponent(jButtonInsertEmployee)
                    .addComponent(jButtonUpdateEmployee))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDeleteEmployee)
                .addGap(388, 388, 388))
        );

        JTableEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        JTableEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableEmployeeMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(JTableEmployee);

        PrintJTableEmployee.setText("Print");
        PrintJTableEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintJTableEmployeeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EmployeeLayout = new javax.swing.GroupLayout(Employee);
        Employee.setLayout(EmployeeLayout);
        EmployeeLayout.setHorizontalGroup(
            EmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EmployeeLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(EmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PrintJTableEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(EmployeeLayout.createSequentialGroup()
                        .addComponent(jPanelEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)))
                .addGap(99, 99, 99))
        );
        EmployeeLayout.setVerticalGroup(
            EmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EmployeeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                    .addComponent(jScrollPane5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PrintJTableEmployee)
                .addContainerGap(165, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Employee", Employee);

        jLabelUser.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabelUser.setToolTipText("Logged in as");
        jLabelUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelUserId.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabelUserId.setToolTipText("ID");
        jLabelUserId.setBorder(null);

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel1.setText("Employee ID :");

        jLabelPosition.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

        File.setText("File");

        Print.setText("Print");

        PrintGameList.setText("Game List");
        PrintGameList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintGameListActionPerformed(evt);
            }
        });
        Print.add(PrintGameList);

        PrintHistory.setText("History");
        Print.add(PrintHistory);

        PrintCustomer.setText("Customer");
        Print.add(PrintCustomer);

        PrintEmployee.setText("Employee");
        Print.add(PrintEmployee);

        File.add(Print);

        LogOut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        LogOut.setText("Log Out");
        LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutActionPerformed(evt);
            }
        });
        File.add(LogOut);

        Exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        File.add(Exit);

        jMenuBar2.add(File);

        AccountCreate.setText("Account");

        AccountCreate1.setText("Add Account");
        AccountCreate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccountCreate1ActionPerformed(evt);
            }
        });
        AccountCreate.add(AccountCreate1);

        AccountDelete.setText("Delete Account");
        AccountDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccountDeleteActionPerformed(evt);
            }
        });
        AccountCreate.add(AccountDelete);

        AccountUpdate.setText("Update Account");
        AccountUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccountUpdateActionPerformed(evt);
            }
        });
        AccountCreate.add(AccountUpdate);

        jMenuBar2.add(AccountCreate);

        About.setText("About");

        About1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        About1.setText("About");
        About1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                About1ActionPerformed(evt);
            }
        });
        About.add(About1);

        jMenuBar2.add(About);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1348, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelPosition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelUserId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSearchEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchEmployeeActionPerformed
        searchByEmployeeName();
        searchByEmployeeId();
        if(JtxtEmployeeID.getText().equals("")&&JtxtNameEmployee.getText().equals(""))
            searchByEmployeeAddress();
        if(JtxtEmployeeID.getText().equals("")&&JtxtNameEmployee.getText().equals("")
           &&JtxtAddressEmployee.getText().equals(""))
         searchByEmployeePosition();
         ClearFieldsEmployeeTab();
    }//GEN-LAST:event_jButtonSearchEmployeeActionPerformed

    private void jButtonInsertEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertEmployeeActionPerformed
    try{ if(!this.jLabelPosition.getText().equals("Manager"))
    {JOptionPane.showMessageDialog(null, "You are not the manager");
        NewHibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
    }
        else
    {Employee employee = new Employee();
        employee.setName(this.JtxtNameEmployee.getText());
        employee.setAddress(this.JtxtAddressEmployee.getText());
        employee.setPositionName(this.JtxtPositionEmployee.getText());
        if( JtxtNameEmployee.getText().equals("") || JtxtAddressEmployee.getText().equals("") || 
                JtxtPositionEmployee.getText().equals("")) 
        {JOptionPane.showMessageDialog(null, "Fill all the fields!");}
        else{this.employeeModel.create(employee);
        JOptionPane.showMessageDialog(null, "Successfully added new employee!");
        FillDataEmployee();
        ClearFieldsEmployeeTab();
        }
        }
    }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }    }//GEN-LAST:event_jButtonInsertEmployeeActionPerformed

    private void jButtonOrderSellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOrderSellActionPerformed
          try{
            int result = JOptionPane.showConfirmDialog(null, "Are you sure?",
               "Confirm?", JOptionPane.YES_NO_OPTION);
       if(result == JOptionPane.YES_OPTION)
       { Videogame videogame = new Videogame();
       videogame.setVideogameId(Integer.parseInt(this.JtxtGameIDSell.getText()));
       videogame.setGameTitle(this.JtxtGameTitleSell.getText());
        videogame.setPlatform(this.cmbPlatformSell.getSelectedItem().toString());
        videogame.setPrice(Double.parseDouble(this.JtxtPriceSell.getText()));
        videogame.setPublisher(this.JtxtPublisherSell.getText());
        videogame.setDistributorId(Integer.parseInt(this.jComboBoxDistGame.getSelectedItem().toString()));
        videogame.setEsrbrating(this.jComboBoxESRB2.getSelectedItem().toString());
        videogame.setQuantity(Integer.parseInt(this.JtxtQuantitySell.getText()) + Integer.parseInt(this.JtxtOrderSell.getText()));
        this.videogameModel.update(videogame);
        FillData();
        FillDataSell();
        JOptionPane.showMessageDialog(null, "Successfully updated!");
         }
       }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
ClearFieldsSellTab();   

        
    }//GEN-LAST:event_jButtonOrderSellActionPerformed
//Using SELL button automatically inserts data into History table
    private void jButtonSellSellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSellSellActionPerformed
            try{
            int result = JOptionPane.showConfirmDialog(null, "Are you sure?",
               "Confirm?", JOptionPane.YES_NO_OPTION);
       if(result == JOptionPane.YES_OPTION)
       { Videogame videogame = new Videogame();
       videogame.setVideogameId(Integer.parseInt(this.JtxtGameIDSell.getText()));
       videogame.setGameTitle(this.JtxtGameTitleSell.getText());
        videogame.setPlatform(this.cmbPlatformSell.getSelectedItem().toString());
        videogame.setPrice(Double.parseDouble(this.JtxtPriceSell.getText()));
        videogame.setPublisher(this.JtxtPublisherSell.getText());
        videogame.setDistributorId(Integer.parseInt(this.jComboBoxDistSell.getSelectedItem().toString()));
        videogame.setEsrbrating(this.jComboBoxESRB2.getSelectedItem().toString());
        videogame.setQuantity(Integer.parseInt(this.JtxtQuantitySell.getText())-Integer.parseInt(this.JtxtOrderSell.getText()));
        String customerId = jComboBox1.getSelectedItem().toString();
        if(!customerModel.CustomerName().contains(customerId)||jComboBox1.getSelectedItem().equals("Select a customer"))
        {   
            JOptionPane.showMessageDialog(null, "Please select a customer");
            NewHibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
        }
        else{ 
            this.videogameModel.update(videogame);
            FillData();
            FillDataSell();
            JOptionPane.showMessageDialog(null, "Successfully updated!");}
            History shipment = new History();
            Customer customer1 = new Customer();
            Employee employee = new Employee();
            employee.setEmployeeId(Integer.parseInt(jLabelUserId.getText()));
            employee.setName(jLabelUser.getText());
            customer1.setCustomerId(customerModel.SellId(customerId).get(0));
            customer1.setName(jComboBox1.getSelectedItem().toString());
            shipment.setCustomer(customer1);
            shipment.setVideogame(videogame);
            shipment.setVideogame(videogame);
            shipment.setEmployee(employee);
            shipment.setQuantity(Integer.parseInt(this.JtxtOrderSell.getText()));
            shipment.setShipmentDate(java.util.Date.from(Instant.now()));
            shipment.setVideogame(videogame);
            this.historyModel.create(shipment);
            FillDataHistory();
            JtxtTotal.setText(Double.toString(historyModel.TotalToday().get(0)));
       }
       }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
      ClearFieldsSellTab();
    
    }//GEN-LAST:event_jButtonSellSellActionPerformed
private void DeleteGame()
{int result = JOptionPane.showConfirmDialog(null, "Are you sure?",
               "Confirm?", JOptionPane.YES_NO_OPTION);
       if(result == JOptionPane.YES_OPTION)
    try
      {
           int index = this.JTableVideogame.getSelectedRow();
           int videogameId = (int) this.JTableVideogame.getValueAt(index, 0);
           Videogame videogame = this.videogameModel.find(videogameId);
           this.videogameModel.delete(videogame);
           FillData();
           FillDataSell();
           ClearFields();
       }
      
      catch(Exception e){
          JOptionPane.showMessageDialog(null, "Delete not completed");
      }
}
    private void jButtonUpdateEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateEmployeeActionPerformed
try{
       int result = JOptionPane.showConfirmDialog(null, "Are you sure?",
                    "Confirm?", JOptionPane.YES_NO_OPTION);
       if(result == JOptionPane.YES_OPTION)
       { Employee employee = new Employee();
         employee.setEmployeeId(Integer.parseInt(JtxtEmployeeID.getText()));
         employee.setName(this.JtxtNameEmployee.getText());
         employee.setAddress(this.JtxtAddressEmployee.getText());
         employee.setPositionName(this.JtxtPositionEmployee.getText());
         this.employeeModel.update(employee);
         FillDataEmployee();
         JOptionPane.showMessageDialog(null, "Successfully updated!");
         ClearFieldsEmployeeTab();
         }
       }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }    }//GEN-LAST:event_jButtonUpdateEmployeeActionPerformed

    private void jButtonDeleteEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteEmployeeActionPerformed

     int result = JOptionPane.showConfirmDialog(null, "Are you sure?",
                  "Confirm?", JOptionPane.YES_NO_OPTION);
       if(result == JOptionPane.YES_OPTION)
    try
      {
          if(!this.jLabelPosition.getText().equals("Manager"))
    {JOptionPane.showMessageDialog(null, "You are not the manager");
        NewHibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
    }
        else
          {int index = this.JTableEmployee.getSelectedRow();
           int employeeId = (int) this.JTableEmployee.getValueAt(index, 0);
           Employee employee = this.employeeModel.find(employeeId);
           this.employeeModel.delete(employee);
           FillDataEmployee();
           ClearFieldsEmployeeTab();
       }
      }
      catch(Exception e){
          JOptionPane.showMessageDialog(null, "Delete not completed");}
          }//GEN-LAST:event_jButtonDeleteEmployeeActionPerformed

   
    private void cmbPlatformSellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPlatformSellActionPerformed
        Videogame videogame = new Videogame();
        if(cmbPlatformSell.getSelectedItem().equals("Xbox 360"))
            videogame.setPlatform("Xbox 360");
        else if (cmbPlatformSell.getSelectedItem().equals("PS3"))
            videogame.setPlatform("PS3");
        else if(cmbPlatformSell.getSelectedItem().equals("Wii U"))
            videogame.setPlatform("Wii U");
        else if(cmbPlatformSell.getSelectedItem().equals("PC"))
            videogame.setPlatform("PC");
    }//GEN-LAST:event_cmbPlatformSellActionPerformed

    private void JTableSellMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableSellMouseClicked
        
        try
        {
           int index = this.JTableSell.getSelectedRow();
           int videogameId = (int) this.JTableSell.getValueAt(index, 0);
           Videogame videogame = this.videogameModel.find(videogameId);
           this.cmbPlatformSell.setSelectedItem(videogame.getPlatform());
           this.JtxtGameIDSell.setText(videogame.getVideogameId().toString());
           this.JtxtGameTitleSell.setText(videogame.getGameTitle());
           this.JtxtPriceSell.setText(Double.toString(videogame.getPrice()));
           this.JtxtPublisherSell.setText(videogame.getPublisher());
           this.jComboBoxDistSell.setSelectedItem(videogame.getDistributorId().toString());
           this.jComboBoxESRB2.setSelectedItem(videogame.getEsrbrating());
           this.JtxtQuantitySell.setText(videogame.getQuantity().toString());
        }
      catch(Exception e){
          JOptionPane.showMessageDialog(null, e);
      }
    }//GEN-LAST:event_JTableSellMouseClicked

    private void cmbPlatformGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPlatformGameActionPerformed
        Videogame videogame = new Videogame();
        if(cmbPlatformGame.getSelectedItem().equals("Xbox 360"))
            videogame.setPlatform("Xbox 360");
        else if (cmbPlatformGame.getSelectedItem().equals("PS3"))
            videogame.setPlatform("PS3");
        else if(cmbPlatformGame.getSelectedItem().equals("Wii U"))
            videogame.setPlatform("Wii U");
        else if(cmbPlatformGame.getSelectedItem().equals("PC"))
            videogame.setPlatform("PC");
    }//GEN-LAST:event_cmbPlatformGameActionPerformed

    private void jButtonSearchGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchGameActionPerformed
   
    searchByGameTitle();
    searchByPlatform();
    searchByGameId();
    searchByDistId();
    searchByESRB();
    if( JtxtGameTitleGame.getText().equals("") && JtxtPriceGame.getText().equals("") &&
 jComboBoxESRB.getSelectedItem().equals("ESRB") && jComboBoxDistGame.getSelectedItem().equals("DistID")
            && cmbPlatformGame.getSelectedItem().equals("=none=")&&JtxtGameIDGame.getText().equals(""))
    searchByPublisher();
    searchByPrice();
    ClearFields();
    }//GEN-LAST:event_jButtonSearchGameActionPerformed

    private void jButtonInsertGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertGameActionPerformed
        try{
        Videogame videogame = new Videogame();
        videogame.setGameTitle(this.JtxtGameTitleGame.getText());
        videogame.setPlatform(this.cmbPlatformGame.getSelectedItem().toString());
        videogame.setPrice(Double.parseDouble(this.JtxtPriceGame.getText()));
        videogame.setPublisher(this.JtxtPublisherGame.getText());
        videogame.setDistributorId(Integer.parseInt(this.jComboBoxDistGame.getSelectedItem().toString()));
        videogame.setEsrbrating(this.jComboBoxESRB.getSelectedItem().toString());
        videogame.setQuantity(Integer.parseInt(this.JtxtQuantityGame.getText()));
        if( JtxtGameTitleGame.getText().equals("") || JtxtPriceGame.getText().equals("") || 
                JtxtPublisherGame.getText().equals("") || jComboBoxESRB.getSelectedItem().equals("ESRB")
                || jComboBoxDistGame.getSelectedItem().equals("DistID")                )
        {
       JOptionPane.showMessageDialog(null, "Fill all the fields!");}
         else {
            this.videogameModel.create(videogame);
            FillData();
            FillDataSell();
            }
        JOptionPane.showMessageDialog(null, "Successfully added new game!");
        ClearFields();
        }
        
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_jButtonInsertGameActionPerformed

    private void jButtonUpdateGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateGameActionPerformed
         
       
       try{
            int result = JOptionPane.showConfirmDialog(null, "Are you sure?",
               "Confirm?", JOptionPane.YES_NO_OPTION);
       if(result == JOptionPane.YES_OPTION)
       { Videogame videogame = new Videogame();
       videogame.setVideogameId(Integer.parseInt(this.JtxtGameIDGame.getText()));
       videogame.setGameTitle(this.JtxtGameTitleGame.getText());
        videogame.setPlatform(this.cmbPlatformGame.getSelectedItem().toString());
        videogame.setPrice(Double.parseDouble(this.JtxtPriceGame.getText()));
        videogame.setPublisher(this.JtxtPublisherGame.getText());
        videogame.setDistributorId(Integer.parseInt(this.jComboBoxDistGame.getSelectedItem().toString()));
        videogame.setEsrbrating(this.jComboBoxESRB.getSelectedItem().toString());
        videogame.setQuantity(Integer.parseInt(this.JtxtQuantityGame.getText()));
        this.videogameModel.update(videogame);
            FillData();
        JOptionPane.showMessageDialog(null, "Successfully updated!");
         }
       }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
       
    }//GEN-LAST:event_jButtonUpdateGameActionPerformed

    private void jButtonDeleteGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteGameActionPerformed
        DeleteGame();
    }//GEN-LAST:event_jButtonDeleteGameActionPerformed

    private void JTableVideogameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableVideogameMouseClicked
          
        try
        {
           int index = this.JTableVideogame.getSelectedRow();
           int videogameId = (int) this.JTableVideogame.getValueAt(index, 0);
           Videogame videogame = this.videogameModel.find(videogameId);
           this.cmbPlatformGame.setSelectedItem(videogame.getPlatform());
           this.JtxtGameIDGame.setText(videogame.getVideogameId().toString());
           this.JtxtGameTitleGame.setText(videogame.getGameTitle());
           this.JtxtPriceGame.setText(Double.toString(videogame.getPrice()));
           this.JtxtPublisherGame.setText(videogame.getPublisher());
           this.jComboBoxDistGame.setSelectedItem(videogame.getDistributorId().toString());
           this.jComboBoxESRB.setSelectedItem(videogame.getEsrbrating());
           this.JtxtQuantityGame.setText(videogame.getQuantity().toString());

        }
      catch(Exception e){
          JOptionPane.showMessageDialog(null, e);
      }
    }//GEN-LAST:event_JTableVideogameMouseClicked

    private void JTableHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableHistoryMouseClicked
        try
        {
           int index = this.JTableHistory.getSelectedRow();
           int shipmentNum = (int) this.JTableHistory.getValueAt(index, 0);
           History shipment = this.historyModel.find(shipmentNum);
           this.JtxtShipmentNum.setText(Integer.toString(shipment.getShipmentNum()));
           this.JtxtGameTitleHistory.setText(shipment.getVideogame().getGameTitle());
           this.JtxtCustomerIDHistory.setText(shipment.getCustomer().getCustomerId().toString());
           this.JtxtQuantityHistory.setText(Integer.toString(shipment.getQuantity()));
           this.JtxtDateHistory.setText(shipment.getShipmentDate().toString());
           this.cmbPlatformHistory.setSelectedItem(shipment.getVideogame().getPlatform());
           this.JtxtHistoryPrice.setText(Double.toString(shipment.getVideogame().getPrice()));
        }
      catch(Exception e){
          JOptionPane.showMessageDialog(null, e);
      }
    }//GEN-LAST:event_JTableHistoryMouseClicked

    private void jButtonClearGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearGameActionPerformed
ClearFields();    }//GEN-LAST:event_jButtonClearGameActionPerformed

    private void JTableEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableEmployeeMouseClicked
 try
        {
           int index = this.JTableEmployee.getSelectedRow();
           int employeeId = (int) this.JTableEmployee.getValueAt(index, 0);
           Employee employee = this.employeeModel.find(employeeId);
           this.JtxtEmployeeID.setText(Integer.toString(employee.getEmployeeId()));
           this.JtxtNameEmployee.setText(employee.getName());
           this.JtxtAddressEmployee.setText(employee.getAddress());
           this.JtxtPositionEmployee.setText(employee.getPositionName());
        }
      catch(Exception e){
          JOptionPane.showMessageDialog(null, e);
      }    }//GEN-LAST:event_JTableEmployeeMouseClicked

    private void JTableCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableCustomerMouseClicked
       try
        {
           int index = this.JTableCustomer.getSelectedRow();
           int customerId = (int) this.JTableCustomer.getValueAt(index, 0);
           Customer customer = this.customerModel.find(customerId);
           this.JtxtNameCustomer.setText(customer.getName());
           this.JtxtPhoneCustomer.setText(customer.getPhoneNum());
           this.JtxtCustomerIDCustomer.setText(customer.getCustomerId().toString());
           this.JtxtAddressCustomer.setText(customer.getAddress());
        }
      catch(Exception e){
          JOptionPane.showMessageDialog(null, e);
      }    }//GEN-LAST:event_JTableCustomerMouseClicked

    private void About1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_About1ActionPerformed
       JOptionPane.showMessageDialog(null, "Author:    Doan Selmani\nContact:  doan.selmani@gmail.com\n"
               + "Project:    Videogamestore GUI app with Hibernate\nGroup:     g7");
    }//GEN-LAST:event_About1ActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed
//Some printing tables code, FIT_WIDTH to print on one paper
    private void JTableVideogamePrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTableVideogamePrintActionPerformed
   MessageFormat header = new MessageFormat("Game List");  
   MessageFormat footer = new MessageFormat("Page{0, number, integer}");   
   try{
       JTableVideogame.print(JTable.PrintMode.FIT_WIDTH, header, footer);
    }
   catch(java.awt.print.PrinterException e){
       System.err.format("Cannot complete Print", e.getMessage());
   }
    }//GEN-LAST:event_JTableVideogamePrintActionPerformed

    private void PrintJTableHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintJTableHistoryActionPerformed
MessageFormat header = new MessageFormat("History");  
   MessageFormat footer = new MessageFormat("Page{0, number, integer}");   
   try{
       JTableHistory.print(JTable.PrintMode.FIT_WIDTH, header, footer);
    }
   catch(java.awt.print.PrinterException e){
       System.err.format("Cannot complete Print", e.getMessage());
      }    }//GEN-LAST:event_PrintJTableHistoryActionPerformed

    private void PrintJTableCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintJTableCustomerActionPerformed
        MessageFormat header = new MessageFormat("List of Customers");  
   MessageFormat footer = new MessageFormat("Page{0, number, integer}");   
   try{
       JTableCustomer.print(JTable.PrintMode.FIT_WIDTH, header, footer);
    }
   catch(java.awt.print.PrinterException e){
       System.err.format("Cannot complete Print", e.getMessage());
   }
    }//GEN-LAST:event_PrintJTableCustomerActionPerformed

    private void PrintJTableEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintJTableEmployeeActionPerformed
        MessageFormat header = new MessageFormat("List of Employees");  
   MessageFormat footer = new MessageFormat("Page{0, number, integer}");   
   try{
       JTableEmployee.print(JTable.PrintMode.FIT_WIDTH, header, footer);
    }
   catch(java.awt.print.PrinterException e){
       System.err.format("Cannot complete Print", e.getMessage());
   }
    }//GEN-LAST:event_PrintJTableEmployeeActionPerformed

    private void PrintGameListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintGameListActionPerformed
        JTableVideogamePrintActionPerformed(evt);
    }//GEN-LAST:event_PrintGameListActionPerformed

    private void AccountDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccountDeleteActionPerformed
        if(!this.jLabelPosition.getText().equals("Manager"))
        JOptionPane.showMessageDialog(null, "You are not the manager");
        else
        new AccountDelete().setVisible(true);
    }//GEN-LAST:event_AccountDeleteActionPerformed

    private void AccountCreate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccountCreate1ActionPerformed
        if(!this.jLabelPosition.getText().equals("Manager"))
        JOptionPane.showMessageDialog(null, "You are not the manager");
        else
        new AccountCreate().setVisible(true);
    }//GEN-LAST:event_AccountCreate1ActionPerformed

    private void AccountUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccountUpdateActionPerformed
         if(!this.jLabelPosition.getText().equals("Manager"))
        JOptionPane.showMessageDialog(null, "You are not the manager");
        else
        new AccountUpdate().setVisible(true);
    }//GEN-LAST:event_AccountUpdateActionPerformed

    private void jButtonSearchCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchCustomerActionPerformed

        if(JtxtAddressCustomer.getText().equals("")&&JtxtNameCustomer.getText().equals("")&&JtxtPhoneCustomer.getText().equals(""))
        searchByCustomerId();
        if(JtxtNameCustomer.getText().equals("")&&JtxtCustomerIDCustomer.getText().equals("")&&JtxtPhoneCustomer.getText().equals(""))
        searchByCustomerAddress();
        if(JtxtAddressCustomer.getText().equals("")&&JtxtCustomerIDCustomer.getText().equals("")&&JtxtAddressCustomer.getText().equals(""))
        searchByPhone();
        if(JtxtAddressCustomer.getText().equals("")&&JtxtCustomerIDCustomer.getText().equals("")&&JtxtPhoneCustomer.getText().equals(""))
        searchByCustomerName();
        ClearFieldsCustomerTab();
    }//GEN-LAST:event_jButtonSearchCustomerActionPerformed

    private void jButtonInsertCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertCustomerActionPerformed
        try{
            Customer customer = new Customer();
            customer.setName(this.JtxtNameCustomer.getText());
            customer.setAddress(this.JtxtAddressCustomer.getText());
            customer.setPhoneNum(this.JtxtPhoneCustomer.getText());
            if( JtxtNameCustomer.getText().equals("") || JtxtAddressCustomer.getText().equals("") ||
                JtxtPhoneCustomer.getText().equals(""))
            {JOptionPane.showMessageDialog(null, "Fill all the fields!");}
            else{
                this.customerModel.create(customer);
                JOptionPane.showMessageDialog(null, "Successfully added new customer!");
                FillDataCustomer();
                ClearFieldsCustomerTab();
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButtonInsertCustomerActionPerformed

    private void jButtonUpdateCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateCustomerActionPerformed
        try
        {
            int result = JOptionPane.showConfirmDialog(null, "Are you sure?",
                "Confirm?", JOptionPane.YES_NO_OPTION);
            if(result == JOptionPane.YES_OPTION)
            {Customer customer = new Customer();
                customer.setCustomerId(Integer.parseInt(JtxtCustomerIDCustomer.getText()));
                customer.setName(this.JtxtNameCustomer.getText());
                customer.setAddress(this.JtxtAddressCustomer.getText());
                customer.setPhoneNum(this.JtxtPhoneCustomer.getText());
                this.customerModel.update(customer);
                FillDataCustomer();
                JOptionPane.showMessageDialog(null, "Successfully updated!");
                ClearFieldsCustomerTab();
                this.jComboBox1.removeItem(JtxtNameCustomer.getText());
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());}
    }//GEN-LAST:event_jButtonUpdateCustomerActionPerformed

    private void jButtonDeleteCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteCustomerActionPerformed

        int result = JOptionPane.showConfirmDialog(null, "Are you sure?",
            "Confirm?", JOptionPane.YES_NO_OPTION);
        if(result == JOptionPane.YES_OPTION)
        try
        {
            int index = this.JTableCustomer.getSelectedRow();
            int customerId = (int) this.JTableCustomer.getValueAt(index, 0);
            Customer customer = this.customerModel.find(customerId);
            this.customerModel.delete(customer);
            FillDataCustomer();
            ClearFieldsCustomerTab();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButtonDeleteCustomerActionPerformed

    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutActionPerformed
       int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?",
       "Confirm?", JOptionPane.YES_NO_OPTION);
       if(result == JOptionPane.YES_OPTION)        
       {   
           JOptionPane.showMessageDialog(null, "You have been logged out");
           dispose();
       }
        new Login().setVisible(true);
    }//GEN-LAST:event_LogOutActionPerformed

    private void jButtonSearchHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchHistoryActionPerformed
        searchHistoryDate();
        if(JtxtDateHistory.getText().equals("")&&
           cmbPlatformHistory.getSelectedItem().toString().equals("=none=")
           ||JtxtDateHistory.getText().equals("YYYY-MM-DD"))
        searchHistoryGame();
        if(JtxtDateHistory.getText().equals("")||
           JtxtDateHistory.getText().equals("YYYY-MM-DD")
           &&JtxtGameTitleHistory.getText().equals(""))
        searchHistoryPlatform();
       // if(JtxtGameTitleHistory.getText().equals("")||cmbPlatformHistory.getSelectedItem().toString().equals("=none="))
       // searchHistoryDate();
        
        ClearFieldsHistory();
 
    }//GEN-LAST:event_jButtonSearchHistoryActionPerformed

    private void cmbPlatformHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPlatformHistoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPlatformHistoryActionPerformed

    private void JtxtDateHistoryKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtxtDateHistoryKeyTyped
        if ((JtxtDateHistory.getText() + evt.getKeyChar()).length() > 11) {
            evt.consume();
        }
    }//GEN-LAST:event_JtxtDateHistoryKeyTyped

    private void jButtonSearchSellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchSellActionPerformed
    searchByGameTitleSell();
    searchByPlatformSell();
    searchByDistIdSell();
    if( JtxtGameTitleSell.getText().equals("") && JtxtPriceSell.getText().equals("")
        &&jComboBoxESRB2.getSelectedItem().equals("ESRB") && 
        jComboBoxDistSell.getSelectedItem().equals("DistID")
        && cmbPlatformSell.getSelectedItem().equals("=none=")
        &&JtxtGameIDSell.getText().equals(""))
    searchByPublisherSell();
    searchByESRBSell();
    searchByPriceSell();
    }//GEN-LAST:event_jButtonSearchSellActionPerformed

    private void jButtonClearHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearHistoryActionPerformed
        ClearFieldsHistory();
    }//GEN-LAST:event_jButtonClearHistoryActionPerformed
  //getters and setters so we can get access to these tables from other classes
    public JTable getJTableCustomer() {
        return JTableCustomer;
    }

    public JTable getJTableEmployee() {
        return JTableEmployee;
    }

    public JTable getJTableHistory() {
        return JTableHistory;
    }

    public JTable getJTableSell() {
        return JTableSell;
    }

    public JTable getJTableVideogame() {
        return JTableVideogame;
    }
   //Fill combo boxes with data from the database
   public void comboCustomer()
   {
      for(String customer : this.customerModel.CustomerName())
      {
          jComboBox1.addItem(customer);
      }
   }
 public void comboboxCustomerAdd(String customer)
 {

          jComboBox1.addItem(customer);
 }
 
 public void comboboxCustomerDelete(String customer)
 {
     jComboBox1.removeItem(customer);
 }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu About;
    private javax.swing.JMenuItem About1;
    private javax.swing.JMenu AccountCreate;
    private javax.swing.JMenuItem AccountCreate1;
    private javax.swing.JMenuItem AccountDelete;
    private javax.swing.JMenuItem AccountUpdate;
    private javax.swing.JLabel AddressCustomer;
    private javax.swing.JLabel AddressEmployee;
    private javax.swing.JPanel Customer;
    private javax.swing.JLabel CustomerIdCustomer;
    private javax.swing.JLabel CustomerIdHistory;
    private javax.swing.JLabel CustomerName;
    private javax.swing.JLabel DateHistory;
    private javax.swing.JLabel DistIDList;
    private javax.swing.JLabel DistIDSell;
    private javax.swing.JLabel Dorra;
    private javax.swing.JLabel ESRBList;
    private javax.swing.JLabel ESRBSell;
    private javax.swing.JPanel Employee;
    private javax.swing.JLabel EmployeeID;
    private javax.swing.JMenuItem Exit;
    private javax.swing.JMenu File;
    private javax.swing.JLabel GameIDList;
    private javax.swing.JLabel GameIDSell;
    private javax.swing.JPanel GameList;
    private javax.swing.JPanel GameList1;
    private javax.swing.JLabel GameTitleHistory;
    private javax.swing.JLabel GameTitleList;
    private javax.swing.JLabel GameTitleSell;
    private javax.swing.JPanel History;
    public javax.swing.JTable JTableCustomer;
    public javax.swing.JTable JTableEmployee;
    public javax.swing.JTable JTableHistory;
    public javax.swing.JTable JTableSell;
    public javax.swing.JTable JTableVideogame;
    private javax.swing.JButton JTableVideogamePrint;
    private javax.swing.JTextField JtxtAddressCustomer;
    private javax.swing.JTextField JtxtAddressEmployee;
    private javax.swing.JTextField JtxtCustomerIDCustomer;
    private javax.swing.JTextField JtxtCustomerIDHistory;
    private javax.swing.JTextField JtxtDateHistory;
    private javax.swing.JTextField JtxtEmployeeID;
    private javax.swing.JTextField JtxtGameIDGame;
    private javax.swing.JTextField JtxtGameIDSell;
    private javax.swing.JTextField JtxtGameTitleGame;
    private javax.swing.JTextField JtxtGameTitleHistory;
    public javax.swing.JTextField JtxtGameTitleSell;
    private javax.swing.JTextField JtxtHistoryPrice;
    private javax.swing.JTextField JtxtNameCustomer;
    private javax.swing.JTextField JtxtNameEmployee;
    private javax.swing.JTextField JtxtOrderSell;
    private javax.swing.JTextField JtxtPhoneCustomer;
    private javax.swing.JTextField JtxtPositionEmployee;
    private javax.swing.JTextField JtxtPriceGame;
    private javax.swing.JTextField JtxtPriceSell;
    private javax.swing.JTextField JtxtPublisherGame;
    public javax.swing.JTextField JtxtPublisherSell;
    private javax.swing.JTextField JtxtQuantityGame;
    private javax.swing.JTextField JtxtQuantityHistory;
    public javax.swing.JTextField JtxtQuantitySell;
    private javax.swing.JTextField JtxtShipmentNum;
    private javax.swing.JTextField JtxtTotal;
    private javax.swing.JMenuItem LogOut;
    private javax.swing.JLabel NameEmployee;
    private javax.swing.JLabel PhoneCustomer;
    private javax.swing.JLabel PlatformHistory;
    private javax.swing.JLabel PlatformList;
    private javax.swing.JLabel PlatformSell;
    private javax.swing.JLabel PositionEmployee;
    private javax.swing.JLabel PriceHistory;
    private javax.swing.JMenu Print;
    private javax.swing.JMenuItem PrintCustomer;
    private javax.swing.JMenuItem PrintEmployee;
    private javax.swing.JMenuItem PrintGameList;
    private javax.swing.JMenuItem PrintHistory;
    private javax.swing.JButton PrintJTableCustomer;
    private javax.swing.JButton PrintJTableEmployee;
    private javax.swing.JButton PrintJTableHistory;
    private javax.swing.JLabel PublisherList;
    private javax.swing.JLabel PublisherSell;
    private javax.swing.JLabel QuantityHistory;
    private javax.swing.JLabel QuantityList;
    private javax.swing.JLabel QuantitySell;
    private javax.swing.JLabel ShipmentIdHistory;
    private javax.swing.JLabel ToSell;
    private javax.swing.JLabel TotalToday;
    private javax.swing.JComboBox<String> cmbPlatformGame;
    private javax.swing.JComboBox<String> cmbPlatformHistory;
    private javax.swing.JComboBox<String> cmbPlatformSell;
    private javax.swing.JButton jButtonClearGame;
    private javax.swing.JButton jButtonClearHistory;
    private javax.swing.JButton jButtonDeleteCustomer;
    private javax.swing.JButton jButtonDeleteEmployee;
    private javax.swing.JButton jButtonDeleteGame;
    private javax.swing.JButton jButtonInsertCustomer;
    private javax.swing.JButton jButtonInsertEmployee;
    private javax.swing.JButton jButtonInsertGame;
    private javax.swing.JButton jButtonOrderSell;
    private javax.swing.JButton jButtonSearchCustomer;
    private javax.swing.JButton jButtonSearchEmployee;
    private javax.swing.JButton jButtonSearchGame;
    private javax.swing.JButton jButtonSearchHistory;
    private javax.swing.JButton jButtonSearchSell;
    private javax.swing.JButton jButtonSellSell;
    private javax.swing.JButton jButtonUpdateCustomer;
    private javax.swing.JButton jButtonUpdateEmployee;
    private javax.swing.JButton jButtonUpdateGame;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBoxDistGame;
    private javax.swing.JComboBox<String> jComboBoxDistSell;
    private javax.swing.JComboBox<String> jComboBoxESRB;
    private javax.swing.JComboBox<String> jComboBoxESRB2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    protected javax.swing.JLabel jLabelPosition;
    public javax.swing.JLabel jLabelUser;
    public javax.swing.JLabel jLabelUserId;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanelCustomer;
    private javax.swing.JPanel jPanelEmployee;
    private javax.swing.JPanel jPanelGameList;
    private javax.swing.JPanel jPanelHistory;
    private javax.swing.JPanel jPanelSellOrder;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
