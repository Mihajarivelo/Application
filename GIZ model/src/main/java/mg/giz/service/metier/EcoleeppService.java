package mg.giz.service.metier;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mg.giz.data.constants.ColumnStructure;
import mg.giz.data.domain.Ecoleepp;

public interface EcoleeppService {
	public List<Ecoleepp> createEcoleepp(String[][] ExcelToArray, Map<String, Integer> ecoleeppMapping, String theme)
			throws ParseException;
	
	List<Long> findIdEcoleepp(List<Ecoleepp> ecoleepps);

	void addEcoleepp(List<Ecoleepp> ecoleepps) throws ParseException;

	List<Ecoleepp> listEcoleepp(ArrayList<ColumnStructure> columnStructure, String[][] ExcelToArray, String theme)
			throws ParseException;
	
	public List<Ecoleepp> getAllEcoleepp();
	
	Long findIdEcoleepp(String ecoleepp_nom);
	
	String findNomEcoleepp();
	
	Long findEcoleepp(String ecoleepp_nom, String code_fkt);
	
	boolean saveCrudEcoleepp(Ecoleepp ecoleepp);
	
	public Long listEcoleepp(String ecoleepp_nom);
	
	Ecoleepp createEcoleeppCrudEducEnv(Ecoleepp ecoleepp, String ecoleepp_nom, String code_fkt);
}
