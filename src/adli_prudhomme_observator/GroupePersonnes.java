package adli_prudhomme_observator;

import java.util.*;

public class GroupePersonnes {

	private HashMap<String,Personne> personnes = new HashMap<String,Personne>();
	private ArrayList<GroupePortes> portes = new ArrayList<>();
	private String code;

	/**
	 * 
	 * @param personne
	 */
	public void addPersonne(Personne personne) {
		personnes.put(personne.getCarte().getNumCarte(), personne);
	}
        
        public String getCode(){
            return code;
        }


	

}