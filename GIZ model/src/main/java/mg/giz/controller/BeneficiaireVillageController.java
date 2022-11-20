package mg.giz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mg.giz.contrainte.factory.BeneficiaireVillageFactory;
import mg.giz.service.metier.BeneficiaireVillageQueryService;

@Controller
public class BeneficiaireVillageController {

	@Autowired
	private BeneficiaireVillageQueryService beneficiaireVillageQueryService;

	@RequestMapping(value = "/beneficiaire-village")
	public String getBeneficairesVillageData(Model model) {

		// Liste des beneficaires par village
		model.addAttribute("listBeneficairesVillage",
				BeneficiaireVillageFactory.getInstances(beneficiaireVillageQueryService.getBeneficairesVillageData()));

		return "beneficiary-table/beneficiary-village.html";
	}

	// Farmer Business Schools
	@RequestMapping(value = "/liste-ben-fbs")
	public String getVIEWFBSMenData(Model model) {
		model.addAttribute("listVIEWFBSMen",
				BeneficiaireVillageFactory.getInstances(beneficiaireVillageQueryService.getVIEWFBSMenData()));

		return "beneficiary-table/beneficiary-fbs.html";
	}

	// ASA
	@RequestMapping(value = "/liste-asa")
	public String getVIEWASAMenData(Model model) {
		model.addAttribute("listVIEWASAMen",
				BeneficiaireVillageFactory.getInstances(beneficiaireVillageQueryService.getVIEWASAMenData()));

		return "beneficiary-table/beneficiary-asa.html";
	}

	// formateurs élevage
	@RequestMapping(value = "/liste-frm-elevage")
	public String getVIEWFormateursElevageMenData(Model model) {
		model.addAttribute("listVIEWFormateursElevageMen", BeneficiaireVillageFactory
				.getInstances(beneficiaireVillageQueryService.getVIEWFormateursElevageMenData()));

		return "beneficiary-table/beneficiary-frm.html";
	}

	// bénéficiaires formation en petit élevage y compirs prod et non prod
	@RequestMapping(value = "/liste-ben-frm-elevage")
	public String getVIEWBeneficiairesFormationPetitElevageMenData(Model model) {
		model.addAttribute("listVIEWBeneficiairesFormationPetitElevageMen", BeneficiaireVillageFactory
				.getInstances(beneficiaireVillageQueryService.getVIEWBeneficiairesFormationPetitElevageMenData()));

		return "beneficiary-table/beneficiary-elevage.html";
	}

	// Jeunes MFR
	@RequestMapping(value = "/liste-mfr")
	public String getVIEWJeunesMFRBoysData(Model model) {
		model.addAttribute("listVIEWJeunesMFRBoys",
				BeneficiaireVillageFactory.getInstances(beneficiaireVillageQueryService.getVIEWJeunesMFRBoysData()));

		return "beneficiary-table/beneficiary-mfr.html";
	}

	// Enseignants formés en éducation environnementale
	@RequestMapping(value = "/liste-enseignants")
	public String getVIEWEnseignantsFormesMenData(Model model) {
		model.addAttribute("listVIEWEnseignantsFormesMen", BeneficiaireVillageFactory
				.getInstances(beneficiaireVillageQueryService.getVIEWEnseignantsFormesMenData()));

		return "beneficiary-table/beneficiary-enseignants.html";
	}

	// VSLAs
	@RequestMapping(value = "/liste-vsla")
	public String getVIEWVSLAsMenData(Model model) {
		model.addAttribute("listVIEWVSLAsMen",
				BeneficiaireVillageFactory.getInstances(beneficiaireVillageQueryService.getVIEWVSLAsMenData()));

		return "beneficiary-table/beneficiary-vsla.html";
	}

	// Setting up Youth Committees
	@RequestMapping(value = "/liste-committees")
	public String getVIEWSettingCommitteesBoysData(Model model) {
		model.addAttribute("listVIEWSettingCommitteesBoys", BeneficiaireVillageFactory
				.getInstances(beneficiaireVillageQueryService.getVIEWSettingCommitteesBoysData()));

		return "beneficiary-table/beneficiary-committees.html";
	}

	// Providing poorest families with small livelihoods grants
	@RequestMapping(value = "/liste-ben-grants")
	public String getVIEWLivelihoodsGrantsMenData(Model model) {
		model.addAttribute("listVIEWLivelihoodsGrantsMen", BeneficiaireVillageFactory
				.getInstances(beneficiaireVillageQueryService.getVIEWLivelihoodsGrantsMenData()));

		return "beneficiary-table/beneficiary-grants.html";
	}

	// Healthcare and WASH (Comp 2b) = Boys&GirlsM12
	@RequestMapping(value = "/liste-jeunes-m12")
	public String getVIEWHealthcareWASHBoysData(Model model) {
		model.addAttribute("listVIEWHealthcareWASHBoys", BeneficiaireVillageFactory
				.getInstances(beneficiaireVillageQueryService.getVIEWHealthcareWASHBoysData()));

		return "beneficiary-table/beneficiary-m12a.html";
	}

	// Healthcare and WASH (Comp 2b) = Men&WomenM12
	@RequestMapping(value = "/liste-adulte-m12")
	public String getVIEWHealthcareWASHMenData(Model model) {
		model.addAttribute("listVIEWHealthcareWASHMen", BeneficiaireVillageFactory
				.getInstances(beneficiaireVillageQueryService.getVIEWHealthcareWASHMenData()));

		return "beneficiary-table/beneficiary-m12b.html";
	}

	// Healthcare and WASH (Comp 2b) = Boys&GirlsM7
	@RequestMapping(value = "/liste-jeunes-m7")
	public String getVIEWHealthcareWASHBoysM7Data(Model model) {
		model.addAttribute("listVIEWHealthcareWASHBoysM7", BeneficiaireVillageFactory
				.getInstances(beneficiaireVillageQueryService.getVIEWHealthcareWASHBoysM7Data()));

		return "beneficiary-table/beneficiary-m7a.html";
	}

	// Healthcare and WASH (Comp 2b) = Men&WomenM7
	@RequestMapping(value = "/liste-adulte-m7")
	public String getVIEWHealthcareWASHMenM7Data(Model model) {
		model.addAttribute("listVIEWHealthcareWASHMenM7", BeneficiaireVillageFactory
				.getInstances(beneficiaireVillageQueryService.getVIEWHealthcareWASHMenM7Data()));

		return "beneficiary-table/beneficiary-m7b.html";
	}

	// Children at Primary Public Schools
	@RequestMapping(value = "/liste-eleve-epp")
	public String getVIEWChildrenPrimaryPublicSchoolsBoysData(Model model) {
		model.addAttribute("listVIEWChildrenPrimaryPublicSchoolsBoys", BeneficiaireVillageFactory
				.getInstances(beneficiaireVillageQueryService.getVIEWChildrenPrimaryPublicSchoolsBoysData()));

		return "beneficiary-table/beneficiary-children.html";
	}

	// Individus sensibilisés
	@RequestMapping(value = "/liste-menages-sensibilises")
	public String getVIEWIndividusSensibilisesBoysData(Model model) {
		model.addAttribute("listVIEWIndividusSensibilisesBoys", BeneficiaireVillageFactory
				.getInstances(beneficiaireVillageQueryService.getVIEWIndividusSensibilisesBoysData()));

		return "beneficiary-table/beneficiary-sensibilises.html";
	}

}
