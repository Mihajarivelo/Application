package mg.giz.data.domain;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "beneficierpgm")
public class Beneficierpgm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "theme_id", nullable = false)
	@Fetch(FetchMode.JOIN)
	//@NotFound(action=NotFoundAction.IGNORE)  
	private Theme theme;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "personne_id", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Personne personne;

	@Column(nullable = true)
	private Date beneficierpgm_date;

	private Long beneficierpgm_valeur;
	private Integer beneficierpgm_groupemod;

	@Column(length = 20)
	private String inscrismfr_anneesco;
	@Column(length = 100)
	private String inscrismfr_niveau;
	@Column(length = 100)
	private String beneficierpgm_speculation;
	private Integer beneficierpgm_effectif;
	@Column(length = 100)
	private String beneficierpgm_plandevieun;
	@Column(length = 100)
	private String beneficierpgm_plandeviedeux;
	@Column(length = 100)
	private String beneficierpgm_lieu;

	@Column(insertable = false, updatable = false)
	private Long personne_id;
	@Column(insertable = false, updatable = false)
	private Long theme_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getBeneficierpgm_date() {
		return beneficierpgm_date;
	}

	public void setBeneficierpgm_date(Date beneficierpgm_date) {
		this.beneficierpgm_date = beneficierpgm_date;
	}

	public Long getBeneficierpgm_valeur() {
		return beneficierpgm_valeur;
	}

	public void setBeneficierpgm_valeur(Long beneficierpgm_valeur) {
		this.beneficierpgm_valeur = beneficierpgm_valeur;
	}

	public Integer getBeneficierpgm_groupemod() {
		return beneficierpgm_groupemod;
	}

	public void setBeneficierpgm_groupemod(Integer beneficierpgm_groupemod) {
		this.beneficierpgm_groupemod = beneficierpgm_groupemod;
	}

	public String getInscrismfr_anneesco() {
		return inscrismfr_anneesco;
	}

	public void setInscrismfr_anneesco(String inscrismfr_anneesco) {
		this.inscrismfr_anneesco = inscrismfr_anneesco;
	}

	public String getInscrismfr_niveau() {
		return inscrismfr_niveau;
	}

	public void setInscrismfr_niveau(String inscrismfr_niveau) {
		this.inscrismfr_niveau = inscrismfr_niveau;
	}

	public String getBeneficierpgm_speculation() {
		return beneficierpgm_speculation;
	}

	public void setBeneficierpgm_speculation(String beneficierpgm_speculation) {
		this.beneficierpgm_speculation = beneficierpgm_speculation;
	}

	public Integer getBeneficierpgm_effectif() {
		return beneficierpgm_effectif;
	}

	public void setBeneficierpgm_effectif(Integer beneficierpgm_effectif) {
		this.beneficierpgm_effectif = beneficierpgm_effectif;
	}

	public String getBeneficierpgm_plandevieun() {
		return beneficierpgm_plandevieun;
	}

	public void setBeneficierpgm_plandevieun(String beneficierpgm_plandevieun) {
		this.beneficierpgm_plandevieun = beneficierpgm_plandevieun;
	}

	public String getBeneficierpgm_plandeviedeux() {
		return beneficierpgm_plandeviedeux;
	}

	public void setBeneficierpgm_plandeviedeux(String beneficierpgm_plandeviedeux) {
		this.beneficierpgm_plandeviedeux = beneficierpgm_plandeviedeux;
	}

	public String getBeneficierpgm_lieu() {
		return beneficierpgm_lieu;
	}

	public void setBeneficierpgm_lieu(String beneficierpgm_lieu) {
		this.beneficierpgm_lieu = beneficierpgm_lieu;
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

	@Override
	public String toString() {
		return "Beneficierpgm [id=" + id + ", theme=" + theme + ", personne=" + personne + ", beneficierpgm_date="
				+ beneficierpgm_date + ", beneficierpgm_valeur=" + beneficierpgm_valeur + ", beneficierpgm_groupemod="
				+ beneficierpgm_groupemod + ", inscrismfr_anneesco=" + inscrismfr_anneesco + ", inscrismfr_niveau="
				+ inscrismfr_niveau + ", beneficierpgm_speculation=" + beneficierpgm_speculation
				+ ", beneficierpgm_effectif=" + beneficierpgm_effectif + ", beneficierpgm_plandevieun="
				+ beneficierpgm_plandevieun + ", beneficierpgm_plandeviedeux=" + beneficierpgm_plandeviedeux
				+ ", beneficierpgm_lieu=" + beneficierpgm_lieu + ", personne_id=" + personne_id + ", theme_id="
				+ theme_id + "]";
	}

}
