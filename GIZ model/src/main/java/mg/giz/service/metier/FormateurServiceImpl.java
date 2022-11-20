package mg.giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.giz.data.constants.code.SousComposanteCode;
import mg.giz.data.constants.code.TypePersonneCode;
import mg.giz.data.domain.Formateur;
import mg.giz.data.domain.Souscomposante;
import mg.giz.data.domain.Theme;
import mg.giz.data.domain.Typepersonne;
import mg.giz.data.domain.Village;
import mg.giz.repository.FormateurRepository;

@Service
public class FormateurServiceImpl implements FormateurService {
	@Autowired
	private FormateurRepository formateurRepository;

	@Autowired
	private ThemeService themeService;

	@Override
	public List<Formateur> createFormateur(String[][] ExcelToArray, Map<String, Integer> FormateurMapping, String theme)
			throws ParseException {
		String souscomposante = SousComposanteCode.sousComposanteCode(theme);
		Long themeId = themeService.findThemeId(theme);
		int typePersonne = TypePersonneCode.typePersonneCode(theme);

		List<Formateur> formateurs = new ArrayList<>();
		int indice = -1;

		for (int i = 1; i < ExcelToArray.length; i++) {
			Formateur formateur = new Formateur();

			Souscomposante sc = new Souscomposante(souscomposante);
			formateur.setSouscomposante(sc);

			Theme th = new Theme(themeId);
			formateur.setTheme(th);

			Typepersonne tp = new Typepersonne(typePersonne);
			formateur.setTypepersonne(tp);

			if (FormateurMapping.containsKey("formateur_contact")) {
				indice = FormateurMapping.get("formateur_contact");
				formateur.setFormateur_contact(ExcelToArray[i][indice]);
			}

			if (FormateurMapping.containsKey("formateur_date")) {
				indice = FormateurMapping.get("formateur_date");
				String dateString = ExcelToArray[i][indice];
				Date date = Date.valueOf(dateString);
				formateur.setFormateur_date(date);
			}

			if (FormateurMapping.containsKey("formateur_genre")) {
				indice = FormateurMapping.get("formateur_genre");
				formateur.setFormateur_genre(ExcelToArray[i][indice].toUpperCase().trim());
			}

			if (FormateurMapping.containsKey("formateur_nom")) {
				indice = FormateurMapping.get("formateur_nom");
				formateur.setFormateur_nom(ExcelToArray[i][indice].replace("\n", "").replace("\r", "").trim().toUpperCase());
			}

			if (FormateurMapping.containsKey("formateur_observation")) {
				indice = FormateurMapping.get("formateur_observation");
				formateur.setFormateur_observation(ExcelToArray[i][indice]);
			}
			
			if (FormateurMapping.containsKey("formateur_adresse")) {
				indice = FormateurMapping.get("formateur_adresse");
				formateur.setFormateur_adresse(ExcelToArray[i][indice]);
			}
			
			if (FormateurMapping.containsKey("formateur_fonction")) {
				indice = FormateurMapping.get("formateur_fonction");
				formateur.setFormateur_fonction(ExcelToArray[i][indice]);
			}

			if (FormateurMapping.containsKey("code_fkt")) {
				indice = FormateurMapping.get("code_fkt");
				if (ExcelToArray[i][indice] != null) {
					Village vl = new Village(ExcelToArray[i][indice].replaceAll("\\s", "").toUpperCase());
					formateur.setVillage(vl);
				}
			}

			formateurs.add(formateur);
		}

		return formateurs;
	}

	@Override
	public void addFormateur(List<Formateur> formateurs) {
		formateurRepository.saveAll(formateurs);
	}

	@Override
	public void deleteFormateurDuplicated() {
		formateurRepository.deleteFormateurDuplicated();
	}

	@Override
	public Formateur createFormateurCrud(Formateur formateur, int typepersonne_id, String formateur_nom, String formateur_genre, Date formateur_date, String formateur_contact,
			String code_fkt, String formateur_observation) {

		formateur.setFormateur_nom(formateur_nom);
		formateur.setFormateur_genre(formateur_genre);
		formateur.setFormateur_date(formateur_date);
		formateur.setFormateur_contact(formateur_contact);
		formateur.setFormateur_observation(formateur_observation);
		if (code_fkt != "") {
			Village vl = new Village(code_fkt);
			formateur.setVillage(vl);
		}
		if (typepersonne_id > 0) {
			Typepersonne tp = new Typepersonne(typepersonne_id);
			formateur.setTypepersonne(tp);
		}

		return formateur;
	}

	@Override
	public boolean saveCrudFormateur(Formateur formateur) {
		int countBeforeSave = formateurRepository.CountFormateur();
		formateurRepository.save(formateur);
		formateurRepository.deleteFormateurDuplicated();
		int countAfterSave = formateurRepository.CountFormateur();
		if (countBeforeSave == countAfterSave) {
			return true;
		}
		return false;
	}

	@Override
	public List<Formateur> listFormateurFBS() {
		return formateurRepository.listFormateurFBS();
	}

	@Override
	public Formateur createFormateurCrudmodif(Formateur formateur, int typepersonne_id, String formateur_nom,
			String formateur_genre, Date formateur_date, String formateur_contact, String formateur_observation) {
		formateur.setFormateur_nom(formateur_nom);
		formateur.setFormateur_genre(formateur_genre);
		formateur.setFormateur_date(formateur_date);
		formateur.setFormateur_contact(formateur_contact);
		formateur.setFormateur_observation(formateur_observation);
		
		if (typepersonne_id > 0) {
			Typepersonne tp = new Typepersonne(typepersonne_id);
			formateur.setTypepersonne(tp);
		}

		return formateur;
	}
}
