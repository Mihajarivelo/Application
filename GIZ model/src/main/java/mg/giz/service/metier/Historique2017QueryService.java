package mg.giz.service.metier;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mg.giz.repository.Historique2017Repository;

@Service
public class Historique2017QueryService {

	@Resource
	private Historique2017Repository historique2017Repository;

	// Revenu moyen de l'exploitation

	public List<String> getRevenuExploitationData() {
		List<String> listRevenuExploitation = historique2017Repository.fetchRevenuExploitationData();
		return listRevenuExploitation;
	}

	// Revenu moyen par type d'exploitation Type 1
	public List<String> getRevenuType1ExploitationData() {
		List<String> listRevenuType1Exploitation = historique2017Repository.fetchRevenuType1ExploitationData();
		return listRevenuType1Exploitation;
	}

	// Revenu moyen par type d'exploitation Type 2
	public List<String> getRevenuType2ExploitationData() {
		List<String> listRevenuType2Exploitation = historique2017Repository.fetchRevenuType2ExploitationData();
		return listRevenuType2Exploitation;
	}

	// Revenu moyen par type d'exploitation Type 3
	public List<String> getRevenuType3ExploitationData() {
		List<String> listRevenuType3Exploitation = historique2017Repository.fetchRevenuType3ExploitationData();
		return listRevenuType3Exploitation;
	}

	// Taux de diversification des revenus Type 1
	public List<String> getTauxDiversificationRevenusType1Data() {
		List<String> listTauxDiversificationRevenusType1 = historique2017Repository
				.fetchTauxDiversificationRevenusType1Data();
		return listTauxDiversificationRevenusType1;
	}

	// Taux de diversification des revenus Type 1 Agricole
	public List<String> getTauxDiversificationRevenusType1AgricoleData() {
		List<String> listTauxDiversificationRevenusType1Agricole = historique2017Repository
				.fetchTauxDiversificationRevenusType1AgricoleData();
		return listTauxDiversificationRevenusType1Agricole;
	}

	// Taux de diversification des revenus Type 1 Non Agricole
	public List<String> getTauxDiversificationRevenusType1NonAgricoleData() {
		List<String> listTauxDiversificationRevenusType1NonAgricole = historique2017Repository
				.fetchTauxDiversificationRevenusType1NonAgricoleData();
		return listTauxDiversificationRevenusType1NonAgricole;
	}

	// Taux de diversification des revenus Type 2
	public List<String> getTauxDiversificationRevenusType2Data() {
		List<String> listTauxDiversificationRevenusType2 = historique2017Repository
				.fetchTauxDiversificationRevenusType2Data();
		return listTauxDiversificationRevenusType2;
	}

	// Taux de diversification des revenus Type 2 Agricole
	public List<String> getTauxDiversificationRevenusType2AgricoleData() {
		List<String> listTauxDiversificationRevenusType2Agricole = historique2017Repository
				.fetchTauxDiversificationRevenusType2AgricoleData();
		return listTauxDiversificationRevenusType2Agricole;
	}

	// Taux de diversification des revenus Type 2 Non Agricole
	public List<String> getTauxDiversificationRevenusType2NonAgricoleData() {
		List<String> listTauxDiversificationRevenusType2NonAgricole = historique2017Repository
				.fetchTauxDiversificationRevenusType2NonAgricoleData();
		return listTauxDiversificationRevenusType2NonAgricole;
	}

	// Taux de diversification des revenus Type 3 Agricole
	public List<String> getTauxDiversificationRevenusType3Data() {
		List<String> listTauxDiversificationRevenusType3 = historique2017Repository
				.fetchTauxDiversificationRevenusType3Data();
		return listTauxDiversificationRevenusType3;
	}

	// Taux de diversification des revenus Type 3 Agricole
	public List<String> getTauxDiversificationRevenusType3AgricoleData() {
		List<String> listTauxDiversificationRevenusType3Agricole = historique2017Repository
				.fetchTauxDiversificationRevenusType3AgricoleData();
		return listTauxDiversificationRevenusType3Agricole;
	}

	// Taux de diversification des revenus Type 3 non agricole
	public List<String> getTauxDiversificationRevenusType3NonAgricoleData() {
		List<String> listTauxDiversificationRevenusType3NonAgricole = historique2017Repository
				.fetchTauxDiversificationRevenusType3NonAgricoleData();
		return listTauxDiversificationRevenusType3NonAgricole;
	}

	// # de mois de soudure alimentaire/difficulté économique Type 1
	public List<String> getMoisSoudureType1Data() {
		List<String> listMoisSoudureType1 = historique2017Repository.fetchMoisSoudureType1Data();
		return listMoisSoudureType1;
	}

	// # de mois de soudure alimentaire/difficulté économique Type 2
	public List<String> getMoisSoudureType2Data() {
		List<String> listMoisSoudureType2 = historique2017Repository.fetchMoisSoudureType2Data();
		return listMoisSoudureType2;
	}

	// # de mois de soudure alimentaire/difficulté économique Type 3
	public List<String> getMoisSoudureType3Data() {
		List<String> listMoisSoudureType3 = historique2017Repository.fetchMoisSoudureType3Data();
		return listMoisSoudureType3;
	}

	// # de FR suivis
	public List<String> getFRSuiviData() {
		List<String> listFRSuivi = historique2017Repository.fetchFRSuiviData();
		return listFRSuivi;
	}

	// # de restitution auprès des FR
	public List<String> getRestitutionFRData() {
		List<String> listRestitutionFR = historique2017Repository.fetchRestitutionFRData();
		return listRestitutionFR;
	}

	// # de formateurs FBS formés
	public List<String> getFormateursFBSFormesData() {
		List<String> listFormateursFBSFormes = historique2017Repository.fetchFormateursFBSFormesData();
		return listFormateursFBSFormes;
	}

	// # de producteurs sensibilisés
	public List<String> getProducteursSensibilisesData() {
		List<String> listProducteursSensibilises = historique2017Repository.fetchProducteursSensibilisesData();
		return listProducteursSensibilises;
	}

	// # de session de formation FBS effectués
	public List<String> getSessionFormationFBSData() {
		List<String> listSessionFormationFBS = historique2017Repository.fetchSessionFormationFBSData();
		return listSessionFormationFBS;
	}

	// # de producteurs formés (ayant terminé les 11 modules)
	public List<String> getProducteursFormesData() {
		List<String> listProducteursFormes = historique2017Repository.fetchProducteursFormesData();
		return listProducteursFormes;
	}

	// Taux de completion de producteurs formés
	public List<String> getTauxCompletionData() {
		List<String> listTauxCompletion = historique2017Repository.fetchTauxCompletionData();
		return listTauxCompletion;
	}

	// # de producteurs bénéficiant de renforcement de capacité post-formation FBS
	public List<String> getBeneficiantPostFormationFBSData() {
		List<String> listBeneficiantPostFormationFBS = historique2017Repository.fetchBeneficiantPostFormationFBSData();
		return listBeneficiantPostFormationFBS;
	}

	// # d'entrepreneurs identifiés
	public List<String> getEntrepreneursIdentifiesData() {
		List<String> listEntrepreneursIdentifies = historique2017Repository.fetchEntrepreneursIdentifiesData();
		return listEntrepreneursIdentifies;
	}

	// # de personnes ressources opérationnelles
	public List<String> getPersonnesRessourcesOperationnellesData() {
		List<String> listPersonnesRessourcesOperationnelles = historique2017Repository
				.fetchPersonnesRessourcesOperationnellesData();
		return listPersonnesRessourcesOperationnelles;
	}

	// # de participants aux formations dispensées par les personnes ressources
	public List<String> getParticipantsPersonnesRessourcesData() {
		List<String> listParticipantsPersonnesRessources = historique2017Repository
				.fetchParticipantsPersonnesRessourcesData();
		return listParticipantsPersonnesRessources;
	}

	// # de pépinièristes fonctionnels et gérant eux-même leur fonds
	public List<String> getPepinieristesFonctionnelsData() {
		List<String> listPepinieristesFonctionnels = historique2017Repository.fetchPepinieristesFonctionnelsData();
		return listPepinieristesFonctionnels;
	}

	// # d'ASA formés
	public List<String> getASAFormesData() {
		List<String> listASAFormes = historique2017Repository.fetchASAFormesData();
		return listASAFormes;
	}

	// # d'ASA opérationnels
	public List<String> getASAOperationnelsData() {
		List<String> listASAOperationnels = historique2017Repository.fetchASAOperationnelsData();
		return listASAOperationnels;
	}

	// Chiffre d'affaire mensuel moyen des ASA
	public List<String> getChiffreAffaireASAData() {
		List<String> listChiffreAffaireASA = historique2017Repository.fetchChiffreAffaireASAData();
		return listChiffreAffaireASA;
	}

	// # de bénéficiaires de service de santé animale
	public List<String> getBeneficiairesServiceSanteAnimaleData() {
		List<String> listBeneficiairesServiceSanteAnimale = historique2017Repository
				.fetchBeneficiairesServiceSanteAnimaleData();
		return listBeneficiairesServiceSanteAnimale;
	}

	// # de cheptels vaccinés
	public List<String> getCheptelsVaccinesData() {
		List<String> listCheptelsVaccines = historique2017Repository.fetchCheptelsVaccinesData();
		return listCheptelsVaccines;
	}

	// # de formateurs en élevages opérationnels
	public List<String> getFormateursElevagesOperationnelsData() {
		List<String> listFormateursElevagesOperationnels = historique2017Repository
				.fetchFormateursElevagesOperationnelsData();
		return listFormateursElevagesOperationnels;
	}

	// # de producteurs formés sur les bonnes pratiques d'élevage
	public List<String> getProducteursFormesBonnesPratiquesElevageData() {
		List<String> listProducteursFormesBonnesPratiquesElevage = historique2017Repository
				.fetchProducteursFormesBonnesPratiquesElevageData();
		return listProducteursFormesBonnesPratiquesElevage;
	}

	// # de producteurs qui ont adopté au moins une bonnes pratique d'élevage
	// (vaccination + alimentation ou logement ou reproduction)
	public List<String> getProducteursAdopteData() {
		List<String> listProducteursAdopte = historique2017Repository.fetchProducteursAdopteData();
		return listProducteursAdopte;
	}

	// # de fermes de diffusion opérationnelles
	public List<String> getFermesDiffusionOperationnellesData() {
		List<String> listFermesDiffusionOperationnelles = historique2017Repository
				.fetchFermesDiffusionOperationnellesData();
		return listFermesDiffusionOperationnelles;
	}

	// # de visiteurs des fermes de diffusion
	public List<String> getVisiteursFermesDiffusionData() {
		List<String> listVisiteursFermesDiffusion = historique2017Repository.fetchVisiteursFermesDiffusionData();
		return listVisiteursFermesDiffusion;
	}

	// # de structure de producteurs fonctionnels
	public List<String> getStructureProducteursFonctionnelsData() {
		List<String> listStructureProducteursFonctionnels = historique2017Repository
				.fetchStructureProducteursFonctionnelsData();
		return listStructureProducteursFonctionnels;
	}

	// # de structure de producteurs mettant en œuvre un service ou un projet
	public List<String> getStructureProducteursServiceData() {
		List<String> listStructureProducteursService = historique2017Repository.fetchStructureProducteursServiceData();
		return listStructureProducteursService;
	}

	// % de petits producteurs formés qui démontrent des compétences en leadership,
	// négociation et communication
	public List<String> getPetitsProducteursFormesData() {
		List<String> listPetitsProducteursFormes = historique2017Repository.fetchPetitsProducteursFormesData();
		return listPetitsProducteursFormes;
	}

	// # de leader de coopératives coachés
	public List<String> getLeaderCooperativesCoachesData() {
		List<String> listLeaderCooperativesCoaches = historique2017Repository.fetchLeaderCooperativesCoachesData();
		return listLeaderCooperativesCoaches;
	}

	// # de leader de coopératives formés
	public List<String> getLeaderCooperativesFormesData() {
		List<String> listLeaderCooperativesFormes = historique2017Repository.fetchLeaderCooperativesFormesData();
		return listLeaderCooperativesFormes;
	}

	// # de personnes touchées par les plateformes de dialogue
	public List<String> getPersonnesPlateformesDialogueData() {
		List<String> listPersonnesPlateformesDialogue = historique2017Repository
				.fetchPersonnesPlateformesDialogueData();
		return listPersonnesPlateformesDialogue;
	}

	// # et le type de résolutions issues des dialogues communautaires
	public List<String> getResolutionsDialoguesCommunautairesData() {
		List<String> listResolutionsDialoguesCommunautaires = historique2017Repository
				.fetchResolutionsDialoguesCommunautairesData();
		return listResolutionsDialoguesCommunautaires;
	}

	// # de MFR opérationnels
	public List<String> getMFROperationnelsData() {
		List<String> listMFROperationnels = historique2017Repository.fetchMFROperationnelsData();
		return listMFROperationnels;
	}

	// Un réseau de MFR opérationnel
	public List<String> getReseauMFROperationnelsData() {
		List<String> listReseauMFROperationnels = historique2017Repository.fetchReseauMFROperationnelsData();
		return listReseauMFROperationnels;
	}

	// # d'élèves étudiant dans les MFR
	public List<String> getElevesEtudiantMFRData() {
		List<String> listElevesEtudiantMFR = historique2017Repository.fetchElevesEtudiantMFRData();
		return listElevesEtudiantMFR;
	}

	// # de jeunes diplômés sortant des MFR
	public List<String> getJeunesdiplomessortantMFRData() {
		List<String> listJeunesdiplomessortantMFR = historique2017Repository.fetchJeunesdiplomessortantMFRData();
		return listJeunesdiplomessortantMFR;
	}

	// # de jeunes sortants des MFR mettant en œuvre leur projet
	public List<String> getJeunesSortantsProjetData() {
		List<String> listJeunesSortantsProjet = historique2017Repository.fetchJeunesSortantsProjetData();
		return listJeunesSortantsProjet;
	}

	// # d'élèves formés sur FBS à travers les MFR
	public List<String> getElevesformesFBSMFRData() {
		List<String> listElevesformesFBSMFR = historique2017Repository.fetchElevesformesFBSMFRData();
		return listElevesformesFBSMFR;
	}

	// # nombre d'échanges MFR entre Comité des jeunes
	public List<String> getEchangesMFRComiteJeunesData() {
		List<String> listEchangesMFRComiteJeunes = historique2017Repository.fetchEchangesMFRComiteJeunesData();
		return listEchangesMFRComiteJeunes;
	}

	// # d'école bénéficiant des subventions
	public List<String> getEcoleBeneficiantSubventionsData() {
		List<String> listEcoleBeneficiantSubventions = historique2017Repository.fetchEcoleBeneficiantSubventionsData();
		return listEcoleBeneficiantSubventions;
	}

	// % des FRAM qui utilisent effectivement les subventions
	public List<String> getFRAMUtilisentSubventionsData() {
		List<String> listFRAMUtilisentSubventions = historique2017Repository.fetchFRAMUtilisentSubventionsData();
		return listFRAMUtilisentSubventions;
	}

	// Proportions subventions % au budget des écoles N°1
	public List<String> getProportionsSubventions1Data() {
		List<String> listProportionsSubventions1 = historique2017Repository.fetchProportionsSubventions1Data();
		return listProportionsSubventions1;
	}

	// Proportions subventions % au budget des écoles N°2
	public List<String> getProportionsSubventions2Data() {
		List<String> listProportionsSubventions2 = historique2017Repository.fetchProportionsSubventions2Data();
		return listProportionsSubventions2;
	}

	// Proportions subventions % au budget des écoles N°3
	public List<String> getProportionsSubventions3Data() {
		List<String> listProportionsSubventions3 = historique2017Repository.fetchProportionsSubventions3Data();
		return listProportionsSubventions3;
	}

	// # d'élèves présents dans les écoles aidées
	public List<String> getElevesPresentsEcolesData() {
		List<String> listElevesPresentsEcoles = historique2017Repository.fetchElevesPresentsEcolesData();
		return listElevesPresentsEcoles;
	}

	// # d'enseignants formés à l'éducation environnementale
	public List<String> getEnseignantsFormesData() {
		List<String> listEnseignantsFormes = historique2017Repository.fetchEnseignantsFormesData();
		return listEnseignantsFormes;
	}

	// # d'enseignants kit mad'ère
	public List<String> getEnseignantsKitMadereData() {
		List<String> listEnseignantsKitMadere = historique2017Repository.fetchEnseignantsKitMadereData();
		return listEnseignantsKitMadere;
	}

	// # d'école concernées
	public List<String> getEcoleConcerneesData() {
		List<String> listEcoleConcernees = historique2017Repository.fetchEcoleConcerneesData();
		return listEcoleConcernees;
	}

	// # de participants au concours environnemental
	public List<String> getParticipantsConcoursData() {
		List<String> listParticipantsConcours = historique2017Repository.fetchParticipantsConcoursData();
		return listParticipantsConcours;
	}

	// Pourcentage de participant ayant obtenu la moyenne au concours
	// environnemental
	public List<String> getPourcentageParticipantData() {
		List<String> listPourcentageParticipant = historique2017Repository.fetchPourcentageParticipantData();
		return listPourcentageParticipant;
	}

	// # de producteurs couverts par la mutuelle de santé mahavelona
	public List<String> getMahavelonaM12AdherantsData() {
		List<String> listMahavelonaM12Adherants = historique2017Repository.fetchMahavelonaM12AdherantsData();
		return listMahavelonaM12Adherants;
	}

	// # de villages couverts par Mahavelona
	public List<String> getVillagesCouvertsMahavelonaData() {
		List<String> listVillagesCouvertsMahavelona = historique2017Repository.fetchVillagesCouvertsMahavelonaData();
		return listVillagesCouvertsMahavelona;
	}

	// Prévalence des maladies diarhéiques des membres de Mahavelona
	public List<String> getPrevalenceMaladiesData() {
		List<String> listPrevalenceMaladies = historique2017Repository.fetchPrevalenceMaladiesData();
		return listPrevalenceMaladies;
	}

	// Taux de sinistralité au niveau des zones d'intervention M7
	public List<String> getTauxSinistraliteM7Data() {
		List<String> listTauxSinistraliteM7 = historique2017Repository.fetchTauxSinistraliteM7Data();
		return listTauxSinistraliteM7;
	}

	// Taux de sinistralité au niveau des zones d'intervention M12
	public List<String> getTauxSinistraliteM12Data() {
		List<String> listTauxSinistraliteM12 = historique2017Repository.fetchTauxSinistraliteM12Data();
		return listTauxSinistraliteM12;
	}

	// Taux de fréquentation des centres de santé pour les enfants des ménages
	// pauvres
	public List<String> getTauxFrequentation1Data() {
		List<String> listTauxFrequentation1 = historique2017Repository.fetchTauxFrequentation1Data();
		return listTauxFrequentation1;
	}

	// Taux de fréquentation des structures de santé
	public List<String> getTauxFrequentation2Data() {
		List<String> listTauxFrequentation2 = historique2017Repository.fetchTauxFrequentation2Data();
		return listTauxFrequentation2;
	}

	// Taux de satisfaction des membres de Mahavelona
	public List<String> getTauxSatisfactionData() {
		List<String> listTauxSatisfaction = historique2017Repository.fetchTauxSatisfactionData();
		return listTauxSatisfaction;
	}

	// # de village ayant amélioré l'accès à l'eau potable
	public List<String> getVillageAmelioreData() {
		List<String> listVillageAmeliore = historique2017Repository.fetchVillageAmelioreData();
		return listVillageAmeliore;
	}

	// # de ménages les plus vulnérables bénéficiant de grants
	public List<String> getBeneficiantGrantsData() {
		List<String> listBeneficiantGrants = historique2017Repository.fetchBeneficiantGrantsData();
		return listBeneficiantGrants;
	}

	// Subventions allouées aux ménages les plus vulnérables
	public List<String> getSubventionsMenagesData() {
		List<String> listSubventionsMenages = historique2017Repository.fetchSubventionsMenagesData();
		return listSubventionsMenages;
	}

	// # ménage qui rapportent que l'utilisation des grants
	public List<String> getMenageRapportentGrantsData() {
		List<String> listMenageRapportentGrants = historique2017Repository.fetchMenageRapportentGrantsData();
		return listMenageRapportentGrants;
	}

	// # de VSLA constitués
	public List<String> getVSLAConstituesData() {
		List<String> listVSLAConstitues = historique2017Repository.fetchVSLAConstituesData();
		return listVSLAConstitues;
	}

	// # de personnes ayant accès aux services financiers informels via les VSLA
	public List<String> getPersonnesFinanciersVSLAData() {
		List<String> listPersonnesFinanciersVSLA = historique2017Repository.fetchPersonnesFinanciersVSLAData();
		return listPersonnesFinanciersVSLA;
	}

	// Montant des épargnes investis dans le groupe VSLA
	public List<String> getMontantInvestisGroupeVSLAData() {
		List<String> listMontantInvestisGroupeVSLA = historique2017Repository.fetchMontantInvestisGroupeVSLAData();
		return listMontantInvestisGroupeVSLA;
	}

	// # de VSLA fonctionnels
	public List<String> getVSLAFonctionnelsData() {
		List<String> listVSLAFonctionnels = historique2017Repository.fetchVSLAFonctionnelsData();
		return listVSLAFonctionnels;
	}

	// Mahavelona (lilghtpackage) => M7 Adhérant
	public List<String> getMahavelonaM7AdherantData() {
		List<String> listMahavelonaM7Adherant = historique2017Repository.fetchMahavelonaM7AdherantData();
		return listMahavelonaM7Adherant;
	}

	// # de jeunes participant au programme d'alphabétisation
	public List<String> getJeunesParticipantAlphabetisationData() {
		List<String> listJeunesParticipantAlphabetisation = historique2017Repository
				.fetchJeunesParticipantAlphabetisationData();
		return listJeunesParticipantAlphabetisation;
	}

	// # de jeunes déscolarisés ayant complèté le programme d'alphabétisation
	public List<String> getJeunesDescolarisesData() {
		List<String> listJeunesDescolarises = historique2017Repository.fetchJeunesDescolarisesData();
		return listJeunesDescolarises;
	}

	// # de jeunes ayant complèté le programme d'alphabétisation
	public List<String> getJeunesAyantCompleteData() {
		List<String> listJeunesAyantComplete = historique2017Repository.fetchJeunesAyantCompleteData();
		return listJeunesAyantComplete;
	}

	// # de jeunes formés en plan de vie viable (pathway)
	public List<String> getPathwayData() {
		List<String> listPathway = historique2017Repository.fetchPathwayData();
		return listPathway;
	}

	// # de jeunes ayant un plan de vie viable, à préciser par type de plan de vie
	public List<String> getJeunesTypePlanVieData() {
		List<String> listJeunesTypePlanVie = historique2017Repository.fetchJeunesTypePlanVieData();
		return listJeunesTypePlanVie;
	}

	// # de jeunes ayant obtenu des grants
	public List<String> getJeunesAyantObtenuGrantsData() {
		List<String> listJeunesAyantObtenuGrants = historique2017Repository.fetchJeunesAyantObtenuGrantsData();
		return listJeunesAyantObtenuGrants;
	}

	// Taux d'abandon scolaire des jeunes
	public List<String> getTauxAbandonScolaireData() {
		List<String> listTauxAbandonScolaire = historique2017Repository.fetchTauxAbandonScolaireData();
		return listTauxAbandonScolaire;
	}

	// # des ménages sensibilisés
	public List<String> getMenagesSensibilisesData() {
		List<String> listMenagesSensibilises = historique2017Repository.fetchMenagesSensibilisesData();
		return listMenagesSensibilises;
	}

	// Taux de diversification alimentaire des ménages pauvres
	public List<String> getTauxDiversificationMenagespauvresData() {
		List<String> listTauxDiversificationMenagespauvres = historique2017Repository
				.fetchTauxDiversificationMenagespauvresData();
		return listTauxDiversificationMenagespauvres;
	}

	// Taux de fréquentation des centres de santé pour les enfants des ménages
	// pauvres
	public List<String> getTauxFrequentationEnfantsData() {
		List<String> listTauxFrequentationEnfants = historique2017Repository.fetchTauxFrequentationEnfantsData();
		return listTauxFrequentationEnfants;
	}

	// Au moins 3 recommandations de santé
	public List<String> getRecommandationsSanteData() {
		List<String> listRecommandationsSante = historique2017Repository.fetchRecommandationsSanteData();
		return listRecommandationsSante;
	}

	// # d'atelier du secteur auquel participe le projet
	public List<String> getAtelierSecteurData() {
		List<String> listAtelierSecteur = historique2017Repository.fetchAtelierSecteurData();
		return listAtelierSecteur;
	}

	// # de participation de SAVE THE CHILDREN aux réunions de SVI
	public List<String> getParticipationReunionsSVIData() {
		List<String> listParticipationReunionsSVI = historique2017Repository.fetchParticipationReunionsSVIData();
		return listParticipationReunionsSVI;
	}

	// Taux de connaissance des droits des enfants dans les ménages et communautés
	public List<String> getTauxConnaissanceData() {
		List<String> listTauxConnaissance = historique2017Repository.fetchTauxConnaissanceData();
		return listTauxConnaissance;
	}

	// # d'acteur de la filière
	public List<String> getActeurFiliereData() {
		List<String> listActeurFiliere = historique2017Repository.fetchActeurFiliereData();
		return listActeurFiliere;
	}

	// Etude d'Impact complète et partagee avec Unilever/Symrise
	public List<String> getEtudeImpactCompleteData() {
		List<String> listEtudeImpactComplete = historique2017Repository.fetchEtudeImpactCompleteData();
		return listEtudeImpactComplete;
	}

}
