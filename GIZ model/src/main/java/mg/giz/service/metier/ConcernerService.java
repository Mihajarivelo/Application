package mg.giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mg.giz.data.constants.ColumnStructure;
import mg.giz.data.domain.Concerner;
import mg.giz.data.domain.Ecoleepp;

public interface ConcernerService {

	List<Concerner> createConcerner(String[][] ExcelToArray, Map<String, Integer> concernerMapping, String theme)
			throws ParseException;

	List<Concerner> listConcerner(ArrayList<ColumnStructure> columnStructure, String[][] ExcelToArray, String theme)
			throws ParseException;

	List<Concerner> addCodeEpp(List<Long> codeEpp, List<Concerner> concerners);

	void addConcerner(ArrayList<ColumnStructure> columnStructure, String[][] ExcelToArray, String theme,
			List<Ecoleepp> ecoleepps) throws ParseException;
	
	boolean saveCrudConcerner(Concerner concerner);
	
	Concerner createConcernerCrudEducEnv(Concerner concerner, Long ecoleepp_id, String concerner_typeecole, Date concerner_date);
	
	public List<Concerner> joinConcernerEcoleepp();
}
