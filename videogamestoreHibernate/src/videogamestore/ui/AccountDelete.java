package videogamestore.ui;
import videogamestore.entity.*;
import videogamestore.model.*;
import videogamestore.util.NewHibernateUtil;
import javax.swing.JOptionPane;
import org.hibernate.SessionFactory;
public class AccountDelete extends javax.swing.JFrame {

    public AccountDelete() {
        initComponents();
    }
  public void ClearFieldsDelete()
{
    this.jTextFieldEmailDelete.setText("");
    this.jPasswordFieldDelete.setText("");
}    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextFieldEmailDelete = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonAccountDelete = new javax.swing.JButton();
        jButtonClear3 = new javax.swing.JButton();
        jPasswordFieldDelete = new javax.swing.JPasswordField();
        jTextFieldAccountIdDelete = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jTextFieldEmailDelete.setText("Enter your e-mail");
        jTextFieldEmailDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldEmailDeleteMouseClicked(evt);
            }
        });

        jLabel1.setText("E-mail");

        jLabel2.setText("Password");

        jButtonAccountDelete.setText("Delete");
        jButtonAccountDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAccountDeleteActionPerformed(evt);
            }
        });

        jButtonClear3.setText("Clear");
        jButtonClear3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClear3ActionPerformed(evt);
            }
        });

        jTextFieldAccountIdDelete.setEditable(false);

        jLabel3.setText("Account Id");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldEmailDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(jPasswordFieldDelete)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonAccountDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonClear3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldAccountIdDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(60, 60, 60))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEmailDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordFieldDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAccountIdDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAccountDelete)
                    .addComponent(jButtonClear3))
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
AccountModel accountModel = new AccountModel();
    private void jTextFieldEmailDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldEmailDeleteMouseClicked
        this.jTextFieldEmailDelete.setText("");
    }//GEN-LAST:event_jTextFieldEmailDeleteMouseClicked

    private void jButtonAccountDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAccountDeleteActionPerformed
        if(jTextFieldAccountIdDelete.getText().equals("")||jTextFieldEmailDelete.equals("")||jPasswordFieldDelete.getText().equals(""))
        {  JOptionPane.showMessageDialog(null, "Fill all the fields!");
            NewHibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();}
        else{try {
            int result = JOptionPane.showConfirmDialog(null, "Delete this account?",
                "Confirm?", JOptionPane.YES_NO_OPTION);
            if(result == JOptionPane.YES_OPTION)
            {   
           int accountId = Integer.parseInt(this.jTextFieldAccountIdDelete.getText());
           Account account = this.accountModel.find(accountId);
           this.accountModel.delete(account);
                JOptionPane.showMessageDialog(null, "Successfully deleted account!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid username or password");
        }
        }
    }//GEN-LAST:event_jButtonAccountDeleteActionPerformed

    private void jButtonClear3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClear3ActionPerformed
        jPasswordFieldDelete.setText("");
        jTextFieldEmailDelete.setText("");
    }//GEN-LAST:event_jButtonClear3ActionPerformed

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
            java.util.logging.Logger.getLogger(AccountDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccountDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccountDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccountDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccountDelete().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAccountDelete;
    private javax.swing.JButton jButtonClear3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordFieldDelete;
    private javax.swing.JTextField jTextFieldAccountIdDelete;
    private javax.swing.JTextField jTextFieldEmailDelete;
    // End of variables declaration//GEN-END:variables
}
