package mg.giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mg.giz.data.constants.ColumnStructure;
import mg.giz.data.domain.Ameliorer;

public interface AmeliorerService {

	List<Ameliorer> createAmeliorer(String[][] ExcelToArray, Map<String, Integer> AmeliorerMapping, String theme)
			throws ParseException;

	List<Ameliorer> addAmeliorer(ArrayList<ColumnStructure> columnStructure, String[][] ExcelToArray, String theme)
			throws ParseException;
	
	boolean saveCrudAmeliorer(Ameliorer ameliorer);
	
	Ameliorer createAmeliorer238(Ameliorer ameliorer, String code_fkt, Date eaupotable_date, String eaupotable_observation, Long theme_id);
	
	public List<Ameliorer> findAmeliorer ();
}
