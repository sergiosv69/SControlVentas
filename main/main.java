package main;


import javax.swing.UIManager;
import views.LoginView;
import views.SystemView;

/**
 *
 * @author Sergio Vasquez
 */
public class main {
    public static void main(String[] args){
        try{
            //UIManager.setLookAndFeel(new SyntheticaBlackMoonLookAndFeel());
                new LoginView().setVisible(true);
        }catch(Exception e){
            
        }
        
        
        
        
        /*LoginView loginview = new LoginView();
        loginview.setVisible(true);*/
        
        
        //new LoginView().setVisible(true);
    }
}