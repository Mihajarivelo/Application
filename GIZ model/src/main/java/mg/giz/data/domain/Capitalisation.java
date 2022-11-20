package mg.giz.data.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "capitalisation")
public class Capitalisation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5453239659767633965L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "id")
	private Long id;

	private String capitalisation_theme;

	@Column(columnDefinition = "TEXT")
	private String capitalisation_activite;

	@Column(columnDefinition = "TEXT")
	private String capitalisation_objectif;

	@Column(columnDefinition = "TEXT")
	private String capitalisation_situationavant;

	@Column(columnDefinition = "TEXT")
	private String capitalisation_situationactuelle;

	@Column(columnDefinition = "TEXT")
	private String capitalisation_directement;

	@Column(columnDefinition = "TEXT")
	private String capitalisation_indirectement;

	@Column(columnDefinition = "TEXT")
	private String capitalisation_positif;

	@Column(columnDefinition = "TEXT")
	private String capitalisation_negatif;

	@Column(columnDefinition = "TEXT")
	private String capitalisation_recommandation;

	public Capitalisation() {
		super();
	}

	public Capitalisation(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCapitalisation_theme() {
		return capitalisation_theme;
	}

	public void setCapitalisation_theme(String capitalisation_theme) {
		this.capitalisation_theme = capitalisation_theme;
	}

	public String getCapitalisation_activite() {
		return capitalisation_activite;
	}

	public void setCapitalisation_activite(String capitalisation_activite) {
		this.capitalisation_activite = capitalisation_activite;
	}

	public String getCapitalisation_objectif() {
		return capitalisation_objectif;
	}

	public void setCapitalisation_objectif(String capitalisation_objectif) {
		this.capitalisation_objectif = capitalisation_objectif;
	}

	public String getCapitalisation_situationavant() {
		return capitalisation_situationavant;
	}

	public void setCapitalisation_situationavant(String capitalisation_situationavant) {
		this.capitalisation_situationavant = capitalisation_situationavant;
	}

	public String getCapitalisation_situationactuelle() {
		return capitalisation_situationactuelle;
	}

	public void setCapitalisation_situationactuelle(String capitalisation_situationactuelle) {
		this.capitalisation_situationactuelle = capitalisation_situationactuelle;
	}

	public String getCapitalisation_directement() {
		return capitalisation_directement;
	}

	public void setCapitalisation_directement(String capitalisation_directement) {
		this.capitalisation_directement = capitalisation_directement;
	}

	public String getCapitalisation_indirectement() {
		return capitalisation_indirectement;
	}

	public void setCapitalisation_indirectement(String capitalisation_indirectement) {
		this.capitalisation_indirectement = capitalisation_indirectement;
	}

	public String getCapitalisation_positif() {
		return capitalisation_positif;
	}

	public void setCapitalisation_positif(String capitalisation_positif) {
		this.capitalisation_positif = capitalisation_positif;
	}

	public String getCapitalisation_negatif() {
		return capitalisation_negatif;
	}

	public void setCapitalisation_negatif(String capitalisation_negatif) {
		this.capitalisation_negatif = capitalisation_negatif;
	}

	public String getCapitalisation_recommandation() {
		return capitalisation_recommandation;
	}

	public void setCapitalisation_recommandation(String capitalisation_recommandation) {
		this.capitalisation_recommandation = capitalisation_recommandation;
	}

	@Override
	public String toString() {
		return "Capitalisation [id=" + id + ", capitalisation_theme=" + capitalisation_theme
				+ ", capitalisation_activite=" + capitalisation_activite + ", capitalisation_objectif="
				+ capitalisation_objectif + ", capitalisation_situationavant=" + capitalisation_situationavant
				+ ", capitalisation_situationactuelle=" + capitalisation_situationactuelle
				+ ", capitalisation_directement=" + capitalisation_directement + ", capitalisation_indirectement="
				+ capitalisation_indirectement + ", capitalisation_positif=" + capitalisation_positif
				+ ", capitalisation_negatif=" + capitalisation_negatif + ", capitalisation_recommandation="
				+ capitalisation_recommandation + "]";
	}
}
