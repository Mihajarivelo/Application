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
@Table(name = "commune")
public class Commune {

	@Id
	@Column(length = 10)
	private String c_code;

	@Column(length = 75)
	private String commune;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "d_code", nullable = false)
	@Fetch(FetchMode.JOIN)
	private District district;

	@Column(length = 10, insertable = false, updatable = false)
	private String d_code;

	public String getC_code() {
		return c_code;
	}

	public void setC_code(String c_code) {
		this.c_code = c_code;
	}

	public String getCommune() {
		return commune;
	}

	public void setCommune(String commune) {
		this.commune = commune;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public String getD_code() {
		return d_code;
	}

	public void setD_code(String d_code) {
		this.d_code = d_code;
	}

	
}
