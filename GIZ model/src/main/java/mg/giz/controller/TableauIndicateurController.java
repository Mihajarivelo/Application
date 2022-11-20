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

		// # de mois de soudure alimentaire/difficulté économique Type 1
		model.addAttribute("listMoisSoudureType1",
				TableauIndicateurSaisirFactory.getInstances(tableauIndicateurQueryService.getMoisSoudureType1Data()));

		// # de mois de soudure alimentaire/difficulté économique Type 2
		model.addAttribute("listMoisSoudureType2",
				TableauIndicateurSaisirFactory.getInstances(tableauIndicateurQueryService.getMoisSoudureType2Data()));

		// # de mois de soudure alimentaire/difficulté économique Type 3
		model.addAttribute("listMoisSoudureType3",
				TableauIndicateurSaisirFactory.getInstances(tableauIndicateurQueryService.getMoisSoudureType3Data()));

		// # de FR suivis
		model.addAttribute("listFRSuivi",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getFRSuiviData()));

		// # de restitution auprès des FR
		model.addAttribute("listRestitutionFR",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getRestitutionFRData()));

		// # de formateurs FBS formés
		model.addAttribute("listFormateursFBSFormes",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getFormateursFBSFormesData()));

		// # de producteurs sensibilisés
		model.addAttribute("listProducteursSensibilises",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getProducteursSensibilisesData()));

		// # de session de formation FBS effectués
		model.addAttribute("listSessionFormationFBS",
		TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getSessionFormationFBSData()));

		// # de producteurs formés (ayant terminé les 11 modules)
		model.addAttribute("listProducteursFormes",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getProducteursFormesData()));

		// Taux de completion de producteurs formés
		model.addAttribute("listTauxCompletion",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getTauxCompletionData()));

		// # de producteurs bénéficiant de renforcement de capacité post-formation FBS
		model.addAttribute("listBeneficiantPostFormationFBS", TableauIndicateurFactory
				.getInstances(tableauIndicateurQueryService.getBeneficiantPostFormationFBSData()));

		// # d'entrepreneurs identifiés
		model.addAttribute("listEntrepreneursIdentifies",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getEntrepreneursIdentifiesData()));

		// # de personnes ressources opérationnelles
		model.addAttribute("listPersonnesRessourcesOperationnelles", TableauIndicateurFactory
				.getInstances(tableauIndicateurQueryService.getPersonnesRessourcesOperationnellesData()));

		// # de participants aux formations dispensées par les personnes ressources
		model.addAttribute("listParticipantsPersonnesRessources", TableauIndicateurFactory
				.getInstances(tableauIndicateurQueryService.getParticipantsPersonnesRessourcesData()));

		// # de pépinièristes fonctionnels et gérant eux-même leur fonds
		model.addAttribute("listPepinieristesFonctionnels", TableauIndicateurFactory
				.getInstances(tableauIndicateurQueryService.getPepinieristesFonctionnelsData()));

		// # d'ASA formés
		model.addAttribute("listASAFormes",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getASAFormesData()));

		// # d'ASA opérationnels
		model.addAttribute("listASAOperationnels",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getASAOperationnelsData()));

		// Chiffre d'affaire mensuel moyen des ASA
		model.addAttribute("listChiffreAffaireASA",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getChiffreAffaireASAData()));

		// # de bénéficiaires de service de santé animale
		model.addAttribute("listBeneficiairesServiceSanteAnimale", TableauIndicateurFactory
				.getInstances(tableauIndicateurQueryService.getBeneficiairesServiceSanteAnimaleData()));

		// # de cheptels vaccinés
		model.addAttribute("listCheptelsVaccines",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getCheptelsVaccinesData()));

		// # de formateurs en élevages opérationnels
		model.addAttribute("listFormateursElevagesOperationnels", TableauIndicateurFactory
				.getInstances(tableauIndicateurQueryService.getFormateursElevagesOperationnelsData()));

		// # de producteurs formés sur les bonnes pratiques d'élevage
		model.addAttribute("listProducteursFormesBonnesPratiquesElevage", TableauIndicateurFactory
				.getInstances(tableauIndicateurQueryService.getProducteursFormesBonnesPratiquesElevageData()));

		// # de producteurs qui ont adopté au moins une bonnes pratique d'élevage
		// (vaccination + alimentation ou logement ou reproduction)
		model.addAttribute("listProducteursAdopte",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getProducteursAdopteData()));

		// # de fermes de diffusion opérationnelles
		model.addAttribute("listFermesDiffusionOperationnelles", TableauIndicateurFactory
				.getInstances(tableauIndicateurQueryService.getFermesDiffusionOperationnellesData()));

		// # de visiteurs des fermes de diffusion
		model.addAttribute("listVisiteursFermesDiffusion",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getVisiteursFermesDiffusionData()));

		// # de structure de producteurs fonctionnels
		model.addAttribute("listStructureProducteursFonctionnels", TableauIndicateurFactory
				.getInstances(tableauIndicateurQueryService.getStructureProducteursFonctionnelsData()));

		// # de structure de producteurs mettant en œuvre un service ou un projet
		model.addAttribute("listStructureProducteursService", TableauIndicateurFactory
				.getInstances(tableauIndicateurQueryService.getStructureProducteursServiceData()));

		// % de petits producteurs formés qui démontrent des compétences en leadership,
		// négociation et communication
		model.addAttribute("listPetitsProducteursFormes",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getPetitsProducteursFormesData()));

		// # de leader de coopératives coachés
		model.addAttribute("listLeaderCooperativesCoaches", TableauIndicateurFactory
				.getInstances(tableauIndicateurQueryService.getLeaderCooperativesCoachesData()));

		// # de leader de coopératives formés
		model.addAttribute("listLeaderCooperativesFormes",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getLeaderCooperativesFormesData()));

		// # de personnes touchées par les plateformes de dialogue
		model.addAttribute("listPersonnesPlateformesDialogue", TableauIndicateurFactory
				.getInstances(tableauIndicateurQueryService.getPersonnesPlateformesDialogueData()));

		// # et le type de résolutions issues des dialogues communautaires
		model.addAttribute("listResolutionsDialoguesCommunautaires", TableauIndicateurFactory
				.getInstances(tableauIndicateurQueryService.getResolutionsDialoguesCommunautairesData()));

		// # de MFR opérationnels
		model.addAttribute("listMFROperationnels",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getMFROperationnelsData()));

		// Un réseau de MFR opérationnel
		model.addAttribute("listReseauMFROperationnels",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getReseauMFROperationnelsData()));

		// # d'élèves étudiant dans les MFR
		model.addAttribute("listElevesEtudiantMFR",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getElevesEtudiantMFRData()));

		// # de jeunes diplômés sortant des MFR
		model.addAttribute("listJeunesdiplomessortantMFR",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getJeunesdiplomessortantMFRData()));

		// # de jeunes sortants des MFR mettant en œuvre leur projet
		model.addAttribute("listJeunesSortantsProjet",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getJeunesSortantsProjetData()));

		// # d'élèves formés sur FBS à travers les MFR
		model.addAttribute("listElevesformesFBSMFR",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getElevesformesFBSMFRData()));

		// # nombre d'échanges MFR entre Comité des jeunes
		model.addAttribute("listEchangesMFRComiteJeunes",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getEchangesMFRComiteJeunesData()));

		// # d'école bénéficiant des subventions
		model.addAttribute("listEcoleBeneficiantSubventions", TableauIndicateurFactory
				.getInstances(tableauIndicateurQueryService.getEcoleBeneficiantSubventionsData()));

		// % des FRAM qui utilisent effectivement les subventions
		model.addAttribute("listFRAMUtilisentSubventions",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getFRAMUtilisentSubventionsData()));

		// Proportions subventions % au budget des écoles N°1
		model.addAttribute("listProportionsSubventions1", TableauIndicateurSaisirFactory
				.getInstances(tableauIndicateurQueryService.getProportionsSubventions1Data()));

		// Proportions subventions % au budget des écoles N°2
		model.addAttribute("listProportionsSubventions2", TableauIndicateurSaisirFactory
				.getInstances(tableauIndicateurQueryService.getProportionsSubventions2Data()));

		// Proportions subventions % au budget des écoles N°3
		model.addAttribute("listProportionsSubventions3", TableauIndicateurSaisirFactory
				.getInstances(tableauIndicateurQueryService.getProportionsSubventions3Data()));

		// # d'élèves présents dans les écoles aidées
		model.addAttribute("listElevesPresentsEcoles",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getElevesPresentsEcolesData()));

		// # d'enseignants formés à l'éducation environnementale
		model.addAttribute("listEnseignantsFormes",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getEnseignantsFormesData()));

		// # d'enseignants kit mad'ère
		model.addAttribute("listEnseignantsKitMadere",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getEnseignantsKitMadereData()));

		// # d'école concernées
		model.addAttribute("listEcoleConcernees",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getEcoleConcerneesData()));

		// # de participants au concours environnemental
		model.addAttribute("listParticipantsConcours",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getParticipantsConcoursData()));

		// Pourcentage de participant ayant obtenu la moyenne au concours
		// environnemental
		model.addAttribute("listPourcentageParticipant",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getPourcentageParticipantData()));

		// # de producteurs couverts par la mutuelle de santé mahavelona
		model.addAttribute("listMahavelonaM12Adherants",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getMahavelonaM12AdherantsData()));

		// # de villages couverts par Mahavelona
		model.addAttribute("listVillagesCouvertsMahavelona", TableauIndicateurFactory
				.getInstances(tableauIndicateurQueryService.getVillagesCouvertsMahavelonaData()));

		// Prévalence des maladies diarhéiques des membres de Mahavelona
		model.addAttribute("listPrevalenceMaladies",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getPrevalenceMaladiesData()));

		// Taux de sinistralité au niveau des zones d'intervention M7
		model.addAttribute("listTauxSinistraliteM7",
				TableauIndicateurSaisirFactory.getInstances(tableauIndicateurQueryService.getTauxSinistraliteM7Data()));

		// Taux de sinistralité au niveau des zones d'intervention M12
		model.addAttribute("listTauxSinistraliteM12",
				TableauIndicateurSaisirFactory.getInstances(tableauIndicateurQueryService.getTauxSinistraliteM12Data()));

		// Taux de fréquentation des centres de santé pour les enfants des ménages
		// pauvres
		model.addAttribute("listTauxFrequentation1",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getTauxFrequentation1Data()));

		// Taux de fréquentation des structures de santé
		model.addAttribute("listTauxFrequentation2",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getTauxFrequentation2Data()));

		// Taux de satisfaction des membres de Mahavelona
		model.addAttribute("listTauxSatisfaction",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getTauxSatisfactionData()));

		// # de village ayant amélioré l'accès à l'eau potable
		model.addAttribute("listVillageAmeliore",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getVillageAmelioreData()));

		// # de ménages les plus vulnérables bénéficiant de grants
		model.addAttribute("listBeneficiantGrants",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getBeneficiantGrantsData()));

		// Subventions allouées aux ménages les plus vulnérables
		model.addAttribute("listSubventionsMenages",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getSubventionsMenagesData()));

		// # ménage qui rapportent que l'utilisation des grants
		model.addAttribute("listMenageRapportentGrants",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getMenageRapportentGrantsData()));

		// # de VSLA constitués
		model.addAttribute("listVSLAConstitues",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getVSLAConstituesData()));

		// # de personnes ayant accès aux services financiers informels via les VSLA
		model.addAttribute("listPersonnesFinanciersVSLA",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getPersonnesFinanciersVSLAData()));

		// Montant des épargnes investis dans le groupe VSLA
		model.addAttribute("listMontantInvestisGroupeVSLA", TableauIndicateurFactory
				.getInstances(tableauIndicateurQueryService.getMontantInvestisGroupeVSLAData()));

		// # de VSLA fonctionnels
		model.addAttribute("listVSLAFonctionnels",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getVSLAFonctionnelsData()));

		// Mahavelona (lilghtpackage) => M7 Adhérant
		model.addAttribute("listMahavelonaM7Adherant",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getMahavelonaM7AdherantData()));

		// # de jeunes participant au programme d'alphabétisation
		model.addAttribute("listJeunesParticipantAlphabetisation", TableauIndicateurFactory
				.getInstances(tableauIndicateurQueryService.getJeunesParticipantAlphabetisationData()));

		// # de jeunes déscolarisés ayant complèté le programme d'alphabétisation
		model.addAttribute("listJeunesDescolarises",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getJeunesDescolarisesData()));

		// # de jeunes ayant complèté le programme d'alphabétisation
		model.addAttribute("listJeunesAyantComplete",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getJeunesAyantCompleteData()));

		// # de jeunes formés en plan de vie viable (pathway)
		model.addAttribute("listPathway",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getPathwayData()));

		// # de jeunes ayant un plan de vie viable, à préciser par type de plan de vie
		model.addAttribute("listJeunesTypePlanVie",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getJeunesTypePlanVieData()));

		// # de jeunes ayant obtenu des grants
		model.addAttribute("listJeunesAyantObtenuGrants",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getJeunesAyantObtenuGrantsData()));

		// Taux d'abandon scolaire des jeunes
		model.addAttribute("listTauxAbandonScolaire",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getTauxAbandonScolaireData()));

		// # des ménages sensibilisés
		model.addAttribute("listMenagesSensibilises",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getMenagesSensibilisesData()));

		// Taux de diversification alimentaire des ménages pauvres
		model.addAttribute("listTauxDiversificationMenagespauvres", TableauIndicateurFactory
				.getInstances(tableauIndicateurQueryService.getTauxDiversificationMenagespauvresData()));

		// Taux de fréquentation des centres de santé pour les enfants des ménages
		// pauvres
		model.addAttribute("listTauxFrequentationEnfants",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getTauxFrequentationEnfantsData()));

		// Au moins 3 recommandations de santé
		model.addAttribute("listRecommandationsSante",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getRecommandationsSanteData()));

		// # d'atelier du secteur auquel participe le projet
		model.addAttribute("listAtelierSecteur",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getAtelierSecteurData()));

		// # de participation de SAVE THE CHILDREN aux réunions de SVI
		model.addAttribute("listParticipationReunionsSVI",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getParticipationReunionsSVIData()));

		// Taux de connaissance des droits des enfants dans les ménages et communautés
		model.addAttribute("listTauxConnaissance",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getTauxConnaissanceData()));

		// # d'acteur de la filière
		model.addAttribute("listActeurFiliere",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getActeurFiliereData()));

		// Etude d'Impact complète et partagee avec Unilever/Symrise
		model.addAttribute("listEtudeImpactComplete",
				TableauIndicateurFactory.getInstances(tableauIndicateurQueryService.getEtudeImpactCompleteData()));

		// return "giz-indicateur/giz-indicateur.html";
		return "giz-indicateur/indicateurs.html";
	}
}
