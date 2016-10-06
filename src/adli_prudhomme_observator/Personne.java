package adli_prudhomme_observator;

import java.util.*;

public class Personne {

	Collection<GroupePersonnes> groupes;
	Carte carte;
	private String nom;
	private String prenom;

	/**
	 * 
	 * @param nom
	 * @param prenom
	 */
	public Personne(String nom, String prenom) {
		// TODO - implement Personne.Personne
		throw new UnsupportedOperationException();
	}

	public String getNom() {
		return this.nom;
	}

	/**
	 * 
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	/**
	 * 
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public ArrayList<GroupePersonnes> getGroupes() {
		// TODO - implement Personne.getGroupes
		throw new UnsupportedOperationException();
	}

}