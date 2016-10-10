package adli_prudhomme_observator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Date;

public class IHMGardien extends JFrame implements Observer {

	private Controler _controler;
        private JPanel _panel;

	public IHMGardien(Controler c){
            this._controler = c;
            setWindows();
        }
        
        private void setWindows(){
            //Création de la fenètre
            JFrame frame = new JFrame("Gardien - Rapport des intrusions");
            frame.setSize(620, 800);
            
            //Création du panel 
            _panel = new JPanel();
            _panel.setLayout(new GridLayout(30,1));
            _panel.add(new JLabel("Rapport des intrusions : "));
            
            frame.add(_panel); 
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
        
        protected void addLabel(String texte) {
            JLabel nvLabel = new JLabel(texte);
            _panel.add(nvLabel);
            _panel.repaint();
            _panel.revalidate();
        }
        
        @Override
         public void update(Observable o, Object arg) {
            HashMap<String, Object> map = (HashMap<String, Object>) arg;
            if((boolean)map.get("Notification") == false){
                JLabel rep = new JLabel();
                String date = (String) map.get("Date");
                String numPers = (String) map.get("NumPers");
                String idPorte = map.get("idPorte").toString();
                addLabel( date + " -|- Porte : " + idPorte + " -|- Numéro Personne : " + numPers + " -|- Batiment : A");
            }
         }
    }