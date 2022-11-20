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
public class PostformationfbsServiceImpl implements PostformationfbsService{
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

			if (columnName.equals("efi")) {
				Index.add(columnStructure.get(i).getIndex());

			}

			if (columnName.equals("petit élevage")) {
				Index.add(columnStructure.get(i).getIndex());
			}

			if (columnName.equals("cep")) {
				Index.add(columnStructure.get(i).getIndex());
			}

		}

		return Index;

	}

	@Override
	public List<Beneficierpgm> addPostformation(String[][] ExcelToArray, List<Integer> Index,
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
	public void addEFI(List<Beneficierpgm> beneficiairePgrm, String[][] ExcelToArray, List<Integer> Index) {
		for (int i = 1; i < ExcelToArray.length; i++) {
			int efi = Index.get(0);
			Long themeIdefi = themeService.findThemeId("1.2.5a");
			if (Integer.parseInt(ExcelToArray[i][efi]) == 1) {
				Theme th = new Theme(themeIdefi);
				beneficiairePgrm.get(i - 1).setTheme(th);
				beneficierpgmRepository.save(beneficiairePgrm.get(i - 1));
			}
		}

	}

	@Override
	public void addPetitElevage(List<Beneficierpgm> beneficiairePgrm, String[][] ExcelToArray, List<Integer> Index) {
		for (int i = 1; i < ExcelToArray.length; i++) {
			int petitElevage = Index.get(1);
			Long themeIdPetitElevage = themeService.findThemeId("1.2.5b");
			if (Integer.parseInt(ExcelToArray[i][petitElevage]) == 1) {
				Theme th = new Theme(themeIdPetitElevage);
				beneficiairePgrm.get(i - 1).setTheme(th);
				beneficierpgmRepository.save(beneficiairePgrm.get(i - 1));
			}
		}

	}

	@Override
	public void addCEP(List<Beneficierpgm> beneficiairePgrm, String[][] ExcelToArray, List<Integer> Index) {
		for (int i = 1; i < ExcelToArray.length; i++) {
			int cep = Index.get(2);
			Long themeIdCep = themeService.findThemeId("1.2.5c");
			if (Integer.parseInt(ExcelToArray[i][cep]) == 1) {
				Theme th = new Theme(themeIdCep);
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
