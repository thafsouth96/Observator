package adli_prudhomme_observator;

import java.util.*;

public class Controler extends Observable {

	Collection<Porte> portes;
	Collection<Carte> groupesPersonnes;
	IHMLecture ihmEmploye;
	IHMGardien ihmGardien;

        
        
        public Controler(){ 
            this.ihmEmploye = new IHMLecture(this);
            this.ihmGardien = new IHMGardien(this);

        }
        
	/**
	 * 
	 * @param numCarte
	 * @param codeCarte
	 * @param idPorte
	 */
	public void lireCarte(int numCarte, int codeCarte, int idPorte) {
		// TODO - implement Controler.lireCarte
		throw new UnsupportedOperationException();
	}
	/**
	 * 
	 * @param numCarte
	 */
	public Carte getCarte(int numCarte) {
		// TODO - implement Controler.getCarte
		throw new UnsupportedOperationException();
	}
	/**
	 * 
	 * @param numCarte
	 */
	public ArrayList<String> getCodesCarte(int numCarte) {
		// TODO - implement Controler.getCodesCarte
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idPorte
	 */
	public String getCodePorte(int idPorte) {
		// TODO - implement Controler.getCodePorte
		throw new UnsupportedOperationException();
	}

	public ArrayList<Porte> getPortes() {
		// TODO - implement Controler.getPortes
		throw new UnsupportedOperationException();
	}

	public IHMGardien getIhmGardien() {
		return this.ihmGardien;
	}

}