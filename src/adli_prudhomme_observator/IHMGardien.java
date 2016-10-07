package adli_prudhomme_observator;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class IHMGardien extends JFrame implements Observer {

	private Controler _controler;

	public IHMGardien(Controler c){
            this._controler = c;
            setWindows();
        }
        
        private void setWindows(){
            JFrame frame = new JFrame("Gardien - Rapport des intrusions");
                        //Création de la fenètre
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
            frame.setVisible(true);
      
         
        }


        @Override
         public void update(Observable o, Object arg) {
             throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         }

}