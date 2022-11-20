package mg.giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import mg.giz.data.domain.Fermepilote;

public interface FermePiloteService {
	public List<Fermepilote> createFermepilote(String[][] ExcelToArray, Map<String, Integer> FermePiloteMapping,
			String theme) throws ParseException;

	public List<Fermepilote> addCodePersonne(List<Long> codePersonne, List<Fermepilote> fermepilote);

	public void addFermepilote(List<Fermepilote> fermepilote);

	public void deleteFermepiloteDudplicated();
	
	public List<Fermepilote> listFermepilote();
	
	boolean saveCrudFermepilote(Fermepilote fermepilote);
	
	Fermepilote createFermepiloteCrud(Fermepilote fermepilote, Long personne_id, String fermepilote_lib, Date fermepilote_date);

}
