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
	public void lireCarte(String numCarte, String numEmploye, int idPorte) {
                String codeGroupeTemp = "NoValid1";
                String codePorteTemp = "NoValide2";
                try{
                    codeGroupeTemp = getCodeGroupe(numCarte);
                    codePorteTemp = getCodePorte(idPorte);
                }catch(Exception e){
                    System.out.println("Gotcha");
                }
                
                HashMap<String, Object> result = new HashMap<String,Object>();
                
                if(codeGroupeTemp.equals(codePorteTemp)){
                  result.put("Notification", true);  
                }else{
                  result.put("Notification", false);
                  result.put("Date",new Date().toString());
                  result.put("NumPers", numEmploye);
                  result.put("idPorte", idPorte);
                  result.put("Personne",getPersonne(numCarte));
                }
                setChanged();
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
            GroupePersonnes groupePersBis = new GroupePersonnes("Gamma2");
            GroupePortes groupePortes = new GroupePortes("alpha1","Z");
            //Inclusion des groupes dans l'autre groupe
            groupePers.addGroupePortes(groupePortes);
            groupePortes.addGroupeOuvre(groupePers);
            //Création Porte et Personne/Carte
            Porte porte1 = new Porte(0,groupePortes);
            Carte c1 = new Carte("R22");
            Carte c2 = new Carte("T11");
            Personne pers1 = new Personne("Gilmour","David",c1);
            Personne pers2 = new Personne("Ju","King",c2);
            
            //Inclusion dans les autres classes
            groupePortes.addPorte(porte1);
            portes.put(porte1.getIdPorte(), porte1);
            this.cartes.put(c1.getNumCarte(), c1);
            this.cartes.put(c2.getNumCarte(),c2);
            c1.setPersonne(pers1);
            c2.setPersonne(pers2);
            groupePers.addPersonne(pers1);
            groupePersBis.addPersonne(pers2);
            pers1.addGroupe(groupePers);
            pers2.addGroupe(groupePersBis);
        }
}