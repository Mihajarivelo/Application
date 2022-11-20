package mg.giz.service.metier;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mg.giz.data.constants.ColumnStructure;
import mg.giz.data.domain.Parentmfr;

public interface ParentmfrService {

	List<Parentmfr> createParentmfr(String[][] ExcelToArray, Map<String, Integer> parentmfrMapping, String theme)
			throws ParseException;

	List<Parentmfr> listParentmfr(ArrayList<ColumnStructure> columnStructure, String[][] ExcelToArray, String theme)
			throws ParseException;

	void addParentmfr(List<Parentmfr> parentmfrs);

	List<Long> findParentmfr(List<Parentmfr> parentmfrs);
	
	boolean saveCrudParentmfr(Parentmfr parentmfr);
	
	Parentmfr createParentmfrCrud213(Parentmfr parentmfr, String parentmfr_nom, String parentmfr_fonction);
	
	public Long findParentmfr(String parentmfr_nom);
}
