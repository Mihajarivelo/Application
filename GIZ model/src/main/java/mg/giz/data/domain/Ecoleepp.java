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
@Table(name = "ecoleepp")
public class Ecoleepp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ecoleepp_id;

	private String ecoleepp_nom;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "souscomposante_code", nullable = true)
	@Fetch(FetchMode.JOIN)
	private Souscomposante souscomposante;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "code_fkt", nullable = true)
	@Fetch(FetchMode.JOIN)
	private Village village;

	@OneToMany(targetEntity = Concerner.class, mappedBy = "ecoleepp", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
	private Set<Concerner> concerners;

	@OneToMany(targetEntity = Subvenirepp.class, mappedBy = "ecoleepp", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
	private Set<Subvenirepp> subvenirepps;

	@Column(length = 32, insertable = false, updatable = false)
	private String code_fkt;
	@Column(length = 10, insertable = false, updatable = false)
	private String souscomposante_code;

	public Ecoleepp(Long ecoleepp_id) {
		this.ecoleepp_id = ecoleepp_id;
	}

	public Ecoleepp() {
		// TODO Auto-generated constructor stub
	}

	public String getCode_fkt() {
		return code_fkt;
	}

	public void setCode_fkt(String code_fkt) {
		this.code_fkt = code_fkt;
	}

	public String getSouscomposante_code() {
		return souscomposante_code;
	}

	public void setSouscomposante_code(String souscomposante_code) {
		this.souscomposante_code = souscomposante_code;
	}

	public Long getEcoleepp_id() {
		return ecoleepp_id;
	}

	public void setEcoleepp_id(Long ecoleepp_id) {
		this.ecoleepp_id = ecoleepp_id;
	}

	public String getEcoleepp_nom() {
		return ecoleepp_nom;
	}

	public void setEcoleepp_nom(String ecoleepp_nom) {
		this.ecoleepp_nom = ecoleepp_nom;
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

	public Set<Concerner> getConcerners() {
		return concerners;
	}

	public void setConcerners(Set<Concerner> concerners) {
		this.concerners = concerners;
	}

	public Set<Subvenirepp> getSubvenirepps() {
		return subvenirepps;
	}

	public void setSubvenirepps(Set<Subvenirepp> subvenirepps) {
		this.subvenirepps = subvenirepps;
	}

	@Override
	public String toString() {
		return "Ecoleepp [ecoleepp_id=" + ecoleepp_id + ", ecoleepp_nom=" + ecoleepp_nom + ", souscomposante="
				+ souscomposante + ", village=" + village + ", concerners=" + concerners + ", subvenirepps="
				+ subvenirepps + ", code_fkt=" + code_fkt + ", souscomposante_code=" + souscomposante_code + "]";
	}
}
