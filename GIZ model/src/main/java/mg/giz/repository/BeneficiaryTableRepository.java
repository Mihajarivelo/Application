package mg.giz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mg.giz.data.domain.Beneficierpgm;

public interface BeneficiaryTableRepository extends JpaRepository<Beneficierpgm, Long> {

	// Farmer Business Schools, (Comp 1a) = Men
	@Query(value = "SELECT * FROM fetchFBSMenData", nativeQuery = true)
	List<String> fetchFBSMenData();

	// Farmer Business Schools, (Comp 1a) = Women
	@Query(value = "SELECT * FROM fetchFBSWomenData", nativeQuery = true)
	List<String> fetchFBSWomenData();

	// coopératives strengthening 1b = Men
	@Query(value = "SELECT * FROM fetchCooperativesStrengtheninMengData", nativeQuery = true)
	List<String> fetchCooperativesStrengtheninMengData();

	// coopératives strengthening 1b = Women
	@Query(value = "SELECT * FROM fetchCooperativesStrengtheningWomenData", nativeQuery = true)
	List<String> fetchCooperativesStrengtheningWomenData();

	// ASA = Men
	@Query(value = "SELECT * FROM fetchASAMenData", nativeQuery = true)
	List<String> fetchASAMenData();

	// ASA = Women
	@Query(value = "SELECT * FROM fetchASAWomenData", nativeQuery = true)
	List<String> fetchASAWomenData();

	// formateurs élevage = Men
	@Query(value = "SELECT * FROM fetchFormateursElevageMenData", nativeQuery = true)
	List<String> fetchFormateursElevageMenData();

	// formateurs élevage = Women
	@Query(value = "SELECT * FROM fetchFormateursElevageWomenData", nativeQuery = true)
	List<String> fetchFormateursElevageWomenData();

	// bénéficiaires formation en petit élevage y compirs prod et non prod = Men
	@Query(value = "SELECT * FROM fetchBeneficiairesFormationPetitElevageMenData", nativeQuery = true)
	List<String> fetchBeneficiairesFormationPetitElevageMenData();

	// bénéficiaires formation en petit élevage y compirs prod et non prod = Women
	@Query(value = "SELECT * FROM fetchBeneficiairesFormationPetitElevageWomenData", nativeQuery = true)
	List<String> fetchBeneficiairesFormationPetitElevageWomenData();

	// Children at Primary Public Schools = Boys
	@Query(value = "SELECT nbre_beneficiaires FROM fetchChildrenPrimaryPublicSchoolsBoysData", nativeQuery = true)
	List<String> fetchChildrenPrimaryPublicSchoolsBoysData();

	// Children at Primary Public Schools = Girls
	@Query(value = "SELECT nbre_beneficiaires FROM fetchChildrenPrimaryPublicSchoolsGirlsData", nativeQuery = true)
	List<String> fetchChildrenPrimaryPublicSchoolsGirlsData();

	// Jeunes MFR = Boys
	@Query(value = "SELECT * FROM fetchJeunesMFRBoysData", nativeQuery = true)
	List<String> fetchJeunesMFRBoysData();

	// Jeunes MFR = Girls
	@Query(value = "SELECT * FROM fetchJeunesMFRGirlsData", nativeQuery = true)
	List<String> fetchJeunesMFRGirlsData();

	// Enseignants formés en éducation environnementale = Men
	@Query(value = "SELECT SUM(nbre_beneficiaires) FROM fetchEnseignantsFormesMenData", nativeQuery = true)
	List<String> fetchEnseignantsFormesMenData();

	// Enseignants formés en éducation environnementale = Women
	@Query(value = "SELECT SUM(nbre_beneficiaires) FROM fetchEnseignantsFormesWomenData", nativeQuery = true)
	List<String> fetchEnseignantsFormesWomenData();

	// Healthcare and WASH (Comp 2b) = Boys
	@Query(value = "SELECT * FROM fetchHealthcareWASHBoysData", nativeQuery = true)
	List<String> fetchHealthcareWASHBoysData();

	// Healthcare and WASH (Comp 2b) = Girls
	@Query(value = "SELECT * FROM fetchHealthcareWASHGirlsData", nativeQuery = true)
	List<String> fetchHealthcareWASHGirlsData();

	// Healthcare and WASH (Comp 2b) = Men
	@Query(value = "SELECT * FROM fetchHealthcareWASHMenData", nativeQuery = true)
	List<String> fetchHealthcareWASHMenData();

	// Healthcare and WASH (Comp 2b) = Women
	@Query(value = "SELECT * FROM fetchHealthcareWASHWomenData", nativeQuery = true)
	List<String> fetchHealthcareWASHWomenData();

	// Healthcare and WASH (Comp 3) = Boys M7
	@Query(value = "SELECT * FROM fetchHealthcareWASHBoysM7Data", nativeQuery = true)
	List<String> fetchHealthcareWASHBoysM7Data();

	// Healthcare and WASH (Comp 3) = Girls M7
	@Query(value = "SELECT * FROM fetchHealthcareWASHGirlsM7Data", nativeQuery = true)
	List<String> fetchHealthcareWASHGirlsM7Data();

	// Healthcare and WASH (Comp 3) = Men M7
	@Query(value = "SELECT * FROM fetchHealthcareWASHMenM7Data", nativeQuery = true)
	List<String> fetchHealthcareWASHMenM7Data();

	// Healthcare and WASH (Comp 3) = Women M7
	@Query(value = "SELECT * FROM fetchHealthcareWASHWomenM7Data", nativeQuery = true)
	List<String> fetchHealthcareWASHWomenM7Data();

	// VSLAs = Men
	@Query(value = "SELECT * FROM fetchVSLAsMenData", nativeQuery = true)
	List<String> fetchVSLAsMenData();

	// VSLAs = Women
	@Query(value = "SELECT * FROM fetchVSLAsWomenData", nativeQuery = true)
	List<String> fetchVSLAsWomenData();

	// Providing poorest families with small livelihoods grants = Men
	@Query(value = "SELECT * FROM fetchLivelihoodsGrantsMenData", nativeQuery = true)
	List<String> fetchLivelihoodsGrantsMenData();

	// Providing poorest families with small livelihoods grants = Women
	@Query(value = "SELECT * FROM fetchLivelihoodsGrantsWomenData", nativeQuery = true)
	List<String> fetchLivelihoodsGrantsWomenData();

	// Individus sensibilisés = Boys
	@Query(value = "SELECT nbre_beneficiaires FROM fetchIndividusSensibilisesBoysData", nativeQuery = true)
	List<String> fetchIndividusSensibilisesBoysData();

	// Individus sensibilisés = Girls
	@Query(value = "SELECT nbre_beneficiaires FROM fetchIndividusSensibilisesGirlsData", nativeQuery = true)
	List<String> fetchIndividusSensibilisesGirlsData();

	// Individus sensibilisés = Men
	@Query(value = "SELECT nbre_beneficiaires FROM fetchIndividusSensibilisesMenData", nativeQuery = true)
	List<String> fetchIndividusSensibilisesMenData();

	// Individus sensibilisés = Women
	@Query(value = "SELECT nbre_beneficiaires FROM fetchIndividusSensibilisesWomenData", nativeQuery = true)
	List<String> fetchIndividusSensibilisesWomenData();

	// Setting up Youth Committees = Boys
	@Query(value = "SELECT * FROM fetchSettingCommitteesBoysData", nativeQuery = true)
	List<String> fetchSettingCommitteesBoysData();

	// Setting up Youth Committees = Girls
	@Query(value = "SELECT * FROM fetchSettingCommitteesGirlsData", nativeQuery = true)
	List<String> fetchSettingCommitteesGirlsData();

	// Providing literacy, numeracy and life skills training = Boys N°1
	@Query(value = "SELECT nbre_beneficiaires FROM fetchLifeSkillsTrainingBoysData", nativeQuery = true)
	List<String> fetchLifeSkillsTrainingBoysData();

	// Providing literacy, numeracy and life skills training = Girls N°1
	@Query(value = "SELECT nbre_beneficiaires FROM fetchLifeSkillsTrainingGirlsData", nativeQuery = true)
	List<String> fetchLifeSkillsTrainingGirlsData();

	// Jeunes formés en plan de vie viable (pathway) = Boys N°2
	@Query(value = "SELECT nbre_beneficiaires FROM fetchPathwayBoysData", nativeQuery = true)
	List<String> fetchPathwayBoysData();

	// Jeunes formés en plan de vie viable (pathway) = Girls N°2
	@Query(value = "SELECT nbre_beneficiaires FROM fetchPathwayGirlsData", nativeQuery = true)
	List<String> fetchPathwayGirlsData();

	// TOTAL BOYS AND GIRLS

	// TOTAL 1 = Boys
	@Query(value = "SELECT * FROM fetchTotalBoysData", nativeQuery = true)
	List<String> fetchTotalBoysData();

	// TOTAL 1 = Girls
	@Query(value = "SELECT * FROM fetchTotalGirlsData", nativeQuery = true)
	List<String> fetchTotalGirlsData();

	// TOTAL MEN AND WOMEN

	// TOTAL 1 = Men
	@Query(value = "SELECT * FROM fetchTotalMenData", nativeQuery = true)
	List<String> fetchTotalMenData();

	// TOTAL 1 = Women
	@Query(value = "SELECT * FROM fetchTotalWomenData", nativeQuery = true)
	List<String> fetchTotalWomenData();

	// TOTAL 2 BOYS AND GIRLS

	// TOTAL 2 = Boys
	@Query(value = "SELECT * FROM fetchTotal2BoysData", nativeQuery = true)
	List<String> fetchTotal2BoysData();

	// TOTAL 2 = Girls
	@Query(value = "SELECT * FROM fetchTotal2GirlsData", nativeQuery = true)
	List<String> fetchTotal2GirlsData();

	// TOTAL 2 MEN AND WOMEN

	// TOTAL 2 = Men
	@Query(value = "SELECT * FROM fetchTotal2MenData", nativeQuery = true)
	List<String> fetchTotal2MenData();

	// TOTAL 2 = Women
	@Query(value = "SELECT * FROM fetchTotal2WomenData", nativeQuery = true)
	List<String> fetchTotal2WomenData();

	// TOTAL 3 BOYS
	@Query(value = "SELECT * FROM fetchTotal3BoysData", nativeQuery = true)
	List<String> fetchTotal3BoysData();

	// TOTAL 3 GIRLS
	@Query(value = "SELECT * FROM fetchTotal3GirlsData", nativeQuery = true)
	List<String> fetchTotal3GirlsData();

	// TOTAL 3 MEN
	@Query(value = "SELECT * FROM fetchTotal3MenData", nativeQuery = true)
	List<String> fetchTotal3MenData();

	// TOTAL 3 WOMEN
	@Query(value = "SELECT * FROM fetchTotal3WomenData", nativeQuery = true)
	List<String> fetchTotal3WomenData();

	// TOTAL 4 Mixte
	@Query(value = "SELECT * FROM fetchTotal4MixteData", nativeQuery = true)
	List<String> fetchTotal4MixteData();

	// TOTAL 5 Ménages
	@Query(value = "SELECT * FROM fetchTOTAL5MenagesData", nativeQuery = true)
	List<String> fetchTOTAL5MenagesData();

}
