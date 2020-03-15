/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rubik.manager;

import java.lang.IllegalAccessException;
import java.lang.InstantiationException;
import javax.swing.UnsupportedLookAndFeelException;
import rubik.manager.forms.Login;

/**
 *
 * @author Wz
 */
public class Main {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InstantiationException {
        //Setando Nimbus como Look and Feel
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        Login login = new Login();
        login.setVisible(true);
        
    }
}
