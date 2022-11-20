package mg.giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mg.giz.data.constants.ColumnStructure;
import mg.giz.data.domain.Visiteurferme;

public interface VisiteurfermeService {

	List<Visiteurferme> createVisiteurferme(String[][] ExcelToArray, Map<String, Integer> visiteurfermeMapping,
			String theme) throws ParseException;

	void addVisiteur(ArrayList<ColumnStructure> columnStructure, String[][] ExcelToArray, String theme)
			throws ParseException;
	
	List<Visiteurferme> listfetchdata();
	
	boolean saveCrudVisiteurferme(Visiteurferme visiteurferme);
	
	Visiteurferme createVisiteurfermeCrud(Visiteurferme visiteurferme, String visiteurferme_nom, Long visiteurferme_valeur,Date visiteurferme_date, String code_fkt);
	
	public void deleteVisiteurferme(Long id);

}
