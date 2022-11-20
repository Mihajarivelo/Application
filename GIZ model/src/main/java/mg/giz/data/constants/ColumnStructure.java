package mg.giz.data.constants;

public class ColumnStructure {
	private String nom;
	private String nom_champ;
	private Boolean Obligatory;
	private int index;
	private int type;
	
	public ColumnStructure(String nom,String nom_champ,Boolean Obligatory,int index,int type) {
		this.nom = nom;
		this.nom_champ = nom_champ;
		this.Obligatory = Obligatory; 
		this.index = index;
		this.type = type;
	}
	
	public String getNom_champ() {
		return nom_champ;
	}

	public void setNom_champ(String nom_champ) {
		this.nom_champ = nom_champ;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Boolean getObligatory() {
		return Obligatory;
	}
	public void setObligatory(Boolean obligatory) {
		Obligatory = obligatory;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	

}
