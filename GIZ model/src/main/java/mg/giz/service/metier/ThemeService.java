package mg.giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mg.giz.data.constants.ColumnStructure;
import mg.giz.data.domain.Theme;

public interface ThemeService {
	public List<Theme> createTheme(String[][] ExcelToArray, Map<String, Integer> ThemeMapping, String theme)
			throws ParseException;

	public Long findThemeId(String theme);
	
	public Long selectId();
	
	public Long select125();
	
	public Long selectThm(String theme_lib);

	public void addTheme(List<Theme> themes);

	public void deleteThemeDuplicated();

	List<Theme> listThemeVsla(ArrayList<ColumnStructure> columnStructure, String[][] ExcelToArray ,String theme)
			throws ParseException;
	
	public void addThemeVsla(List<Theme> themes);

	List<Long> findThemeIdVsla(List<Theme> themes, String theme);
	
	Theme createThemeCrud(Theme theme, String theme_lib,String souscomposante_code, String theme_programme, Date theme_date,String code_fkt);
	
	boolean saveCrudTheme(Theme theme);
	
	public Long listTheme(String theme_lib,String theme_programme);
	
	public Long selectTheme238();
	
	public Long selectTheme441();
	
	public Long selectTheme144();
	
	Theme createThemeCrud211(Theme theme, String code_fkt, Date theme_date, String theme_programme);
	
	public List<Theme> themeMFR();
	
	public Long selectTheme135();
	
	public Long selectTheme213();
	
	public Long selectThemeFBS();
}
