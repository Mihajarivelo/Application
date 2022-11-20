package mg.giz.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "region")
public class Region {

	@Id
	@Column(length = 5)
	private String r_code;

	@Column(length = 100)
	private String region;

	public String getR_code() {
		return r_code;
	}

	public void setR_code(String r_code) {
		this.r_code = r_code;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}


}
