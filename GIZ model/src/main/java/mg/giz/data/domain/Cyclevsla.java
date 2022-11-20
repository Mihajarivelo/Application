package mg.giz.data.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cyclevsla")
public class Cyclevsla {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cyclevsla_id;

	@Column(length = 50)
	private String cyclevsla_lib;

	@OneToMany(targetEntity = Avoircycle.class, mappedBy = "cyclevsla", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
	private Set<Avoircycle> avoircycles;

	public Integer getCyclevsla_id() {
		return cyclevsla_id;
	}

	public void setCyclevsla_id(Integer cyclevsla_id) {
		this.cyclevsla_id = cyclevsla_id;
	}

	public String getCyclevsla_lib() {
		return cyclevsla_lib;
	}

	public void setCyclevsla_lib(String cyclevsla_lib) {
		this.cyclevsla_lib = cyclevsla_lib;
	}

	public Set<Avoircycle> getAvoircycles() {
		return avoircycles;
	}

	public void setAvoircycles(Set<Avoircycle> avoircycles) {
		this.avoircycles = avoircycles;
	}

	@Override
	public String toString() {
		return "Cyclevsla [cyclevsla_id=" + cyclevsla_id + ", cyclevsla_lib=" + cyclevsla_lib + ", avoircycles="
				+ avoircycles + "]";
	}
}
