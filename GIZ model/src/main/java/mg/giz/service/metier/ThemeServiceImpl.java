package mg.giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.giz.contrainte.factory.mappage.ThemeMappage;
import mg.giz.data.constants.ColumnStructure;
import mg.giz.data.constants.code.SousComposanteCode;
import mg.giz.data.constants.code.ThemeProgrammeCode;
import mg.giz.data.domain.Souscomposante;
import mg.giz.data.domain.Theme;
import mg.giz.data.domain.Village;
import mg.giz.repository.ThemeRepository;

@Service
public class ThemeServiceImpl implements ThemeService {
	@Autowired
	private ThemeRepository themeRepository;

	@Override
	public Long findThemeId(String theme) {
		Long theme_id = themeRepository.findThemeId(theme);
		return theme_id;
	}

	@Override
	public List<Theme> createTheme(String[][] ExcelToArray, Map<String, Integer> ThemeMapping, String theme)
			throws ParseException {
		String souscomposante = SousComposanteCode.sousComposanteCode(theme);
		String themeprogramme = ThemeProgrammeCode.themeProgrammeCode(theme);

		List<Theme> themes = new ArrayList<>();
		int indice = -1;

		for (int i = 1; i < ExcelToArray.length; i++) {
			Theme th = new Theme();
			Souscomposante sc = new Souscomposante(souscomposante);
			th.setSouscomposante(sc);
			th.setTheme_programme(themeprogramme);

			if (ThemeMapping.containsKey("theme_date")) {
				indice = ThemeMapping.get("theme_date");
				String dateString = ExcelToArray[i][indice];
				Date date = Date.valueOf(dateString);
				th.setTheme_date(date);
			}

			if (ThemeMapping.containsKey("theme_lib")) {
				indice = ThemeMapping.get("theme_lib");
				th.setTheme_lib(ExcelToArray[i][indice]);
			}

			if (ThemeMapping.containsKey("theme_vslahameau")) {
				indice = ThemeMapping.get("theme_vslahameau");
				th.setTheme_vslahameau(ExcelToArray[i][indice]);
			}

			if (ThemeMapping.containsKey("code_fkt")) {
				indice = ThemeMapping.get("code_fkt");
				if (ExcelToArray[i][indice] != null) {
					Village vl = new Village(ExcelToArray[i][indice].replaceAll("\\s", ""));
					th.setVillage(vl);
					th.setCode_fkt(ExcelToArray[i][indice].replaceAll("\\s", ""));
				}
			}

			themes.add(th);
		}

		return themes;
	}

	@Override
	public void addTheme(List<Theme> themes) {
		themeRepository.saveAll(themes);
	}

	@Override
	public void deleteThemeDuplicated() {
		themeRepository.deleteThemeDuplicated();

	}

	@Override
	public List<Theme> listThemeVsla(ArrayList<ColumnStructure> columnStructure, String[][] ExcelToArray, String theme)
			throws ParseException {
		Map<String, Integer> themeVslaMapping = ThemeMappage.tableTheme(columnStructure);
		List<Theme> themes = createTheme(ExcelToArray, themeVslaMapping, theme);
		return themes;
	}

	@Override
	public void addThemeVsla(List<Theme> themes) {
		themeRepository.saveAll(themes);
		themeRepository.deleteThemeDuplicated();
	}

	@Override
	public List<Long> findThemeIdVsla(List<Theme> themes, String theme) {
		List<Long> IdTheme = new ArrayList<>();
		for (int i = 0; i < themes.size(); i++) {
			String themeProgramme;
			String themeLib = themes.get(i).getTheme_lib();
			String fkt = themes.get(i).getCode_fkt();
			if (theme.equals("3.1.4")) {
				themeProgramme = "VSLA";
			} else {
				themeProgramme = "VSLA fonctionnels";
			}
			Long id = themeRepository.findThemeIdVsla(themeLib, themeProgramme, fkt);
			IdTheme.add(id);
		}
		return IdTheme;
	}

	@Override
	public Long selectId() {
		// TODO Auto-generated method stub
		Long thm_id = themeRepository.selectId();
		return thm_id;
	}

	@Override
	public Long select125() {
		// TODO Auto-generated method stub
		return themeRepository.select125();
	}

	@Override
	public Long selectThm(String theme_lib) {
		return themeRepository.selectThm(theme_lib);
	}

	@Override
	public Theme createThemeCrud(Theme theme, String theme_lib,String souscomposante_code, String theme_programme, Date theme_date,String code_fkt) {
		theme.setTheme_lib(theme_lib);
		theme.setTheme_programme(theme_programme);
		theme.setTheme_date(theme_date);
		
		if (souscomposante_code != null) {
			Souscomposante vl = new Souscomposante(souscomposante_code);
			theme.setSouscomposante(vl);
		}
		if (code_fkt != "") {
			Village fk = new Village(code_fkt);
			theme.setVillage(fk);
		}
		
		return theme;
	}

	@Override
	public boolean saveCrudTheme(Theme theme) {
		int countBeforeSave = themeRepository.CountTheme();
		themeRepository.save(theme);
		themeRepository.deleteThemeDuplicated();
		int countAfterSave = themeRepository.CountTheme();
		if (countBeforeSave == countAfterSave) {
			return true;
		}
		return false;
	}

	@Override
	public Long listTheme(String theme_lib, String theme_programme) {
		return themeRepository.selectThemeId(theme_lib, theme_programme);
	}

	@Override
	public Long selectTheme238() {
		return themeRepository.selectTheme238();
	}

	@Override
	public Long selectTheme441() {
		return themeRepository.selectTheme441();
	}

	@Override
	public Long selectTheme144() {
		return themeRepository.selectTheme144();
	}

	@Override
	public Theme createThemeCrud211(Theme theme, String code_fkt, Date theme_date, String theme_programme) {
		if (code_fkt != "") {
			Village fk = new Village(code_fkt);
			theme.setVillage(fk);
		}
		theme.setTheme_date(theme_date);
		theme.setTheme_programme(theme_programme);
		return theme;
	}

	@Override
	public List<Theme> themeMFR() {
		return themeRepository.themeMFR();
	}

	@Override
	public Long selectTheme135() {
		return themeRepository.selectTheme135();
	}

	@Override
	public Long selectTheme213() {
		return themeRepository.selectTheme213();
	}

	@Override
	public Long selectThemeFBS() {
		return themeRepository.selectThemeFBS();
	}
}
