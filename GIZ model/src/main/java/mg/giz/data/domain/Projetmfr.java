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
@Table(name = "projetmfr")
public class Projetmfr {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Date projetmfr_date;

	private String projetmfr_promotion;
	private String projetmfr_validees;
	private String projetmfr_realisees;
	private String projetmfr_remarque;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "souscomposante_code", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Souscomposante souscomposante;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "theme_id", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Theme theme;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "personne_id", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Personne personne;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "otiv_id", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Otiv otiv;

	@Column(length = 10, insertable = false, updatable = false)
	private String souscomposante_code;
	@Column(insertable = false, updatable = false)
	private Long personne_id;
	@Column(insertable = false, updatable = false)
	private Long theme_id;
	@Column(insertable = false, updatable = false)
	private Integer otiv_id;

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

	public Long getTheme_id() {
		return theme_id;
	}

	public void setTheme_id(Long theme_id) {
		this.theme_id = theme_id;
	}

	public Integer getOtiv_id() {
		return otiv_id;
	}

	public void setOtiv_id(Integer otiv_id) {
		this.otiv_id = otiv_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getProjetmfr_date() {
		return projetmfr_date;
	}

	public void setProjetmfr_date(Date projetmfr_date) {
		this.projetmfr_date = projetmfr_date;
	}

	public String getProjetmfr_promotion() {
		return projetmfr_promotion;
	}

	public void setProjetmfr_promotion(String projetmfr_promotion) {
		this.projetmfr_promotion = projetmfr_promotion;
	}

	public String getProjetmfr_validees() {
		return projetmfr_validees;
	}

	public void setProjetmfr_validees(String projetmfr_validees) {
		this.projetmfr_validees = projetmfr_validees;
	}

	public String getProjetmfr_realisees() {
		return projetmfr_realisees;
	}

	public void setProjetmfr_realisees(String projetmfr_realisees) {
		this.projetmfr_realisees = projetmfr_realisees;
	}

	public String getProjetmfr_remarque() {
		return projetmfr_remarque;
	}

	public void setProjetmfr_remarque(String projetmfr_remarque) {
		this.projetmfr_remarque = projetmfr_remarque;
	}

	public Souscomposante getSouscomposante() {
		return souscomposante;
	}

	public void setSouscomposante(Souscomposante souscomposante) {
		this.souscomposante = souscomposante;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public Otiv getOtiv() {
		return otiv;
	}

	public void setOtiv(Otiv otiv) {
		this.otiv = otiv;
	}

	@Override
	public String toString() {
		return "Projetmfr [id=" + id + ", projetmfr_date=" + projetmfr_date + ", projetmfr_promotion="
				+ projetmfr_promotion + ", projetmfr_validees=" + projetmfr_validees + ", projetmfr_realisees="
				+ projetmfr_realisees + ", projetmfr_remarque=" + projetmfr_remarque + ", souscomposante="
				+ souscomposante + ", theme=" + theme + ", personne=" + personne + ", otiv=" + otiv
				+ ", souscomposante_code=" + souscomposante_code + ", personne_id=" + personne_id + ", theme_id="
				+ theme_id + ", otiv_id=" + otiv_id + "]";
	}
}
