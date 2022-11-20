package mg.giz.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name = "indicateur")
public class Indicateur {

	@Id
	@Column(length = 10)
	private String indicateur_id;

	@NotBlank
	@Column(columnDefinition = "TEXT")
	private String indicateur_nom;

	private String indicateur_srcdonnees;
	
	@Value("Test @Value")	
	private String indicateur_ennonceobjectif;

	private Double indicateur_objectif = 0.0;

	@Column(length = 80)
	private String indicateur_observation;
	@Column(columnDefinition = "TEXT")
	private String indicateur_situationref;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "souscomposante_code", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Souscomposante souscomposante;

	@Column(length = 10, insertable = false, updatable = false)
	private String souscomposante_code;

	public String getIndicateur_id() {
		return indicateur_id;
	}

	public void setIndicateur_id(String indicateur_id) {
		this.indicateur_id = indicateur_id;
	}

	public String getIndicateur_nom() {
		return indicateur_nom;
	}

	public void setIndicateur_nom(String indicateur_nom) {
		this.indicateur_nom = indicateur_nom;
	}

	public String getIndicateur_srcdonnees() {
		return indicateur_srcdonnees;
	}

	public void setIndicateur_srcdonnees(String indicateur_srcdonnees) {
		this.indicateur_srcdonnees = indicateur_srcdonnees;
	}

	public String getIndicateur_ennonceobjectif() {
		return indicateur_ennonceobjectif;
	}

	public void setIndicateur_ennonceobjectif(String indicateur_ennonceobjectif) {
		this.indicateur_ennonceobjectif = indicateur_ennonceobjectif;
	}

	public Double getIndicateur_objectif() {
		return indicateur_objectif;
	}

	public void setIndicateur_objectif(Double indicateur_objectif) {
		this.indicateur_objectif = indicateur_objectif;
	}

	public String getIndicateur_observation() {
		return indicateur_observation;
	}

	public void setIndicateur_observation(String indicateur_observation) {
		this.indicateur_observation = indicateur_observation;
	}

	public String getIndicateur_situationref() {
		return indicateur_situationref;
	}

	public void setIndicateur_situationref(String indicateur_situationref) {
		this.indicateur_situationref = indicateur_situationref;
	}

	public Souscomposante getSouscomposante() {
		return souscomposante;
	}

	public void setSouscomposante(Souscomposante souscomposante) {
		this.souscomposante = souscomposante;
	}

	public String getSouscomposante_code() {
		return souscomposante_code;
	}

	public void setSouscomposante_code(String souscomposante_code) {
		this.souscomposante_code = souscomposante_code;
	}

	@Override
	public String toString() {
		return "Indicateur [indicateur_id=" + indicateur_id + ", indicateur_nom=" + indicateur_nom
				+ ", indicateur_srcdonnees=" + indicateur_srcdonnees + ", indicateur_ennonceobjectif="
				+ indicateur_ennonceobjectif + ", indicateur_objectif=" + indicateur_objectif
				+ ", indicateur_observation=" + indicateur_observation + ", indicateur_situationref="
				+ indicateur_situationref + ", souscomposante=" + souscomposante + ", souscomposante_code="
				+ souscomposante_code + "]";
	}

}
