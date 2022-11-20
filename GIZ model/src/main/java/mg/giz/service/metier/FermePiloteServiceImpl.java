package mg.giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.giz.data.constants.code.SousComposanteCode;
import mg.giz.data.domain.Fermepilote;
import mg.giz.data.domain.Personne;
import mg.giz.data.domain.Souscomposante;
import mg.giz.repository.FermepiloteRepository;

@Service
public class FermePiloteServiceImpl implements FermePiloteService {

	@Autowired
	private FermepiloteRepository fermepiloteRepository;

	@Override
	public List<Fermepilote> createFermepilote(String[][] ExcelToArray, Map<String, Integer> FermePiloteMapping,
			String theme) throws ParseException {
		int indice = -1;
		List<Fermepilote> fermepilotes = new ArrayList<>();
		String souscomposante = SousComposanteCode.sousComposanteCode(theme);

		for (int i = 1; i < ExcelToArray.length; i++) {
			Fermepilote fermepilote = new Fermepilote();
			Souscomposante sc = new Souscomposante(souscomposante);
			fermepilote.setSouscomposante(sc);

			if (FermePiloteMapping.containsKey("fermepilote_date")) {
				indice = FermePiloteMapping.get("fermepilote_date");
				String dateString = ExcelToArray[i][indice];
				Date date = Date.valueOf(dateString);
				fermepilote.setFermepilote_date(date);
			}

			if (FermePiloteMapping.containsKey("fermepilote_lib")) {
				indice = FermePiloteMapping.get("fermepilote_lib");
				fermepilote.setFermepilote_lib(ExcelToArray[i][indice]);
			}
			fermepilotes.add(fermepilote);
		}
		return fermepilotes;
	}

	@Override
	public void addFermepilote(List<Fermepilote> fermepilote) {
		fermepiloteRepository.saveAll(fermepilote);
	}

	@Override
	public List<Fermepilote> addCodePersonne(List<Long> codePersonne, List<Fermepilote> fermepilote) {
		for (int i = 0; i < fermepilote.size(); i++) {
			Personne p = new Personne(codePersonne.get(i));
			fermepilote.get(i).setPersonne(p);
		}
		return fermepilote;
	}

	@Override
	public void deleteFermepiloteDudplicated() {
		fermepiloteRepository.deleteFermepiloteDudplicated();

	}

	@Override
	public List<Fermepilote> listFermepilote() {
		// TODO Auto-generated method stub
		return fermepiloteRepository.fetchFermepilote();
	}

	@Override
	public boolean saveCrudFermepilote(Fermepilote fermepilote) {
		int countBeforeSave = fermepiloteRepository.CountFermepilote();
		fermepiloteRepository.save(fermepilote);
		fermepiloteRepository.deleteFermepiloteDudplicated();
		int countAfterSave = fermepiloteRepository.CountFermepilote();
		if (countBeforeSave == countAfterSave) {
			return true;
		}
		return false;
	}

	@Override
	public Fermepilote createFermepiloteCrud(Fermepilote fermepilote, Long personne_id, String fermepilote_lib,
			Date fermepilote_date) {

		if (personne_id > 0) {
			Personne pi = new Personne(personne_id);
			fermepilote.setPersonne(pi);
		}
		fermepilote.setFermepilote_date(fermepilote_date);
		fermepilote.setFermepilote_lib(fermepilote_lib);
		return fermepilote;
	}
}
