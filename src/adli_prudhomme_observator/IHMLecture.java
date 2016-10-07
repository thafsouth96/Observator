package adli_prudhomme_observator;

import java.awt.*;
import javax.swing.*;
import java.util.Observable;
import java.util.Observer;


public class IHMLecture implements Observer {

	private Controler _controler;
        private boolean _voyantVert;
        private JPanel _voyant;
      
        public IHMLecture(Controler c){
            this._controler = c;
             _voyantVert = false;
            _voyant = new JPanel();
            _voyant.setPreferredSize(new Dimension(40, 40));
            
            setWindows();
            setCouleurVoyant();
        }
        
        private void setWindows(){         
            //Création de la fenètre
            JFrame frame = new JFrame("Porte 22 -Accès batiment A ");
            //Création du panel et de ses grid
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
            //Ajout des labels et champs 
            panel.add(setMainPanel(),BorderLayout.CENTER);
            //Bouton valider
            panel.add(new JButton("Valider"), BorderLayout.SOUTH);
            //Ajout du voyant 
            panel.add(_voyant);
            //Ajout du panel
            frame.add(panel);
            frame.setSize(700, 700);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
        
        protected JComponent setMainPanel() {
            JPanel inner = new JPanel();
            inner.setLayout(new GridLayout(2, 2, 10, 0));
            inner.add(new JLabel("Numéro Employé : "));
            inner.add(new JTextField());
            inner.add(new JLabel("Numéro Employé : "));
            inner.add(new JTextField());
            return inner;
          }
        
        public void setCouleurVoyant(){
            if(_voyantVert){
                _voyant.setBackground(Color.green);
            }else{
                _voyant.setBackground(Color.red);
            }
        }
        
        @Override
        public void update(Observable o, Object arg) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

}