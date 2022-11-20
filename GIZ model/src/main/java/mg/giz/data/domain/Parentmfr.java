package mg.giz.data.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parentmfr")
public class Parentmfr {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long parentmfr_id;

	private String parentmfr_nom;
	private String parentmfr_fonction;
	private String parentmfr_adresse;
	private String parentmfr_contact;

	public Parentmfr(Long parentmfr_id) {
		this.parentmfr_id = parentmfr_id;
	}

	public Parentmfr() {
		// TODO Auto-generated constructor stub
	}

	public Long getParentmfr_id() {
		return parentmfr_id;
	}

	public void setParentmfr_id(Long parentmfr_id) {
		this.parentmfr_id = parentmfr_id;
	}

	public String getParentmfr_nom() {
		return parentmfr_nom;
	}

	public void setParentmfr_nom(String parentmfr_nom) {
		this.parentmfr_nom = parentmfr_nom;
	}

	public String getParentmfr_fonction() {
		return parentmfr_fonction;
	}

	public void setParentmfr_fonction(String parentmfr_fonction) {
		this.parentmfr_fonction = parentmfr_fonction;
	}

	public String getParentmfr_adresse() {
		return parentmfr_adresse;
	}

	public void setParentmfr_adresse(String parentmfr_adresse) {
		this.parentmfr_adresse = parentmfr_adresse;
	}

	public String getParentmfr_contact() {
		return parentmfr_contact;
	}

	public void setParentmfr_contact(String parentmfr_contact) {
		this.parentmfr_contact = parentmfr_contact;
	}

	@Override
	public String toString() {
		return "Parentmfr [parentmfr_id=" + parentmfr_id + ", parentmfr_nom=" + parentmfr_nom + ", parentmfr_fonction="
				+ parentmfr_fonction + ", parentmfr_adresse=" + parentmfr_adresse + ", parentmfr_contact="
				+ parentmfr_contact + "]";
	}
}
