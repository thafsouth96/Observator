package adli_prudhomme_observator;

public class Porte {

	private GroupePortes groupe;
	private int idPorte;
        

	public Porte(int idPorte, GroupePortes groupe) {
		this.groupe = groupe;
                this.idPorte = idPorte;
	}

	public int getIdPorte() {
		return this.idPorte;
	}

	public void setIdPorte(int idPorte) {
		this.idPorte = idPorte;
	}
        
        public GroupePortes getGroupe(){
            return groupe;
        }
}