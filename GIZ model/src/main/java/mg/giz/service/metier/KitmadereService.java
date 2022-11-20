package mg.giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mg.giz.data.constants.ColumnStructure;
import mg.giz.data.domain.Enseignantepp;
import mg.giz.data.domain.Kitmadere;

public interface KitmadereService {

	List<Kitmadere> createKitmadere(String[][] ExcelToArray, Map<String, Integer> kitmadereMapping, String theme)
			throws ParseException;

	List<Kitmadere> addCodeEnseignant(List<Long> codeEnseignant, List<Kitmadere> kitmaderes);

	void addKitmadere(ArrayList<ColumnStructure> columnStructure, String[][] ExcelToArray, String theme,
			List<Enseignantepp> enseignantepps) throws ParseException;
	
	boolean saveCrudKitmadere(Kitmadere kitmadere);
	
	Kitmadere createKitmadereCrud(Kitmadere kitmadere, Long enseignantepp_id, Date kitmadere_date);
	
	public List<Kitmadere> findKitmadere();
	
	public List<Kitmadere> joinKitEnsEcole();

}
