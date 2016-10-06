public class Carte {

	Personne personne;
	private String numCarte;

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
	public Carte(Carte numCarte) {
		// TODO - implement Carte.Carte
		throw new UnsupportedOperationException();
	}

	public Personne getPersonne() {
		return this.personne;
	}

}