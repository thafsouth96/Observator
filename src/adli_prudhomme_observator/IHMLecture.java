package adli_prudhomme_observator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.time.zone.ZoneRulesProvider.refresh;
import java.util.HashMap;
import javax.swing.*;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;

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
    private JTextField code_carte ; 
    private JTextField num_carte ; 
     

    public IHMLecture(Controler c) {
        this._controler = c;
        _voyantVert = false;
        _voyant = new MyCanvas();
        code_carte = new JTextField(); 
        num_carte = new JTextField(); 

        setWindows();
        setCouleurVoyant();
    }
    
    public String getCodeVAl(){
        
        return code_carte.getText(); //retourne la valeur saisie dans le JTextField 
    }
    
    public String getNumCarteVAl(){
        return num_carte.getText(); 
    }

    public Controler getControler() {
        return _controler;
    }

    public void setControler(Controler _controler) {
        this._controler = _controler;
    }

    public boolean isVoyantVert() {
        return _voyantVert;
    }

    public void setVoyantVert(boolean _voyantVert) {
        this._voyantVert = _voyantVert;
    }

    public MyCanvas getVoyant() {
        return _voyant;
    }

    public void setVoyant(MyCanvas _voyant) {
        this._voyant = _voyant;
    }

    public JTextField getCode_carte() {
        return code_carte;
    }

    public void setCode_carte(JTextField code_carte) {
        this.code_carte = code_carte;
    }

    public JTextField getNum_carte() {
        return num_carte;
    }

    public void setNum_carte(JTextField num_carte) {
        this.num_carte = num_carte;
    }
    
    private void sendData(){
        _controler.lireCarte(code_carte.getText(),num_carte.getText() , 0);
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
        JButton b_valider = new JButton("Valider"); 
        b_valider.addActionListener(new ActionListener(
        ) {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendData();
            }
        });
        panel.add(b_valider, BorderLayout.SOUTH);
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
        
        //code.setSize(d);
        panel_code.add(this.getCode_carte());

        JPanel panel_num = new JPanel();
        panel_num.setLayout(new GridLayout(1, 2));
     
        
        panel_num.add(new JLabel("Numéro Employé : "));
        
        //numero.setPreferredSize(new Dimension(200, 24));
        panel_num.add(this.getNum_carte());

        JPanel panel_voyant = new JPanel();
        panel_voyant.setLayout(new GridLayout(1, 2));
        
        panel_voyant.add(new JLabel("Voyant "));
        panel_voyant.add(_voyant);
        _voyant.setBackground(Color.red);

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
       HashMap<String, Object> map = (HashMap<String, Object>) arg;
       if((boolean) map.get("Notification")){
           _voyantVert = true;
           setCouleurVoyant();
           _voyant.repaint();
           /*try{
               TimeUnit.SECONDS.sleep(5);
           }catch(Exception e){
               System.out.println("Exception : " + e.getMessage());
           }*/
       }
        /*_voyantVert = false;
        setCouleurVoyant();  */     
       
    }

}
