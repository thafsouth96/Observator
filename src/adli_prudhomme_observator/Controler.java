package adli_prudhomme_observator;

import java.util.*;

public class Controler extends Observable {

	HashMap<Integer, Porte> portes = new HashMap<Integer, Porte>();
	HashMap<String,Carte> cartes = new HashMap<String, Carte>();
	IHMLecture ihmEmploye;
	IHMGardien ihmGardien;

        
        
        public Controler(){ 
            initModel();
            
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
	public void lireCarte(String numCarte, int codeCarte, int idPorte) {
		String codeGroupeTemp = getCodeGroupe(numCarte);
                String codePorteTemp = getCodePorte(idPorte);
                
                HashMap<String, Object> result = new HashMap<String,Object>();
                
                if(codeGroupeTemp.equals(codePorteTemp)){
                  result.put("Notification", true);  
                }else{
                  result.put("Notification", false);
                  result.put("Date",new Date().toString());
                  result.put("Personne",getPersonne(numCarte));
                }
                this.notifyObservers(result);
	}
	/**
	 * 
	 * @param numCarte
	 */
	private Carte getCarte(String numCarte) {
		return cartes.get(numCarte);
	}
	/**
	 * 
	 * @param numCarte
	 */
	private String getCodeGroupe(String numCarte) {
		return getCarte(numCarte).getPersonne().getGroupes().get(0).getCode();
	}
        
        private String getPersonne(String numcarte){
            return (getCarte(numcarte).getPersonne().getNom() + getCarte(numcarte).getPersonne().getPrenom());
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

        private IHMLecture getIhmLecture(){
            return this.ihmEmploye;
        }
	private IHMGardien getIhmGardien() {
		return this.ihmGardien;
	}

        private void initModel(){
            //Création des groupes
            GroupePersonnes groupePers = new GroupePersonnes("alpha1");
            GroupePortes groupePortes = new GroupePortes("alpha1","Z");
            //Inclusion des groupes dans l'autre groupe
            groupePers.addGroupePortes(groupePortes);
            groupePortes.addGroupeOuvre(groupePers);
            //Création Porte et Personne/Carte
            Porte porte1 = new Porte(0,groupePortes);
            Carte c1 = new Carte("R22");
            Personne pers1 = new Personne("Gilmour","David",c1);
            
            //Inclusion dans les autres classes
            groupePortes.addPorte(porte1);
            portes.put(porte1.getIdPorte(), porte1);
            this.cartes.put(c1.getNumCarte(), c1);
            groupePers.addPersonne(pers1);
            pers1.addGroupe(groupePers);
        }
}