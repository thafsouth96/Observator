package adli_prudhomme_observator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class IHMLecture implements Observer {

    private Controler _controler;
    private boolean _voyantVert;
    private JPanel _voyant;
    private JFrame frame;
    private JTextField code_carte ; 
    private JTextField num_carte ; 
     

    public IHMLecture(Controler c) {
        this._controler = c;
        _voyantVert = false;
        _voyant = new JPanel();
        code_carte = new JTextField(); 
        num_carte = new JTextField(); 

        setWindows();
        _voyant.setBackground(Color.white);
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

    public JPanel getVoyant() {
        return _voyant;
    }

    public void setVoyant(JPanel _voyant) {
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
        frame = new JFrame("Porte 0 -Accès batiment A ");
        //Création du panel et de ses grid
        JPanel panel = new JPanel();
        //panel.setLayout(new BorderLayout());
        //Ajout des labels et champs 
        panel.add(setMainPanel()/*, BorderLayout.CENTER*/);
        //Ajout du panel
        frame.add(panel);
        frame.setSize(600, 250);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.validate();
        frame.setVisible(true);
    }
    
  

    private JComponent setMainPanel() {
        JPanel main_panel = new JPanel();
        BoxLayout b = new BoxLayout(main_panel, BoxLayout.Y_AXIS);
        main_panel.setLayout(b); 
        
        // 3 sous-panel 
        JPanel panel_code = new JPanel();
        panel_code.setLayout(new GridLayout(1, 4));
        panel_code.add(new JLabel("Numéro Carte : "));
        panel_code.add(this.getCode_carte());
        JPanel panel_num = new JPanel();
        panel_num.setLayout(new GridLayout(1, 2));
        panel_num.add(new JLabel("Numéro Employé : "));
        panel_num.add(this.getNum_carte());
        JPanel panel_voyant = new JPanel();
        panel_voyant.setLayout(new GridLayout(1, 2));
        panel_voyant.add(new JLabel("Voyant "));
        _voyant.setPreferredSize(new Dimension(100,100));
        panel_voyant.add(_voyant);

        main_panel.add(panel_code);
        main_panel.add(panel_num);
        main_panel.add(panel_voyant);
        
        //Bouton valider
        JButton b_valider = new JButton("Valider"); 
        b_valider.setPreferredSize(new Dimension(150,50));
        b_valider.addActionListener(new ActionListener(
        ) {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendData();
            }
        });
        main_panel.add(b_valider/*, BorderLayout.SOUTH*/);
        
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
       }else{
          _voyantVert = false;
          setCouleurVoyant(); 
       }
       _voyantVert = false;    
        Thread thread = new Thread(){
            @Override
            public void run(){
                try{
                    this.sleep(4000);
                }catch(Exception e){
                    System.out.println("Gotcha");
                }
                _voyant.setBackground(Color.white);
            }
        };
        thread.start();
    }

}