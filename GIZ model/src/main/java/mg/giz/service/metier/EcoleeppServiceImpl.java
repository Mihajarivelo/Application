package mg.giz.service.metier;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.giz.contrainte.factory.mappage.EcoleeppMappage;
import mg.giz.data.constants.ColumnStructure;
import mg.giz.data.constants.code.SousComposanteCode;
import mg.giz.data.domain.Ecoleepp;
import mg.giz.data.domain.Souscomposante;
import mg.giz.data.domain.Village;
import mg.giz.repository.EcoleeppRepository;

@Service
public class EcoleeppServiceImpl implements EcoleeppService {
	@Autowired
	EcoleeppRepository ecoleeppRepository;

	@Override
	public List<Ecoleepp> createEcoleepp(String[][] ExcelToArray, Map<String, Integer> ecoleeppMapping, String theme)
			throws ParseException {
		String souscomposante = SousComposanteCode.sousComposanteCode(theme);

		List<Ecoleepp> ecoleepps = new ArrayList<>();
		int indice = -1;

		for (int i = 1; i < ExcelToArray.length; i++) {
			Ecoleepp ecoleepp = new Ecoleepp();

			Souscomposante sc = new Souscomposante(souscomposante);
			ecoleepp.setSouscomposante(sc);

			if (ecoleeppMapping.containsKey("ecoleepp_nom")) {
				indice = ecoleeppMapping.get("ecoleepp_nom");
				ecoleepp.setEcoleepp_nom(ExcelToArray[i][indice].trim());
			}

			if (ecoleeppMapping.containsKey("code_fkt")) {
				indice = ecoleeppMapping.get("code_fkt");
				if (ExcelToArray[i][indice] != null) {
					Village vl = new Village(ExcelToArray[i][indice].replaceAll("\\s", "").toUpperCase());
					ecoleepp.setVillage(vl);
				}
			}

			ecoleepps.add(ecoleepp);
		}

		return ecoleepps;
	}

	@Override
	public List<Ecoleepp> listEcoleepp(ArrayList<ColumnStructure> columnStructure, String[][] ExcelToArray,
			String theme) throws ParseException {
		Map<String, Integer> EcoleeppMapping = EcoleeppMappage.tableEcoleeppMappage(columnStructure);
		List<Ecoleepp> ecoleepps = createEcoleepp(ExcelToArray, EcoleeppMapping, theme);
		return ecoleepps;

	}
	
	@Override
	public void addEcoleepp(List<Ecoleepp> ecoleepps) throws ParseException {
		ecoleeppRepository.saveAll(ecoleepps);
		ecoleeppRepository.deleteEcoleeppDudplicated();
	}

	@Override
	public List<Long> findIdEcoleepp(List<Ecoleepp> ecoleepps) {
		List<Long> IdEcoleepp = new ArrayList<>();

		for (int i = 0; i < ecoleepps.size(); i++) {
			String fkt = ecoleepps.get(i).getVillage().getCode_fkt();
			Long id = ecoleeppRepository.findEcoleepp(fkt);
			IdEcoleepp.add(id);
		}
		return IdEcoleepp;
	}

	@Override
	public Long findIdEcoleepp(String ecoleepp_nom) {
		return ecoleeppRepository.findIdEcoleepp(ecoleepp_nom);
	}

	@Override
	public String findNomEcoleepp() {
		return ecoleeppRepository.findNomEcoleepp();
	}

	@Override
	public boolean saveCrudEcoleepp(Ecoleepp ecoleepp) {
		int countBeforeSave = ecoleeppRepository.CountEcoleepp();
		ecoleeppRepository.save(ecoleepp);
		ecoleeppRepository.deleteEcoleeppDudplicated();
		int countAfterSave = ecoleeppRepository.CountEcoleepp();
		if (countBeforeSave == countAfterSave) {
			return true;
		}
		return false;
	}

	@Override
	public Long findEcoleepp(String ecoleepp_nom, String code_fkt) {
		return ecoleeppRepository.findEcoleepp(code_fkt);
	}

	@Override
	public List<Ecoleepp> getAllEcoleepp() {
		return (List<Ecoleepp>) ecoleeppRepository.findAll();
	}

	@Override
	public Long listEcoleepp(String ecoleepp_nom) {
		return ecoleeppRepository.selectEcoleepp(ecoleepp_nom);
	}

	@Override
	public Ecoleepp createEcoleeppCrudEducEnv(Ecoleepp ecoleepp, String ecoleepp_nom, String code_fkt) {
		ecoleepp.setEcoleepp_nom(ecoleepp_nom);
		if (code_fkt != "") {
			Village vl = new Village(code_fkt);
			ecoleepp.setVillage(vl);
		}
		return ecoleepp;
	}
}
