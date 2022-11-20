package mg.giz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mg.giz.contrainte.factory.BeneficiaryTableFactory;
import mg.giz.service.metier.BeneficiaryTableQueryService;

@Controller
public class BeneficiaryTableController {

	@Autowired
	private BeneficiaryTableQueryService beneficiaryTableQueryService;

	@RequestMapping(value = "/beneficiary-table")
	public String getIndicateursGizData(Model model) {

		// Farmer Business Schools, (Comp 1a) = Men
		model.addAttribute("listFBSMen",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getFBSMenData()));

		// Farmer Business Schools, (Comp 1a) = Women
		model.addAttribute("listFBSWomen",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getFBSWomenData()));

		// coopératives strengthening 1b = Men
		model.addAttribute("listCooperativesStrengtheninMen", BeneficiaryTableFactory
				.getInstances(beneficiaryTableQueryService.getCooperativesStrengtheninMengData()));

		// coopératives strengthening 1b = Women
		model.addAttribute("listCooperativesStrengtheningWomen", BeneficiaryTableFactory
				.getInstances(beneficiaryTableQueryService.getCooperativesStrengtheningWomenData()));

		// ASA = Men
		model.addAttribute("listASAMen",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getASAMenData()));

		// ASA = Women
		model.addAttribute("listASAWomen",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getASAWomenData()));

		// formateurs élevage = Men
		model.addAttribute("listFormateursElevageMen",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getFormateursElevageMenData()));

		// formateurs élevage = Women
		model.addAttribute("listFormateursElevageWomen",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getFormateursElevageWomenData()));

		// bénéficiaires formation en petit élevage y compirs prod et non prod = Men
		model.addAttribute("listBeneficiairesFormationPetitElevageMen", BeneficiaryTableFactory
				.getInstances(beneficiaryTableQueryService.getBeneficiairesFormationPetitElevageMenData()));

		// bénéficiaires formation en petit élevage y compirs prod et non prod = Women
		model.addAttribute("listBeneficiairesFormationPetitElevageWomen", BeneficiaryTableFactory
				.getInstances(beneficiaryTableQueryService.getBeneficiairesFormationPetitElevageWomenData()));

		// Children at Primary Public Schools = Boys
		model.addAttribute("listChildrenPrimaryPublicSchoolsBoys", BeneficiaryTableFactory
				.getInstances(beneficiaryTableQueryService.getChildrenPrimaryPublicSchoolsBoysData()));

		// Children at Primary Public Schools = Girls
		model.addAttribute("listChildrenPrimaryPublicSchoolsGirls", BeneficiaryTableFactory
				.getInstances(beneficiaryTableQueryService.getChildrenPrimaryPublicSchoolsGirlsData()));

		// Jeunes MFR = Boys
		model.addAttribute("listJeunesMFRBoys",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getJeunesMFRBoysData()));

		// Jeunes MFR = Girls
		model.addAttribute("listJeunesMFRGirl",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getJeunesMFRGirlsData()));

		// Enseignants formés en éducation environnementale = Men
		model.addAttribute("listEnseignantsFormesMen",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getEnseignantsFormesMenData()));

		// Enseignants formés en éducation environnementale = Women
		model.addAttribute("listEnseignantsFormesWomen",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getEnseignantsFormesWomenData()));

		// Healthcare and WASH (Comp 2b) = Boys
		model.addAttribute("listHealthcareWASHBoys",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getHealthcareWASHBoysData()));

		// Healthcare and WASH (Comp 2b) = Girls
		model.addAttribute("listHealthcareWASHGirls",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getHealthcareWASHGirlsData()));

		// Healthcare and WASH (Comp 2b) = Men
		model.addAttribute("listHealthcareWASHMen",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getHealthcareWASHMenData()));

		// Healthcare and WASH (Comp 2b) = Women
		model.addAttribute("listHealthcareWASHWomen",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getHealthcareWASHWomenData()));

		// Healthcare and WASH (Comp 3) = Boys M7
		model.addAttribute("listHealthcareWASHBoysM7",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getHealthcareWASHBoysM7Data()));

		// Healthcare and WASH (Comp 3) = Girls M7
		model.addAttribute("listHealthcareWASHGirlsM7",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getHealthcareWASHGirlsM7Data()));

		// Healthcare and WASH (Comp 3) = Men M7
		model.addAttribute("listHealthcareWASHMenM7",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getHealthcareWASHMenM7Data()));

		// Healthcare and WASH (Comp 3) = Women M7
		model.addAttribute("listHealthcareWASHWomenM7",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getHealthcareWASHWomenM7Data()));

		// VSLAs = Men
		model.addAttribute("listVSLAsMen",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getVSLAsMenData()));

		// VSLAs = Women
		model.addAttribute("listVSLAsWomen",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getVSLAsWomenData()));

		// Providing poorest families with small livelihoods grants = Men
		model.addAttribute("listLivelihoodsGrantsMen",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getLivelihoodsGrantsMenData()));

		// // Providing poorest families with small livelihoods grants = Women
		model.addAttribute("listLivelihoodsGrantsWomen",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getLivelihoodsGrantsWomenData()));

		// Individus sensibilisés = Boys
		model.addAttribute("listIndividusSensibilisesBoys",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getIndividusSensibilisesBoysData()));

		// Individus sensibilisés = Girls
		model.addAttribute("listIndividusSensibilisesGirls",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getIndividusSensibilisesGirlsData()));

		// Individus sensibilisés = Men
		model.addAttribute("listIndividusSensibilisesMen",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getIndividusSensibilisesMenData()));

		// Individus sensibilisés = Women
		model.addAttribute("listIndividusSensibilisesWomen",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getIndividusSensibilisesWomenData()));

		// Setting up Youth Committees = Boys
		model.addAttribute("listSettingCommitteesBoys",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getSettingCommitteesBoysData()));

		// Setting up Youth Committees = Girls
		model.addAttribute("listSettingCommitteesGirls",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getSettingCommitteesGirlsData()));

		// Providing literacy, numeracy and life skills training = Boys
		model.addAttribute("listLifeSkillsTrainingBoys",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getLifeSkillsTrainingBoysData()));

		// Providing literacy, numeracy and life skills training = Girls
		model.addAttribute("listLifeSkillsTrainingGirls",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getLifeSkillsTrainingGirlsData()));

		// Jeunes formés en plan de vie viable (pathway) = Boys N°2
		model.addAttribute("listPathwayBoys",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getPathwayBoysData()));

		// Jeunes formés en plan de vie viable (pathway) = Girls N°2
		model.addAttribute("listPathwayGirls",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getPathwayGirlsData()));

		// TOTAL = Boys
		model.addAttribute("listTotalBoys",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getTotalBoysData()));

		// TOTAL = Girls
		model.addAttribute("listTotalGirls",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getTotalGirlsData()));

		// TOTAL 2 = Men
		model.addAttribute("listTotalMen",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getTotalMenData()));

		// TOTAL 2 = Women
		model.addAttribute("listTotalWomen",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getTotalWomenData()));

		// TOTAL 2 = Boys
		model.addAttribute("listTotal2Boys",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getTotal2BoysData()));

		// TOTAL 2 = Girls
		model.addAttribute("listTotal2Girls",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getTotal2GirlsData()));

		// TOTAL 2 = Men
		model.addAttribute("listTotal2Men",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getTotal2MenData()));

		// TOTAL 2 = Women
		model.addAttribute("listTotal2Women",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getTotal2WomenData()));

		// TOTAL 3 BOYS
		model.addAttribute("listTotal3Boys",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getTotal3BoysData()));

		// TOTAL 3 GIRLS
		model.addAttribute("listTotal3Girls",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getTotal3GirlsData()));

		// TOTAL 3 MEN
		model.addAttribute("listTotal3Men",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getTotal3MenData()));

		// TOTAL 3 WOMEN
		model.addAttribute("listTotal3Women",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getTotal3WomenData()));

		// TOTAL 4 Mixte
		model.addAttribute("listTotal4Mixte",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getTotal4MixteData()));

		// TOTAL 5 Ménages
		model.addAttribute("listTOTAL5Menages",
				BeneficiaryTableFactory.getInstances(beneficiaryTableQueryService.getTOTAL5MenagesData()));

		return "beneficiary-table/beneficiary-table.html";
	}
}
