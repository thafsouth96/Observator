package adli_prudhomme_observator;

public class Carte {

	private Personne personne;
	private String numCarte;
        
        public Carte(String num) {
                setNumCarte(num);
	}

	public String getNumCarte() {
		return numCarte;
	}
	/**
	 * 
	 * @param numCarte
	 */
	public void setNumCarte(String numCarte) {
		this.numCarte = numCarte;
	}
        
        public void setPersonne(Personne p){
            this.personne=p;
        }
	/**
	 * 
	 * @param numCarte
	 */
	public Personne getPersonne() {
		return this.personne;
	}

}