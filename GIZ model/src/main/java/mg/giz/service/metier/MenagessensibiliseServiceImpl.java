package mg.giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.giz.contrainte.factory.mappage.MenagessensibilisesMappage;
import mg.giz.data.constants.ColumnStructure;
import mg.giz.data.domain.Menagessensibilise;
import mg.giz.data.domain.Theme;
import mg.giz.data.domain.Village;
import mg.giz.repository.MenagessensibiliseRepository;

@Service
public class MenagessensibiliseServiceImpl implements MenagessensibiliseService {

	@Autowired
	private ThemeService themeService;

	@Autowired
	private MenagessensibiliseRepository menagessensibiliseRepository;

	@Override
	public List<Menagessensibilise> createMenagessensibilise(String[][] ExcelToArray,
			Map<String, Integer> MenagessensibilisesMappageMapping, String theme) throws ParseException {

		Long themeId = themeService.findThemeId(theme);
		List<Menagessensibilise> menagessensibilises = new ArrayList<>();
		int indice = -1;

		for (int i = 1; i < ExcelToArray.length; i++) {
			Menagessensibilise menagessensibilise = new Menagessensibilise();

			Theme th = new Theme(themeId);
			menagessensibilise.setTheme(th);

			if (MenagessensibilisesMappageMapping.containsKey("menagessensibilise_lib")) {
				indice = MenagessensibilisesMappageMapping.get("menagessensibilise_lib");
				menagessensibilise.setMenagessensibilise_lib(ExcelToArray[i][indice]);
			}

			if (MenagessensibilisesMappageMapping.containsKey("menagessensibilise_date")) {
				indice = MenagessensibilisesMappageMapping.get("menagessensibilise_date");
				String dateString = ExcelToArray[i][indice];
				Date date = Date.valueOf(dateString);
				menagessensibilise.setMenagessensibilise_date(date);
			}

			if (MenagessensibilisesMappageMapping.containsKey("menagessensibilise_homme")) {
				indice = MenagessensibilisesMappageMapping.get("menagessensibilise_homme");
				double doubleValue = Double.valueOf(ExcelToArray[i][indice]);
				menagessensibilise.setMenagessensibilise_homme((int) doubleValue);
			}

			if (MenagessensibilisesMappageMapping.containsKey("menagessensibilise_femme")) {
				indice = MenagessensibilisesMappageMapping.get("menagessensibilise_femme");
				double doubleValue = Double.valueOf(ExcelToArray[i][indice]);
				menagessensibilise.setMenagessensibilise_femme((int) doubleValue);
			}

			if (MenagessensibilisesMappageMapping.containsKey("menagessensibilise_garcon")) {
				indice = MenagessensibilisesMappageMapping.get("menagessensibilise_garcon");
				double doubleValue = Double.valueOf(ExcelToArray[i][indice]);
				menagessensibilise.setMenagessensibilise_garcon((int) doubleValue);
			}

			if (MenagessensibilisesMappageMapping.containsKey("menagessensibilise_fille")) {
				indice = MenagessensibilisesMappageMapping.get("menagessensibilise_fille");
				double doubleValue = Double.valueOf(ExcelToArray[i][indice]);
				menagessensibilise.setMenagessensibilise_fille((int) doubleValue);
			}

			if (MenagessensibilisesMappageMapping.containsKey("code_fkt")) {
				indice = MenagessensibilisesMappageMapping.get("code_fkt");
				if (ExcelToArray[i][indice] != null) {
					Village vl = new Village(ExcelToArray[i][indice].replaceAll("\\s", "").toUpperCase());
					menagessensibilise.setVillage(vl);
				}
			}

			menagessensibilises.add(menagessensibilise);
		}

		return menagessensibilises;
	}

	@Override
	public void addMenagessensibilise( ArrayList<ColumnStructure> columnStructure, String[][] ExcelToArray, String theme) throws ParseException {
		Map<String, Integer> menagessensibilisesMapping = MenagessensibilisesMappage.tableMenagessensibilisesMappage(columnStructure);
		List<Menagessensibilise> menagessensibilises = createMenagessensibilise(ExcelToArray, menagessensibilisesMapping, theme);
		menagessensibiliseRepository.saveAll(menagessensibilises);
		menagessensibiliseRepository.deleteMenagessensibiliseDudplicated();
	}

	@Override
	public List<Menagessensibilise> List331() {
		return menagessensibiliseRepository.fetchMenagessensibiliseData();
	}

	@Override
	public Menagessensibilise createPersonCrud331(Menagessensibilise menagessensibilise, String code_fkt,
			Date menagessensibilise_date, String menagessensibilise_lib, int menagessensibilise_homme,
			int menagessensibilise_femme, int menagessensibilise_garcon, int menagessensibilise_fille) {
		menagessensibilise.setMenagessensibilise_date(menagessensibilise_date);
		menagessensibilise.setMenagessensibilise_lib(menagessensibilise_lib);
		menagessensibilise.setMenagessensibilise_homme(menagessensibilise_homme);
		menagessensibilise.setMenagessensibilise_femme(menagessensibilise_femme);
		menagessensibilise.setMenagessensibilise_garcon(menagessensibilise_garcon);
		menagessensibilise.setMenagessensibilise_fille(menagessensibilise_fille);

		if (code_fkt != "") {
			Village vl = new Village(code_fkt);
			menagessensibilise.setVillage(vl);
		}

		return menagessensibilise;
	}

	@Override
	public boolean saveCrudMenagessensibilise(Menagessensibilise menagessensibilise) {
		int countBeforeSave = menagessensibiliseRepository.CountMenagessensibilise();
		menagessensibiliseRepository.save(menagessensibilise);
		menagessensibiliseRepository.deleteMenagessensibiliseDudplicated();
		int countAfterSave = menagessensibiliseRepository.CountMenagessensibilise();
		if (countBeforeSave == countAfterSave) {
			return true;
		}
		return false;
	}

}
