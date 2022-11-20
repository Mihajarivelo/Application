package mg.giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.giz.contrainte.factory.mappage.EnseignanteppMappage;
import mg.giz.data.constants.ColumnStructure;
import mg.giz.data.domain.Ecoleepp;
import mg.giz.data.domain.Enseignantepp;
import mg.giz.repository.EnseignanteppRepository;

@Service
public class EnseignanteppServiceImpl implements EnseignanteppService {
	
	@Autowired
	EcoleeppService ecoleeppService;
	
	@Autowired
	EnseignanteppRepository enseignanteppRepository;

	@Override
	public List<Enseignantepp> createEnseignantepp(String[][] ExcelToArray, Map<String, Integer> enseignanteppMapping,
			String theme) throws ParseException {

		List<Enseignantepp> enseignantepps = new ArrayList<>();
		int indice = -1;

		for (int i = 1; i < ExcelToArray.length; i++) {
			Enseignantepp enseignantepp = new Enseignantepp();

			if (enseignanteppMapping.containsKey("enseignantepp_nom")) {
				indice = enseignanteppMapping.get("enseignantepp_nom");
				enseignantepp.setEnseignantepp_nom(ExcelToArray[i][indice].replace("\n", "").replace("\r", "").trim().toUpperCase());
			}

			if (enseignanteppMapping.containsKey("enseignantepp_genre")) {
				indice = enseignanteppMapping.get("enseignantepp_genre");
				enseignantepp.setEnseignantepp_genre(ExcelToArray[i][indice].toUpperCase());
			}

			if (enseignanteppMapping.containsKey("enseignantepp_fonction")) {
				indice = enseignanteppMapping.get("enseignantepp_fonction");
				enseignantepp.setEnseignantepp_fonction(ExcelToArray[i][indice]);
			}

			if (enseignanteppMapping.containsKey("enseignantepp_date")) {
				indice = enseignanteppMapping.get("enseignantepp_date");
				String dateString = ExcelToArray[i][indice];
				Date date = Date.valueOf(dateString);
				enseignantepp.setEnseignantepp_date(date);
			}

			if (enseignanteppMapping.containsKey("enseignantepp_adresse")) {
				indice = enseignanteppMapping.get("enseignantepp_adresse");
				enseignantepp.setEnseignantepp_nom(ExcelToArray[i][indice]);
			}
			
			if (enseignanteppMapping.containsKey("enseignantepp_classe")) {
				indice = enseignanteppMapping.get("enseignantepp_classe");
				enseignantepp.setEnseignantepp_classe(ExcelToArray[i][indice]);
			}

			enseignantepps.add(enseignantepp);
		}

		return enseignantepps;
	}

	@Override
	public List<Enseignantepp> addEnseignantepp(ArrayList<ColumnStructure> columnStructure, String[][] ExcelToArray, String theme,
			List<Ecoleepp> ecoleepps) throws ParseException {
		Map<String, Integer> EnseignanteppMapping = EnseignanteppMappage.tableEnseignanteppMappage(columnStructure);
		List<Enseignantepp> enseignantepps = createEnseignantepp(ExcelToArray, EnseignanteppMapping, theme);
		List<Long> IdEcoleepp = ecoleeppService.findIdEcoleepp(ecoleepps);
		List<Enseignantepp> Enseignantepp = addCodeEpp(IdEcoleepp, enseignantepps);
		enseignanteppRepository.saveAll(Enseignantepp);
		enseignanteppRepository.deleteEnseignantDudplicated();
		return Enseignantepp;

	}

	@Override
	public List<Enseignantepp> addCodeEpp(List<Long> codeEpp, List<Enseignantepp> enseignantepp) {
		for (int i = 0; i < enseignantepp.size(); i++) {
			Ecoleepp epp = new Ecoleepp(codeEpp.get(i));
			enseignantepp.get(i).setEcoleepp(epp);
		}
		return enseignantepp;
	}
	
	@Override
	public List<Enseignantepp> listEnseignantepp(ArrayList<ColumnStructure> columnStructure, String[][] ExcelToArray,
			String theme) throws ParseException {
		Map<String, Integer> enseignanteppMapping = EnseignanteppMappage.tableEnseignanteppMappage(columnStructure);
		List<Enseignantepp> enseignantepps = createEnseignantepp(ExcelToArray, enseignanteppMapping, theme);
		return enseignantepps;
	}
	
	@Override
	public List<Enseignantepp> findEnseignantepp() {
		return enseignanteppRepository.findEnseigantepp();
	}

	@Override
	public boolean saveCrudEnseignantepp(Enseignantepp enseignantepp) {
		int countBeforeSave = enseignanteppRepository.CountEnseignantepp();
		enseignanteppRepository.save(enseignantepp);
		enseignanteppRepository.deleteEnseignantDudplicated();
		int countAfterSave = enseignanteppRepository.CountEnseignantepp();
		if (countBeforeSave == countAfterSave) {
			return true;
		}
		return false;
	}

	@Override
	public Enseignantepp createEnseignanteppCrudEducEnv(Enseignantepp enseignantepp, 
			Long ecoleepp_id, String enseignantepp_nom, String enseignantepp_genre, String enseignantepp_fonction,
			String enseignantepp_classe, Date enseignantepp_date) {
		enseignantepp.setEnseignantepp_nom(enseignantepp_nom);
		enseignantepp.setEnseignantepp_genre(enseignantepp_genre);
		enseignantepp.setEnseignantepp_fonction(enseignantepp_fonction);
		enseignantepp.setEnseignantepp_classe(enseignantepp_classe);
		enseignantepp.setEnseignantepp_date(enseignantepp_date);
		
		if (ecoleepp_id > 0) {
			Ecoleepp ep = new Ecoleepp(ecoleepp_id);
			enseignantepp.setEcoleepp(ep);
		}
		
		return enseignantepp;
	}
	
	@Override
	public List<Long> findEnseignantepp(List<Enseignantepp> enseignantepps) {
		List<Long> IdEnseignantepp = new ArrayList<>();

		for (int i = 0; i < enseignantepps.size(); i++) {
			Long ecoleepp_id = enseignantepps.get(i).getEcoleepp().getEcoleepp_id();
			String enseignantepp_nom = enseignantepps.get(i).getEnseignantepp_nom();
			String enseignantepp_genre = enseignantepps.get(i).getEnseignantepp_genre();
			Long id = enseignanteppRepository.findEnseignantepp(ecoleepp_id, enseignantepp_nom, enseignantepp_genre);
			IdEnseignantepp.add(id);
		}
		return IdEnseignantepp;
	}

	@Override
	public Enseignantepp createEnseignanteppCrudKitemadere(Enseignantepp enseignantepp, Long ecoleepp_id,
			String enseignantepp_nom, String enseignantepp_genre, String enseignantepp_fonction,
			String enseignantepp_classe) {
		enseignantepp.setEnseignantepp_nom(enseignantepp_nom);
		enseignantepp.setEnseignantepp_genre(enseignantepp_genre);
		enseignantepp.setEnseignantepp_fonction(enseignantepp_fonction);
		enseignantepp.setEnseignantepp_classe(enseignantepp_classe);
		
		if (ecoleepp_id > 0) {
			Ecoleepp ep = new Ecoleepp(ecoleepp_id);
			enseignantepp.setEcoleepp(ep);
		}
		
		return enseignantepp;
	}

	@Override
	public Long listEnseignantepp(String enseignantepp_nom) {
		return enseignanteppRepository.selectEnseignantepp(enseignantepp_nom);
	}

}
