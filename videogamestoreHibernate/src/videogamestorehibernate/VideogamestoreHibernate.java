/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogamestorehibernate;
import videogamestore.ui.*;
public class VideogamestoreHibernate extends  javax.swing.JFrame{
public static void main(String[] args)  
    {
     
       try {
              /* for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;*/
            javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
            new Login().setVisible(true);
            }
               
       // } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
       //java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       // }
       catch (Exception ex) {
            ex.printStackTrace();
        }
      
       //new Login().setVisible(true);
       
    }

}

