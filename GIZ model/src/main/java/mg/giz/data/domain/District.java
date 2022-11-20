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
@Table(name = "district")
public class District {

	@Id
	@Column(length = 10)
	private String d_code;

	@Column(length = 75)
	private String district;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "r_code", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Region region;

	@Column(length = 5, insertable = false, updatable = false)
	private String r_code;

	public String getD_code() {
		return d_code;
	}

	public void setD_code(String d_code) {
		this.d_code = d_code;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public String getR_code() {
		return r_code;
	}

	public void setR_code(String r_code) {
		this.r_code = r_code;
	}


}
