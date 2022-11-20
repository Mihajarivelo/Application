package mg.giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.giz.contrainte.factory.mappage.AmeliorerMappage;
import mg.giz.data.constants.ColumnStructure;
import mg.giz.data.domain.Ameliorer;
import mg.giz.data.domain.Theme;
import mg.giz.data.domain.Village;
import mg.giz.repository.AmeliorerRepository;

@Service
public class AmelioreServiceImpl implements AmeliorerService{

	@Autowired
	ThemeService themeService;
	
	@Autowired
	AmeliorerRepository ameliorerRepository;
	
	@Override
	public List<Ameliorer> createAmeliorer(String[][] ExcelToArray, Map<String, Integer> AmeliorerMapping, String theme)
			throws ParseException {
		int indice = -1;
		List<Ameliorer> Ameliorers = new ArrayList<>();
		Long themeId = themeService.findThemeId(theme);

		for (int i = 1; i < ExcelToArray.length; i++) {
			Ameliorer ameliorer = new Ameliorer();

			Theme th = new Theme(themeId);
			ameliorer.setTheme(th);

			if (AmeliorerMapping.containsKey("eaupotable_date")) {
				indice = AmeliorerMapping.get("eaupotable_date");
				String dateString = ExcelToArray[i][indice];
				Date date = Date.valueOf(dateString);
				ameliorer.setEaupotable_date(date);
			}

			if (AmeliorerMapping.containsKey("eaupotable_observation")) {
				indice = AmeliorerMapping.get("eaupotable_observation");
				ameliorer.setEaupotable_observation(ExcelToArray[i][indice]);
			}
			
			if (AmeliorerMapping.containsKey("code_fkt")) {
				indice = AmeliorerMapping.get("code_fkt");
				if (ExcelToArray[i][indice] != null) {
					Village vl = new Village(ExcelToArray[i][indice].replaceAll("\\s", "").toUpperCase());
					ameliorer.setVillage(vl);
					ameliorer.setCode_fkt(ExcelToArray[i][indice].replaceAll("\\s", "").toUpperCase());
				}
			}

			Ameliorers.add(ameliorer);
		}
		return Ameliorers;
	}

	@Override
	public List<Ameliorer> addAmeliorer(ArrayList<ColumnStructure> columnStructure, String[][] ExcelToArray,
			String theme) throws ParseException {
		Map<String, Integer> AmeliorerMapping = AmeliorerMappage.tableAmeliorer(columnStructure);
		List<Ameliorer> ameliorers = createAmeliorer(ExcelToArray, AmeliorerMapping, theme);
		ameliorerRepository.saveAll(ameliorers);
		ameliorerRepository.delete238Duplicated();
		return ameliorers;
	}

	@Override
	public boolean saveCrudAmeliorer(Ameliorer ameliorer) {
		int countBeforeSave = ameliorerRepository.CountAmeliorer();
		ameliorerRepository.save(ameliorer);
		ameliorerRepository.delete238Duplicated();
		int countAfterSave = ameliorerRepository.CountAmeliorer();
		if (countBeforeSave == countAfterSave) {
			return true;
		}
		return false;
	}

	@Override
	public Ameliorer createAmeliorer238(Ameliorer ameliorer, String code_fkt, Date eaupotable_date, String eaupotable_observation, Long theme_id) {
		ameliorer.setEaupotable_date(eaupotable_date);
		ameliorer.setEaupotable_observation(eaupotable_observation);
		
		if (code_fkt != "") {
			Village vl = new Village(code_fkt);
			ameliorer.setVillage(vl);
		}		
		if (theme_id > 0) {
			Theme th = new Theme(theme_id);
			ameliorer.setTheme(th);
		}
		return ameliorer;
	}

	@Override
	public List<Ameliorer> findAmeliorer() {
		return ameliorerRepository.findAmeliorer();
	}
}
