package mg.giz.service.metier;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mg.giz.repository.BeneficiaryTableRepository;

@Service
public class BeneficiaryTableQueryService {

	@Resource
	private BeneficiaryTableRepository beneficiaryTableRepository;

	// Farmer Business Schools, (Comp 1a) = Men
	public List<String> getFBSMenData() {
		List<String> listFBSMen = beneficiaryTableRepository.fetchFBSMenData();
		return listFBSMen;
	}

	// Farmer Business Schools, (Comp 1a) = Women
	public List<String> getFBSWomenData() {
		List<String> listFBSWomen = beneficiaryTableRepository.fetchFBSWomenData();
		return listFBSWomen;
	}

	// coopératives strengthening 1b = Men
	public List<String> getCooperativesStrengtheninMengData() {
		List<String> listCooperativesStrengtheninMen = beneficiaryTableRepository
				.fetchCooperativesStrengtheninMengData();
		return listCooperativesStrengtheninMen;
	}

	// coopératives strengthening 1b = Women
	public List<String> getCooperativesStrengtheningWomenData() {
		List<String> listCooperativesStrengtheningWomen = beneficiaryTableRepository
				.fetchCooperativesStrengtheningWomenData();
		return listCooperativesStrengtheningWomen;
	}

	// ASA = Men
	public List<String> getASAMenData() {
		List<String> listASAMen = beneficiaryTableRepository.fetchASAMenData();
		return listASAMen;
	}

	// ASA = Women
	public List<String> getASAWomenData() {
		List<String> listASAWomen = beneficiaryTableRepository.fetchASAWomenData();
		return listASAWomen;
	}

	// formateurs élevage = Men
	public List<String> getFormateursElevageMenData() {
		List<String> listFormateursElevageMen = beneficiaryTableRepository.fetchFormateursElevageMenData();
		return listFormateursElevageMen;
	}

	// formateurs élevage = Women
	public List<String> getFormateursElevageWomenData() {
		List<String> listFormateursElevageWomen = beneficiaryTableRepository.fetchFormateursElevageWomenData();
		return listFormateursElevageWomen;
	}

	// bénéficiaires formation en petit élevage y compirs prod et non prod = Men
	public List<String> getBeneficiairesFormationPetitElevageMenData() {
		List<String> listBeneficiairesFormationPetitElevageMen = beneficiaryTableRepository
				.fetchBeneficiairesFormationPetitElevageMenData();
		return listBeneficiairesFormationPetitElevageMen;
	}

	// bénéficiaires formation en petit élevage y compirs prod et non prod = Women
	public List<String> getBeneficiairesFormationPetitElevageWomenData() {
		List<String> listBeneficiairesFormationPetitElevageWomen = beneficiaryTableRepository
				.fetchBeneficiairesFormationPetitElevageWomenData();
		return listBeneficiairesFormationPetitElevageWomen;
	}

	// Children at Primary Public Schools = Boys
	public List<String> getChildrenPrimaryPublicSchoolsBoysData() {
		List<String> listChildrenPrimaryPublicSchoolsBoys = beneficiaryTableRepository
				.fetchChildrenPrimaryPublicSchoolsBoysData();
		return listChildrenPrimaryPublicSchoolsBoys;
	}

	// Children at Primary Public Schools = Girls
	public List<String> getChildrenPrimaryPublicSchoolsGirlsData() {
		List<String> listChildrenPrimaryPublicSchoolsGirls = beneficiaryTableRepository
				.fetchChildrenPrimaryPublicSchoolsGirlsData();
		return listChildrenPrimaryPublicSchoolsGirls;
	}

	// Jeunes MFR = Boys
	public List<String> getJeunesMFRBoysData() {
		List<String> listJeunesMFRBoys = beneficiaryTableRepository.fetchJeunesMFRBoysData();
		return listJeunesMFRBoys;
	}

	// Jeunes MFR = Girls
	public List<String> getJeunesMFRGirlsData() {
		List<String> listJeunesMFRGirl = beneficiaryTableRepository.fetchJeunesMFRGirlsData();
		return listJeunesMFRGirl;
	}

	// Enseignants formés en éducation environnementale = Men
	public List<String> getEnseignantsFormesMenData() {
		List<String> listEnseignantsFormesMen = beneficiaryTableRepository.fetchEnseignantsFormesMenData();
		return listEnseignantsFormesMen;
	}

	// Enseignants formés en éducation environnementale = Women
	public List<String> getEnseignantsFormesWomenData() {
		List<String> listEnseignantsFormesWomen = beneficiaryTableRepository.fetchEnseignantsFormesWomenData();
		return listEnseignantsFormesWomen;
	}

	// Healthcare and WASH (Comp 2b) = Boys
	public List<String> getHealthcareWASHBoysData() {
		List<String> listHealthcareWASHBoys = beneficiaryTableRepository.fetchHealthcareWASHBoysData();
		return listHealthcareWASHBoys;
	}

	// Healthcare and WASH (Comp 2b) = Girls
	public List<String> getHealthcareWASHGirlsData() {
		List<String> listHealthcareWASHGirls = beneficiaryTableRepository.fetchHealthcareWASHGirlsData();
		return listHealthcareWASHGirls;
	}

	// Healthcare and WASH (Comp 2b) = Men
	public List<String> getHealthcareWASHMenData() {
		List<String> listHealthcareWASHMen = beneficiaryTableRepository.fetchHealthcareWASHMenData();
		return listHealthcareWASHMen;
	}

	// Healthcare and WASH (Comp 2b) = Women
	public List<String> getHealthcareWASHWomenData() {
		List<String> listHealthcareWASHWomen = beneficiaryTableRepository.fetchHealthcareWASHWomenData();
		return listHealthcareWASHWomen;
	}

	// Healthcare and WASH (Comp 3) = Boys M7
	public List<String> getHealthcareWASHBoysM7Data() {
		List<String> listHealthcareWASHBoysM7 = beneficiaryTableRepository.fetchHealthcareWASHBoysM7Data();
		return listHealthcareWASHBoysM7;
	}

	// Healthcare and WASH (Comp 3) = Girls M7
	public List<String> getHealthcareWASHGirlsM7Data() {
		List<String> listHealthcareWASHGirlsM7 = beneficiaryTableRepository.fetchHealthcareWASHGirlsM7Data();
		return listHealthcareWASHGirlsM7;
	}

	// Healthcare and WASH (Comp 3) = Men M7
	public List<String> getHealthcareWASHMenM7Data() {
		List<String> listHealthcareWASHMenM7 = beneficiaryTableRepository.fetchHealthcareWASHMenM7Data();
		return listHealthcareWASHMenM7;
	}

	// Healthcare and WASH (Comp 3) = Women M7
	public List<String> getHealthcareWASHWomenM7Data() {
		List<String> listHealthcareWASHWomenM7 = beneficiaryTableRepository.fetchHealthcareWASHWomenM7Data();
		return listHealthcareWASHWomenM7;
	}

	// VSLAs = Men
	public List<String> getVSLAsMenData() {
		List<String> listVSLAsMen = beneficiaryTableRepository.fetchVSLAsMenData();
		return listVSLAsMen;
	}

	// VSLAs = Women
	public List<String> getVSLAsWomenData() {
		List<String> listVSLAsWomen = beneficiaryTableRepository.fetchVSLAsWomenData();
		return listVSLAsWomen;
	}

	// Providing poorest families with small livelihoods grants = Men
	public List<String> getLivelihoodsGrantsMenData() {
		List<String> listLivelihoodsGrantsMen = beneficiaryTableRepository.fetchLivelihoodsGrantsMenData();
		return listLivelihoodsGrantsMen;
	}

	// Providing poorest families with small livelihoods grants = Women
	public List<String> getLivelihoodsGrantsWomenData() {
		List<String> listLivelihoodsGrantsWomen = beneficiaryTableRepository.fetchLivelihoodsGrantsWomenData();
		return listLivelihoodsGrantsWomen;
	}

	// Individus sensibilisés = Boys
	public List<String> getIndividusSensibilisesBoysData() {
		List<String> listIndividusSensibilisesBoys = beneficiaryTableRepository.fetchIndividusSensibilisesBoysData();
		return listIndividusSensibilisesBoys;
	}

	// Individus sensibilisés = Girls
	public List<String> getIndividusSensibilisesGirlsData() {
		List<String> listIndividusSensibilisesGirls = beneficiaryTableRepository.fetchIndividusSensibilisesGirlsData();
		return listIndividusSensibilisesGirls;
	}

	// Individus sensibilisés = Men
	public List<String> getIndividusSensibilisesMenData() {
		List<String> listIndividusSensibilisesMen = beneficiaryTableRepository.fetchIndividusSensibilisesMenData();
		return listIndividusSensibilisesMen;
	}

	// Individus sensibilisés = Women
	public List<String> getIndividusSensibilisesWomenData() {
		List<String> listIndividusSensibilisesWomen = beneficiaryTableRepository.fetchIndividusSensibilisesWomenData();
		return listIndividusSensibilisesWomen;
	}

	// Setting up Youth Committees = Boys
	public List<String> getSettingCommitteesBoysData() {
		List<String> listSettingCommitteesBoys = beneficiaryTableRepository.fetchSettingCommitteesBoysData();
		return listSettingCommitteesBoys;
	}

	// Setting up Youth Committees = Girls
	public List<String> getSettingCommitteesGirlsData() {
		List<String> listSettingCommitteesGirls = beneficiaryTableRepository.fetchSettingCommitteesGirlsData();
		return listSettingCommitteesGirls;
	}

	// Providing literacy, numeracy and life skills training = Boys
	public List<String> getLifeSkillsTrainingBoysData() {
		List<String> listLifeSkillsTrainingBoys = beneficiaryTableRepository.fetchLifeSkillsTrainingBoysData();
		return listLifeSkillsTrainingBoys;
	}

	// Providing literacy, numeracy and life skills training = Girls
	public List<String> getLifeSkillsTrainingGirlsData() {
		List<String> listLifeSkillsTrainingGirls = beneficiaryTableRepository.fetchLifeSkillsTrainingGirlsData();
		return listLifeSkillsTrainingGirls;
	}

	// Jeunes formés en plan de vie viable (pathway) = Boys N°2
	public List<String> getPathwayBoysData() {
		List<String> listPathwayBoys = beneficiaryTableRepository.fetchPathwayBoysData();
		return listPathwayBoys;
	}

	// Jeunes formés en plan de vie viable (pathway) = Girls N°2
	public List<String> getPathwayGirlsData() {
		List<String> listPathwayGirls = beneficiaryTableRepository.fetchPathwayGirlsData();
		return listPathwayGirls;
	}

	// TOTAL = Boys
	public List<String> getTotalBoysData() {
		List<String> listTotalBoys = beneficiaryTableRepository.fetchTotalBoysData();
		return listTotalBoys;
	}

	// TOTAL = Girls
	public List<String> getTotalGirlsData() {
		List<String> listTotalGirls = beneficiaryTableRepository.fetchTotalGirlsData();
		return listTotalGirls;
	}

	// TOTAL = Men
	public List<String> getTotalMenData() {
		List<String> listTotalMen = beneficiaryTableRepository.fetchTotalMenData();
		return listTotalMen;
	}

	// TOTAL = Women
	public List<String> getTotalWomenData() {
		List<String> listTotalWomen = beneficiaryTableRepository.fetchTotalWomenData();
		return listTotalWomen;
	}

	// TOTAL 2 = Boys
	public List<String> getTotal2BoysData() {
		List<String> listTotal2Boys = beneficiaryTableRepository.fetchTotal2BoysData();
		return listTotal2Boys;
	}

	// TOTAL 2 = Girls
	public List<String> getTotal2GirlsData() {
		List<String> listTotal2Girls = beneficiaryTableRepository.fetchTotal2GirlsData();
		return listTotal2Girls;
	}

	// TOTAL 2 = Men
	public List<String> getTotal2MenData() {
		List<String> listTotal2Men = beneficiaryTableRepository.fetchTotal2MenData();
		return listTotal2Men;
	}

	// TOTAL 2 = Women
	public List<String> getTotal2WomenData() {
		List<String> listTotal2Women = beneficiaryTableRepository.fetchTotal2WomenData();
		return listTotal2Women;
	}

	// TOTAL 3 BOYS
	public List<String> getTotal3BoysData() {
		List<String> listTotal3Boys = beneficiaryTableRepository.fetchTotal3BoysData();
		return listTotal3Boys;
	}

	// TOTAL 3 GIRLS
	public List<String> getTotal3GirlsData() {
		List<String> listTotal3Girls = beneficiaryTableRepository.fetchTotal3GirlsData();
		return listTotal3Girls;
	}

	// TOTAL 3 MEN
	public List<String> getTotal3MenData() {
		List<String> listTotal3Men = beneficiaryTableRepository.fetchTotal3MenData();
		return listTotal3Men;
	}

	// TOTAL 3 WOMEN
	public List<String> getTotal3WomenData() {
		List<String> listTotal3Women = beneficiaryTableRepository.fetchTotal3WomenData();
		return listTotal3Women;
	}

	// TOTAL 4 Mixte
	public List<String> getTotal4MixteData() {
		List<String> listTotal4Mixte = beneficiaryTableRepository.fetchTotal4MixteData();
		return listTotal4Mixte;
	}

	// TOTAL 5 Ménages
	public List<String> getTOTAL5MenagesData() {
		List<String> listTOTAL5Menages = beneficiaryTableRepository.fetchTOTAL5MenagesData();
		return listTOTAL5Menages;
	}

}
