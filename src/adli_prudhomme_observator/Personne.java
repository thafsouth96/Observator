package adli_prudhomme_observator;

import java.util.*;

public class Personne {

	private ArrayList<GroupePersonnes> groupes = new ArrayList<>();
	private Carte carte;
	private String nom;
	private String prenom;

	/**
	 * 
	 * @param nom
	 * @param prenom
	 */
	public Personne(String nom, String prenom, Carte c) {
            this.nom = nom;
            this.prenom = prenom;
            this.carte = c;
	}

        public void addGroupe(GroupePersonnes g){
            groupes.add(g);
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

        public Carte getCarte(){
            return carte;
        }
        
	/**
	 * 
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public ArrayList<GroupePersonnes> getGroupes() {
		return groupes;
	}

}