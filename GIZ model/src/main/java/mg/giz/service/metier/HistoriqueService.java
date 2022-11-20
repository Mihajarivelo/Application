package mg.giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import mg.giz.data.domain.Historique;

public interface HistoriqueService {
	public List<Historique> createHistorique(String[][] ExcelToArray, Map<String, Integer> HistoriqueMapping,
			String theme) throws ParseException;

	boolean saveCrudHistorique(Historique historique);
	
	public List<Historique> addCodePersonne(List<Long> codePersonne, List<Historique> historique);

	public void addHistorique(List<Historique> historique);

	public void deleteHistoriqueDudplicated();
	
	public List<Historique> listHistorique(int id);
	
	Historique createHistoriqueCrud(Historique historique, Long personne_id, int typepersonne_id, Date historique_date);
	
	Historique createHistoriqueCrud140(Historique historique, Long personne_id, Date historique_date);
	
	public List<Historique> findHistoriqueSmyrise();
}
