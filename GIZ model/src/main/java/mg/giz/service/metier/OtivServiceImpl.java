package mg.giz.service.metier;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.giz.data.domain.Otiv;
import mg.giz.repository.OtivRepository;

@Service
public class OtivServiceImpl implements OtivService {
	@Autowired
	private OtivRepository otivRepository;

	@Override
	public List<Otiv> createOtiv(String[][] ExcelToArray, Map<String, Integer> OtivMapping, String theme)
			throws ParseException {
		int indice = -1;
		List<Otiv> otivs = new ArrayList<>();

		for (int i = 1; i < ExcelToArray.length; i++) {
			Otiv otiv = new Otiv();
			if (OtivMapping.containsKey("otiv_code")) {
				indice = OtivMapping.get("otiv_code");
				otiv.setOtiv_code(ExcelToArray[i][indice]);
			}
			otivs.add(otiv);
		}
		return otivs;
	}

	@Override
	public void addOtiv(List<Otiv> otivs) {
		otivRepository.saveAll(otivs);

	}

	@Override
	public void deleteOtivDuplicated() {
		otivRepository.deleteOtivDuplicated();

	}

	@Override
	public List<Integer> findOtiv(List<Otiv> otivs) {
		List<Integer> IdOtiv = new ArrayList<>();
		for (int i = 0; i < otivs.size(); i++) {
			Integer id;
			if (otivs.get(i).getOtiv_code() == null) {
				id = null;
			} else {
				String otiv_code = otivs.get(i).getOtiv_code();
				id = otivRepository.findOtiv(otiv_code);
			}
			IdOtiv.add(id);
		}
		return IdOtiv;
	}

	@Override
	public int selectOtiv(String otiv_code) {
		return otivRepository.selectOtiv(otiv_code);
	}

	@Override
	public boolean saveCrudOtiv(Otiv otiv) {
		int countBeforeSave = otivRepository.CountOtiv();
		otivRepository.save(otiv);
		otivRepository.deleteOtivDuplicated();
		int countAfterSave = otivRepository.CountOtiv();
		if (countBeforeSave == countAfterSave) {
			return true;
		}
		return false;
	}

	@Override
	public Otiv createOtivCrud(Otiv otiv, String otiv_code) {
		otiv.setOtiv_code(otiv_code);
		return otiv;
	}
}
