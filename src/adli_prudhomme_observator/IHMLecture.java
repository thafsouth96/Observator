package adli_prudhomme_observator;

import java.awt.*;
import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

class MyCanvas extends JComponent {

    @Override
    public void paint(Graphics g) {
        g.drawRect(60, 60, 60, 60);

    }
}

public class IHMLecture implements Observer {

    private Controler _controler;
    private boolean _voyantVert;
    private MyCanvas _voyant;

    public IHMLecture(Controler c) {
        this._controler = c;
        _voyantVert = false;
        _voyant = new MyCanvas();

        setWindows();
        setCouleurVoyant();
    }

    private void setWindows() {
        //Création de la fenètre
        JFrame frame = new JFrame("Porte 22 -Accès batiment A ");
        //Création du panel et de ses grid
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        //Ajout des labels et champs 
        panel.add(setMainPanel(), BorderLayout.CENTER);
        //Bouton valider
        panel.add(new JButton("Valider"), BorderLayout.SOUTH);
        //Ajout du voyant 
        //panel.add(_voyant);
        //Ajout du panel
        frame.add(panel);
        frame.setSize(700, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //valider ==> controler.lirecarte(); 
    }

    protected JComponent setMainPanel() {
        JPanel main_panel = new JPanel();
        BoxLayout b = new BoxLayout(main_panel, BoxLayout.Y_AXIS);
        main_panel.setLayout(b); 
        
        // 3 sous-panel 
        JPanel panel_code = new JPanel();
        panel_code.setLayout(new GridLayout(1, 4));
        
        //Dimension d = new Dimension(100, 400);

        panel_code.add(new JLabel("Numéro Carte : "));
        JTextField code = new JTextField();
        //code.setSize(d);
        panel_code.add(code);

        JPanel panel_num = new JPanel();
        panel_num.setLayout(new GridLayout(1, 2));
     

        panel_num.add(new JLabel("Numéro Employé : "));
        panel_num.add(new JTextField());

        JPanel panel_voyant = new JPanel();
        panel_voyant.setLayout(new GridLayout(1, 2));
        
        panel_voyant.add(new JLabel("Voyant "));
        panel_voyant.add(_voyant);

        main_panel.add(panel_code);
        main_panel.add(panel_num);
        main_panel.add(panel_voyant);
        return main_panel;
    }

    public void setCouleurVoyant() {
        if (_voyantVert) {
            _voyant.setBackground(Color.green);
        } else {
            _voyant.setBackground(Color.red);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
