package mg.giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.giz.contrainte.factory.mappage.NombreeleveMappage;
import mg.giz.data.constants.ColumnStructure;
import mg.giz.data.domain.Ecoleepp;
import mg.giz.data.domain.Nombreeleve;
import mg.giz.repository.NombreeleveRepository;

@Service
public class NombreeleveServiceImpl implements NombreeleveService {
	
	@Autowired
	EcoleeppService ecoleeppService;
	
	@Autowired
	NombreeleveRepository nombreeleveRepository;

	@Override
	public List<Nombreeleve> createNombreeleve(String[][] ExcelToArray, Map<String, Integer> nombreeleveMapping,
			String theme) throws ParseException {

		List<Nombreeleve> nombreeleves = new ArrayList<>();
		int indice = -1;

		for (int i = 1; i < ExcelToArray.length; i++) {
			Nombreeleve nombreeleve = new Nombreeleve();

			if (nombreeleveMapping.containsKey("nombreeleve_date")) {
				indice = nombreeleveMapping.get("nombreeleve_date");
				String dateString = ExcelToArray[i][indice];
				Date date = Date.valueOf(dateString);
				nombreeleve.setNombreeleve_date(date);
			}

			if (nombreeleveMapping.containsKey("nombreeleve_fille")) {
				indice = nombreeleveMapping.get("nombreeleve_fille");
				double doubleValue = Double.valueOf(ExcelToArray[i][indice]);
				nombreeleve.setNombreeleve_fille((long) doubleValue);
			}

			if (nombreeleveMapping.containsKey("nombreeleve_garcon")) {
				indice = nombreeleveMapping.get("nombreeleve_garcon");
				double doubleValue = Double.valueOf(ExcelToArray[i][indice]);
				nombreeleve.setNombreeleve_garcon((long) doubleValue);
			}
			
			if (nombreeleveMapping.containsKey("nombreeleve_valeur")) {
				indice = nombreeleveMapping.get("nombreeleve_valeur");
				double doubleValue = Double.valueOf(ExcelToArray[i][indice]);
				nombreeleve.setNombreeleve_valeur((long) doubleValue);
			}

			nombreeleves.add(nombreeleve);
		}
		return nombreeleves;
	}

	@Override
	public void addNombreeleve(ArrayList<ColumnStructure> columnStructure, String[][] ExcelToArray, String theme, List<Ecoleepp> ecoleepps)
			throws ParseException {
		Map<String, Integer> NombreeleveMapping = NombreeleveMappage.tableNombreeleveMappage(columnStructure);
		List<Nombreeleve> nombreeleves = createNombreeleve(ExcelToArray, NombreeleveMapping, theme);
		List<Long> IdEcoleepp  = ecoleeppService.findIdEcoleepp(ecoleepps);
		List<Nombreeleve> nombreEleveEpp = addCodeEpp(IdEcoleepp, nombreeleves);
		nombreeleveRepository.saveAll(nombreEleveEpp);
		nombreeleveRepository.deleteNombreeleveDudplicated();
	}

	@Override
	public List<Nombreeleve> addCodeEpp(List<Long> codeEpp, List<Nombreeleve> nombreeleve) {
		for (int i = 0; i < nombreeleve.size(); i++) {
			Ecoleepp epp = new Ecoleepp(codeEpp.get(i));
			nombreeleve.get(i).setEcoleepp(epp);
		}
		return nombreeleve;
	}

	@Override
	public boolean saveCrudNombreeleve(Nombreeleve nombreeleve) {
		int countBeforeSave = nombreeleveRepository.CountNombreeleve();
		nombreeleveRepository.save(nombreeleve);
		nombreeleveRepository.deleteNombreeleveDudplicated();
		int countAfterSave = nombreeleveRepository.CountNombreeleve();
		if (countBeforeSave == countAfterSave) {
			return true;
		}
		return false;
	}

	@Override
	public Nombreeleve createNombreeleveCrud(Nombreeleve nombreeleve, Long ecoleepp_id, Long nombreeleve_garcon,
			Long nombreeleve_fille, Date nombreeleve_date) {
		nombreeleve.setNombreeleve_garcon(nombreeleve_garcon);
		nombreeleve.setNombreeleve_fille(nombreeleve_fille);
		nombreeleve.setNombreeleve_date(nombreeleve_date);
		
		if (ecoleepp_id > 0) {
			Ecoleepp ec = new Ecoleepp(ecoleepp_id);
			nombreeleve.setEcoleepp(ec);
		}
		
		return nombreeleve;
	}

	@Override
	public List<Nombreeleve> listNombreeleve() {
		return nombreeleveRepository.listNombreeleve();
	}

}
