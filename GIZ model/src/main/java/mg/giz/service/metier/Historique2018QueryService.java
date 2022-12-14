package mg.giz.service.metier;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mg.giz.repository.Historique2018Repository;

@Service
public class Historique2018QueryService {

	@Resource
	private Historique2018Repository historique2018Repository;

	// Revenu moyen de l'exploitation

	public List<String> getRevenuExploitationData() {
		List<String> listRevenuExploitation = historique2018Repository.fetchRevenuExploitationData();
		return listRevenuExploitation;
	}

	// Revenu moyen par type d'exploitation Type 1
	public List<String> getRevenuType1ExploitationData() {
		List<String> listRevenuType1Exploitation = historique2018Repository.fetchRevenuType1ExploitationData();
		return listRevenuType1Exploitation;
	}

	// Revenu moyen par type d'exploitation Type 2
	public List<String> getRevenuType2ExploitationData() {
		List<String> listRevenuType2Exploitation = historique2018Repository.fetchRevenuType2ExploitationData();
		return listRevenuType2Exploitation;
	}

	// Revenu moyen par type d'exploitation Type 3
	public List<String> getRevenuType3ExploitationData() {
		List<String> listRevenuType3Exploitation = historique2018Repository.fetchRevenuType3ExploitationData();
		return listRevenuType3Exploitation;
	}

	// Taux de diversification des revenus Type 1
	public List<String> getTauxDiversificationRevenusType1Data() {
		List<String> listTauxDiversificationRevenusType1 = historique2018Repository
				.fetchTauxDiversificationRevenusType1Data();
		return listTauxDiversificationRevenusType1;
	}

	// Taux de diversification des revenus Type 1 Agricole
	public List<String> getTauxDiversificationRevenusType1AgricoleData() {
		List<String> listTauxDiversificationRevenusType1Agricole = historique2018Repository
				.fetchTauxDiversificationRevenusType1AgricoleData();
		return listTauxDiversificationRevenusType1Agricole;
	}

	// Taux de diversification des revenus Type 1 Non Agricole
	public List<String> getTauxDiversificationRevenusType1NonAgricoleData() {
		List<String> listTauxDiversificationRevenusType1NonAgricole = historique2018Repository
				.fetchTauxDiversificationRevenusType1NonAgricoleData();
		return listTauxDiversificationRevenusType1NonAgricole;
	}

	// Taux de diversification des revenus Type 2
	public List<String> getTauxDiversificationRevenusType2Data() {
		List<String> listTauxDiversificationRevenusType2 = historique2018Repository
				.fetchTauxDiversificationRevenusType2Data();
		return listTauxDiversificationRevenusType2;
	}

	// Taux de diversification des revenus Type 2 Agricole
	public List<String> getTauxDiversificationRevenusType2AgricoleData() {
		List<String> listTauxDiversificationRevenusType2Agricole = historique2018Repository
				.fetchTauxDiversificationRevenusType2AgricoleData();
		return listTauxDiversificationRevenusType2Agricole;
	}

	// Taux de diversification des revenus Type 2 Non Agricole
	public List<String> getTauxDiversificationRevenusType2NonAgricoleData() {
		List<String> listTauxDiversificationRevenusType2NonAgricole = historique2018Repository
				.fetchTauxDiversificationRevenusType2NonAgricoleData();
		return listTauxDiversificationRevenusType2NonAgricole;
	}

	// Taux de diversification des revenus Type 3 Agricole
	public List<String> getTauxDiversificationRevenusType3Data() {
		List<String> listTauxDiversificationRevenusType3 = historique2018Repository
				.fetchTauxDiversificationRevenusType3Data();
		return listTauxDiversificationRevenusType3;
	}

	// Taux de diversification des revenus Type 3 Agricole
	public List<String> getTauxDiversificationRevenusType3AgricoleData() {
		List<String> listTauxDiversificationRevenusType3Agricole = historique2018Repository
				.fetchTauxDiversificationRevenusType3AgricoleData();
		return listTauxDiversificationRevenusType3Agricole;
	}

	// Taux de diversification des revenus Type 3 non agricole
	public List<String> getTauxDiversificationRevenusType3NonAgricoleData() {
		List<String> listTauxDiversificationRevenusType3NonAgricole = historique2018Repository
				.fetchTauxDiversificationRevenusType3NonAgricoleData();
		return listTauxDiversificationRevenusType3NonAgricole;
	}

	// # de mois de soudure alimentaire/difficult?? ??conomique Type 1
	public List<String> getMoisSoudureType1Data() {
		List<String> listMoisSoudureType1 = historique2018Repository.fetchMoisSoudureType1Data();
		return listMoisSoudureType1;
	}

	// # de mois de soudure alimentaire/difficult?? ??conomique Type 2
	public List<String> getMoisSoudureType2Data() {
		List<String> listMoisSoudureType2 = historique2018Repository.fetchMoisSoudureType2Data();
		return listMoisSoudureType2;
	}

	// # de mois de soudure alimentaire/difficult?? ??conomique Type 3
	public List<String> getMoisSoudureType3Data() {
		List<String> listMoisSoudureType3 = historique2018Repository.fetchMoisSoudureType3Data();
		return listMoisSoudureType3;
	}

	// # de FR suivis
	public List<String> getFRSuiviData() {
		List<String> listFRSuivi = historique2018Repository.fetchFRSuiviData();
		return listFRSuivi;
	}

	// # de restitution aupr??s des FR
	public List<String> getRestitutionFRData() {
		List<String> listRestitutionFR = historique2018Repository.fetchRestitutionFRData();
		return listRestitutionFR;
	}

	// # de formateurs FBS form??s
	public List<String> getFormateursFBSFormesData() {
		List<String> listFormateursFBSFormes = historique2018Repository.fetchFormateursFBSFormesData();
		return listFormateursFBSFormes;
	}

	// # de producteurs sensibilis??s
	public List<String> getProducteursSensibilisesData() {
		List<String> listProducteursSensibilises = historique2018Repository.fetchProducteursSensibilisesData();
		return listProducteursSensibilises;
	}

	// # de session de formation FBS effectu??s
	public List<String> getSessionFormationFBSData() {
		List<String> listSessionFormationFBS = historique2018Repository.fetchSessionFormationFBSData();
		return listSessionFormationFBS;
	}

	// # de producteurs form??s (ayant termin?? les 11 modules)
	public List<String> getProducteursFormesData() {
		List<String> listProducteursFormes = historique2018Repository.fetchProducteursFormesData();
		return listProducteursFormes;
	}

	// Taux de completion de producteurs form??s
	public List<String> getTauxCompletionData() {
		List<String> listTauxCompletion = historique2018Repository.fetchTauxCompletionData();
		return listTauxCompletion;
	}

	// # de producteurs b??n??ficiant de renforcement de capacit?? post-formation FBS
	public List<String> getBeneficiantPostFormationFBSData() {
		List<String> listBeneficiantPostFormationFBS = historique2018Repository
				.fetchBeneficiantPostFormationFBSData();
		return listBeneficiantPostFormationFBS;
	}

	// # d'entrepreneurs identifi??s
	public List<String> getEntrepreneursIdentifiesData() {
		List<String> listEntrepreneursIdentifies = historique2018Repository.fetchEntrepreneursIdentifiesData();
		return listEntrepreneursIdentifies;
	}

	// # de personnes ressources op??rationnelles
	public List<String> getPersonnesRessourcesOperationnellesData() {
		List<String> listPersonnesRessourcesOperationnelles = historique2018Repository
				.fetchPersonnesRessourcesOperationnellesData();
		return listPersonnesRessourcesOperationnelles;
	}

	// # de participants aux formations dispens??es par les personnes ressources
	public List<String> getParticipantsPersonnesRessourcesData() {
		List<String> listParticipantsPersonnesRessources = historique2018Repository
				.fetchParticipantsPersonnesRessourcesData();
		return listParticipantsPersonnesRessources;
	}

	// # de p??pini??ristes fonctionnels et g??rant eux-m??me leur fonds
	public List<String> getPepinieristesFonctionnelsData() {
		List<String> listPepinieristesFonctionnels = historique2018Repository.fetchPepinieristesFonctionnelsData();
		return listPepinieristesFonctionnels;
	}

	// # d'ASA form??s
	public List<String> getASAFormesData() {
		List<String> listASAFormes = historique2018Repository.fetchASAFormesData();
		return listASAFormes;
	}

	// # d'ASA op??rationnels
	public List<String> getASAOperationnelsData() {
		List<String> listASAOperationnels = historique2018Repository.fetchASAOperationnelsData();
		return listASAOperationnels;
	}

	// Chiffre d'affaire mensuel moyen des ASA
	public List<String> getChiffreAffaireASAData() {
		List<String> listChiffreAffaireASA = historique2018Repository.fetchChiffreAffaireASAData();
		return listChiffreAffaireASA;
	}

	// # de b??n??ficiaires de service de sant?? animale
	public List<String> getBeneficiairesServiceSanteAnimaleData() {
		List<String> listBeneficiairesServiceSanteAnimale = historique2018Repository
				.fetchBeneficiairesServiceSanteAnimaleData();
		return listBeneficiairesServiceSanteAnimale;
	}

	// # de cheptels vaccin??s
	public List<String> getCheptelsVaccinesData() {
		List<String> listCheptelsVaccines = historique2018Repository.fetchCheptelsVaccinesData();
		return listCheptelsVaccines;
	}

	// # de formateurs en ??levages op??rationnels
	public List<String> getFormateursElevagesOperationnelsData() {
		List<String> listFormateursElevagesOperationnels = historique2018Repository
				.fetchFormateursElevagesOperationnelsData();
		return listFormateursElevagesOperationnels;
	}

	// # de producteurs form??s sur les bonnes pratiques d'??levage
	public List<String> getProducteursFormesBonnesPratiquesElevageData() {
		List<String> listProducteursFormesBonnesPratiquesElevage = historique2018Repository
				.fetchProducteursFormesBonnesPratiquesElevageData();
		return listProducteursFormesBonnesPratiquesElevage;
	}

	// # de producteurs qui ont adopt?? au moins une bonnes pratique d'??levage
	// (vaccination + alimentation ou logement ou reproduction)
	public List<String> getProducteursAdopteData() {
		List<String> listProducteursAdopte = historique2018Repository.fetchProducteursAdopteData();
		return listProducteursAdopte;
	}

	// # de fermes de diffusion op??rationnelles
	public List<String> getFermesDiffusionOperationnellesData() {
		List<String> listFermesDiffusionOperationnelles = historique2018Repository
				.fetchFermesDiffusionOperationnellesData();
		return listFermesDiffusionOperationnelles;
	}

	// # de visiteurs des fermes de diffusion
	public List<String> getVisiteursFermesDiffusionData() {
		List<String> listVisiteursFermesDiffusion = historique2018Repository.fetchVisiteursFermesDiffusionData();
		return listVisiteursFermesDiffusion;
	}

	// # de structure de producteurs fonctionnels
	public List<String> getStructureProducteursFonctionnelsData() {
		List<String> listStructureProducteursFonctionnels = historique2018Repository
				.fetchStructureProducteursFonctionnelsData();
		return listStructureProducteursFonctionnels;
	}

	// # de structure de producteurs mettant en ??uvre un service ou un projet
	public List<String> getStructureProducteursServiceData() {
		List<String> listStructureProducteursService = historique2018Repository
				.fetchStructureProducteursServiceData();
		return listStructureProducteursService;
	}

	// % de petits producteurs form??s qui d??montrent des comp??tences en leadership,
	// n??gociation et communication
	public List<String> getPetitsProducteursFormesData() {
		List<String> listPetitsProducteursFormes = historique2018Repository.fetchPetitsProducteursFormesData();
		return listPetitsProducteursFormes;
	}

	// # de leader de coop??ratives coach??s
	public List<String> getLeaderCooperativesCoachesData() {
		List<String> listLeaderCooperativesCoaches = historique2018Repository.fetchLeaderCooperativesCoachesData();
		return listLeaderCooperativesCoaches;
	}

	// # de leader de coop??ratives form??s
	public List<String> getLeaderCooperativesFormesData() {
		List<String> listLeaderCooperativesFormes = historique2018Repository.fetchLeaderCooperativesFormesData();
		return listLeaderCooperativesFormes;
	}

	// # de personnes touch??es par les plateformes de dialogue
	public List<String> getPersonnesPlateformesDialogueData() {
		List<String> listPersonnesPlateformesDialogue = historique2018Repository
				.fetchPersonnesPlateformesDialogueData();
		return listPersonnesPlateformesDialogue;
	}

	// # et le type de r??solutions issues des dialogues communautaires
	public List<String> getResolutionsDialoguesCommunautairesData() {
		List<String> listResolutionsDialoguesCommunautaires = historique2018Repository
				.fetchResolutionsDialoguesCommunautairesData();
		return listResolutionsDialoguesCommunautaires;
	}

	// # de MFR op??rationnels
	public List<String> getMFROperationnelsData() {
		List<String> listMFROperationnels = historique2018Repository.fetchMFROperationnelsData();
		return listMFROperationnels;
	}

	// Un r??seau de MFR op??rationnel
	public List<String> getReseauMFROperationnelsData() {
		List<String> listReseauMFROperationnels = historique2018Repository.fetchReseauMFROperationnelsData();
		return listReseauMFROperationnels;
	}

	// # d'??l??ves ??tudiant dans les MFR
	public List<String> getElevesEtudiantMFRData() {
		List<String> listElevesEtudiantMFR = historique2018Repository.fetchElevesEtudiantMFRData();
		return listElevesEtudiantMFR;
	}

	// # de jeunes dipl??m??s sortant des MFR
	public List<String> getJeunesdiplomessortantMFRData() {
		List<String> listJeunesdiplomessortantMFR = historique2018Repository.fetchJeunesdiplomessortantMFRData();
		return listJeunesdiplomessortantMFR;
	}

	// # de jeunes sortants des MFR mettant en ??uvre leur projet
	public List<String> getJeunesSortantsProjetData() {
		List<String> listJeunesSortantsProjet = historique2018Repository.fetchJeunesSortantsProjetData();
		return listJeunesSortantsProjet;
	}

	// # d'??l??ves form??s sur FBS ?? travers les MFR
	public List<String> getElevesformesFBSMFRData() {
		List<String> listElevesformesFBSMFR = historique2018Repository.fetchElevesformesFBSMFRData();
		return listElevesformesFBSMFR;
	}

	// # nombre d'??changes MFR entre Comit?? des jeunes
	public List<String> getEchangesMFRComiteJeunesData() {
		List<String> listEchangesMFRComiteJeunes = historique2018Repository.fetchEchangesMFRComiteJeunesData();
		return listEchangesMFRComiteJeunes;
	}

	// # d'??cole b??n??ficiant des subventions
	public List<String> getEcoleBeneficiantSubventionsData() {
		List<String> listEcoleBeneficiantSubventions = historique2018Repository
				.fetchEcoleBeneficiantSubventionsData();
		return listEcoleBeneficiantSubventions;
	}

	// % des FRAM qui utilisent effectivement les subventions
	public List<String> getFRAMUtilisentSubventionsData() {
		List<String> listFRAMUtilisentSubventions = historique2018Repository.fetchFRAMUtilisentSubventionsData();
		return listFRAMUtilisentSubventions;
	}

	// Proportions subventions % au budget des ??coles N??1
	public List<String> getProportionsSubventions1Data() {
		List<String> listProportionsSubventions1 = historique2018Repository.fetchProportionsSubventions1Data();
		return listProportionsSubventions1;
	}

	// Proportions subventions % au budget des ??coles N??2
	public List<String> getProportionsSubventions2Data() {
		List<String> listProportionsSubventions2 = historique2018Repository.fetchProportionsSubventions2Data();
		return listProportionsSubventions2;
	}

	// Proportions subventions % au budget des ??coles N??3
	public List<String> getProportionsSubventions3Data() {
		List<String> listProportionsSubventions3 = historique2018Repository.fetchProportionsSubventions3Data();
		return listProportionsSubventions3;
	}

	// # d'??l??ves pr??sents dans les ??coles aid??es
	public List<String> getElevesPresentsEcolesData() {
		List<String> listElevesPresentsEcoles = historique2018Repository.fetchElevesPresentsEcolesData();
		return listElevesPresentsEcoles;
	}

	// # d'enseignants form??s ?? l'??ducation environnementale
	public List<String> getEnseignantsFormesData() {
		List<String> listEnseignantsFormes = historique2018Repository.fetchEnseignantsFormesData();
		return listEnseignantsFormes;
	}

	// # d'enseignants kit mad'??re
	public List<String> getEnseignantsKitMadereData() {
		List<String> listEnseignantsKitMadere = historique2018Repository.fetchEnseignantsKitMadereData();
		return listEnseignantsKitMadere;
	}

	// # d'??cole concern??es
	public List<String> getEcoleConcerneesData() {
		List<String> listEcoleConcernees = historique2018Repository.fetchEcoleConcerneesData();
		return listEcoleConcernees;
	}

	// # de participants au concours environnemental
	public List<String> getParticipantsConcoursData() {
		List<String> listParticipantsConcours = historique2018Repository.fetchParticipantsConcoursData();
		return listParticipantsConcours;
	}

	// Pourcentage de participant ayant obtenu la moyenne au concours
	// environnemental
	public List<String> getPourcentageParticipantData() {
		List<String> listPourcentageParticipant = historique2018Repository.fetchPourcentageParticipantData();
		return listPourcentageParticipant;
	}

	// # de producteurs couverts par la mutuelle de sant?? mahavelona
	public List<String> getMahavelonaM12AdherantsData() {
		List<String> listMahavelonaM12Adherants = historique2018Repository.fetchMahavelonaM12AdherantsData();
		return listMahavelonaM12Adherants;
	}

	// # de villages couverts par Mahavelona
	public List<String> getVillagesCouvertsMahavelonaData() {
		List<String> listVillagesCouvertsMahavelona = historique2018Repository.fetchVillagesCouvertsMahavelonaData();
		return listVillagesCouvertsMahavelona;
	}

	// Pr??valence des maladies diarh??iques des membres de Mahavelona
	public List<String> getPrevalenceMaladiesData() {
		List<String> listPrevalenceMaladies = historique2018Repository.fetchPrevalenceMaladiesData();
		return listPrevalenceMaladies;
	}

	// Taux de sinistralit?? au niveau des zones d'intervention M7
	public List<String> getTauxSinistraliteM7Data() {
		List<String> listTauxSinistraliteM7 = historique2018Repository.fetchTauxSinistraliteM7Data();
		return listTauxSinistraliteM7;
	}

	// Taux de sinistralit?? au niveau des zones d'intervention M12
	public List<String> getTauxSinistraliteM12Data() {
		List<String> listTauxSinistraliteM12 = historique2018Repository.fetchTauxSinistraliteM12Data();
		return listTauxSinistraliteM12;
	}

	// Taux de fr??quentation des centres de sant?? pour les enfants des m??nages
	// pauvres
	public List<String> getTauxFrequentation1Data() {
		List<String> listTauxFrequentation1 = historique2018Repository.fetchTauxFrequentation1Data();
		return listTauxFrequentation1;
	}

	// Taux de fr??quentation des structures de sant??
	public List<String> getTauxFrequentation2Data() {
		List<String> listTauxFrequentation2 = historique2018Repository.fetchTauxFrequentation2Data();
		return listTauxFrequentation2;
	}

	// Taux de satisfaction des membres de Mahavelona
	public List<String> getTauxSatisfactionData() {
		List<String> listTauxSatisfaction = historique2018Repository.fetchTauxSatisfactionData();
		return listTauxSatisfaction;
	}

	// # de village ayant am??lior?? l'acc??s ?? l'eau potable
	public List<String> getVillageAmelioreData() {
		List<String> listVillageAmeliore = historique2018Repository.fetchVillageAmelioreData();
		return listVillageAmeliore;
	}

	// # de m??nages les plus vuln??rables b??n??ficiant de grants
	public List<String> getBeneficiantGrantsData() {
		List<String> listBeneficiantGrants = historique2018Repository.fetchBeneficiantGrantsData();
		return listBeneficiantGrants;
	}

	// Subventions allou??es aux m??nages les plus vuln??rables
	public List<String> getSubventionsMenagesData() {
		List<String> listSubventionsMenages = historique2018Repository.fetchSubventionsMenagesData();
		return listSubventionsMenages;
	}

	// # m??nage qui rapportent que l'utilisation des grants
	public List<String> getMenageRapportentGrantsData() {
		List<String> listMenageRapportentGrants = historique2018Repository.fetchMenageRapportentGrantsData();
		return listMenageRapportentGrants;
	}

	// # de VSLA constitu??s
	public List<String> getVSLAConstituesData() {
		List<String> listVSLAConstitues = historique2018Repository.fetchVSLAConstituesData();
		return listVSLAConstitues;
	}

	// # de personnes ayant acc??s aux services financiers informels via les VSLA
	public List<String> getPersonnesFinanciersVSLAData() {
		List<String> listPersonnesFinanciersVSLA = historique2018Repository.fetchPersonnesFinanciersVSLAData();
		return listPersonnesFinanciersVSLA;
	}

	// Montant des ??pargnes investis dans le groupe VSLA
	public List<String> getMontantInvestisGroupeVSLAData() {
		List<String> listMontantInvestisGroupeVSLA = historique2018Repository.fetchMontantInvestisGroupeVSLAData();
		return listMontantInvestisGroupeVSLA;
	}

	// # de VSLA fonctionnels
	public List<String> getVSLAFonctionnelsData() {
		List<String> listVSLAFonctionnels = historique2018Repository.fetchVSLAFonctionnelsData();
		return listVSLAFonctionnels;
	}

	// Mahavelona (lilghtpackage) => M7 Adh??rant
	public List<String> getMahavelonaM7AdherantData() {
		List<String> listMahavelonaM7Adherant = historique2018Repository.fetchMahavelonaM7AdherantData();
		return listMahavelonaM7Adherant;
	}

	// # de jeunes participant au programme d'alphab??tisation
	public List<String> getJeunesParticipantAlphabetisationData() {
		List<String> listJeunesParticipantAlphabetisation = historique2018Repository
				.fetchJeunesParticipantAlphabetisationData();
		return listJeunesParticipantAlphabetisation;
	}

	// # de jeunes d??scolaris??s ayant compl??t?? le programme d'alphab??tisation
	public List<String> getJeunesDescolarisesData() {
		List<String> listJeunesDescolarises = historique2018Repository.fetchJeunesDescolarisesData();
		return listJeunesDescolarises;
	}

	// # de jeunes ayant compl??t?? le programme d'alphab??tisation
	public List<String> getJeunesAyantCompleteData() {
		List<String> listJeunesAyantComplete = historique2018Repository.fetchJeunesAyantCompleteData();
		return listJeunesAyantComplete;
	}

	// # de jeunes form??s en plan de vie viable (pathway)
	public List<String> getPathwayData() {
		List<String> listPathway = historique2018Repository.fetchPathwayData();
		return listPathway;
	}

	// # de jeunes ayant un plan de vie viable, ?? pr??ciser par type de plan de vie
	public List<String> getJeunesTypePlanVieData() {
		List<String> listJeunesTypePlanVie = historique2018Repository.fetchJeunesTypePlanVieData();
		return listJeunesTypePlanVie;
	}

	// # de jeunes ayant obtenu des grants
	public List<String> getJeunesAyantObtenuGrantsData() {
		List<String> listJeunesAyantObtenuGrants = historique2018Repository.fetchJeunesAyantObtenuGrantsData();
		return listJeunesAyantObtenuGrants;
	}

	// Taux d'abandon scolaire des jeunes
	public List<String> getTauxAbandonScolaireData() {
		List<String> listTauxAbandonScolaire = historique2018Repository.fetchTauxAbandonScolaireData();
		return listTauxAbandonScolaire;
	}

	// # des m??nages sensibilis??s
	public List<String> getMenagesSensibilisesData() {
		List<String> listMenagesSensibilises = historique2018Repository.fetchMenagesSensibilisesData();
		return listMenagesSensibilises;
	}

	// Taux de diversification alimentaire des m??nages pauvres
	public List<String> getTauxDiversificationMenagespauvresData() {
		List<String> listTauxDiversificationMenagespauvres = historique2018Repository
				.fetchTauxDiversificationMenagespauvresData();
		return listTauxDiversificationMenagespauvres;
	}

	// Taux de fr??quentation des centres de sant?? pour les enfants des m??nages
	// pauvres
	public List<String> getTauxFrequentationEnfantsData() {
		List<String> listTauxFrequentationEnfants = historique2018Repository.fetchTauxFrequentationEnfantsData();
		return listTauxFrequentationEnfants;
	}

	// Au moins 3 recommandations de sant??
	public List<String> getRecommandationsSanteData() {
		List<String> listRecommandationsSante = historique2018Repository.fetchRecommandationsSanteData();
		return listRecommandationsSante;
	}

	// # d'atelier du secteur auquel participe le projet
	public List<String> getAtelierSecteurData() {
		List<String> listAtelierSecteur = historique2018Repository.fetchAtelierSecteurData();
		return listAtelierSecteur;
	}

	// # de participation de SAVE THE CHILDREN aux r??unions de SVI
	public List<String> getParticipationReunionsSVIData() {
		List<String> listParticipationReunionsSVI = historique2018Repository.fetchParticipationReunionsSVIData();
		return listParticipationReunionsSVI;
	}

	// Taux de connaissance des droits des enfants dans les m??nages et communaut??s
	public List<String> getTauxConnaissanceData() {
		List<String> listTauxConnaissance = historique2018Repository.fetchTauxConnaissanceData();
		return listTauxConnaissance;
	}

	// # d'acteur de la fili??re
	public List<String> getActeurFiliereData() {
		List<String> listActeurFiliere = historique2018Repository.fetchActeurFiliereData();
		return listActeurFiliere;
	}

	// Etude d'Impact compl??te et partagee avec Unilever/Symrise
	public List<String> getEtudeImpactCompleteData() {
		List<String> listEtudeImpactComplete = historique2018Repository.fetchEtudeImpactCompleteData();
		return listEtudeImpactComplete;
	}

}
