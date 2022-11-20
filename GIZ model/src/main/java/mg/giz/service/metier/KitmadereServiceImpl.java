package mg.giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.giz.contrainte.factory.mappage.KitmadereMappage;
import mg.giz.data.constants.ColumnStructure;
import mg.giz.data.domain.Enseignantepp;
import mg.giz.data.domain.Kitmadere;
import mg.giz.repository.KitmadereRepository;

@Service
public class KitmadereServiceImpl implements KitmadereService {
	@Autowired
	EnseignanteppService enseignanteppService;

	@Autowired
	KitmadereRepository kitmadereRepository;

	@Override
	public List<Kitmadere> createKitmadere(String[][] ExcelToArray, Map<String, Integer> kitmadereMapping, String theme)
			throws ParseException {

		List<Kitmadere> kitmaderes = new ArrayList<>();
		int indice = -1;

		for (int i = 1; i < ExcelToArray.length; i++) {
			Kitmadere kitmadere = new Kitmadere();

			if (kitmadereMapping.containsKey("kitmadere_observation")) {
				indice = kitmadereMapping.get("kitmadere_observation");
				kitmadere.setKitmadere_observation(ExcelToArray[i][indice]);
			}

			if (kitmadereMapping.containsKey("kitmadere_date")) {
				indice = kitmadereMapping.get("kitmadere_date");
				String dateString = ExcelToArray[i][indice];
				Date date = Date.valueOf(dateString);
				kitmadere.setKitmadere_date(date);
			}

			kitmaderes.add(kitmadere);
		}

		return kitmaderes;
	}

	@Override
	public List<Kitmadere> addCodeEnseignant(List<Long> codeEnseignant, List<Kitmadere> kitmaderes) {
		for (int i = 0; i < kitmaderes.size(); i++) {
			Enseignantepp enseignant = new Enseignantepp(codeEnseignant.get(i));
			kitmaderes.get(i).setEnseignantepp(enseignant);
		}
		return kitmaderes;
	}

	@Override
	public void addKitmadere(ArrayList<ColumnStructure> columnStructure, String[][] ExcelToArray, String theme,
			List<Enseignantepp> enseignantepps) throws ParseException {
		Map<String, Integer> kitmadereMapping = KitmadereMappage.tableKitmadere(columnStructure);
		List<Kitmadere> kitmaderes = createKitmadere(ExcelToArray, kitmadereMapping, theme);
		List<Long> IdEnseignant = enseignanteppService.findEnseignantepp(enseignantepps);
		List<Kitmadere> EnseignanteppKit = addCodeEnseignant(IdEnseignant, kitmaderes);
		kitmadereRepository.saveAll(EnseignanteppKit);
		kitmadereRepository.deleteKitmadereDudplicated();

	}

	@Override
	public boolean saveCrudKitmadere(Kitmadere kitmadere) {
		int countBeforeSave = kitmadereRepository.CountKitmadere();
		kitmadereRepository.save(kitmadere);
		kitmadereRepository.deleteKitmadereDudplicated();
		int countAfterSave = kitmadereRepository.CountKitmadere();
		if (countBeforeSave == countAfterSave) {
			return true;
		}
		return false;
	}

	@Override
	public Kitmadere createKitmadereCrud(Kitmadere kitmadere, Long enseignantepp_id, Date kitmadere_date) {
		
		if (enseignantepp_id > 0) {
			Enseignantepp ens = new Enseignantepp(enseignantepp_id);
			kitmadere.setEnseignantepp(ens);
		}
		
		kitmadere.setKitmadere_date(kitmadere_date);		
		return kitmadere;
	}

	@Override
	public List<Kitmadere> findKitmadere() {
		return kitmadereRepository.findKitmadere();
	}

	@Override
	public List<Kitmadere> joinKitEnsEcole() {
		return kitmadereRepository.joinKitEnsEcole();
	}
}
