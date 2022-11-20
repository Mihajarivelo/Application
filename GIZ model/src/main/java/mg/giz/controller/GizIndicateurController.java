package mg.giz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mg.giz.contrainte.factory.GizIndicateursFactory;
import mg.giz.service.metier.GizIndicateursQueryService;

@Controller
public class GizIndicateurController {

	@Autowired
	private GizIndicateursQueryService gizIndicateursQueryService;

	// Ferme de reference

	@RequestMapping(value = "/giz-indicateurs")
	public String getIndicateursGizData(Model model) {

		// # beneficiaires FR

		model.addAttribute("listFRDto", GizIndicateursFactory.getInstances(gizIndicateursQueryService.getFRData()));

		// # de restitution auprès des FR
		model.addAttribute("listRestitutionFR",
				GizIndicateursFactory.getInstances(gizIndicateursQueryService.getRestitutionFRData()));

		// # de formateurs FBS formés

		model.addAttribute("listFormateursFBS",
				GizIndicateursFactory.getInstances(gizIndicateursQueryService.getFormateursFBSformesData()));

		// # de producteurs sensibilisés

		model.addAttribute("listProducteursSensibilises",
				GizIndicateursFactory.getInstances(gizIndicateursQueryService.getProdsensibilisesData()));

		// # de session de formation FBS effectués

		model.addAttribute("listSessionFormationFBS",
				GizIndicateursFactory.getInstances(gizIndicateursQueryService.getNombreSessionFBSData()));

		// # de producteurs formés

		model.addAttribute("listProducteursFormes",
				GizIndicateursFactory.getInstances(gizIndicateursQueryService.getProdformesData()));

		// # de producteurs bénéficiant de renforcement de capacité post-formation FBS

		model.addAttribute("listProducteursPostformationFBS",
				GizIndicateursFactory.getInstances(gizIndicateursQueryService.getProdpostformationData()));

		// # d'entrepreneurs identifiés

		model.addAttribute("listEntrepreneurIdentifies",
				GizIndicateursFactory.getInstances(gizIndicateursQueryService.getEntrepreneursData()));

		// # de personnes ressources opérationnelles

		model.addAttribute("listPersonnesRessourcesOperationnelles", GizIndicateursFactory
				.getInstances(gizIndicateursQueryService.getPersonnesRessourcesOperationnellesData()));

		// # de participants aux formations dispensées par les personnes ressources

		model.addAttribute("listFormationsPersonnesRessourcesData",
				GizIndicateursFactory.getInstances(gizIndicateursQueryService.getFormationsPersonnesRessourcesData()));

		// # de pépinièristes fonctionnels et gérant eux-même leur fonds

		model.addAttribute("listPepinieristesFonctionnels",
				GizIndicateursFactory.getInstances(gizIndicateursQueryService.getPepinieristesFonctionnelsData()));

		// # d'ASA formés

		model.addAttribute("listASAFormes",
				GizIndicateursFactory.getInstances(gizIndicateursQueryService.getASAFormesData()));

		// # d'ASA opérationnels

		model.addAttribute("listASAOperationnels",
				GizIndicateursFactory.getInstances(gizIndicateursQueryService.getASAOperationnelsData()));

		/*
		 * // Chiffre d'affaire mensuel moyen des ASA
		 * model.addAttribute("listChiffreAffaireMensuelMoyenASA",
		 * GizIndicateursFactory.getInstances(gizIndicateursQueryService.
		 * getChiffreAffaireMensuelMoyenASAData()));
		 * 
		 * // # de cheptels vaccinés model.addAttribute("listCheptelsVaccines",
		 * GizIndicateursFactory.getInstances(gizIndicateursQueryService.
		 * getCheptelsVaccinesData()));
		 */

		// # de formateurs en élevages opérationnels

		model.addAttribute("listFormateursElevagesOperationnels", GizIndicateursFactory
				.getInstances(gizIndicateursQueryService.getFormateursElevagesOperationnelsData()));

		// # de producteurs formés sur les bonnes pratiques d'élevage

		model.addAttribute("listProducteursFormesBonnesPratiquesElevage", GizIndicateursFactory
				.getInstances(gizIndicateursQueryService.getProducteursFormesBonnesPratiquesElevageData()));

		// # de producteurs qui ont adopté au moins une bonnes pratique d'élevage
		// (vaccination + alimentation ou logement ou reproduction)
		/*
		 * model.addAttribute("listProducteursBonnespratiqueElevage",
		 * GizIndicateursFactory .getInstances(gizIndicateursQueryService.
		 * getProducteursBonnespratiqueElevageData()));
		 */

		// # de fermes de diffusion opérationnelles

		model.addAttribute("listFermesPilote",
				GizIndicateursFactory.getInstances(gizIndicateursQueryService.getFermesPiloteData()));

		// # de visiteurs des fermes de diffusion (= producteurs qui sont venus pour le
		// croisement)
		/*
		 * model.addAttribute("listVisiteursFermesDiffusion",
		 * GizIndicateursFactory.getInstances(gizIndicateursQueryService.
		 * getVisiteursFermesDiffusionData()));
		 */
		// # de structure de producteurs fonctionnels

		model.addAttribute("listStructureProducteurs",
				GizIndicateursFactory.getInstances(gizIndicateursQueryService.getStructureProducteursData()));

		// # de structure de producteurs mettant en œuvre un service ou un projet

		model.addAttribute("listStructureProducteursProjet",
				GizIndicateursFactory.getInstances(gizIndicateursQueryService.getStructureProducteursProjetData()));

		// % de petits producteurs formés qui démontrent des compétences en leadership,
		// négociation et communication
		/*
		 * model.addAttribute("listTauxPetitsProducteursFormes",
		 * GizIndicateursFactory.getInstances(gizIndicateursQueryService.
		 * getTauxPetitsProducteursFormesData()));
		 */

		// # de MFR opérationnels
		model.addAttribute("listMFRoperationnels",
				GizIndicateursFactory.getInstances(gizIndicateursQueryService.getMFRoperationnelsData()));

		// # d'élèves étudiant dans les MFR
		model.addAttribute("listElevesEtudiantMFR",
				GizIndicateursFactory.getInstances(gizIndicateursQueryService.getElevesEtudiantMFRData()));

		// # de jeunes diplômés sortant des MFR
		model.addAttribute("listJeunesdiplomessortantMFR",
				GizIndicateursFactory.getInstances(gizIndicateursQueryService.getJeunesdiplomessortantMFRData()));

		// # de jeunes sortants des MFR mettant en œuvre leur projet
		model.addAttribute("listJeunesSortantsProjet",
				GizIndicateursFactory.getInstances(gizIndicateursQueryService.getJeunesSortantsProjetData()));

		// # d'élèves formés sur FBS à travers les MFR
		model.addAttribute("listElevesformesFBSMFR",
				GizIndicateursFactory.getInstances(gizIndicateursQueryService.getElevesformesFBSMFRData()));

		// # de producteurs couverts par la mutuelle de santé mahavelona
		model.addAttribute("listProducteursMahavelonaM12",
				GizIndicateursFactory.getInstances(gizIndicateursQueryService.getProducteursMahavelonaM12Data()));

		// Taux de sinistralité au niveau des zones d'intervention
		model.addAttribute("listTauxSinistralite",
				GizIndicateursFactory.getInstances(gizIndicateursQueryService.getTauxSinistraliteData()));

		// # de ménages les plus vulnérables bénéficiant de grants
		model.addAttribute("listMenagesVulnerablesBeneficiantGrants", GizIndicateursFactory
				.getInstances(gizIndicateursQueryService.getMenagesVulnerablesBeneficiantGrantsData()));

		// # de VSLA constitués
		model.addAttribute("listVSLAConstitues",
				GizIndicateursFactory.getInstances(gizIndicateursQueryService.getVSLAConstituesData()));

		return "giz-indicateur/giz-indicateur.html";
	}

}
