package adli_prudhomme_observator;

public class Carte {

	private Personne personne;
	private String numCarte;
        
        public Carte(String numCarte) {
                setNumCarte(numCarte);
	}

	public String getNumCarte() {
		return this.numCarte;
	}
	/**
	 * 
	 * @param numCarte
	 */
	public void setNumCarte(String numCarte) {
		this.numCarte = numCarte;
	}

	/**
	 * 
	 * @param numCarte
	 */
	public Personne getPersonne() {
		return this.personne;
	}

}