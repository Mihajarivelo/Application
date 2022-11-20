package mg.giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.giz.contrainte.factory.mappage.SubvenireppMappage;
import mg.giz.data.constants.ColumnStructure;
import mg.giz.data.domain.Ecoleepp;
import mg.giz.data.domain.Subvenirepp;
import mg.giz.repository.SubvenireppRepository;

@Service
public class SubvenireppServiceImpl implements SubvenireppService {
	
	@Autowired
	EcoleeppService ecoleeppService; 
	
	@Autowired
	SubvenireppRepository subvenireppRepository;
	
	@Override
	public List<Subvenirepp> createSubvenirepp(String[][] ExcelToArray, Map<String, Integer> subvenireppMapping,
			String theme) throws ParseException {

		int indice = -1;
		List<Subvenirepp> subvenirepps = new ArrayList<>();

		for (int i = 1; i < ExcelToArray.length; i++) {
			Subvenirepp subvenirepp = new Subvenirepp();

			if (subvenireppMapping.containsKey("subvenirepp_date")) {
				indice = subvenireppMapping.get("subvenirepp_date");
				String dateString = ExcelToArray[i][indice];
				Date date = Date.valueOf(dateString);
				subvenirepp.setSubvenirepp_date(date);
			}

			if (subvenireppMapping.containsKey("subvenirepp_fourniture")) {
				indice = subvenireppMapping.get("subvenirepp_fourniture");
				double doubleValue = Double.valueOf(ExcelToArray[i][indice]);
				subvenirepp.setSubvenirepp_fourniture(doubleValue);
			}

			if (subvenireppMapping.containsKey("subvenirepp_salaire")) {
				indice = subvenireppMapping.get("subvenirepp_salaire");
				double doubleValue = Double.valueOf(ExcelToArray[i][indice]);
				subvenirepp.setSubvenirepp_salaire(doubleValue);
			}

			if (subvenireppMapping.containsKey("subvenirepp_rehabilitation")) {
				indice = subvenireppMapping.get("subvenirepp_rehabilitation");
				double doubleValue = Double.valueOf(ExcelToArray[i][indice]);
				subvenirepp.setSubvenirepp_rehabilitaion(doubleValue);
			}

			if (subvenireppMapping.containsKey("subvenirepp_ansco")) {
				indice = subvenireppMapping.get("subvenirepp_ansco");
				subvenirepp.setSubvenirepp_ansco(ExcelToArray[i][indice]);
			}

			subvenirepps.add(subvenirepp);
		}

		return subvenirepps;
	}
	
	
	@Override
	public List<Subvenirepp> addCodeEpp(List<Long> codeEpp, List<Subvenirepp> subvenirepp) {
		for (int i = 0; i < subvenirepp.size(); i++) {
			Ecoleepp epp = new Ecoleepp(codeEpp.get(i));
			subvenirepp.get(i).setEcoleepp(epp);
		}
		return subvenirepp;
	}
	
	@Override
	public void addSubvenirepp(ArrayList<ColumnStructure> columnStructure, String[][] ExcelToArray, String theme, List<Ecoleepp> ecoleepps)
			throws ParseException {
		Map<String, Integer> subvenireppMapping = SubvenireppMappage.tableSubvenireppMappage(columnStructure);
		List<Subvenirepp> subvenirepp = createSubvenirepp(ExcelToArray, subvenireppMapping, theme);
		List<Long> IdEcoleepp  = ecoleeppService.findIdEcoleepp(ecoleepps);
		List<Subvenirepp> EppSubvontionnés = addCodeEpp(IdEcoleepp, subvenirepp);
		subvenireppRepository.saveAll(EppSubvontionnés);
		subvenireppRepository.deleteSubvenireppDudplicated();
	}


	@Override
	public List<Subvenirepp> List221() {
		return subvenireppRepository.fetchSubvenireppData();
	}


	@Override
	public boolean saveCrudSubvenirepp(Subvenirepp subvenirepp) {
		int countBeforeSave = subvenireppRepository.CountSubvenirepp();
		subvenireppRepository.save(subvenirepp);
		subvenireppRepository.deleteSubvenireppDudplicated();
		int countAfterSave = subvenireppRepository.CountSubvenirepp();
		if (countBeforeSave == countAfterSave) {
			return true;
		}
		return false;
	}


	@Override
	public Subvenirepp createSubvenireppCrud(Subvenirepp subvenirepp, Double subvenirepp_rehabilitaion,
			Double subvenirepp_salaire, Double subvenirepp_fourniture, String subvenirepp_ansco, Date subvenirepp_date,
			Long ecoleepp_id) {
		subvenirepp.setSubvenirepp_ansco(subvenirepp_ansco);
		subvenirepp.setSubvenirepp_date(subvenirepp_date);
		subvenirepp.setSubvenirepp_fourniture(subvenirepp_fourniture);
		subvenirepp.setSubvenirepp_rehabilitaion(subvenirepp_rehabilitaion);
		subvenirepp.setSubvenirepp_salaire(subvenirepp_salaire);

		if (ecoleepp_id > 0) {
			Ecoleepp ec = new Ecoleepp(ecoleepp_id);
			subvenirepp.setEcoleepp(ec);
		}
		return subvenirepp;
	}


	@Override
	public void deleteSubvenirepp(Long id) {
		subvenireppRepository.deleteSubvenireppQuery(id);
		
	}

}
