package mg.giz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mg.giz.contrainte.factory.TableauIndicateurFactory;
import mg.giz.contrainte.factory.TableauIndicateurSaisirFactory;
import mg.giz.service.metier.TableauIndicateurQueryService;

@Controller
public class TableauIndicateurController {

	@Autowired
	private TableauIndicateurQueryService tableauIndicateurQueryService;

	@RequestMapping(value = "/tableau-indicateur")
	public String getTableauIndicateurData(Model model) {

		// Revenu moyen de l'exploitation
		model.addAttribute("listRevenuExploitation",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getRevenuExploitationData()));

		// Revenu moyen par type d'exploitation Type 1
		model.addAttribute("listRevenuType1Exploitation", TableauIndicateurSaisirFactory
				.getInstances(tableauIndicateurQueryService.getRevenuType1ExploitationData()));

		// Revenu moyen par type d'exploitation Type 2
		model.addAttribute("listRevenuType2Exploitation", TableauIndicateurSaisirFactory
				.getInstances(tableauIndicateurQueryService.getRevenuType2ExploitationData()));

		// Revenu moyen par type d'exploitation Type 3
		model.addAttribute("listRevenuType3Exploitation", TableauIndicateurSaisirFactory
				.getInstances(tableauIndicateurQueryService.getRevenuType3ExploitationData()));

		// Taux de diversification des revenus Type 1
		model.addAttribute("listTauxDiversificationRevenusType1", TableauIndicateurSaisirFactory
				.getInstances(tableauIndicateurQueryService.getTauxDiversificationRevenusType1Data()));

		// Taux de diversification des revenus Type 1 Agricole
		model.addAttribute("listTauxDiversificationRevenusType1Agricole", TableauIndicateurSaisirFactory
				.getInstances(tableauIndicateurQueryService.getTauxDiversificationRevenusType1AgricoleData()));

		// Taux de diversification des revenus Type 1 Non Agricole
		model.addAttribute("listTauxDiversificationRevenusType1NonAgricole", TableauIndicateurSaisirFactory
				.getInstances(tableauIndicateurQueryService.getTauxDiversificationRevenusType1NonAgricoleData()));

		// Taux de diversification des revenus Type 2
		model.addAttribute("listTauxDiversificationRevenusType2", TableauIndicateurSaisirFactory
				.getInstances(tableauIndicateurQueryService.getTauxDiversificationRevenusType2Data()));

		// Taux de diversification des revenus Type 2 Agricole
		model.addAttribute("listTauxDiversificationRevenusType2Agricole", TableauIndicateurSaisirFactory
				.getInstances(tableauIndicateurQueryService.getTauxDiversificationRevenusType2AgricoleData()));

		// Taux de diversification des revenus Type 2 Non Agricole
		model.addAttribute("listTauxDiversificationRevenusType2NonAgricole", TableauIndicateurSaisirFactory
				.getInstances(tableauIndicateurQueryService.getTauxDiversificationRevenusType2NonAgricoleData()));

		// Taux de diversification des revenus Type 3
		model.addAttribute("listTauxDiversificationRevenusType3", TableauIndicateurSaisirFactory
				.getInstances(tableauIndicateurQueryService.getTauxDiversificationRevenusType3Data()));

		// Taux de diversification des revenus Type 3 Agricole
		model.addAttribute("listTauxDiversificationRevenusType3Agricole", TableauIndicateurSaisirFactory
				.getInstances(tableauIndicateurQueryService.getTauxDiversificationRevenusType3AgricoleData()));

		// Taux de diversification des revenus Type 3 non agricole
		model.addAttribute("listTauxDiversificationRevenusType3NonAgricole", TableauIndicateurSaisirFactory
				.getInstances(tableauIndicateurQueryService.getTauxDiversificationRevenusType3NonAgricoleData()));

		// # de mois de soudure alimentaire/difficult?? ??conomique Type 1
		model.addAttribute("listMoisSoudureType1",
				TableauIndicateurSaisirFactory.getInstances(tableauIndicateurQueryService.getMoisSoudureType1Data()));

		// # de mois de soudure alimentaire/difficult?? ??conomique Type 2
		model.addAttribute("listMoisSoudureType2",
				TableauIndicateurSaisirFactory.getInstances(tableauIndicateurQueryService.getMoisSoudureType2Data()));

		// # de mois de soudure alimentaire/difficult?? ??conomique Type 3
		model.addAttribute("listMoisSoudureType3",
				TableauIndicateurSaisirFactory.getInstances(tableauIndicateurQueryService.getMoisSoudureType3Data()));

		// # de FR suivis
		model.addAttribute("listFRSuivi",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getFRSuiviData()));

		// # de restitution aupr??s des FR
		model.addAttribute("listRestitutionFR",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getRestitutionFRData()));

		// # de formateurs FBS form??s
		model.addAttribute("listFormateursFBSFormes",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getFormateursFBSFormesData()));

		// # de producteurs sensibilis??s
		model.addAttribute("listProducteursSensibilises",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getProducteursSensibilisesData()));

		// # de session de formation FBS effectu??s
		model.addAttribute("listSessionFormationFBS",
		TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getSessionFormationFBSData()));

		// # de producteurs form??s (ayant termin?? les 11 modules)
		model.addAttribute("listProducteursFormes",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getProducteursFormesData()));

		// Taux de completion de producteurs form??s
		model.addAttribute("listTauxCompletion",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getTauxCompletionData()));

		// # de producteurs b??n??ficiant de renforcement de capacit?? post-formation FBS
		model.addAttribute("listBeneficiantPostFormationFBS", TableauIndicateurFactory
				.getInstances(tableauIndicateurQueryService.getBeneficiantPostFormationFBSData()));

		// # d'entrepreneurs identifi??s
		model.addAttribute("listEntrepreneursIdentifies",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getEntrepreneursIdentifiesData()));

		// # de personnes ressources op??rationnelles
		model.addAttribute("listPersonnesRessourcesOperationnelles", TableauIndicateurFactory
				.getInstances(tableauIndicateurQueryService.getPersonnesRessourcesOperationnellesData()));

		// # de participants aux formations dispens??es par les personnes ressources
		model.addAttribute("listParticipantsPersonnesRessources", TableauIndicateurFactory
				.getInstances(tableauIndicateurQueryService.getParticipantsPersonnesRessourcesData()));

		// # de p??pini??ristes fonctionnels et g??rant eux-m??me leur fonds
		model.addAttribute("listPepinieristesFonctionnels", TableauIndicateurFactory
				.getInstances(tableauIndicateurQueryService.getPepinieristesFonctionnelsData()));

		// # d'ASA form??s
		model.addAttribute("listASAFormes",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getASAFormesData()));

		// # d'ASA op??rationnels
		model.addAttribute("listASAOperationnels",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getASAOperationnelsData()));

		// Chiffre d'affaire mensuel moyen des ASA
		model.addAttribute("listChiffreAffaireASA",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getChiffreAffaireASAData()));

		// # de b??n??ficiaires de service de sant?? animale
		model.addAttribute("listBeneficiairesServiceSanteAnimale", TableauIndicateurFactory
				.getInstances(tableauIndicateurQueryService.getBeneficiairesServiceSanteAnimaleData()));

		// # de cheptels vaccin??s
		model.addAttribute("listCheptelsVaccines",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getCheptelsVaccinesData()));

		// # de formateurs en ??levages op??rationnels
		model.addAttribute("listFormateursElevagesOperationnels", TableauIndicateurFactory
				.getInstances(tableauIndicateurQueryService.getFormateursElevagesOperationnelsData()));

		// # de producteurs form??s sur les bonnes pratiques d'??levage
		model.addAttribute("listProducteursFormesBonnesPratiquesElevage", TableauIndicateurFactory
				.getInstances(tableauIndicateurQueryService.getProducteursFormesBonnesPratiquesElevageData()));

		// # de producteurs qui ont adopt?? au moins une bonnes pratique d'??levage
		// (vaccination + alimentation ou logement ou reproduction)
		model.addAttribute("listProducteursAdopte",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getProducteursAdopteData()));

		// # de fermes de diffusion op??rationnelles
		model.addAttribute("listFermesDiffusionOperationnelles", TableauIndicateurFactory
				.getInstances(tableauIndicateurQueryService.getFermesDiffusionOperationnellesData()));

		// # de visiteurs des fermes de diffusion
		model.addAttribute("listVisiteursFermesDiffusion",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getVisiteursFermesDiffusionData()));

		// # de structure de producteurs fonctionnels
		model.addAttribute("listStructureProducteursFonctionnels", TableauIndicateurFactory
				.getInstances(tableauIndicateurQueryService.getStructureProducteursFonctionnelsData()));

		// # de structure de producteurs mettant en ??uvre un service ou un projet
		model.addAttribute("listStructureProducteursService", TableauIndicateurFactory
				.getInstances(tableauIndicateurQueryService.getStructureProducteursServiceData()));

		// % de petits producteurs form??s qui d??montrent des comp??tences en leadership,
		// n??gociation et communication
		model.addAttribute("listPetitsProducteursFormes",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getPetitsProducteursFormesData()));

		// # de leader de coop??ratives coach??s
		model.addAttribute("listLeaderCooperativesCoaches", TableauIndicateurFactory
				.getInstances(tableauIndicateurQueryService.getLeaderCooperativesCoachesData()));

		// # de leader de coop??ratives form??s
		model.addAttribute("listLeaderCooperativesFormes",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getLeaderCooperativesFormesData()));

		// # de personnes touch??es par les plateformes de dialogue
		model.addAttribute("listPersonnesPlateformesDialogue", TableauIndicateurFactory
				.getInstances(tableauIndicateurQueryService.getPersonnesPlateformesDialogueData()));

		// # et le type de r??solutions issues des dialogues communautaires
		model.addAttribute("listResolutionsDialoguesCommunautaires", TableauIndicateurFactory
				.getInstances(tableauIndicateurQueryService.getResolutionsDialoguesCommunautairesData()));

		// # de MFR op??rationnels
		model.addAttribute("listMFROperationnels",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getMFROperationnelsData()));

		// Un r??seau de MFR op??rationnel
		model.addAttribute("listReseauMFROperationnels",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getReseauMFROperationnelsData()));

		// # d'??l??ves ??tudiant dans les MFR
		model.addAttribute("listElevesEtudiantMFR",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getElevesEtudiantMFRData()));

		// # de jeunes dipl??m??s sortant des MFR
		model.addAttribute("listJeunesdiplomessortantMFR",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getJeunesdiplomessortantMFRData()));

		// # de jeunes sortants des MFR mettant en ??uvre leur projet
		model.addAttribute("listJeunesSortantsProjet",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getJeunesSortantsProjetData()));

		// # d'??l??ves form??s sur FBS ?? travers les MFR
		model.addAttribute("listElevesformesFBSMFR",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getElevesformesFBSMFRData()));

		// # nombre d'??changes MFR entre Comit?? des jeunes
		model.addAttribute("listEchangesMFRComiteJeunes",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getEchangesMFRComiteJeunesData()));

		// # d'??cole b??n??ficiant des subventions
		model.addAttribute("listEcoleBeneficiantSubventions", TableauIndicateurFactory
				.getInstances(tableauIndicateurQueryService.getEcoleBeneficiantSubventionsData()));

		// % des FRAM qui utilisent effectivement les subventions
		model.addAttribute("listFRAMUtilisentSubventions",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getFRAMUtilisentSubventionsData()));

		// Proportions subventions % au budget des ??coles N??1
		model.addAttribute("listProportionsSubventions1", TableauIndicateurSaisirFactory
				.getInstances(tableauIndicateurQueryService.getProportionsSubventions1Data()));

		// Proportions subventions % au budget des ??coles N??2
		model.addAttribute("listProportionsSubventions2", TableauIndicateurSaisirFactory
				.getInstances(tableauIndicateurQueryService.getProportionsSubventions2Data()));

		// Proportions subventions % au budget des ??coles N??3
		model.addAttribute("listProportionsSubventions3", TableauIndicateurSaisirFactory
				.getInstances(tableauIndicateurQueryService.getProportionsSubventions3Data()));

		// # d'??l??ves pr??sents dans les ??coles aid??es
		model.addAttribute("listElevesPresentsEcoles",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getElevesPresentsEcolesData()));

		// # d'enseignants form??s ?? l'??ducation environnementale
		model.addAttribute("listEnseignantsFormes",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getEnseignantsFormesData()));

		// # d'enseignants kit mad'??re
		model.addAttribute("listEnseignantsKitMadere",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getEnseignantsKitMadereData()));

		// # d'??cole concern??es
		model.addAttribute("listEcoleConcernees",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getEcoleConcerneesData()));

		// # de participants au concours environnemental
		model.addAttribute("listParticipantsConcours",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getParticipantsConcoursData()));

		// Pourcentage de participant ayant obtenu la moyenne au concours
		// environnemental
		model.addAttribute("listPourcentageParticipant",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getPourcentageParticipantData()));

		// # de producteurs couverts par la mutuelle de sant?? mahavelona
		model.addAttribute("listMahavelonaM12Adherants",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getMahavelonaM12AdherantsData()));

		// # de villages couverts par Mahavelona
		model.addAttribute("listVillagesCouvertsMahavelona", TableauIndicateurFactory
				.getInstances(tableauIndicateurQueryService.getVillagesCouvertsMahavelonaData()));

		// Pr??valence des maladies diarh??iques des membres de Mahavelona
		model.addAttribute("listPrevalenceMaladies",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getPrevalenceMaladiesData()));

		// Taux de sinistralit?? au niveau des zones d'intervention M7
		model.addAttribute("listTauxSinistraliteM7",
				TableauIndicateurSaisirFactory.getInstances(tableauIndicateurQueryService.getTauxSinistraliteM7Data()));

		// Taux de sinistralit?? au niveau des zones d'intervention M12
		model.addAttribute("listTauxSinistraliteM12",
				TableauIndicateurSaisirFactory.getInstances(tableauIndicateurQueryService.getTauxSinistraliteM12Data()));

		// Taux de fr??quentation des centres de sant?? pour les enfants des m??nages
		// pauvres
		model.addAttribute("listTauxFrequentation1",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getTauxFrequentation1Data()));

		// Taux de fr??quentation des structures de sant??
		model.addAttribute("listTauxFrequentation2",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getTauxFrequentation2Data()));

		// Taux de satisfaction des membres de Mahavelona
		model.addAttribute("listTauxSatisfaction",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getTauxSatisfactionData()));

		// # de village ayant am??lior?? l'acc??s ?? l'eau potable
		model.addAttribute("listVillageAmeliore",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getVillageAmelioreData()));

		// # de m??nages les plus vuln??rables b??n??ficiant de grants
		model.addAttribute("listBeneficiantGrants",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getBeneficiantGrantsData()));

		// Subventions allou??es aux m??nages les plus vuln??rables
		model.addAttribute("listSubventionsMenages",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getSubventionsMenagesData()));

		// # m??nage qui rapportent que l'utilisation des grants
		model.addAttribute("listMenageRapportentGrants",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getMenageRapportentGrantsData()));

		// # de VSLA constitu??s
		model.addAttribute("listVSLAConstitues",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getVSLAConstituesData()));

		// # de personnes ayant acc??s aux services financiers informels via les VSLA
		model.addAttribute("listPersonnesFinanciersVSLA",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getPersonnesFinanciersVSLAData()));

		// Montant des ??pargnes investis dans le groupe VSLA
		model.addAttribute("listMontantInvestisGroupeVSLA", TableauIndicateurFactory
				.getInstances(tableauIndicateurQueryService.getMontantInvestisGroupeVSLAData()));

		// # de VSLA fonctionnels
		model.addAttribute("listVSLAFonctionnels",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getVSLAFonctionnelsData()));

		// Mahavelona (lilghtpackage) => M7 Adh??rant
		model.addAttribute("listMahavelonaM7Adherant",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getMahavelonaM7AdherantData()));

		// # de jeunes participant au programme d'alphab??tisation
		model.addAttribute("listJeunesParticipantAlphabetisation", TableauIndicateurFactory
				.getInstances(tableauIndicateurQueryService.getJeunesParticipantAlphabetisationData()));

		// # de jeunes d??scolaris??s ayant compl??t?? le programme d'alphab??tisation
		model.addAttribute("listJeunesDescolarises",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getJeunesDescolarisesData()));

		// # de jeunes ayant compl??t?? le programme d'alphab??tisation
		model.addAttribute("listJeunesAyantComplete",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getJeunesAyantCompleteData()));

		// # de jeunes form??s en plan de vie viable (pathway)
		model.addAttribute("listPathway",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getPathwayData()));

		// # de jeunes ayant un plan de vie viable, ?? pr??ciser par type de plan de vie
		model.addAttribute("listJeunesTypePlanVie",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getJeunesTypePlanVieData()));

		// # de jeunes ayant obtenu des grants
		model.addAttribute("listJeunesAyantObtenuGrants",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getJeunesAyantObtenuGrantsData()));

		// Taux d'abandon scolaire des jeunes
		model.addAttribute("listTauxAbandonScolaire",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getTauxAbandonScolaireData()));

		// # des m??nages sensibilis??s
		model.addAttribute("listMenagesSensibilises",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getMenagesSensibilisesData()));

		// Taux de diversification alimentaire des m??nages pauvres
		model.addAttribute("listTauxDiversificationMenagespauvres", TableauIndicateurFactory
				.getInstances(tableauIndicateurQueryService.getTauxDiversificationMenagespauvresData()));

		// Taux de fr??quentation des centres de sant?? pour les enfants des m??nages
		// pauvres
		model.addAttribute("listTauxFrequentationEnfants",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getTauxFrequentationEnfantsData()));

		// Au moins 3 recommandations de sant??
		model.addAttribute("listRecommandationsSante",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getRecommandationsSanteData()));

		// # d'atelier du secteur auquel participe le projet
		model.addAttribute("listAtelierSecteur",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getAtelierSecteurData()));

		// # de participation de SAVE THE CHILDREN aux r??unions de SVI
		model.addAttribute("listParticipationReunionsSVI",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getParticipationReunionsSVIData()));

		// Taux de connaissance des droits des enfants dans les m??nages et communaut??s
		model.addAttribute("listTauxConnaissance",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getTauxConnaissanceData()));

		// # d'acteur de la fili??re
		model.addAttribute("listActeurFiliere",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getActeurFiliereData()));

		// Etude d'Impact compl??te et partagee avec Unilever/Symrise
		model.addAttribute("listEtudeImpactComplete",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getEtudeImpactCompleteData()));

		// return "giz-indicateur/giz-indicateur.html";
		return "giz-indicateur/indicateurs.html";
	}
}
