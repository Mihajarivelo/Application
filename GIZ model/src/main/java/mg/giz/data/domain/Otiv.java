package mg.giz.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "otiv")
public class Otiv {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer otiv_id;

	@Column(length = 50)
	private String otiv_code;

	public Otiv(Integer otiv_id) {
		this.otiv_id = otiv_id;
	}

	public Otiv() {
		// TODO Auto-generated constructor stub
	}

	public Integer getOtiv_id() {
		return otiv_id;
	}

	public void setOtiv_id(Integer otiv_id) {
		this.otiv_id = otiv_id;
	}

	public String getOtiv_code() {
		return otiv_code;
	}

	public void setOtiv_code(String otiv_code) {
		this.otiv_code = otiv_code;
	}

	@Override
	public String toString() {
		return "Otiv [otiv_id=" + otiv_id + ", otiv_code=" + otiv_code + "]";
	}
}
