package mg.giz.data.dto;

public class IndicateurDto {

	private String indicateurCode;
	private String indicateurNom;
	private String indicateurSrcdonnees;
	private Double indicateurObjectif;
	private String indicateurObservation;
	private String indicateurSituationref;
	private Long nbreBeneficiaires;
	private String pourcentageRealisation;

	public String getIndicateurCode() {
		return indicateurCode;
	}

	public void setIndicateurCode(String indicateurCode) {
		this.indicateurCode = indicateurCode;
	}

	public String getIndicateurNom() {
		return indicateurNom;
	}

	public void setIndicateurNom(String indicateurNom) {
		this.indicateurNom = indicateurNom;
	}

	public String getIndicateurSrcdonnees() {
		return indicateurSrcdonnees;
	}

	public void setIndicateurSrcdonnees(String indicateurSrcdonnees) {
		this.indicateurSrcdonnees = indicateurSrcdonnees;
	}

	public Double getIndicateurObjectif() {
		return indicateurObjectif;
	}

	public void setIndicateurObjectif(Double indicateurObjectif) {
		this.indicateurObjectif = indicateurObjectif;
	}

	public String getIndicateurObservation() {
		return indicateurObservation;
	}

	public void setIndicateurObservation(String indicateurObservation) {
		this.indicateurObservation = indicateurObservation;
	}

	public String getIndicateurSituationref() {
		return indicateurSituationref;
	}

	public void setIndicateurSituationref(String indicateurSituationref) {
		this.indicateurSituationref = indicateurSituationref;
	}

	public Long getNbreBeneficiaires() {
		return nbreBeneficiaires;
	}

	public void setNbreBeneficiaires(Long nbreBeneficiaires) {
		this.nbreBeneficiaires = nbreBeneficiaires;
	}

	public String getPourcentageRealisation() {
		return pourcentageRealisation;
	}

	public void setPourcentageRealisation(String pourcentageRealisation) {
		this.pourcentageRealisation = pourcentageRealisation;
	}
}
