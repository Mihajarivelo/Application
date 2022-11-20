package mg.giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.giz.contrainte.factory.mappage.SuivithemeMappage;
import mg.giz.data.constants.ColumnStructure;
import mg.giz.data.domain.Suivitheme;
import mg.giz.data.domain.Theme;
import mg.giz.data.domain.Village;
import mg.giz.repository.SuivithemeRepository;

@Service
public class SuivithemeServiceImpl implements SuivithemeService{
	@Autowired
	private ThemeService themeService;
	
	@Autowired
	private SuivithemeRepository suivithemeRepository;
	
	@Override
	public List<Suivitheme> createSuivitheme(String[][] ExcelToArray, Map<String, Integer> suivithemeMapping,
			String theme) throws ParseException {

		List<Suivitheme> suivithemes = new ArrayList<>();
		int indice = -1;
		Long themeId = themeService.findThemeId(theme);
		
		for (int i = 1; i < ExcelToArray.length; i++) {
			Suivitheme st = new Suivitheme();
			
			Theme th = new Theme(themeId);
			st.setTheme(th);
			
			if (suivithemeMapping.containsKey("code_fkt")) {
				indice = suivithemeMapping.get("code_fkt");
				if (ExcelToArray[i][indice] != null) {
					Village vl = new Village(ExcelToArray[i][indice].replaceAll("\\s", "").toUpperCase());
					st.setVillage(vl);
					st.setCode_fkt(ExcelToArray[i][indice].replaceAll("\\s", "").toUpperCase());
				}
			}
			
			if (suivithemeMapping.containsKey("suivitheme_date")) {
				indice = suivithemeMapping.get("suivitheme_date");
				String dateString = ExcelToArray[i][indice];
				Date date = Date.valueOf(dateString);
				st.setSuivitheme_date(date);
			}

			if (suivithemeMapping.containsKey("suivitheme_comm")) {
				indice = suivithemeMapping.get("suivitheme_comm");
				st.setSuivitheme_comm(ExcelToArray[i][indice]);
			}
			if (suivithemeMapping.containsKey("suivitheme_femme")) {
				indice = suivithemeMapping.get("suivitheme_femme");
				double doubleValue = Double.valueOf(ExcelToArray[i][indice]);
				st.setSuivitheme_femme((int) doubleValue);
				
			}
			if (suivithemeMapping.containsKey("suivitheme_homme")) {
				indice = suivithemeMapping.get("suivitheme_homme");
				double doubleValue = Double.valueOf(ExcelToArray[i][indice]);
				st.setSuivitheme_homme((int) doubleValue);
			}
			if (suivithemeMapping.containsKey("suivitheme_valeur")) {
				indice = suivithemeMapping.get("suivitheme_valeur");
				double doubleValue = Double.valueOf(ExcelToArray[i][indice]);
				st.setSuivitheme_valeur(doubleValue);
			}
			suivithemes.add(st);
		}
		return suivithemes;
	}

	@Override
	public List<Suivitheme> listSuivitheme(ArrayList<ColumnStructure> columnStructure, String[][] ExcelToArray,
			String theme) throws ParseException {
		Map<String, Integer> suivithemeMapping = SuivithemeMappage.tableSuivitheme(columnStructure);
		List<Suivitheme> suivithemes = createSuivitheme(ExcelToArray, suivithemeMapping, theme);
		suivithemeRepository.saveAll(suivithemes);
		suivithemeRepository.delete441Duplicated();
		return suivithemes;
	}

	@Override
	public List<Suivitheme> listfetchdata(Long theme_id) {
		return suivithemeRepository.fetchSuiviThmData(theme_id);
	}

	@Override
	public boolean saveCrudSuivitheme(Suivitheme suivitheme) {
		int countBeforeSave = suivithemeRepository.CountSuivitheme();
		suivithemeRepository.save(suivitheme);
		suivithemeRepository.delete441Duplicated();
		int countAfterSave = suivithemeRepository.CountSuivitheme();
		if (countBeforeSave == countAfterSave) {
			return true;
		}
		return false;
	}

	@Override
	public Suivitheme createSuivithemeCrud(Suivitheme suivitheme, Date suivitheme_date, Double suivitheme_valeur,
			Long theme_id, String code_fkt) {
		suivitheme.setSuivitheme_date(suivitheme_date);
		suivitheme.setSuivitheme_valeur(suivitheme_valeur);
		if (code_fkt != "") {
			Village vl = new Village(code_fkt);
			suivitheme.setVillage(vl);
		}
		
		if (theme_id > 0 ) {
			Theme th = new Theme(theme_id);
			suivitheme.setTheme(th);
		}
		return suivitheme;
	}

	@Override
	public List<Suivitheme> findSuivitheme() {
		return suivithemeRepository.findSuivitheme();
	}

	@Override
	public Suivitheme create146eCrud(Suivitheme suivitheme, Date suivitheme_date, int suivitheme_homme,
			int suivitheme_femme, Long theme_id, String code_fkt) {
		suivitheme.setSuivitheme_date(suivitheme_date);
		suivitheme.setSuivitheme_homme(suivitheme_homme);
		suivitheme.setSuivitheme_femme(suivitheme_femme);
		if (code_fkt != "") {
			Village vl = new Village(code_fkt);
			suivitheme.setVillage(vl);
		}
		
		if (theme_id > 0 ) {
			Theme th = new Theme(theme_id);
			suivitheme.setTheme(th);
		}
		return suivitheme;
	}

	@Override
	public Suivitheme createCrud135(Suivitheme suivitheme, Long theme_id, Double suivitheme_valeur, String code_fkt,
			Date suivitheme_date) {
		suivitheme.setSuivitheme_valeur(suivitheme_valeur);
		if (code_fkt != "") {
			Village vl = new Village(code_fkt);
			suivitheme.setVillage(vl);
		}		
		if (theme_id > 0 ) {
			Theme th = new Theme(theme_id);
			suivitheme.setTheme(th);
		}		
		suivitheme.setSuivitheme_date(suivitheme_date);
		
		return suivitheme;
	}

	@Override
	public List<Suivitheme> findSuivitheme135() {
		return suivithemeRepository.findSuivitheme135();
	}

}
