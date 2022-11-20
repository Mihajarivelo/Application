package mg.giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mg.giz.data.constants.ColumnStructure;
import mg.giz.data.domain.Ecoleepp;
import mg.giz.data.domain.Enseignantepp;

public interface EnseignanteppService {

	List<Enseignantepp> createEnseignantepp(String[][] ExcelToArray, Map<String, Integer> enseignanteppMapping,
			String theme) throws ParseException;
	
	List<Enseignantepp> addEnseignantepp(ArrayList<ColumnStructure> columnStructure, String[][] ExcelToArray, String theme,
			List<Ecoleepp> ecoleepps) throws ParseException;
	
	List<Enseignantepp> addCodeEpp(List<Long> codeEpp, List<Enseignantepp> enseignantepp);
	
	public List<Enseignantepp> findEnseignantepp ();
	
	boolean saveCrudEnseignantepp(Enseignantepp enseignantepp);
	
	Enseignantepp createEnseignanteppCrudEducEnv(Enseignantepp enseignantepp, Long ecoleepp_id, String enseignantepp_nom, String enseignantepp_genre, String enseignantepp_fonction, String enseignantepp_classe, Date enseignantepp_date);
	
	List<Enseignantepp> listEnseignantepp(ArrayList<ColumnStructure> columnStructure, String[][] ExcelToArray,
			String theme) throws ParseException;

	List<Long> findEnseignantepp(List<Enseignantepp> enseignantepps);
	
	Enseignantepp createEnseignanteppCrudKitemadere(Enseignantepp enseignantepp, Long ecoleepp_id, String enseignantepp_nom, String enseignantepp_genre, String enseignantepp_fonction, String enseignantepp_classe);
	
	public Long listEnseignantepp(String enseignantepp_nom);
}
