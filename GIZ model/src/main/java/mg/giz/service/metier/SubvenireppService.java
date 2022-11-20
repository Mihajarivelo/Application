package mg.giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mg.giz.data.constants.ColumnStructure;
import mg.giz.data.domain.Ecoleepp;
import mg.giz.data.domain.Subvenirepp;

public interface SubvenireppService {

	List<Subvenirepp> createSubvenirepp(String[][] ExcelToArray, Map<String, Integer> subvenireppMapping, String theme)
			throws ParseException;

	void addSubvenirepp(ArrayList<ColumnStructure> columnStructure, String[][] ExcelToArray, String theme,
			List<Ecoleepp> ecoleepps) throws ParseException;

	List<Subvenirepp> addCodeEpp(List<Long> codeEpp, List<Subvenirepp> subvenirepp);
	
	public List<Subvenirepp> List221();

	boolean saveCrudSubvenirepp(Subvenirepp subvenirepp);
	
	Subvenirepp createSubvenireppCrud(Subvenirepp subvenirepp, Double subvenirepp_rehabilitaion,Double subvenirepp_salaire,Double subvenirepp_fourniture,String subvenirepp_ansco,
			Date subvenirepp_date,Long ecoleepp_id);
	
	public void deleteSubvenirepp(Long id);
}
