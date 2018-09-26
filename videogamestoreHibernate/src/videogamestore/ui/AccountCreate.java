
package videogamestore.ui;
import javax.swing.JOptionPane;
import videogamestore.entity.*;
import videogamestore.model.*;
import videogamestore.util.NewHibernateUtil;
public class AccountCreate extends javax.swing.JFrame {
    public AccountCreate() {
        initComponents();
    }
    AccountModel accountModel = new AccountModel();
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextFieldEmailCreate = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonAccountCreate = new javax.swing.JButton();
        jButtonClear1 = new javax.swing.JButton();
        jPasswordFieldCreate = new javax.swing.JPasswordField();
        jTextFieldAccountId = new javax.swing.JTextField();
        EmployeeID = new javax.swing.JLabel();
        jComboBoxAccountCreate = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create Account");
        setResizable(false);

        jTextFieldEmailCreate.setText("Enter your e-mail");
        jTextFieldEmailCreate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldEmailCreateMouseClicked(evt);
            }
        });

        jLabel1.setText("E-mail");

        jLabel2.setText("Password");

        jButtonAccountCreate.setText("Create");
        jButtonAccountCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAccountCreateActionPerformed(evt);
            }
        });

        jButtonClear1.setText("Clear");
        jButtonClear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClear1ActionPerformed(evt);
            }
        });

        jTextFieldAccountId.setEditable(false);

        EmployeeID.setText("EmployeeID");

        jComboBoxAccountCreate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select an employee" }));
        jComboBoxAccountCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxAccountCreateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldEmailCreate)
                            .addComponent(jPasswordFieldCreate)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBoxAccountCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(jTextFieldAccountId, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(60, 60, 60))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(EmployeeID)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonAccountCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonClear1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEmailCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordFieldCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAccountId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EmployeeID)
                    .addComponent(jComboBoxAccountCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAccountCreate)
                    .addComponent(jButtonClear1))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        for(String employee : this.employeeModel.employeeName())
        {
            this.jComboBoxAccountCreate.addItem(employee);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
 EmployeeModel employeeModel = new EmployeeModel();
    public void ClearFieldsCreate()
{
    this.jTextFieldEmailCreate.setText("");
    this.jPasswordFieldCreate.setText("");
    this.jTextFieldAccountId.setText("");
}    

    private void jTextFieldEmailCreateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldEmailCreateMouseClicked
        this.jTextFieldEmailCreate.setText("");
    }//GEN-LAST:event_jTextFieldEmailCreateMouseClicked

    private void jButtonAccountCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAccountCreateActionPerformed
        try {int result = JOptionPane.showConfirmDialog(null, "Create a new account?",
                    "Confirm?", JOptionPane.YES_NO_OPTION);
       if(result == JOptionPane.YES_OPTION)
       {   if(!employeeModel.employeeId().contains(Integer.parseInt(this.jTextFieldAccountId.getText())))
       {
           JOptionPane.showMessageDialog(null, "Invalid employee ID (see Employee tab)");
           NewHibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
       }
       else{
           Account account = new Account();
           Employee employee = new Employee();
           employee.setEmployeeId(Integer.parseInt(this.jTextFieldAccountId.getText()));
           account.setUsername(this.jTextFieldEmailCreate.getText());
           account.setPassword(this.jPasswordFieldCreate.getText());
           account.setEmployee(employee);
        this.accountModel.create(account);
        JOptionPane.showMessageDialog(null, "Successfully added a new account!");
        ClearFieldsCreate();
       }
       } 
       } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_jButtonAccountCreateActionPerformed

    private void jButtonClear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClear1ActionPerformed
        jPasswordFieldCreate.setText("");
        jTextFieldEmailCreate.setText("");
    }//GEN-LAST:event_jButtonClear1ActionPerformed

    private void jComboBoxAccountCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxAccountCreateActionPerformed
      this.jTextFieldAccountId.setText(this.employeeModel.accountToName(jComboBoxAccountCreate.getSelectedItem().toString()).get(0).toString());
    }//GEN-LAST:event_jComboBoxAccountCreateActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AccountCreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccountCreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccountCreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccountCreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccountCreate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EmployeeID;
    private javax.swing.JButton jButtonAccountCreate;
    private javax.swing.JButton jButtonClear1;
    private javax.swing.JComboBox<String> jComboBoxAccountCreate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordFieldCreate;
    private javax.swing.JTextField jTextFieldAccountId;
    private javax.swing.JTextField jTextFieldEmailCreate;
    // End of variables declaration//GEN-END:variables
}
