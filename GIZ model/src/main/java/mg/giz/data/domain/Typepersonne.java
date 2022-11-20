package mg.giz.data.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "typepersonne")
public class Typepersonne {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1796973047697012012L;

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer typepersonne_id;

	private String typepersonne_nom;

	/**
	 * 
	 */
	public Typepersonne() {
		super();
	}

	public Typepersonne(int typepersonne_id) {
		this.typepersonne_id = typepersonne_id;
	}

	public Integer getTypepersonne_id() {
		return typepersonne_id;
	}

	public void setTypepersonne_id(Integer typepersonne_id) {
		this.typepersonne_id = typepersonne_id;
	}

	public String getTypepersonne_nom() {
		return typepersonne_nom;
	}

	public void setTypepersonne_nom(String typepersonne_nom) {
		this.typepersonne_nom = typepersonne_nom;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Typepersonne [typepersonne_id=" + typepersonne_id + ", typepersonne_nom=" + typepersonne_nom + "]";
	}
}
