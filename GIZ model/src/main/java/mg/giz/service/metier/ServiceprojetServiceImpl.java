package mg.giz.service.metier;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.giz.contrainte.factory.mappage.ServiceprojetMappage;
import mg.giz.data.constants.ColumnStructure;
import mg.giz.data.domain.Serviceprojet;
import mg.giz.repository.ServiceprojetRepository;

@Service
public class ServiceprojetServiceImpl implements ServiceprojetService {
	@Autowired
	ServiceprojetRepository serviceprojetRepository;

	@Override
	public List<Serviceprojet> createServiceprojet(String[][] ExcelToArray, Map<String, Integer> serviceprojetMapping)
			throws ParseException {
		int indice = -1;
		List<Serviceprojet> serviceprojets = new ArrayList<>();

		for (int i = 1; i < ExcelToArray.length; i++) {
			Serviceprojet serviceprojet = new Serviceprojet();

			if (serviceprojetMapping.containsKey("serviceprojet_nom")) {
				indice = serviceprojetMapping.get("serviceprojet_nom");
				serviceprojet.setServiceprojet_nom(ExcelToArray[i][indice]);
			}
			serviceprojets.add(serviceprojet);
		}
		return serviceprojets;
	}

	
	@Override
	public List<Long> findServiceprojet(List<Serviceprojet> serviceprojets) {
		List<Long> IdServiceprojet = new ArrayList<>();

		for (int i = 0; i < serviceprojets.size(); i++) {
			String nomServiceprojet = serviceprojets.get(i).getServiceprojet_nom();
			Long id = serviceprojetRepository.findIdGroupement(nomServiceprojet);
			IdServiceprojet.add(id);
		}
		return IdServiceprojet;
	}

	@Override
	public List<Serviceprojet> listServiceprojet(ArrayList<ColumnStructure> columnStructure, String[][] ExcelToArray)
			throws ParseException {
		Map<String, Integer> ServiceprojetMapping = ServiceprojetMappage.tableServiceprojet(columnStructure);
		List<Serviceprojet> serviceprojets = createServiceprojet(ExcelToArray, ServiceprojetMapping);
		return serviceprojets;
	}

	@Override
	public void addServiceprojet(List<Serviceprojet> serviceprojets) {
		serviceprojetRepository.saveAll(serviceprojets);
		serviceprojetRepository.deleteServiceprojetDuplicated();
	}

}
