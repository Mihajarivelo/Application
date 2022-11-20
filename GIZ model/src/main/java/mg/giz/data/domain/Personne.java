package mg.giz.data.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "personne")
public class Personne {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long personne_id;

	@Column(unique = false)
	private String personne_code;

	private String personne_nom;
	@Column(length = 10)
	private String personne_genre;
	
	private Long personne_anneenaiss;
	private String personne_lieunaiss;
	@Column(length = 50)
	private String personne_cin;
	private String personne_adresse;
	@Column(length = 80)
	private String personne_contact;
	@Column(length = 50)
	private String personne_affiliation;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "code_fkt", nullable = true)
	@Fetch(FetchMode.JOIN)
	private Village village;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parentmfr_id", nullable = true)
	@Fetch(FetchMode.JOIN)
	private Parentmfr parentmfr;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "groupementprod_id", nullable = true)
	@Fetch(FetchMode.JOIN)
	private Groupementprod groupementprod;

	@OneToMany(targetEntity = Beneficierpgm.class, mappedBy = "personne", orphanRemoval = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Beneficierpgm> beneficierpgms;

	@Column(length = 32, insertable = false, updatable = false)
	private String code_fkt;

	public Personne(Long personne_id) {
		this.personne_id = personne_id;
	}

	public Personne() {
		// TODO Auto-generated constructor stub
	}

	public String getCode_fkt() {
		return code_fkt;
	}

	public void setCode_fkt(String code_fkt) {
		this.code_fkt = code_fkt;
	}

	public Long getPersonne_id() {
		return personne_id;
	}

	public void setPersonne_id(Long personne_id) {
		this.personne_id = personne_id;
	}

	public String getPersonne_code() {
		return personne_code;
	}

	public void setPersonne_code(String personne_code) {
		this.personne_code = personne_code;
	}

	public String getPersonne_nom() {
		return personne_nom;
	}

	public void setPersonne_nom(String personne_nom) {
		this.personne_nom = personne_nom;
	}

	public String getPersonne_genre() {
		return personne_genre;
	}

	public void setPersonne_genre(String personne_genre) {
		this.personne_genre = personne_genre;
	}

	public Long getPersonne_anneenaiss() {
		return personne_anneenaiss;
	}

	public void setPersonne_anneenaiss(Long personne_anneenaiss) {
		this.personne_anneenaiss = personne_anneenaiss;
	}

	public String getPersonne_lieunaiss() {
		return personne_lieunaiss;
	}

	public void setPersonne_lieunaiss(String personne_lieunaiss) {
		this.personne_lieunaiss = personne_lieunaiss;
	}

	public String getPersonne_cin() {
		return personne_cin;
	}

	public void setPersonne_cin(String personne_cin) {
		this.personne_cin = personne_cin;
	}

	public String getPersonne_adresse() {
		return personne_adresse;
	}

	public void setPersonne_adresse(String personne_adresse) {
		this.personne_adresse = personne_adresse;
	}

	public String getPersonne_contact() {
		return personne_contact;
	}

	public void setPersonne_contact(String personne_contact) {
		this.personne_contact = personne_contact;
	}

	public String getPersonne_affiliation() {
		return personne_affiliation;
	}

	public void setPersonne_affiliation(String personne_affiliation) {
		this.personne_affiliation = personne_affiliation;
	}

	public Village getVillage() {
		return village;
	}

	public void setVillage(Village village) {
		this.village = village;
	}

	public Parentmfr getParentmfr() {
		return parentmfr;
	}

	public void setParentmfr(Parentmfr parentmfr) {
		this.parentmfr = parentmfr;
	}

	public Groupementprod getGroupementprod() {
		return groupementprod;
	}

	public void setGroupementprod(Groupementprod groupementprod) {
		this.groupementprod = groupementprod;
	}

	public Set<Beneficierpgm> getBeneficierpgms() {
		return beneficierpgms;
	}

	public void setBeneficierpgms(Set<Beneficierpgm> beneficierpgms) {
		this.beneficierpgms = beneficierpgms;
	}


}
