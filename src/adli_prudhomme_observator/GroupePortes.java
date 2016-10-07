package adli_prudhomme_observator;

import java.util.*;

public class GroupePortes {

	private HashMap<Integer, Porte> portes = new HashMap<Integer, Porte>();
	private ArrayList<GroupePersonnes> personneOuvre = new ArrayList<>();
	private String code;
	private String batiment;

        public GroupePortes(String code, String batiment){
            this.code = code;
            this.batiment = batiment;
        }
        
        public void addGroupeOuvre(GroupePersonnes g){
            personneOuvre.add(g);
        }
       
	public void addPorte(Porte porte) {
		getPortes().put(porte.getIdPorte(), porte);
	}

	public String getCode() {
		return this.code;
	}

	/**
	 * 
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	public String getBatiment() {
		return this.batiment;
	}

	public void setBatiment(String batiment) {
		this.batiment = batiment;
	}

    /**
     * @return the portes
     */
    public HashMap<Integer, Porte> getPortes() {
        return portes;
    }

    /**
     * @param portes the portes to set
     */
    public void setPortes(HashMap<Integer, Porte> portes) {
        this.portes = portes;
    }

    /**
     * @return the PersonneOuvre
     */
    public ArrayList<GroupePersonnes> getPersonneOuvre() {
        return personneOuvre;
    }

    /**
     * @param personneOuvre the PersonneOuvre to set
     */
    public void setPersonneOuvre(ArrayList<GroupePersonnes> PersonneOuvre) {
        this.personneOuvre = PersonneOuvre;
    }
}