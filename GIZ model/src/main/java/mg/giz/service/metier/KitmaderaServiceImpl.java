package mg.giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.giz.contrainte.factory.mappage.KitmaderaMappage;
import mg.giz.data.constants.ColumnStructure;
import mg.giz.data.domain.Ecoleepp;
import mg.giz.data.domain.Enseignantepp;
import mg.giz.data.domain.Kitmadera;
import mg.giz.repository.KitmaderaRepository;

@Service
public class KitmaderaServiceImpl implements KitmaderaService {

	@Autowired
	EcoleeppService ecoleeppService;

	@Autowired
	KitmaderaRepository kitmaderaRepository;

	@Override
	public List<Kitmadera> createKitmadera(String[][] ExcelToArray, Map<String, Integer> kitmaderaMapping, String theme)
			throws ParseException {

		List<Kitmadera> Kitmaderas = new ArrayList<>();
		int indice = -1;

		for (int i = 1; i < ExcelToArray.length; i++) {
			Kitmadera Kitmadera = new Kitmadera();

			if (kitmaderaMapping.containsKey("enseignantepp_nom")) {
				indice = kitmaderaMapping.get("enseignantepp_nom");
				Kitmadera.setEnseignantepp_nom(
						ExcelToArray[i][indice].replace("\n", "").replace("\r", "").trim().toUpperCase());
			}

			if (kitmaderaMapping.containsKey("enseignantepp_genre")) {
				indice = kitmaderaMapping.get("enseignantepp_genre");
				Kitmadera.setEnseignantepp_genre(ExcelToArray[i][indice].toUpperCase());
			}

			if (kitmaderaMapping.containsKey("enseignantepp_fonction")) {
				indice = kitmaderaMapping.get("enseignantepp_fonction");
				Kitmadera.setEnseignantepp_fonction(ExcelToArray[i][indice]);
			}

			if (kitmaderaMapping.containsKey("kitmadere_date")) {
				indice = kitmaderaMapping.get("kitmadere_date");
				String dateString = ExcelToArray[i][indice];
				Date date = Date.valueOf(dateString);
				Kitmadera.setKitmadere_date(date);
			}

			if (kitmaderaMapping.containsKey("enseignantepp_classe")) {
				indice = kitmaderaMapping.get("enseignantepp_classe");
				Kitmadera.setEnseignantepp_classe(ExcelToArray[i][indice]);
			}

			if (kitmaderaMapping.containsKey("enseignantepp_adresse")) {
				indice = kitmaderaMapping.get("enseignantepp_adresse");
				Kitmadera.setEnseignantepp_adresse(ExcelToArray[i][indice]);
			}

			Kitmaderas.add(Kitmadera);
		}

		return Kitmaderas;
	}

	@Override
	public void addKitmadera(ArrayList<ColumnStructure> columnStructure, String[][] ExcelToArray, String theme,
			List<Ecoleepp> ecoleepps) throws ParseException {
		Map<String, Integer> KitmaderaMapping = KitmaderaMappage.tableKitmaderaMappage(columnStructure);
		List<Kitmadera> Kitmaderas = createKitmadera(ExcelToArray, KitmaderaMapping, theme);
		List<Long> IdEcoleepp = ecoleeppService.findIdEcoleepp(ecoleepps);
		List<Kitmadera> Enseignantkit = addCodeEpp(IdEcoleepp, Kitmaderas);
		kitmaderaRepository.saveAll(Enseignantkit);
		kitmaderaRepository.deleteEnseignantKitDudplicated();
	}

	@Override
	public List<Kitmadera> addCodeEpp(List<Long> codeEpp, List<Kitmadera> Kitmadera) {
		for (int i = 0; i < Kitmadera.size(); i++) {
			Ecoleepp epp = new Ecoleepp(codeEpp.get(i));
			Kitmadera.get(i).setEcoleepp(epp);
		}
		return Kitmadera;
	}

}
