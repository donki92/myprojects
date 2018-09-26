
package videogamestore.ui;
import videogamestore.entity.*;
import videogamestore.model.*;
import videogamestore.util.NewHibernateUtil;
import javax.swing.JOptionPane;
import org.hibernate.SessionFactory;
public class AccountUpdate extends javax.swing.JFrame {

   
    public AccountUpdate() {
        initComponents();
    }
    public void ClearFieldsCreate()
{
    this.jTextFieldEmailUpdate.setText("");
    this.jPasswordFieldUpdate.setText("");
}    

AccountModel accountModel = new AccountModel();
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextFieldEmailUpdate = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonAccountUpdate = new javax.swing.JButton();
        jButtonClear2 = new javax.swing.JButton();
        jPasswordFieldUpdate = new javax.swing.JPasswordField();
        jTextFieldAccountId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jTextFieldEmailUpdate.setText("Enter your e-mail");
        jTextFieldEmailUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldEmailUpdateMouseClicked(evt);
            }
        });

        jLabel1.setText("E-mail");

        jLabel2.setText("Password");

        jButtonAccountUpdate.setText("Update");
        jButtonAccountUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAccountUpdateActionPerformed(evt);
            }
        });

        jButtonClear2.setText("Clear");
        jButtonClear2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClear2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Account Id");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldAccountId, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldEmailUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                            .addComponent(jPasswordFieldUpdate)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonAccountUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonClear2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(60, 60, 60))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEmailUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordFieldUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAccountId, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAccountUpdate)
                    .addComponent(jButtonClear2))
                .addContainerGap(111, Short.MAX_VALUE))
        );

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

    private void jTextFieldEmailUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldEmailUpdateMouseClicked
        this.jTextFieldEmailUpdate.setText("");
    }//GEN-LAST:event_jTextFieldEmailUpdateMouseClicked

    private void jButtonAccountUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAccountUpdateActionPerformed
        if(jTextFieldAccountId.getText().equals("")||jTextFieldEmailUpdate.equals("")||jPasswordFieldUpdate.getText().equals(""))
        {  JOptionPane.showMessageDialog(null, "Fill all the fields!");
            NewHibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();}
        else{try {
            int result = JOptionPane.showConfirmDialog(null, "Update your account?",
            "Confirm?", JOptionPane.YES_NO_OPTION);
        if(result == JOptionPane.YES_OPTION)
        {   Account account = new Account();
            account.setAccountId(Integer.parseInt(this.jTextFieldAccountId.getText()));
            account.setUsername(this.jTextFieldEmailUpdate.getText());
            account.setPassword(this.jPasswordFieldUpdate.getText());
            this.accountModel.update(account);
            JOptionPane.showMessageDialog(null, "Successfully updated account!");
            ClearFieldsCreate();
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid username or password");
        }
        }
    }//GEN-LAST:event_jButtonAccountUpdateActionPerformed

    private void jButtonClear2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClear2ActionPerformed
        jPasswordFieldUpdate.setText("");
        jTextFieldEmailUpdate.setText("");
    }//GEN-LAST:event_jButtonClear2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAccountUpdate;
    private javax.swing.JButton jButtonClear2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordFieldUpdate;
    private javax.swing.JTextField jTextFieldAccountId;
    private javax.swing.JTextField jTextFieldEmailUpdate;
    // End of variables declaration//GEN-END:variables
}
