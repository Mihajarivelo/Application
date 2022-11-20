package mg.giz.data.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "suivithemecoop")
public class Suivithemecoop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer suivitheme_homme;
	private Integer suivitheme_femme;
	private String suivitheme_comm;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSuivitheme_homme() {
		return suivitheme_homme;
	}

	public void setSuivitheme_homme(Integer suivitheme_homme) {
		this.suivitheme_homme = suivitheme_homme;
	}

	public Integer getSuivitheme_femme() {
		return suivitheme_femme;
	}

	public void setSuivitheme_femme(Integer suivitheme_femme) {
		this.suivitheme_femme = suivitheme_femme;
	}

	public String getSuivitheme_comm() {
		return suivitheme_comm;
	}

	public void setSuivitheme_comm(String suivitheme_comm) {
		this.suivitheme_comm = suivitheme_comm;
	}

	@Override
	public String toString() {
		return "Suivithemecoop [id=" + id + ", suivitheme_homme=" + suivitheme_homme + ", suivitheme_femme="
				+ suivitheme_femme + ", suivitheme_comm=" + suivitheme_comm + "]";
	}
}
