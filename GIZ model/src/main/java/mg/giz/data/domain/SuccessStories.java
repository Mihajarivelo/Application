package mg.giz.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "successStories")
public class SuccessStories {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Lob
	private byte[] file;

	@NotBlank
	@Column(name = "district", nullable = false, length = 50)
	private String district;

	@NotBlank
	@Column(name = "village", nullable = false, length = 50)
	private String village;

	@NotBlank
	@Column(name = "proprietaire", nullable = false, length = 50)
	private String proprietaire;

	@NotBlank
	@Column(name = "commune", nullable = false, length = 50)
	private String commune;

	@NotBlank
	@Column(name = "thematique", nullable = false)
	private String thematique;

	@NotBlank
	@Column(name = "fileType", nullable = false)
	private String fileType;

	@NotBlank
	@Column(name = "fileName",columnDefinition = "TEXT")
	private String fileName;

	public SuccessStories(byte[] file, String district, String village, String proprietaire, String commune,
			String thematique, String fileType, String fileName) {
		super();
		this.file = file;
		this.district = district;
		this.village = village;
		this.proprietaire = proprietaire;
		this.commune = commune;
		this.thematique = thematique;
		this.fileType = fileType;
		this.fileName = fileName;
	}

	public SuccessStories(Long id, byte[] file, String district, String village, String proprietaire, String commune,
			String thematique, String fileType, String fileName) {
		super();
		this.id = id;
		this.file = file;
		this.district = district;
		this.village = village;
		this.proprietaire = proprietaire;
		this.commune = commune;
		this.thematique = thematique;
		this.fileType = fileType;
		this.fileName = fileName;
	}

	public SuccessStories() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}

	public String getCommune() {
		return commune;
	}

	public void setCommune(String commune) {
		this.commune = commune;
	}

	public String getThematique() {
		return thematique;
	}

	public void setThematique(String thematique) {
		this.thematique = thematique;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

}
