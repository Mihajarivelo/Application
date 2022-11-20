package mg.giz.data.domain;

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
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "historique")
public class Historique {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Date historique_date;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "souscomposante_code", nullable = true)
	@Fetch(FetchMode.JOIN)
	private Souscomposante souscomposante;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "typepersonne_id", nullable = true)
	@Fetch(FetchMode.JOIN)
	private Typepersonne typepersonne;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "personne_id", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Personne personne;

	@Column(insertable = false, updatable = false)
	private Integer typepersonne_id;
	
	@Column(length = 10, insertable = false, updatable = false)
	private String souscomposante_code;
	
	@Column(insertable = false, updatable = false)
	private Long personne_id;

	public Integer getTypepersonne_id() {
		return typepersonne_id;
	}

	public void setTypepersonne_id(Integer typepersonne_id) {
		this.typepersonne_id = typepersonne_id;
	}

	public String getSouscomposante_code() {
		return souscomposante_code;
	}

	public void setSouscomposante_code(String souscomposante_code) {
		this.souscomposante_code = souscomposante_code;
	}

	public Long getPersonne_id() {
		return personne_id;
	}

	public void setPersonne_id(Long personne_id) {
		this.personne_id = personne_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getHistorique_date() {
		return historique_date;
	}

	public void setHistorique_date(Date historique_date) {
		this.historique_date = historique_date;
	}

	public Souscomposante getSouscomposante() {
		return souscomposante;
	}

	public void setSouscomposante(Souscomposante souscomposante) {
		this.souscomposante = souscomposante;
	}

	public Typepersonne getTypepersonne() {
		return typepersonne;
	}

	public void setTypepersonne(Typepersonne typepersonne) {
		this.typepersonne = typepersonne;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	@Override
	public String toString() {
		return "Historique [id=" + id + ", historique_date=" + historique_date + ", souscomposante=" + souscomposante
				+ ", typepersonne=" + typepersonne + ", personne=" + personne + ", typepersonne_id=" + typepersonne_id
				+ ", souscomposante_code=" + souscomposante_code + ", personne_id=" + personne_id + "]";
	}

}
