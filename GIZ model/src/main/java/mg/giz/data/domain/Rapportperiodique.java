package mg.giz.data.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "rapportperiodique")
public class Rapportperiodique implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5711186166028001512L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "id")
	private Long id;

	@Column(nullable = true)
	private String rapportperiodique_type;
	@Column(nullable = true)
	private String rapportperiodique_typelib;

	@Column(nullable = false)
	private Date rapportperiodique_situation;

	private Double rapportperiodique_valeur;

	@Column(columnDefinition = "TEXT")
	private String rapportperiodique_comm;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "indicateur_id", nullable = false)
	private Indicateur indicateur;

	@Column(length = 10, insertable = false, updatable = false)
	private String indicateur_id;

	public String getIndicateur_id() {
		return indicateur_id;
	}

	public void setIndicateur_id(String indicateur_id) {
		this.indicateur_id = indicateur_id;
	}

	public Rapportperiodique() {
		super();
	}

	public Rapportperiodique(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRapportperiodique_type() {
		return rapportperiodique_type;
	}

	public void setRapportperiodique_type(String rapportperiodique_type) {
		this.rapportperiodique_type = rapportperiodique_type;
	}

	public String getRapportperiodique_typelib() {
		return rapportperiodique_typelib;
	}

	public void setRapportperiodique_typelib(String rapportperiodique_typelib) {
		this.rapportperiodique_typelib = rapportperiodique_typelib;
	}

	public Date getRapportperiodique_situation() {
		return rapportperiodique_situation;
	}

	public void setRapportperiodique_situation(Date rapportperiodique_situation) {
		this.rapportperiodique_situation = rapportperiodique_situation;
	}

	public Double getRapportperiodique_valeur() {
		return rapportperiodique_valeur;
	}

	public void setRapportperiodique_valeur(Double rapportperiodique_valeur) {
		this.rapportperiodique_valeur = rapportperiodique_valeur;
	}

	public String getRapportperiodique_comm() {
		return rapportperiodique_comm;
	}

	public void setRapportperiodique_comm(String rapportperiodique_comm) {
		this.rapportperiodique_comm = rapportperiodique_comm;
	}

	public Indicateur getIndicateur() {
		return indicateur;
	}

	public void setIndicateur(Indicateur indicateur) {
		this.indicateur = indicateur;
	}

	@Override
	public String toString() {
		return "Rapportperiodique [id=" + id + ", rapportperiodique_type=" + rapportperiodique_type
				+ ", rapportperiodique_typelib=" + rapportperiodique_typelib + ", rapportperiodique_situation="
				+ rapportperiodique_situation + ", rapportperiodique_valeur=" + rapportperiodique_valeur
				+ ", rapportperiodique_comm=" + rapportperiodique_comm + ", indicateur=" + indicateur
				+ ", indicateur_id=" + indicateur_id + "]";
	}
}
