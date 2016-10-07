package adli_prudhomme_observator;

import java.util.*;

public class GroupePersonnes {

	private HashMap<String,Personne> personnes = new HashMap<String,Personne>();
	private ArrayList<GroupePortes> portes = new ArrayList<>();
	private String code;

        public GroupePersonnes(String code){
            this.code = code;
        }
        
	/**
	 * 
	 * @param personne
	 */
	public void addPersonne(Personne personne) {
            String temp = personne.getCarte().getNumCarte();
		personnes.put(temp, personne);
	}
        
        public void addGroupePortes(GroupePortes g){
            portes.add(g);
        }
        
        public String getCode(){
            return code;
        }


	

}