package mg.giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.giz.contrainte.factory.mappage.VisiteurfermeMappage;
import mg.giz.data.constants.ColumnStructure;
import mg.giz.data.constants.code.SousComposanteCode;
import mg.giz.data.domain.Souscomposante;
import mg.giz.data.domain.Village;
import mg.giz.data.domain.Visiteurferme;
import mg.giz.repository.VisiteurfermeRepository;

@Service
public class VisiteurfermeServiceImpl implements VisiteurfermeService {
	
	@Autowired
	VisiteurfermeRepository visiteurfermeRepository;

	@Override
	public List<Visiteurferme> createVisiteurferme(String[][] ExcelToArray, Map<String, Integer> visiteurfermeMapping,
			String theme) throws ParseException {

		String souscomposante = SousComposanteCode.sousComposanteCode(theme);

		List<Visiteurferme> visiteurfermes = new ArrayList<>();
		int indice = -1;

		for (int i = 1; i < ExcelToArray.length; i++) {
			Visiteurferme visiteurferme = new Visiteurferme();

			Souscomposante sc = new Souscomposante(souscomposante);
			visiteurferme.setSouscomposante(sc);

			if (visiteurfermeMapping.containsKey("visiteurferme_nom")) {
				indice = visiteurfermeMapping.get("visiteurferme_nom");
				visiteurferme.setVisiteurferme_nom(ExcelToArray[i][indice].replace("\n", "").replace("\r", "").trim().toUpperCase());
			}

			if (visiteurfermeMapping.containsKey("visiteurferme_valeur")) {
				indice = visiteurfermeMapping.get("visiteurferme_valeur");
				double doubleValue = Double.valueOf(ExcelToArray[i][indice]);
				visiteurferme.setVisiteurferme_valeur((long) doubleValue);
			}

			if (visiteurfermeMapping.containsKey("visiteurferme_date")) {
				indice = visiteurfermeMapping.get("visiteurferme_date");
				String dateString = ExcelToArray[i][indice];
				Date date = Date.valueOf(dateString);
				visiteurferme.setVisiteurferme_date(date);
			}

			if (visiteurfermeMapping.containsKey("code_fkt")) {
				indice = visiteurfermeMapping.get("code_fkt");
				if (ExcelToArray[i][indice] != null) {
					Village vl = new Village(ExcelToArray[i][indice].replaceAll("\\s", "").toUpperCase());
					visiteurferme.setVillage(vl);
					visiteurferme.setCode_fkt(ExcelToArray[i][indice].replaceAll("\\s", "").toUpperCase());
				}
			}

			visiteurfermes.add(visiteurferme);
		}

		return visiteurfermes;
	}
	
	@Override
	public void addVisiteur(ArrayList<ColumnStructure> columnStructure, String[][] ExcelToArray,
			String theme) throws ParseException {
		Map<String, Integer> visiteurfermeMapping = VisiteurfermeMappage.tableVisiteurfermeMappage(columnStructure);
		List<Visiteurferme> visiteurfermes = createVisiteurferme(ExcelToArray, visiteurfermeMapping, theme);
		visiteurfermeRepository.saveAll(visiteurfermes);
		visiteurfermeRepository.deleteVisiteurDuplicated();
	}

	@Override
	public List<Visiteurferme> listfetchdata() {
		return visiteurfermeRepository.fetchVisiteurfermeData();
	}

	@Override
	public boolean saveCrudVisiteurferme(Visiteurferme visiteurferme) {
		int countBeforeSave = visiteurfermeRepository.CountVisiteurferme();
		visiteurfermeRepository.save(visiteurferme);
		visiteurfermeRepository.deleteVisiteurDuplicated();
		int countAfterSave = visiteurfermeRepository.CountVisiteurferme();
		if (countBeforeSave == countAfterSave) {
			return true;
		}
		return false;
	}

	@Override
	public Visiteurferme createVisiteurfermeCrud(Visiteurferme visiteurferme, String visiteurferme_nom,
			Long visiteurferme_valeur, Date visiteurferme_date, String code_fkt) {
			visiteurferme.setVisiteurferme_nom(visiteurferme_nom);
			visiteurferme.setVisiteurferme_valeur(visiteurferme_valeur);
			visiteurferme.setVisiteurferme_date(visiteurferme_date);
			if (code_fkt != "") {
				Village vl = new Village(code_fkt);
				visiteurferme.setVillage(vl);
			}
			
			return visiteurferme;
	}

	@Override
	public void deleteVisiteurferme(Long id) {
		visiteurfermeRepository.deleteVisiteurfermeQuery(id);
		
	}

}
