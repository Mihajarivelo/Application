package mg.giz.service.metier;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.giz.contrainte.factory.mappage.BeneficierPgmMappage;
import mg.giz.contrainte.factory.mappage.PersonneMappage;
import mg.giz.data.constants.ColumnStructure;
import mg.giz.data.domain.Beneficierpgm;
import mg.giz.data.domain.Personne;
import mg.giz.data.domain.Theme;
import mg.giz.repository.BeneficierpgmRepository;

@Service
public class BonnepratiquefbsServiceImpl implements BonnepratiquefbsService {
	@Autowired
	PersonneService personneService;

	@Autowired
	BeneficierPgmService beneficierPgmService;

	@Autowired
	ThemeService themeService;

	@Autowired
	BeneficierpgmRepository beneficierpgmRepository;

	@Override
	public List<Integer> searchIndex(ArrayList<ColumnStructure> columnStructure) {
		List<Integer> Index = new ArrayList<Integer>();
		for (int i = 0; i < columnStructure.size(); i++) {
			String columnName = columnStructure.get(i).getNom();

			if (columnName.equals("planification et adoption techniques améliorées")) {
				Index.add(columnStructure.get(i).getIndex());

			}

			if (columnName.equals("diversification culturale et vie associative")) {
				Index.add(columnStructure.get(i).getIndex());
			}

			if (columnName.equals("bancarisation et vie associative")) {
				Index.add(columnStructure.get(i).getIndex());
			}

		}

		return Index;

	}

	@Override
	public List<Beneficierpgm> addBonnepratique(String[][] ExcelToArray, List<Integer> Index,
			ArrayList<ColumnStructure> columnStructure, String theme) throws ParseException {
		Map<String, Integer> personneMapping = PersonneMappage.tablePersonne(columnStructure);
		Map<String, Integer> beneficierpgmMapping = BeneficierPgmMappage.tableBeneficierPgmMappage(columnStructure);
		List<Personne> personnes = personneService.createPersonne(ExcelToArray, personneMapping, theme);
		List<Beneficierpgm> beneficierpgm = beneficierPgmService.createBeneficierpgm(ExcelToArray, beneficierpgmMapping,
				theme);
		personneService.addPersonne(personnes);
		personneService.deletePersonneDuplicated();
		List<Long> codePersonne = personneService.findPersonne(personnes);
		List<Beneficierpgm> beneficiairePgrm = beneficierPgmService.addCodePersonne(codePersonne, beneficierpgm);
		return beneficiairePgrm;

	}

	@Override
	public void addPlanification(List<Beneficierpgm> beneficiairePgrm, String[][] ExcelToArray, List<Integer> Index) {
		for (int i = 1; i < ExcelToArray.length; i++) {
			int Planification = Index.get(0);
			Long themeIdPlanification = themeService.findThemeId("1.2.6a");
			if (Integer.parseInt(ExcelToArray[i][Planification]) == 1) {
				Theme th = new Theme(themeIdPlanification);
				beneficiairePgrm.get(i - 1).setTheme(th);
				beneficierpgmRepository.save(beneficiairePgrm.get(i - 1));
			}
		}

	}

	@Override
	public void addDiversification(List<Beneficierpgm> beneficiairePgrm, String[][] ExcelToArray, List<Integer> Index) {
		for (int i = 1; i < ExcelToArray.length; i++) {
			int Diversification = Index.get(1);
			Long themeIdDiversification = themeService.findThemeId("1.2.6b");
			if (Integer.parseInt(ExcelToArray[i][Diversification]) == 1) {
				Theme th = new Theme(themeIdDiversification);
				beneficiairePgrm.get(i - 1).setTheme(th);
				beneficierpgmRepository.save(beneficiairePgrm.get(i - 1));
			}
		}

	}

	@Override
	public void addBancarisation(List<Beneficierpgm> beneficiairePgrm, String[][] ExcelToArray, List<Integer> Index) {
		for (int i = 1; i < ExcelToArray.length; i++) {
			int Bancarisation = Index.get(2);
			Long themeIdBancarisation = themeService.findThemeId("1.2.6c");
			if (Integer.parseInt(ExcelToArray[i][Bancarisation]) == 1) {
				Theme th = new Theme(themeIdBancarisation);
				beneficiairePgrm.get(i - 1).setTheme(th);
				beneficierpgmRepository.save(beneficiairePgrm.get(i - 1));
			}
		}

	}

	@Override
	public void deleteDuplicated() {
		beneficierpgmRepository.deleteBeneficierPgmDudplicated();
	}


}
