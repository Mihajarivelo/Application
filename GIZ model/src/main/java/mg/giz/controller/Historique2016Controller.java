package mg.giz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mg.giz.contrainte.factory.HistoriqueIndicateurFactory;
import mg.giz.contrainte.factory.HistoriqueIndicateurSaisirFactory;
import mg.giz.service.metier.Historique2016QueryService;

@Controller
public class Historique2016Controller {

	@Autowired
	private Historique2016QueryService historique2016QueryService;

	@RequestMapping(value = "/indicateur-2016")
	public String getTableauIndicateurData(Model model) {

		// Revenu moyen de l'exploitation
		model.addAttribute("listRevenuExploitation",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getRevenuExploitationData()));

		// Revenu moyen par type d'exploitation Type 1
		model.addAttribute("listRevenuType1Exploitation", HistoriqueIndicateurSaisirFactory
				.getInstances(historique2016QueryService.getRevenuType1ExploitationData()));

		// Revenu moyen par type d'exploitation Type 2
		model.addAttribute("listRevenuType2Exploitation", HistoriqueIndicateurSaisirFactory
				.getInstances(historique2016QueryService.getRevenuType2ExploitationData()));

		// Revenu moyen par type d'exploitation Type 3
		model.addAttribute("listRevenuType3Exploitation", HistoriqueIndicateurSaisirFactory
				.getInstances(historique2016QueryService.getRevenuType3ExploitationData()));

		// Taux de diversification des revenus Type 1
		model.addAttribute("listTauxDiversificationRevenusType1", HistoriqueIndicateurSaisirFactory
				.getInstances(historique2016QueryService.getTauxDiversificationRevenusType1Data()));

		// Taux de diversification des revenus Type 1 Agricole
		model.addAttribute("listTauxDiversificationRevenusType1Agricole", HistoriqueIndicateurSaisirFactory
				.getInstances(historique2016QueryService.getTauxDiversificationRevenusType1AgricoleData()));

		// Taux de diversification des revenus Type 1 Non Agricole
		model.addAttribute("listTauxDiversificationRevenusType1NonAgricole", HistoriqueIndicateurSaisirFactory
				.getInstances(historique2016QueryService.getTauxDiversificationRevenusType1NonAgricoleData()));

		// Taux de diversification des revenus Type 2
		model.addAttribute("listTauxDiversificationRevenusType2", HistoriqueIndicateurSaisirFactory
				.getInstances(historique2016QueryService.getTauxDiversificationRevenusType2Data()));

		// Taux de diversification des revenus Type 2 Agricole
		model.addAttribute("listTauxDiversificationRevenusType2Agricole", HistoriqueIndicateurSaisirFactory
				.getInstances(historique2016QueryService.getTauxDiversificationRevenusType2AgricoleData()));

		// Taux de diversification des revenus Type 2 Non Agricole
		model.addAttribute("listTauxDiversificationRevenusType2NonAgricole", HistoriqueIndicateurSaisirFactory
				.getInstances(historique2016QueryService.getTauxDiversificationRevenusType2NonAgricoleData()));

		// Taux de diversification des revenus Type 3
		model.addAttribute("listTauxDiversificationRevenusType3", HistoriqueIndicateurSaisirFactory
				.getInstances(historique2016QueryService.getTauxDiversificationRevenusType3Data()));

		// Taux de diversification des revenus Type 3 Agricole
		model.addAttribute("listTauxDiversificationRevenusType3Agricole", HistoriqueIndicateurSaisirFactory
				.getInstances(historique2016QueryService.getTauxDiversificationRevenusType3AgricoleData()));

		// Taux de diversification des revenus Type 3 non agricole
		model.addAttribute("listTauxDiversificationRevenusType3NonAgricole", HistoriqueIndicateurSaisirFactory
				.getInstances(historique2016QueryService.getTauxDiversificationRevenusType3NonAgricoleData()));

		// # de mois de soudure alimentaire/difficulté économique Type 1
		model.addAttribute("listMoisSoudureType1",
				HistoriqueIndicateurSaisirFactory.getInstances(historique2016QueryService.getMoisSoudureType1Data()));

		// # de mois de soudure alimentaire/difficulté économique Type 2
		model.addAttribute("listMoisSoudureType2",
				HistoriqueIndicateurSaisirFactory.getInstances(historique2016QueryService.getMoisSoudureType2Data()));

		// # de mois de soudure alimentaire/difficulté économique Type 3
		model.addAttribute("listMoisSoudureType3",
				HistoriqueIndicateurSaisirFactory.getInstances(historique2016QueryService.getMoisSoudureType3Data()));

		// # de FR suivis
		model.addAttribute("listFRSuivi",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getFRSuiviData()));

		// # de restitution auprès des FR
		model.addAttribute("listRestitutionFR",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getRestitutionFRData()));

		// # de formateurs FBS formés
		model.addAttribute("listFormateursFBSFormes",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getFormateursFBSFormesData()));

		// # de producteurs sensibilisés
		model.addAttribute("listProducteursSensibilises",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getProducteursSensibilisesData()));

		// # de session de formation FBS effectués
		model.addAttribute("listSessionFormationFBS",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getSessionFormationFBSData()));

		// # de producteurs formés (ayant terminé les 11 modules)
		model.addAttribute("listProducteursFormes",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getProducteursFormesData()));

		// Taux de completion de producteurs formés
		model.addAttribute("listTauxCompletion",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getTauxCompletionData()));

		// # de producteurs bénéficiant de renforcement de capacité post-formation FBS
		model.addAttribute("listBeneficiantPostFormationFBS", HistoriqueIndicateurFactory
				.getInstances(historique2016QueryService.getBeneficiantPostFormationFBSData()));

		// # d'entrepreneurs identifiés
		model.addAttribute("listEntrepreneursIdentifies",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getEntrepreneursIdentifiesData()));

		// # de personnes ressources opérationnelles
		model.addAttribute("listPersonnesRessourcesOperationnelles", HistoriqueIndicateurFactory
				.getInstances(historique2016QueryService.getPersonnesRessourcesOperationnellesData()));

		// # de participants aux formations dispensées par les personnes ressources
		model.addAttribute("listParticipantsPersonnesRessources", HistoriqueIndicateurFactory
				.getInstances(historique2016QueryService.getParticipantsPersonnesRessourcesData()));

		// # de pépinièristes fonctionnels et gérant eux-même leur fonds
		model.addAttribute("listPepinieristesFonctionnels", HistoriqueIndicateurFactory
				.getInstances(historique2016QueryService.getPepinieristesFonctionnelsData()));

		// # d'ASA formés
		model.addAttribute("listASAFormes",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getASAFormesData()));

		// # d'ASA opérationnels
		model.addAttribute("listASAOperationnels",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getASAOperationnelsData()));

		// Chiffre d'affaire mensuel moyen des ASA
		model.addAttribute("listChiffreAffaireASA",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getChiffreAffaireASAData()));

		// # de bénéficiaires de service de santé animale
		model.addAttribute("listBeneficiairesServiceSanteAnimale", HistoriqueIndicateurFactory
				.getInstances(historique2016QueryService.getBeneficiairesServiceSanteAnimaleData()));

		// # de cheptels vaccinés
		model.addAttribute("listCheptelsVaccines",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getCheptelsVaccinesData()));

		// # de formateurs en élevages opérationnels
		model.addAttribute("listFormateursElevagesOperationnels", HistoriqueIndicateurFactory
				.getInstances(historique2016QueryService.getFormateursElevagesOperationnelsData()));

		// # de producteurs formés sur les bonnes pratiques d'élevage
		model.addAttribute("listProducteursFormesBonnesPratiquesElevage", HistoriqueIndicateurFactory
				.getInstances(historique2016QueryService.getProducteursFormesBonnesPratiquesElevageData()));

		// # de producteurs qui ont adopté au moins une bonnes pratique d'élevage
		// (vaccination + alimentation ou logement ou reproduction)
		model.addAttribute("listProducteursAdopte",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getProducteursAdopteData()));

		// # de fermes de diffusion opérationnelles
		model.addAttribute("listFermesDiffusionOperationnelles", HistoriqueIndicateurFactory
				.getInstances(historique2016QueryService.getFermesDiffusionOperationnellesData()));

		// # de visiteurs des fermes de diffusion
		model.addAttribute("listVisiteursFermesDiffusion",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getVisiteursFermesDiffusionData()));

		// # de structure de producteurs fonctionnels
		model.addAttribute("listStructureProducteursFonctionnels", HistoriqueIndicateurFactory
				.getInstances(historique2016QueryService.getStructureProducteursFonctionnelsData()));

		// # de structure de producteurs mettant en œuvre un service ou un projet
		model.addAttribute("listStructureProducteursService", HistoriqueIndicateurFactory
				.getInstances(historique2016QueryService.getStructureProducteursServiceData()));

		// % de petits producteurs formés qui démontrent des compétences en leadership,
		// négociation et communication
		model.addAttribute("listPetitsProducteursFormes",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getPetitsProducteursFormesData()));

		// # de leader de coopératives coachés
		model.addAttribute("listLeaderCooperativesCoaches", HistoriqueIndicateurFactory
				.getInstances(historique2016QueryService.getLeaderCooperativesCoachesData()));

		// # de leader de coopératives formés
		model.addAttribute("listLeaderCooperativesFormes",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getLeaderCooperativesFormesData()));

		// # de personnes touchées par les plateformes de dialogue
		model.addAttribute("listPersonnesPlateformesDialogue", HistoriqueIndicateurFactory
				.getInstances(historique2016QueryService.getPersonnesPlateformesDialogueData()));

		// # et le type de résolutions issues des dialogues communautaires
		model.addAttribute("listResolutionsDialoguesCommunautaires", HistoriqueIndicateurFactory
				.getInstances(historique2016QueryService.getResolutionsDialoguesCommunautairesData()));

		// # de MFR opérationnels
		model.addAttribute("listMFROperationnels",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getMFROperationnelsData()));

		// Un réseau de MFR opérationnel
		model.addAttribute("listReseauMFROperationnels",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getReseauMFROperationnelsData()));

		// # d'élèves étudiant dans les MFR
		model.addAttribute("listElevesEtudiantMFR",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getElevesEtudiantMFRData()));

		// # de jeunes diplômés sortant des MFR
		model.addAttribute("listJeunesdiplomessortantMFR",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getJeunesdiplomessortantMFRData()));

		// # de jeunes sortants des MFR mettant en œuvre leur projet
		model.addAttribute("listJeunesSortantsProjet",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getJeunesSortantsProjetData()));

		// # d'élèves formés sur FBS à travers les MFR
		model.addAttribute("listElevesformesFBSMFR",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getElevesformesFBSMFRData()));

		// # nombre d'échanges MFR entre Comité des jeunes
		model.addAttribute("listEchangesMFRComiteJeunes",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getEchangesMFRComiteJeunesData()));

		// # d'école bénéficiant des subventions
		model.addAttribute("listEcoleBeneficiantSubventions", HistoriqueIndicateurFactory
				.getInstances(historique2016QueryService.getEcoleBeneficiantSubventionsData()));

		// % des FRAM qui utilisent effectivement les subventions
		model.addAttribute("listFRAMUtilisentSubventions",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getFRAMUtilisentSubventionsData()));

		// Proportions subventions % au budget des écoles N°1
		model.addAttribute("listProportionsSubventions1", HistoriqueIndicateurSaisirFactory
				.getInstances(historique2016QueryService.getProportionsSubventions1Data()));

		// Proportions subventions % au budget des écoles N°2
		model.addAttribute("listProportionsSubventions2", HistoriqueIndicateurSaisirFactory
				.getInstances(historique2016QueryService.getProportionsSubventions2Data()));

		// Proportions subventions % au budget des écoles N°3
		model.addAttribute("listProportionsSubventions3", HistoriqueIndicateurSaisirFactory
				.getInstances(historique2016QueryService.getProportionsSubventions3Data()));

		// # d'élèves présents dans les écoles aidées
		model.addAttribute("listElevesPresentsEcoles",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getElevesPresentsEcolesData()));

		// # d'enseignants formés à l'éducation environnementale
		model.addAttribute("listEnseignantsFormes",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getEnseignantsFormesData()));

		// # d'enseignants kit mad'ère
		model.addAttribute("listEnseignantsKitMadere",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getEnseignantsKitMadereData()));

		// # d'école concernées
		model.addAttribute("listEcoleConcernees",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getEcoleConcerneesData()));

		// # de participants au concours environnemental
		model.addAttribute("listParticipantsConcours",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getParticipantsConcoursData()));

		// Pourcentage de participant ayant obtenu la moyenne au concours
		// environnemental
		model.addAttribute("listPourcentageParticipant",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getPourcentageParticipantData()));

		// # de producteurs couverts par la mutuelle de santé mahavelona
		model.addAttribute("listMahavelonaM12Adherants",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getMahavelonaM12AdherantsData()));

		// # de villages couverts par Mahavelona
		model.addAttribute("listVillagesCouvertsMahavelona", HistoriqueIndicateurFactory
				.getInstances(historique2016QueryService.getVillagesCouvertsMahavelonaData()));

		// Prévalence des maladies diarhéiques des membres de Mahavelona
		model.addAttribute("listPrevalenceMaladies",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getPrevalenceMaladiesData()));

		// Taux de sinistralité au niveau des zones d'intervention M7
		model.addAttribute("listTauxSinistraliteM7",
				HistoriqueIndicateurSaisirFactory.getInstances(historique2016QueryService.getTauxSinistraliteM7Data()));

		// Taux de sinistralité au niveau des zones d'intervention M12
		model.addAttribute("listTauxSinistraliteM12", HistoriqueIndicateurSaisirFactory
				.getInstances(historique2016QueryService.getTauxSinistraliteM12Data()));

		// Taux de fréquentation des centres de santé pour les enfants des ménages
		// pauvres
		model.addAttribute("listTauxFrequentation1",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getTauxFrequentation1Data()));

		// Taux de fréquentation des structures de santé
		model.addAttribute("listTauxFrequentation2",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getTauxFrequentation2Data()));

		// Taux de satisfaction des membres de Mahavelona
		model.addAttribute("listTauxSatisfaction",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getTauxSatisfactionData()));

		// # de village ayant amélioré l'accès à l'eau potable
		model.addAttribute("listVillageAmeliore",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getVillageAmelioreData()));

		// # de ménages les plus vulnérables bénéficiant de grants
		model.addAttribute("listBeneficiantGrants",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getBeneficiantGrantsData()));

		// Subventions allouées aux ménages les plus vulnérables
		model.addAttribute("listSubventionsMenages",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getSubventionsMenagesData()));

		// # ménage qui rapportent que l'utilisation des grants
		model.addAttribute("listMenageRapportentGrants",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getMenageRapportentGrantsData()));

		// # de VSLA constitués
		model.addAttribute("listVSLAConstitues",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getVSLAConstituesData()));

		// # de personnes ayant accès aux services financiers informels via les VSLA
		model.addAttribute("listPersonnesFinanciersVSLA",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getPersonnesFinanciersVSLAData()));

		// Montant des épargnes investis dans le groupe VSLA
		model.addAttribute("listMontantInvestisGroupeVSLA", HistoriqueIndicateurFactory
				.getInstances(historique2016QueryService.getMontantInvestisGroupeVSLAData()));

		// # de VSLA fonctionnels
		model.addAttribute("listVSLAFonctionnels",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getVSLAFonctionnelsData()));

		// Mahavelona (lilghtpackage) => M7 Adhérant
		model.addAttribute("listMahavelonaM7Adherant",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getMahavelonaM7AdherantData()));

		// # de jeunes participant au programme d'alphabétisation
		model.addAttribute("listJeunesParticipantAlphabetisation", HistoriqueIndicateurFactory
				.getInstances(historique2016QueryService.getJeunesParticipantAlphabetisationData()));

		// # de jeunes déscolarisés ayant complèté le programme d'alphabétisation
		model.addAttribute("listJeunesDescolarises",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getJeunesDescolarisesData()));

		// # de jeunes ayant complèté le programme d'alphabétisation
		model.addAttribute("listJeunesAyantComplete",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getJeunesAyantCompleteData()));

		// # de jeunes formés en plan de vie viable (pathway)
		model.addAttribute("listPathway",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getPathwayData()));

		// # de jeunes ayant un plan de vie viable, à préciser par type de plan de vie
		model.addAttribute("listJeunesTypePlanVie",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getJeunesTypePlanVieData()));

		// # de jeunes ayant obtenu des grants
		model.addAttribute("listJeunesAyantObtenuGrants",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getJeunesAyantObtenuGrantsData()));

		// Taux d'abandon scolaire des jeunes
		model.addAttribute("listTauxAbandonScolaire",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getTauxAbandonScolaireData()));

		// # des ménages sensibilisés
		model.addAttribute("listMenagesSensibilises",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getMenagesSensibilisesData()));

		// Taux de diversification alimentaire des ménages pauvres
		model.addAttribute("listTauxDiversificationMenagespauvres", HistoriqueIndicateurFactory
				.getInstances(historique2016QueryService.getTauxDiversificationMenagespauvresData()));

		// Taux de fréquentation des centres de santé pour les enfants des ménages
		// pauvres
		model.addAttribute("listTauxFrequentationEnfants",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getTauxFrequentationEnfantsData()));

		// Au moins 3 recommandations de santé
		model.addAttribute("listRecommandationsSante",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getRecommandationsSanteData()));

		// # d'atelier du secteur auquel participe le projet
		model.addAttribute("listAtelierSecteur",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getAtelierSecteurData()));

		// # de participation de SAVE THE CHILDREN aux réunions de SVI
		model.addAttribute("listParticipationReunionsSVI",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getParticipationReunionsSVIData()));

		// Taux de connaissance des droits des enfants dans les ménages et communautés
		model.addAttribute("listTauxConnaissance",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getTauxConnaissanceData()));

		// # d'acteur de la filière
		model.addAttribute("listActeurFiliere",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getActeurFiliereData()));

		// Etude d'Impact complète et partagee avec Unilever/Symrise
		model.addAttribute("listEtudeImpactComplete",
				HistoriqueIndicateurFactory.getInstances(historique2016QueryService.getEtudeImpactCompleteData()));

		return "giz-indicateur/indicateurs2016.html";
	}
}
