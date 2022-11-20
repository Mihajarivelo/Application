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
@Table(name = "subventionepp")
public class Subventionepp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer subventionepp_id;

	private String subventionepp_lib;
	private Double subventionepp_mont;

	@OneToMany(targetEntity = Subvenirepp.class, mappedBy = "subventionepp", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
	private Set<Subvenirepp> subvenirepps;

	public Integer getSubventionepp_id() {
		return subventionepp_id;
	}

	public void setSubventionepp_id(Integer subventionepp_id) {
		this.subventionepp_id = subventionepp_id;
	}

	public String getSubventionepp_lib() {
		return subventionepp_lib;
	}

	public void setSubventionepp_lib(String subventionepp_lib) {
		this.subventionepp_lib = subventionepp_lib;
	}

	public Double getSubventionepp_mont() {
		return subventionepp_mont;
	}

	public void setSubventionepp_mont(Double subventionepp_mont) {
		this.subventionepp_mont = subventionepp_mont;
	}

	public Set<Subvenirepp> getSubvenirepps() {
		return subvenirepps;
	}

	public void setSubvenirepps(Set<Subvenirepp> subvenirepps) {
		this.subvenirepps = subvenirepps;
	}

	@Override
	public String toString() {
		return "Subventionepp [subventionepp_id=" + subventionepp_id + ", subventionepp_lib=" + subventionepp_lib
				+ ", subventionepp_mont=" + subventionepp_mont + ", subvenirepps=" + subvenirepps + "]";
	}
}
