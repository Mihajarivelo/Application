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
@Table(name = "formateur")
public class Formateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String formateur_nom;
	private String formateur_adresse;
	private String formateur_fonction;
	@Column(length = 10)
	private String formateur_genre;

	@Column(nullable = false)
	private Date formateur_date;

	@Column(length = 100)
	private String formateur_contact;
	private String formateur_observation;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "typepersonne_id", nullable = true)
	@Fetch(FetchMode.JOIN)
	private Typepersonne typepersonne;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "souscomposante_code", nullable = true)
	@Fetch(FetchMode.JOIN)
	private Souscomposante souscomposante;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "code_fkt", nullable = true)
	@Fetch(FetchMode.JOIN)
	private Village village;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "theme_id", nullable = true)
	@Fetch(FetchMode.JOIN)
	private Theme theme;

	@Column(insertable = false, updatable = false)
	private Integer typepersonne_id;
	@Column(length = 10, insertable = false, updatable = false)
	private String souscomposante_code;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFormateur_nom() {
		return formateur_nom;
	}

	public void setFormateur_nom(String formateur_nom) {
		this.formateur_nom = formateur_nom;
	}

	public String getFormateur_genre() {
		return formateur_genre;
	}

	public void setFormateur_genre(String formateur_genre) {
		this.formateur_genre = formateur_genre;
	}

	public Date getFormateur_date() {
		return formateur_date;
	}

	public void setFormateur_date(Date formateur_date) {
		this.formateur_date = formateur_date;
	}

	public String getFormateur_contact() {
		return formateur_contact;
	}

	public void setFormateur_contact(String formateur_contact) {
		this.formateur_contact = formateur_contact;
	}

	public String getFormateur_observation() {
		return formateur_observation;
	}

	public void setFormateur_observation(String formateur_observation) {
		this.formateur_observation = formateur_observation;
	}

	public Typepersonne getTypepersonne() {
		return typepersonne;
	}

	public void setTypepersonne(Typepersonne typepersonne) {
		this.typepersonne = typepersonne;
	}

	public Souscomposante getSouscomposante() {
		return souscomposante;
	}

	public void setSouscomposante(Souscomposante souscomposante) {
		this.souscomposante = souscomposante;
	}

	public Village getVillage() {
		return village;
	}

	public void setVillage(Village village) {
		this.village = village;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public String getFormateur_adresse() {
		return formateur_adresse;
	}

	public void setFormateur_adresse(String formateur_adresse) {
		this.formateur_adresse = formateur_adresse;
	}

	public String getFormateur_fonction() {
		return formateur_fonction;
	}

	public void setFormateur_fonction(String formateur_fonction) {
		this.formateur_fonction = formateur_fonction;
	}

	@Override
	public String toString() {
		return "Formateur [id=" + id + ", formateur_nom=" + formateur_nom + ", formateur_genre=" + formateur_genre
				+ ", formateur_date=" + formateur_date + ", formateur_contact=" + formateur_contact
				+ ", formateur_observation=" + formateur_observation + ", typepersonne=" + typepersonne
				+ ", souscomposante=" + souscomposante + ", village=" + village + ", theme=" + theme
				+ ", typepersonne_id=" + typepersonne_id + ", souscomposante_code=" + souscomposante_code + "]";
	}

}
