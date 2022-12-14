package mg.giz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mg.giz.contrainte.factory.HistoriqueIndicateurFactory;
import mg.giz.contrainte.factory.HistoriqueIndicateurSaisirFactory;
import mg.giz.service.metier.Historique2020QueryService;

@Controller
public class Historique2020Controller {

	@Autowired
	private Historique2020QueryService historique2020QueryService;

	@RequestMapping(value = "/indicateur-2020")
	public String getTableauIndicateurData(Model model) {

		// Revenu moyen de l'exploitation
		model.addAttribute("listRevenuExploitation",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getRevenuExploitationData()));

		// Revenu moyen par type d'exploitation Type 1
		model.addAttribute("listRevenuType1Exploitation", HistoriqueIndicateurSaisirFactory
				.getInstances(historique2020QueryService.getRevenuType1ExploitationData()));

		// Revenu moyen par type d'exploitation Type 2
		model.addAttribute("listRevenuType2Exploitation", HistoriqueIndicateurSaisirFactory
				.getInstances(historique2020QueryService.getRevenuType2ExploitationData()));

		// Revenu moyen par type d'exploitation Type 3
		model.addAttribute("listRevenuType3Exploitation", HistoriqueIndicateurSaisirFactory
				.getInstances(historique2020QueryService.getRevenuType3ExploitationData()));

		// Taux de diversification des revenus Type 1
		model.addAttribute("listTauxDiversificationRevenusType1", HistoriqueIndicateurSaisirFactory
				.getInstances(historique2020QueryService.getTauxDiversificationRevenusType1Data()));

		// Taux de diversification des revenus Type 1 Agricole
		model.addAttribute("listTauxDiversificationRevenusType1Agricole", HistoriqueIndicateurSaisirFactory
				.getInstances(historique2020QueryService.getTauxDiversificationRevenusType1AgricoleData()));

		// Taux de diversification des revenus Type 1 Non Agricole
		model.addAttribute("listTauxDiversificationRevenusType1NonAgricole", HistoriqueIndicateurSaisirFactory
				.getInstances(historique2020QueryService.getTauxDiversificationRevenusType1NonAgricoleData()));

		// Taux de diversification des revenus Type 2
		model.addAttribute("listTauxDiversificationRevenusType2", HistoriqueIndicateurSaisirFactory
				.getInstances(historique2020QueryService.getTauxDiversificationRevenusType2Data()));

		// Taux de diversification des revenus Type 2 Agricole
		model.addAttribute("listTauxDiversificationRevenusType2Agricole", HistoriqueIndicateurSaisirFactory
				.getInstances(historique2020QueryService.getTauxDiversificationRevenusType2AgricoleData()));

		// Taux de diversification des revenus Type 2 Non Agricole
		model.addAttribute("listTauxDiversificationRevenusType2NonAgricole", HistoriqueIndicateurSaisirFactory
				.getInstances(historique2020QueryService.getTauxDiversificationRevenusType2NonAgricoleData()));

		// Taux de diversification des revenus Type 3
		model.addAttribute("listTauxDiversificationRevenusType3", HistoriqueIndicateurSaisirFactory
				.getInstances(historique2020QueryService.getTauxDiversificationRevenusType3Data()));

		// Taux de diversification des revenus Type 3 Agricole
		model.addAttribute("listTauxDiversificationRevenusType3Agricole", HistoriqueIndicateurSaisirFactory
				.getInstances(historique2020QueryService.getTauxDiversificationRevenusType3AgricoleData()));

		// Taux de diversification des revenus Type 3 non agricole
		model.addAttribute("listTauxDiversificationRevenusType3NonAgricole", HistoriqueIndicateurSaisirFactory
				.getInstances(historique2020QueryService.getTauxDiversificationRevenusType3NonAgricoleData()));

		// # de mois de soudure alimentaire/difficult?? ??conomique Type 1
		model.addAttribute("listMoisSoudureType1",
				HistoriqueIndicateurSaisirFactory.getInstances(historique2020QueryService.getMoisSoudureType1Data()));

		// # de mois de soudure alimentaire/difficult?? ??conomique Type 2
		model.addAttribute("listMoisSoudureType2",
				HistoriqueIndicateurSaisirFactory.getInstances(historique2020QueryService.getMoisSoudureType2Data()));

		// # de mois de soudure alimentaire/difficult?? ??conomique Type 3
		model.addAttribute("listMoisSoudureType3",
				HistoriqueIndicateurSaisirFactory.getInstances(historique2020QueryService.getMoisSoudureType3Data()));

		// # de FR suivis
		model.addAttribute("listFRSuivi",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getFRSuiviData()));

		// # de restitution aupr??s des FR
		model.addAttribute("listRestitutionFR",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getRestitutionFRData()));

		// # de formateurs FBS form??s
		model.addAttribute("listFormateursFBSFormes",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getFormateursFBSFormesData()));

		// # de producteurs sensibilis??s
		model.addAttribute("listProducteursSensibilises",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getProducteursSensibilisesData()));

		// # de session de formation FBS effectu??s
		model.addAttribute("listSessionFormationFBS",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getSessionFormationFBSData()));

		// # de producteurs form??s (ayant termin?? les 11 modules)
		model.addAttribute("listProducteursFormes",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getProducteursFormesData()));

		// Taux de completion de producteurs form??s
		model.addAttribute("listTauxCompletion",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getTauxCompletionData()));

		// # de producteurs b??n??ficiant de renforcement de capacit?? post-formation FBS
		model.addAttribute("listBeneficiantPostFormationFBS", HistoriqueIndicateurFactory
				.getInstances(historique2020QueryService.getBeneficiantPostFormationFBSData()));

		// # d'entrepreneurs identifi??s
		model.addAttribute("listEntrepreneursIdentifies",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getEntrepreneursIdentifiesData()));

		// # de personnes ressources op??rationnelles
		model.addAttribute("listPersonnesRessourcesOperationnelles", HistoriqueIndicateurFactory
				.getInstances(historique2020QueryService.getPersonnesRessourcesOperationnellesData()));

		// # de participants aux formations dispens??es par les personnes ressources
		model.addAttribute("listParticipantsPersonnesRessources", HistoriqueIndicateurFactory
				.getInstances(historique2020QueryService.getParticipantsPersonnesRessourcesData()));

		// # de p??pini??ristes fonctionnels et g??rant eux-m??me leur fonds
		model.addAttribute("listPepinieristesFonctionnels", HistoriqueIndicateurFactory
				.getInstances(historique2020QueryService.getPepinieristesFonctionnelsData()));

		// # d'ASA form??s
		model.addAttribute("listASAFormes",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getASAFormesData()));

		// # d'ASA op??rationnels
		model.addAttribute("listASAOperationnels",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getASAOperationnelsData()));

		// Chiffre d'affaire mensuel moyen des ASA
		model.addAttribute("listChiffreAffaireASA",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getChiffreAffaireASAData()));

		// # de b??n??ficiaires de service de sant?? animale
		model.addAttribute("listBeneficiairesServiceSanteAnimale", HistoriqueIndicateurFactory
				.getInstances(historique2020QueryService.getBeneficiairesServiceSanteAnimaleData()));

		// # de cheptels vaccin??s
		model.addAttribute("listCheptelsVaccines",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getCheptelsVaccinesData()));

		// # de formateurs en ??levages op??rationnels
		model.addAttribute("listFormateursElevagesOperationnels", HistoriqueIndicateurFactory
				.getInstances(historique2020QueryService.getFormateursElevagesOperationnelsData()));

		// # de producteurs form??s sur les bonnes pratiques d'??levage
		model.addAttribute("listProducteursFormesBonnesPratiquesElevage", HistoriqueIndicateurFactory
				.getInstances(historique2020QueryService.getProducteursFormesBonnesPratiquesElevageData()));

		// # de producteurs qui ont adopt?? au moins une bonnes pratique d'??levage
		// (vaccination + alimentation ou logement ou reproduction)
		model.addAttribute("listProducteursAdopte",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getProducteursAdopteData()));

		// # de fermes de diffusion op??rationnelles
		model.addAttribute("listFermesDiffusionOperationnelles", HistoriqueIndicateurFactory
				.getInstances(historique2020QueryService.getFermesDiffusionOperationnellesData()));

		// # de visiteurs des fermes de diffusion
		model.addAttribute("listVisiteursFermesDiffusion",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getVisiteursFermesDiffusionData()));

		// # de structure de producteurs fonctionnels
		model.addAttribute("listStructureProducteursFonctionnels", HistoriqueIndicateurFactory
				.getInstances(historique2020QueryService.getStructureProducteursFonctionnelsData()));

		// # de structure de producteurs mettant en ??uvre un service ou un projet
		model.addAttribute("listStructureProducteursService", HistoriqueIndicateurFactory
				.getInstances(historique2020QueryService.getStructureProducteursServiceData()));

		// % de petits producteurs form??s qui d??montrent des comp??tences en leadership,
		// n??gociation et communication
		model.addAttribute("listPetitsProducteursFormes",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getPetitsProducteursFormesData()));

		// # de leader de coop??ratives coach??s
		model.addAttribute("listLeaderCooperativesCoaches", HistoriqueIndicateurFactory
				.getInstances(historique2020QueryService.getLeaderCooperativesCoachesData()));

		// # de leader de coop??ratives form??s
		model.addAttribute("listLeaderCooperativesFormes",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getLeaderCooperativesFormesData()));

		// # de personnes touch??es par les plateformes de dialogue
		model.addAttribute("listPersonnesPlateformesDialogue", HistoriqueIndicateurFactory
				.getInstances(historique2020QueryService.getPersonnesPlateformesDialogueData()));

		// # et le type de r??solutions issues des dialogues communautaires
		model.addAttribute("listResolutionsDialoguesCommunautaires", HistoriqueIndicateurFactory
				.getInstances(historique2020QueryService.getResolutionsDialoguesCommunautairesData()));

		// # de MFR op??rationnels
		model.addAttribute("listMFROperationnels",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getMFROperationnelsData()));

		// Un r??seau de MFR op??rationnel
		model.addAttribute("listReseauMFROperationnels",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getReseauMFROperationnelsData()));

		// # d'??l??ves ??tudiant dans les MFR
		model.addAttribute("listElevesEtudiantMFR",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getElevesEtudiantMFRData()));

		// # de jeunes dipl??m??s sortant des MFR
		model.addAttribute("listJeunesdiplomessortantMFR",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getJeunesdiplomessortantMFRData()));

		// # de jeunes sortants des MFR mettant en ??uvre leur projet
		model.addAttribute("listJeunesSortantsProjet",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getJeunesSortantsProjetData()));

		// # d'??l??ves form??s sur FBS ?? travers les MFR
		model.addAttribute("listElevesformesFBSMFR",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getElevesformesFBSMFRData()));

		// # nombre d'??changes MFR entre Comit?? des jeunes
		model.addAttribute("listEchangesMFRComiteJeunes",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getEchangesMFRComiteJeunesData()));

		// # d'??cole b??n??ficiant des subventions
		model.addAttribute("listEcoleBeneficiantSubventions", HistoriqueIndicateurFactory
				.getInstances(historique2020QueryService.getEcoleBeneficiantSubventionsData()));

		// % des FRAM qui utilisent effectivement les subventions
		model.addAttribute("listFRAMUtilisentSubventions",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getFRAMUtilisentSubventionsData()));

		// Proportions subventions % au budget des ??coles N??1
		model.addAttribute("listProportionsSubventions1", HistoriqueIndicateurSaisirFactory
				.getInstances(historique2020QueryService.getProportionsSubventions1Data()));

		// Proportions subventions % au budget des ??coles N??2
		model.addAttribute("listProportionsSubventions2", HistoriqueIndicateurSaisirFactory
				.getInstances(historique2020QueryService.getProportionsSubventions2Data()));

		// Proportions subventions % au budget des ??coles N??3
		model.addAttribute("listProportionsSubventions3", HistoriqueIndicateurSaisirFactory
				.getInstances(historique2020QueryService.getProportionsSubventions3Data()));

		// # d'??l??ves pr??sents dans les ??coles aid??es
		model.addAttribute("listElevesPresentsEcoles",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getElevesPresentsEcolesData()));

		// # d'enseignants form??s ?? l'??ducation environnementale
		model.addAttribute("listEnseignantsFormes",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getEnseignantsFormesData()));

		// # d'enseignants kit mad'??re
		model.addAttribute("listEnseignantsKitMadere",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getEnseignantsKitMadereData()));

		// # d'??cole concern??es
		model.addAttribute("listEcoleConcernees",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getEcoleConcerneesData()));

		// # de participants au concours environnemental
		model.addAttribute("listParticipantsConcours",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getParticipantsConcoursData()));

		// Pourcentage de participant ayant obtenu la moyenne au concours
		// environnemental
		model.addAttribute("listPourcentageParticipant",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getPourcentageParticipantData()));

		// # de producteurs couverts par la mutuelle de sant?? mahavelona
		model.addAttribute("listMahavelonaM12Adherants",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getMahavelonaM12AdherantsData()));

		// # de villages couverts par Mahavelona
		model.addAttribute("listVillagesCouvertsMahavelona", HistoriqueIndicateurFactory
				.getInstances(historique2020QueryService.getVillagesCouvertsMahavelonaData()));

		// Pr??valence des maladies diarh??iques des membres de Mahavelona
		model.addAttribute("listPrevalenceMaladies",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getPrevalenceMaladiesData()));

		// Taux de sinistralit?? au niveau des zones d'intervention M7
		model.addAttribute("listTauxSinistraliteM7",
				HistoriqueIndicateurSaisirFactory.getInstances(historique2020QueryService.getTauxSinistraliteM7Data()));

		// Taux de sinistralit?? au niveau des zones d'intervention M12
		model.addAttribute("listTauxSinistraliteM12", HistoriqueIndicateurSaisirFactory
				.getInstances(historique2020QueryService.getTauxSinistraliteM12Data()));

		// Taux de fr??quentation des centres de sant?? pour les enfants des m??nages
		// pauvres
		model.addAttribute("listTauxFrequentation1",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getTauxFrequentation1Data()));

		// Taux de fr??quentation des structures de sant??
		model.addAttribute("listTauxFrequentation2",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getTauxFrequentation2Data()));

		// Taux de satisfaction des membres de Mahavelona
		model.addAttribute("listTauxSatisfaction",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getTauxSatisfactionData()));

		// # de village ayant am??lior?? l'acc??s ?? l'eau potable
		model.addAttribute("listVillageAmeliore",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getVillageAmelioreData()));

		// # de m??nages les plus vuln??rables b??n??ficiant de grants
		model.addAttribute("listBeneficiantGrants",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getBeneficiantGrantsData()));

		// Subventions allou??es aux m??nages les plus vuln??rables
		model.addAttribute("listSubventionsMenages",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getSubventionsMenagesData()));

		// # m??nage qui rapportent que l'utilisation des grants
		model.addAttribute("listMenageRapportentGrants",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getMenageRapportentGrantsData()));

		// # de VSLA constitu??s
		model.addAttribute("listVSLAConstitues",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getVSLAConstituesData()));

		// # de personnes ayant acc??s aux services financiers informels via les VSLA
		model.addAttribute("listPersonnesFinanciersVSLA",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getPersonnesFinanciersVSLAData()));

		// Montant des ??pargnes investis dans le groupe VSLA
		model.addAttribute("listMontantInvestisGroupeVSLA", HistoriqueIndicateurFactory
				.getInstances(historique2020QueryService.getMontantInvestisGroupeVSLAData()));

		// # de VSLA fonctionnels
		model.addAttribute("listVSLAFonctionnels",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getVSLAFonctionnelsData()));

		// Mahavelona (lilghtpackage) => M7 Adh??rant
		model.addAttribute("listMahavelonaM7Adherant",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getMahavelonaM7AdherantData()));

		// # de jeunes participant au programme d'alphab??tisation
		model.addAttribute("listJeunesParticipantAlphabetisation", HistoriqueIndicateurFactory
				.getInstances(historique2020QueryService.getJeunesParticipantAlphabetisationData()));

		// # de jeunes d??scolaris??s ayant compl??t?? le programme d'alphab??tisation
		model.addAttribute("listJeunesDescolarises",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getJeunesDescolarisesData()));

		// # de jeunes ayant compl??t?? le programme d'alphab??tisation
		model.addAttribute("listJeunesAyantComplete",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getJeunesAyantCompleteData()));

		// # de jeunes form??s en plan de vie viable (pathway)
		model.addAttribute("listPathway",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getPathwayData()));

		// # de jeunes ayant un plan de vie viable, ?? pr??ciser par type de plan de vie
		model.addAttribute("listJeunesTypePlanVie",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getJeunesTypePlanVieData()));

		// # de jeunes ayant obtenu des grants
		model.addAttribute("listJeunesAyantObtenuGrants",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getJeunesAyantObtenuGrantsData()));

		// Taux d'abandon scolaire des jeunes
		model.addAttribute("listTauxAbandonScolaire",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getTauxAbandonScolaireData()));

		// # des m??nages sensibilis??s
		model.addAttribute("listMenagesSensibilises",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getMenagesSensibilisesData()));

		// Taux de diversification alimentaire des m??nages pauvres
		model.addAttribute("listTauxDiversificationMenagespauvres", HistoriqueIndicateurFactory
				.getInstances(historique2020QueryService.getTauxDiversificationMenagespauvresData()));

		// Taux de fr??quentation des centres de sant?? pour les enfants des m??nages
		// pauvres
		model.addAttribute("listTauxFrequentationEnfants",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getTauxFrequentationEnfantsData()));

		// Au moins 3 recommandations de sant??
		model.addAttribute("listRecommandationsSante",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getRecommandationsSanteData()));

		// # d'atelier du secteur auquel participe le projet
		model.addAttribute("listAtelierSecteur",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getAtelierSecteurData()));

		// # de participation de SAVE THE CHILDREN aux r??unions de SVI
		model.addAttribute("listParticipationReunionsSVI",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getParticipationReunionsSVIData()));

		// Taux de connaissance des droits des enfants dans les m??nages et communaut??s
		model.addAttribute("listTauxConnaissance",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getTauxConnaissanceData()));

		// # d'acteur de la fili??re
		model.addAttribute("listActeurFiliere",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getActeurFiliereData()));

		// Etude d'Impact compl??te et partagee avec Unilever/Symrise
		model.addAttribute("listEtudeImpactComplete",
				HistoriqueIndicateurFactory.getInstances(historique2020QueryService.getEtudeImpactCompleteData()));

		return "giz-indicateur/indicateurs2020.html";
	}
}
