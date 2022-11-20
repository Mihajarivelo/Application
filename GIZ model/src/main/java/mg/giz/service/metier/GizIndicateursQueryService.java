package mg.giz.service.metier;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mg.giz.repository.GizIndicateursRepository;

@Service
public class GizIndicateursQueryService {

	@Resource
	private GizIndicateursRepository gizIndicateursRepository;

	// # DONNEES A SAISIR
	/*
	 * public List<String> getRapportperiodiqueData() { List<String> listrapport =
	 * indicateursGizRepository.fetchRapportperiodiqueData(); return listrapport; }
	 */

	// Beneficiaires FR

	public List<String> getFRData() {
		List<String> listFRDto = gizIndicateursRepository.fetchFRData();
		return listFRDto;
	}

	// # de restitution auprès des FR
	public List<String> getRestitutionFRData() {
		List<String> listRestitutionFR = gizIndicateursRepository.fetchRestitutionFRData();
		return listRestitutionFR;
	}

	// # de formateurs FBS formés

	public List<String> getFormateursFBSformesData() {
		List<String> listFormateursFBS = gizIndicateursRepository.fetchFormateursFBSformesData();
		return listFormateursFBS;
	}

	// # de producteurs sensibilisés

	public List<String> getProdsensibilisesData() {
		List<String> listProducteursSensibilises = gizIndicateursRepository.fetchProdsensibilisesData();
		return listProducteursSensibilises;
	}

	// # de session de formation FBS effectués

	public List<String> getNombreSessionFBSData() {
		List<String> listSessionFormationFBS = gizIndicateursRepository.fetchNombreSessionFBSData();
		return listSessionFormationFBS;
	}

	// # de producteurs formés

	public List<String> getProdformesData() {
		List<String> listProducteursFormes = gizIndicateursRepository.fetchProdformesData();
		return listProducteursFormes;
	}

	// # de producteurs bénéficiant de renforcement de capacité post-formation FBS

	public List<String> getProdpostformationData() {
		List<String> listProducteursPostformationFBS = gizIndicateursRepository.fetchProdpostformationData();
		return listProducteursPostformationFBS;
	}

	// # d'entrepreneurs identifiés

	public List<String> getEntrepreneursData() {
		List<String> listEntrepreneurIdentifies = gizIndicateursRepository.fetchEntrepreneursData();
		return listEntrepreneurIdentifies;
	}

	// # de personnes ressources opérationnelles

	public List<String> getPersonnesRessourcesOperationnellesData() {
		List<String> listPersonnesRessourcesOperationnelles = gizIndicateursRepository
				.fetchPersonnesRessourcesOperationnellesData();
		return listPersonnesRessourcesOperationnelles;
	}

	// # de participants aux formations dispensées par les personnes ressources

	public List<String> getFormationsPersonnesRessourcesData() {
		List<String> listFormationsPersonnesRessourcesData = gizIndicateursRepository
				.fetchFormationsPersonnesRessourcesData();
		return listFormationsPersonnesRessourcesData;
	}

	// # de pépinièristes fonctionnels et gérant eux-même leur fonds

	public List<String> getPepinieristesFonctionnelsData() {
		List<String> listPepinieristesFonctionnels = gizIndicateursRepository.fetchPepinieristesFonctionnelsData();
		return listPepinieristesFonctionnels;
	}

	// # d'ASA formés
	public List<String> getASAFormesData() {
		List<String> listASAFormes = gizIndicateursRepository.fetchASAFormesData();
		return listASAFormes;
	}

	// # d'ASA opérationnels
	public List<String> getASAOperationnelsData() {
		List<String> listASAOperationnels = gizIndicateursRepository.fetchASAOperationnelsData();
		return listASAOperationnels;
	}

	/*
	 * // Chiffre d'affaire mensuel moyen des ASA public List<String>
	 * getChiffreAffaireMensuelMoyenASAData() { List<String>
	 * listChiffreAffaireMensuelMoyenASA = gizIndicateursRepository
	 * .fetchChiffreAffaireMensuelMoyenASAData(); return
	 * listChiffreAffaireMensuelMoyenASA; }
	 * 
	 * // # de cheptels vaccinés public List<String> getCheptelsVaccinesData() {
	 * List<String> listCheptelsVaccines =
	 * gizIndicateursRepository.fetchCheptelsVaccinesData(); return
	 * listCheptelsVaccines; }
	 */

	// # de formateurs en élevages opérationnels

	public List<String> getFormateursElevagesOperationnelsData() {
		List<String> listFormateursElevagesOperationnels = gizIndicateursRepository
				.fetchFormateursElevagesOperationnelsData();
		return listFormateursElevagesOperationnels;
	}

	// # de producteurs formés sur les bonnes pratiques d'élevage

	public List<String> getProducteursFormesBonnesPratiquesElevageData() {
		List<String> listProducteursFormesBonnesPratiquesElevage = gizIndicateursRepository
				.fetchProducteursFormesBonnesPratiquesElevageData();
		return listProducteursFormesBonnesPratiquesElevage;
	}

	// # de producteurs qui ont adopté au moins une bonnes pratique d'élevage
	// (vaccination + alimentation ou logement ou reproduction)

	/*
	 * public List<String> getProducteursBonnespratiqueElevageData() { List<String>
	 * listProducteursBonnespratiqueElevage = gizIndicateursRepository
	 * .fetchProducteursBonnespratiqueElevageData(); return
	 * listProducteursBonnespratiqueElevage; }
	 */

	// # de fermes de diffusion opérationnelles

	public List<String> getFermesPiloteData() {
		List<String> listFermesPilote = gizIndicateursRepository.fetchFermesPiloteData();
		return listFermesPilote;
	}

	// # de visiteurs des fermes de diffusion (= producteurs qui sont venus pour le
	// croisement)

	/*
	 * public List<String> getVisiteursFermesDiffusionData() { List<String>
	 * listVisiteursFermesDiffusion =
	 * gizIndicateursRepository.fetchVisiteursFermesDiffusionData(); return
	 * listVisiteursFermesDiffusion; }
	 */

	// # de structure de producteurs fonctionnels

	public List<String> getStructureProducteursData() {
		List<String> listStructureProducteurs = gizIndicateursRepository.fetchStructureProducteursData();
		return listStructureProducteurs;
	}

	// # de structure de producteurs mettant en œuvre un service ou un projet

	public List<String> getStructureProducteursProjetData() {
		List<String> listStructureProducteursProjet = gizIndicateursRepository.fetchStructureProducteursProjetData();
		return listStructureProducteursProjet;
	}

	// % de petits producteurs formés qui démontrent des compétences en leadership,
	// négociation et communication
	/*
	 * public List<String> getTauxPetitsProducteursFormesData() { List<String>
	 * listTauxPetitsProducteursFormes =
	 * gizIndicateursRepository.fetchTauxPetitsProducteursFormesData(); return
	 * listTauxPetitsProducteursFormes; }
	 */

	// # de MFR opérationnels
	public List<String> getMFRoperationnelsData() {
		List<String> listMFRoperationnels = gizIndicateursRepository.fetchMFRoperationnelsData();
		return listMFRoperationnels;
	}

	// # d'élèves étudiant dans les MFR
	public List<String> getElevesEtudiantMFRData() {
		List<String> listElevesEtudiantMFR = gizIndicateursRepository.fetchElevesEtudiantMFRData();
		return listElevesEtudiantMFR;
	}

	// # de jeunes diplômés sortant des MFR
	public List<String> getJeunesdiplomessortantMFRData() {
		List<String> listJeunesdiplomessortantMFR = gizIndicateursRepository.fetchJeunesdiplomessortantMFRData();
		return listJeunesdiplomessortantMFR;
	}

	// # de jeunes sortants des MFR mettant en œuvre leur projet
	public List<String> getJeunesSortantsProjetData() {
		List<String> listJeunesSortantsProjet = gizIndicateursRepository.fetchJeunesSortantsProjetData();
		return listJeunesSortantsProjet;
	}

	// # d'élèves formés sur FBS à travers les MFR
	public List<String> getElevesformesFBSMFRData() {
		List<String> listElevesformesFBSMFR = gizIndicateursRepository.fetchElevesformesFBSMFRData();
		return listElevesformesFBSMFR;
	}

	// # de producteurs couverts par la mutuelle de santé mahavelona
	public List<String> getProducteursMahavelonaM12Data() {
		List<String> listProducteursMahavelonaM12 = gizIndicateursRepository.fetchProducteursMahavelonaM12Data();
		return listProducteursMahavelonaM12;
	}

	// Taux de sinistralité au niveau des zones d'intervention
	public List<String> getTauxSinistraliteData() {
		List<String> listTauxSinistralite = gizIndicateursRepository.fetchTauxSinistraliteData();
		return listTauxSinistralite;
	}

	// # de ménages les plus vulnérables bénéficiant de grants
	public List<String> getMenagesVulnerablesBeneficiantGrantsData() {
		List<String> listMenagesVulnerablesBeneficiantGrants = gizIndicateursRepository
				.fetchMenagesVulnerablesBeneficiantGrantsData();
		return listMenagesVulnerablesBeneficiantGrants;
	}

	// # de VSLA constitués
	public List<String> getVSLAConstituesData() {
		List<String> listVSLAConstitues = gizIndicateursRepository.fetchVSLAConstituesData();
		return listVSLAConstitues;
	}

}
