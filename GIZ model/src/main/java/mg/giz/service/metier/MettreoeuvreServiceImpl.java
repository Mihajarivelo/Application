package mg.giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.giz.contrainte.factory.mappage.MettreoeuvreMappage;
import mg.giz.data.constants.ColumnStructure;
import mg.giz.data.domain.Groupementprod;
import mg.giz.data.domain.Mettreoeuvre;
import mg.giz.data.domain.Serviceprojet;
import mg.giz.repository.MettreoeuvreRepository;

@Service
public class MettreoeuvreServiceImpl implements MettreoeuvreService {
	@Autowired
	ServiceprojetService serviceprojetService;

	@Autowired
	GroupementprodService groupementprodService;

	@Autowired
	MettreoeuvreRepository mettreoeuvreRepository;

	@Override
	public List<Mettreoeuvre> createMettreoeuvre(String[][] ExcelToArray, Map<String, Integer> mettreoeuvreMapping)
			throws ParseException {
		int indice = -1;
		List<Mettreoeuvre> mettreoeuvres = new ArrayList<>();

		for (int i = 1; i < ExcelToArray.length; i++) {
			Mettreoeuvre mettreoeuvre = new Mettreoeuvre();

			if (mettreoeuvreMapping.containsKey("mettreoeuvre_date")) {
				indice = mettreoeuvreMapping.get("mettreoeuvre_date");
				String dateString = ExcelToArray[i][indice];
				Date date = Date.valueOf(dateString);
				mettreoeuvre.setMettreoeuvre_date(date);
			}
			mettreoeuvres.add(mettreoeuvre);
		}
		return mettreoeuvres;
	}

	@Override
	public void addMettreoeuvre(ArrayList<ColumnStructure> columnStructure, String[][] ExcelToArray,
			List<Serviceprojet> serviceprojets, List<Groupementprod> groupementprods) throws ParseException {
		Map<String, Integer> mettreoeuvreMapping = MettreoeuvreMappage.tableMettreoeuvre(columnStructure);
		List<Mettreoeuvre> mettreoeuvres = createMettreoeuvre(ExcelToArray, mettreoeuvreMapping);
		List<Long> IdServiceprojet = serviceprojetService.findServiceprojet(serviceprojets);
		List<Long> IdGroupementprod = groupementprodService.findGroupement(groupementprods);
		
		for (int i = 0; i < mettreoeuvres.size(); i++) {
			Serviceprojet s = new Serviceprojet(IdServiceprojet.get(i));
			mettreoeuvres.get(i).setServiceprojet(s);
			Groupementprod g = new Groupementprod(IdGroupementprod.get(i));
			mettreoeuvres.get(i).setGroupementprod(g);
		}

		mettreoeuvreRepository.saveAll(mettreoeuvres);
		mettreoeuvreRepository.deleteMettreoeuvreDudplicated();
	}

}
