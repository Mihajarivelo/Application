package mg.giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.giz.contrainte.factory.mappage.GroupementprodMappage;
import mg.giz.data.constants.ColumnStructure;
import mg.giz.data.constants.code.SousComposanteCode;
import mg.giz.data.domain.Groupementprod;
import mg.giz.data.domain.Souscomposante;
import mg.giz.data.domain.Village;
import mg.giz.repository.GroupementprodRepository;

@Service
public class GroupementprodServiceImpl implements GroupementprodService {
	@Autowired
	private GroupementprodRepository groupementprodRepository;

	@Override
	public List<Groupementprod> createGroupementprod(String[][] ExcelToArray,
			Map<String, Integer> groupementprodMapping, String theme) throws ParseException {
		int indice = -1;
		List<Groupementprod> groupementprods = new ArrayList<>();
		String souscomposante = SousComposanteCode.sousComposanteCode(theme);

		for (int i = 1; i < ExcelToArray.length; i++) {
			Groupementprod groupementprod = new Groupementprod();
			Souscomposante sc = new Souscomposante(souscomposante);
			groupementprod.setSouscomposante(sc);

			if (groupementprodMapping.containsKey("groupementprod_date")) {
				indice = groupementprodMapping.get("groupementprod_date");
				String dateString = ExcelToArray[i][indice];
				Date date = Date.valueOf(dateString);
				groupementprod.setGroupementprod_date(date);
			}

			if (groupementprodMapping.containsKey("groupementprod_nom")) {
				indice = groupementprodMapping.get("groupementprod_nom");
				groupementprod.setGroupementprod_nom(ExcelToArray[i][indice]);
			}
			
			if (groupementprodMapping.containsKey("groupementprod_service")) {
				indice = groupementprodMapping.get("groupementprod_service");
				groupementprod.setGroupementprod_service(ExcelToArray[i][indice]);
			}
			
			if (groupementprodMapping.containsKey("code_fkt")) {
				indice = groupementprodMapping.get("code_fkt");
				if (ExcelToArray[i][indice] != null) {
					Village vl = new Village(ExcelToArray[i][indice].replaceAll("\\s", "").toUpperCase());
					groupementprod.setVillage(vl);
					groupementprod.setCode_fkt(ExcelToArray[i][indice].replaceAll("\\s", "").toUpperCase());
				}
			}
			groupementprods.add(groupementprod);
		}
		return groupementprods;
	}

	@Override
	public void addGroupementprod(List<Groupementprod> groupementprods) {
		groupementprodRepository.saveAll(groupementprods);
	}

	@Override
	public void deleteGroupementprodDudplicated() {
		groupementprodRepository.deleteGroupementprodDudplicated();
	}

	@Override
	public String verifyGroupementprod(String groupementprod) {
		return groupementprodRepository.verifyGroupementprod(groupementprod);
	}

	@Override
	public List<Long> findGroupement(List<Groupementprod> groupementprods) {
		List<Long> IdGroupementprod = new ArrayList<>();

		for (int i = 0; i < groupementprods.size(); i++) {
			String nomGroupementprod = groupementprods.get(i).getGroupementprod_nom();
			Long id = groupementprodRepository.findIdGroupement(nomGroupementprod.toLowerCase());
			IdGroupementprod.add(id);
		}
		return IdGroupementprod;
	}

	@Override
	public List<Groupementprod> listGroupementprod(ArrayList<ColumnStructure> columnStructure, String[][] ExcelToArray,
			String theme) throws ParseException {
		Map<String, Integer> groupementprodMapping = GroupementprodMappage.tableGroupementprodMappage(columnStructure);
		List<Groupementprod> groupementprods = createGroupementprod(ExcelToArray, groupementprodMapping, theme);
		return groupementprods;
	}

	@Override
	public boolean saveGroupemenentprod(Groupementprod groupementprod) {
		int countBeforeSave = groupementprodRepository.CountGroupementprod();
		groupementprodRepository.save(groupementprod);
		groupementprodRepository.deleteGroupementprodDudplicated();
		int countAfterSave = groupementprodRepository.CountGroupementprod();
		if (countBeforeSave == countAfterSave) {
			return true;
		}
		return false;
	}

	@Override
	public Groupementprod createGroupementprodCrud(Groupementprod groupementprod, String groupementprod_nom,
			String code_fkt, Date groupementprod_date, String groupementprod_service) {
		groupementprod.setGroupementprod_nom(groupementprod_nom);
		groupementprod.setGroupementprod_date(groupementprod_date);
		groupementprod.setGroupementprod_service(groupementprod_service);
		
		if (code_fkt != "") {
			Village vl = new Village(code_fkt);
			groupementprod.setVillage(vl);
		}
		return groupementprod;
	}

	@Override
	public List<Groupementprod> listGroupementprod() {
		return groupementprodRepository.listGroupementprod();
	}

}
