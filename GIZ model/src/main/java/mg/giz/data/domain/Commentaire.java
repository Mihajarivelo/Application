package mg.giz.data.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name = "commentaire")
public class Commentaire implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5005168600394033859L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "id")
	private Long id;

	@Column(nullable = false)
	private Date commentaire_date;
	
	@Value("${some.key:}")
	@Column(columnDefinition = "TEXT")
	private String commentaire_texte;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "indicateur_id", nullable = false)
	private Indicateur indicateur;

	@Column(length = 10, insertable = false, updatable = false)
	private String indicateur_id;

	public String getIndicateur_id() {
		return indicateur_id;
	}

	public void setIndicateur_id(String indicateur_id) {
		this.indicateur_id = indicateur_id;
	}

	public Commentaire() {
		super();
	}

	public Commentaire(Long id) {
		super();
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCommentaire_date() {
		return commentaire_date;
	}

	public void setCommentaire_date(Date commentaire_date) {
		this.commentaire_date = commentaire_date;
	}

	public String getCommentaire_texte() {
		return commentaire_texte;
	}

	public void setCommentaire_texte(String commentaire_texte) {
		this.commentaire_texte = commentaire_texte;
	}

	public Indicateur getIndicateur() {
		return indicateur;
	}

	public void setIndicateur(Indicateur indicateur) {
		this.indicateur = indicateur;
	}

	@Override
	public String toString() {
		return "Commentaire [id=" + id + ", commentaire_date=" + commentaire_date + ", commentaire_texte="
				+ commentaire_texte + ", indicateur=" + indicateur + "]";
	}

}
