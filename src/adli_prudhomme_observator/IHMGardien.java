package adli_prudhomme_observator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IHMGardien extends JFrame implements Observer {

	private Controler _controler;

	public IHMGardien(Controler c){
            this._controler = c;
            setWindows();
        }
        
        private void setWindows(){
            JFrame frame = new JFrame("Gardien - Rapport des intrusions");
            frame.setSize(200, 300);
                        //Création de la fenètre
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
            
            panel.add(setMainPanel("Texte"),BorderLayout.CENTER); 
            
            JButton b_OK = new JButton("ok"); 
            panel.add(b_OK); 
            
            frame.add(panel); 
            frame.setVisible(true);
      
         
        }
        
        protected JComponent setMainPanel(String texte) {
        JPanel main_panel = new JPanel();
        
        BoxLayout b = new BoxLayout(main_panel, BoxLayout.Y_AXIS);
        main_panel.setLayout(b); 
        
        JLabel lab = new JLabel(texte); 
        main_panel.add(lab); 
        
        
       
        return main_panel;
        
    }
        


        @Override
         public void update(Observable o, Object arg) {
         }

        }