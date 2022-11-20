package mg.giz.service.metier;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mg.giz.repository.BeneficiaireVillageRepository;

@Service
public class BeneficiaireVillageQueryService {

	@Resource
	private BeneficiaireVillageRepository beneficiaireVillageRepository;

	// Liste des beneficaires par village
	public List<String> getBeneficairesVillageData() {
		List<String> listBeneficairesVillage = beneficiaireVillageRepository.fetchBeneficairesVillageData();
		return listBeneficairesVillage;
	}

	// Farmer Business Schools
	public List<String> getVIEWFBSMenData() {
		List<String> listVIEWFBSMen = beneficiaireVillageRepository.fetchVIEWFBSMenData();
		return listVIEWFBSMen;
	}

	// ASA
	public List<String> getVIEWASAMenData() {
		List<String> listVIEWASAMen = beneficiaireVillageRepository.fetchVIEWASAMenData();
		return listVIEWASAMen;
	}

	// formateurs élevage
	public List<String> getVIEWFormateursElevageMenData() {
		List<String> listVIEWFormateursElevageMen = beneficiaireVillageRepository.fetchVIEWFormateursElevageMenData();
		return listVIEWFormateursElevageMen;
	}

	// bénéficiaires formation en petit élevage y compirs prod et non prod
	public List<String> getVIEWBeneficiairesFormationPetitElevageMenData() {
		List<String> listVIEWBeneficiairesFormationPetitElevageMen = beneficiaireVillageRepository
				.fetchVIEWBeneficiairesFormationPetitElevageMenData();
		return listVIEWBeneficiairesFormationPetitElevageMen;
	}

	// Jeunes MFR
	public List<String> getVIEWJeunesMFRBoysData() {
		List<String> listVIEWJeunesMFRBoys = beneficiaireVillageRepository.fetchVIEWJeunesMFRBoysData();
		return listVIEWJeunesMFRBoys;
	}

	// Enseignants formés en éducation environnementale
	public List<String> getVIEWEnseignantsFormesMenData() {
		List<String> listVIEWEnseignantsFormesMen = beneficiaireVillageRepository.fetchVIEWEnseignantsFormesMenData();
		return listVIEWEnseignantsFormesMen;
	}

	// VSLAs
	public List<String> getVIEWVSLAsMenData() {
		List<String> listVIEWVSLAsMen = beneficiaireVillageRepository.fetchVIEWVSLAsMenData();
		return listVIEWVSLAsMen;
	}

	// Setting up Youth Committees
	public List<String> getVIEWSettingCommitteesBoysData() {
		List<String> listVIEWSettingCommitteesBoys = beneficiaireVillageRepository.fetchVIEWSettingCommitteesBoysData();
		return listVIEWSettingCommitteesBoys;
	}

	// Providing poorest families with small livelihoods grants
	public List<String> getVIEWLivelihoodsGrantsMenData() {
		List<String> listVIEWLivelihoodsGrantsMen = beneficiaireVillageRepository.fetchVIEWLivelihoodsGrantsMenData();
		return listVIEWLivelihoodsGrantsMen;
	}

	// Healthcare and WASH (Comp 2b) = Boys&GirlsM12
	public List<String> getVIEWHealthcareWASHBoysData() {
		List<String> listVIEWHealthcareWASHBoys = beneficiaireVillageRepository.fetchVIEWHealthcareWASHBoysData();
		return listVIEWHealthcareWASHBoys;
	}

	// Healthcare and WASH (Comp 2b) = Men&WomenM12
	public List<String> getVIEWHealthcareWASHMenData() {
		List<String> listVIEWHealthcareWASHMen = beneficiaireVillageRepository.fetchVIEWHealthcareWASHMenData();
		return listVIEWHealthcareWASHMen;
	}

	// Healthcare and WASH (Comp 2b) = Boys&GirlsM7
	public List<String> getVIEWHealthcareWASHBoysM7Data() {
		List<String> listVIEWHealthcareWASHBoysM7 = beneficiaireVillageRepository.fetchVIEWHealthcareWASHBoysM7Data();
		return listVIEWHealthcareWASHBoysM7;
	}

	// Healthcare and WASH (Comp 2b) = Men&WomenM7
	public List<String> getVIEWHealthcareWASHMenM7Data() {
		List<String> listVIEWHealthcareWASHMenM7 = beneficiaireVillageRepository.fetchVIEWHealthcareWASHMenM7Data();
		return listVIEWHealthcareWASHMenM7;
	}

	// Children at Primary Public Schools
	public List<String> getVIEWChildrenPrimaryPublicSchoolsBoysData() {
		List<String> listVIEWChildrenPrimaryPublicSchoolsBoys = beneficiaireVillageRepository
				.fetchVIEWChildrenPrimaryPublicSchoolsBoysData();
		return listVIEWChildrenPrimaryPublicSchoolsBoys;
	}

	// Individus sensibilisés
	public List<String> getVIEWIndividusSensibilisesBoysData() {
		List<String> listVIEWIndividusSensibilisesBoys = beneficiaireVillageRepository
				.fetchVIEWIndividusSensibilisesBoysData();
		return listVIEWIndividusSensibilisesBoys;
	}

}
