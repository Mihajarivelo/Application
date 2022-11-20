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
@Table(name = "fermepilote")
public class Fermepilote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String fermepilote_lib;

	@Column(nullable = false)
	private Date fermepilote_date;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "souscomposante_code", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Souscomposante souscomposante;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "personne_id", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Personne personne;

	@Column(insertable = false, updatable = false)
	private Long personne_id;
	@Column(length = 10, insertable = false, updatable = false)
	private String souscomposante_code;

	public Long getPersonne_id() {
		return personne_id;
	}

	public void setPersonne_id(Long personne_id) {
		this.personne_id = personne_id;
	}

	public String getSouscomposante_code() {
		return souscomposante_code;
	}

	public void setSouscomposante_code(String souscomposante_code) {
		this.souscomposante_code = souscomposante_code;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFermepilote_lib() {
		return fermepilote_lib;
	}

	public void setFermepilote_lib(String fermepilote_lib) {
		this.fermepilote_lib = fermepilote_lib;
	}

	public Date getFermepilote_date() {
		return fermepilote_date;
	}

	public void setFermepilote_date(Date fermepilote_date) {
		this.fermepilote_date = fermepilote_date;
	}

	public Souscomposante getSouscomposante() {
		return souscomposante;
	}

	public void setSouscomposante(Souscomposante souscomposante) {
		this.souscomposante = souscomposante;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	@Override
	public String toString() {
		return "Fermepilote [id=" + id + ", fermepilote_lib=" + fermepilote_lib + ", fermepilote_date="
				+ fermepilote_date + ", souscomposante=" + souscomposante + ", personne=" + personne + ", personne_id="
				+ personne_id + ", souscomposante_code=" + souscomposante_code + "]";
	}
}
