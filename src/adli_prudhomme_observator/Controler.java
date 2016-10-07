package adli_prudhomme_observator;

import java.util.*;

public class Controler extends Observable {

	HashMap<Integer, Porte> portes = new HashMap<Integer, Porte>();
	HashMap<String,Carte> cartes = new HashMap<String, Carte>();
	IHMLecture ihmEmploye;
	IHMGardien ihmGardien;

        
        
        public Controler(){ 
            this.ihmEmploye = new IHMLecture(this);
            this.ihmGardien = new IHMGardien(this);
            
            this.addObserver(this.ihmEmploye);
            this.addObserver(this.ihmGardien);
        }
        
	/**
	 * 
	 * @param numCarte
	 * @param codeCarte
	 * @param idPorte
	 */
	public void lireCarte(int numCarte, int codeCarte, int idPorte) {
		String codeCarteTemp = getCodeCarte(numCarte);
                
	}
	/**
	 * 
	 * @param numCarte
	 */
	public Carte getCarte(int numCarte) {
		return cartes.get(numCarte);
	}
	/**
	 * 
	 * @param numCarte
	 */
	public String getCodeCarte(int numCarte) {
		return getCarte(numCarte).getPersonne().getGroupes().get(0).getCode();
	}

	/**
	 * 
	 * @param idPorte
	 */
	public String getCodePorte(int idPorte) {
		return portes.get(idPorte).getGroupe().getCode();
	}

	public HashMap<Integer, Porte> getPortes() {
		return portes;
	}

        public IHMLecture getIhmLecture(){
            return this.ihmEmploye;
        }
	public IHMGardien getIhmGardien() {
		return this.ihmGardien;
	}

}