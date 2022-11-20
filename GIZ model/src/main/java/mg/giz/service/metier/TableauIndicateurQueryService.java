package mg.giz.service.metier;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import mg.giz.repository.TableauIndicateurRepository;

@Service
public class TableauIndicateurQueryService {

	@Resource
	private TableauIndicateurRepository tableauIndicateurRepository;

	// Revenu moyen de l'exploitation

	public List<String> getRevenuExploitationData() {
		List<String> listRevenuExploitation = tableauIndicateurRepository.fetchRevenuExploitationData();
		return listRevenuExploitation;
	}

	// Revenu moyen par type d'exploitation Type 1
	public List<String> getRevenuType1ExploitationData() {
		List<String> listRevenuType1Exploitation = tableauIndicateurRepository.fetchRevenuType1ExploitationData();
		return listRevenuType1Exploitation;
	}

	// Revenu moyen par type d'exploitation Type 2
	public List<String> getRevenuType2ExploitationData() {
		List<String> listRevenuType2Exploitation = tableauIndicateurRepository.fetchRevenuType2ExploitationData();
		return listRevenuType2Exploitation;
	}

	// Revenu moyen par type d'exploitation Type 3
	public List<String> getRevenuType3ExploitationData() {
		List<String> listRevenuType3Exploitation = tableauIndicateurRepository.fetchRevenuType3ExploitationData();
		return listRevenuType3Exploitation;
	}

	// Taux de diversification des revenus Type 1
	public List<String> getTauxDiversificationRevenusType1Data() {
		List<String> listTauxDiversificationRevenusType1 = tableauIndicateurRepository
				.fetchTauxDiversificationRevenusType1Data();
		return listTauxDiversificationRevenusType1;
	}

	// Taux de diversification des revenus Type 1 Agricole
	public List<String> getTauxDiversificationRevenusType1AgricoleData() {
		List<String> listTauxDiversificationRevenusType1Agricole = tableauIndicateurRepository
				.fetchTauxDiversificationRevenusType1AgricoleData();
		return listTauxDiversificationRevenusType1Agricole;
	}

	// Taux de diversification des revenus Type 1 Non Agricole
	public List<String> getTauxDiversificationRevenusType1NonAgricoleData() {
		List<String> listTauxDiversificationRevenusType1NonAgricole = tableauIndicateurRepository
				.fetchTauxDiversificationRevenusType1NonAgricoleData();
		return listTauxDiversificationRevenusType1NonAgricole;
	}

	// Taux de diversification des revenus Type 2
	public List<String> getTauxDiversificationRevenusType2Data() {
		List<String> listTauxDiversificationRevenusType2 = tableauIndicateurRepository
				.fetchTauxDiversificationRevenusType2Data();
		return listTauxDiversificationRevenusType2;
	}

	// Taux de diversification des revenus Type 2 Agricole
	public List<String> getTauxDiversificationRevenusType2AgricoleData() {
		List<String> listTauxDiversificationRevenusType2Agricole = tableauIndicateurRepository
				.fetchTauxDiversificationRevenusType2AgricoleData();
		return listTauxDiversificationRevenusType2Agricole;
	}

	// Taux de diversification des revenus Type 2 Non Agricole
	public List<String> getTauxDiversificationRevenusType2NonAgricoleData() {
		List<String> listTauxDiversificationRevenusType2NonAgricole = tableauIndicateurRepository
				.fetchTauxDiversificationRevenusType2NonAgricoleData();
		return listTauxDiversificationRevenusType2NonAgricole;
	}

	// Taux de diversification des revenus Type 3 Agricole
	public List<String> getTauxDiversificationRevenusType3Data() {
		List<String> listTauxDiversificationRevenusType3 = tableauIndicateurRepository
				.fetchTauxDiversificationRevenusType3Data();
		return listTauxDiversificationRevenusType3;
	}

	// Taux de diversification des revenus Type 3 Agricole
	public List<String> getTauxDiversificationRevenusType3AgricoleData() {
		List<String> listTauxDiversificationRevenusType3Agricole = tableauIndicateurRepository
				.fetchTauxDiversificationRevenusType3AgricoleData();
		return listTauxDiversificationRevenusType3Agricole;
	}

	// Taux de diversification des revenus Type 3 non agricole
	public List<String> getTauxDiversificationRevenusType3NonAgricoleData() {
		List<String> listTauxDiversificationRevenusType3NonAgricole = tableauIndicateurRepository
				.fetchTauxDiversificationRevenusType3NonAgricoleData();
		return listTauxDiversificationRevenusType3NonAgricole;
	}

	// # de mois de soudure alimentaire/difficulté économique Type 1
	public List<String> getMoisSoudureType1Data() {
		List<String> listMoisSoudureType1 = tableauIndicateurRepository.fetchMoisSoudureType1Data();
		return listMoisSoudureType1;
	}

	// # de mois de soudure alimentaire/difficulté économique Type 2
	public List<String> getMoisSoudureType2Data() {
		List<String> listMoisSoudureType2 = tableauIndicateurRepository.fetchMoisSoudureType2Data();
		return listMoisSoudureType2;
	}

	// # de mois de soudure alimentaire/difficulté économique Type 3
	public List<String> getMoisSoudureType3Data() {
		List<String> listMoisSoudureType3 = tableauIndicateurRepository.fetchMoisSoudureType3Data();
		return listMoisSoudureType3;
	}

	// # de FR suivis
	public List<String> getFRSuiviData() {
		List<String> listFRSuivi = tableauIndicateurRepository.fetchFRSuiviData();
		return listFRSuivi;
	}

	// # de restitution auprès des FR
	public List<String> getRestitutionFRData() {
		List<String> listRestitutionFR = tableauIndicateurRepository.fetchRestitutionFRData();
		return listRestitutionFR;
	}

	// # de formateurs FBS formés
	public List<String> getFormateursFBSFormesData() {
		List<String> listFormateursFBSFormes = tableauIndicateurRepository.fetchFormateursFBSFormesData();
		return listFormateursFBSFormes;
	}

	// # de producteurs sensibilisés
	public List<String> getProducteursSensibilisesData() {
		List<String> listProducteursSensibilises = tableauIndicateurRepository.fetchProducteursSensibilisesData();
		return listProducteursSensibilises;
	}

	// # de session de formation FBS effectués
	public List<String> getSessionFormationFBSData() {
		List<String> listSessionFormationFBS = tableauIndicateurRepository.fetchSessionFormationFBSData();
		return listSessionFormationFBS;
	}

	// # de producteurs formés (ayant terminé les 11 modules)
	public List<String> getProducteursFormesData() {
		List<String> listProducteursFormes = tableauIndicateurRepository.fetchProducteursFormesData();
		return listProducteursFormes;
	}

	// Taux de completion de producteurs formés
	public List<String> getTauxCompletionData() {
		List<String> listTauxCompletion = tableauIndicateurRepository.fetchTauxCompletionData();
		return listTauxCompletion;
	}

	// # de producteurs bénéficiant de renforcement de capacité post-formation FBS
	public List<String> getBeneficiantPostFormationFBSData() {
		List<String> listBeneficiantPostFormationFBS = tableauIndicateurRepository
				.fetchBeneficiantPostFormationFBSData();
		return listBeneficiantPostFormationFBS;
	}

	// # d'entrepreneurs identifiés
	public List<String> getEntrepreneursIdentifiesData() {
		List<String> listEntrepreneursIdentifies = tableauIndicateurRepository.fetchEntrepreneursIdentifiesData();
		return listEntrepreneursIdentifies;
	}

	// # de personnes ressources opérationnelles
	public List<String> getPersonnesRessourcesOperationnellesData() {
		List<String> listPersonnesRessourcesOperationnelles = tableauIndicateurRepository
				.fetchPersonnesRessourcesOperationnellesData();
		return listPersonnesRessourcesOperationnelles;
	}

	// # de participants aux formations dispensées par les personnes ressources
	public List<String> getParticipantsPersonnesRessourcesData() {
		List<String> listParticipantsPersonnesRessources = tableauIndicateurRepository
				.fetchParticipantsPersonnesRessourcesData();
		return listParticipantsPersonnesRessources;
	}

	// # de pépinièristes fonctionnels et gérant eux-même leur fonds
	public List<String> getPepinieristesFonctionnelsData() {
		List<String> listPepinieristesFonctionnels = tableauIndicateurRepository.fetchPepinieristesFonctionnelsData();
		return listPepinieristesFonctionnels;
	}

	// # d'ASA formés
	public List<String> getASAFormesData() {
		List<String> listASAFormes = tableauIndicateurRepository.fetchASAFormesData();
		return listASAFormes;
	}

	// # d'ASA opérationnels
	public List<String> getASAOperationnelsData() {
		List<String> listASAOperationnels = tableauIndicateurRepository.fetchASAOperationnelsData();
		return listASAOperationnels;
	}

	// Chiffre d'affaire mensuel moyen des ASA
	public List<String> getChiffreAffaireASAData() {
		List<String> listChiffreAffaireASA = tableauIndicateurRepository.fetchChiffreAffaireASAData();
		return listChiffreAffaireASA;
	}

	// # de bénéficiaires de service de santé animale
	public List<String> getBeneficiairesServiceSanteAnimaleData() {
		List<String> listBeneficiairesServiceSanteAnimale = tableauIndicateurRepository
				.fetchBeneficiairesServiceSanteAnimaleData();
		return listBeneficiairesServiceSanteAnimale;
	}

	// # de cheptels vaccinés
	public List<String> getCheptelsVaccinesData() {
		List<String> listCheptelsVaccines = tableauIndicateurRepository.fetchCheptelsVaccinesData();
		return listCheptelsVaccines;
	}

	// # de formateurs en élevages opérationnels
	public List<String> getFormateursElevagesOperationnelsData() {
		List<String> listFormateursElevagesOperationnels = tableauIndicateurRepository
				.fetchFormateursElevagesOperationnelsData();
		return listFormateursElevagesOperationnels;
	}

	// # de producteurs formés sur les bonnes pratiques d'élevage
	public List<String> getProducteursFormesBonnesPratiquesElevageData() {
		List<String> listProducteursFormesBonnesPratiquesElevage = tableauIndicateurRepository
				.fetchProducteursFormesBonnesPratiquesElevageData();
		return listProducteursFormesBonnesPratiquesElevage;
	}

	// # de producteurs qui ont adopté au moins une bonnes pratique d'élevage
	// (vaccination + alimentation ou logement ou reproduction)
	public List<String> getProducteursAdopteData() {
		List<String> listProducteursAdopte = tableauIndicateurRepository.fetchProducteursAdopteData();
		return listProducteursAdopte;
	}

	// # de fermes de diffusion opérationnelles
	public List<String> getFermesDiffusionOperationnellesData() {
		List<String> listFermesDiffusionOperationnelles = tableauIndicateurRepository
				.fetchFermesDiffusionOperationnellesData();
		return listFermesDiffusionOperationnelles;
	}

	// # de visiteurs des fermes de diffusion
	public List<String> getVisiteursFermesDiffusionData() {
		List<String> listVisiteursFermesDiffusion = tableauIndicateurRepository.fetchVisiteursFermesDiffusionData();
		return listVisiteursFermesDiffusion;
	}

	// # de structure de producteurs fonctionnels
	public List<String> getStructureProducteursFonctionnelsData() {
		List<String> listStructureProducteursFonctionnels = tableauIndicateurRepository
				.fetchStructureProducteursFonctionnelsData();
		return listStructureProducteursFonctionnels;
	}

	// # de structure de producteurs mettant en œuvre un service ou un projet
	public List<String> getStructureProducteursServiceData() {
		List<String> listStructureProducteursService = tableauIndicateurRepository
				.fetchStructureProducteursServiceData();
		return listStructureProducteursService;
	}

	// % de petits producteurs formés qui démontrent des compétences en leadership,
	// négociation et communication
	public List<String> getPetitsProducteursFormesData() {
		List<String> listPetitsProducteursFormes = tableauIndicateurRepository.fetchPetitsProducteursFormesData();
		return listPetitsProducteursFormes;
	}

	// # de leader de coopératives coachés
	public List<String> getLeaderCooperativesCoachesData() {
		List<String> listLeaderCooperativesCoaches = tableauIndicateurRepository.fetchLeaderCooperativesCoachesData();
		return listLeaderCooperativesCoaches;
	}

	// # de leader de coopératives formés
	public List<String> getLeaderCooperativesFormesData() {
		List<String> listLeaderCooperativesFormes = tableauIndicateurRepository.fetchLeaderCooperativesFormesData();
		return listLeaderCooperativesFormes;
	}

	// # de personnes touchées par les plateformes de dialogue
	public List<String> getPersonnesPlateformesDialogueData() {
		List<String> listPersonnesPlateformesDialogue = tableauIndicateurRepository
				.fetchPersonnesPlateformesDialogueData();
		return listPersonnesPlateformesDialogue;
	}

	// # et le type de résolutions issues des dialogues communautaires
	public List<String> getResolutionsDialoguesCommunautairesData() {
		List<String> listResolutionsDialoguesCommunautaires = tableauIndicateurRepository
				.fetchResolutionsDialoguesCommunautairesData();
		return listResolutionsDialoguesCommunautaires;
	}

	// # de MFR opérationnels
	public List<String> getMFROperationnelsData() {
		List<String> listMFROperationnels = tableauIndicateurRepository.fetchMFROperationnelsData();
		return listMFROperationnels;
	}

	// Un réseau de MFR opérationnel
	public List<String> getReseauMFROperationnelsData() {
		List<String> listReseauMFROperationnels = tableauIndicateurRepository.fetchReseauMFROperationnelsData();
		return listReseauMFROperationnels;
	}

	// # d'élèves étudiant dans les MFR
	public List<String> getElevesEtudiantMFRData() {
		List<String> listElevesEtudiantMFR = tableauIndicateurRepository.fetchElevesEtudiantMFRData();
		return listElevesEtudiantMFR;
	}

	// # de jeunes diplômés sortant des MFR
	public List<String> getJeunesdiplomessortantMFRData() {
		List<String> listJeunesdiplomessortantMFR = tableauIndicateurRepository.fetchJeunesdiplomessortantMFRData();
		return listJeunesdiplomessortantMFR;
	}

	// # de jeunes sortants des MFR mettant en œuvre leur projet
	public List<String> getJeunesSortantsProjetData() {
		List<String> listJeunesSortantsProjet = tableauIndicateurRepository.fetchJeunesSortantsProjetData();
		return listJeunesSortantsProjet;
	}

	// # d'élèves formés sur FBS à travers les MFR
	public List<String> getElevesformesFBSMFRData() {
		List<String> listElevesformesFBSMFR = tableauIndicateurRepository.fetchElevesformesFBSMFRData();
		return listElevesformesFBSMFR;
	}

	// # nombre d'échanges MFR entre Comité des jeunes
	public List<String> getEchangesMFRComiteJeunesData() {
		List<String> listEchangesMFRComiteJeunes = tableauIndicateurRepository.fetchEchangesMFRComiteJeunesData();
		return listEchangesMFRComiteJeunes;
	}

	// # d'école bénéficiant des subventions
	public List<String> getEcoleBeneficiantSubventionsData() {
		List<String> listEcoleBeneficiantSubventions = tableauIndicateurRepository
				.fetchEcoleBeneficiantSubventionsData();
		return listEcoleBeneficiantSubventions;
	}

	// % des FRAM qui utilisent effectivement les subventions
	public List<String> getFRAMUtilisentSubventionsData() {
		List<String> listFRAMUtilisentSubventions = tableauIndicateurRepository.fetchFRAMUtilisentSubventionsData();
		return listFRAMUtilisentSubventions;
	}

	// Proportions subventions % au budget des écoles N°1
	public List<String> getProportionsSubventions1Data() {
		List<String> listProportionsSubventions1 = tableauIndicateurRepository.fetchProportionsSubventions1Data();
		return listProportionsSubventions1;
	}

	// Proportions subventions % au budget des écoles N°2
	public List<String> getProportionsSubventions2Data() {
		List<String> listProportionsSubventions2 = tableauIndicateurRepository.fetchProportionsSubventions2Data();
		return listProportionsSubventions2;
	}

	// Proportions subventions % au budget des écoles N°3
	public List<String> getProportionsSubventions3Data() {
		List<String> listProportionsSubventions3 = tableauIndicateurRepository.fetchProportionsSubventions3Data();
		return listProportionsSubventions3;
	}

	// # d'élèves présents dans les écoles aidées
	public List<String> getElevesPresentsEcolesData() {
		List<String> listElevesPresentsEcoles = tableauIndicateurRepository.fetchElevesPresentsEcolesData();
		return listElevesPresentsEcoles;
	}

	// # d'enseignants formés à l'éducation environnementale
	public List<String> getEnseignantsFormesData() {
		List<String> listEnseignantsFormes = tableauIndicateurRepository.fetchEnseignantsFormesData();
		return listEnseignantsFormes;
	}

	// # d'enseignants kit mad'ère
	public List<String> getEnseignantsKitMadereData() {
		List<String> listEnseignantsKitMadere = tableauIndicateurRepository.fetchEnseignantsKitMadereData();
		return listEnseignantsKitMadere;
	}

	// # d'école concernées
	public List<String> getEcoleConcerneesData() {
		List<String> listEcoleConcernees = tableauIndicateurRepository.fetchEcoleConcerneesData();
		return listEcoleConcernees;
	}

	// # de participants au concours environnemental
	public List<String> getParticipantsConcoursData() {
		List<String> listParticipantsConcours = tableauIndicateurRepository.fetchParticipantsConcoursData();
		return listParticipantsConcours;
	}

	// Pourcentage de participant ayant obtenu la moyenne au concours
	// environnemental
	public List<String> getPourcentageParticipantData() {
		List<String> listPourcentageParticipant = tableauIndicateurRepository.fetchPourcentageParticipantData();
		return listPourcentageParticipant;
	}

	// # de producteurs couverts par la mutuelle de santé mahavelona
	public List<String> getMahavelonaM12AdherantsData() {
		List<String> listMahavelonaM12Adherants = tableauIndicateurRepository.fetchMahavelonaM12AdherantsData();
		return listMahavelonaM12Adherants;
	}

	// # de villages couverts par Mahavelona
	public List<String> getVillagesCouvertsMahavelonaData() {
		List<String> listVillagesCouvertsMahavelona = tableauIndicateurRepository.fetchVillagesCouvertsMahavelonaData();
		return listVillagesCouvertsMahavelona;
	}

	// Prévalence des maladies diarhéiques des membres de Mahavelona
	public List<String> getPrevalenceMaladiesData() {
		List<String> listPrevalenceMaladies = tableauIndicateurRepository.fetchPrevalenceMaladiesData();
		return listPrevalenceMaladies;
	}

	// Taux de sinistralité au niveau des zones d'intervention M7
	public List<String> getTauxSinistraliteM7Data() {
		List<String> listTauxSinistraliteM7 = tableauIndicateurRepository.fetchTauxSinistraliteM7Data();
		return listTauxSinistraliteM7;
	}

	// Taux de sinistralité au niveau des zones d'intervention M12
	public List<String> getTauxSinistraliteM12Data() {
		List<String> listTauxSinistraliteM12 = tableauIndicateurRepository.fetchTauxSinistraliteM12Data();
		return listTauxSinistraliteM12;
	}

	// Taux de fréquentation des centres de santé pour les enfants des ménages
	// pauvres
	public List<String> getTauxFrequentation1Data() {
		List<String> listTauxFrequentation1 = tableauIndicateurRepository.fetchTauxFrequentation1Data();
		return listTauxFrequentation1;
	}

	// Taux de fréquentation des structures de santé
	public List<String> getTauxFrequentation2Data() {
		List<String> listTauxFrequentation2 = tableauIndicateurRepository.fetchTauxFrequentation2Data();
		return listTauxFrequentation2;
	}

	// Taux de satisfaction des membres de Mahavelona
	public List<String> getTauxSatisfactionData() {
		List<String> listTauxSatisfaction = tableauIndicateurRepository.fetchTauxSatisfactionData();
		return listTauxSatisfaction;
	}

	// # de village ayant amélioré l'accès à l'eau potable
	public List<String> getVillageAmelioreData() {
		List<String> listVillageAmeliore = tableauIndicateurRepository.fetchVillageAmelioreData();
		return listVillageAmeliore;
	}

	// # de ménages les plus vulnérables bénéficiant de grants
	public List<String> getBeneficiantGrantsData() {
		List<String> listBeneficiantGrants = tableauIndicateurRepository.fetchBeneficiantGrantsData();
		return listBeneficiantGrants;
	}

	// Subventions allouées aux ménages les plus vulnérables
	public List<String> getSubventionsMenagesData() {
		List<String> listSubventionsMenages = tableauIndicateurRepository.fetchSubventionsMenagesData();
		return listSubventionsMenages;
	}

	// # ménage qui rapportent que l'utilisation des grants
	public List<String> getMenageRapportentGrantsData() {
		List<String> listMenageRapportentGrants = tableauIndicateurRepository.fetchMenageRapportentGrantsData();
		return listMenageRapportentGrants;
	}

	// # de VSLA constitués
	public List<String> getVSLAConstituesData() {
		List<String> listVSLAConstitues = tableauIndicateurRepository.fetchVSLAConstituesData();
		return listVSLAConstitues;
	}

	// # de personnes ayant accès aux services financiers informels via les VSLA
	public List<String> getPersonnesFinanciersVSLAData() {
		List<String> listPersonnesFinanciersVSLA = tableauIndicateurRepository.fetchPersonnesFinanciersVSLAData();
		return listPersonnesFinanciersVSLA;
	}

	// Montant des épargnes investis dans le groupe VSLA
	public List<String> getMontantInvestisGroupeVSLAData() {
		List<String> listMontantInvestisGroupeVSLA = tableauIndicateurRepository.fetchMontantInvestisGroupeVSLAData();
		return listMontantInvestisGroupeVSLA;
	}

	// # de VSLA fonctionnels
	public List<String> getVSLAFonctionnelsData() {
		List<String> listVSLAFonctionnels = tableauIndicateurRepository.fetchVSLAFonctionnelsData();
		return listVSLAFonctionnels;
	}

	// Mahavelona (lilghtpackage) => M7 Adhérant
	public List<String> getMahavelonaM7AdherantData() {
		List<String> listMahavelonaM7Adherant = tableauIndicateurRepository.fetchMahavelonaM7AdherantData();
		return listMahavelonaM7Adherant;
	}

	// # de jeunes participant au programme d'alphabétisation
	public List<String> getJeunesParticipantAlphabetisationData() {
		List<String> listJeunesParticipantAlphabetisation = tableauIndicateurRepository
				.fetchJeunesParticipantAlphabetisationData();
		return listJeunesParticipantAlphabetisation;
	}

	// # de jeunes déscolarisés ayant complèté le programme d'alphabétisation
	public List<String> getJeunesDescolarisesData() {
		List<String> listJeunesDescolarises = tableauIndicateurRepository.fetchJeunesDescolarisesData();
		return listJeunesDescolarises;
	}

	// # de jeunes ayant complèté le programme d'alphabétisation
	public List<String> getJeunesAyantCompleteData() {
		List<String> listJeunesAyantComplete = tableauIndicateurRepository.fetchJeunesAyantCompleteData();
		return listJeunesAyantComplete;
	}

	// # de jeunes formés en plan de vie viable (pathway)
	public List<String> getPathwayData() {
		List<String> listPathway = tableauIndicateurRepository.fetchPathwayData();
		return listPathway;
	}

	// # de jeunes ayant un plan de vie viable, à préciser par type de plan de vie
	public List<String> getJeunesTypePlanVieData() {
		List<String> listJeunesTypePlanVie = tableauIndicateurRepository.fetchJeunesTypePlanVieData();
		return listJeunesTypePlanVie;
	}

	// # de jeunes ayant obtenu des grants
	public List<String> getJeunesAyantObtenuGrantsData() {
		List<String> listJeunesAyantObtenuGrants = tableauIndicateurRepository.fetchJeunesAyantObtenuGrantsData();
		return listJeunesAyantObtenuGrants;
	}

	// Taux d'abandon scolaire des jeunes
	public List<String> getTauxAbandonScolaireData() {
		List<String> listTauxAbandonScolaire = tableauIndicateurRepository.fetchTauxAbandonScolaireData();
		return listTauxAbandonScolaire;
	}

	// # des ménages sensibilisés
	public List<String> getMenagesSensibilisesData() {
		List<String> listMenagesSensibilises = tableauIndicateurRepository.fetchMenagesSensibilisesData();
		return listMenagesSensibilises;
	}

	// Taux de diversification alimentaire des ménages pauvres
	public List<String> getTauxDiversificationMenagespauvresData() {
		List<String> listTauxDiversificationMenagespauvres = tableauIndicateurRepository
				.fetchTauxDiversificationMenagespauvresData();
		return listTauxDiversificationMenagespauvres;
	}

	// Taux de fréquentation des centres de santé pour les enfants des ménages
	// pauvres
	public List<String> getTauxFrequentationEnfantsData() {
		List<String> listTauxFrequentationEnfants = tableauIndicateurRepository.fetchTauxFrequentationEnfantsData();
		return listTauxFrequentationEnfants;
	}

	// Au moins 3 recommandations de santé
	public List<String> getRecommandationsSanteData() {
		List<String> listRecommandationsSante = tableauIndicateurRepository.fetchRecommandationsSanteData();
		return listRecommandationsSante;
	}

	// # d'atelier du secteur auquel participe le projet
	public List<String> getAtelierSecteurData() {
		List<String> listAtelierSecteur = tableauIndicateurRepository.fetchAtelierSecteurData();
		return listAtelierSecteur;
	}

	// # de participation de SAVE THE CHILDREN aux réunions de SVI
	public List<String> getParticipationReunionsSVIData() {
		List<String> listParticipationReunionsSVI = tableauIndicateurRepository.fetchParticipationReunionsSVIData();
		return listParticipationReunionsSVI;
	}

	// Taux de connaissance des droits des enfants dans les ménages et communautés
	public List<String> getTauxConnaissanceData() {
		List<String> listTauxConnaissance = tableauIndicateurRepository.fetchTauxConnaissanceData();
		return listTauxConnaissance;
	}

	// # d'acteur de la filière
	public List<String> getActeurFiliereData() {
		List<String> listActeurFiliere = tableauIndicateurRepository.fetchActeurFiliereData();
		return listActeurFiliere;
	}

	// Etude d'Impact complète et partagee avec Unilever/Symrise
	public List<String> getEtudeImpactCompleteData() {
		List<String> listEtudeImpactComplete = tableauIndicateurRepository.fetchEtudeImpactCompleteData();
		return listEtudeImpactComplete;
	}

}
