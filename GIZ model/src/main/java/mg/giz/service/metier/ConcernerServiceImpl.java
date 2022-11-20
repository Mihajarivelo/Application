package mg.giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.giz.contrainte.factory.mappage.ConcernerMappage;
import mg.giz.data.constants.ColumnStructure;
import mg.giz.data.domain.Concerner;
import mg.giz.data.domain.Ecoleepp;
import mg.giz.data.domain.Theme;
import mg.giz.repository.ConcernerRepository;

@Service
public class ConcernerServiceImpl implements ConcernerService {

	@Autowired
	private ThemeService themeService;
	
	@Autowired
	EcoleeppService ecoleeppService;
	
	@Autowired 
	ConcernerRepository concernerRepository;

	@Override
	public List<Concerner> createConcerner(String[][] ExcelToArray, Map<String, Integer> concernerMapping, String theme)
			throws ParseException {

		Long themeId = themeService.findThemeId(theme);

		List<Concerner> concerners = new ArrayList<>();
		int indice = -1;

		for (int i = 1; i < ExcelToArray.length; i++) {
			Concerner concerner = new Concerner();

			Theme th = new Theme(themeId);
			concerner.setTheme(th);

			if (concernerMapping.containsKey("concerner_typeecole")) {
				indice = concernerMapping.get("concerner_typeecole");
				concerner.setConcerner_typeecole(ExcelToArray[i][indice]);
			}

			if (concernerMapping.containsKey("concerner_date")) {
				indice = concernerMapping.get("concerner_date");
				String dateString = ExcelToArray[i][indice];
				Date date = Date.valueOf(dateString);
				concerner.setConcerner_date(date);
			}

			concerners.add(concerner);
		}

		return concerners;
	}
	
	@Override
	public List<Concerner> addCodeEpp(List<Long> codeEpp, List<Concerner> concerners) {
		for (int i = 0; i < concerners.size(); i++) {
			Ecoleepp epp = new Ecoleepp(codeEpp.get(i));
			concerners.get(i).setEcoleepp(epp);
		}
		return concerners;
	}
	
	@Override
	public void addConcerner(ArrayList<ColumnStructure> columnStructure, String[][] ExcelToArray, String theme,
			List<Ecoleepp> ecoleepps) throws ParseException {
		Map<String, Integer> concernerMapping = ConcernerMappage.tableConcernerMappage(columnStructure);
		List<Concerner> concerners = createConcerner(ExcelToArray, concernerMapping, theme);
		List<Long> IdEcoleepp = ecoleeppService.findIdEcoleepp(ecoleepps);
		System.out.println(IdEcoleepp);
		List<Concerner> eppConcerners = addCodeEpp(IdEcoleepp, concerners);
		concernerRepository.saveAll(eppConcerners);
		concernerRepository.deleteConcernerDuplicated();

	}

	@Override
	public List<Concerner> listConcerner(ArrayList<ColumnStructure> columnStructure, String[][] ExcelToArray,
			String theme) throws ParseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveCrudConcerner(Concerner concerner) {
		int countBeforeSave = concernerRepository.CountConcerner();
		concernerRepository.save(concerner);
		concernerRepository.deleteConcernerDuplicated();
		int countAfterSave = concernerRepository.CountConcerner();
		if (countBeforeSave == countAfterSave) {
			return true;
		}
		return false;
	}

	@Override
	public Concerner createConcernerCrudEducEnv(Concerner concerner, Long ecoleepp_id, String concerner_typeecole, Date concerner_date) {
		concerner.setConcerner_typeecole(concerner_typeecole);
		concerner.setConcerner_date(concerner_date);
		
		if (ecoleepp_id > 0) {
			Ecoleepp ec = new Ecoleepp(ecoleepp_id);
			concerner.setEcoleepp(ec);
		}
		return concerner;
	}

	@Override
	public List<Concerner> joinConcernerEcoleepp() {
		return concernerRepository.joinConcernerEcoleepp();
	}
}
