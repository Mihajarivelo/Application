package mg.giz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mg.giz.data.domain.Personne;

public interface BeneficiaireVillageRepository extends JpaRepository<Personne, Long> {

	// Liste des beneficaires par village

	@Query(value = "SELECT concat('\"', personne_nom ,'\",\"', personne_genre ,'\",\"', district ,'\",\"', commune ,'\",\"', code_fkt ,'\",\"', village_nom ,'\"') FROM beneficiaire_village", nativeQuery = true)
	List<String> fetchBeneficairesVillageData();

	// Farmer Business Schools

	@Query(value = "SELECT concat('\"', nbre_ben ,'\",\"', personne_nom ,'\",\"', personne_genre ,'\",\"', district ,'\",\"', commune ,'\",\"', village_nom ,'\"') FROM fetchVIEWFBSMenData", nativeQuery = true)
	List<String> fetchVIEWFBSMenData();

	// ASA
	@Query(value = "SELECT concat('\"', nbre_ben ,'\",\"', personne_nom ,'\",\"', personne_genre ,'\",\"', district ,'\",\"', commune ,'\",\"', village_nom ,'\"') FROM fetchVIEWASAMenData", nativeQuery = true)
	List<String> fetchVIEWASAMenData();

	// formateurs élevage
	@Query(value = "SELECT concat('\"', nbre_ben ,'\",\"', personne_nom ,'\",\"', personne_genre ,'\",\"', district ,'\",\"', commune ,'\",\"', village_nom ,'\"') FROM fetchVIEWFormateursElevageMenData", nativeQuery = true)
	List<String> fetchVIEWFormateursElevageMenData();

	// bénéficiaires formation en petit élevage y compirs prod et non prod
	@Query(value = "SELECT concat('\"', nbre_ben ,'\",\"', personne_nom ,'\",\"', personne_genre ,'\",\"', district ,'\",\"', commune ,'\",\"', village_nom ,'\"') FROM fetchVIEWBeneficiairesFormationPetitElevageMenData", nativeQuery = true)
	List<String> fetchVIEWBeneficiairesFormationPetitElevageMenData();

	// Jeunes MFR
	@Query(value = "SELECT concat('\"', nbre_ben ,'\",\"', personne_nom ,'\",\"', personne_genre ,'\",\"', district ,'\",\"', commune ,'\",\"', village_nom ,'\"') FROM fetchVIEWJeunesMFRBoysData", nativeQuery = true)
	List<String> fetchVIEWJeunesMFRBoysData();

	// Enseignants formés en éducation environnementale
	@Query(value = "SELECT concat('\"', nbre_ben ,'\",\"', ecoleepp_nom ,'\",\"', enseignantepp_nom ,'\",\"', enseignantepp_genre ,'\",\"', enseignantepp_classe ,'\",\"', enseignantepp_fonction ,'\"') FROM fetchVIEWEnseignantsFormesMenData", nativeQuery = true)
	List<String> fetchVIEWEnseignantsFormesMenData();

	// VSLAs
	@Query(value = "SELECT concat('\"', nbre_ben ,'\",\"', personne_nom ,'\",\"', personne_genre ,'\",\"', district ,'\",\"', commune ,'\",\"', village_nom ,'\"') FROM fetchVIEWVSLAsMenData", nativeQuery = true)
	List<String> fetchVIEWVSLAsMenData();

	// Setting up Youth Committees
	@Query(value = "SELECT concat('\"', nbre_ben ,'\",\"', personne_nom ,'\",\"', personne_genre ,'\",\"', district ,'\",\"', commune ,'\",\"', village_nom ,'\"') FROM fetchVIEWSettingCommitteesBoysData", nativeQuery = true)
	List<String> fetchVIEWSettingCommitteesBoysData();

	// Providing poorest families with small livelihoods grants
	@Query(value = "SELECT concat('\"', nbre_ben ,'\",\"', personne_nom ,'\",\"', personne_genre ,'\",\"', district ,'\",\"', commune ,'\",\"', village_nom ,'\"') FROM fetchVIEWLivelihoodsGrantsMenData", nativeQuery = true)
	List<String> fetchVIEWLivelihoodsGrantsMenData();

	// Healthcare and WASH (Comp 2b) = Boys&GirlsM12
	@Query(value = "SELECT concat('\"', nbre_ben ,'\",\"', personne_nom ,'\",\"', personne_genre ,'\",\"', district ,'\",\"', commune ,'\",\"', village_nom ,'\"') FROM fetchVIEWHealthcareWASHBoysData", nativeQuery = true)
	List<String> fetchVIEWHealthcareWASHBoysData();

	// Healthcare and WASH (Comp 2b) = Men&WomenM12
	@Query(value = "SELECT concat('\"', nbre_ben ,'\",\"', personne_nom ,'\",\"', personne_genre ,'\",\"', district ,'\",\"', commune ,'\",\"', village_nom ,'\"') FROM fetchVIEWHealthcareWASHMenData", nativeQuery = true)
	List<String> fetchVIEWHealthcareWASHMenData();

	// Healthcare and WASH (Comp 2b) = Boys&GirlsM7
	@Query(value = "SELECT concat('\"', nbre_ben ,'\",\"', personne_nom ,'\",\"', personne_genre ,'\",\"', district ,'\",\"', commune ,'\",\"', village_nom ,'\"') FROM fetchVIEWHealthcareWASHBoysM7Data", nativeQuery = true)
	List<String> fetchVIEWHealthcareWASHBoysM7Data();

	// Healthcare and WASH (Comp 2b) = Men&WomenM7
	@Query(value = "SELECT concat('\"', nbre_ben ,'\",\"', personne_nom ,'\",\"', personne_genre ,'\",\"', district ,'\",\"', commune ,'\",\"', village_nom ,'\"') FROM fetchVIEWHealthcareWASHMenM7Data", nativeQuery = true)
	List<String> fetchVIEWHealthcareWASHMenM7Data();

	// Children at Primary Public Schools
	@Query(value = "SELECT concat('\"', ecoleepp_id ,'\",\"', nombreeleve_valeur ,'\",\"', ecoleepp_nom ,'\",\"', nombreeleve_date ,'\",\"', nombreeleve_garcon ,'\",\"', nombreeleve_fille ,'\"') FROM fetchVIEWChildrenPrimaryPublicSchoolsBoysData", nativeQuery = true)
	List<String> fetchVIEWChildrenPrimaryPublicSchoolsBoysData();

	// Individus sensibilisés
	@Query(value = "SELECT concat('\"', menagessensibilise_date ,'\",\"', menagessensibilise_garcon ,'\",\"', menagessensibilise_fille ,'\",\"', menagessensibilise_homme ,'\",\"', menagessensibilise_femme ,'\",\"', village_nom ,'\"') FROM fetchVIEWIndividusSensibilisesBoysData", nativeQuery = true)
	List<String> fetchVIEWIndividusSensibilisesBoysData();

	/*
	 * @Query(value =
	 * "SELECT concat('\"', p.personne_nom ,'\",' , '\"', p.personne_genre ,'\",' , '\"', d.district ,'\",' , '\"', c.commune ,'\",' , \r\n"
	 * + "		   '\"', p.code_fkt ,'\",' , '\"', v.village_nom ,'\"') \r\n" +
	 * "    FROM Personne p \r\n" +
	 * "        LEFT JOIN village v ON p.code_fkt = v.code_fkt\r\n" +
	 * "        LEFT JOIN commune c ON v.c_code = c.c_code\r\n" +
	 * "	    LEFT JOIN district d ON c.d_code = d.d_code ORDER BY p.code_fkt",
	 * nativeQuery = true) List<String> fetchBeneficairesVillageData();
	 *
	 * 
	 * 
	 * // Providing literacy, numeracy and life skills training
	 * 
	 * @Query(value =
	 * "SELECT concat('\"', theme_lib ,'\",\"', suivitheme_date ,'\",\"', suivitheme_valeur ,'\",\"', village_nom ,'\",\"', suivitheme_comm ,'\"') FROM fetchVIEWLifeSkillsTrainingBoysData"
	 * , nativeQuery = true) List<String> fetchVIEWLifeSkillsTrainingBoysData();
	 * 
	 * // Jeunes formés en plan de vie viable (pathway)
	 * 
	 * @Query(value =
	 * "SELECT concat('\"', theme_lib ,'\",\"', suivitheme_date ,'\",\"', suivitheme_valeur ,'\",\"', village_nom ,'\",\"', suivitheme_comm ,'\"') FROM fetchVIEWPathwayBoysData"
	 * , nativeQuery = true) List<String> fetchVIEWPathwayBoysData();
	 */

}
