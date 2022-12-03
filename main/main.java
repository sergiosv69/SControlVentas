package main;


import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import views.LoginView;

/**
 *
 * @author Sergio Vasquez
 */
public class main {
    public static void main(String[] args){
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
        try{
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            //UIManager.setLookAndFeel(new SyntheticaBlackMoonLookAndFeel());
            UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
                new LoginView().setVisible(true);
        }catch(Exception e){
            
        }
        
        LoginView loginview = new LoginView();
        loginview.setVisible(true);

        
        //new LoginView().setVisible(true);
    }
}