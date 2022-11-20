package mg.giz.data.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "typerapport")
public class Typerapport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4013930723018477390L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "id")
	private int id;

	private String typerapport_lib;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTyperapport_lib() {
		return typerapport_lib;
	}

	public void setTyperapport_lib(String typerapport_lib) {
		this.typerapport_lib = typerapport_lib;
	}

	@Override
	public String toString() {
		return "Typerapport [id=" + id + ", typerapport_lib=" + typerapport_lib + "]";
	}
}
