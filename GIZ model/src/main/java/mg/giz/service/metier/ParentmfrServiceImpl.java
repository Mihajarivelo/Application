package mg.giz.service.metier;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.giz.contrainte.factory.mappage.parentmfrMappage;
import mg.giz.data.constants.ColumnStructure;
import mg.giz.data.domain.Parentmfr;
import mg.giz.repository.ParentmfrRepository;

@Service
public class ParentmfrServiceImpl implements ParentmfrService {
	@Autowired
	ParentmfrRepository parentmfrRepository;

	@Override
	public List<Parentmfr> createParentmfr(String[][] ExcelToArray, Map<String, Integer> parentmfrMapping, String theme)
			throws ParseException {
		int indice = -1;
		List<Parentmfr> parentmfs = new ArrayList<>();

		for (int i = 1; i < ExcelToArray.length; i++) {
			Parentmfr parentmfr = new Parentmfr();
			if (parentmfrMapping.containsKey("parentmfr_nom")) {
				indice = parentmfrMapping.get("parentmfr_nom");
				parentmfr.setParentmfr_nom(ExcelToArray[i][indice].replace("\n", "").replace("\r", "").trim().toUpperCase());
			}

			if (parentmfrMapping.containsKey("parentmfr_fonction")) {
				indice = parentmfrMapping.get("parentmfr_fonction");
				parentmfr.setParentmfr_fonction(ExcelToArray[i][indice]);
			}
			parentmfs.add(parentmfr);
		}
		return parentmfs;
	}

	@Override
	public List<Parentmfr> listParentmfr(ArrayList<ColumnStructure> columnStructure, String[][] ExcelToArray,
			String theme) throws ParseException {
		Map<String, Integer> parentmfrMapping = parentmfrMappage.tableParentmfrMappage(columnStructure);
		List<Parentmfr> parentmfrs = createParentmfr(ExcelToArray, parentmfrMapping, theme);
		return parentmfrs;
	}

	@Override
	public void addParentmfr(List<Parentmfr> parentmfrs) {
		parentmfrRepository.saveAll(parentmfrs);
		parentmfrRepository.deleteParentmfrDuplicated();

	}

	@Override
	public List<Long> findParentmfr(List<Parentmfr> parentmfrs) {
		List<Long> IdParentmfr = new ArrayList<>();
		for (int i = 0; i < parentmfrs.size(); i++) {
			Long id;
			if ((parentmfrs.get(i).getParentmfr_nom() == null)) {
				id = null;
			} else {
				String nomParent = parentmfrs.get(i).getParentmfr_nom();
				System.out.println("ato");
				id = parentmfrRepository.findParentmfr(nomParent);
			}
			IdParentmfr.add(id);

		}
		return IdParentmfr;
	}

	@Override
	public boolean saveCrudParentmfr(Parentmfr parentmfr) {
		int countBeforeSave = parentmfrRepository.CountParentmfr();
		parentmfrRepository.save(parentmfr);
		parentmfrRepository.deleteParentmfrDuplicated();
		int countAfterSave = parentmfrRepository.CountParentmfr();
		if (countBeforeSave == countAfterSave) {
			return true;
		}
		return false;
	}

	@Override
	public Parentmfr createParentmfrCrud213(Parentmfr parentmfr, String parentmfr_nom, String parentmfr_fonction) {
		parentmfr.setParentmfr_nom(parentmfr_nom);
		parentmfr.setParentmfr_fonction(parentmfr_fonction);
		return parentmfr;
	}

	@Override
	public Long findParentmfr(String parentmfr_nom) {
		// TODO Auto-generated method stub
		return parentmfrRepository.findParentmfr(parentmfr_nom);
	}

}
