package mg.giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mg.giz.data.constants.ColumnStructure;
import mg.giz.data.domain.Menagessensibilise;

public interface MenagessensibiliseService {

	public List<Menagessensibilise> createMenagessensibilise(String[][] ExcelToArray,
			Map<String, Integer> MenagessensibilisesMappageMapping, String theme) throws ParseException;

	void addMenagessensibilise(ArrayList<ColumnStructure> columnStructure, String[][] ExcelToArray, String theme)
			throws ParseException;
	
	public List<Menagessensibilise> List331();
	
	Menagessensibilise createPersonCrud331(Menagessensibilise menagessensibilise, String code_fkt, Date menagessensibilise_date,
			String menagessensibilise_lib, int menagessensibilise_homme, int menagessensibilise_femme, int menagessensibilise_garcon,
			int menagessensibilise_fille);
	
	boolean saveCrudMenagessensibilise(Menagessensibilise menagessensibilise);

}
