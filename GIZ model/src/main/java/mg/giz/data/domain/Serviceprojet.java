package mg.giz.data.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "serviceprojet")
public class Serviceprojet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long serviceprojet_id;

	private String serviceprojet_nom;

	@OneToMany(targetEntity = Mettreoeuvre.class, mappedBy = "serviceprojet", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
	private Set<Mettreoeuvre> mettreoeuvres;

	public Serviceprojet(Long serviceprojet_id) {
		this.serviceprojet_id = serviceprojet_id;
	}

	public Serviceprojet() {
		// TODO Auto-generated constructor stub
	}

	public Long getServiceprojet_id() {
		return serviceprojet_id;
	}

	public void setServiceprojet_id(Long serviceprojet_id) {
		this.serviceprojet_id = serviceprojet_id;
	}

	public String getServiceprojet_nom() {
		return serviceprojet_nom;
	}

	public void setServiceprojet_nom(String serviceprojet_nom) {
		this.serviceprojet_nom = serviceprojet_nom;
	}

	public Set<Mettreoeuvre> getMettreoeuvres() {
		return mettreoeuvres;
	}

	public void setMettreoeuvres(Set<Mettreoeuvre> mettreoeuvres) {
		this.mettreoeuvres = mettreoeuvres;
	}

	@Override
	public String toString() {
		return "Serviceprojet [serviceprojet_id=" + serviceprojet_id + ", serviceprojet_nom=" + serviceprojet_nom
				+ ", mettreoeuvres=" + mettreoeuvres + "]";
	}
}
