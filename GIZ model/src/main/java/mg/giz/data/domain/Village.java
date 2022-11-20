package mg.giz.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "village")
public class Village {

	@Id
	@Column(length = 32)
	private String code_fkt;

	private String village_nom;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "c_code", nullable = true)
	@Fetch(FetchMode.JOIN)
	private Commune commune;

	@Column(length = 10, insertable = false, updatable = false)
	private String c_code;

	/**
	 * 
	 */
	public Village() {
		super();
	}

	public Village(String code_fkt) {
		this.code_fkt = code_fkt;
	}

	public Commune getCommune() {
		return commune;
	}

	public void setCommune(Commune commune) {
		this.commune = commune;
	}

	public String getC_code() {
		return c_code;
	}

	public void setC_code(String c_code) {
		this.c_code = c_code;
	}

	public String getCode_fkt() {
		return code_fkt;
	}

	public void setCode_fkt(String code_fkt) {
		this.code_fkt = code_fkt;
	}

	public String getVillage_nom() {
		return village_nom;
	}

	public void setVillage_nom(String village_nom) {
		this.village_nom = village_nom;
	}

	@Override
	public String toString() {
		return "Village [code_fkt=" + code_fkt + ", village_nom=" + village_nom + ", commune=" + commune + ", c_code="
				+ c_code + "]";
	}
}
