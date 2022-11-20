package mg.giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import mg.giz.data.domain.Formateur;

public interface FormateurService {
	public List<Formateur> createFormateur(String[][] ExcelToArray, Map<String, Integer> FormateurMapping, String theme)
			throws ParseException;

	public void addFormateur(List<Formateur> formateurs);

	public void deleteFormateurDuplicated();

	Formateur createFormateurCrud(Formateur formateur, int typepersonne_id, String formateur_nom, String formateur_genre, Date formateur_date, String formateur_contact,
			String code_fkt, String formateur_observation);
	
	Formateur createFormateurCrudmodif(Formateur formateur, int typepersonne_id, String formateur_nom, String formateur_genre, Date formateur_date, String formateur_contact,
			String formateur_observation);
	
	boolean saveCrudFormateur(Formateur formateur);
	
	public List<Formateur> listFormateurFBS();
	
}
