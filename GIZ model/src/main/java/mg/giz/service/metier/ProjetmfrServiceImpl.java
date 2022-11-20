package mg.giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.giz.data.constants.code.SousComposanteCode;
import mg.giz.data.domain.Otiv;
import mg.giz.data.domain.Personne;
import mg.giz.data.domain.Projetmfr;
import mg.giz.data.domain.Souscomposante;
import mg.giz.data.domain.Theme;
import mg.giz.repository.ProjetmfrRepository;

@Service
public class ProjetmfrServiceImpl implements ProjetmfrService {
	@Autowired
	private ThemeService themeService;

	@Autowired
	private ProjetmfrRepository projetmfrRepository;

	@Override
	public List<Projetmfr> createProjetmfr(String[][] ExcelToArray, Map<String, Integer> projetmfrMapping, String theme)
			throws ParseException {
		int indice = -1;
		List<Projetmfr> projetmfrs = new ArrayList<>();
		String souscomposante = SousComposanteCode.sousComposanteCode(theme);
		Long themeId = themeService.findThemeId(theme);

		for (int i = 1; i < ExcelToArray.length; i++) {
			Projetmfr projetmfr = new Projetmfr();
			Souscomposante sc = new Souscomposante(souscomposante);
			projetmfr.setSouscomposante(sc);
			Theme th = new Theme(themeId);
			projetmfr.setTheme(th);

			if (projetmfrMapping.containsKey("projetmfr_date")) {
				indice = projetmfrMapping.get("projetmfr_date");
				String dateString = ExcelToArray[i][indice];
				Date date = Date.valueOf(dateString);
				projetmfr.setProjetmfr_date(date);
			}

			if (projetmfrMapping.containsKey("projetmfr_promotion")) {
				indice = projetmfrMapping.get("projetmfr_promotion");
				projetmfr.setProjetmfr_promotion(ExcelToArray[i][indice]);
			}

			if (projetmfrMapping.containsKey("projetmfr_realisees")) {
				indice = projetmfrMapping.get("projetmfr_realisees");
				projetmfr.setProjetmfr_realisees(ExcelToArray[i][indice]);
			}

			if (projetmfrMapping.containsKey("projetmfr_remarque")) {
				indice = projetmfrMapping.get("projetmfr_remarque");
				projetmfr.setProjetmfr_remarque(ExcelToArray[i][indice]);
			}

			if (projetmfrMapping.containsKey("projetmfr_validees")) {
				indice = projetmfrMapping.get("projetmfr_validees");
				projetmfr.setProjetmfr_validees(ExcelToArray[i][indice]);
			}
			projetmfrs.add(projetmfr);
		}
		return projetmfrs;
	}

	@Override
	public void addProjetmfr(List<Projetmfr> projetmfrs) {
		projetmfrRepository.saveAll(projetmfrs);
	}

	@Override
	public void deleteProjetmfrDuplicated() {
		projetmfrRepository.deleteProjetMfrDuplicated();

	}

	@Override
	public List<Projetmfr> addIdPersonneOtiv(List<Long> codePersonne, List<Integer> codeOtiv,
			List<Projetmfr> projetmfr) {
		for (int i = 0; i < projetmfr.size(); i++) {
			if (codeOtiv.get(i) != null) {
				Otiv o = new Otiv(codeOtiv.get(i));
				projetmfr.get(i).setOtiv(o);
			}
			Personne p = new Personne(codePersonne.get(i));
			projetmfr.get(i).setPersonne(p);
		}
		return projetmfr;
	}

	@Override
	public boolean saveCrudProjetmfr(Projetmfr projetmfr) {
		int countBeforeSave = projetmfrRepository.CountProjetmfr();
		projetmfrRepository.save(projetmfr);
		projetmfrRepository.deleteProjetMfrDuplicated();
		int countAfterSave = projetmfrRepository.CountProjetmfr();
		if (countBeforeSave == countAfterSave) {
			return true;
		}
		return false;
	}

	@Override
	public Projetmfr createProjetmrfCrud215(Projetmfr projetmfr, Long personne_id, int otiv_id, Date projetmfr_date, String projetmfr_promotion,
			String projetmfr_realisees, String projetmfr_validees, String projetmfr_remarque) {
		projetmfr.setProjetmfr_date(projetmfr_date);
		projetmfr.setProjetmfr_promotion(projetmfr_promotion);
		projetmfr.setProjetmfr_realisees(projetmfr_realisees);
		projetmfr.setProjetmfr_validees(projetmfr_validees);
		projetmfr.setProjetmfr_remarque(projetmfr_remarque);
		
		if (personne_id > 0) {
			Personne pe = new Personne(personne_id);
			projetmfr.setPersonne(pe);
		}
		if (otiv_id > 0) {
			Otiv ot = new Otiv(otiv_id);
			projetmfr.setOtiv(ot);
		}
		
		return projetmfr;
	}

	@Override
	public List<Projetmfr> listProjetmfr() {
		return projetmfrRepository.listProjetmfr();
	}

}
