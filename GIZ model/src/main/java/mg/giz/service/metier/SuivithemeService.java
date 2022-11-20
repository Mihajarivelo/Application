package mg.giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mg.giz.data.constants.ColumnStructure;
import mg.giz.data.domain.Suivitheme;

public interface SuivithemeService {
	public List<Suivitheme> createSuivitheme(String[][] ExcelToArray, Map<String, Integer> suivithemeMapping,
			String theme) throws ParseException;

	List<Suivitheme> listSuivitheme(ArrayList<ColumnStructure> columnStructure, String[][] ExcelToArray, String theme)
			throws ParseException;
	
	List<Suivitheme> listfetchdata(Long theme_id);
	
	boolean saveCrudSuivitheme(Suivitheme suivitheme);
	
	Suivitheme createSuivithemeCrud(Suivitheme suivitheme, Date suivitheme_date, Double suivitheme_valeur,Long theme_id, String code_fkt);
	
	public List<Suivitheme> findSuivitheme();
	
	Suivitheme create146eCrud(Suivitheme suivitheme, Date suivitheme_date,int suivitheme_homme, int suivitheme_femme,Long theme_id, String code_fkt);
	
	Suivitheme createCrud135(Suivitheme suivitheme, Long theme_id, Double suivitheme_valeur, String code_fkt, Date suivitheme_date);
	
	public List<Suivitheme> findSuivitheme135();
}
