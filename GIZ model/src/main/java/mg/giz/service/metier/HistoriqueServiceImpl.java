package mg.giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.giz.data.constants.code.SousComposanteCode;
import mg.giz.data.constants.code.TypePersonneCode;
import mg.giz.data.domain.Historique;
import mg.giz.data.domain.Personne;
import mg.giz.data.domain.Souscomposante;
import mg.giz.data.domain.Typepersonne;
import mg.giz.repository.HistoriqueRepository;

@Service
public class HistoriqueServiceImpl implements HistoriqueService {

	@Autowired
	private HistoriqueRepository historiqueRepository;

	@Override
	public List<Historique> createHistorique(String[][] ExcelToArray, Map<String, Integer> HistoriqueMapping,
			String theme) throws ParseException {
		int indice = -1;
		List<Historique> historiques = new ArrayList<>();
		String souscomposante = SousComposanteCode.sousComposanteCode(theme);
		int typePersonne = TypePersonneCode.typePersonneCode(theme);

		for (int i = 1; i < ExcelToArray.length; i++) {
			Historique historique = new Historique();
			Souscomposante sc = new Souscomposante(souscomposante);
			historique.setSouscomposante(sc);

			Typepersonne tp = new Typepersonne(typePersonne);
			historique.setTypepersonne(tp);

			if (HistoriqueMapping.containsKey("historique_date")) {
				indice = HistoriqueMapping.get("historique_date");
				String dateString = ExcelToArray[i][indice];
				Date date = Date.valueOf(dateString);
				historique.setHistorique_date(date);
			}
			historiques.add(historique);
		}
		return historiques;
	}

	@Override
	public List<Historique> addCodePersonne(List<Long> codePersonne, List<Historique> historique) {
		for (int i = 0; i < historique.size(); i++) {
			Personne p = new Personne(codePersonne.get(i));
			historique.get(i).setPersonne(p);
		}
		return historique;
	}

	@Override
	public void addHistorique(List<Historique> historique) {
		historiqueRepository.saveAll(historique);
	}

	@Override
	public void deleteHistoriqueDudplicated() {
		historiqueRepository.deleteHistoriqueDudplicated();
	}

	@Override
	public Historique createHistoriqueCrud(Historique historique, Long personne_id, int typepersonne_id,
			Date historique_date) {
		
		if (personne_id > 0) {
			Personne pi = new Personne(personne_id);
			historique.setPersonne(pi);
		}
		if (typepersonne_id > 0) {
			Typepersonne tp = new Typepersonne(typepersonne_id);
			historique.setTypepersonne(tp);
		}
		
		historique.setHistorique_date(historique_date);
		return historique;
	}

	@Override
	public List<Historique> listHistorique(int id) {
		return historiqueRepository.fetchTypepersonneRessource(id);
	}

	@Override
	public boolean saveCrudHistorique(Historique historique) {
		int countBeforeSave = historiqueRepository.CountHistorique();
		historiqueRepository.save(historique);
		historiqueRepository.deleteHistoriqueDudplicated();
		int countAfterSave = historiqueRepository.CountHistorique();
		if (countBeforeSave == countAfterSave) {
			return true;
		}
		return false;
	}

	@Override
	public Historique createHistoriqueCrud140(Historique historique, Long personne_id, Date historique_date) {
		if (personne_id > 0) {
			Personne pi = new Personne(personne_id);
			historique.setPersonne(pi);
		}
		historique.setHistorique_date(historique_date);
		return historique;
	}

	@Override
	public List<Historique> findHistoriqueSmyrise() {
		return historiqueRepository.findHistoriqueSmyrise();
	}

}
