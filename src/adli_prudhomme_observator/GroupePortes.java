package adli_prudhomme_observator;

import java.util.*;

public class GroupePortes {

	private HashMap<Integer, Porte> portes = new HashMap<Integer, Porte>();
	private ArrayList<GroupePersonnes> PersonneOuvre = new ArrayList<>();
	private String code;
	private String batiment;

	/**
	 * 
	 * @param porte
	 */
	public void addPorte(Porte porte) {
		portes.put(porte.getIdPorte(), porte);
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

	/**
	 * 
	 * @param batiment
	 */
	public void setBatiment(String batiment) {
		this.batiment = batiment;
	}
}